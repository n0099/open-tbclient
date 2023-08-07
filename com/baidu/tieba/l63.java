package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class l63 extends m63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.m63
    public h63 f(i63 i63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i63Var)) == null) {
            return null;
        }
        return (h63) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m63
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, i63 i63Var, kg3 kg3Var, kc2<j63> kc2Var);

    /* loaded from: classes6.dex */
    public class a implements kr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i63 a;
        public final /* synthetic */ kc2 b;
        public final /* synthetic */ l63 c;

        public a(l63 l63Var, i63 i63Var, kc2 kc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l63Var, i63Var, kc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l63Var;
            this.a = i63Var;
            this.b = kc2Var;
        }

        @Override // com.baidu.tieba.kr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                j63 j63Var = new j63(this.a.f);
                j63Var.a = this.a.e;
                this.b.a(j63Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements rp3<kg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya3 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ i63 c;
        public final /* synthetic */ kc2 d;
        public final /* synthetic */ l63 e;

        public b(l63 l63Var, ya3 ya3Var, SwanAppActivity swanAppActivity, i63 i63Var, kc2 kc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l63Var, ya3Var, swanAppActivity, i63Var, kc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = l63Var;
            this.a = ya3Var;
            this.b = swanAppActivity;
            this.c = i63Var;
            this.d = kc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(kg3 kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, kg3Var, this.d);
            }
        }
    }

    public l63() {
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

    @Override // com.baidu.tieba.m63
    public y22 j(String str, i63 i63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i63Var)) == null) {
            return new y22(0);
        }
        return (y22) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.m63
    public y22 m(i63 i63Var, kc2<j63> kc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, i63Var, kc2Var)) == null) {
            if (i63Var != null && !TextUtils.isEmpty(i63Var.a)) {
                if (kc2Var == null) {
                    return new y22(1001, "get fun page info, cb is null");
                }
                ya3 q = xa3.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, i63Var, kc2Var));
                        return new y22(1001, "not login");
                    }
                    o(i63Var, kc2Var);
                    return new y22(0);
                }
                return new y22(1001, "get fun page info, master has dead");
            }
            return new y22(1001, "get fun page info, provider appKey is empty");
        }
        return (y22) invokeLL.objValue;
    }

    public final void o(i63 i63Var, kc2<j63> kc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, i63Var, kc2Var) == null) {
            q63.b("start get open data");
            ya3 q = xa3.K().q();
            SwanAppActivity w = q.w();
            kg3.B(w, g(), i63Var.a, true, h(), new b(this, q, w, i63Var, kc2Var));
        }
    }
}
