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
/* loaded from: classes7.dex */
public class nn2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static nn2 d;
    public static nn2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public long b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948008151, "Lcom/baidu/tieba/nn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948008151, "Lcom/baidu/tieba/nn2;");
                return;
            }
        }
        c = ms1.a;
    }

    public nn2() {
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
    public static nn2 a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (d == null) {
                d = d(e(str));
            }
            return d;
        }
        return (nn2) invokeL.objValue;
    }

    @NonNull
    public static nn2 b(@NonNull ln2 ln2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ln2Var)) == null) {
            if (ln2Var.c() == 1) {
                return c(ln2Var.d());
            }
            return a(ln2Var.d());
        }
        return (nn2) invokeL.objValue;
    }

    @NonNull
    public static nn2 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (e == null) {
                e = d(e(str));
            }
            return e;
        }
        return (nn2) invokeL.objValue;
    }

    @NonNull
    public static nn2 d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jSONObject)) == null) {
            nn2 nn2Var = new nn2();
            if (jSONObject != null) {
                nn2Var.a = jSONObject.optString("extension-core-version-name");
                nn2Var.b = jSONObject.optLong("extension-core-version-code");
            }
            return nn2Var;
        }
        return (nn2) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static JSONObject e(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (c) {
                Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
            }
            String D = gs4.D(AppRuntime.getAppContext(), str);
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
