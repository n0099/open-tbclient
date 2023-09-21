package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class t63 extends u63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.u63
    public p63 f(q63 q63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, q63Var)) == null) {
            return null;
        }
        return (p63) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u63
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, q63 q63Var, sg3 sg3Var, sc2<r63> sc2Var);

    /* loaded from: classes8.dex */
    public class a implements sr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q63 a;
        public final /* synthetic */ sc2 b;
        public final /* synthetic */ t63 c;

        public a(t63 t63Var, q63 q63Var, sc2 sc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t63Var, q63Var, sc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t63Var;
            this.a = q63Var;
            this.b = sc2Var;
        }

        @Override // com.baidu.tieba.sr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                r63 r63Var = new r63(this.a.f);
                r63Var.a = this.a.e;
                this.b.a(r63Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements zp3<sg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb3 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ q63 c;
        public final /* synthetic */ sc2 d;
        public final /* synthetic */ t63 e;

        public b(t63 t63Var, gb3 gb3Var, SwanAppActivity swanAppActivity, q63 q63Var, sc2 sc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t63Var, gb3Var, swanAppActivity, q63Var, sc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = t63Var;
            this.a = gb3Var;
            this.b = swanAppActivity;
            this.c = q63Var;
            this.d = sc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(sg3 sg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sg3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, sg3Var, this.d);
            }
        }
    }

    public t63() {
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

    @Override // com.baidu.tieba.u63
    public g32 j(String str, q63 q63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, q63Var)) == null) {
            return new g32(0);
        }
        return (g32) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.u63
    public g32 m(q63 q63Var, sc2<r63> sc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, q63Var, sc2Var)) == null) {
            if (q63Var != null && !TextUtils.isEmpty(q63Var.a)) {
                if (sc2Var == null) {
                    return new g32(1001, "get fun page info, cb is null");
                }
                gb3 q = fb3.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, q63Var, sc2Var));
                        return new g32(1001, "not login");
                    }
                    o(q63Var, sc2Var);
                    return new g32(0);
                }
                return new g32(1001, "get fun page info, master has dead");
            }
            return new g32(1001, "get fun page info, provider appKey is empty");
        }
        return (g32) invokeLL.objValue;
    }

    public final void o(q63 q63Var, sc2<r63> sc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, q63Var, sc2Var) == null) {
            y63.b("start get open data");
            gb3 q = fb3.K().q();
            SwanAppActivity w = q.w();
            sg3.B(w, g(), q63Var.a, true, h(), new b(this, q, w, q63Var, sc2Var));
        }
    }
}
