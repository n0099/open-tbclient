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
public abstract class t13 extends u13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.u13
    public p13 f(q13 q13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, q13Var)) == null) {
            return null;
        }
        return (p13) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u13
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, q13 q13Var, sb3 sb3Var, s72<r13> s72Var);

    /* loaded from: classes8.dex */
    public class a implements tm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q13 a;
        public final /* synthetic */ s72 b;
        public final /* synthetic */ t13 c;

        public a(t13 t13Var, q13 q13Var, s72 s72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t13Var, q13Var, s72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t13Var;
            this.a = q13Var;
            this.b = s72Var;
        }

        @Override // com.baidu.tieba.tm1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                r13 r13Var = new r13(this.a.f);
                r13Var.a = this.a.e;
                this.b.a(r13Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements zk3<sb3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ q13 c;
        public final /* synthetic */ s72 d;
        public final /* synthetic */ t13 e;

        public b(t13 t13Var, g63 g63Var, SwanAppActivity swanAppActivity, q13 q13Var, s72 s72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t13Var, g63Var, swanAppActivity, q13Var, s72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = t13Var;
            this.a = g63Var;
            this.b = swanAppActivity;
            this.c = q13Var;
            this.d = s72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(sb3 sb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb3Var) == null) {
                this.e.p(this.b, this.a.P(), this.c, sb3Var, this.d);
            }
        }
    }

    public t13() {
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

    @Override // com.baidu.tieba.u13
    public hy1 j(String str, q13 q13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, q13Var)) == null) {
            return new hy1(0);
        }
        return (hy1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.u13
    public hy1 m(q13 q13Var, s72<r13> s72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, q13Var, s72Var)) == null) {
            if (q13Var != null && !TextUtils.isEmpty(q13Var.a)) {
                if (s72Var == null) {
                    return new hy1(1001, "get fun page info, cb is null");
                }
                g63 q = f63.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, q13Var, s72Var));
                        return new hy1(1001, "not login");
                    }
                    o(q13Var, s72Var);
                    return new hy1(0);
                }
                return new hy1(1001, "get fun page info, master has dead");
            }
            return new hy1(1001, "get fun page info, provider appKey is empty");
        }
        return (hy1) invokeLL.objValue;
    }

    public final void o(q13 q13Var, s72<r13> s72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, q13Var, s72Var) == null) {
            y13.b("start get open data");
            g63 q = f63.K().q();
            SwanAppActivity w = q.w();
            sb3.B(w, g(), q13Var.a, true, h(), new b(this, q, w, q13Var, s72Var));
        }
    }
}
