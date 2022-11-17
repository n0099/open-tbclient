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
public abstract class sz2 extends tz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tz2
    public oz2 f(pz2 pz2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pz2Var)) == null) {
            return null;
        }
        return (oz2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tz2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, pz2 pz2Var, r93 r93Var, r52<qz2> r52Var);

    /* loaded from: classes5.dex */
    public class a implements rk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz2 a;
        public final /* synthetic */ r52 b;
        public final /* synthetic */ sz2 c;

        public a(sz2 sz2Var, pz2 pz2Var, r52 r52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz2Var, pz2Var, r52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sz2Var;
            this.a = pz2Var;
            this.b = r52Var;
        }

        @Override // com.baidu.tieba.rk1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                qz2 qz2Var = new qz2(this.a.f);
                qz2Var.a = this.a.e;
                this.b.a(qz2Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements yi3<r93> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f43 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ pz2 c;
        public final /* synthetic */ r52 d;
        public final /* synthetic */ sz2 e;

        public b(sz2 sz2Var, f43 f43Var, SwanAppActivity swanAppActivity, pz2 pz2Var, r52 r52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz2Var, f43Var, swanAppActivity, pz2Var, r52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sz2Var;
            this.a = f43Var;
            this.b = swanAppActivity;
            this.c = pz2Var;
            this.d = r52Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(r93 r93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r93Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, r93Var, this.d);
            }
        }
    }

    public sz2() {
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

    @Override // com.baidu.tieba.tz2
    public fw1 j(String str, pz2 pz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, pz2Var)) == null) {
            return new fw1(0);
        }
        return (fw1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.tz2
    public fw1 m(pz2 pz2Var, r52<qz2> r52Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, pz2Var, r52Var)) == null) {
            if (pz2Var != null && !TextUtils.isEmpty(pz2Var.a)) {
                if (r52Var == null) {
                    return new fw1(1001, "get fun page info, cb is null");
                }
                f43 q = e43.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, pz2Var, r52Var));
                        return new fw1(1001, "not login");
                    }
                    o(pz2Var, r52Var);
                    return new fw1(0);
                }
                return new fw1(1001, "get fun page info, master has dead");
            }
            return new fw1(1001, "get fun page info, provider appKey is empty");
        }
        return (fw1) invokeLL.objValue;
    }

    public final void o(pz2 pz2Var, r52<qz2> r52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, pz2Var, r52Var) == null) {
            xz2.b("start get open data");
            f43 q = e43.K().q();
            SwanAppActivity w = q.w();
            r93.B(w, g(), pz2Var.a, true, h(), new b(this, q, w, pz2Var, r52Var));
        }
    }
}
