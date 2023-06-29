package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rf2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class q73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract c42 b(JSONObject jSONObject);

    public abstract l73 f(m73 m73Var);

    public abstract String g();

    public abstract String h();

    public abstract c42 j(String str, m73 m73Var);

    public abstract boolean k();

    public abstract c42 m(m73 m73Var, od2<n73> od2Var);

    /* loaded from: classes7.dex */
    public class a implements rf2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m73 a;
        public final /* synthetic */ od2 b;
        public final /* synthetic */ q73 c;

        public a(q73 q73Var, m73 m73Var, od2 od2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q73Var, m73Var, od2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q73Var;
            this.a = m73Var;
            this.b = od2Var;
        }

        @Override // com.baidu.tieba.rf2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u73.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.rf2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.rf2.b
        public void b(vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vn3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements xe2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m73 a;
        public final /* synthetic */ od2 b;
        public final /* synthetic */ q73 c;

        public b(q73 q73Var, m73 m73Var, od2 od2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q73Var, m73Var, od2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q73Var;
            this.a = m73Var;
            this.b = od2Var;
        }

        @Override // com.baidu.tieba.xe2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.xe2
        public void b(int i, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, vn3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public q73() {
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

    public final void c(m73 m73Var, String str, od2<n73> od2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m73Var, str, od2Var) == null) {
            u73.b("local has not main pkg, download fun page main pkg");
            en4 en4Var = new en4(str, bc3.K().k());
            en4Var.q(0L);
            en4Var.t(m73Var.c);
            en4Var.d("3");
            mj4.c(en4Var, new rf2(str, new a(this, m73Var, od2Var)));
        }
    }

    public final void e(m73 m73Var, l73 l73Var, od2<n73> od2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, m73Var, l73Var, od2Var) == null) {
            u73.b("main pkg is exist, download fun page sub pkg");
            String str = l73Var.a;
            int i = l73Var.d;
            mj4.h(new hn4(str, i, a83.e(l73Var.c, l73Var.b), 0), new tf2(str, String.valueOf(i), new b(this, m73Var, od2Var)));
        }
    }

    public final void d(m73 m73Var, boolean z, od2<n73> od2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{m73Var, Boolean.valueOf(z), od2Var}) == null) {
            if (z) {
                l73 f = f(m73Var);
                if (f != null && f.f) {
                    u73.b("payment fun page, download success, ready to jump");
                    j(f.c, m73Var);
                    return;
                }
                u73.b("payment fun page, download success, but not exist");
                n73 n73Var = new n73(m73Var.f);
                n73Var.a = m73Var.e;
                od2Var.a(n73Var);
                return;
            }
            u73.b("payment fun page, download failed");
            n73 n73Var2 = new n73(m73Var.f);
            n73Var2.a = m73Var.e;
            od2Var.a(n73Var2);
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

    public final c42 l(m73 m73Var, od2<n73> od2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, m73Var, od2Var)) == null) {
            u73.b("open fun page start");
            if (m73Var != null && m73Var.a()) {
                c42 b2 = b(m73Var.g);
                if (b2 != null) {
                    u73.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    u73.b("open payment fun page");
                    l73 f = f(m73Var);
                    if (f == null) {
                        return new c42(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        u73.b("payment fun page, " + m73Var.d + " mode");
                        if (i(m73Var.d)) {
                            if (f.e) {
                                e(m73Var, f, od2Var);
                            } else {
                                return new c42(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(m73Var, f, od2Var);
                        } else {
                            c(m73Var, f.a, od2Var);
                        }
                        u73.b("open fun page end");
                        return new c42(0);
                    }
                    return j(f.c, m73Var);
                } else {
                    u73.b("open user info or choose address fun page");
                    return m(m73Var, od2Var);
                }
            }
            u73.b("params parse fail");
            return new c42(202, "params parse fail");
        }
        return (c42) invokeLL.objValue;
    }
}
