package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class ly2 extends my2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements kj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy2 a;
        public final /* synthetic */ k42 b;
        public final /* synthetic */ ly2 c;

        public a(ly2 ly2Var, iy2 iy2Var, k42 k42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly2Var, iy2Var, k42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ly2Var;
            this.a = iy2Var;
            this.b = k42Var;
        }

        @Override // com.baidu.tieba.kj1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    jy2 jy2Var = new jy2(this.a.f);
                    jy2Var.a = this.a.e;
                    this.b.a(jy2Var);
                    return;
                }
                this.c.o(this.a, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements rh3<k83> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y23 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ iy2 c;
        public final /* synthetic */ k42 d;
        public final /* synthetic */ ly2 e;

        public b(ly2 ly2Var, y23 y23Var, SwanAppActivity swanAppActivity, iy2 iy2Var, k42 k42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly2Var, y23Var, swanAppActivity, iy2Var, k42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ly2Var;
            this.a = y23Var;
            this.b = swanAppActivity;
            this.c = iy2Var;
            this.d = k42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(k83 k83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k83Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, k83Var, this.d);
            }
        }
    }

    public ly2() {
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

    @Override // com.baidu.tieba.my2
    public hy2 f(iy2 iy2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iy2Var)) == null) {
            return null;
        }
        return (hy2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.my2
    public yu1 j(String str, iy2 iy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, iy2Var)) == null) ? new yu1(0) : (yu1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.my2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.my2
    public yu1 m(iy2 iy2Var, k42<jy2> k42Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, iy2Var, k42Var)) == null) {
            if (iy2Var == null || TextUtils.isEmpty(iy2Var.a)) {
                return new yu1(1001, "get fun page info, provider appKey is empty");
            }
            if (k42Var == null) {
                return new yu1(1001, "get fun page info, cb is null");
            }
            y23 q = x23.K().q();
            SwanAppActivity w = q.w();
            if (w != null && !w.isFinishing()) {
                if (!q.N().e(q)) {
                    q.N().f(w, null, new a(this, iy2Var, k42Var));
                    return new yu1(1001, "not login");
                }
                o(iy2Var, k42Var);
                return new yu1(0);
            }
            return new yu1(1001, "get fun page info, master has dead");
        }
        return (yu1) invokeLL.objValue;
    }

    public final void o(iy2 iy2Var, k42<jy2> k42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, iy2Var, k42Var) == null) {
            qy2.b("start get open data");
            y23 q = x23.K().q();
            SwanAppActivity w = q.w();
            k83.B(w, g(), iy2Var.a, true, h(), new b(this, q, w, iy2Var, k42Var));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, iy2 iy2Var, k83 k83Var, k42<jy2> k42Var);
}
