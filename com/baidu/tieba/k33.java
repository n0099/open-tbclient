package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class k33 extends l33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.l33
    public g33 f(h33 h33Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, h33Var)) == null) {
            return null;
        }
        return (g33) invokeL.objValue;
    }

    @Override // com.baidu.tieba.l33
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, h33 h33Var, jd3 jd3Var, j92<i33> j92Var);

    /* loaded from: classes5.dex */
    public class a implements jo1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h33 a;
        public final /* synthetic */ j92 b;
        public final /* synthetic */ k33 c;

        public a(k33 k33Var, h33 h33Var, j92 j92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k33Var, h33Var, j92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = k33Var;
            this.a = h33Var;
            this.b = j92Var;
        }

        @Override // com.baidu.tieba.jo1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                i33 i33Var = new i33(this.a.f);
                i33Var.a = this.a.e;
                this.b.a(i33Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qm3<jd3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x73 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ h33 c;
        public final /* synthetic */ j92 d;
        public final /* synthetic */ k33 e;

        public b(k33 k33Var, x73 x73Var, SwanAppActivity swanAppActivity, h33 h33Var, j92 j92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k33Var, x73Var, swanAppActivity, h33Var, j92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = k33Var;
            this.a = x73Var;
            this.b = swanAppActivity;
            this.c = h33Var;
            this.d = j92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(jd3 jd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jd3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, jd3Var, this.d);
            }
        }
    }

    public k33() {
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

    @Override // com.baidu.tieba.l33
    public xz1 j(String str, h33 h33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, h33Var)) == null) {
            return new xz1(0);
        }
        return (xz1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.l33
    public xz1 m(h33 h33Var, j92<i33> j92Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, h33Var, j92Var)) == null) {
            if (h33Var != null && !TextUtils.isEmpty(h33Var.a)) {
                if (j92Var == null) {
                    return new xz1(1001, "get fun page info, cb is null");
                }
                x73 q = w73.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, h33Var, j92Var));
                        return new xz1(1001, "not login");
                    }
                    o(h33Var, j92Var);
                    return new xz1(0);
                }
                return new xz1(1001, "get fun page info, master has dead");
            }
            return new xz1(1001, "get fun page info, provider appKey is empty");
        }
        return (xz1) invokeLL.objValue;
    }

    public final void o(h33 h33Var, j92<i33> j92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, h33Var, j92Var) == null) {
            p33.b("start get open data");
            x73 q = w73.K().q();
            SwanAppActivity w = q.w();
            jd3.B(w, g(), h33Var.a, true, h(), new b(this, q, w, h33Var, j92Var));
        }
    }
}
