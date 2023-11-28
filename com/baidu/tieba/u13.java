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
public abstract class u13 extends v13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.v13
    public q13 f(r13 r13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r13Var)) == null) {
            return null;
        }
        return (q13) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v13
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, r13 r13Var, tb3 tb3Var, t72<s13> t72Var);

    /* loaded from: classes8.dex */
    public class a implements um1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r13 a;
        public final /* synthetic */ t72 b;
        public final /* synthetic */ u13 c;

        public a(u13 u13Var, r13 r13Var, t72 t72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u13Var, r13Var, t72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u13Var;
            this.a = r13Var;
            this.b = t72Var;
        }

        @Override // com.baidu.tieba.um1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                s13 s13Var = new s13(this.a.f);
                s13Var.a = this.a.e;
                this.b.a(s13Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements al3<tb3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h63 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ r13 c;
        public final /* synthetic */ t72 d;
        public final /* synthetic */ u13 e;

        public b(u13 u13Var, h63 h63Var, SwanAppActivity swanAppActivity, r13 r13Var, t72 t72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u13Var, h63Var, swanAppActivity, r13Var, t72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = u13Var;
            this.a = h63Var;
            this.b = swanAppActivity;
            this.c = r13Var;
            this.d = t72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(tb3 tb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tb3Var) == null) {
                this.e.p(this.b, this.a.P(), this.c, tb3Var, this.d);
            }
        }
    }

    public u13() {
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

    @Override // com.baidu.tieba.v13
    public iy1 j(String str, r13 r13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, r13Var)) == null) {
            return new iy1(0);
        }
        return (iy1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.v13
    public iy1 m(r13 r13Var, t72<s13> t72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, r13Var, t72Var)) == null) {
            if (r13Var != null && !TextUtils.isEmpty(r13Var.a)) {
                if (t72Var == null) {
                    return new iy1(1001, "get fun page info, cb is null");
                }
                h63 q = g63.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, r13Var, t72Var));
                        return new iy1(1001, "not login");
                    }
                    o(r13Var, t72Var);
                    return new iy1(0);
                }
                return new iy1(1001, "get fun page info, master has dead");
            }
            return new iy1(1001, "get fun page info, provider appKey is empty");
        }
        return (iy1) invokeLL.objValue;
    }

    public final void o(r13 r13Var, t72<s13> t72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, r13Var, t72Var) == null) {
            z13.b("start get open data");
            h63 q = g63.K().q();
            SwanAppActivity w = q.w();
            tb3.B(w, g(), r13Var.a, true, h(), new b(this, q, w, r13Var, t72Var));
        }
    }
}
