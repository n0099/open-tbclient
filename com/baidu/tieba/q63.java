package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class q63 extends r63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.r63
    public m63 f(n63 n63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, n63Var)) == null) {
            return null;
        }
        return (m63) invokeL.objValue;
    }

    @Override // com.baidu.tieba.r63
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, n63 n63Var, pg3 pg3Var, pc2<o63> pc2Var);

    /* loaded from: classes7.dex */
    public class a implements pr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n63 a;
        public final /* synthetic */ pc2 b;
        public final /* synthetic */ q63 c;

        public a(q63 q63Var, n63 n63Var, pc2 pc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q63Var, n63Var, pc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q63Var;
            this.a = n63Var;
            this.b = pc2Var;
        }

        @Override // com.baidu.tieba.pr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                o63 o63Var = new o63(this.a.f);
                o63Var.a = this.a.e;
                this.b.a(o63Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements wp3<pg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db3 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ n63 c;
        public final /* synthetic */ pc2 d;
        public final /* synthetic */ q63 e;

        public b(q63 q63Var, db3 db3Var, SwanAppActivity swanAppActivity, n63 n63Var, pc2 pc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q63Var, db3Var, swanAppActivity, n63Var, pc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = q63Var;
            this.a = db3Var;
            this.b = swanAppActivity;
            this.c = n63Var;
            this.d = pc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(pg3 pg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pg3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, pg3Var, this.d);
            }
        }
    }

    public q63() {
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

    @Override // com.baidu.tieba.r63
    public d32 j(String str, n63 n63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, n63Var)) == null) {
            return new d32(0);
        }
        return (d32) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.r63
    public d32 m(n63 n63Var, pc2<o63> pc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, n63Var, pc2Var)) == null) {
            if (n63Var != null && !TextUtils.isEmpty(n63Var.a)) {
                if (pc2Var == null) {
                    return new d32(1001, "get fun page info, cb is null");
                }
                db3 q = cb3.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, n63Var, pc2Var));
                        return new d32(1001, "not login");
                    }
                    o(n63Var, pc2Var);
                    return new d32(0);
                }
                return new d32(1001, "get fun page info, master has dead");
            }
            return new d32(1001, "get fun page info, provider appKey is empty");
        }
        return (d32) invokeLL.objValue;
    }

    public final void o(n63 n63Var, pc2<o63> pc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, n63Var, pc2Var) == null) {
            v63.b("start get open data");
            db3 q = cb3.K().q();
            SwanAppActivity w = q.w();
            pg3.B(w, g(), n63Var.a, true, h(), new b(this, q, w, n63Var, pc2Var));
        }
    }
}
