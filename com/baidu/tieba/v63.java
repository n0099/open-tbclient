package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.we2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class v63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract h32 b(JSONObject jSONObject);

    public abstract q63 f(r63 r63Var);

    public abstract String g();

    public abstract String h();

    public abstract h32 j(String str, r63 r63Var);

    public abstract boolean k();

    public abstract h32 m(r63 r63Var, tc2<s63> tc2Var);

    /* loaded from: classes8.dex */
    public class a implements we2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r63 a;
        public final /* synthetic */ tc2 b;
        public final /* synthetic */ v63 c;

        public a(v63 v63Var, r63 r63Var, tc2 tc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v63Var, r63Var, tc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v63Var;
            this.a = r63Var;
            this.b = tc2Var;
        }

        @Override // com.baidu.tieba.we2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z63.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.we2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.we2.b
        public void b(an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, an3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ce2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r63 a;
        public final /* synthetic */ tc2 b;
        public final /* synthetic */ v63 c;

        public b(v63 v63Var, r63 r63Var, tc2 tc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v63Var, r63Var, tc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v63Var;
            this.a = r63Var;
            this.b = tc2Var;
        }

        @Override // com.baidu.tieba.ce2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.ce2
        public void b(int i, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, an3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public v63() {
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

    public final void c(r63 r63Var, String str, tc2<s63> tc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r63Var, str, tc2Var) == null) {
            z63.b("local has not main pkg, download fun page main pkg");
            jm4 jm4Var = new jm4(str, gb3.K().k());
            jm4Var.q(0L);
            jm4Var.t(r63Var.c);
            jm4Var.d("3");
            ri4.c(jm4Var, new we2(str, new a(this, r63Var, tc2Var)));
        }
    }

    public final void e(r63 r63Var, q63 q63Var, tc2<s63> tc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, r63Var, q63Var, tc2Var) == null) {
            z63.b("main pkg is exist, download fun page sub pkg");
            String str = q63Var.a;
            int i = q63Var.d;
            ri4.h(new mm4(str, i, f73.e(q63Var.c, q63Var.b), 0), new ye2(str, String.valueOf(i), new b(this, r63Var, tc2Var)));
        }
    }

    public final void d(r63 r63Var, boolean z, tc2<s63> tc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{r63Var, Boolean.valueOf(z), tc2Var}) == null) {
            if (z) {
                q63 f = f(r63Var);
                if (f != null && f.f) {
                    z63.b("payment fun page, download success, ready to jump");
                    j(f.c, r63Var);
                    return;
                }
                z63.b("payment fun page, download success, but not exist");
                s63 s63Var = new s63(r63Var.f);
                s63Var.a = r63Var.e;
                tc2Var.a(s63Var);
                return;
            }
            z63.b("payment fun page, download failed");
            s63 s63Var2 = new s63(r63Var.f);
            s63Var2.a = r63Var.e;
            tc2Var.a(s63Var2);
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

    public final h32 l(r63 r63Var, tc2<s63> tc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, r63Var, tc2Var)) == null) {
            z63.b("open fun page start");
            if (r63Var != null && r63Var.a()) {
                h32 b2 = b(r63Var.g);
                if (b2 != null) {
                    z63.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    z63.b("open payment fun page");
                    q63 f = f(r63Var);
                    if (f == null) {
                        return new h32(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        z63.b("payment fun page, " + r63Var.d + " mode");
                        if (i(r63Var.d)) {
                            if (f.e) {
                                e(r63Var, f, tc2Var);
                            } else {
                                return new h32(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(r63Var, f, tc2Var);
                        } else {
                            c(r63Var, f.a, tc2Var);
                        }
                        z63.b("open fun page end");
                        return new h32(0);
                    }
                    return j(f.c, r63Var);
                } else {
                    z63.b("open user info or choose address fun page");
                    return m(r63Var, tc2Var);
                }
            }
            z63.b("params parse fail");
            return new h32(202, "params parse fail");
        }
        return (h32) invokeLL.objValue;
    }
}
