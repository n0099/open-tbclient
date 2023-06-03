package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jn2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static jn2 d;
    public static jn2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public long b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947888987, "Lcom/baidu/tieba/jn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947888987, "Lcom/baidu/tieba/jn2;");
                return;
            }
        }
        c = is1.a;
    }

    public jn2() {
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

    @NonNull
    public static jn2 a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (d == null) {
                d = d(e(str));
            }
            return d;
        }
        return (jn2) invokeL.objValue;
    }

    @NonNull
    public static jn2 b(@NonNull hn2 hn2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hn2Var)) == null) {
            if (hn2Var.c() == 1) {
                return c(hn2Var.d());
            }
            return a(hn2Var.d());
        }
        return (jn2) invokeL.objValue;
    }

    @NonNull
    public static jn2 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (e == null) {
                e = d(e(str));
            }
            return e;
        }
        return (jn2) invokeL.objValue;
    }

    @NonNull
    public static jn2 d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jSONObject)) == null) {
            jn2 jn2Var = new jn2();
            if (jSONObject != null) {
                jn2Var.a = jSONObject.optString("extension-core-version-name");
                jn2Var.b = jSONObject.optLong("extension-core-version-code");
            }
            return jn2Var;
        }
        return (jn2) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static JSONObject e(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (c) {
                Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
            }
            String D = cs4.D(AppRuntime.getAppContext(), str);
            if (TextUtils.isEmpty(D)) {
                if (c) {
                    Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
                }
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(D);
                if (c) {
                    Log.d("ExtCore-PresetConfig", "readPresetConfig end. config: " + jSONObject.toString());
                }
                return jSONObject;
            } catch (JSONException e2) {
                if (!c) {
                    return null;
                }
                throw new RuntimeException(e2);
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
