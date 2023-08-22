package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class v34 extends j34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

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
        c = nr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v34() {
        super("startPermissionsPage");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.j34
    public d32 a(JSONObject jSONObject, ho2 ho2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, ho2Var)) == null) {
            db3 b0 = db3.b0();
            if (b0 != null && b0.w() != null) {
                String str = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str)) {
                    str = str.toLowerCase(Locale.US);
                }
                if (TextUtils.equals(str, "oppo")) {
                    try {
                        Intent intent = new Intent(b0.w().getPackageName());
                        intent.setComponent(new ComponentName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity"));
                        b0.w().startActivity(intent);
                    } catch (Exception e) {
                        if (c) {
                            e.printStackTrace();
                        }
                        ho3.f(b0.w());
                    }
                } else {
                    ho3.g(b0.w());
                }
                ho2Var.onSuccess(null);
            } else if (c) {
                Log.d("StartPermissionsPage", "swan or activity is null");
            }
            return null;
        }
        return (d32) invokeLL.objValue;
    }
}
