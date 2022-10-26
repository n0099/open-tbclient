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
public abstract class zy2 extends az2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.az2
    public vy2 f(wy2 wy2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wy2Var)) == null) {
            return null;
        }
        return (vy2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.az2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, wy2 wy2Var, y83 y83Var, y42 y42Var);

    /* loaded from: classes6.dex */
    public class a implements yj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy2 a;
        public final /* synthetic */ y42 b;
        public final /* synthetic */ zy2 c;

        public a(zy2 zy2Var, wy2 wy2Var, y42 y42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy2Var, wy2Var, y42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zy2Var;
            this.a = wy2Var;
            this.b = y42Var;
        }

        @Override // com.baidu.tieba.yj1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                xy2 xy2Var = new xy2(this.a.f);
                xy2Var.a = this.a.e;
                this.b.a(xy2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m33 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ wy2 c;
        public final /* synthetic */ y42 d;
        public final /* synthetic */ zy2 e;

        public b(zy2 zy2Var, m33 m33Var, SwanAppActivity swanAppActivity, wy2 wy2Var, y42 y42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy2Var, m33Var, swanAppActivity, wy2Var, y42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zy2Var;
            this.a = m33Var;
            this.b = swanAppActivity;
            this.c = wy2Var;
            this.d = y42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(y83 y83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y83Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, y83Var, this.d);
            }
        }
    }

    public zy2() {
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

    @Override // com.baidu.tieba.az2
    public mv1 j(String str, wy2 wy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, wy2Var)) == null) {
            return new mv1(0);
        }
        return (mv1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.az2
    public mv1 m(wy2 wy2Var, y42 y42Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, wy2Var, y42Var)) == null) {
            if (wy2Var != null && !TextUtils.isEmpty(wy2Var.a)) {
                if (y42Var == null) {
                    return new mv1(1001, "get fun page info, cb is null");
                }
                m33 q = l33.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, wy2Var, y42Var));
                        return new mv1(1001, "not login");
                    }
                    o(wy2Var, y42Var);
                    return new mv1(0);
                }
                return new mv1(1001, "get fun page info, master has dead");
            }
            return new mv1(1001, "get fun page info, provider appKey is empty");
        }
        return (mv1) invokeLL.objValue;
    }

    public final void o(wy2 wy2Var, y42 y42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, wy2Var, y42Var) == null) {
            ez2.b("start get open data");
            m33 q = l33.K().q();
            SwanAppActivity w = q.w();
            y83.B(w, g(), wy2Var.a, true, h(), new b(this, q, w, wy2Var, y42Var));
        }
    }
}
