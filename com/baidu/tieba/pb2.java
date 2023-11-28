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
import com.baidu.tieba.dp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public final class pb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final pb2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-523750901, "Lcom/baidu/tieba/pb2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-523750901, "Lcom/baidu/tieba/pb2$b;");
                    return;
                }
            }
            a = new pb2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948056201, "Lcom/baidu/tieba/pb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948056201, "Lcom/baidu/tieba/pb2;");
                return;
            }
        }
        b = sm1.a;
    }

    public pb2() {
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

    public static pb2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (pb2) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ pb2(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            sv1.k(swanAppConfigData);
            rb2.k().x(g63.K().getAppId(), false);
            df3.l().t();
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
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.ps1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull d82 d82Var, @NonNull os1 os1Var, @NonNull er2 er2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable dp2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo g0;
        boolean H;
        Bundle Q;
        boolean F;
        yc2 yc2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{d82Var, os1Var, er2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        wc2.c(14);
                    }
                    return;
                }
                if (z) {
                    wc2.c(1);
                }
                String d = s93.d(ur2.V(), er2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                vc2 vc2Var = new vc2();
                vc2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    vc2Var.b = gVar.a;
                } else {
                    vc2Var.b = dp2.e.i(er2Var.I(), er2Var.x1()).getPath() + File.separator;
                }
                vc2Var.c = os1Var.a();
                vc2Var.d = d;
                vc2Var.f = String.valueOf(e32.a());
                vc2Var.g = vc2.c(h63.M(), d);
                vc2Var.i = h;
                if (!b && !ur2.V().O()) {
                    z2 = false;
                    vc2Var.h = z2;
                    vc2Var.j = os1Var.I();
                    vc2Var.l = zc2.b();
                    g0 = er2Var.g0();
                    if (g0 != null && !TextUtils.isEmpty(g0.userActionApis)) {
                        vc2Var.m = g0.userActionApis;
                    }
                    H = g23.H();
                    if (H) {
                        vc2Var.k = k32.b();
                    }
                    Q = er2Var.Q();
                    if (Q != null) {
                        String string = Q.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            vc2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", vc2Var.toString());
                    }
                    mz2.o().F(new UbcFlowEvent("master_dispatch_start"));
                    hc3.d().i("master_dispatch_start");
                    d82Var.B(vc2Var);
                    bd2.V().V0(vc2.b(vc2Var));
                    op2.m0().a();
                    bd2.V().i1(vc2Var.j);
                    F = g23.F(er2Var.h0());
                    boolean q0 = er2Var.q0();
                    if (!F) {
                        x32.d();
                        x32.g().h("appready");
                    } else if (q0) {
                        q32.e().f("appready");
                    }
                    w63 f = ur2.V().f(z93.b(zj3.f(d)));
                    yc2Var = new yc2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        yc2Var.a = gVar.a;
                    } else {
                        yc2Var.a = dp2.e.i(er2Var.I(), er2Var.x1()).getPath() + File.separator;
                    }
                    yc2Var.b = d;
                    yc2Var.d = f.g;
                    yc2Var.c = h;
                    yc2Var.k = vc2Var.g;
                    yc2Var.e = String.valueOf(er2Var.n0());
                    yc2Var.g = z2;
                    yc2Var.i = os1Var.I();
                    yc2Var.m = true;
                    if (H) {
                        yc2Var.j = k32.d();
                    }
                    if (!F) {
                        x32.g().h("pageready");
                    } else if (q0) {
                        q32.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", yc2Var.toString());
                    }
                    mz2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    hc3.d().i("slave_dispatch_start");
                    os1Var.J(yc2Var);
                    oj3.d();
                    os1Var.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    os1Var.P(d);
                    bd2.V().W0(os1Var.a(), yc2.a(yc2Var));
                    rc3.F(os1Var.a(), yc2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + vc2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + os1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + yc2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + yc2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + yc2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                vc2Var.h = z2;
                vc2Var.j = os1Var.I();
                vc2Var.l = zc2.b();
                g0 = er2Var.g0();
                if (g0 != null) {
                    vc2Var.m = g0.userActionApis;
                }
                H = g23.H();
                if (H) {
                }
                Q = er2Var.Q();
                if (Q != null) {
                }
                if (b) {
                }
                mz2.o().F(new UbcFlowEvent("master_dispatch_start"));
                hc3.d().i("master_dispatch_start");
                d82Var.B(vc2Var);
                bd2.V().V0(vc2.b(vc2Var));
                op2.m0().a();
                bd2.V().i1(vc2Var.j);
                F = g23.F(er2Var.h0());
                boolean q02 = er2Var.q0();
                if (!F) {
                }
                w63 f2 = ur2.V().f(z93.b(zj3.f(d)));
                yc2Var = new yc2();
                if (gVar == null) {
                }
                yc2Var.a = dp2.e.i(er2Var.I(), er2Var.x1()).getPath() + File.separator;
                yc2Var.b = d;
                yc2Var.d = f2.g;
                yc2Var.c = h;
                yc2Var.k = vc2Var.g;
                yc2Var.e = String.valueOf(er2Var.n0());
                yc2Var.g = z2;
                yc2Var.i = os1Var.I();
                yc2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                mz2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                hc3.d().i("slave_dispatch_start");
                os1Var.J(yc2Var);
                oj3.d();
                os1Var.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                os1Var.P(d);
                bd2.V().W0(os1Var.a(), yc2.a(yc2Var));
                rc3.F(os1Var.a(), yc2Var.b);
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
        d82 X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = f03.b()) != 0 && (X = bd2.V().X()) != null) {
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
