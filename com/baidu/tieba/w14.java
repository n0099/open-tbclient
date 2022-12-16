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
/* loaded from: classes6.dex */
public class w14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ob2 a;
    public i74 b;
    public Context c;
    public lw1 d;
    public lw1 e;
    public lw1 f;
    public y14 g;
    public b24 h;
    public a24 i;
    public a24 j;
    public x14 k;
    public f l;

    /* loaded from: classes6.dex */
    public interface f {
        void a();

        void b(int i);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    /* loaded from: classes6.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w14 a;

        public a(w14 w14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w14Var;
        }

        @Override // com.baidu.tieba.w14.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                b24 b24Var = new b24();
                b24Var.errMsg = "showKeyboard:ok";
                b24Var.height = i;
                q64.call(this.a.d, true, b24Var);
            }
        }

        @Override // com.baidu.tieba.w14.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.a.k != null) {
                this.a.k.c(str);
            }
        }

        @Override // com.baidu.tieba.w14.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && this.a.k != null) {
                this.a.k.b(str);
            }
        }

        @Override // com.baidu.tieba.w14.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && this.a.k != null) {
                this.a.k.d(str);
            }
        }

        @Override // com.baidu.tieba.w14.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w14 a;

        public b(w14 w14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w14Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!j74.p().n(this.a.b)) {
                    this.a.h.errMsg = "showKeyboard:fail";
                    q64.call(this.a.d, false, this.a.h);
                    return;
                }
                this.a.b.j(this.a.g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w14 a;

        public c(w14 w14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w14Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (j74.p().s(this.a.b)) {
                    this.a.i.errMsg = "hideKeyboard:ok";
                    q64.call(this.a.e, true, this.a.i);
                    return;
                }
                this.a.i.errMsg = "hideKeyboard:fail";
                q64.call(this.a.e, false, this.a.i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w14 a;

        public d(w14 w14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w14Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j74.p().s(this.a.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ w14 b;

        public e(w14 w14Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w14Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w14Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.b.m(this.a)) {
                    this.b.j.errMsg = "updateKeyboard:ok";
                    q64.call(this.b.f, true, this.b.j);
                    return;
                }
                this.b.j.errMsg = "updateKeyboard:fail";
                q64.call(this.b.f, false, this.b.j);
            }
        }
    }

    public w14(ob2 ob2Var, x14 x14Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ob2Var, x14Var};
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
        this.a = ob2Var;
        Context appContext = AppRuntime.getAppContext();
        this.c = appContext;
        i74 i74Var = new i74(appContext);
        this.b = i74Var;
        i74Var.i(this.l);
        this.k = x14Var;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            yh3.e0(new d(this));
        }
    }

    public void k(JsObject jsObject) {
        i74 i74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.i = new a24();
            lw1 F = lw1.F(jsObject);
            this.e = F;
            if (F == null) {
                this.e = new lw1();
            }
            if (this.a != null && (i74Var = this.b) != null && i74Var.g()) {
                yh3.e0(new c(this));
                return;
            }
            a24 a24Var = this.i;
            a24Var.errMsg = "hideKeyboard:fail";
            q64.call(this.e, false, a24Var);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.j = new a24();
            lw1 F = lw1.F(jsObject);
            this.f = F;
            if (F == null) {
                this.f = new lw1();
            }
            if (this.a != null && this.b != null) {
                yh3.e0(new e(this, this.f.B("value")));
                return;
            }
            a24 a24Var = this.j;
            a24Var.errMsg = "updateKeyboard:fail";
            q64.call(this.f, false, a24Var);
        }
    }

    public void l(JsObject jsObject) {
        i74 i74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.h = new b24();
            lw1 F = lw1.F(jsObject);
            this.d = F;
            if (F == null) {
                this.d = new lw1();
            }
            if (this.a != null && (i74Var = this.b) != null && !i74Var.g()) {
                y14 y14Var = new y14();
                this.g = y14Var;
                try {
                    if (y14Var.a(this.d)) {
                        yh3.f0(new b(this), 500L);
                    } else {
                        this.h.errMsg = "showKeyboard:fail";
                        q64.call(this.d, false, this.h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    b24 b24Var = this.h;
                    b24Var.errMsg = "showKeyboard:fail";
                    q64.call(this.d, false, b24Var);
                    return;
                }
            }
            b24 b24Var2 = this.h;
            b24Var2.errMsg = "showKeyboard:fail";
            q64.call(this.d, false, b24Var2);
        }
    }
}
