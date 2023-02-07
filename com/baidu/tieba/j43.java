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
public abstract class j43 extends k43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.k43
    public f43 f(g43 g43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, g43Var)) == null) {
            return null;
        }
        return (f43) invokeL.objValue;
    }

    @Override // com.baidu.tieba.k43
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, g43 g43Var, ie3 ie3Var, ia2<h43> ia2Var);

    /* loaded from: classes5.dex */
    public class a implements ip1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g43 a;
        public final /* synthetic */ ia2 b;
        public final /* synthetic */ j43 c;

        public a(j43 j43Var, g43 g43Var, ia2 ia2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j43Var, g43Var, ia2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j43Var;
            this.a = g43Var;
            this.b = ia2Var;
        }

        @Override // com.baidu.tieba.ip1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                h43 h43Var = new h43(this.a.f);
                h43Var.a = this.a.e;
                this.b.a(h43Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pn3<ie3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w83 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ g43 c;
        public final /* synthetic */ ia2 d;
        public final /* synthetic */ j43 e;

        public b(j43 j43Var, w83 w83Var, SwanAppActivity swanAppActivity, g43 g43Var, ia2 ia2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j43Var, w83Var, swanAppActivity, g43Var, ia2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = j43Var;
            this.a = w83Var;
            this.b = swanAppActivity;
            this.c = g43Var;
            this.d = ia2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pn3
        /* renamed from: b */
        public void a(ie3 ie3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ie3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, ie3Var, this.d);
            }
        }
    }

    public j43() {
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

    @Override // com.baidu.tieba.k43
    public w02 j(String str, g43 g43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, g43Var)) == null) {
            return new w02(0);
        }
        return (w02) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.k43
    public w02 m(g43 g43Var, ia2<h43> ia2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, g43Var, ia2Var)) == null) {
            if (g43Var != null && !TextUtils.isEmpty(g43Var.a)) {
                if (ia2Var == null) {
                    return new w02(1001, "get fun page info, cb is null");
                }
                w83 q = v83.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, g43Var, ia2Var));
                        return new w02(1001, "not login");
                    }
                    o(g43Var, ia2Var);
                    return new w02(0);
                }
                return new w02(1001, "get fun page info, master has dead");
            }
            return new w02(1001, "get fun page info, provider appKey is empty");
        }
        return (w02) invokeLL.objValue;
    }

    public final void o(g43 g43Var, ia2<h43> ia2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, g43Var, ia2Var) == null) {
            o43.b("start get open data");
            w83 q = v83.K().q();
            SwanAppActivity w = q.w();
            ie3.B(w, g(), g43Var.a, true, h(), new b(this, q, w, g43Var, ia2Var));
        }
    }
}
