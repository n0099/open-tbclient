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
public abstract class z43 extends a53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.a53
    public v43 f(w43 w43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w43Var)) == null) {
            return null;
        }
        return (v43) invokeL.objValue;
    }

    @Override // com.baidu.tieba.a53
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, w43 w43Var, ye3 ye3Var, ya2<x43> ya2Var);

    /* loaded from: classes7.dex */
    public class a implements yp1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w43 a;
        public final /* synthetic */ ya2 b;
        public final /* synthetic */ z43 c;

        public a(z43 z43Var, w43 w43Var, ya2 ya2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var, w43Var, ya2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z43Var;
            this.a = w43Var;
            this.b = ya2Var;
        }

        @Override // com.baidu.tieba.yp1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                x43 x43Var = new x43(this.a.f);
                x43Var.a = this.a.e;
                this.b.a(x43Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements fo3<ye3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m93 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ w43 c;
        public final /* synthetic */ ya2 d;
        public final /* synthetic */ z43 e;

        public b(z43 z43Var, m93 m93Var, SwanAppActivity swanAppActivity, w43 w43Var, ya2 ya2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z43Var, m93Var, swanAppActivity, w43Var, ya2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z43Var;
            this.a = m93Var;
            this.b = swanAppActivity;
            this.c = w43Var;
            this.d = ya2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(ye3 ye3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ye3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, ye3Var, this.d);
            }
        }
    }

    public z43() {
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

    @Override // com.baidu.tieba.a53
    public m12 j(String str, w43 w43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, w43Var)) == null) {
            return new m12(0);
        }
        return (m12) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.a53
    public m12 m(w43 w43Var, ya2<x43> ya2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, w43Var, ya2Var)) == null) {
            if (w43Var != null && !TextUtils.isEmpty(w43Var.a)) {
                if (ya2Var == null) {
                    return new m12(1001, "get fun page info, cb is null");
                }
                m93 q = l93.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, w43Var, ya2Var));
                        return new m12(1001, "not login");
                    }
                    o(w43Var, ya2Var);
                    return new m12(0);
                }
                return new m12(1001, "get fun page info, master has dead");
            }
            return new m12(1001, "get fun page info, provider appKey is empty");
        }
        return (m12) invokeLL.objValue;
    }

    public final void o(w43 w43Var, ya2<x43> ya2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, w43Var, ya2Var) == null) {
            e53.b("start get open data");
            m93 q = l93.K().q();
            SwanAppActivity w = q.w();
            ye3.B(w, g(), w43Var.a, true, h(), new b(this, q, w, w43Var, ya2Var));
        }
    }
}
