package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n62;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class my2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements n62.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy2 a;
        public final /* synthetic */ k42 b;
        public final /* synthetic */ my2 c;

        public a(my2 my2Var, iy2 iy2Var, k42 k42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my2Var, iy2Var, k42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = my2Var;
            this.a = iy2Var;
            this.b = k42Var;
        }

        @Override // com.baidu.tieba.n62.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qy2.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.n62.b
        public void b(re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, re3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }

        @Override // com.baidu.tieba.n62.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements t52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy2 a;
        public final /* synthetic */ k42 b;
        public final /* synthetic */ my2 c;

        public b(my2 my2Var, iy2 iy2Var, k42 k42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my2Var, iy2Var, k42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = my2Var;
            this.a = iy2Var;
            this.b = k42Var;
        }

        @Override // com.baidu.tieba.t52
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.t52
        public void b(int i, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, re3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public my2() {
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

    public abstract yu1 b(JSONObject jSONObject);

    public final void c(iy2 iy2Var, String str, k42<jy2> k42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iy2Var, str, k42Var) == null) {
            qy2.b("local has not main pkg, download fun page main pkg");
            ae4 ae4Var = new ae4(str, x23.K().k());
            ae4Var.q(0L);
            ae4Var.t(iy2Var.c);
            ae4Var.d("3");
            ia4.c(ae4Var, new n62(str, new a(this, iy2Var, k42Var)));
        }
    }

    public final void d(iy2 iy2Var, boolean z, k42<jy2> k42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{iy2Var, Boolean.valueOf(z), k42Var}) == null) {
            if (z) {
                hy2 f = f(iy2Var);
                if (f != null && f.f) {
                    qy2.b("payment fun page, download success, ready to jump");
                    j(f.c, iy2Var);
                    return;
                }
                qy2.b("payment fun page, download success, but not exist");
                jy2 jy2Var = new jy2(iy2Var.f);
                jy2Var.a = iy2Var.e;
                k42Var.a(jy2Var);
                return;
            }
            qy2.b("payment fun page, download failed");
            jy2 jy2Var2 = new jy2(iy2Var.f);
            jy2Var2.a = iy2Var.e;
            k42Var.a(jy2Var2);
        }
    }

    public final void e(iy2 iy2Var, hy2 hy2Var, k42<jy2> k42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, iy2Var, hy2Var, k42Var) == null) {
            qy2.b("main pkg is exist, download fun page sub pkg");
            String str = hy2Var.a;
            int i = hy2Var.d;
            ia4.h(new de4(str, i, wy2.e(hy2Var.c, hy2Var.b), 0), new p62(str, String.valueOf(i), new b(this, iy2Var, k42Var)));
        }
    }

    public abstract hy2 f(iy2 iy2Var);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract yu1 j(String str, iy2 iy2Var);

    public abstract boolean k();

    public final yu1 l(iy2 iy2Var, k42<jy2> k42Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, iy2Var, k42Var)) == null) {
            qy2.b("open fun page start");
            if (iy2Var != null && iy2Var.a()) {
                yu1 b2 = b(iy2Var.g);
                if (b2 != null) {
                    qy2.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    qy2.b("open payment fun page");
                    hy2 f = f(iy2Var);
                    if (f == null) {
                        return new yu1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        qy2.b("payment fun page, " + iy2Var.d + " mode");
                        if (i(iy2Var.d)) {
                            if (f.e) {
                                e(iy2Var, f, k42Var);
                            } else {
                                return new yu1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(iy2Var, f, k42Var);
                        } else {
                            c(iy2Var, f.a, k42Var);
                        }
                        qy2.b("open fun page end");
                        return new yu1(0);
                    }
                    return j(f.c, iy2Var);
                } else {
                    qy2.b("open user info or choose address fun page");
                    return m(iy2Var, k42Var);
                }
            }
            qy2.b("params parse fail");
            return new yu1(202, "params parse fail");
        }
        return (yu1) invokeLL.objValue;
    }

    public abstract yu1 m(iy2 iy2Var, k42<jy2> k42Var);
}
