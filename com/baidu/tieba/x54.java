package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.dr2;
import com.baidu.tieba.k53;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class x54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public k53 a;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ oy1 c;
        public final /* synthetic */ dr2 d;
        public final /* synthetic */ x54 e;

        public a(x54 x54Var, SwanAppActivity swanAppActivity, String str, oy1 oy1Var, dr2 dr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x54Var, swanAppActivity, str, oy1Var, dr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = x54Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = oy1Var;
            this.d = dr2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.f(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy1 a;

        public b(x54 x54Var, oy1 oy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x54Var, oy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                s84.a(this.a, true, new z54(false));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy1 a;
        public final /* synthetic */ dr2 b;
        public final /* synthetic */ x54 c;

        public c(x54 x54Var, oy1 oy1Var, dr2 dr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x54Var, oy1Var, dr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x54Var;
            this.a = oy1Var;
            this.b = dr2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                s84.a(this.a, true, new z54(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948251346, "Lcom/baidu/tieba/x54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948251346, "Lcom/baidu/tieba/x54;");
                return;
            }
        }
        b = rm1.a;
    }

    public x54() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void c(oy1 oy1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, oy1Var, str) == null) {
            p04 p04Var = new p04();
            p04Var.errMsg = str;
            s84.a(oy1Var, false, p04Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            oy1 G = oy1.G(jsObject);
            if (G == null) {
                G = new oy1();
            }
            oy1 oy1Var = G;
            g63 q = f63.K().q();
            if (!q.I()) {
                c(oy1Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity w = q.w();
            dr2.a X = q.X();
            if (w == null) {
                c(oy1Var, "reload failed, api internal error.");
                return;
            }
            String C = oy1Var.C("content");
            if (TextUtils.isEmpty(C)) {
                C = w.getString(R.string.obfuscated_res_0x7f0f01b1);
            }
            ak3.e0(new a(this, w, C, oy1Var, X));
        }
    }

    public final void e(@NonNull dr2 dr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dr2Var) == null) {
            String I = dr2Var.I();
            String i1 = er2.i1(dr2Var.I(), dr2Var.U(), dr2Var.H());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, I);
            bundle.putString("scheme", i1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + dr2Var.I());
            }
            b33.Q().W(bundle, y54.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull oy1 oy1Var, @NonNull dr2 dr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, oy1Var, dr2Var) == null) {
            k53 k53Var = this.a;
            if (k53Var != null && k53Var.isShowing()) {
                c(oy1Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            k53.a aVar = new k53.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f01b2);
            aVar.x(str);
            aVar.a();
            aVar.n(new ol3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f0141, new b(this, oy1Var));
            aVar.O(R.string.obfuscated_res_0x7f0f01d1, new c(this, oy1Var, dr2Var));
            this.a = aVar.X();
        }
    }
}
