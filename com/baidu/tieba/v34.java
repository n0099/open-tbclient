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
import com.baidu.tieba.bp2;
import com.baidu.tieba.i33;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class v34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public i33 a;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lw1 c;
        public final /* synthetic */ bp2 d;
        public final /* synthetic */ v34 e;

        public a(v34 v34Var, SwanAppActivity swanAppActivity, String str, lw1 lw1Var, bp2 bp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v34Var, swanAppActivity, str, lw1Var, bp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = v34Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = lw1Var;
            this.d = bp2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.f(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw1 a;

        public b(v34 v34Var, lw1 lw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v34Var, lw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lw1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                q64.call(this.a, true, new x34(false));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw1 a;
        public final /* synthetic */ bp2 b;
        public final /* synthetic */ v34 c;

        public c(v34 v34Var, lw1 lw1Var, bp2 bp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v34Var, lw1Var, bp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v34Var;
            this.a = lw1Var;
            this.b = bp2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                q64.call(this.a, true, new x34(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948189842, "Lcom/baidu/tieba/v34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948189842, "Lcom/baidu/tieba/v34;");
                return;
            }
        }
        b = ok1.a;
    }

    public v34() {
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

    public final void c(lw1 lw1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, lw1Var, str) == null) {
            ny3 ny3Var = new ny3();
            ny3Var.errMsg = str;
            q64.call(lw1Var, false, ny3Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            lw1 F = lw1.F(jsObject);
            if (F == null) {
                F = new lw1();
            }
            lw1 lw1Var = F;
            e43 q = d43.K().q();
            if (!q.I()) {
                c(lw1Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity w = q.w();
            bp2.a W = q.W();
            if (w == null) {
                c(lw1Var, "reload failed, api internal error.");
                return;
            }
            String B = lw1Var.B("content");
            if (TextUtils.isEmpty(B)) {
                B = w.getString(R.string.obfuscated_res_0x7f0f0182);
            }
            yh3.e0(new a(this, w, B, lw1Var, W));
        }
    }

    public final void e(@NonNull bp2 bp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bp2Var) == null) {
            String H = bp2Var.H();
            String h1 = cp2.h1(bp2Var.H(), bp2Var.T(), bp2Var.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", h1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + bp2Var.H());
            }
            z03.Q().W(bundle, w34.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull lw1 lw1Var, @NonNull bp2 bp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, lw1Var, bp2Var) == null) {
            i33 i33Var = this.a;
            if (i33Var != null && i33Var.isShowing()) {
                c(lw1Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            i33.a aVar = new i33.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f0183);
            aVar.x(str);
            aVar.a();
            aVar.n(new mj3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f0112, new b(this, lw1Var));
            aVar.O(R.string.obfuscated_res_0x7f0f01a2, new c(this, lw1Var, bp2Var));
            this.a = aVar.X();
        }
    }
}
