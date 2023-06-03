package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nf2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract y32 b(JSONObject jSONObject);

    public abstract h73 f(i73 i73Var);

    public abstract String g();

    public abstract String h();

    public abstract y32 j(String str, i73 i73Var);

    public abstract boolean k();

    public abstract y32 m(i73 i73Var, kd2<j73> kd2Var);

    /* loaded from: classes6.dex */
    public class a implements nf2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i73 a;
        public final /* synthetic */ kd2 b;
        public final /* synthetic */ m73 c;

        public a(m73 m73Var, i73 i73Var, kd2 kd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m73Var, i73Var, kd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m73Var;
            this.a = i73Var;
            this.b = kd2Var;
        }

        @Override // com.baidu.tieba.nf2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q73.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.nf2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.nf2.b
        public void b(rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rn3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements te2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i73 a;
        public final /* synthetic */ kd2 b;
        public final /* synthetic */ m73 c;

        public b(m73 m73Var, i73 i73Var, kd2 kd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m73Var, i73Var, kd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m73Var;
            this.a = i73Var;
            this.b = kd2Var;
        }

        @Override // com.baidu.tieba.te2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.te2
        public void b(int i, rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, rn3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public m73() {
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

    public final void c(i73 i73Var, String str, kd2<j73> kd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i73Var, str, kd2Var) == null) {
            q73.b("local has not main pkg, download fun page main pkg");
            an4 an4Var = new an4(str, xb3.K().k());
            an4Var.q(0L);
            an4Var.t(i73Var.c);
            an4Var.d("3");
            ij4.c(an4Var, new nf2(str, new a(this, i73Var, kd2Var)));
        }
    }

    public final void e(i73 i73Var, h73 h73Var, kd2<j73> kd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, i73Var, h73Var, kd2Var) == null) {
            q73.b("main pkg is exist, download fun page sub pkg");
            String str = h73Var.a;
            int i = h73Var.d;
            ij4.h(new dn4(str, i, w73.e(h73Var.c, h73Var.b), 0), new pf2(str, String.valueOf(i), new b(this, i73Var, kd2Var)));
        }
    }

    public final void d(i73 i73Var, boolean z, kd2<j73> kd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{i73Var, Boolean.valueOf(z), kd2Var}) == null) {
            if (z) {
                h73 f = f(i73Var);
                if (f != null && f.f) {
                    q73.b("payment fun page, download success, ready to jump");
                    j(f.c, i73Var);
                    return;
                }
                q73.b("payment fun page, download success, but not exist");
                j73 j73Var = new j73(i73Var.f);
                j73Var.a = i73Var.e;
                kd2Var.a(j73Var);
                return;
            }
            q73.b("payment fun page, download failed");
            j73 j73Var2 = new j73(i73Var.f);
            j73Var2.a = i73Var.e;
            kd2Var.a(j73Var2);
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

    public final y32 l(i73 i73Var, kd2<j73> kd2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, i73Var, kd2Var)) == null) {
            q73.b("open fun page start");
            if (i73Var != null && i73Var.a()) {
                y32 b2 = b(i73Var.g);
                if (b2 != null) {
                    q73.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    q73.b("open payment fun page");
                    h73 f = f(i73Var);
                    if (f == null) {
                        return new y32(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        q73.b("payment fun page, " + i73Var.d + " mode");
                        if (i(i73Var.d)) {
                            if (f.e) {
                                e(i73Var, f, kd2Var);
                            } else {
                                return new y32(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(i73Var, f, kd2Var);
                        } else {
                            c(i73Var, f.a, kd2Var);
                        }
                        q73.b("open fun page end");
                        return new y32(0);
                    }
                    return j(f.c, i73Var);
                } else {
                    q73.b("open user info or choose address fun page");
                    return m(i73Var, kd2Var);
                }
            }
            q73.b("params parse fail");
            return new y32(202, "params parse fail");
        }
        return (y32) invokeLL.objValue;
    }
}
