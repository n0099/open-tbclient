package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kb2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class j33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract vz1 b(JSONObject jSONObject);

    public abstract e33 f(f33 f33Var);

    public abstract String g();

    public abstract String h();

    public abstract vz1 j(String str, f33 f33Var);

    public abstract boolean k();

    public abstract vz1 m(f33 f33Var, h92<g33> h92Var);

    /* loaded from: classes5.dex */
    public class a implements kb2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f33 a;
        public final /* synthetic */ h92 b;
        public final /* synthetic */ j33 c;

        public a(j33 j33Var, f33 f33Var, h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j33Var, f33Var, h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j33Var;
            this.a = f33Var;
            this.b = h92Var;
        }

        @Override // com.baidu.tieba.kb2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n33.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.kb2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.kb2.b
        public void b(oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oj3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qa2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f33 a;
        public final /* synthetic */ h92 b;
        public final /* synthetic */ j33 c;

        public b(j33 j33Var, f33 f33Var, h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j33Var, f33Var, h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j33Var;
            this.a = f33Var;
            this.b = h92Var;
        }

        @Override // com.baidu.tieba.qa2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.qa2
        public void b(int i, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, oj3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public j33() {
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

    public final void c(f33 f33Var, String str, h92<g33> h92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f33Var, str, h92Var) == null) {
            n33.b("local has not main pkg, download fun page main pkg");
            xi4 xi4Var = new xi4(str, u73.K().k());
            xi4Var.q(0L);
            xi4Var.t(f33Var.c);
            xi4Var.d("3");
            ff4.c(xi4Var, new kb2(str, new a(this, f33Var, h92Var)));
        }
    }

    public final void e(f33 f33Var, e33 e33Var, h92<g33> h92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, f33Var, e33Var, h92Var) == null) {
            n33.b("main pkg is exist, download fun page sub pkg");
            String str = e33Var.a;
            int i = e33Var.d;
            ff4.h(new aj4(str, i, t33.e(e33Var.c, e33Var.b), 0), new mb2(str, String.valueOf(i), new b(this, f33Var, h92Var)));
        }
    }

    public final void d(f33 f33Var, boolean z, h92<g33> h92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{f33Var, Boolean.valueOf(z), h92Var}) == null) {
            if (z) {
                e33 f = f(f33Var);
                if (f != null && f.f) {
                    n33.b("payment fun page, download success, ready to jump");
                    j(f.c, f33Var);
                    return;
                }
                n33.b("payment fun page, download success, but not exist");
                g33 g33Var = new g33(f33Var.f);
                g33Var.a = f33Var.e;
                h92Var.a(g33Var);
                return;
            }
            n33.b("payment fun page, download failed");
            g33 g33Var2 = new g33(f33Var.f);
            g33Var2.a = f33Var.e;
            h92Var.a(g33Var2);
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

    public final vz1 l(f33 f33Var, h92<g33> h92Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, f33Var, h92Var)) == null) {
            n33.b("open fun page start");
            if (f33Var != null && f33Var.a()) {
                vz1 b2 = b(f33Var.g);
                if (b2 != null) {
                    n33.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    n33.b("open payment fun page");
                    e33 f = f(f33Var);
                    if (f == null) {
                        return new vz1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        n33.b("payment fun page, " + f33Var.d + " mode");
                        if (i(f33Var.d)) {
                            if (f.e) {
                                e(f33Var, f, h92Var);
                            } else {
                                return new vz1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(f33Var, f, h92Var);
                        } else {
                            c(f33Var, f.a, h92Var);
                        }
                        n33.b("open fun page end");
                        return new vz1(0);
                    }
                    return j(f.c, f33Var);
                } else {
                    n33.b("open user info or choose address fun page");
                    return m(f33Var, h92Var);
                }
            }
            n33.b("params parse fail");
            return new vz1(202, "params parse fail");
        }
        return (vz1) invokeLL.objValue;
    }
}
