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
import com.baidu.tieba.sw2;
import com.baidu.tieba.za3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mb4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public za3 a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ c42 c;
        public final /* synthetic */ sw2 d;
        public final /* synthetic */ mb4 e;

        public a(mb4 mb4Var, SwanAppActivity swanAppActivity, String str, c42 c42Var, sw2 sw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb4Var, swanAppActivity, str, c42Var, sw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mb4Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = c42Var;
            this.d = sw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.f(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c42 a;

        public b(mb4 mb4Var, c42 c42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb4Var, c42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c42Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                he4.call(this.a, true, new ob4(false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c42 a;
        public final /* synthetic */ sw2 b;
        public final /* synthetic */ mb4 c;

        public c(mb4 mb4Var, c42 c42Var, sw2 sw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb4Var, c42Var, sw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mb4Var;
            this.a = c42Var;
            this.b = sw2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                he4.call(this.a, true, new ob4(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947966890, "Lcom/baidu/tieba/mb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947966890, "Lcom/baidu/tieba/mb4;");
                return;
            }
        }
        b = fs1.a;
    }

    public mb4() {
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

    public final void c(c42 c42Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, c42Var, str) == null) {
            e64 e64Var = new e64();
            e64Var.errMsg = str;
            he4.call(c42Var, false, e64Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            c42 F = c42.F(jsObject);
            if (F == null) {
                F = new c42();
            }
            c42 c42Var = F;
            vb3 q = ub3.K().q();
            if (!q.I()) {
                c(c42Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity w = q.w();
            sw2.a W = q.W();
            if (w == null) {
                c(c42Var, "reload failed, api internal error.");
                return;
            }
            String B = c42Var.B("content");
            if (TextUtils.isEmpty(B)) {
                B = w.getString(R.string.obfuscated_res_0x7f0f01ae);
            }
            pp3.e0(new a(this, w, B, c42Var, W));
        }
    }

    public final void e(@NonNull sw2 sw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sw2Var) == null) {
            String H = sw2Var.H();
            String h1 = tw2.h1(sw2Var.H(), sw2Var.T(), sw2Var.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", h1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + sw2Var.H());
            }
            q83.Q().W(bundle, nb4.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull c42 c42Var, @NonNull sw2 sw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, c42Var, sw2Var) == null) {
            za3 za3Var = this.a;
            if (za3Var != null && za3Var.isShowing()) {
                c(c42Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            za3.a aVar = new za3.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f01af);
            aVar.x(str);
            aVar.a();
            aVar.n(new dr3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f013e, new b(this, c42Var));
            aVar.O(R.string.obfuscated_res_0x7f0f01ce, new c(this, c42Var, sw2Var));
            this.a = aVar.X();
        }
    }
}
