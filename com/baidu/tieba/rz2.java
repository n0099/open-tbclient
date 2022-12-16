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
public abstract class rz2 extends sz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.sz2
    public nz2 f(oz2 oz2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oz2Var)) == null) {
            return null;
        }
        return (nz2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sz2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, oz2 oz2Var, q93 q93Var, q52<pz2> q52Var);

    /* loaded from: classes6.dex */
    public class a implements qk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oz2 a;
        public final /* synthetic */ q52 b;
        public final /* synthetic */ rz2 c;

        public a(rz2 rz2Var, oz2 oz2Var, q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz2Var, oz2Var, q52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rz2Var;
            this.a = oz2Var;
            this.b = q52Var;
        }

        @Override // com.baidu.tieba.qk1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                pz2 pz2Var = new pz2(this.a.f);
                pz2Var.a = this.a.e;
                this.b.a(pz2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements xi3<q93> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e43 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ oz2 c;
        public final /* synthetic */ q52 d;
        public final /* synthetic */ rz2 e;

        public b(rz2 rz2Var, e43 e43Var, SwanAppActivity swanAppActivity, oz2 oz2Var, q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz2Var, e43Var, swanAppActivity, oz2Var, q52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rz2Var;
            this.a = e43Var;
            this.b = swanAppActivity;
            this.c = oz2Var;
            this.d = q52Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(q93 q93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q93Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, q93Var, this.d);
            }
        }
    }

    public rz2() {
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

    @Override // com.baidu.tieba.sz2
    public ew1 j(String str, oz2 oz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, oz2Var)) == null) {
            return new ew1(0);
        }
        return (ew1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.sz2
    public ew1 m(oz2 oz2Var, q52<pz2> q52Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, oz2Var, q52Var)) == null) {
            if (oz2Var != null && !TextUtils.isEmpty(oz2Var.a)) {
                if (q52Var == null) {
                    return new ew1(1001, "get fun page info, cb is null");
                }
                e43 q = d43.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, oz2Var, q52Var));
                        return new ew1(1001, "not login");
                    }
                    o(oz2Var, q52Var);
                    return new ew1(0);
                }
                return new ew1(1001, "get fun page info, master has dead");
            }
            return new ew1(1001, "get fun page info, provider appKey is empty");
        }
        return (ew1) invokeLL.objValue;
    }

    public final void o(oz2 oz2Var, q52<pz2> q52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, oz2Var, q52Var) == null) {
            wz2.b("start get open data");
            e43 q = d43.K().q();
            SwanAppActivity w = q.w();
            q93.B(w, g(), oz2Var.a, true, h(), new b(this, q, w, oz2Var, q52Var));
        }
    }
}
