package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.of2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class n73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract z32 b(JSONObject jSONObject);

    public abstract i73 f(j73 j73Var);

    public abstract String g();

    public abstract String h();

    public abstract z32 j(String str, j73 j73Var);

    public abstract boolean k();

    public abstract z32 m(j73 j73Var, ld2<k73> ld2Var);

    /* loaded from: classes6.dex */
    public class a implements of2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j73 a;
        public final /* synthetic */ ld2 b;
        public final /* synthetic */ n73 c;

        public a(n73 n73Var, j73 j73Var, ld2 ld2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n73Var, j73Var, ld2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n73Var;
            this.a = j73Var;
            this.b = ld2Var;
        }

        @Override // com.baidu.tieba.of2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r73.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.of2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.of2.b
        public void b(sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sn3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ue2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j73 a;
        public final /* synthetic */ ld2 b;
        public final /* synthetic */ n73 c;

        public b(n73 n73Var, j73 j73Var, ld2 ld2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n73Var, j73Var, ld2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n73Var;
            this.a = j73Var;
            this.b = ld2Var;
        }

        @Override // com.baidu.tieba.ue2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.ue2
        public void b(int i, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sn3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public n73() {
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

    public final void c(j73 j73Var, String str, ld2<k73> ld2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j73Var, str, ld2Var) == null) {
            r73.b("local has not main pkg, download fun page main pkg");
            bn4 bn4Var = new bn4(str, yb3.K().k());
            bn4Var.q(0L);
            bn4Var.t(j73Var.c);
            bn4Var.d("3");
            jj4.c(bn4Var, new of2(str, new a(this, j73Var, ld2Var)));
        }
    }

    public final void e(j73 j73Var, i73 i73Var, ld2<k73> ld2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, j73Var, i73Var, ld2Var) == null) {
            r73.b("main pkg is exist, download fun page sub pkg");
            String str = i73Var.a;
            int i = i73Var.d;
            jj4.h(new en4(str, i, x73.e(i73Var.c, i73Var.b), 0), new qf2(str, String.valueOf(i), new b(this, j73Var, ld2Var)));
        }
    }

    public final void d(j73 j73Var, boolean z, ld2<k73> ld2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{j73Var, Boolean.valueOf(z), ld2Var}) == null) {
            if (z) {
                i73 f = f(j73Var);
                if (f != null && f.f) {
                    r73.b("payment fun page, download success, ready to jump");
                    j(f.c, j73Var);
                    return;
                }
                r73.b("payment fun page, download success, but not exist");
                k73 k73Var = new k73(j73Var.f);
                k73Var.a = j73Var.e;
                ld2Var.a(k73Var);
                return;
            }
            r73.b("payment fun page, download failed");
            k73 k73Var2 = new k73(j73Var.f);
            k73Var2.a = j73Var.e;
            ld2Var.a(k73Var2);
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

    public final z32 l(j73 j73Var, ld2<k73> ld2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, j73Var, ld2Var)) == null) {
            r73.b("open fun page start");
            if (j73Var != null && j73Var.a()) {
                z32 b2 = b(j73Var.g);
                if (b2 != null) {
                    r73.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    r73.b("open payment fun page");
                    i73 f = f(j73Var);
                    if (f == null) {
                        return new z32(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        r73.b("payment fun page, " + j73Var.d + " mode");
                        if (i(j73Var.d)) {
                            if (f.e) {
                                e(j73Var, f, ld2Var);
                            } else {
                                return new z32(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(j73Var, f, ld2Var);
                        } else {
                            c(j73Var, f.a, ld2Var);
                        }
                        r73.b("open fun page end");
                        return new z32(0);
                    }
                    return j(f.c, j73Var);
                } else {
                    r73.b("open user info or choose address fun page");
                    return m(j73Var, ld2Var);
                }
            }
            r73.b("params parse fail");
            return new z32(202, "params parse fail");
        }
        return (z32) invokeLL.objValue;
    }
}
