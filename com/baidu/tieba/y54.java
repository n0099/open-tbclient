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
import com.baidu.tieba.er2;
import com.baidu.tieba.l53;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class y54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public l53 a;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ py1 c;
        public final /* synthetic */ er2 d;
        public final /* synthetic */ y54 e;

        public a(y54 y54Var, SwanAppActivity swanAppActivity, String str, py1 py1Var, er2 er2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y54Var, swanAppActivity, str, py1Var, er2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = y54Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = py1Var;
            this.d = er2Var;
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
        public final /* synthetic */ py1 a;

        public b(y54 y54Var, py1 py1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y54Var, py1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = py1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                t84.a(this.a, true, new a64(false));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ py1 a;
        public final /* synthetic */ er2 b;
        public final /* synthetic */ y54 c;

        public c(y54 y54Var, py1 py1Var, er2 er2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y54Var, py1Var, er2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y54Var;
            this.a = py1Var;
            this.b = er2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                t84.a(this.a, true, new a64(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948281137, "Lcom/baidu/tieba/y54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948281137, "Lcom/baidu/tieba/y54;");
                return;
            }
        }
        b = sm1.a;
    }

    public y54() {
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

    public final void c(py1 py1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, py1Var, str) == null) {
            q04 q04Var = new q04();
            q04Var.errMsg = str;
            t84.a(py1Var, false, q04Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            py1 G = py1.G(jsObject);
            if (G == null) {
                G = new py1();
            }
            py1 py1Var = G;
            h63 q = g63.K().q();
            if (!q.I()) {
                c(py1Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity w = q.w();
            er2.a X = q.X();
            if (w == null) {
                c(py1Var, "reload failed, api internal error.");
                return;
            }
            String C = py1Var.C("content");
            if (TextUtils.isEmpty(C)) {
                C = w.getString(R.string.obfuscated_res_0x7f0f01b9);
            }
            bk3.e0(new a(this, w, C, py1Var, X));
        }
    }

    public final void e(@NonNull er2 er2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, er2Var) == null) {
            String I = er2Var.I();
            String i1 = fr2.i1(er2Var.I(), er2Var.U(), er2Var.H());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, I);
            bundle.putString("scheme", i1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + er2Var.I());
            }
            c33.Q().W(bundle, z54.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull py1 py1Var, @NonNull er2 er2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, py1Var, er2Var) == null) {
            l53 l53Var = this.a;
            if (l53Var != null && l53Var.isShowing()) {
                c(py1Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            l53.a aVar = new l53.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f01ba);
            aVar.x(str);
            aVar.a();
            aVar.n(new pl3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f0149, new b(this, py1Var));
            aVar.O(R.string.obfuscated_res_0x7f0f01d9, new c(this, py1Var, er2Var));
            this.a = aVar.X();
        }
    }
}
