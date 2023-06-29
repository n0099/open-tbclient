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
import com.baidu.tieba.yu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public final class kh2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final kh2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-661355530, "Lcom/baidu/tieba/kh2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-661355530, "Lcom/baidu/tieba/kh2$b;");
                    return;
                }
            }
            a = new kh2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947913012, "Lcom/baidu/tieba/kh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947913012, "Lcom/baidu/tieba/kh2;");
                return;
            }
        }
        b = ms1.a;
    }

    public kh2() {
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

    public static kh2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (kh2) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ kh2(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            m12.k(swanAppConfigData);
            mh2.k().x(bc3.K().getAppId(), false);
            yk3.l().t();
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
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.jy1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull yd2 yd2Var, @NonNull iy1 iy1Var, @NonNull zw2 zw2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable yu2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        ti2 ti2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{yd2Var, iy1Var, zw2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        ri2.c(14);
                    }
                    return;
                }
                if (z) {
                    ri2.c(1);
                }
                String d = nf3.d(px2.T(), zw2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                qi2 qi2Var = new qi2();
                qi2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    qi2Var.b = gVar.a;
                } else {
                    qi2Var.b = yu2.e.i(zw2Var.H(), zw2Var.v1()).getPath() + File.separator;
                }
                qi2Var.c = iy1Var.a();
                qi2Var.d = d;
                qi2Var.f = String.valueOf(z82.a());
                qi2Var.g = qi2.c(cc3.M(), d);
                qi2Var.i = h;
                if (!b && !px2.T().M()) {
                    z2 = false;
                    qi2Var.h = z2;
                    qi2Var.j = iy1Var.I();
                    qi2Var.l = ui2.b();
                    f0 = zw2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        qi2Var.m = f0.userActionApis;
                    }
                    H = b83.H();
                    if (H) {
                        qi2Var.k = f92.b();
                    }
                    P = zw2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            qi2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", qi2Var.toString());
                    }
                    h53.o().F(new UbcFlowEvent("master_dispatch_start"));
                    ci3.d().i("master_dispatch_start");
                    yd2Var.C(qi2Var);
                    wi2.U().U0(qi2.b(qi2Var));
                    jv2.m0().a();
                    wi2.U().h1(qi2Var.j);
                    F = b83.F(zw2Var.g0());
                    boolean p0 = zw2Var.p0();
                    if (!F) {
                        s92.d();
                        s92.g().h("appready");
                    } else if (p0) {
                        l92.e().f("appready");
                    }
                    rc3 f = px2.T().f(uf3.b(up3.f(d)));
                    ti2Var = new ti2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        ti2Var.a = gVar.a;
                    } else {
                        ti2Var.a = yu2.e.i(zw2Var.H(), zw2Var.v1()).getPath() + File.separator;
                    }
                    ti2Var.b = d;
                    ti2Var.d = f.g;
                    ti2Var.c = h;
                    ti2Var.k = qi2Var.g;
                    ti2Var.e = String.valueOf(zw2Var.m0());
                    ti2Var.g = z2;
                    ti2Var.i = iy1Var.I();
                    ti2Var.m = true;
                    if (H) {
                        ti2Var.j = f92.d();
                    }
                    if (!F) {
                        s92.g().h("pageready");
                    } else if (p0) {
                        l92.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", ti2Var.toString());
                    }
                    h53.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    ci3.d().i("slave_dispatch_start");
                    iy1Var.J(ti2Var);
                    jp3.d();
                    iy1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    iy1Var.Q(d);
                    wi2.U().V0(iy1Var.a(), ti2.a(ti2Var));
                    mi3.F(iy1Var.a(), ti2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + qi2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + iy1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + ti2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + ti2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + ti2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                qi2Var.h = z2;
                qi2Var.j = iy1Var.I();
                qi2Var.l = ui2.b();
                f0 = zw2Var.f0();
                if (f0 != null) {
                    qi2Var.m = f0.userActionApis;
                }
                H = b83.H();
                if (H) {
                }
                P = zw2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                h53.o().F(new UbcFlowEvent("master_dispatch_start"));
                ci3.d().i("master_dispatch_start");
                yd2Var.C(qi2Var);
                wi2.U().U0(qi2.b(qi2Var));
                jv2.m0().a();
                wi2.U().h1(qi2Var.j);
                F = b83.F(zw2Var.g0());
                boolean p02 = zw2Var.p0();
                if (!F) {
                }
                rc3 f2 = px2.T().f(uf3.b(up3.f(d)));
                ti2Var = new ti2();
                if (gVar == null) {
                }
                ti2Var.a = yu2.e.i(zw2Var.H(), zw2Var.v1()).getPath() + File.separator;
                ti2Var.b = d;
                ti2Var.d = f2.g;
                ti2Var.c = h;
                ti2Var.k = qi2Var.g;
                ti2Var.e = String.valueOf(zw2Var.m0());
                ti2Var.g = z2;
                ti2Var.i = iy1Var.I();
                ti2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                h53.o().F(new UbcFlowEvent("slave_dispatch_start"));
                ci3.d().i("slave_dispatch_start");
                iy1Var.J(ti2Var);
                jp3.d();
                iy1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                iy1Var.Q(d);
                wi2.U().V0(iy1Var.a(), ti2.a(ti2Var));
                mi3.F(iy1Var.a(), ti2Var.b);
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
        yd2 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = a63.b()) != 0 && (W = wi2.U().W()) != null) {
            if (b2 < 0) {
                W.o(b2);
            } else if (b2 == 1) {
                W.o(-4);
            } else {
                W.o(-2);
            }
        }
    }
}
