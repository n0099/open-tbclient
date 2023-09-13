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
import com.baidu.tieba.ew2;
import com.baidu.tieba.la3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ya4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public la3 a;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ o32 c;
        public final /* synthetic */ ew2 d;
        public final /* synthetic */ ya4 e;

        public a(ya4 ya4Var, SwanAppActivity swanAppActivity, String str, o32 o32Var, ew2 ew2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya4Var, swanAppActivity, str, o32Var, ew2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ya4Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = o32Var;
            this.d = ew2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.f(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o32 a;

        public b(ya4 ya4Var, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya4Var, o32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o32Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                td4.call(this.a, true, new ab4(false));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o32 a;
        public final /* synthetic */ ew2 b;
        public final /* synthetic */ ya4 c;

        public c(ya4 ya4Var, o32 o32Var, ew2 ew2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya4Var, o32Var, ew2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ya4Var;
            this.a = o32Var;
            this.b = ew2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                td4.call(this.a, true, new ab4(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948323421, "Lcom/baidu/tieba/ya4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948323421, "Lcom/baidu/tieba/ya4;");
                return;
            }
        }
        b = rr1.a;
    }

    public ya4() {
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

    public final void c(o32 o32Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, o32Var, str) == null) {
            q54 q54Var = new q54();
            q54Var.errMsg = str;
            td4.call(o32Var, false, q54Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            o32 F = o32.F(jsObject);
            if (F == null) {
                F = new o32();
            }
            o32 o32Var = F;
            hb3 q = gb3.K().q();
            if (!q.I()) {
                c(o32Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity w = q.w();
            ew2.a W = q.W();
            if (w == null) {
                c(o32Var, "reload failed, api internal error.");
                return;
            }
            String B = o32Var.B("content");
            if (TextUtils.isEmpty(B)) {
                B = w.getString(R.string.obfuscated_res_0x7f0f01af);
            }
            bp3.e0(new a(this, w, B, o32Var, W));
        }
    }

    public final void e(@NonNull ew2 ew2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ew2Var) == null) {
            String H = ew2Var.H();
            String h1 = fw2.h1(ew2Var.H(), ew2Var.T(), ew2Var.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", h1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + ew2Var.H());
            }
            c83.Q().W(bundle, za4.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull o32 o32Var, @NonNull ew2 ew2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, o32Var, ew2Var) == null) {
            la3 la3Var = this.a;
            if (la3Var != null && la3Var.isShowing()) {
                c(o32Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            la3.a aVar = new la3.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f01b0);
            aVar.x(str);
            aVar.a();
            aVar.n(new pq3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f013f, new b(this, o32Var));
            aVar.O(R.string.obfuscated_res_0x7f0f01cf, new c(this, o32Var, ew2Var));
            this.a = aVar.X();
        }
    }
}
