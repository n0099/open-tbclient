package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.se2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class r63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract d32 b(JSONObject jSONObject);

    public abstract m63 f(n63 n63Var);

    public abstract String g();

    public abstract String h();

    public abstract d32 j(String str, n63 n63Var);

    public abstract boolean k();

    public abstract d32 m(n63 n63Var, pc2<o63> pc2Var);

    /* loaded from: classes7.dex */
    public class a implements se2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n63 a;
        public final /* synthetic */ pc2 b;
        public final /* synthetic */ r63 c;

        public a(r63 r63Var, n63 n63Var, pc2 pc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r63Var, n63Var, pc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r63Var;
            this.a = n63Var;
            this.b = pc2Var;
        }

        @Override // com.baidu.tieba.se2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v63.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.se2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.se2.b
        public void b(wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wm3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yd2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n63 a;
        public final /* synthetic */ pc2 b;
        public final /* synthetic */ r63 c;

        public b(r63 r63Var, n63 n63Var, pc2 pc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r63Var, n63Var, pc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r63Var;
            this.a = n63Var;
            this.b = pc2Var;
        }

        @Override // com.baidu.tieba.yd2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.yd2
        public void b(int i, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, wm3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public r63() {
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

    public final void c(n63 n63Var, String str, pc2<o63> pc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n63Var, str, pc2Var) == null) {
            v63.b("local has not main pkg, download fun page main pkg");
            fm4 fm4Var = new fm4(str, cb3.K().k());
            fm4Var.q(0L);
            fm4Var.t(n63Var.c);
            fm4Var.d("3");
            ni4.c(fm4Var, new se2(str, new a(this, n63Var, pc2Var)));
        }
    }

    public final void e(n63 n63Var, m63 m63Var, pc2<o63> pc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, n63Var, m63Var, pc2Var) == null) {
            v63.b("main pkg is exist, download fun page sub pkg");
            String str = m63Var.a;
            int i = m63Var.d;
            ni4.h(new im4(str, i, b73.e(m63Var.c, m63Var.b), 0), new ue2(str, String.valueOf(i), new b(this, n63Var, pc2Var)));
        }
    }

    public final void d(n63 n63Var, boolean z, pc2<o63> pc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{n63Var, Boolean.valueOf(z), pc2Var}) == null) {
            if (z) {
                m63 f = f(n63Var);
                if (f != null && f.f) {
                    v63.b("payment fun page, download success, ready to jump");
                    j(f.c, n63Var);
                    return;
                }
                v63.b("payment fun page, download success, but not exist");
                o63 o63Var = new o63(n63Var.f);
                o63Var.a = n63Var.e;
                pc2Var.a(o63Var);
                return;
            }
            v63.b("payment fun page, download failed");
            o63 o63Var2 = new o63(n63Var.f);
            o63Var2.a = n63Var.e;
            pc2Var.a(o63Var2);
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

    public final d32 l(n63 n63Var, pc2<o63> pc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, n63Var, pc2Var)) == null) {
            v63.b("open fun page start");
            if (n63Var != null && n63Var.a()) {
                d32 b2 = b(n63Var.g);
                if (b2 != null) {
                    v63.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    v63.b("open payment fun page");
                    m63 f = f(n63Var);
                    if (f == null) {
                        return new d32(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        v63.b("payment fun page, " + n63Var.d + " mode");
                        if (i(n63Var.d)) {
                            if (f.e) {
                                e(n63Var, f, pc2Var);
                            } else {
                                return new d32(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(n63Var, f, pc2Var);
                        } else {
                            c(n63Var, f.a, pc2Var);
                        }
                        v63.b("open fun page end");
                        return new d32(0);
                    }
                    return j(f.c, n63Var);
                } else {
                    v63.b("open user info or choose address fun page");
                    return m(n63Var, pc2Var);
                }
            }
            v63.b("params parse fail");
            return new d32(202, "params parse fail");
        }
        return (d32) invokeLL.objValue;
    }
}
