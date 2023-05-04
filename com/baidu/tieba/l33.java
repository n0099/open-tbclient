package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.mb2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class l33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract xz1 b(JSONObject jSONObject);

    public abstract g33 f(h33 h33Var);

    public abstract String g();

    public abstract String h();

    public abstract xz1 j(String str, h33 h33Var);

    public abstract boolean k();

    public abstract xz1 m(h33 h33Var, j92<i33> j92Var);

    /* loaded from: classes5.dex */
    public class a implements mb2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h33 a;
        public final /* synthetic */ j92 b;
        public final /* synthetic */ l33 c;

        public a(l33 l33Var, h33 h33Var, j92 j92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l33Var, h33Var, j92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l33Var;
            this.a = h33Var;
            this.b = j92Var;
        }

        @Override // com.baidu.tieba.mb2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p33.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.mb2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.mb2.b
        public void b(qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qj3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements sa2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h33 a;
        public final /* synthetic */ j92 b;
        public final /* synthetic */ l33 c;

        public b(l33 l33Var, h33 h33Var, j92 j92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l33Var, h33Var, j92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l33Var;
            this.a = h33Var;
            this.b = j92Var;
        }

        @Override // com.baidu.tieba.sa2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.sa2
        public void b(int i, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, qj3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public l33() {
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

    public final void c(h33 h33Var, String str, j92<i33> j92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h33Var, str, j92Var) == null) {
            p33.b("local has not main pkg, download fun page main pkg");
            zi4 zi4Var = new zi4(str, w73.K().k());
            zi4Var.q(0L);
            zi4Var.t(h33Var.c);
            zi4Var.d("3");
            hf4.c(zi4Var, new mb2(str, new a(this, h33Var, j92Var)));
        }
    }

    public final void e(h33 h33Var, g33 g33Var, j92<i33> j92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, h33Var, g33Var, j92Var) == null) {
            p33.b("main pkg is exist, download fun page sub pkg");
            String str = g33Var.a;
            int i = g33Var.d;
            hf4.h(new cj4(str, i, v33.e(g33Var.c, g33Var.b), 0), new ob2(str, String.valueOf(i), new b(this, h33Var, j92Var)));
        }
    }

    public final void d(h33 h33Var, boolean z, j92<i33> j92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{h33Var, Boolean.valueOf(z), j92Var}) == null) {
            if (z) {
                g33 f = f(h33Var);
                if (f != null && f.f) {
                    p33.b("payment fun page, download success, ready to jump");
                    j(f.c, h33Var);
                    return;
                }
                p33.b("payment fun page, download success, but not exist");
                i33 i33Var = new i33(h33Var.f);
                i33Var.a = h33Var.e;
                j92Var.a(i33Var);
                return;
            }
            p33.b("payment fun page, download failed");
            i33 i33Var2 = new i33(h33Var.f);
            i33Var2.a = h33Var.e;
            j92Var.a(i33Var2);
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

    public final xz1 l(h33 h33Var, j92<i33> j92Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, h33Var, j92Var)) == null) {
            p33.b("open fun page start");
            if (h33Var != null && h33Var.a()) {
                xz1 b2 = b(h33Var.g);
                if (b2 != null) {
                    p33.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    p33.b("open payment fun page");
                    g33 f = f(h33Var);
                    if (f == null) {
                        return new xz1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        p33.b("payment fun page, " + h33Var.d + " mode");
                        if (i(h33Var.d)) {
                            if (f.e) {
                                e(h33Var, f, j92Var);
                            } else {
                                return new xz1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(h33Var, f, j92Var);
                        } else {
                            c(h33Var, f.a, j92Var);
                        }
                        p33.b("open fun page end");
                        return new xz1(0);
                    }
                    return j(f.c, h33Var);
                } else {
                    p33.b("open user info or choose address fun page");
                    return m(h33Var, j92Var);
                }
            }
            p33.b("params parse fail");
            return new xz1(202, "params parse fail");
        }
        return (xz1) invokeLL.objValue;
    }
}
