package com.baidu.wallet.lightapp.base;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.lightapp.multipage.h;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public class LightappWebViewCenter implements NoProguard {
    public static final String TAG = "LightappWebViewCenter";

    /* renamed from: a  reason: collision with root package name */
    public LightappBrowserWebView f24689a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedBlockingQueue<LightappBrowserWebView> f24690b;

    /* renamed from: c  reason: collision with root package name */
    public MutableContextWrapper f24691c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24692d;

    /* renamed from: e  reason: collision with root package name */
    public Context f24693e;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static LightappWebViewCenter f24694a = new LightappWebViewCenter();
    }

    public static LightappWebViewCenter getInstance() {
        return a.f24694a;
    }

    public static boolean isLightappWebViewCenterOn(Context context) {
        return SdkInitResponse.getInstance().isLangbridgeSpeedUpEnable(context.getApplicationContext());
    }

    public LightappBrowserWebView getLightappWebView(Context context) {
        if (isLightappWebViewCenterOn(context) && !this.f24692d) {
            this.f24692d = true;
            return initLightappWebView(context);
        }
        return new LightappBrowserWebView(context);
    }

    public LightappBrowserWebView getLightappWebViewFromPool() {
        InterruptedException e2;
        LightappBrowserWebView lightappBrowserWebView;
        if (this.f24690b == null || this.f24693e == null || !h.a().a(this.f24693e).MW_ON || this.f24690b.size() <= 0) {
            return null;
        }
        try {
            lightappBrowserWebView = this.f24690b.take();
        } catch (InterruptedException e3) {
            e2 = e3;
            lightappBrowserWebView = null;
        }
        try {
            lightappBrowserWebView.onResume();
            lightappBrowserWebView.clearHistory();
        } catch (InterruptedException e4) {
            e2 = e4;
            e2.printStackTrace();
            return lightappBrowserWebView;
        }
        return lightappBrowserWebView;
    }

    public LightappBrowserWebView initLightappWebView(Context context) {
        if (this.f24689a == null) {
            this.f24691c = new MutableContextWrapper(context);
            this.f24689a = new LightappBrowserWebView(this.f24691c);
        } else {
            MutableContextWrapper mutableContextWrapper = this.f24691c;
            if (mutableContextWrapper != null) {
                mutableContextWrapper.setBaseContext(context);
                this.f24689a.clearHistory();
            }
        }
        return this.f24689a;
    }

    public void initLightappWebViewPool(@NonNull Activity activity) {
        if (activity != null && this.f24690b == null && h.a().a(activity).MW_ON) {
            PayStatisticsUtil.onEventStart("#eventInitWebviewPool");
            DXMSdkSAUtils.onEventStart("#eventInitWebviewPool");
            int i2 = h.a().a(activity).MW_WEBVIEW_POOL_SIZE;
            if (i2 <= 0) {
                return;
            }
            this.f24690b = new LinkedBlockingQueue<>(i2);
            this.f24693e = activity.getApplication();
            while (this.f24690b.remainingCapacity() > 0) {
                LightappBrowserWebView lightappBrowserWebView = new LightappBrowserWebView(activity);
                try {
                    lightappBrowserWebView.loadUrl("about:blank");
                    lightappBrowserWebView.setBaseContext(this.f24693e);
                    lightappBrowserWebView.onPause();
                    this.f24690b.put(lightappBrowserWebView);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            PayStatisticsUtil.onEventEnd("#eventInitWebviewPool", 0);
            DXMSdkSAUtils.onEventEnd("#eventInitWebviewPool", 0);
        }
    }

    public void initWebViewCore(Context context) {
        String userAgentString = new LightappBrowserWebView(context.getApplicationContext()).getSettings().getUserAgentString();
        if (userAgentString != null && !userAgentString.contains("BaiduWallet")) {
            userAgentString = userAgentString + " " + BussinessUtils.getUA(context.getApplicationContext());
        }
        if (TextUtils.isEmpty(userAgentString)) {
            return;
        }
        LangbridgeCacheManager.getInstance().setLangbridgeUA(userAgentString);
    }

    public boolean releaseLightappWebView(@NonNull Context context, LightappBrowserWebView lightappBrowserWebView) {
        if (this.f24689a == lightappBrowserWebView) {
            lightappBrowserWebView.removeAllViews();
            ViewGroup viewGroup = (ViewGroup) lightappBrowserWebView.getParent();
            if (viewGroup != null) {
                try {
                    viewGroup.removeView(lightappBrowserWebView);
                } catch (Throwable th) {
                    LogUtil.e(TAG, "release Exception", th);
                }
            }
            lightappBrowserWebView.loadUrl("about:blank");
            lightappBrowserWebView.clearHistory();
            lightappBrowserWebView.setWebViewClient(null);
            lightappBrowserWebView.setWebChromeClient(null);
            lightappBrowserWebView.setDownloadListener(null);
            lightappBrowserWebView.setOnTouchListener(null);
            lightappBrowserWebView.setOnMyScrollChangeListener(null);
            lightappBrowserWebView.removeJavascriptInterface(LightappJsClient.LIGHTAPP_JS_NAME);
            lightappBrowserWebView.setVisibility(0);
            MutableContextWrapper mutableContextWrapper = this.f24691c;
            if (mutableContextWrapper != null) {
                mutableContextWrapper.setBaseContext(context.getApplicationContext());
            }
            this.f24692d = false;
            return true;
        }
        return false;
    }

    public void releaseLightappWebView2Pool(LightappBrowserWebView lightappBrowserWebView) {
        if (lightappBrowserWebView != null) {
            if (this.f24690b != null && this.f24693e != null && h.a().a(this.f24693e).MW_ON && this.f24690b.remainingCapacity() > 0) {
                lightappBrowserWebView.onPause();
                lightappBrowserWebView.removeAllViews();
                ViewGroup viewGroup = (ViewGroup) lightappBrowserWebView.getParent();
                if (viewGroup != null) {
                    try {
                        viewGroup.removeView(lightappBrowserWebView);
                    } catch (Throwable th) {
                        LogUtil.e(TAG, "release Exception", th);
                    }
                }
                lightappBrowserWebView.loadUrl("about:blank");
                lightappBrowserWebView.setWebViewClient(null);
                lightappBrowserWebView.setWebChromeClient(null);
                lightappBrowserWebView.setDownloadListener(null);
                lightappBrowserWebView.setOnTouchListener(null);
                lightappBrowserWebView.setOnMyScrollChangeListener(null);
                lightappBrowserWebView.removeJavascriptInterface(LightappJsClient.LIGHTAPP_JS_NAME);
                lightappBrowserWebView.setVisibility(0);
                lightappBrowserWebView.setBaseContext(this.f24693e);
                lightappBrowserWebView.clearJsCode();
                lightappBrowserWebView.clearHistory();
                try {
                    this.f24690b.put(lightappBrowserWebView);
                    return;
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    lightappBrowserWebView.destroy();
                    return;
                }
            }
            lightappBrowserWebView.destroy();
        }
    }

    public LightappWebViewCenter() {
        this.f24690b = null;
        this.f24692d = false;
    }

    public LightappBrowserWebView getLightappWebViewFromPool(@NonNull Activity activity, boolean z) {
        LightappBrowserWebView lightappBrowserWebView;
        LightappBrowserWebView lightappBrowserWebView2 = null;
        if (this.f24693e == null || this.f24690b == null) {
            if (activity != null) {
                initLightappWebViewPool(activity);
            }
        } else if (h.a().a(this.f24693e).MW_ON && this.f24690b.size() > 0) {
            try {
                lightappBrowserWebView = this.f24690b.take();
                if (lightappBrowserWebView != null) {
                    try {
                        lightappBrowserWebView.setBaseContext(activity);
                        lightappBrowserWebView.onResume();
                        lightappBrowserWebView.clearHistory();
                    } catch (InterruptedException e2) {
                        e = e2;
                        lightappBrowserWebView2 = lightappBrowserWebView;
                        e.printStackTrace();
                        lightappBrowserWebView = lightappBrowserWebView2;
                        PayStatisticsUtil.onEventWithValue("#getWebviewPoolRetType", "0");
                        DXMSdkSAUtils.onEventWithValues("#getWebviewPoolRetType", Arrays.asList("0"));
                        return lightappBrowserWebView;
                    }
                }
            } catch (InterruptedException e3) {
                e = e3;
            }
            PayStatisticsUtil.onEventWithValue("#getWebviewPoolRetType", "0");
            DXMSdkSAUtils.onEventWithValues("#getWebviewPoolRetType", Arrays.asList("0"));
            return lightappBrowserWebView;
        }
        if (!z || activity == null) {
            return null;
        }
        PayStatisticsUtil.onEventWithValue("#getWebviewPoolRetType", "1");
        DXMSdkSAUtils.onEventWithValues("#getWebviewPoolRetType", Arrays.asList("1"));
        return new LightappBrowserWebView(activity);
    }
}
