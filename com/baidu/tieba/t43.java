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
public abstract class t43 extends u43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.u43
    public p43 f(q43 q43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, q43Var)) == null) {
            return null;
        }
        return (p43) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u43
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, q43 q43Var, se3 se3Var, sa2<r43> sa2Var);

    /* loaded from: classes7.dex */
    public class a implements sp1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q43 a;
        public final /* synthetic */ sa2 b;
        public final /* synthetic */ t43 c;

        public a(t43 t43Var, q43 q43Var, sa2 sa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t43Var, q43Var, sa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t43Var;
            this.a = q43Var;
            this.b = sa2Var;
        }

        @Override // com.baidu.tieba.sp1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                r43 r43Var = new r43(this.a.f);
                r43Var.a = this.a.e;
                this.b.a(r43Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements zn3<se3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g93 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ q43 c;
        public final /* synthetic */ sa2 d;
        public final /* synthetic */ t43 e;

        public b(t43 t43Var, g93 g93Var, SwanAppActivity swanAppActivity, q43 q43Var, sa2 sa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t43Var, g93Var, swanAppActivity, q43Var, sa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = t43Var;
            this.a = g93Var;
            this.b = swanAppActivity;
            this.c = q43Var;
            this.d = sa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(se3 se3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, se3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, se3Var, this.d);
            }
        }
    }

    public t43() {
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

    @Override // com.baidu.tieba.u43
    public g12 j(String str, q43 q43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, q43Var)) == null) {
            return new g12(0);
        }
        return (g12) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.u43
    public g12 m(q43 q43Var, sa2<r43> sa2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, q43Var, sa2Var)) == null) {
            if (q43Var != null && !TextUtils.isEmpty(q43Var.a)) {
                if (sa2Var == null) {
                    return new g12(1001, "get fun page info, cb is null");
                }
                g93 q = f93.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, q43Var, sa2Var));
                        return new g12(1001, "not login");
                    }
                    o(q43Var, sa2Var);
                    return new g12(0);
                }
                return new g12(1001, "get fun page info, master has dead");
            }
            return new g12(1001, "get fun page info, provider appKey is empty");
        }
        return (g12) invokeLL.objValue;
    }

    public final void o(q43 q43Var, sa2<r43> sa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, q43Var, sa2Var) == null) {
            y43.b("start get open data");
            g93 q = f93.K().q();
            SwanAppActivity w = q.w();
            se3.B(w, g(), q43Var.a, true, h(), new b(this, q, w, q43Var, sa2Var));
        }
    }
}
