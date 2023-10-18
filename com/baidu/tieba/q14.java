package com.baidu.tieba;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.tieba.f24;
import com.baidu.tieba.k23;
import com.baidu.tieba.y42;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q14 extends oi2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;
    public long q;

    @Override // com.baidu.tieba.oi2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.oi2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.x53, com.baidu.tieba.s53
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.oi2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.baidu.tieba.oi2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.baidu.tieba.oi2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements jo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q14 a;

        public a(q14 q14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q14Var;
        }

        @Override // com.baidu.tieba.jo2
        public void a(int i, io2 io2Var) {
            f24.c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, io2Var) == null) && (cVar = (f24.c) io2Var) != null && !TextUtils.isEmpty(cVar.a)) {
                p14.m().I(this.a.Z());
                p14.m().x(cVar);
                sz3.h();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements k23.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q14 a;

        public b(q14 q14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q14Var;
        }

        @Override // com.baidu.tieba.k23.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i != 100) {
                    if (i != 102) {
                        if (i != 103) {
                            if (i != 106) {
                                if (i != 107) {
                                    switch (i) {
                                        case 123:
                                            vh3.r(message);
                                            return true;
                                        case 124:
                                            vh3.q(message);
                                            return true;
                                        case 125:
                                            i23.b(message);
                                            return true;
                                        case 126:
                                            i23.d(message);
                                            return true;
                                        default:
                                            return false;
                                    }
                                }
                                r82.a(message);
                                return true;
                            }
                            o53.K().s();
                            return true;
                        }
                        p53 M = p53.M();
                        if (M != null) {
                            M.f0().i();
                            lx2.g().v();
                        }
                        this.a.Q0();
                        p14.m().H();
                        dz3.b();
                        return true;
                    }
                    boolean a = wo2.M().a();
                    wo2.M().d(a);
                    if (this.a.b != null) {
                        this.a.b.y(a, false);
                    }
                    return true;
                }
                f23.e().h(new h23(4));
                this.a.Q0();
                p14.m().H();
                o53.K().s();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q14 a;

        public c(q14 q14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q14Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (q14.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                this.a.q = System.currentTimeMillis();
                m64.f(this.a.Z());
                this.a.b.O();
                uy2.h("preload", "startup");
                int j = p14.m().j();
                HybridUbcFlow p = uy2.p("startup");
                p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.D("codecache", String.valueOf(j));
                p.F(new UbcFlowEvent("na_first_paint"));
                p.A();
                long f = p.f("na_first_paint", "naStart");
                p14.m().i(new p34(f));
                if (q14.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + f);
                }
                c84.A().D();
                g24.f().init();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q14 a;

        public d(q14 q14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q14Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.j1();
            this.a.i1();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948038965, "Lcom/baidu/tieba/q14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948038965, "Lcom/baidu/tieba/q14;");
                return;
            }
        }
        r = am1.a;
    }

    @Override // com.baidu.tieba.oi2
    @NonNull
    public k23.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new b(this);
        }
        return (k23.c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oi2
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (o53.K().q().Z().e0() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public long g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.q;
        }
        return invokeV.longValue;
    }

    public xc2 h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return p14.m().n();
        }
        return (xc2) invokeV.objValue;
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c84.A().m();
        }
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c84.A().F();
        }
    }

    public boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.q > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            jj3.e0(new c(this));
            ExecutorUtilsExt.postOnElastic(new d(this), "SwanGameFrameRequestAd", 2);
            e84.q();
            d84.b();
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.q = 0L;
        }
    }

    @Override // com.baidu.tieba.oi2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.s0();
            p14.m().h(this.b);
        }
    }

    @Override // com.baidu.tieba.oi2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            cr2.V().E(this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q14(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((SwanAppActivity) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.oi2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            ic3.E();
            if (z2) {
                m64.f(Z());
                dz3.b();
            }
        }
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            m1();
            if (!o53.K().E()) {
                return;
            }
            cr2.V().G(Z(), new a(this));
            if (p14.m().v() && p14.m().q()) {
                p14.m().F(this.b);
            }
        }
    }

    @Override // com.baidu.tieba.oi2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            cz3.w();
            uh2.i();
            m64.e("exit", Z());
            cr2.V().l(this.b);
            cr2.c0();
            v74.a().b();
            SwanInspectorEndpoint.v().q();
            g64.c().b();
            d44.b().e();
        }
    }

    @Override // com.baidu.tieba.oi2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            p22.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            sc3 sc3Var = new sc3();
            sc3Var.e = "back";
            Q(sc3Var);
            v42 m = this.c.m();
            if (m != null && m.G()) {
                return;
            }
            if (e0()) {
                p53 M = p53.M();
                if (M != null) {
                    M.Q().E();
                }
                m64.e("back", Z());
                dz3.g("0");
                return;
            }
            y42.b i = this.c.i("navigateBack");
            i.n(y42.i, y42.h);
            i.g();
            i.a();
        }
    }

    public final void n1() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !q().I()) {
            return;
        }
        if (ej3.f(Z().b0())) {
            if (r) {
                Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + Z().b0());
            }
            p14.C();
            return;
        }
        SwanCoreVersion k0 = Z().k0();
        if (k0 != null && ej3.f(k0.swanCoreVersionName) && lq2.a(Z().T())) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r) {
                Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
            }
            p14.C();
        }
    }

    @Override // com.baidu.tieba.oi2
    public void m0() {
        String L;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            n1();
            g64.c().b();
            d44.b().e();
            q().J(true);
            f1();
            if (Z() == null) {
                L = "";
            } else {
                L = Z().L();
            }
            V8Engine.setCrashKeyValue("game_title", L);
        }
    }
}
