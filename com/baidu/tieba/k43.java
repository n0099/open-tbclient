package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lc2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class k43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract w02 b(JSONObject jSONObject);

    public abstract f43 f(g43 g43Var);

    public abstract String g();

    public abstract String h();

    public abstract w02 j(String str, g43 g43Var);

    public abstract boolean k();

    public abstract w02 m(g43 g43Var, ia2<h43> ia2Var);

    /* loaded from: classes5.dex */
    public class a implements lc2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g43 a;
        public final /* synthetic */ ia2 b;
        public final /* synthetic */ k43 c;

        public a(k43 k43Var, g43 g43Var, ia2 ia2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k43Var, g43Var, ia2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = k43Var;
            this.a = g43Var;
            this.b = ia2Var;
        }

        @Override // com.baidu.tieba.lc2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o43.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.lc2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.lc2.b
        public void b(pk3 pk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pk3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements rb2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g43 a;
        public final /* synthetic */ ia2 b;
        public final /* synthetic */ k43 c;

        public b(k43 k43Var, g43 g43Var, ia2 ia2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k43Var, g43Var, ia2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = k43Var;
            this.a = g43Var;
            this.b = ia2Var;
        }

        @Override // com.baidu.tieba.rb2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.rb2
        public void b(int i, pk3 pk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, pk3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public k43() {
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

    public final void c(g43 g43Var, String str, ia2<h43> ia2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g43Var, str, ia2Var) == null) {
            o43.b("local has not main pkg, download fun page main pkg");
            yj4 yj4Var = new yj4(str, v83.K().k());
            yj4Var.q(0L);
            yj4Var.t(g43Var.c);
            yj4Var.d("3");
            gg4.c(yj4Var, new lc2(str, new a(this, g43Var, ia2Var)));
        }
    }

    public final void e(g43 g43Var, f43 f43Var, ia2<h43> ia2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, g43Var, f43Var, ia2Var) == null) {
            o43.b("main pkg is exist, download fun page sub pkg");
            String str = f43Var.a;
            int i = f43Var.d;
            gg4.h(new bk4(str, i, u43.e(f43Var.c, f43Var.b), 0), new nc2(str, String.valueOf(i), new b(this, g43Var, ia2Var)));
        }
    }

    public final void d(g43 g43Var, boolean z, ia2<h43> ia2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{g43Var, Boolean.valueOf(z), ia2Var}) == null) {
            if (z) {
                f43 f = f(g43Var);
                if (f != null && f.f) {
                    o43.b("payment fun page, download success, ready to jump");
                    j(f.c, g43Var);
                    return;
                }
                o43.b("payment fun page, download success, but not exist");
                h43 h43Var = new h43(g43Var.f);
                h43Var.a = g43Var.e;
                ia2Var.a(h43Var);
                return;
            }
            o43.b("payment fun page, download failed");
            h43 h43Var2 = new h43(g43Var.f);
            h43Var2.a = g43Var.e;
            ia2Var.a(h43Var2);
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

    public final w02 l(g43 g43Var, ia2<h43> ia2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, g43Var, ia2Var)) == null) {
            o43.b("open fun page start");
            if (g43Var != null && g43Var.a()) {
                w02 b2 = b(g43Var.g);
                if (b2 != null) {
                    o43.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    o43.b("open payment fun page");
                    f43 f = f(g43Var);
                    if (f == null) {
                        return new w02(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        o43.b("payment fun page, " + g43Var.d + " mode");
                        if (i(g43Var.d)) {
                            if (f.e) {
                                e(g43Var, f, ia2Var);
                            } else {
                                return new w02(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(g43Var, f, ia2Var);
                        } else {
                            c(g43Var, f.a, ia2Var);
                        }
                        o43.b("open fun page end");
                        return new w02(0);
                    }
                    return j(f.c, g43Var);
                } else {
                    o43.b("open user info or choose address fun page");
                    return m(g43Var, ia2Var);
                }
            }
            o43.b("params parse fail");
            return new w02(202, "params parse fail");
        }
        return (w02) invokeLL.objValue;
    }
}
