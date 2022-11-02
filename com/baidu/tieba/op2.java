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
import com.baidu.tieba.an2;
import com.baidu.tieba.bp2;
import com.baidu.tieba.t73;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class op2 extends np2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes5.dex */
    public class b implements ym2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bp2 a;
        public final /* synthetic */ op2 b;

        /* loaded from: classes5.dex */
        public class a implements t73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ an2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, an2.g gVar) {
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

            @Override // com.baidu.tieba.t73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    e12.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.t73.e
            public void b(int i, xf3 xf3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, xf3Var) == null) {
                    e12.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    xf3 xf3Var2 = new xf3();
                    xf3Var2.k(5L);
                    xf3Var2.i(38L);
                    xf3Var2.f("download subpackage fail, errcode=" + i);
                    fb3 fb3Var = new fb3();
                    fb3Var.q(xa3.n(this.c.a.G()));
                    fb3Var.p(xf3Var2);
                    fb3Var.r(this.c.a);
                    xa3.R(fb3Var);
                }
            }
        }

        public b(op2 op2Var, bp2 bp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {op2Var, bp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = op2Var;
            this.a = bp2Var;
        }

        @Override // com.baidu.tieba.ym2
        public void a(int i, xm2 xm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, xm2Var) == null) {
                an2.g gVar = (an2.g) xm2Var;
                if (t73.p(this.a, gVar)) {
                    if (e43.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = wh3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(w73.b(f));
                        t73.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    e12.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(op2 op2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {op2Var, Long.valueOf(j)};
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
                xh3.g(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bp2 a;

        public c(op2 op2Var, bp2 bp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {op2Var, bp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bp2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                an2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bp2 a;
        public final /* synthetic */ an2.g b;
        public final /* synthetic */ op2 c;

        public d(op2 op2Var, bp2 bp2Var, an2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {op2Var, bp2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = op2Var;
            this.a = bp2Var;
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

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bp2 a;

        public e(op2 op2Var, bp2 bp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {op2Var, bp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bp2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && ln2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948039864, "Lcom/baidu/tieba/op2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948039864, "Lcom/baidu/tieba/op2;");
                return;
            }
        }
        l = ok1.a;
    }

    public op2() {
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

    @Override // com.baidu.tieba.np2, com.baidu.tieba.pp2
    @Nullable
    public e43 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return e43.M();
        }
        return (e43) invokeV.objValue;
    }

    @Override // com.baidu.tieba.np2, com.baidu.tieba.pp2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ya2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.np2, com.baidu.tieba.pp2
    public void E(bp2 bp2Var, ym2 ym2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bp2Var, ym2Var) == null) {
            super.E(bp2Var, ym2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bp2Var.j0());
            }
            an2.c(bp2Var, new b(this, bp2Var));
            ya2.U().d1(bp2Var);
            ya2.U().c1(bp2Var);
            ya2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.np2, com.baidu.tieba.pp2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            ja2.d();
            ya2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            rg3.j();
            dr2.b();
            us2.y();
            bf3.u();
            PaymentPanelManager.F();
            de3.n();
            qd3.d();
            me3.k();
            kh2.d();
            jg4.f();
            su2.e().o();
            u63.h();
            wd3.h();
            ru2.k();
            if (ln2.I() != null) {
                ln2.I().e();
            }
            vu1.e().n();
            nw1.b().f();
            r63.b().k();
            vi2.d();
            qv1.d().h();
            ju2.g().f();
            ta2.b();
            xo2.c().a();
            yy2.g().b();
            SwanPrefetchImageRes.b().e();
            d82.g().d();
            e22.c().n();
            wj3.c().i();
        }
    }

    @Override // com.baidu.tieba.np2, com.baidu.tieba.pp2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            e12.i("SwanApp", "onAppForeground");
            String g0 = e43.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", ey2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                bp2.a S = this.d.S();
                oa3.v(S);
                Z(S);
            }
            u(new ge2(hashMap));
            e12.i("SwanApp", "onAppShow");
            nw1.b().g(false);
            dr2.h(true);
            us2.r(false);
            su2.e().h(false);
            vu1.e().j();
            ru2.i();
            if (ln2.I() != null) {
                ln2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (fy2.h()) {
                xx2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                yg3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    public final void X(int i, bp2 bp2Var, an2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048580, this, i, bp2Var, gVar) == null) && i == 0 && bp2Var != null && gVar != null) {
            jx2.o().F(new UbcFlowEvent("na_post_to_main_start"));
            yh3.d0(this.k);
            d dVar = new d(this, bp2Var, gVar);
            this.k = dVar;
            yh3.g0(dVar);
        }
    }

    public final void Y(bp2 bp2Var, an2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bp2Var, gVar) == null) {
            jx2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            ea3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + rp2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (bp2Var.m0()) {
                n(this.d).setVisibility(0);
                b12.b(true);
                e12.i("AppsControllerImpl", "init sConsole for devHook");
            }
            e12.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            ya2.U().Z0(bp2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.np2, com.baidu.tieba.pp2
    public void d(bp2 bp2Var, ym2 ym2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bp2Var, ym2Var) == null) {
            super.d(bp2Var, ym2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bp2Var.j0());
            }
            ya2.U().d1(bp2Var);
            ya2.U().H0(null);
            SwanAppConfigData Q = d43.K().q().Q();
            if (Q != null) {
                an2.g gVar = new an2.g();
                xx2.e().d(new c(this, bp2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = an2.e.i(bp2Var.H(), bp2Var.v1()).getPath() + File.separator;
                jx2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                ea3.d().i("na_post_to_main_start");
                Y(bp2Var, gVar);
            }
        }
    }

    public final void Z(bp2 bp2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bp2Var) == null) && !TextUtils.isEmpty(bp2Var.n("fromHost")) && !TextUtils.isEmpty(bp2Var.n("spuId")) && !TextUtils.isEmpty(bp2Var.n("contentId"))) {
            yh3.b0(new e(this, bp2Var), 2000L);
        }
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            d43 K = d43.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.pp2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = rp2.U().S();
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

    @Override // com.baidu.tieba.np2, com.baidu.tieba.pp2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            e12.i("SwanApp", "onAppBackground");
            String g0 = e43.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(gi3.b().a()));
            u(new ge2(contentValues));
            e12.i("SwanApp", "onAppHide");
            gi3.b().d();
            nw1.b().g(true);
            dr2.h(false);
            us2.r(true);
            su2.e().h(true);
            ru2.j(false);
            if (ln2.I() != null) {
                ln2.I().c();
            }
            xh3.h();
            cu2.i();
        }
    }
}
