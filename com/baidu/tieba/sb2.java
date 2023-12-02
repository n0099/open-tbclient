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
import com.baidu.tieba.gp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public final class sb2 {
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
        public static final sb2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-437863448, "Lcom/baidu/tieba/sb2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-437863448, "Lcom/baidu/tieba/sb2$b;");
                    return;
                }
            }
            a = new sb2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948145574, "Lcom/baidu/tieba/sb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948145574, "Lcom/baidu/tieba/sb2;");
                return;
            }
        }
        b = vm1.a;
    }

    public sb2() {
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

    public static sb2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (sb2) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ sb2(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            vv1.k(swanAppConfigData);
            ub2.k().x(j63.K().getAppId(), false);
            gf3.l().t();
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
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.ss1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull g82 g82Var, @NonNull rs1 rs1Var, @NonNull hr2 hr2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable gp2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo g0;
        boolean H;
        Bundle Q;
        boolean F;
        bd2 bd2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{g82Var, rs1Var, hr2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        zc2.c(14);
                    }
                    return;
                }
                if (z) {
                    zc2.c(1);
                }
                String d = v93.d(xr2.V(), hr2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                yc2 yc2Var = new yc2();
                yc2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    yc2Var.b = gVar.a;
                } else {
                    yc2Var.b = gp2.e.i(hr2Var.I(), hr2Var.x1()).getPath() + File.separator;
                }
                yc2Var.c = rs1Var.a();
                yc2Var.d = d;
                yc2Var.f = String.valueOf(h32.a());
                yc2Var.g = yc2.c(k63.M(), d);
                yc2Var.i = h;
                if (!b && !xr2.V().O()) {
                    z2 = false;
                    yc2Var.h = z2;
                    yc2Var.j = rs1Var.I();
                    yc2Var.l = cd2.b();
                    g0 = hr2Var.g0();
                    if (g0 != null && !TextUtils.isEmpty(g0.userActionApis)) {
                        yc2Var.m = g0.userActionApis;
                    }
                    H = j23.H();
                    if (H) {
                        yc2Var.k = n32.b();
                    }
                    Q = hr2Var.Q();
                    if (Q != null) {
                        String string = Q.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            yc2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", yc2Var.toString());
                    }
                    pz2.o().F(new UbcFlowEvent("master_dispatch_start"));
                    kc3.d().i("master_dispatch_start");
                    g82Var.B(yc2Var);
                    ed2.V().V0(yc2.b(yc2Var));
                    rp2.m0().a();
                    ed2.V().i1(yc2Var.j);
                    F = j23.F(hr2Var.h0());
                    boolean q0 = hr2Var.q0();
                    if (!F) {
                        a42.d();
                        a42.g().h("appready");
                    } else if (q0) {
                        t32.e().f("appready");
                    }
                    z63 f = xr2.V().f(ca3.b(ck3.f(d)));
                    bd2Var = new bd2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        bd2Var.a = gVar.a;
                    } else {
                        bd2Var.a = gp2.e.i(hr2Var.I(), hr2Var.x1()).getPath() + File.separator;
                    }
                    bd2Var.b = d;
                    bd2Var.d = f.g;
                    bd2Var.c = h;
                    bd2Var.k = yc2Var.g;
                    bd2Var.e = String.valueOf(hr2Var.n0());
                    bd2Var.g = z2;
                    bd2Var.i = rs1Var.I();
                    bd2Var.m = true;
                    if (H) {
                        bd2Var.j = n32.d();
                    }
                    if (!F) {
                        a42.g().h("pageready");
                    } else if (q0) {
                        t32.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", bd2Var.toString());
                    }
                    pz2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    kc3.d().i("slave_dispatch_start");
                    rs1Var.J(bd2Var);
                    rj3.d();
                    rs1Var.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    rs1Var.P(d);
                    ed2.V().W0(rs1Var.a(), bd2.a(bd2Var));
                    uc3.F(rs1Var.a(), bd2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + yc2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + rs1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + bd2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bd2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + bd2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                yc2Var.h = z2;
                yc2Var.j = rs1Var.I();
                yc2Var.l = cd2.b();
                g0 = hr2Var.g0();
                if (g0 != null) {
                    yc2Var.m = g0.userActionApis;
                }
                H = j23.H();
                if (H) {
                }
                Q = hr2Var.Q();
                if (Q != null) {
                }
                if (b) {
                }
                pz2.o().F(new UbcFlowEvent("master_dispatch_start"));
                kc3.d().i("master_dispatch_start");
                g82Var.B(yc2Var);
                ed2.V().V0(yc2.b(yc2Var));
                rp2.m0().a();
                ed2.V().i1(yc2Var.j);
                F = j23.F(hr2Var.h0());
                boolean q02 = hr2Var.q0();
                if (!F) {
                }
                z63 f2 = xr2.V().f(ca3.b(ck3.f(d)));
                bd2Var = new bd2();
                if (gVar == null) {
                }
                bd2Var.a = gp2.e.i(hr2Var.I(), hr2Var.x1()).getPath() + File.separator;
                bd2Var.b = d;
                bd2Var.d = f2.g;
                bd2Var.c = h;
                bd2Var.k = yc2Var.g;
                bd2Var.e = String.valueOf(hr2Var.n0());
                bd2Var.g = z2;
                bd2Var.i = rs1Var.I();
                bd2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                pz2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                kc3.d().i("slave_dispatch_start");
                rs1Var.J(bd2Var);
                rj3.d();
                rs1Var.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                rs1Var.P(d);
                ed2.V().W0(rs1Var.a(), bd2.a(bd2Var));
                uc3.F(rs1Var.a(), bd2Var.b);
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
        g82 X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = i03.b()) != 0 && (X = ed2.V().X()) != null) {
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
