package com.baidu.wallet.lightapp.base;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter;
import com.baidu.wallet.lightapp.multipage.LangbridgeSettings;
import com.baidu.wallet.lightapp.multipage.i;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes8.dex */
public class LightappWebViewCenter implements NoProguard, i.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LightappWebViewCenter";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f61726a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f61727b;

    /* renamed from: c  reason: collision with root package name */
    public LightappBrowserWebView f61728c;

    /* renamed from: d  reason: collision with root package name */
    public LinkedBlockingQueue<LightappBrowserWebView> f61729d;

    /* renamed from: e  reason: collision with root package name */
    public MutableContextWrapper f61730e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61731f;

    /* renamed from: g  reason: collision with root package name */
    public Context f61732g;

    /* renamed from: h  reason: collision with root package name */
    public int f61733h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f61734i;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static LightappWebViewCenter f61736a;
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
            f61736a = new LightappWebViewCenter();
        }
    }

    public static /* synthetic */ int b(LightappWebViewCenter lightappWebViewCenter) {
        int i2 = lightappWebViewCenter.f61733h;
        lightappWebViewCenter.f61733h = i2 - 1;
        return i2;
    }

    public static LightappWebViewCenter getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? a.f61736a : (LightappWebViewCenter) invokeV.objValue;
    }

    public static boolean isLightappWebViewCenterOn(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? SdkInitResponse.getInstance().isLangbridgeSpeedUpEnable(DxmApplicationContextImpl.getApplicationContext(context)) : invokeL.booleanValue;
    }

    public LightappBrowserWebView getLightappWebView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (isLightappWebViewCenterOn(context) && !this.f61731f) {
                this.f61731f = true;
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
            if (this.f61729d != null && this.f61732g != null) {
                if (i.a().a(this.f61732g).MW_ON && this.f61729d.size() > 0) {
                    try {
                        lightappBrowserWebView = this.f61729d.take();
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
                return null;
            }
            DXMSdkSAUtils.onEvent("#webviewPoolNotInit");
            return null;
        }
        return (LightappBrowserWebView) invokeV.objValue;
    }

    public LightappBrowserWebView initLightappWebView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (this.f61728c == null) {
                this.f61730e = new MutableContextWrapper(context);
                this.f61728c = new LightappBrowserWebView(this.f61730e);
            } else {
                MutableContextWrapper mutableContextWrapper = this.f61730e;
                if (mutableContextWrapper != null) {
                    mutableContextWrapper.setBaseContext(context);
                    this.f61728c.clearHistory();
                }
            }
            return this.f61728c;
        }
        return (LightappBrowserWebView) invokeL.objValue;
    }

    public void initLightappWebViewPool(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, activity) == null) && activity != null && this.f61729d == null) {
            i.a().a(this);
            if (i.a().a(activity).MW_ON) {
                long currentTimeMillis = System.currentTimeMillis();
                int i2 = i.a().a(activity).MW_WEBVIEW_POOL_SIZE;
                if (i2 <= 0) {
                    return;
                }
                this.f61729d = new LinkedBlockingQueue<>(i2);
                this.f61732g = activity.getApplication();
                while (this.f61729d.remainingCapacity() > 0) {
                    LightappBrowserWebView lightappBrowserWebView = new LightappBrowserWebView(activity);
                    try {
                        lightappBrowserWebView.loadUrl("about:blank");
                        lightappBrowserWebView.setBaseContext(this.f61732g);
                        lightappBrowserWebView.onPause();
                        this.f61729d.put(lightappBrowserWebView);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                LogUtil.i(TAG, "init webview pool cost: " + currentTimeMillis2);
                DXMSdkSAUtils.onEventWithValues("#eventInitWebviewPool", Arrays.asList(currentTimeMillis2 + ""));
            }
        }
    }

    public void initWebViewCore(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            String userAgentString = new LightappBrowserWebView(DxmApplicationContextImpl.getApplicationContext(context)).getSettings().getUserAgentString();
            if (userAgentString != null && !userAgentString.contains("BaiduWallet")) {
                userAgentString = userAgentString + " " + BussinessUtils.getUA(DxmApplicationContextImpl.getApplicationContext(context));
            }
            if (TextUtils.isEmpty(userAgentString)) {
                return;
            }
            LangbridgeCacheManager.getInstance().setLangbridgeUA(userAgentString);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.i.a
    public void onSettingUpdated(LangbridgeSettings langbridgeSettings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, langbridgeSettings) == null) {
            if ((!i.a().a(this.f61732g).MW_ON || i.a().a(this.f61732g).MW_USE_OLD) && this.f61729d != null) {
                this.f61727b.removeCallbacks(this.f61734i);
                LightappBrowserWebView lightappBrowserWebView = null;
                while (this.f61729d.size() > 0) {
                    try {
                        lightappBrowserWebView = this.f61729d.take();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    if (lightappBrowserWebView != null) {
                        lightappBrowserWebView.destroy();
                    }
                }
            }
        }
    }

    public boolean releaseLightappWebView(@NonNull Context context, LightappBrowserWebView lightappBrowserWebView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, lightappBrowserWebView)) == null) {
            if (this.f61728c == lightappBrowserWebView) {
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
                MutableContextWrapper mutableContextWrapper = this.f61730e;
                if (mutableContextWrapper != null) {
                    mutableContextWrapper.setBaseContext(DxmApplicationContextImpl.getApplicationContext(context));
                }
                this.f61731f = false;
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void releaseLightappWebView2Pool(Activity activity, LightappBrowserWebView lightappBrowserWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, lightappBrowserWebView) == null) {
            if (lightappBrowserWebView != null) {
                lightappBrowserWebView.removeAllViews();
                ViewGroup viewGroup = (ViewGroup) lightappBrowserWebView.getParent();
                if (viewGroup != null) {
                    try {
                        viewGroup.removeView(lightappBrowserWebView);
                    } catch (Throwable th) {
                        LogUtil.e(TAG, "release Exception", th);
                    }
                }
                lightappBrowserWebView.clearHistory();
                lightappBrowserWebView.destroy();
                this.f61726a++;
            }
            LogUtil.i(TAG, "releaseLightappWebView2Pool1: " + lightappBrowserWebView.hashCode());
            if (this.f61729d != null && activity != null && this.f61732g != null && i.a().a(this.f61732g).MW_ON) {
                while (this.f61726a > 0 && this.f61729d.remainingCapacity() > 0) {
                    LightappBrowserWebView lightappBrowserWebView2 = new LightappBrowserWebView(activity);
                    try {
                        lightappBrowserWebView2.loadUrl("about:blank");
                        lightappBrowserWebView2.setBaseContext(this.f61732g);
                        lightappBrowserWebView2.onPause();
                        this.f61729d.put(lightappBrowserWebView2);
                        this.f61726a--;
                        LogUtil.i(TAG, "new inset" + lightappBrowserWebView2.hashCode() + " mLightappWebViewPool " + this.f61729d.size());
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            LinkedBlockingQueue<LightappBrowserWebView> linkedBlockingQueue = this.f61729d;
            if (linkedBlockingQueue == null || linkedBlockingQueue.remainingCapacity() == 0) {
                this.f61726a = 0;
            }
        }
    }

    public void startAutoChecker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f61733h = i.a().a(this.f61732g).MW_PRELOAD_TEST_CHECK_MAX_TIMES;
            this.f61727b.post(this.f61734i);
        }
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
        this.f61726a = 0;
        this.f61729d = null;
        this.f61731f = false;
        this.f61733h = -1;
        this.f61734i = new Runnable(this) { // from class: com.baidu.wallet.lightapp.base.LightappWebViewCenter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LightappWebViewCenter f61735a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f61735a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !i.a().a(this.f61735a.f61732g).MW_USE_OLD && i.a().a(this.f61735a.f61732g).MW_ON && i.a().a(this.f61735a.f61732g).MW_START_PRELOAD_AUTO_TEST_NEW && LightappWebViewCenter.b(this.f61735a) > 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add("file:///android_asset/MWmonitorTest.html");
                    LangbridgePreloadCellCenter.getInstance(this.f61735a.f61732g).preload(arrayList, 20, null, null);
                    this.f61735a.f61727b.postDelayed(this.f61735a.f61734i, i.a().a(this.f61735a.f61732g).MW_PRELOAD_AUTO_TEST_INTERVAL * 1000);
                }
            }
        };
        this.f61727b = new Handler(Looper.getMainLooper());
    }

    public LightappBrowserWebView getLightappWebViewFromPool(@NonNull Activity activity, boolean z) {
        InterceptResult invokeLZ;
        LightappBrowserWebView lightappBrowserWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, activity, z)) == null) {
            LightappBrowserWebView lightappBrowserWebView2 = null;
            if (this.f61732g == null || this.f61729d == null) {
                if (activity != null) {
                    DXMSdkSAUtils.onEvent("#webviewPoolNotInit");
                    initLightappWebViewPool(activity);
                }
            } else if (i.a().a(this.f61732g).MW_ON && this.f61729d.size() > 0) {
                try {
                    lightappBrowserWebView = this.f61729d.take();
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
                            DXMSdkSAUtils.onEventWithValues("#getWebviewPoolRetType", Arrays.asList("0"));
                            return lightappBrowserWebView;
                        }
                    }
                } catch (InterruptedException e3) {
                    e = e3;
                }
                DXMSdkSAUtils.onEventWithValues("#getWebviewPoolRetType", Arrays.asList("0"));
                return lightappBrowserWebView;
            }
            if (!z || activity == null) {
                return null;
            }
            DXMSdkSAUtils.onEventWithValues("#getWebviewPoolRetType", Arrays.asList("1"));
            return new LightappBrowserWebView(activity);
        }
        return (LightappBrowserWebView) invokeLZ.objValue;
    }
}
