package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
        }
    }

    public static void i(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, exc) == null) {
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            return j(str).replaceAll("\"\\{", "\\{").replaceAll("\\}\"", "\\}");
        }
        return (String) invokeL.objValue;
    }

    public static Map<String, String> b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                    hashMap.put(next, optString);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @NonNull
    public static JSONObject c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (Exception e) {
                h(e.getMessage());
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                StringWriter stringWriter = new StringWriter(str.length());
                k(stringWriter, str);
                return stringWriter.toString();
            } catch (IOException e) {
                h(e.getMessage());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void d(JSONObject jSONObject, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, jSONObject, str, i) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, i);
                    return;
                } catch (Exception e) {
                    i(e);
                    return;
                }
            }
            h("json或key值不合法！");
        }
    }

    public static <T> void f(JSONObject jSONObject, String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, jSONObject, str, t) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, t);
                    return;
                } catch (Exception e) {
                    i(e);
                    return;
                }
            }
            h("json或key值不合法！");
        }
    }

    public static void g(JSONObject jSONObject, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, null, jSONObject, str, z) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, z);
                    return;
                } catch (Exception e) {
                    i(e);
                    return;
                }
            }
            h("json或key值不合法！");
        }
    }

    public static void e(JSONObject jSONObject, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jSONObject, str, Long.valueOf(j)}) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, j);
                    return;
                } catch (Exception e) {
                    i(e);
                    return;
                }
            }
            h("json或key值不合法！");
        }
    }

    public static void k(Writer writer, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, writer, str) == null) {
            if (writer != null) {
                if (str != null) {
                    int length = str.length();
                    StringBuilder sb = new StringBuilder(4);
                    boolean z = false;
                    boolean z2 = false;
                    for (int i = 0; i < length; i++) {
                        char charAt = str.charAt(i);
                        if (z2) {
                            sb.append(charAt);
                            if (sb.length() == 4) {
                                try {
                                    writer.write((char) Integer.parseInt(sb.toString(), 16));
                                    sb.setLength(0);
                                    z = false;
                                    z2 = false;
                                } catch (NumberFormatException e) {
                                    h(e.getMessage());
                                }
                            }
                        } else if (z) {
                            if (charAt != '\"') {
                                if (charAt != '\'') {
                                    if (charAt != '\\') {
                                        if (charAt != 'b') {
                                            if (charAt != 'f') {
                                                if (charAt != 'n') {
                                                    if (charAt != 'r') {
                                                        if (charAt != 't') {
                                                            if (charAt != 'u') {
                                                                writer.write(charAt);
                                                            } else {
                                                                z = false;
                                                                z2 = true;
                                                            }
                                                        } else {
                                                            writer.write(9);
                                                        }
                                                    } else {
                                                        writer.write(13);
                                                    }
                                                } else {
                                                    writer.write(10);
                                                }
                                            } else {
                                                writer.write(12);
                                            }
                                        } else {
                                            writer.write(8);
                                        }
                                    } else {
                                        writer.write(92);
                                    }
                                } else {
                                    writer.write(39);
                                }
                            } else {
                                writer.write(34);
                            }
                            z = false;
                        } else if (charAt == '\\') {
                            z = true;
                        } else {
                            writer.write(charAt);
                        }
                    }
                    if (z) {
                        writer.write(92);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("The Writer must not be null");
        }
    }
}
