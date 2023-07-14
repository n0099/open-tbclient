package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kf2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class j73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract v32 b(JSONObject jSONObject);

    public abstract e73 f(f73 f73Var);

    public abstract String g();

    public abstract String h();

    public abstract v32 j(String str, f73 f73Var);

    public abstract boolean k();

    public abstract v32 m(f73 f73Var, hd2<g73> hd2Var);

    /* loaded from: classes6.dex */
    public class a implements kf2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f73 a;
        public final /* synthetic */ hd2 b;
        public final /* synthetic */ j73 c;

        public a(j73 j73Var, f73 f73Var, hd2 hd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j73Var, f73Var, hd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j73Var;
            this.a = f73Var;
            this.b = hd2Var;
        }

        @Override // com.baidu.tieba.kf2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n73.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.kf2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.kf2.b
        public void b(on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, on3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements qe2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f73 a;
        public final /* synthetic */ hd2 b;
        public final /* synthetic */ j73 c;

        public b(j73 j73Var, f73 f73Var, hd2 hd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j73Var, f73Var, hd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j73Var;
            this.a = f73Var;
            this.b = hd2Var;
        }

        @Override // com.baidu.tieba.qe2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.qe2
        public void b(int i, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, on3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public j73() {
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

    public final void c(f73 f73Var, String str, hd2<g73> hd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f73Var, str, hd2Var) == null) {
            n73.b("local has not main pkg, download fun page main pkg");
            xm4 xm4Var = new xm4(str, ub3.K().k());
            xm4Var.q(0L);
            xm4Var.t(f73Var.c);
            xm4Var.d("3");
            fj4.c(xm4Var, new kf2(str, new a(this, f73Var, hd2Var)));
        }
    }

    public final void e(f73 f73Var, e73 e73Var, hd2<g73> hd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, f73Var, e73Var, hd2Var) == null) {
            n73.b("main pkg is exist, download fun page sub pkg");
            String str = e73Var.a;
            int i = e73Var.d;
            fj4.h(new an4(str, i, t73.e(e73Var.c, e73Var.b), 0), new mf2(str, String.valueOf(i), new b(this, f73Var, hd2Var)));
        }
    }

    public final void d(f73 f73Var, boolean z, hd2<g73> hd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{f73Var, Boolean.valueOf(z), hd2Var}) == null) {
            if (z) {
                e73 f = f(f73Var);
                if (f != null && f.f) {
                    n73.b("payment fun page, download success, ready to jump");
                    j(f.c, f73Var);
                    return;
                }
                n73.b("payment fun page, download success, but not exist");
                g73 g73Var = new g73(f73Var.f);
                g73Var.a = f73Var.e;
                hd2Var.a(g73Var);
                return;
            }
            n73.b("payment fun page, download failed");
            g73 g73Var2 = new g73(f73Var.f);
            g73Var2.a = f73Var.e;
            hd2Var.a(g73Var2);
        }
    }

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP);
        }
        return invokeL.booleanValue;
    }

    public final v32 l(f73 f73Var, hd2<g73> hd2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, f73Var, hd2Var)) == null) {
            n73.b("open fun page start");
            if (f73Var != null && f73Var.a()) {
                v32 b2 = b(f73Var.g);
                if (b2 != null) {
                    n73.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    n73.b("open payment fun page");
                    e73 f = f(f73Var);
                    if (f == null) {
                        return new v32(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        n73.b("payment fun page, " + f73Var.d + " mode");
                        if (i(f73Var.d)) {
                            if (f.e) {
                                e(f73Var, f, hd2Var);
                            } else {
                                return new v32(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(f73Var, f, hd2Var);
                        } else {
                            c(f73Var, f.a, hd2Var);
                        }
                        n73.b("open fun page end");
                        return new v32(0);
                    }
                    return j(f.c, f73Var);
                } else {
                    n73.b("open user info or choose address fun page");
                    return m(f73Var, hd2Var);
                }
            }
            n73.b("params parse fail");
            return new v32(202, "params parse fail");
        }
        return (v32) invokeLL.objValue;
    }
}
