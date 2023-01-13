package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.y72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class xz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract jw1 b(JSONObject jSONObject);

    public abstract sz2 f(tz2 tz2Var);

    public abstract String g();

    public abstract String h();

    public abstract jw1 j(String str, tz2 tz2Var);

    public abstract boolean k();

    public abstract jw1 m(tz2 tz2Var, v52<uz2> v52Var);

    /* loaded from: classes6.dex */
    public class a implements y72.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz2 a;
        public final /* synthetic */ v52 b;
        public final /* synthetic */ xz2 c;

        public a(xz2 xz2Var, tz2 tz2Var, v52 v52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz2Var, tz2Var, v52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xz2Var;
            this.a = tz2Var;
            this.b = v52Var;
        }

        @Override // com.baidu.tieba.y72.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b03.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.y72.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.y72.b
        public void b(cg3 cg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cg3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements e72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz2 a;
        public final /* synthetic */ v52 b;
        public final /* synthetic */ xz2 c;

        public b(xz2 xz2Var, tz2 tz2Var, v52 v52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz2Var, tz2Var, v52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xz2Var;
            this.a = tz2Var;
            this.b = v52Var;
        }

        @Override // com.baidu.tieba.e72
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.e72
        public void b(int i, cg3 cg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cg3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public xz2() {
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

    public final void c(tz2 tz2Var, String str, v52<uz2> v52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tz2Var, str, v52Var) == null) {
            b03.b("local has not main pkg, download fun page main pkg");
            lf4 lf4Var = new lf4(str, i43.K().k());
            lf4Var.q(0L);
            lf4Var.t(tz2Var.c);
            lf4Var.d("3");
            tb4.c(lf4Var, new y72(str, new a(this, tz2Var, v52Var)));
        }
    }

    public final void e(tz2 tz2Var, sz2 sz2Var, v52<uz2> v52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tz2Var, sz2Var, v52Var) == null) {
            b03.b("main pkg is exist, download fun page sub pkg");
            String str = sz2Var.a;
            int i = sz2Var.d;
            tb4.h(new of4(str, i, h03.e(sz2Var.c, sz2Var.b), 0), new a82(str, String.valueOf(i), new b(this, tz2Var, v52Var)));
        }
    }

    public final void d(tz2 tz2Var, boolean z, v52<uz2> v52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tz2Var, Boolean.valueOf(z), v52Var}) == null) {
            if (z) {
                sz2 f = f(tz2Var);
                if (f != null && f.f) {
                    b03.b("payment fun page, download success, ready to jump");
                    j(f.c, tz2Var);
                    return;
                }
                b03.b("payment fun page, download success, but not exist");
                uz2 uz2Var = new uz2(tz2Var.f);
                uz2Var.a = tz2Var.e;
                v52Var.a(uz2Var);
                return;
            }
            b03.b("payment fun page, download failed");
            uz2 uz2Var2 = new uz2(tz2Var.f);
            uz2Var2.a = tz2Var.e;
            v52Var.a(uz2Var2);
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

    public final jw1 l(tz2 tz2Var, v52<uz2> v52Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, tz2Var, v52Var)) == null) {
            b03.b("open fun page start");
            if (tz2Var != null && tz2Var.a()) {
                jw1 b2 = b(tz2Var.g);
                if (b2 != null) {
                    b03.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    b03.b("open payment fun page");
                    sz2 f = f(tz2Var);
                    if (f == null) {
                        return new jw1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        b03.b("payment fun page, " + tz2Var.d + " mode");
                        if (i(tz2Var.d)) {
                            if (f.e) {
                                e(tz2Var, f, v52Var);
                            } else {
                                return new jw1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(tz2Var, f, v52Var);
                        } else {
                            c(tz2Var, f.a, v52Var);
                        }
                        b03.b("open fun page end");
                        return new jw1(0);
                    }
                    return j(f.c, tz2Var);
                } else {
                    b03.b("open user info or choose address fun page");
                    return m(tz2Var, v52Var);
                }
            }
            b03.b("params parse fail");
            return new jw1(202, "params parse fail");
        }
        return (jw1) invokeLL.objValue;
    }
}
