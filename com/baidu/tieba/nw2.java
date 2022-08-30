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
public abstract class nw2 extends ow2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements mh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kw2 a;
        public final /* synthetic */ m22 b;
        public final /* synthetic */ nw2 c;

        public a(nw2 nw2Var, kw2 kw2Var, m22 m22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw2Var, kw2Var, m22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nw2Var;
            this.a = kw2Var;
            this.b = m22Var;
        }

        @Override // com.baidu.tieba.mh1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    lw2 lw2Var = new lw2(this.a.f);
                    lw2Var.a = this.a.e;
                    this.b.a(lw2Var);
                    return;
                }
                this.c.o(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements tf3<m63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a13 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ kw2 c;
        public final /* synthetic */ m22 d;
        public final /* synthetic */ nw2 e;

        public b(nw2 nw2Var, a13 a13Var, SwanAppActivity swanAppActivity, kw2 kw2Var, m22 m22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw2Var, a13Var, swanAppActivity, kw2Var, m22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nw2Var;
            this.a = a13Var;
            this.b = swanAppActivity;
            this.c = kw2Var;
            this.d = m22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(m63 m63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m63Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, m63Var, this.d);
            }
        }
    }

    public nw2() {
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

    @Override // com.baidu.tieba.ow2
    public jw2 f(kw2 kw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kw2Var)) == null) {
            return null;
        }
        return (jw2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ow2
    public at1 j(String str, kw2 kw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, kw2Var)) == null) ? new at1(0) : (at1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ow2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ow2
    public at1 m(kw2 kw2Var, m22<lw2> m22Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, kw2Var, m22Var)) == null) {
            if (kw2Var == null || TextUtils.isEmpty(kw2Var.a)) {
                return new at1(1001, "get fun page info, provider appKey is empty");
            }
            if (m22Var == null) {
                return new at1(1001, "get fun page info, cb is null");
            }
            a13 q = z03.K().q();
            SwanAppActivity w = q.w();
            if (w != null && !w.isFinishing()) {
                if (!q.N().e(q)) {
                    q.N().f(w, null, new a(this, kw2Var, m22Var));
                    return new at1(1001, "not login");
                }
                o(kw2Var, m22Var);
                return new at1(0);
            }
            return new at1(1001, "get fun page info, master has dead");
        }
        return (at1) invokeLL.objValue;
    }

    public final void o(kw2 kw2Var, m22<lw2> m22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, kw2Var, m22Var) == null) {
            sw2.b("start get open data");
            a13 q = z03.K().q();
            SwanAppActivity w = q.w();
            m63.B(w, g(), kw2Var.a, true, h(), new b(this, q, w, kw2Var, m22Var));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, kw2 kw2Var, m63 m63Var, m22<lw2> m22Var);
}
