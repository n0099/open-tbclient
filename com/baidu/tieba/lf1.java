package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class lf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (i != 0) {
                if (i != 101) {
                    if (i != 201) {
                        if (i != 202) {
                            if (i != 301) {
                                if (i != 302) {
                                    switch (i) {
                                        case 401:
                                            return ef1.a().getString(R.string.prologue_united_scheme_err_message_action_sec_check_fail);
                                        case 402:
                                            return ef1.a().getString(R.string.prologue_united_scheme_err_message_action_acl_check_fail);
                                        case 403:
                                            return ef1.a().getString(R.string.prologue_united_scheme_err_message_action_allow_close);
                                        default:
                                            return ef1.a().getString(R.string.prologue_united_scheme_err_message_parse_fail);
                                    }
                                }
                                return ef1.a().getString(R.string.prologue_united_scheme_err_message_action_notfound);
                            }
                            return ef1.a().getString(R.string.prologue_united_scheme_err_message_module_notfound);
                        }
                        return ef1.a().getString(R.string.prologue_united_scheme_err_message_params_parse_fail);
                    }
                    return ef1.a().getString(R.string.prologue_united_scheme_err_message_parse_fail);
                }
                return ef1.a().getString(R.string.prologue_united_scheme_err_message_not_support);
            }
            return ef1.a().getString(R.string.prologue_united_scheme_err_message_ok);
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> b(String str) {
        InterceptResult invokeL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (TextUtils.isEmpty(str)) {
                return hashMap;
            }
            int indexOf = str.indexOf("?");
            int indexOf2 = str.indexOf("#");
            if (indexOf < 0) {
                return hashMap;
            }
            if (indexOf2 < 0) {
                substring = str.substring(indexOf + 1);
            } else {
                substring = str.substring(indexOf + 1, indexOf2);
            }
            String[] split = substring.split("&");
            if (split == null) {
                return hashMap;
            }
            for (String str2 : split) {
                int indexOf3 = str2.indexOf("=");
                if (indexOf3 > 0) {
                    try {
                        hashMap.put(URLDecoder.decode(str2.substring(0, indexOf3)), URLDecoder.decode(str2.substring(indexOf3 + 1)));
                    } catch (IllegalArgumentException unused) {
                    }
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String[] c(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(uri.getPathSegments());
            if (!d(uri)) {
                arrayList.add(0, uri.getHost());
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeL.objValue;
    }

    public static boolean d(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uri)) == null) {
            if (uri == null) {
                return false;
            }
            String host = uri.getHost();
            if (TextUtils.isEmpty(host) || !host.startsWith("v") || !e(host)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (Pattern.compile("[0-9]").matcher(str).find()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, uri)) == null) {
            if (uri == null) {
                return false;
            }
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (!TextUtils.equals(hf1.a, scheme) || TextUtils.isEmpty(host)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return f(Uri.parse(str));
        }
        return invokeL.booleanValue;
    }

    public static JSONObject h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            return j(null, i);
        }
        return (JSONObject) invokeI.objValue;
    }

    public static JSONObject i(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", String.valueOf(i));
                jSONObject.put("message", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeIL.objValue;
    }

    public static JSONObject j(JSONObject jSONObject, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, jSONObject, i)) == null) {
            return k(jSONObject, i, a(i));
        }
        return (JSONObject) invokeLI.objValue;
    }

    public static JSONObject k(JSONObject jSONObject, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65546, null, jSONObject, i, str)) == null) {
            JSONObject i2 = i(i, str);
            if (jSONObject != null) {
                try {
                    i2.put("data", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return i2;
        }
        return (JSONObject) invokeLIL.objValue;
    }
}
