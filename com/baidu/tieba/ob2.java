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
import com.baidu.tieba.cp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public final class ob2 {
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
        public static final ob2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-552380052, "Lcom/baidu/tieba/ob2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-552380052, "Lcom/baidu/tieba/ob2$b;");
                    return;
                }
            }
            a = new ob2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948026410, "Lcom/baidu/tieba/ob2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948026410, "Lcom/baidu/tieba/ob2;");
                return;
            }
        }
        b = rm1.a;
    }

    public ob2() {
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

    public static ob2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (ob2) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ ob2(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            rv1.k(swanAppConfigData);
            qb2.k().x(f63.K().getAppId(), false);
            cf3.l().t();
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
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.os1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull c82 c82Var, @NonNull ns1 ns1Var, @NonNull dr2 dr2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable cp2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo g0;
        boolean H;
        Bundle Q;
        boolean F;
        xc2 xc2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{c82Var, ns1Var, dr2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        vc2.c(14);
                    }
                    return;
                }
                if (z) {
                    vc2.c(1);
                }
                String d = r93.d(tr2.V(), dr2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                uc2 uc2Var = new uc2();
                uc2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    uc2Var.b = gVar.a;
                } else {
                    uc2Var.b = cp2.e.i(dr2Var.I(), dr2Var.x1()).getPath() + File.separator;
                }
                uc2Var.c = ns1Var.a();
                uc2Var.d = d;
                uc2Var.f = String.valueOf(d32.a());
                uc2Var.g = uc2.c(g63.M(), d);
                uc2Var.i = h;
                if (!b && !tr2.V().O()) {
                    z2 = false;
                    uc2Var.h = z2;
                    uc2Var.j = ns1Var.I();
                    uc2Var.l = yc2.b();
                    g0 = dr2Var.g0();
                    if (g0 != null && !TextUtils.isEmpty(g0.userActionApis)) {
                        uc2Var.m = g0.userActionApis;
                    }
                    H = f23.H();
                    if (H) {
                        uc2Var.k = j32.b();
                    }
                    Q = dr2Var.Q();
                    if (Q != null) {
                        String string = Q.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            uc2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", uc2Var.toString());
                    }
                    lz2.o().F(new UbcFlowEvent("master_dispatch_start"));
                    gc3.d().i("master_dispatch_start");
                    c82Var.B(uc2Var);
                    ad2.V().V0(uc2.b(uc2Var));
                    np2.m0().a();
                    ad2.V().i1(uc2Var.j);
                    F = f23.F(dr2Var.h0());
                    boolean q0 = dr2Var.q0();
                    if (!F) {
                        w32.d();
                        w32.g().h("appready");
                    } else if (q0) {
                        p32.e().f("appready");
                    }
                    v63 f = tr2.V().f(y93.b(yj3.f(d)));
                    xc2Var = new xc2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        xc2Var.a = gVar.a;
                    } else {
                        xc2Var.a = cp2.e.i(dr2Var.I(), dr2Var.x1()).getPath() + File.separator;
                    }
                    xc2Var.b = d;
                    xc2Var.d = f.g;
                    xc2Var.c = h;
                    xc2Var.k = uc2Var.g;
                    xc2Var.e = String.valueOf(dr2Var.n0());
                    xc2Var.g = z2;
                    xc2Var.i = ns1Var.I();
                    xc2Var.m = true;
                    if (H) {
                        xc2Var.j = j32.d();
                    }
                    if (!F) {
                        w32.g().h("pageready");
                    } else if (q0) {
                        p32.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", xc2Var.toString());
                    }
                    lz2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    gc3.d().i("slave_dispatch_start");
                    ns1Var.J(xc2Var);
                    nj3.d();
                    ns1Var.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    ns1Var.P(d);
                    ad2.V().W0(ns1Var.a(), xc2.a(xc2Var));
                    qc3.F(ns1Var.a(), xc2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + uc2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + ns1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + xc2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + xc2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + xc2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                uc2Var.h = z2;
                uc2Var.j = ns1Var.I();
                uc2Var.l = yc2.b();
                g0 = dr2Var.g0();
                if (g0 != null) {
                    uc2Var.m = g0.userActionApis;
                }
                H = f23.H();
                if (H) {
                }
                Q = dr2Var.Q();
                if (Q != null) {
                }
                if (b) {
                }
                lz2.o().F(new UbcFlowEvent("master_dispatch_start"));
                gc3.d().i("master_dispatch_start");
                c82Var.B(uc2Var);
                ad2.V().V0(uc2.b(uc2Var));
                np2.m0().a();
                ad2.V().i1(uc2Var.j);
                F = f23.F(dr2Var.h0());
                boolean q02 = dr2Var.q0();
                if (!F) {
                }
                v63 f2 = tr2.V().f(y93.b(yj3.f(d)));
                xc2Var = new xc2();
                if (gVar == null) {
                }
                xc2Var.a = cp2.e.i(dr2Var.I(), dr2Var.x1()).getPath() + File.separator;
                xc2Var.b = d;
                xc2Var.d = f2.g;
                xc2Var.c = h;
                xc2Var.k = uc2Var.g;
                xc2Var.e = String.valueOf(dr2Var.n0());
                xc2Var.g = z2;
                xc2Var.i = ns1Var.I();
                xc2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                lz2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                gc3.d().i("slave_dispatch_start");
                ns1Var.J(xc2Var);
                nj3.d();
                ns1Var.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                ns1Var.P(d);
                ad2.V().W0(ns1Var.a(), xc2.a(xc2Var));
                qc3.F(ns1Var.a(), xc2Var.b);
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
        c82 X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = e03.b()) != 0 && (X = ad2.V().X()) != null) {
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
