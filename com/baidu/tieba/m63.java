package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ne2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class m63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract y22 b(JSONObject jSONObject);

    public abstract h63 f(i63 i63Var);

    public abstract String g();

    public abstract String h();

    public abstract y22 j(String str, i63 i63Var);

    public abstract boolean k();

    public abstract y22 m(i63 i63Var, kc2<j63> kc2Var);

    /* loaded from: classes6.dex */
    public class a implements ne2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i63 a;
        public final /* synthetic */ kc2 b;
        public final /* synthetic */ m63 c;

        public a(m63 m63Var, i63 i63Var, kc2 kc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m63Var, i63Var, kc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m63Var;
            this.a = i63Var;
            this.b = kc2Var;
        }

        @Override // com.baidu.tieba.ne2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q63.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.ne2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.ne2.b
        public void b(rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rm3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements td2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i63 a;
        public final /* synthetic */ kc2 b;
        public final /* synthetic */ m63 c;

        public b(m63 m63Var, i63 i63Var, kc2 kc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m63Var, i63Var, kc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m63Var;
            this.a = i63Var;
            this.b = kc2Var;
        }

        @Override // com.baidu.tieba.td2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.td2
        public void b(int i, rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, rm3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public m63() {
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

    public final void c(i63 i63Var, String str, kc2<j63> kc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i63Var, str, kc2Var) == null) {
            q63.b("local has not main pkg, download fun page main pkg");
            am4 am4Var = new am4(str, xa3.K().k());
            am4Var.q(0L);
            am4Var.t(i63Var.c);
            am4Var.d("3");
            ii4.c(am4Var, new ne2(str, new a(this, i63Var, kc2Var)));
        }
    }

    public final void e(i63 i63Var, h63 h63Var, kc2<j63> kc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, i63Var, h63Var, kc2Var) == null) {
            q63.b("main pkg is exist, download fun page sub pkg");
            String str = h63Var.a;
            int i = h63Var.d;
            ii4.h(new dm4(str, i, w63.e(h63Var.c, h63Var.b), 0), new pe2(str, String.valueOf(i), new b(this, i63Var, kc2Var)));
        }
    }

    public final void d(i63 i63Var, boolean z, kc2<j63> kc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{i63Var, Boolean.valueOf(z), kc2Var}) == null) {
            if (z) {
                h63 f = f(i63Var);
                if (f != null && f.f) {
                    q63.b("payment fun page, download success, ready to jump");
                    j(f.c, i63Var);
                    return;
                }
                q63.b("payment fun page, download success, but not exist");
                j63 j63Var = new j63(i63Var.f);
                j63Var.a = i63Var.e;
                kc2Var.a(j63Var);
                return;
            }
            q63.b("payment fun page, download failed");
            j63 j63Var2 = new j63(i63Var.f);
            j63Var2.a = i63Var.e;
            kc2Var.a(j63Var2);
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

    public final y22 l(i63 i63Var, kc2<j63> kc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, i63Var, kc2Var)) == null) {
            q63.b("open fun page start");
            if (i63Var != null && i63Var.a()) {
                y22 b2 = b(i63Var.g);
                if (b2 != null) {
                    q63.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    q63.b("open payment fun page");
                    h63 f = f(i63Var);
                    if (f == null) {
                        return new y22(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        q63.b("payment fun page, " + i63Var.d + " mode");
                        if (i(i63Var.d)) {
                            if (f.e) {
                                e(i63Var, f, kc2Var);
                            } else {
                                return new y22(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(i63Var, f, kc2Var);
                        } else {
                            c(i63Var, f.a, kc2Var);
                        }
                        q63.b("open fun page end");
                        return new y22(0);
                    }
                    return j(f.c, i63Var);
                } else {
                    q63.b("open user info or choose address fun page");
                    return m(i63Var, kc2Var);
                }
            }
            q63.b("params parse fail");
            return new y22(202, "params parse fail");
        }
        return (y22) invokeLL.objValue;
    }
}
