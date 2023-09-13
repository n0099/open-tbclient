package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class u63 extends v63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.v63
    public q63 f(r63 r63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r63Var)) == null) {
            return null;
        }
        return (q63) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v63
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, r63 r63Var, tg3 tg3Var, tc2<s63> tc2Var);

    /* loaded from: classes8.dex */
    public class a implements tr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r63 a;
        public final /* synthetic */ tc2 b;
        public final /* synthetic */ u63 c;

        public a(u63 u63Var, r63 r63Var, tc2 tc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u63Var, r63Var, tc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u63Var;
            this.a = r63Var;
            this.b = tc2Var;
        }

        @Override // com.baidu.tieba.tr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                s63 s63Var = new s63(this.a.f);
                s63Var.a = this.a.e;
                this.b.a(s63Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements aq3<tg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hb3 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ r63 c;
        public final /* synthetic */ tc2 d;
        public final /* synthetic */ u63 e;

        public b(u63 u63Var, hb3 hb3Var, SwanAppActivity swanAppActivity, r63 r63Var, tc2 tc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u63Var, hb3Var, swanAppActivity, r63Var, tc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = u63Var;
            this.a = hb3Var;
            this.b = swanAppActivity;
            this.c = r63Var;
            this.d = tc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(tg3 tg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tg3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, tg3Var, this.d);
            }
        }
    }

    public u63() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.v63
    public h32 j(String str, r63 r63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, r63Var)) == null) {
            return new h32(0);
        }
        return (h32) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.v63
    public h32 m(r63 r63Var, tc2<s63> tc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, r63Var, tc2Var)) == null) {
            if (r63Var != null && !TextUtils.isEmpty(r63Var.a)) {
                if (tc2Var == null) {
                    return new h32(1001, "get fun page info, cb is null");
                }
                hb3 q = gb3.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, r63Var, tc2Var));
                        return new h32(1001, "not login");
                    }
                    o(r63Var, tc2Var);
                    return new h32(0);
                }
                return new h32(1001, "get fun page info, master has dead");
            }
            return new h32(1001, "get fun page info, provider appKey is empty");
        }
        return (h32) invokeLL.objValue;
    }

    public final void o(r63 r63Var, tc2<s63> tc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, r63Var, tc2Var) == null) {
            z63.b("start get open data");
            hb3 q = gb3.K().q();
            SwanAppActivity w = q.w();
            tg3.B(w, g(), r63Var.a, true, h(), new b(this, q, w, r63Var, tc2Var));
        }
    }
}
