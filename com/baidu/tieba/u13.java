package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.v92;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class u13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract hy1 b(JSONObject jSONObject);

    public abstract p13 f(q13 q13Var);

    public abstract String g();

    public abstract String h();

    public abstract hy1 j(String str, q13 q13Var);

    public abstract boolean k();

    public abstract hy1 m(q13 q13Var, s72<r13> s72Var);

    /* loaded from: classes8.dex */
    public class a implements v92.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q13 a;
        public final /* synthetic */ s72 b;
        public final /* synthetic */ u13 c;

        public a(u13 u13Var, q13 q13Var, s72 s72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u13Var, q13Var, s72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u13Var;
            this.a = q13Var;
            this.b = s72Var;
        }

        @Override // com.baidu.tieba.v92.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y13.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.v92.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.v92.b
        public void b(zh3 zh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zh3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements b92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q13 a;
        public final /* synthetic */ s72 b;
        public final /* synthetic */ u13 c;

        public b(u13 u13Var, q13 q13Var, s72 s72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u13Var, q13Var, s72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u13Var;
            this.a = q13Var;
            this.b = s72Var;
        }

        @Override // com.baidu.tieba.b92
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.b92
        public void b(int i, zh3 zh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zh3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public u13() {
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

    public final void c(q13 q13Var, String str, s72<r13> s72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q13Var, str, s72Var) == null) {
            y13.b("local has not main pkg, download fun page main pkg");
            ih4 ih4Var = new ih4(str, f63.K().k());
            ih4Var.q(0L);
            ih4Var.t(q13Var.c);
            ih4Var.d("3");
            qd4.c(ih4Var, new v92(str, new a(this, q13Var, s72Var)));
        }
    }

    public final void e(q13 q13Var, p13 p13Var, s72<r13> s72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, q13Var, p13Var, s72Var) == null) {
            y13.b("main pkg is exist, download fun page sub pkg");
            String str = p13Var.a;
            int i = p13Var.d;
            qd4.h(new lh4(str, i, e23.e(p13Var.c, p13Var.b), 0), new x92(str, String.valueOf(i), new b(this, q13Var, s72Var)));
        }
    }

    public final void d(q13 q13Var, boolean z, s72<r13> s72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{q13Var, Boolean.valueOf(z), s72Var}) == null) {
            if (z) {
                p13 f = f(q13Var);
                if (f != null && f.f) {
                    y13.b("payment fun page, download success, ready to jump");
                    j(f.c, q13Var);
                    return;
                }
                y13.b("payment fun page, download success, but not exist");
                r13 r13Var = new r13(q13Var.f);
                r13Var.a = q13Var.e;
                s72Var.a(r13Var);
                return;
            }
            y13.b("payment fun page, download failed");
            r13 r13Var2 = new r13(q13Var.f);
            r13Var2.a = q13Var.e;
            s72Var.a(r13Var2);
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

    public final hy1 l(q13 q13Var, s72<r13> s72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, q13Var, s72Var)) == null) {
            y13.b("open fun page start");
            if (q13Var != null && q13Var.a()) {
                hy1 b2 = b(q13Var.g);
                if (b2 != null) {
                    y13.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    y13.b("open payment fun page");
                    p13 f = f(q13Var);
                    if (f == null) {
                        return new hy1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        y13.b("payment fun page, " + q13Var.d + " mode");
                        if (i(q13Var.d)) {
                            if (f.e) {
                                e(q13Var, f, s72Var);
                            } else {
                                return new hy1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(q13Var, f, s72Var);
                        } else {
                            c(q13Var, f.a, s72Var);
                        }
                        y13.b("open fun page end");
                        return new hy1(0);
                    }
                    return j(f.c, q13Var);
                } else {
                    y13.b("open user info or choose address fun page");
                    return m(q13Var, s72Var);
                }
            }
            y13.b("params parse fail");
            return new hy1(202, "params parse fail");
        }
        return (hy1) invokeLL.objValue;
    }
}
