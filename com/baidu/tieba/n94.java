package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class n94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fj2 a;
    public ze4 b;
    public Context c;
    public c42 d;
    public c42 e;
    public c42 f;
    public p94 g;
    public s94 h;
    public r94 i;
    public r94 j;
    public o94 k;
    public f l;

    /* loaded from: classes7.dex */
    public interface f {
        void a();

        void b(int i);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    /* loaded from: classes7.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n94 a;

        public a(n94 n94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n94Var;
        }

        @Override // com.baidu.tieba.n94.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                s94 s94Var = new s94();
                s94Var.errMsg = "showKeyboard:ok";
                s94Var.height = i;
                he4.call(this.a.d, true, s94Var);
            }
        }

        @Override // com.baidu.tieba.n94.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.a.k != null) {
                this.a.k.c(str);
            }
        }

        @Override // com.baidu.tieba.n94.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && this.a.k != null) {
                this.a.k.b(str);
            }
        }

        @Override // com.baidu.tieba.n94.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && this.a.k != null) {
                this.a.k.d(str);
            }
        }

        @Override // com.baidu.tieba.n94.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n94 a;

        public b(n94 n94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n94Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!af4.p().n(this.a.b)) {
                    this.a.h.errMsg = "showKeyboard:fail";
                    he4.call(this.a.d, false, this.a.h);
                    return;
                }
                this.a.b.j(this.a.g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n94 a;

        public c(n94 n94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n94Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (af4.p().s(this.a.b)) {
                    this.a.i.errMsg = "hideKeyboard:ok";
                    he4.call(this.a.e, true, this.a.i);
                    return;
                }
                this.a.i.errMsg = "hideKeyboard:fail";
                he4.call(this.a.e, false, this.a.i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n94 a;

        public d(n94 n94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n94Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                af4.p().s(this.a.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ n94 b;

        public e(n94 n94Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n94Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n94Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.b.m(this.a)) {
                    this.b.j.errMsg = "updateKeyboard:ok";
                    he4.call(this.b.f, true, this.b.j);
                    return;
                }
                this.b.j.errMsg = "updateKeyboard:fail";
                he4.call(this.b.f, false, this.b.j);
            }
        }
    }

    public n94(fj2 fj2Var, o94 o94Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fj2Var, o94Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        this.l = new a(this);
        this.a = fj2Var;
        Context appContext = AppRuntime.getAppContext();
        this.c = appContext;
        ze4 ze4Var = new ze4(appContext);
        this.b = ze4Var;
        ze4Var.i(this.l);
        this.k = o94Var;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            pp3.e0(new d(this));
        }
    }

    public void k(JsObject jsObject) {
        ze4 ze4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.i = new r94();
            c42 F = c42.F(jsObject);
            this.e = F;
            if (F == null) {
                this.e = new c42();
            }
            if (this.a != null && (ze4Var = this.b) != null && ze4Var.g()) {
                pp3.e0(new c(this));
                return;
            }
            r94 r94Var = this.i;
            r94Var.errMsg = "hideKeyboard:fail";
            he4.call(this.e, false, r94Var);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.j = new r94();
            c42 F = c42.F(jsObject);
            this.f = F;
            if (F == null) {
                this.f = new c42();
            }
            if (this.a != null && this.b != null) {
                pp3.e0(new e(this, this.f.B("value")));
                return;
            }
            r94 r94Var = this.j;
            r94Var.errMsg = "updateKeyboard:fail";
            he4.call(this.f, false, r94Var);
        }
    }

    public void l(JsObject jsObject) {
        ze4 ze4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.h = new s94();
            c42 F = c42.F(jsObject);
            this.d = F;
            if (F == null) {
                this.d = new c42();
            }
            if (this.a != null && (ze4Var = this.b) != null && !ze4Var.g()) {
                p94 p94Var = new p94();
                this.g = p94Var;
                try {
                    if (p94Var.a(this.d)) {
                        pp3.f0(new b(this), 500L);
                    } else {
                        this.h.errMsg = "showKeyboard:fail";
                        he4.call(this.d, false, this.h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    s94 s94Var = this.h;
                    s94Var.errMsg = "showKeyboard:fail";
                    he4.call(this.d, false, s94Var);
                    return;
                }
            }
            s94 s94Var2 = this.h;
            s94Var2.errMsg = "showKeyboard:fail";
            he4.call(this.d, false, s94Var2);
        }
    }
}
