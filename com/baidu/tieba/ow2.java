package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p42;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class ow2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements p42.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kw2 a;
        public final /* synthetic */ m22 b;
        public final /* synthetic */ ow2 c;

        public a(ow2 ow2Var, kw2 kw2Var, m22 m22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow2Var, kw2Var, m22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ow2Var;
            this.a = kw2Var;
            this.b = m22Var;
        }

        @Override // com.baidu.tieba.p42.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sw2.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.p42.b
        public void b(tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tc3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }

        @Override // com.baidu.tieba.p42.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements v32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kw2 a;
        public final /* synthetic */ m22 b;
        public final /* synthetic */ ow2 c;

        public b(ow2 ow2Var, kw2 kw2Var, m22 m22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow2Var, kw2Var, m22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ow2Var;
            this.a = kw2Var;
            this.b = m22Var;
        }

        @Override // com.baidu.tieba.v32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.v32
        public void b(int i, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, tc3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public ow2() {
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

    public abstract at1 b(JSONObject jSONObject);

    public final void c(kw2 kw2Var, String str, m22<lw2> m22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kw2Var, str, m22Var) == null) {
            sw2.b("local has not main pkg, download fun page main pkg");
            ac4 ac4Var = new ac4(str, z03.K().k());
            ac4Var.q(0L);
            ac4Var.t(kw2Var.c);
            ac4Var.d("3");
            i84.c(ac4Var, new p42(str, new a(this, kw2Var, m22Var)));
        }
    }

    public final void d(kw2 kw2Var, boolean z, m22<lw2> m22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{kw2Var, Boolean.valueOf(z), m22Var}) == null) {
            if (z) {
                jw2 f = f(kw2Var);
                if (f != null && f.f) {
                    sw2.b("payment fun page, download success, ready to jump");
                    j(f.c, kw2Var);
                    return;
                }
                sw2.b("payment fun page, download success, but not exist");
                lw2 lw2Var = new lw2(kw2Var.f);
                lw2Var.a = kw2Var.e;
                m22Var.a(lw2Var);
                return;
            }
            sw2.b("payment fun page, download failed");
            lw2 lw2Var2 = new lw2(kw2Var.f);
            lw2Var2.a = kw2Var.e;
            m22Var.a(lw2Var2);
        }
    }

    public final void e(kw2 kw2Var, jw2 jw2Var, m22<lw2> m22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, kw2Var, jw2Var, m22Var) == null) {
            sw2.b("main pkg is exist, download fun page sub pkg");
            String str = jw2Var.a;
            int i = jw2Var.d;
            i84.h(new dc4(str, i, yw2.e(jw2Var.c, jw2Var.b), 0), new r42(str, String.valueOf(i), new b(this, kw2Var, m22Var)));
        }
    }

    public abstract jw2 f(kw2 kw2Var);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract at1 j(String str, kw2 kw2Var);

    public abstract boolean k();

    public final at1 l(kw2 kw2Var, m22<lw2> m22Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, kw2Var, m22Var)) == null) {
            sw2.b("open fun page start");
            if (kw2Var != null && kw2Var.a()) {
                at1 b2 = b(kw2Var.g);
                if (b2 != null) {
                    sw2.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    sw2.b("open payment fun page");
                    jw2 f = f(kw2Var);
                    if (f == null) {
                        return new at1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        sw2.b("payment fun page, " + kw2Var.d + " mode");
                        if (i(kw2Var.d)) {
                            if (f.e) {
                                e(kw2Var, f, m22Var);
                            } else {
                                return new at1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(kw2Var, f, m22Var);
                        } else {
                            c(kw2Var, f.a, m22Var);
                        }
                        sw2.b("open fun page end");
                        return new at1(0);
                    }
                    return j(f.c, kw2Var);
                } else {
                    sw2.b("open user info or choose address fun page");
                    return m(kw2Var, m22Var);
                }
            }
            sw2.b("params parse fail");
            return new at1(202, "params parse fail");
        }
        return (at1) invokeLL.objValue;
    }

    public abstract at1 m(kw2 kw2Var, m22<lw2> m22Var);
}
