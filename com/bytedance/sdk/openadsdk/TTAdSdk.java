package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.e;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.executor.GetExecutor;
import com.bytedance.sdk.component.net.executor.NetExecutor;
import com.bytedance.sdk.component.net.tnc.AppConfig;
import com.bytedance.sdk.component.net.utils.NetLog;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.j.f;
import com.bytedance.sdk.openadsdk.core.j.g;
import com.bytedance.sdk.openadsdk.core.j.h;
import com.bytedance.sdk.openadsdk.core.k.c;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.j.b.a;
import com.bytedance.sdk.openadsdk.multipro.d;
import com.bytedance.sdk.openadsdk.preload.geckox.b;
import com.bytedance.sdk.openadsdk.q.j;
import com.bytedance.sdk.openadsdk.q.q;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class TTAdSdk {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f65392a;

    /* renamed from: b  reason: collision with root package name */
    public static final TTAdManager f65393b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface InitCallback {
        void fail(int i2, String str);

        void success();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2037386439, "Lcom/bytedance/sdk/openadsdk/TTAdSdk;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2037386439, "Lcom/bytedance/sdk/openadsdk/TTAdSdk;");
                return;
            }
        }
        f65393b = new u();
    }

    public TTAdSdk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void c(Context context, TTAdConfig tTAdConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, context, tTAdConfig) == null) && g.a()) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) e.a();
            AppConfig.getInstance(context).setThreadPoolExecutor(threadPoolExecutor);
            b.a(threadPoolExecutor);
            d.a(context);
            if (tTAdConfig.isSupportMultiProcess()) {
                com.bytedance.sdk.openadsdk.multipro.b.a();
            }
            if (o.h().L()) {
                try {
                    GetExecutor getExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getGetExecutor();
                    getExecutor.setUrl(q.l("/api/ad/union/ping"));
                    getExecutor.enqueue(new NetCallback() { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        @Override // com.bytedance.sdk.component.net.callback.NetCallback
                        public void onFailure(NetExecutor netExecutor, IOException iOException) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                            }
                        }

                        @Override // com.bytedance.sdk.component.net.callback.NetCallback
                        public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) || netResponse == null) {
                                return;
                            }
                            l.f66742d = netResponse.getCode();
                        }
                    });
                } catch (Throwable unused) {
                }
            }
            updateAdConfig(tTAdConfig);
            c(tTAdConfig);
            l.a();
        }
    }

    public static void d(Context context, TTAdConfig tTAdConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, tTAdConfig) == null) {
            p.a(context, "Context is null, please check.");
            p.a(tTAdConfig, "TTAdConfig is null, please check.");
            o.a(context);
            if (tTAdConfig.isDebug()) {
                k.b();
            }
        }
    }

    public static void e(Context context, TTAdConfig tTAdConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, tTAdConfig) == null) {
            e.a(new com.bytedance.sdk.component.d.g("init sync", context, tTAdConfig) { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f65397a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTAdConfig f65398b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7, context, tTAdConfig};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65397a = context;
                    this.f65398b = tTAdConfig;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        h h2 = o.h();
                        if (!h2.K()) {
                            synchronized (h2) {
                                if (!h2.K()) {
                                    h2.a();
                                }
                            }
                        }
                        com.bytedance.sdk.openadsdk.downloadnew.a.g.a(this.f65397a);
                        AppLogHelper.getInstance().initAppLog(this.f65397a);
                        com.bytedance.sdk.openadsdk.core.h.d().i();
                        c.f();
                        TTAdSdk.updatePaid(this.f65398b.isPaid());
                        l.a(this.f65397a);
                        e.a(true);
                        e.a(new a());
                        if (this.f65398b.isDebug()) {
                            TTAdSdk.f65393b.openDebugMode();
                        }
                        com.bytedance.sdk.openadsdk.dislike.a.a();
                        com.bytedance.sdk.openadsdk.m.a.a(this.f65397a);
                        c.a(this.f65397a);
                        if (Build.VERSION.SDK_INT >= 29) {
                            try {
                                s.a();
                                n.a(new j());
                            } catch (Exception unused) {
                            }
                        }
                        com.bytedance.sdk.openadsdk.q.s.b();
                    }
                }
            }, 10);
            l.c().postDelayed(new Runnable(tTAdConfig, context) { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdConfig f65399a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f65400b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tTAdConfig, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65399a = tTAdConfig;
                    this.f65400b = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f65399a.isSupportMultiProcess()) {
                            if (com.bytedance.sdk.component.utils.q.a(this.f65400b)) {
                                f.a(o.h()).e();
                                k.c("TTAdSdk", "Load setting in main process");
                            }
                        } else {
                            f.a(o.h()).e();
                        }
                        com.bytedance.sdk.openadsdk.m.a.c();
                        o.c().a();
                        o.e().a();
                        o.d().a();
                        CacheDirConstants.clearCache();
                    }
                }
            }, 10000L);
        }
    }

    public static TTAdManager getAdManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? f65393b : (TTAdManager) invokeV.objValue;
    }

    public static TTAdManager init(Context context, TTAdConfig tTAdConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, context, tTAdConfig)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (Looper.getMainLooper() != Looper.myLooper()) {
                k.b("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
            }
            if (f65392a) {
                return f65393b;
            }
            try {
                d(context, tTAdConfig);
                c(context, tTAdConfig);
                e(context, tTAdConfig);
                a(SystemClock.elapsedRealtime() - elapsedRealtime, false, tTAdConfig);
                f65392a = true;
            } catch (Throwable th) {
                th.printStackTrace();
                k.c("TTAdSdk", "Pangle exec init fail, msg = ", th.getMessage());
                f65392a = false;
            }
            b(tTAdConfig);
            l.f66741c = true;
            return f65393b;
        }
        return (TTAdManager) invokeLL.objValue;
    }

    public static boolean isInitSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? f65392a : invokeV.booleanValue;
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, tTAdConfig) == null) || tTAdConfig == null) {
            return;
        }
        if (!TextUtils.isEmpty(tTAdConfig.getData())) {
            com.bytedance.sdk.openadsdk.core.h.d().d(tTAdConfig.getData());
        }
        if (TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.h.d().c(tTAdConfig.getKeywords());
    }

    public static void updatePaid(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, null, z) == null) {
            com.bytedance.sdk.openadsdk.core.h.d().b(z);
        }
    }

    public static void b(TTAdConfig tTAdConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, tTAdConfig) == null) && tTAdConfig.isDebug()) {
            com.bytedance.sdk.openadsdk.o.a.b(1, f65392a ? "1" : "0");
            com.bytedance.sdk.openadsdk.o.a.a(3, com.bytedance.sdk.openadsdk.core.j.a(o.a()));
            com.bytedance.sdk.openadsdk.core.h.d().e();
            com.bytedance.sdk.openadsdk.o.a.a(2, tTAdConfig.getAppId());
            try {
                Thread.currentThread().getContextClassLoader().loadClass("com.bytedance.sdk.openadsdk.core.GlobalInfo");
                com.bytedance.sdk.openadsdk.o.a.b(2, "0");
            } catch (Exception unused) {
                com.bytedance.sdk.openadsdk.o.a.b(2, "1");
            }
            com.bytedance.sdk.openadsdk.o.a.a(0, "3.7.0.3");
        }
    }

    public static void a(long j2, boolean z, TTAdConfig tTAdConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), tTAdConfig}) == null) {
            e.b(new com.bytedance.sdk.component.d.g("initMustBeCall", j2, z, tTAdConfig) { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f65401a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f65402b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ TTAdConfig f65403c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7, Long.valueOf(j2), Boolean.valueOf(z), tTAdConfig};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65401a = j2;
                    this.f65402b = z;
                    this.f65403c = tTAdConfig;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        l.b();
                        if (o.h().v()) {
                            try {
                                boolean g2 = com.bytedance.sdk.openadsdk.core.h.d().g();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("duration", this.f65401a);
                                jSONObject.put("is_async", this.f65402b);
                                jSONObject.put("is_multi_process", this.f65403c.isSupportMultiProcess());
                                jSONObject.put("is_debug", this.f65403c.isDebug());
                                jSONObject.put("is_use_texture_view", this.f65403c.isUseTextureView());
                                jSONObject.put("is_activate_init", g2);
                                com.bytedance.sdk.openadsdk.core.h.d().a(false);
                                com.bytedance.sdk.openadsdk.j.a.a().a("pangle_sdk_init", jSONObject);
                                k.b("TTAdSdk", "pangle_sdk_init = ", jSONObject);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }

    public static void c(TTAdConfig tTAdConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, tTAdConfig) == null) {
            if (tTAdConfig.getHttpStack() != null) {
                com.bytedance.sdk.openadsdk.k.d.a(tTAdConfig.getHttpStack());
            }
            l.f66739a = tTAdConfig.isAsyncInit();
            l.f66740b = tTAdConfig.getCustomController();
            f65393b.setAppId(tTAdConfig.getAppId()).setName(tTAdConfig.getAppName()).setKeywords(tTAdConfig.getKeywords()).setData(tTAdConfig.getData()).setTitleBarTheme(tTAdConfig.getTitleBarTheme()).setAllowShowNotifiFromSDK(tTAdConfig.isAllowShowNotify()).setAllowLandingPageShowWhenScreenLock(tTAdConfig.isAllowShowPageWhenScreenLock()).setDirectDownloadNetworkType(tTAdConfig.getDirectDownloadNetworkType()).isUseTextureView(tTAdConfig.isUseTextureView()).setTTDownloadEventLogger(tTAdConfig.getTTDownloadEventLogger()).setNeedClearTaskReset(tTAdConfig.getNeedClearTaskReset()).setTTSecAbs(tTAdConfig.getTTSecAbs()).setCustomController(tTAdConfig.getCustomController());
            com.bytedance.sdk.openadsdk.m.a.a(tTAdConfig);
            try {
                if (tTAdConfig.isDebug()) {
                    f65393b.openDebugMode();
                    com.bytedance.sdk.openadsdk.q.h.a();
                    com.bytedance.sdk.component.video.d.c.a();
                    NetLog.openDebugMode();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void init(Context context, TTAdConfig tTAdConfig, InitCallback initCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, context, tTAdConfig, initCallback) == null) {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (Looper.getMainLooper() != Looper.myLooper()) {
                    k.b("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
                }
                if (f65392a) {
                    if (initCallback != null) {
                        initCallback.success();
                        return;
                    }
                    return;
                }
                d(context, tTAdConfig);
                a(SystemClock.elapsedRealtime() - elapsedRealtime, true, tTAdConfig);
                l.c().post(new Runnable(initCallback, context, tTAdConfig) { // from class: com.bytedance.sdk.openadsdk.TTAdSdk.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ InitCallback f65394a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Context f65395b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ TTAdConfig f65396c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {initCallback, context, tTAdConfig};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f65394a = initCallback;
                        this.f65395b = context;
                        this.f65396c = tTAdConfig;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (!TTAdSdk.f65392a) {
                                try {
                                    TTAdSdk.c(this.f65395b, this.f65396c);
                                    if (this.f65394a != null) {
                                        this.f65394a.success();
                                    }
                                    TTAdSdk.e(this.f65395b, this.f65396c);
                                    boolean unused = TTAdSdk.f65392a = true;
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    InitCallback initCallback2 = this.f65394a;
                                    if (initCallback2 != null) {
                                        initCallback2.fail(4000, th.getMessage());
                                    }
                                    boolean unused2 = TTAdSdk.f65392a = false;
                                }
                                TTAdSdk.b(this.f65396c);
                                return;
                            }
                            InitCallback initCallback3 = this.f65394a;
                            if (initCallback3 != null) {
                                initCallback3.success();
                            }
                        }
                    }
                });
                l.f66741c = true;
            } catch (Throwable th) {
                if (initCallback != null) {
                    initCallback.fail(4000, th.getMessage());
                    k.c("TTAdSdk", " Pangle exec init fail, msg = ", th.getMessage());
                    f65392a = false;
                    b(tTAdConfig);
                }
            }
        }
    }
}
