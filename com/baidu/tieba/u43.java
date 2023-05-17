package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vc2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class u43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract g12 b(JSONObject jSONObject);

    public abstract p43 f(q43 q43Var);

    public abstract String g();

    public abstract String h();

    public abstract g12 j(String str, q43 q43Var);

    public abstract boolean k();

    public abstract g12 m(q43 q43Var, sa2<r43> sa2Var);

    /* loaded from: classes7.dex */
    public class a implements vc2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q43 a;
        public final /* synthetic */ sa2 b;
        public final /* synthetic */ u43 c;

        public a(u43 u43Var, q43 q43Var, sa2 sa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u43Var, q43Var, sa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u43Var;
            this.a = q43Var;
            this.b = sa2Var;
        }

        @Override // com.baidu.tieba.vc2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y43.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.vc2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.vc2.b
        public void b(zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zk3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q43 a;
        public final /* synthetic */ sa2 b;
        public final /* synthetic */ u43 c;

        public b(u43 u43Var, q43 q43Var, sa2 sa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u43Var, q43Var, sa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u43Var;
            this.a = q43Var;
            this.b = sa2Var;
        }

        @Override // com.baidu.tieba.bc2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.bc2
        public void b(int i, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zk3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public u43() {
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

    public final void c(q43 q43Var, String str, sa2<r43> sa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q43Var, str, sa2Var) == null) {
            y43.b("local has not main pkg, download fun page main pkg");
            ik4 ik4Var = new ik4(str, f93.K().k());
            ik4Var.q(0L);
            ik4Var.t(q43Var.c);
            ik4Var.d("3");
            qg4.c(ik4Var, new vc2(str, new a(this, q43Var, sa2Var)));
        }
    }

    public final void e(q43 q43Var, p43 p43Var, sa2<r43> sa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, q43Var, p43Var, sa2Var) == null) {
            y43.b("main pkg is exist, download fun page sub pkg");
            String str = p43Var.a;
            int i = p43Var.d;
            qg4.h(new lk4(str, i, e53.e(p43Var.c, p43Var.b), 0), new xc2(str, String.valueOf(i), new b(this, q43Var, sa2Var)));
        }
    }

    public final void d(q43 q43Var, boolean z, sa2<r43> sa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{q43Var, Boolean.valueOf(z), sa2Var}) == null) {
            if (z) {
                p43 f = f(q43Var);
                if (f != null && f.f) {
                    y43.b("payment fun page, download success, ready to jump");
                    j(f.c, q43Var);
                    return;
                }
                y43.b("payment fun page, download success, but not exist");
                r43 r43Var = new r43(q43Var.f);
                r43Var.a = q43Var.e;
                sa2Var.a(r43Var);
                return;
            }
            y43.b("payment fun page, download failed");
            r43 r43Var2 = new r43(q43Var.f);
            r43Var2.a = q43Var.e;
            sa2Var.a(r43Var2);
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

    public final g12 l(q43 q43Var, sa2<r43> sa2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, q43Var, sa2Var)) == null) {
            y43.b("open fun page start");
            if (q43Var != null && q43Var.a()) {
                g12 b2 = b(q43Var.g);
                if (b2 != null) {
                    y43.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    y43.b("open payment fun page");
                    p43 f = f(q43Var);
                    if (f == null) {
                        return new g12(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        y43.b("payment fun page, " + q43Var.d + " mode");
                        if (i(q43Var.d)) {
                            if (f.e) {
                                e(q43Var, f, sa2Var);
                            } else {
                                return new g12(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(q43Var, f, sa2Var);
                        } else {
                            c(q43Var, f.a, sa2Var);
                        }
                        y43.b("open fun page end");
                        return new g12(0);
                    }
                    return j(f.c, q43Var);
                } else {
                    y43.b("open user info or choose address fun page");
                    return m(q43Var, sa2Var);
                }
            }
            y43.b("params parse fail");
            return new g12(202, "params parse fail");
        }
        return (g12) invokeLL.objValue;
    }
}
