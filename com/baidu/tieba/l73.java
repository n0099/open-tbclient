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
public abstract class l73 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.m73
    public h73 f(i73 i73Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i73Var)) == null) {
            return null;
        }
        return (h73) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m73
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, i73 i73Var, kh3 kh3Var, kd2<j73> kd2Var);

    /* loaded from: classes6.dex */
    public class a implements ks1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i73 a;
        public final /* synthetic */ kd2 b;
        public final /* synthetic */ l73 c;

        public a(l73 l73Var, i73 i73Var, kd2 kd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l73Var, i73Var, kd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l73Var;
            this.a = i73Var;
            this.b = kd2Var;
        }

        @Override // com.baidu.tieba.ks1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                j73 j73Var = new j73(this.a.f);
                j73Var.a = this.a.e;
                this.b.a(j73Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements rq3<kh3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yb3 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ i73 c;
        public final /* synthetic */ kd2 d;
        public final /* synthetic */ l73 e;

        public b(l73 l73Var, yb3 yb3Var, SwanAppActivity swanAppActivity, i73 i73Var, kd2 kd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l73Var, yb3Var, swanAppActivity, i73Var, kd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = l73Var;
            this.a = yb3Var;
            this.b = swanAppActivity;
            this.c = i73Var;
            this.d = kd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(kh3 kh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kh3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, kh3Var, this.d);
            }
        }
    }

    public l73() {
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

    @Override // com.baidu.tieba.m73
    public y32 j(String str, i73 i73Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i73Var)) == null) {
            return new y32(0);
        }
        return (y32) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.m73
    public y32 m(i73 i73Var, kd2<j73> kd2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, i73Var, kd2Var)) == null) {
            if (i73Var != null && !TextUtils.isEmpty(i73Var.a)) {
                if (kd2Var == null) {
                    return new y32(1001, "get fun page info, cb is null");
                }
                yb3 q = xb3.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, i73Var, kd2Var));
                        return new y32(1001, "not login");
                    }
                    o(i73Var, kd2Var);
                    return new y32(0);
                }
                return new y32(1001, "get fun page info, master has dead");
            }
            return new y32(1001, "get fun page info, provider appKey is empty");
        }
        return (y32) invokeLL.objValue;
    }

    public final void o(i73 i73Var, kd2<j73> kd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, i73Var, kd2Var) == null) {
            q73.b("start get open data");
            yb3 q = xb3.K().q();
            SwanAppActivity w = q.w();
            kh3.B(w, g(), i73Var.a, true, h(), new b(this, q, w, i73Var, kd2Var));
        }
    }
}
