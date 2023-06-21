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
public abstract class m73 extends n73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.n73
    public i73 f(j73 j73Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, j73Var)) == null) {
            return null;
        }
        return (i73) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n73
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, j73 j73Var, lh3 lh3Var, ld2<k73> ld2Var);

    /* loaded from: classes6.dex */
    public class a implements ls1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j73 a;
        public final /* synthetic */ ld2 b;
        public final /* synthetic */ m73 c;

        public a(m73 m73Var, j73 j73Var, ld2 ld2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m73Var, j73Var, ld2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m73Var;
            this.a = j73Var;
            this.b = ld2Var;
        }

        @Override // com.baidu.tieba.ls1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                k73 k73Var = new k73(this.a.f);
                k73Var.a = this.a.e;
                this.b.a(k73Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements sq3<lh3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zb3 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ j73 c;
        public final /* synthetic */ ld2 d;
        public final /* synthetic */ m73 e;

        public b(m73 m73Var, zb3 zb3Var, SwanAppActivity swanAppActivity, j73 j73Var, ld2 ld2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m73Var, zb3Var, swanAppActivity, j73Var, ld2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = m73Var;
            this.a = zb3Var;
            this.b = swanAppActivity;
            this.c = j73Var;
            this.d = ld2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(lh3 lh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lh3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, lh3Var, this.d);
            }
        }
    }

    public m73() {
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

    @Override // com.baidu.tieba.n73
    public z32 j(String str, j73 j73Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j73Var)) == null) {
            return new z32(0);
        }
        return (z32) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.n73
    public z32 m(j73 j73Var, ld2<k73> ld2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, j73Var, ld2Var)) == null) {
            if (j73Var != null && !TextUtils.isEmpty(j73Var.a)) {
                if (ld2Var == null) {
                    return new z32(1001, "get fun page info, cb is null");
                }
                zb3 q = yb3.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, j73Var, ld2Var));
                        return new z32(1001, "not login");
                    }
                    o(j73Var, ld2Var);
                    return new z32(0);
                }
                return new z32(1001, "get fun page info, master has dead");
            }
            return new z32(1001, "get fun page info, provider appKey is empty");
        }
        return (z32) invokeLL.objValue;
    }

    public final void o(j73 j73Var, ld2<k73> ld2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, j73Var, ld2Var) == null) {
            r73.b("start get open data");
            zb3 q = yb3.K().q();
            SwanAppActivity w = q.w();
            lh3.B(w, g(), j73Var.a, true, h(), new b(this, q, w, j73Var, ld2Var));
        }
    }
}
