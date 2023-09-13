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
/* loaded from: classes9.dex */
public class z84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ri2 a;
    public le4 b;
    public Context c;
    public o32 d;
    public o32 e;
    public o32 f;
    public b94 g;
    public e94 h;
    public d94 i;
    public d94 j;
    public a94 k;
    public f l;

    /* loaded from: classes9.dex */
    public interface f {
        void a();

        void b(int i);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    /* loaded from: classes9.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z84 a;

        public a(z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z84Var;
        }

        @Override // com.baidu.tieba.z84.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                e94 e94Var = new e94();
                e94Var.errMsg = "showKeyboard:ok";
                e94Var.height = i;
                td4.call(this.a.d, true, e94Var);
            }
        }

        @Override // com.baidu.tieba.z84.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.a.k != null) {
                this.a.k.c(str);
            }
        }

        @Override // com.baidu.tieba.z84.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && this.a.k != null) {
                this.a.k.b(str);
            }
        }

        @Override // com.baidu.tieba.z84.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && this.a.k != null) {
                this.a.k.d(str);
            }
        }

        @Override // com.baidu.tieba.z84.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z84 a;

        public b(z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z84Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!me4.p().n(this.a.b)) {
                    this.a.h.errMsg = "showKeyboard:fail";
                    td4.call(this.a.d, false, this.a.h);
                    return;
                }
                this.a.b.j(this.a.g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z84 a;

        public c(z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z84Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (me4.p().s(this.a.b)) {
                    this.a.i.errMsg = "hideKeyboard:ok";
                    td4.call(this.a.e, true, this.a.i);
                    return;
                }
                this.a.i.errMsg = "hideKeyboard:fail";
                td4.call(this.a.e, false, this.a.i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z84 a;

        public d(z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z84Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                me4.p().s(this.a.b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ z84 b;

        public e(z84 z84Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z84Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z84Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.b.m(this.a)) {
                    this.b.j.errMsg = "updateKeyboard:ok";
                    td4.call(this.b.f, true, this.b.j);
                    return;
                }
                this.b.j.errMsg = "updateKeyboard:fail";
                td4.call(this.b.f, false, this.b.j);
            }
        }
    }

    public z84(ri2 ri2Var, a94 a94Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ri2Var, a94Var};
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
        this.a = ri2Var;
        Context appContext = AppRuntime.getAppContext();
        this.c = appContext;
        le4 le4Var = new le4(appContext);
        this.b = le4Var;
        le4Var.i(this.l);
        this.k = a94Var;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bp3.e0(new d(this));
        }
    }

    public void k(JsObject jsObject) {
        le4 le4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.i = new d94();
            o32 F = o32.F(jsObject);
            this.e = F;
            if (F == null) {
                this.e = new o32();
            }
            if (this.a != null && (le4Var = this.b) != null && le4Var.g()) {
                bp3.e0(new c(this));
                return;
            }
            d94 d94Var = this.i;
            d94Var.errMsg = "hideKeyboard:fail";
            td4.call(this.e, false, d94Var);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.j = new d94();
            o32 F = o32.F(jsObject);
            this.f = F;
            if (F == null) {
                this.f = new o32();
            }
            if (this.a != null && this.b != null) {
                bp3.e0(new e(this, this.f.B("value")));
                return;
            }
            d94 d94Var = this.j;
            d94Var.errMsg = "updateKeyboard:fail";
            td4.call(this.f, false, d94Var);
        }
    }

    public void l(JsObject jsObject) {
        le4 le4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.h = new e94();
            o32 F = o32.F(jsObject);
            this.d = F;
            if (F == null) {
                this.d = new o32();
            }
            if (this.a != null && (le4Var = this.b) != null && !le4Var.g()) {
                b94 b94Var = new b94();
                this.g = b94Var;
                try {
                    if (b94Var.a(this.d)) {
                        bp3.f0(new b(this), 500L);
                    } else {
                        this.h.errMsg = "showKeyboard:fail";
                        td4.call(this.d, false, this.h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    e94 e94Var = this.h;
                    e94Var.errMsg = "showKeyboard:fail";
                    td4.call(this.d, false, e94Var);
                    return;
                }
            }
            e94 e94Var2 = this.h;
            e94Var2.errMsg = "showKeyboard:fail";
            td4.call(this.d, false, e94Var2);
        }
    }
}
