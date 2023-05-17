package com.baidu.tieba;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kl3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947916887, "Lcom/baidu/tieba/kl3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947916887, "Lcom/baidu/tieba/kl3;");
                return;
            }
        }
        a = qp1.a;
    }

    public static JSONObject a(String str, String str2, String str3) throws JSONException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", str);
            jSONObject.put("swan", str2);
            jSONObject.put("type", "NA");
            jSONObject.put("error", str3);
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static JSONObject b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", a(str, str2, str3));
                jSONObject.put("os", "android");
                jSONObject.put("type", CommonTbJsBridge.GET_APIS);
                jSONObject.put("from", "swan");
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(@Nullable String str) {
        String str2;
        SwanCoreVersion e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            try {
                e = li3.e(0);
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            if (e != null) {
                str2 = e.swanCoreVersionName;
                if (str == null) {
                    str = "";
                }
                nf3.k("1087", b("2", str2, str));
            }
            str2 = "";
            if (str == null) {
            }
            nf3.k("1087", b("2", str2, str));
        }
    }

    public static void d() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            try {
                str = ag2.U().d0().swanCoreVersionName;
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
                str = "";
            }
            nf3.k("1087", b("1", str, ""));
        }
    }
}
