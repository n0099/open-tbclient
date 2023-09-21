package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile wd3 g;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public FloatButton b;
    public String c;
    public JSONObject d;
    public String e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948266691, "Lcom/baidu/tieba/wd3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948266691, "Lcom/baidu/tieba/wd3;");
                return;
            }
        }
        f = qr1.a;
    }

    public wd3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = "";
    }

    public static wd3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (g == null) {
                synchronized (wd3.class) {
                    if (g == null) {
                        g = new wd3();
                    }
                }
            }
            return g;
        }
        return (wd3) invokeV.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65539, null) != null) || g == null) {
            return;
        }
        g = null;
    }

    public FloatButton c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (FloatButton) invokeV.objValue;
    }

    public final FloatButton a(Context context, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, viewGroup)) == null) {
            if (context != null && viewGroup != null) {
                FloatButton e = e(context);
                viewGroup.addView(e);
                return e;
            }
            return null;
        }
        return (FloatButton) invokeLL.objValue;
    }

    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) && intent != null && this.b != null) {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return;
            }
            String substring = dataString.substring(8);
            if (!TextUtils.isEmpty(substring) && substring.equals(this.e)) {
                if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
                    this.c = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0210);
                } else if (TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction())) {
                    this.c = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14ce);
                }
                this.b.setFloatButtonText(this.c);
            }
        }
    }

    public final FloatButton e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (context == null) {
                return null;
            }
            return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.obfuscated_res_0x7f0d0926, (ViewGroup) null);
        }
        return (FloatButton) invokeL.objValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.e = str;
        }
    }

    public void j(FloatButton floatButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, floatButton) == null) {
            this.b = floatButton;
        }
    }

    public FloatButton f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Activity activity = this.a;
            if (!(activity instanceof SwanAppActivity)) {
                return null;
            }
            if (this.b == null) {
                this.b = a(activity, (ViewGroup) activity.findViewById(16908290));
            }
            this.b.setFloatButtonText(this.c);
            this.b.setFloatButtonDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081439));
            this.b.setFloatButtonDefaultPosition();
            this.b.setFloatButtonStyle(this.d);
            this.b.setVisibility(0);
            return this.b;
        }
        return (FloatButton) invokeV.objValue;
    }

    public void g(Activity activity, JSONObject jSONObject) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, activity, jSONObject) == null) && jSONObject != null) {
            if (f) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.a = activity;
            String optString = jSONObject.optString("name");
            this.e = optString;
            if (ap3.F(activity, optString)) {
                string = activity.getString(R.string.obfuscated_res_0x7f0f0210);
            } else {
                string = activity.getString(R.string.obfuscated_res_0x7f0f14ce);
            }
            this.c = string;
            this.d = jSONObject.optJSONObject("style");
        }
    }
}
