package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ve2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class u63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract g32 b(JSONObject jSONObject);

    public abstract p63 f(q63 q63Var);

    public abstract String g();

    public abstract String h();

    public abstract g32 j(String str, q63 q63Var);

    public abstract boolean k();

    public abstract g32 m(q63 q63Var, sc2<r63> sc2Var);

    /* loaded from: classes8.dex */
    public class a implements ve2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q63 a;
        public final /* synthetic */ sc2 b;
        public final /* synthetic */ u63 c;

        public a(u63 u63Var, q63 q63Var, sc2 sc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u63Var, q63Var, sc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u63Var;
            this.a = q63Var;
            this.b = sc2Var;
        }

        @Override // com.baidu.tieba.ve2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y63.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.ve2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.ve2.b
        public void b(zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zm3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements be2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q63 a;
        public final /* synthetic */ sc2 b;
        public final /* synthetic */ u63 c;

        public b(u63 u63Var, q63 q63Var, sc2 sc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u63Var, q63Var, sc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u63Var;
            this.a = q63Var;
            this.b = sc2Var;
        }

        @Override // com.baidu.tieba.be2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.be2
        public void b(int i, zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zm3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public u63() {
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

    public final void c(q63 q63Var, String str, sc2<r63> sc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q63Var, str, sc2Var) == null) {
            y63.b("local has not main pkg, download fun page main pkg");
            im4 im4Var = new im4(str, fb3.K().k());
            im4Var.q(0L);
            im4Var.t(q63Var.c);
            im4Var.d("3");
            qi4.c(im4Var, new ve2(str, new a(this, q63Var, sc2Var)));
        }
    }

    public final void e(q63 q63Var, p63 p63Var, sc2<r63> sc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, q63Var, p63Var, sc2Var) == null) {
            y63.b("main pkg is exist, download fun page sub pkg");
            String str = p63Var.a;
            int i = p63Var.d;
            qi4.h(new lm4(str, i, e73.e(p63Var.c, p63Var.b), 0), new xe2(str, String.valueOf(i), new b(this, q63Var, sc2Var)));
        }
    }

    public final void d(q63 q63Var, boolean z, sc2<r63> sc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{q63Var, Boolean.valueOf(z), sc2Var}) == null) {
            if (z) {
                p63 f = f(q63Var);
                if (f != null && f.f) {
                    y63.b("payment fun page, download success, ready to jump");
                    j(f.c, q63Var);
                    return;
                }
                y63.b("payment fun page, download success, but not exist");
                r63 r63Var = new r63(q63Var.f);
                r63Var.a = q63Var.e;
                sc2Var.a(r63Var);
                return;
            }
            y63.b("payment fun page, download failed");
            r63 r63Var2 = new r63(q63Var.f);
            r63Var2.a = q63Var.e;
            sc2Var.a(r63Var2);
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

    public final g32 l(q63 q63Var, sc2<r63> sc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, q63Var, sc2Var)) == null) {
            y63.b("open fun page start");
            if (q63Var != null && q63Var.a()) {
                g32 b2 = b(q63Var.g);
                if (b2 != null) {
                    y63.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    y63.b("open payment fun page");
                    p63 f = f(q63Var);
                    if (f == null) {
                        return new g32(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        y63.b("payment fun page, " + q63Var.d + " mode");
                        if (i(q63Var.d)) {
                            if (f.e) {
                                e(q63Var, f, sc2Var);
                            } else {
                                return new g32(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(q63Var, f, sc2Var);
                        } else {
                            c(q63Var, f.a, sc2Var);
                        }
                        y63.b("open fun page end");
                        return new g32(0);
                    }
                    return j(f.c, q63Var);
                } else {
                    y63.b("open user info or choose address fun page");
                    return m(q63Var, sc2Var);
                }
            }
            y63.b("params parse fail");
            return new g32(202, "params parse fail");
        }
        return (g32) invokeLL.objValue;
    }
}
