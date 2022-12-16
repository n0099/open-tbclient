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
import com.baidu.tieba.an2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public final class m92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final m92 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-647502715, "Lcom/baidu/tieba/m92$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-647502715, "Lcom/baidu/tieba/m92$b;");
                    return;
                }
            }
            a = new m92(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947927427, "Lcom/baidu/tieba/m92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947927427, "Lcom/baidu/tieba/m92;");
                return;
            }
        }
        b = ok1.a;
    }

    public m92() {
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

    public static m92 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (m92) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ m92(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            ot1.k(swanAppConfigData);
            o92.k().x(d43.K().getAppId(), false);
            ad3.l().t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00de A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f0 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013e A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c0 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c8 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e1 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0231 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.lq1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull a62 a62Var, @NonNull kq1 kq1Var, @NonNull bp2 bp2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable an2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        va2 va2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{a62Var, kq1Var, bp2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        ta2.c(14);
                    }
                    return;
                }
                if (z) {
                    ta2.c(1);
                }
                String d = p73.d(rp2.U(), bp2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                sa2 sa2Var = new sa2();
                sa2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    sa2Var.b = gVar.a;
                } else {
                    sa2Var.b = an2.e.i(bp2Var.H(), bp2Var.v1()).getPath() + File.separator;
                }
                sa2Var.c = kq1Var.a();
                sa2Var.d = d;
                sa2Var.f = String.valueOf(b12.a());
                sa2Var.g = sa2.c(e43.M(), d);
                sa2Var.i = h;
                if (!b && !rp2.U().N()) {
                    z2 = false;
                    sa2Var.h = z2;
                    sa2Var.j = kq1Var.K();
                    sa2Var.l = wa2.b();
                    f0 = bp2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        sa2Var.m = f0.userActionApis;
                    }
                    H = d03.H();
                    if (H) {
                        sa2Var.k = h12.b();
                    }
                    P = bp2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            sa2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", sa2Var.toString());
                    }
                    jx2.o().F(new UbcFlowEvent("master_dispatch_start"));
                    ea3.d().i("master_dispatch_start");
                    a62Var.D(sa2Var);
                    ya2.U().U0(sa2.b(sa2Var));
                    ln2.m0().a();
                    ya2.U().h1(sa2Var.j);
                    F = d03.F(bp2Var.g0());
                    boolean p0 = bp2Var.p0();
                    if (!F) {
                        u12.d();
                        u12.g().h("appready");
                    } else if (p0) {
                        n12.e().f("appready");
                    }
                    t43 f = rp2.U().f(w73.b(wh3.f(d)));
                    va2Var = new va2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        va2Var.a = gVar.a;
                    } else {
                        va2Var.a = an2.e.i(bp2Var.H(), bp2Var.v1()).getPath() + File.separator;
                    }
                    va2Var.b = d;
                    va2Var.d = f.g;
                    va2Var.c = h;
                    va2Var.k = sa2Var.g;
                    va2Var.e = String.valueOf(bp2Var.m0());
                    va2Var.g = z2;
                    va2Var.i = kq1Var.K();
                    va2Var.m = true;
                    if (H) {
                        va2Var.j = h12.d();
                    }
                    if (!F) {
                        u12.g().h("pageready");
                    } else if (p0) {
                        n12.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", va2Var.toString());
                    }
                    jx2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    ea3.d().i("slave_dispatch_start");
                    kq1Var.L(va2Var);
                    lh3.d();
                    kq1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    kq1Var.R(d);
                    ya2.U().V0(kq1Var.a(), va2.a(va2Var));
                    oa3.F(kq1Var.a(), va2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + sa2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + kq1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + va2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + va2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + va2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                sa2Var.h = z2;
                sa2Var.j = kq1Var.K();
                sa2Var.l = wa2.b();
                f0 = bp2Var.f0();
                if (f0 != null) {
                    sa2Var.m = f0.userActionApis;
                }
                H = d03.H();
                if (H) {
                }
                P = bp2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                jx2.o().F(new UbcFlowEvent("master_dispatch_start"));
                ea3.d().i("master_dispatch_start");
                a62Var.D(sa2Var);
                ya2.U().U0(sa2.b(sa2Var));
                ln2.m0().a();
                ya2.U().h1(sa2Var.j);
                F = d03.F(bp2Var.g0());
                boolean p02 = bp2Var.p0();
                if (!F) {
                }
                t43 f2 = rp2.U().f(w73.b(wh3.f(d)));
                va2Var = new va2();
                if (gVar == null) {
                }
                va2Var.a = an2.e.i(bp2Var.H(), bp2Var.v1()).getPath() + File.separator;
                va2Var.b = d;
                va2Var.d = f2.g;
                va2Var.c = h;
                va2Var.k = sa2Var.g;
                va2Var.e = String.valueOf(bp2Var.m0());
                va2Var.g = z2;
                va2Var.i = kq1Var.K();
                va2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                jx2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                ea3.d().i("slave_dispatch_start");
                kq1Var.L(va2Var);
                lh3.d();
                kq1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                kq1Var.R(d);
                ya2.U().V0(kq1Var.a(), va2.a(va2Var));
                oa3.F(kq1Var.a(), va2Var.b);
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
        a62 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = cy2.b()) != 0 && (W = ya2.U().W()) != null) {
            if (b2 < 0) {
                W.p(b2);
            } else if (b2 == 1) {
                W.p(-4);
            } else {
                W.p(-2);
            }
        }
    }
}
