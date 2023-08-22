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
import com.baidu.tieba.aw2;
import com.baidu.tieba.ha3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ua4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public ha3 a;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ k32 c;
        public final /* synthetic */ aw2 d;
        public final /* synthetic */ ua4 e;

        public a(ua4 ua4Var, SwanAppActivity swanAppActivity, String str, k32 k32Var, aw2 aw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua4Var, swanAppActivity, str, k32Var, aw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ua4Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = k32Var;
            this.d = aw2Var;
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
        public final /* synthetic */ k32 a;

        public b(ua4 ua4Var, k32 k32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua4Var, k32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k32Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                pd4.call(this.a, true, new wa4(false));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k32 a;
        public final /* synthetic */ aw2 b;
        public final /* synthetic */ ua4 c;

        public c(ua4 ua4Var, k32 k32Var, aw2 aw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua4Var, k32Var, aw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ua4Var;
            this.a = k32Var;
            this.b = aw2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                pd4.call(this.a, true, new wa4(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948204257, "Lcom/baidu/tieba/ua4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948204257, "Lcom/baidu/tieba/ua4;");
                return;
            }
        }
        b = nr1.a;
    }

    public ua4() {
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

    public final void c(k32 k32Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, k32Var, str) == null) {
            m54 m54Var = new m54();
            m54Var.errMsg = str;
            pd4.call(k32Var, false, m54Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            k32 F = k32.F(jsObject);
            if (F == null) {
                F = new k32();
            }
            k32 k32Var = F;
            db3 q = cb3.K().q();
            if (!q.I()) {
                c(k32Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity w = q.w();
            aw2.a W = q.W();
            if (w == null) {
                c(k32Var, "reload failed, api internal error.");
                return;
            }
            String B = k32Var.B("content");
            if (TextUtils.isEmpty(B)) {
                B = w.getString(R.string.obfuscated_res_0x7f0f01af);
            }
            xo3.e0(new a(this, w, B, k32Var, W));
        }
    }

    public final void e(@NonNull aw2 aw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aw2Var) == null) {
            String H = aw2Var.H();
            String h1 = bw2.h1(aw2Var.H(), aw2Var.T(), aw2Var.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", h1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + aw2Var.H());
            }
            y73.Q().W(bundle, va4.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull k32 k32Var, @NonNull aw2 aw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, k32Var, aw2Var) == null) {
            ha3 ha3Var = this.a;
            if (ha3Var != null && ha3Var.isShowing()) {
                c(k32Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            ha3.a aVar = new ha3.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f01b0);
            aVar.x(str);
            aVar.a();
            aVar.n(new lq3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f013f, new b(this, k32Var));
            aVar.O(R.string.obfuscated_res_0x7f0f01cf, new c(this, k32Var, aw2Var));
            this.a = aVar.X();
        }
    }
}
