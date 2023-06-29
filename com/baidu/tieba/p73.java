package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class p73 extends q73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.q73
    public l73 f(m73 m73Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, m73Var)) == null) {
            return null;
        }
        return (l73) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q73
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, m73 m73Var, oh3 oh3Var, od2<n73> od2Var);

    /* loaded from: classes7.dex */
    public class a implements os1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m73 a;
        public final /* synthetic */ od2 b;
        public final /* synthetic */ p73 c;

        public a(p73 p73Var, m73 m73Var, od2 od2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p73Var, m73Var, od2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = p73Var;
            this.a = m73Var;
            this.b = od2Var;
        }

        @Override // com.baidu.tieba.os1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                n73 n73Var = new n73(this.a.f);
                n73Var.a = this.a.e;
                this.b.a(n73Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements vq3<oh3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cc3 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ m73 c;
        public final /* synthetic */ od2 d;
        public final /* synthetic */ p73 e;

        public b(p73 p73Var, cc3 cc3Var, SwanAppActivity swanAppActivity, m73 m73Var, od2 od2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p73Var, cc3Var, swanAppActivity, m73Var, od2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = p73Var;
            this.a = cc3Var;
            this.b = swanAppActivity;
            this.c = m73Var;
            this.d = od2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(oh3 oh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oh3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, oh3Var, this.d);
            }
        }
    }

    public p73() {
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

    @Override // com.baidu.tieba.q73
    public c42 j(String str, m73 m73Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, m73Var)) == null) {
            return new c42(0);
        }
        return (c42) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.q73
    public c42 m(m73 m73Var, od2<n73> od2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, m73Var, od2Var)) == null) {
            if (m73Var != null && !TextUtils.isEmpty(m73Var.a)) {
                if (od2Var == null) {
                    return new c42(1001, "get fun page info, cb is null");
                }
                cc3 q = bc3.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, m73Var, od2Var));
                        return new c42(1001, "not login");
                    }
                    o(m73Var, od2Var);
                    return new c42(0);
                }
                return new c42(1001, "get fun page info, master has dead");
            }
            return new c42(1001, "get fun page info, provider appKey is empty");
        }
        return (c42) invokeLL.objValue;
    }

    public final void o(m73 m73Var, od2<n73> od2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, m73Var, od2Var) == null) {
            u73.b("start get open data");
            cc3 q = bc3.K().q();
            SwanAppActivity w = q.w();
            oh3.B(w, g(), m73Var.a, true, h(), new b(this, q, w, m73Var, od2Var));
        }
    }
}
