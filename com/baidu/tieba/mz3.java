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
import com.baidu.tieba.account.AccountRestoreActivity;
import com.baidu.tieba.b04;
import com.baidu.tieba.g03;
import com.baidu.tieba.u22;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mz3 extends kg2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;
    public long q;

    /* loaded from: classes5.dex */
    public class a implements fm2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz3 a;

        public a(mz3 mz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz3Var;
        }

        @Override // com.baidu.tieba.fm2
        public void a(int i, em2 em2Var) {
            b04.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, em2Var) == null) || (cVar = (b04.c) em2Var) == null || TextUtils.isEmpty(cVar.a)) {
                return;
            }
            lz3.m().I(this.a.Z());
            lz3.m().x(cVar);
            ox3.h();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements g03.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz3 a;

        public b(mz3 mz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz3Var;
        }

        @Override // com.baidu.tieba.g03.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i == 100) {
                    b03.e().h(new d03(4));
                    this.a.Q0();
                    lz3.m().H();
                    k33.K().s();
                    return true;
                } else if (i == 102) {
                    boolean a = sm2.M().a();
                    sm2.M().d(a);
                    if (this.a.b != null) {
                        this.a.b.x(a, false);
                    }
                    return true;
                } else if (i == 103) {
                    l33 M = l33.M();
                    if (M != null) {
                        M.e0().i();
                        hv2.g().v();
                    }
                    this.a.Q0();
                    lz3.m().H();
                    zw3.b();
                    return true;
                } else if (i == 106) {
                    k33.K().s();
                    return true;
                } else if (i != 107) {
                    switch (i) {
                        case 123:
                            rf3.r(message);
                            return true;
                        case 124:
                            rf3.q(message);
                            return true;
                        case 125:
                            e03.b(message);
                            return true;
                        case 126:
                            e03.d(message);
                            return true;
                        default:
                            return false;
                    }
                } else {
                    n62.a(message);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz3 a;

        public c(mz3 mz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (mz3.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                this.a.q = System.currentTimeMillis();
                i44.f(this.a.Z());
                this.a.b.O();
                qw2.h("preload", "startup");
                int j = lz3.m().j();
                HybridUbcFlow p = qw2.p("startup");
                p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.D("codecache", String.valueOf(j));
                p.F(new UbcFlowEvent("na_first_paint"));
                p.A();
                long f = p.f("na_first_paint", "naStart");
                lz3.m().i(new l14(f));
                if (mz3.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + f);
                }
                y54.A().D();
                c04.f().init();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz3 a;

        public d(mz3 mz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i1();
                this.a.h1();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947989923, "Lcom/baidu/tieba/mz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947989923, "Lcom/baidu/tieba/mz3;");
                return;
            }
        }
        r = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mz3(SwanAppActivity swanAppActivity, String str) {
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

    @Override // com.baidu.tieba.kg2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.kg2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.kg2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            ea3.E();
            if (z2) {
                i44.f(Z());
                zw3.b();
            }
        }
    }

    @Override // com.baidu.tieba.kg2
    @NonNull
    public g03.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new b(this) : (g03.c) invokeV.objValue;
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l1();
            if (k33.K().E()) {
                yo2.U().E(Z(), new a(this));
                if (lz3.m().v() && lz3.m().q()) {
                    lz3.m().F(this.b);
                }
            }
        }
    }

    public long f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.longValue;
    }

    @Override // com.baidu.tieba.kg2
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? k33.K().q().Y().d0() == 1 : invokeV.booleanValue;
    }

    public ta2 g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? lz3.m().n() : (ta2) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            y54.A().m();
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            y54.A().F();
        }
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.q > 0 : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.t33, com.baidu.tieba.o33
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.kg2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            l02.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            oa3 oa3Var = new oa3();
            oa3Var.e = "back";
            Q(oa3Var);
            r22 m = this.c.m();
            if (m == null || !m.I()) {
                if (e0()) {
                    l33 M = l33.M();
                    if (M != null) {
                        M.P().E();
                    }
                    i44.e("back", Z());
                    zw3.g("0");
                    return;
                }
                u22.b i = this.c.i("navigateBack");
                i.n(u22.i, u22.h);
                i.g();
                i.a();
            }
        }
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            fh3.e0(new c(this));
            ExecutorUtilsExt.postOnElastic(new d(this), "SwanGameFrameRequestAd", 2);
            a64.q();
            z54.b();
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.q = 0L;
        }
    }

    @Override // com.baidu.tieba.kg2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            m1();
            c44.c().b();
            z14.b().e();
            q().J(true);
            e1();
            V8Engine.setCrashKeyValue("game_title", Z() == null ? "" : Z().K());
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && q().I()) {
            if (ah3.f(Z().a0())) {
                if (r) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + Z().a0());
                }
                lz3.C();
                return;
            }
            SwanCoreVersion j0 = Z().j0();
            if (j0 != null && ah3.f(j0.swanCoreVersionName) && ho2.a(Z().S())) {
                if (r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                lz3.C();
            }
        }
    }

    @Override // com.baidu.tieba.kg2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            yw3.v();
            qf2.i();
            i44.e(AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, Z());
            yo2.U().unregisterReceiver(this.b);
            yo2.b0();
            r54.a().b();
            SwanInspectorEndpoint.v().q();
            c44.c().b();
            z14.b().e();
        }
    }

    @Override // com.baidu.tieba.kg2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.s0();
            lz3.m().h(this.b);
        }
    }

    @Override // com.baidu.tieba.kg2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.baidu.tieba.kg2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            yo2.U().registerReceiver(this.b);
        }
    }

    @Override // com.baidu.tieba.kg2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.baidu.tieba.kg2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }
}
