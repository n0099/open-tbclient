package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class sz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract ew1 b(JSONObject jSONObject);

    public abstract nz2 f(oz2 oz2Var);

    public abstract String g();

    public abstract String h();

    public abstract ew1 j(String str, oz2 oz2Var);

    public abstract boolean k();

    public abstract ew1 m(oz2 oz2Var, q52<pz2> q52Var);

    /* loaded from: classes6.dex */
    public class a implements t72.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oz2 a;
        public final /* synthetic */ q52 b;
        public final /* synthetic */ sz2 c;

        public a(sz2 sz2Var, oz2 oz2Var, q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz2Var, oz2Var, q52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sz2Var;
            this.a = oz2Var;
            this.b = q52Var;
        }

        @Override // com.baidu.tieba.t72.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wz2.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.t72.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.t72.b
        public void b(xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xf3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements z62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oz2 a;
        public final /* synthetic */ q52 b;
        public final /* synthetic */ sz2 c;

        public b(sz2 sz2Var, oz2 oz2Var, q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz2Var, oz2Var, q52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sz2Var;
            this.a = oz2Var;
            this.b = q52Var;
        }

        @Override // com.baidu.tieba.z62
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.z62
        public void b(int i, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, xf3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public sz2() {
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

    public final void c(oz2 oz2Var, String str, q52<pz2> q52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oz2Var, str, q52Var) == null) {
            wz2.b("local has not main pkg, download fun page main pkg");
            gf4 gf4Var = new gf4(str, d43.K().k());
            gf4Var.q(0L);
            gf4Var.t(oz2Var.c);
            gf4Var.d("3");
            ob4.c(gf4Var, new t72(str, new a(this, oz2Var, q52Var)));
        }
    }

    public final void e(oz2 oz2Var, nz2 nz2Var, q52<pz2> q52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, oz2Var, nz2Var, q52Var) == null) {
            wz2.b("main pkg is exist, download fun page sub pkg");
            String str = nz2Var.a;
            int i = nz2Var.d;
            ob4.h(new jf4(str, i, c03.e(nz2Var.c, nz2Var.b), 0), new v72(str, String.valueOf(i), new b(this, oz2Var, q52Var)));
        }
    }

    public final void d(oz2 oz2Var, boolean z, q52<pz2> q52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{oz2Var, Boolean.valueOf(z), q52Var}) == null) {
            if (z) {
                nz2 f = f(oz2Var);
                if (f != null && f.f) {
                    wz2.b("payment fun page, download success, ready to jump");
                    j(f.c, oz2Var);
                    return;
                }
                wz2.b("payment fun page, download success, but not exist");
                pz2 pz2Var = new pz2(oz2Var.f);
                pz2Var.a = oz2Var.e;
                q52Var.a(pz2Var);
                return;
            }
            wz2.b("payment fun page, download failed");
            pz2 pz2Var2 = new pz2(oz2Var.f);
            pz2Var2.a = oz2Var.e;
            q52Var.a(pz2Var2);
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

    public final ew1 l(oz2 oz2Var, q52<pz2> q52Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, oz2Var, q52Var)) == null) {
            wz2.b("open fun page start");
            if (oz2Var != null && oz2Var.a()) {
                ew1 b2 = b(oz2Var.g);
                if (b2 != null) {
                    wz2.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    wz2.b("open payment fun page");
                    nz2 f = f(oz2Var);
                    if (f == null) {
                        return new ew1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        wz2.b("payment fun page, " + oz2Var.d + " mode");
                        if (i(oz2Var.d)) {
                            if (f.e) {
                                e(oz2Var, f, q52Var);
                            } else {
                                return new ew1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(oz2Var, f, q52Var);
                        } else {
                            c(oz2Var, f.a, q52Var);
                        }
                        wz2.b("open fun page end");
                        return new ew1(0);
                    }
                    return j(f.c, oz2Var);
                } else {
                    wz2.b("open user info or choose address fun page");
                    return m(oz2Var, q52Var);
                }
            }
            wz2.b("params parse fail");
            return new ew1(202, "params parse fail");
        }
        return (ew1) invokeLL.objValue;
    }
}
