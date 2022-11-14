package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class tz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract fw1 b(JSONObject jSONObject);

    public abstract oz2 f(pz2 pz2Var);

    public abstract String g();

    public abstract String h();

    public abstract fw1 j(String str, pz2 pz2Var);

    public abstract boolean k();

    public abstract fw1 m(pz2 pz2Var, r52<qz2> r52Var);

    /* loaded from: classes6.dex */
    public class a implements u72.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz2 a;
        public final /* synthetic */ r52 b;
        public final /* synthetic */ tz2 c;

        public a(tz2 tz2Var, pz2 pz2Var, r52 r52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz2Var, pz2Var, r52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tz2Var;
            this.a = pz2Var;
            this.b = r52Var;
        }

        @Override // com.baidu.tieba.u72.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xz2.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.u72.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.u72.b
        public void b(yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yf3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz2 a;
        public final /* synthetic */ r52 b;
        public final /* synthetic */ tz2 c;

        public b(tz2 tz2Var, pz2 pz2Var, r52 r52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz2Var, pz2Var, r52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tz2Var;
            this.a = pz2Var;
            this.b = r52Var;
        }

        @Override // com.baidu.tieba.a72
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.a72
        public void b(int i, yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, yf3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public tz2() {
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

    public final void c(pz2 pz2Var, String str, r52<qz2> r52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pz2Var, str, r52Var) == null) {
            xz2.b("local has not main pkg, download fun page main pkg");
            hf4 hf4Var = new hf4(str, e43.K().k());
            hf4Var.q(0L);
            hf4Var.t(pz2Var.c);
            hf4Var.d("3");
            pb4.c(hf4Var, new u72(str, new a(this, pz2Var, r52Var)));
        }
    }

    public final void e(pz2 pz2Var, oz2 oz2Var, r52<qz2> r52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, pz2Var, oz2Var, r52Var) == null) {
            xz2.b("main pkg is exist, download fun page sub pkg");
            String str = oz2Var.a;
            int i = oz2Var.d;
            pb4.h(new kf4(str, i, d03.e(oz2Var.c, oz2Var.b), 0), new w72(str, String.valueOf(i), new b(this, pz2Var, r52Var)));
        }
    }

    public final void d(pz2 pz2Var, boolean z, r52<qz2> r52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pz2Var, Boolean.valueOf(z), r52Var}) == null) {
            if (z) {
                oz2 f = f(pz2Var);
                if (f != null && f.f) {
                    xz2.b("payment fun page, download success, ready to jump");
                    j(f.c, pz2Var);
                    return;
                }
                xz2.b("payment fun page, download success, but not exist");
                qz2 qz2Var = new qz2(pz2Var.f);
                qz2Var.a = pz2Var.e;
                r52Var.a(qz2Var);
                return;
            }
            xz2.b("payment fun page, download failed");
            qz2 qz2Var2 = new qz2(pz2Var.f);
            qz2Var2.a = pz2Var.e;
            r52Var.a(qz2Var2);
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

    public final fw1 l(pz2 pz2Var, r52<qz2> r52Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, pz2Var, r52Var)) == null) {
            xz2.b("open fun page start");
            if (pz2Var != null && pz2Var.a()) {
                fw1 b2 = b(pz2Var.g);
                if (b2 != null) {
                    xz2.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    xz2.b("open payment fun page");
                    oz2 f = f(pz2Var);
                    if (f == null) {
                        return new fw1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        xz2.b("payment fun page, " + pz2Var.d + " mode");
                        if (i(pz2Var.d)) {
                            if (f.e) {
                                e(pz2Var, f, r52Var);
                            } else {
                                return new fw1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(pz2Var, f, r52Var);
                        } else {
                            c(pz2Var, f.a, r52Var);
                        }
                        xz2.b("open fun page end");
                        return new fw1(0);
                    }
                    return j(f.c, pz2Var);
                } else {
                    xz2.b("open user info or choose address fun page");
                    return m(pz2Var, r52Var);
                }
            }
            xz2.b("params parse fail");
            return new fw1(202, "params parse fail");
        }
        return (fw1) invokeLL.objValue;
    }
}
