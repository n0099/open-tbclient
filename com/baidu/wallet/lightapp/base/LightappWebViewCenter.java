package com.baidu.wallet.lightapp.base;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.lightapp.multipage.h;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public class LightappWebViewCenter implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LightappWebViewCenter";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LightappBrowserWebView f25232a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedBlockingQueue<LightappBrowserWebView> f25233b;

    /* renamed from: c  reason: collision with root package name */
    public MutableContextWrapper f25234c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25235d;

    /* renamed from: e  reason: collision with root package name */
    public Context f25236e;

    /* renamed from: com.baidu.wallet.lightapp.base.LightappWebViewCenter$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static LightappWebViewCenter f25237a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(169467997, "Lcom/baidu/wallet/lightapp/base/LightappWebViewCenter$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(169467997, "Lcom/baidu/wallet/lightapp/base/LightappWebViewCenter$a;");
                    return;
                }
            }
            f25237a = new LightappWebViewCenter(null);
        }
    }

    public /* synthetic */ LightappWebViewCenter(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static LightappWebViewCenter getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f25237a : (LightappWebViewCenter) invokeV.objValue;
    }

    public static boolean isLightappWebViewCenterOn(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? SdkInitResponse.getInstance().isLangbridgeSpeedUpEnable(context.getApplicationContext()) : invokeL.booleanValue;
    }

    public LightappBrowserWebView getLightappWebView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (isLightappWebViewCenterOn(context) && !this.f25235d) {
                this.f25235d = true;
                return initLightappWebView(context);
            }
            return new LightappBrowserWebView(context);
        }
        return (LightappBrowserWebView) invokeL.objValue;
    }

    public LightappBrowserWebView getLightappWebViewFromPool() {
        InterceptResult invokeV;
        InterruptedException e2;
        LightappBrowserWebView lightappBrowserWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f25233b == null || this.f25236e == null || !h.a().a(this.f25236e).MW_ON || this.f25233b.size() <= 0) {
                return null;
            }
            try {
                lightappBrowserWebView = this.f25233b.take();
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
        return (LightappBrowserWebView) invokeV.objValue;
    }

    public LightappBrowserWebView initLightappWebView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (this.f25232a == null) {
                this.f25234c = new MutableContextWrapper(context);
                this.f25232a = new LightappBrowserWebView(this.f25234c);
            } else {
                MutableContextWrapper mutableContextWrapper = this.f25234c;
                if (mutableContextWrapper != null) {
                    mutableContextWrapper.setBaseContext(context);
                    this.f25232a.clearHistory();
                }
            }
            return this.f25232a;
        }
        return (LightappBrowserWebView) invokeL.objValue;
    }

    public void initLightappWebViewPool(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, activity) == null) && activity != null && this.f25233b == null && h.a().a(activity).MW_ON) {
            PayStatisticsUtil.onEventStart("#eventInitWebviewPool");
            DXMSdkSAUtils.onEventStart("#eventInitWebviewPool");
            int i2 = h.a().a(activity).MW_WEBVIEW_POOL_SIZE;
            if (i2 <= 0) {
                return;
            }
            this.f25233b = new LinkedBlockingQueue<>(i2);
            this.f25236e = activity.getApplication();
            while (this.f25233b.remainingCapacity() > 0) {
                LightappBrowserWebView lightappBrowserWebView = new LightappBrowserWebView(activity);
                try {
                    lightappBrowserWebView.loadUrl("about:blank");
                    lightappBrowserWebView.setBaseContext(this.f25236e);
                    lightappBrowserWebView.onPause();
                    this.f25233b.put(lightappBrowserWebView);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            PayStatisticsUtil.onEventEnd("#eventInitWebviewPool", 0);
            DXMSdkSAUtils.onEventEnd("#eventInitWebviewPool", 0);
        }
    }

    public void initWebViewCore(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            String userAgentString = new LightappBrowserWebView(context.getApplicationContext()).getSettings().getUserAgentString();
            if (userAgentString != null && !userAgentString.contains("BaiduWallet")) {
                userAgentString = userAgentString + " " + BussinessUtils.getUA(context.getApplicationContext());
            }
            if (TextUtils.isEmpty(userAgentString)) {
                return;
            }
            LangbridgeCacheManager.getInstance().setLangbridgeUA(userAgentString);
        }
    }

    public boolean releaseLightappWebView(@NonNull Context context, LightappBrowserWebView lightappBrowserWebView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, lightappBrowserWebView)) == null) {
            if (this.f25232a == lightappBrowserWebView) {
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
                MutableContextWrapper mutableContextWrapper = this.f25234c;
                if (mutableContextWrapper != null) {
                    mutableContextWrapper.setBaseContext(context.getApplicationContext());
                }
                this.f25235d = false;
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void releaseLightappWebView2Pool(LightappBrowserWebView lightappBrowserWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, lightappBrowserWebView) == null) || lightappBrowserWebView == null) {
            return;
        }
        if (this.f25233b != null && this.f25236e != null && h.a().a(this.f25236e).MW_ON && this.f25233b.remainingCapacity() > 0) {
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
            lightappBrowserWebView.setBaseContext(this.f25236e);
            lightappBrowserWebView.clearJsCode();
            lightappBrowserWebView.clearHistory();
            try {
                this.f25233b.put(lightappBrowserWebView);
                return;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                lightappBrowserWebView.destroy();
                return;
            }
        }
        lightappBrowserWebView.destroy();
    }

    public LightappWebViewCenter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25233b = null;
        this.f25235d = false;
    }

    public LightappBrowserWebView getLightappWebViewFromPool(@NonNull Activity activity, boolean z) {
        InterceptResult invokeLZ;
        LightappBrowserWebView lightappBrowserWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, activity, z)) == null) {
            LightappBrowserWebView lightappBrowserWebView2 = null;
            if (this.f25236e == null || this.f25233b == null) {
                if (activity != null) {
                    initLightappWebViewPool(activity);
                }
            } else if (h.a().a(this.f25236e).MW_ON && this.f25233b.size() > 0) {
                try {
                    lightappBrowserWebView = this.f25233b.take();
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
        return (LightappBrowserWebView) invokeLZ.objValue;
    }
}
