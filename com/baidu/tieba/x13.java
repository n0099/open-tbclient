package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class x13 extends y13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.y13
    public t13 f(u13 u13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u13Var)) == null) {
            return null;
        }
        return (t13) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y13
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, u13 u13Var, wb3 wb3Var, w72<v13> w72Var);

    /* loaded from: classes9.dex */
    public class a implements xm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u13 a;
        public final /* synthetic */ w72 b;
        public final /* synthetic */ x13 c;

        public a(x13 x13Var, u13 u13Var, w72 w72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x13Var, u13Var, w72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x13Var;
            this.a = u13Var;
            this.b = w72Var;
        }

        @Override // com.baidu.tieba.xm1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                v13 v13Var = new v13(this.a.f);
                v13Var.a = this.a.e;
                this.b.a(v13Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements dl3<wb3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k63 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ u13 c;
        public final /* synthetic */ w72 d;
        public final /* synthetic */ x13 e;

        public b(x13 x13Var, k63 k63Var, SwanAppActivity swanAppActivity, u13 u13Var, w72 w72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x13Var, k63Var, swanAppActivity, u13Var, w72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = x13Var;
            this.a = k63Var;
            this.b = swanAppActivity;
            this.c = u13Var;
            this.d = w72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(wb3 wb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wb3Var) == null) {
                this.e.p(this.b, this.a.P(), this.c, wb3Var, this.d);
            }
        }
    }

    public x13() {
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

    @Override // com.baidu.tieba.y13
    public ly1 j(String str, u13 u13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, u13Var)) == null) {
            return new ly1(0);
        }
        return (ly1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.y13
    public ly1 m(u13 u13Var, w72<v13> w72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, u13Var, w72Var)) == null) {
            if (u13Var != null && !TextUtils.isEmpty(u13Var.a)) {
                if (w72Var == null) {
                    return new ly1(1001, "get fun page info, cb is null");
                }
                k63 q = j63.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, u13Var, w72Var));
                        return new ly1(1001, "not login");
                    }
                    o(u13Var, w72Var);
                    return new ly1(0);
                }
                return new ly1(1001, "get fun page info, master has dead");
            }
            return new ly1(1001, "get fun page info, provider appKey is empty");
        }
        return (ly1) invokeLL.objValue;
    }

    public final void o(u13 u13Var, w72<v13> w72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, u13Var, w72Var) == null) {
            c23.b("start get open data");
            k63 q = j63.K().q();
            SwanAppActivity w = q.w();
            wb3.B(w, g(), u13Var.a, true, h(), new b(this, q, w, u13Var, w72Var));
        }
    }
}
