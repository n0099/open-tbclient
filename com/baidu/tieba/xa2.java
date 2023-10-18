package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.lo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public final class xa2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final xa2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-295641214, "Lcom/baidu/tieba/xa2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-295641214, "Lcom/baidu/tieba/xa2$b;");
                    return;
                }
            }
            a = new xa2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948293568, "Lcom/baidu/tieba/xa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948293568, "Lcom/baidu/tieba/xa2;");
                return;
            }
        }
        b = am1.a;
    }

    public xa2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
    }

    public static xa2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (xa2) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ xa2(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            av1.k(swanAppConfigData);
            za2.k().x(o53.K().getAppId(), false);
            le3.l().t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ef A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013d A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01bf A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c7 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e0 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022e A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.xr1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull l72 l72Var, @NonNull wr1 wr1Var, @NonNull mq2 mq2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable lo2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo g0;
        boolean H;
        Bundle Q;
        boolean F;
        gc2 gc2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{l72Var, wr1Var, mq2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        ec2.c(14);
                    }
                    return;
                }
                if (z) {
                    ec2.c(1);
                }
                String d = a93.d(cr2.V(), mq2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                dc2 dc2Var = new dc2();
                dc2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    dc2Var.b = gVar.a;
                } else {
                    dc2Var.b = lo2.e.i(mq2Var.I(), mq2Var.x1()).getPath() + File.separator;
                }
                dc2Var.c = wr1Var.a();
                dc2Var.d = d;
                dc2Var.f = String.valueOf(m22.a());
                dc2Var.g = dc2.c(p53.M(), d);
                dc2Var.i = h;
                if (!b && !cr2.V().O()) {
                    z2 = false;
                    dc2Var.h = z2;
                    dc2Var.j = wr1Var.H();
                    dc2Var.l = hc2.b();
                    g0 = mq2Var.g0();
                    if (g0 != null && !TextUtils.isEmpty(g0.userActionApis)) {
                        dc2Var.m = g0.userActionApis;
                    }
                    H = o13.H();
                    if (H) {
                        dc2Var.k = s22.b();
                    }
                    Q = mq2Var.Q();
                    if (Q != null) {
                        String string = Q.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            dc2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", dc2Var.toString());
                    }
                    uy2.o().F(new UbcFlowEvent("master_dispatch_start"));
                    pb3.d().i("master_dispatch_start");
                    l72Var.B(dc2Var);
                    jc2.V().V0(dc2.b(dc2Var));
                    wo2.m0().a();
                    jc2.V().i1(dc2Var.j);
                    F = o13.F(mq2Var.h0());
                    boolean q0 = mq2Var.q0();
                    if (!F) {
                        f32.d();
                        f32.g().h("appready");
                    } else if (q0) {
                        y22.e().f("appready");
                    }
                    e63 f = cr2.V().f(h93.b(hj3.f(d)));
                    gc2Var = new gc2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        gc2Var.a = gVar.a;
                    } else {
                        gc2Var.a = lo2.e.i(mq2Var.I(), mq2Var.x1()).getPath() + File.separator;
                    }
                    gc2Var.b = d;
                    gc2Var.d = f.g;
                    gc2Var.c = h;
                    gc2Var.k = dc2Var.g;
                    gc2Var.e = String.valueOf(mq2Var.n0());
                    gc2Var.g = z2;
                    gc2Var.i = wr1Var.H();
                    gc2Var.m = true;
                    if (H) {
                        gc2Var.j = s22.d();
                    }
                    if (!F) {
                        f32.g().h("pageready");
                    } else if (q0) {
                        y22.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", gc2Var.toString());
                    }
                    uy2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    pb3.d().i("slave_dispatch_start");
                    wr1Var.I(gc2Var);
                    wi3.d();
                    wr1Var.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    wr1Var.P(d);
                    jc2.V().W0(wr1Var.a(), gc2.a(gc2Var));
                    zb3.F(wr1Var.a(), gc2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + dc2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + wr1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + gc2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + gc2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + gc2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                dc2Var.h = z2;
                dc2Var.j = wr1Var.H();
                dc2Var.l = hc2.b();
                g0 = mq2Var.g0();
                if (g0 != null) {
                    dc2Var.m = g0.userActionApis;
                }
                H = o13.H();
                if (H) {
                }
                Q = mq2Var.Q();
                if (Q != null) {
                }
                if (b) {
                }
                uy2.o().F(new UbcFlowEvent("master_dispatch_start"));
                pb3.d().i("master_dispatch_start");
                l72Var.B(dc2Var);
                jc2.V().V0(dc2.b(dc2Var));
                wo2.m0().a();
                jc2.V().i1(dc2Var.j);
                F = o13.F(mq2Var.h0());
                boolean q02 = mq2Var.q0();
                if (!F) {
                }
                e63 f2 = cr2.V().f(h93.b(hj3.f(d)));
                gc2Var = new gc2();
                if (gVar == null) {
                }
                gc2Var.a = lo2.e.i(mq2Var.I(), mq2Var.x1()).getPath() + File.separator;
                gc2Var.b = d;
                gc2Var.d = f2.g;
                gc2Var.c = h;
                gc2Var.k = dc2Var.g;
                gc2Var.e = String.valueOf(mq2Var.n0());
                gc2Var.g = z2;
                gc2Var.i = wr1Var.H();
                gc2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                uy2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                pb3.d().i("slave_dispatch_start");
                wr1Var.I(gc2Var);
                wi3.d();
                wr1Var.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                wr1Var.P(d);
                jc2.V().W0(wr1Var.a(), gc2.a(gc2Var));
                zb3.F(wr1Var.a(), gc2Var.b);
                if (b) {
                }
                a(swanAppConfigData);
                this.a = true;
                e();
            }
        }
    }

    public final void e() {
        int b2;
        l72 X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = nz2.b()) != 0 && (X = jc2.V().X()) != null) {
            if (b2 < 0) {
                X.o(b2);
            } else if (b2 == 1) {
                X.o(-4);
            } else {
                X.o(-2);
            }
        }
    }
}
