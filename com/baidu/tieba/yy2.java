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
public abstract class yy2 extends zy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements xj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy2 a;
        public final /* synthetic */ x42 b;
        public final /* synthetic */ yy2 c;

        public a(yy2 yy2Var, vy2 vy2Var, x42 x42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy2Var, vy2Var, x42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yy2Var;
            this.a = vy2Var;
            this.b = x42Var;
        }

        @Override // com.baidu.tieba.xj1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    wy2 wy2Var = new wy2(this.a.f);
                    wy2Var.a = this.a.e;
                    this.b.a(wy2Var);
                    return;
                }
                this.c.o(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ei3<x83> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l33 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ vy2 c;
        public final /* synthetic */ x42 d;
        public final /* synthetic */ yy2 e;

        public b(yy2 yy2Var, l33 l33Var, SwanAppActivity swanAppActivity, vy2 vy2Var, x42 x42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy2Var, l33Var, swanAppActivity, vy2Var, x42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yy2Var;
            this.a = l33Var;
            this.b = swanAppActivity;
            this.c = vy2Var;
            this.d = x42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(x83 x83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x83Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, x83Var, this.d);
            }
        }
    }

    public yy2() {
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

    @Override // com.baidu.tieba.zy2
    public uy2 f(vy2 vy2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vy2Var)) == null) {
            return null;
        }
        return (uy2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zy2
    public lv1 j(String str, vy2 vy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, vy2Var)) == null) ? new lv1(0) : (lv1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.zy2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zy2
    public lv1 m(vy2 vy2Var, x42<wy2> x42Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, vy2Var, x42Var)) == null) {
            if (vy2Var == null || TextUtils.isEmpty(vy2Var.a)) {
                return new lv1(1001, "get fun page info, provider appKey is empty");
            }
            if (x42Var == null) {
                return new lv1(1001, "get fun page info, cb is null");
            }
            l33 q = k33.K().q();
            SwanAppActivity w = q.w();
            if (w != null && !w.isFinishing()) {
                if (!q.N().e(q)) {
                    q.N().f(w, null, new a(this, vy2Var, x42Var));
                    return new lv1(1001, "not login");
                }
                o(vy2Var, x42Var);
                return new lv1(0);
            }
            return new lv1(1001, "get fun page info, master has dead");
        }
        return (lv1) invokeLL.objValue;
    }

    public final void o(vy2 vy2Var, x42<wy2> x42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, vy2Var, x42Var) == null) {
            dz2.b("start get open data");
            l33 q = k33.K().q();
            SwanAppActivity w = q.w();
            x83.B(w, g(), vy2Var.a, true, h(), new b(this, q, w, vy2Var, x42Var));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, vy2 vy2Var, x83 x83Var, x42<wy2> x42Var);
}
