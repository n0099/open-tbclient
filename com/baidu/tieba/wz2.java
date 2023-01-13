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
public abstract class wz2 extends xz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.xz2
    public sz2 f(tz2 tz2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tz2Var)) == null) {
            return null;
        }
        return (sz2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xz2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, tz2 tz2Var, v93 v93Var, v52<uz2> v52Var);

    /* loaded from: classes6.dex */
    public class a implements vk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz2 a;
        public final /* synthetic */ v52 b;
        public final /* synthetic */ wz2 c;

        public a(wz2 wz2Var, tz2 tz2Var, v52 v52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz2Var, tz2Var, v52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wz2Var;
            this.a = tz2Var;
            this.b = v52Var;
        }

        @Override // com.baidu.tieba.vk1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                uz2 uz2Var = new uz2(this.a.f);
                uz2Var.a = this.a.e;
                this.b.a(uz2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cj3<v93> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j43 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ tz2 c;
        public final /* synthetic */ v52 d;
        public final /* synthetic */ wz2 e;

        public b(wz2 wz2Var, j43 j43Var, SwanAppActivity swanAppActivity, tz2 tz2Var, v52 v52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz2Var, j43Var, swanAppActivity, tz2Var, v52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wz2Var;
            this.a = j43Var;
            this.b = swanAppActivity;
            this.c = tz2Var;
            this.d = v52Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(v93 v93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v93Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, v93Var, this.d);
            }
        }
    }

    public wz2() {
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

    @Override // com.baidu.tieba.xz2
    public jw1 j(String str, tz2 tz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, tz2Var)) == null) {
            return new jw1(0);
        }
        return (jw1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.xz2
    public jw1 m(tz2 tz2Var, v52<uz2> v52Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tz2Var, v52Var)) == null) {
            if (tz2Var != null && !TextUtils.isEmpty(tz2Var.a)) {
                if (v52Var == null) {
                    return new jw1(1001, "get fun page info, cb is null");
                }
                j43 q = i43.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, tz2Var, v52Var));
                        return new jw1(1001, "not login");
                    }
                    o(tz2Var, v52Var);
                    return new jw1(0);
                }
                return new jw1(1001, "get fun page info, master has dead");
            }
            return new jw1(1001, "get fun page info, provider appKey is empty");
        }
        return (jw1) invokeLL.objValue;
    }

    public final void o(tz2 tz2Var, v52<uz2> v52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tz2Var, v52Var) == null) {
            b03.b("start get open data");
            j43 q = i43.K().q();
            SwanAppActivity w = q.w();
            v93.B(w, g(), tz2Var.a, true, h(), new b(this, q, w, tz2Var, v52Var));
        }
    }
}
