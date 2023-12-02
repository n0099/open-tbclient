package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.z92;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class y13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract ly1 b(JSONObject jSONObject);

    public abstract t13 f(u13 u13Var);

    public abstract String g();

    public abstract String h();

    public abstract ly1 j(String str, u13 u13Var);

    public abstract boolean k();

    public abstract ly1 m(u13 u13Var, w72<v13> w72Var);

    /* loaded from: classes9.dex */
    public class a implements z92.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u13 a;
        public final /* synthetic */ w72 b;
        public final /* synthetic */ y13 c;

        public a(y13 y13Var, u13 u13Var, w72 w72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y13Var, u13Var, w72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y13Var;
            this.a = u13Var;
            this.b = w72Var;
        }

        @Override // com.baidu.tieba.z92.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c23.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.z92.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.z92.b
        public void b(di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, di3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements f92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u13 a;
        public final /* synthetic */ w72 b;
        public final /* synthetic */ y13 c;

        public b(y13 y13Var, u13 u13Var, w72 w72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y13Var, u13Var, w72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y13Var;
            this.a = u13Var;
            this.b = w72Var;
        }

        @Override // com.baidu.tieba.f92
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.f92
        public void b(int i, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, di3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public y13() {
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

    public final void c(u13 u13Var, String str, w72<v13> w72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u13Var, str, w72Var) == null) {
            c23.b("local has not main pkg, download fun page main pkg");
            mh4 mh4Var = new mh4(str, j63.K().k());
            mh4Var.q(0L);
            mh4Var.t(u13Var.c);
            mh4Var.d("3");
            ud4.c(mh4Var, new z92(str, new a(this, u13Var, w72Var)));
        }
    }

    public final void e(u13 u13Var, t13 t13Var, w72<v13> w72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, u13Var, t13Var, w72Var) == null) {
            c23.b("main pkg is exist, download fun page sub pkg");
            String str = t13Var.a;
            int i = t13Var.d;
            ud4.h(new ph4(str, i, i23.e(t13Var.c, t13Var.b), 0), new ba2(str, String.valueOf(i), new b(this, u13Var, w72Var)));
        }
    }

    public final void d(u13 u13Var, boolean z, w72<v13> w72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{u13Var, Boolean.valueOf(z), w72Var}) == null) {
            if (z) {
                t13 f = f(u13Var);
                if (f != null && f.f) {
                    c23.b("payment fun page, download success, ready to jump");
                    j(f.c, u13Var);
                    return;
                }
                c23.b("payment fun page, download success, but not exist");
                v13 v13Var = new v13(u13Var.f);
                v13Var.a = u13Var.e;
                w72Var.a(v13Var);
                return;
            }
            c23.b("payment fun page, download failed");
            v13 v13Var2 = new v13(u13Var.f);
            v13Var2.a = u13Var.e;
            w72Var.a(v13Var2);
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

    public final ly1 l(u13 u13Var, w72<v13> w72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, u13Var, w72Var)) == null) {
            c23.b("open fun page start");
            if (u13Var != null && u13Var.a()) {
                ly1 b2 = b(u13Var.g);
                if (b2 != null) {
                    c23.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    c23.b("open payment fun page");
                    t13 f = f(u13Var);
                    if (f == null) {
                        return new ly1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        c23.b("payment fun page, " + u13Var.d + " mode");
                        if (i(u13Var.d)) {
                            if (f.e) {
                                e(u13Var, f, w72Var);
                            } else {
                                return new ly1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(u13Var, f, w72Var);
                        } else {
                            c(u13Var, f.a, w72Var);
                        }
                        c23.b("open fun page end");
                        return new ly1(0);
                    }
                    return j(f.c, u13Var);
                } else {
                    c23.b("open user info or choose address fun page");
                    return m(u13Var, w72Var);
                }
            }
            c23.b("params parse fail");
            return new ly1(202, "params parse fail");
        }
        return (ly1) invokeLL.objValue;
    }
}
