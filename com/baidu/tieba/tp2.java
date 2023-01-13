package com.baidu.tieba;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.fn2;
import com.baidu.tieba.gp2;
import com.baidu.tieba.y73;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class tp2 extends sp2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes6.dex */
    public class b implements dn2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp2 a;
        public final /* synthetic */ tp2 b;

        /* loaded from: classes6.dex */
        public class a implements y73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ fn2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, fn2.g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i), gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = i;
                this.b = gVar;
            }

            @Override // com.baidu.tieba.y73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    j12.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.y73.e
            public void b(int i, cg3 cg3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cg3Var) == null) {
                    j12.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    cg3 cg3Var2 = new cg3();
                    cg3Var2.k(5L);
                    cg3Var2.i(38L);
                    cg3Var2.f("download subpackage fail, errcode=" + i);
                    kb3 kb3Var = new kb3();
                    kb3Var.q(cb3.n(this.c.a.G()));
                    kb3Var.p(cg3Var2);
                    kb3Var.r(this.c.a);
                    cb3.R(kb3Var);
                }
            }
        }

        public b(tp2 tp2Var, gp2 gp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp2Var, gp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tp2Var;
            this.a = gp2Var;
        }

        @Override // com.baidu.tieba.dn2
        public void a(int i, cn2 cn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, cn2Var) == null) {
                fn2.g gVar = (fn2.g) cn2Var;
                if (y73.p(this.a, gVar)) {
                    if (j43.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = bi3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(b83.b(f));
                        y73.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    j12.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(tp2 tp2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp2Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ci3.g(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp2 a;

        public c(tp2 tp2Var, gp2 gp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp2Var, gp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fn2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp2 a;
        public final /* synthetic */ fn2.g b;
        public final /* synthetic */ tp2 c;

        public d(tp2 tp2Var, gp2 gp2Var, fn2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp2Var, gp2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tp2Var;
            this.a = gp2Var;
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.Y(this.a, this.b);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp2 a;

        public e(tp2 tp2Var, gp2 gp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp2Var, gp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && qn2.s0().a(n, n2, n3)) {
                    this.a.z("fromHost", null);
                    this.a.z("spuId", null);
                    this.a.z("contentId", null);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948188819, "Lcom/baidu/tieba/tp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948188819, "Lcom/baidu/tieba/tp2;");
                return;
            }
        }
        l = tk1.a;
    }

    public tp2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.sp2, com.baidu.tieba.up2
    @Nullable
    public j43 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return j43.M();
        }
        return (j43) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sp2, com.baidu.tieba.up2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return db2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sp2, com.baidu.tieba.up2
    public void E(gp2 gp2Var, dn2 dn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gp2Var, dn2Var) == null) {
            super.E(gp2Var, dn2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + gp2Var.j0());
            }
            fn2.c(gp2Var, new b(this, gp2Var));
            db2.U().d1(gp2Var);
            db2.U().c1(gp2Var);
            db2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.sp2, com.baidu.tieba.up2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            oa2.d();
            db2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            wg3.j();
            ir2.b();
            zs2.y();
            gf3.u();
            PaymentPanelManager.F();
            ie3.n();
            vd3.d();
            re3.k();
            ph2.d();
            og4.f();
            xu2.e().o();
            z63.h();
            be3.h();
            wu2.k();
            if (qn2.I() != null) {
                qn2.I().e();
            }
            av1.e().n();
            sw1.b().f();
            w63.b().k();
            aj2.d();
            vv1.d().h();
            ou2.g().f();
            ya2.b();
            cp2.c().a();
            dz2.g().b();
            SwanPrefetchImageRes.b().e();
            i82.g().d();
            j22.c().n();
            bk3.c().i();
        }
    }

    public final void X(int i, gp2 gp2Var, fn2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048580, this, i, gp2Var, gVar) == null) && i == 0 && gp2Var != null && gVar != null) {
            ox2.o().F(new UbcFlowEvent("na_post_to_main_start"));
            di3.d0(this.k);
            d dVar = new d(this, gp2Var, gVar);
            this.k = dVar;
            di3.g0(dVar);
        }
    }

    public final void Y(gp2 gp2Var, fn2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gp2Var, gVar) == null) {
            ox2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            ja3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + wp2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (gp2Var.m0()) {
                n(this.d).setVisibility(0);
                g12.b(true);
                j12.i("AppsControllerImpl", "init sConsole for devHook");
            }
            j12.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            db2.U().Z0(gp2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.sp2, com.baidu.tieba.up2
    public void d(gp2 gp2Var, dn2 dn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gp2Var, dn2Var) == null) {
            super.d(gp2Var, dn2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + gp2Var.j0());
            }
            db2.U().d1(gp2Var);
            db2.U().H0(null);
            SwanAppConfigData Q = i43.K().q().Q();
            if (Q != null) {
                fn2.g gVar = new fn2.g();
                cy2.e().d(new c(this, gp2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = fn2.e.i(gp2Var.H(), gp2Var.v1()).getPath() + File.separator;
                ox2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                ja3.d().i("na_post_to_main_start");
                Y(gp2Var, gVar);
            }
        }
    }

    public final void Z(gp2 gp2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, gp2Var) == null) && !TextUtils.isEmpty(gp2Var.n("fromHost")) && !TextUtils.isEmpty(gp2Var.n("spuId")) && !TextUtils.isEmpty(gp2Var.n("contentId"))) {
            di3.b0(new e(this, gp2Var), 2000L);
        }
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            i43 K = i43.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.up2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = wp2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            if (this.h && S <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.sp2, com.baidu.tieba.up2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            j12.i("SwanApp", "onAppForeground");
            String g0 = j43.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", jy2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                gp2.a S = this.d.S();
                ta3.v(S);
                Z(S);
            }
            u(new le2(hashMap));
            j12.i("SwanApp", "onAppShow");
            sw1.b().g(false);
            ir2.h(true);
            zs2.r(false);
            xu2.e().h(false);
            av1.e().j();
            wu2.i();
            if (qn2.I() != null) {
                qn2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (ky2.h()) {
                cy2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                dh3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.baidu.tieba.sp2, com.baidu.tieba.up2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            j12.i("SwanApp", "onAppBackground");
            String g0 = j43.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(li3.b().a()));
            u(new le2(contentValues));
            j12.i("SwanApp", "onAppHide");
            li3.b().d();
            sw1.b().g(true);
            ir2.h(false);
            zs2.r(true);
            xu2.e().h(true);
            wu2.j(false);
            if (qn2.I() != null) {
                qn2.I().c();
            }
            ci3.h();
            hu2.i();
        }
    }
}
