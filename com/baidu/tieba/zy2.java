package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class zy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements a72.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy2 a;
        public final /* synthetic */ x42 b;
        public final /* synthetic */ zy2 c;

        public a(zy2 zy2Var, vy2 vy2Var, x42 x42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy2Var, vy2Var, x42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zy2Var;
            this.a = vy2Var;
            this.b = x42Var;
        }

        @Override // com.baidu.tieba.a72.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dz2.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.a72.b
        public void b(ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }

        @Override // com.baidu.tieba.a72.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements g62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy2 a;
        public final /* synthetic */ x42 b;
        public final /* synthetic */ zy2 c;

        public b(zy2 zy2Var, vy2 vy2Var, x42 x42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy2Var, vy2Var, x42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zy2Var;
            this.a = vy2Var;
            this.b = x42Var;
        }

        @Override // com.baidu.tieba.g62
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.g62
        public void b(int i, ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ef3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public zy2() {
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

    public abstract lv1 b(JSONObject jSONObject);

    public final void c(vy2 vy2Var, String str, x42<wy2> x42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vy2Var, str, x42Var) == null) {
            dz2.b("local has not main pkg, download fun page main pkg");
            ne4 ne4Var = new ne4(str, k33.K().k());
            ne4Var.q(0L);
            ne4Var.t(vy2Var.c);
            ne4Var.d("3");
            va4.c(ne4Var, new a72(str, new a(this, vy2Var, x42Var)));
        }
    }

    public final void d(vy2 vy2Var, boolean z, x42<wy2> x42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{vy2Var, Boolean.valueOf(z), x42Var}) == null) {
            if (z) {
                uy2 f = f(vy2Var);
                if (f != null && f.f) {
                    dz2.b("payment fun page, download success, ready to jump");
                    j(f.c, vy2Var);
                    return;
                }
                dz2.b("payment fun page, download success, but not exist");
                wy2 wy2Var = new wy2(vy2Var.f);
                wy2Var.a = vy2Var.e;
                x42Var.a(wy2Var);
                return;
            }
            dz2.b("payment fun page, download failed");
            wy2 wy2Var2 = new wy2(vy2Var.f);
            wy2Var2.a = vy2Var.e;
            x42Var.a(wy2Var2);
        }
    }

    public final void e(vy2 vy2Var, uy2 uy2Var, x42<wy2> x42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, vy2Var, uy2Var, x42Var) == null) {
            dz2.b("main pkg is exist, download fun page sub pkg");
            String str = uy2Var.a;
            int i = uy2Var.d;
            va4.h(new qe4(str, i, jz2.e(uy2Var.c, uy2Var.b), 0), new c72(str, String.valueOf(i), new b(this, vy2Var, x42Var)));
        }
    }

    public abstract uy2 f(vy2 vy2Var);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract lv1 j(String str, vy2 vy2Var);

    public abstract boolean k();

    public final lv1 l(vy2 vy2Var, x42<wy2> x42Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, vy2Var, x42Var)) == null) {
            dz2.b("open fun page start");
            if (vy2Var != null && vy2Var.a()) {
                lv1 b2 = b(vy2Var.g);
                if (b2 != null) {
                    dz2.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    dz2.b("open payment fun page");
                    uy2 f = f(vy2Var);
                    if (f == null) {
                        return new lv1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        dz2.b("payment fun page, " + vy2Var.d + " mode");
                        if (i(vy2Var.d)) {
                            if (f.e) {
                                e(vy2Var, f, x42Var);
                            } else {
                                return new lv1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(vy2Var, f, x42Var);
                        } else {
                            c(vy2Var, f.a, x42Var);
                        }
                        dz2.b("open fun page end");
                        return new lv1(0);
                    }
                    return j(f.c, vy2Var);
                } else {
                    dz2.b("open user info or choose address fun page");
                    return m(vy2Var, x42Var);
                }
            }
            dz2.b("params parse fail");
            return new lv1(202, "params parse fail");
        }
        return (lv1) invokeLL.objValue;
    }

    public abstract lv1 m(vy2 vy2Var, x42<wy2> x42Var);
}
