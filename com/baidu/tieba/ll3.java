package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ll3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947946678, "Lcom/baidu/tieba/ll3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947946678, "Lcom/baidu/tieba/ll3;");
                return;
            }
        }
        a = do1.a;
    }

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        StringBuilder sb;
        StringBuilder sb2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String str4 = str2 + "=";
            int indexOf = str.indexOf("?");
            String str5 = null;
            if (indexOf < 0) {
                int indexOf2 = str.indexOf("#");
                if (indexOf2 < 0) {
                    sb2 = new StringBuilder(str);
                } else {
                    str5 = str.substring(indexOf2);
                    sb2 = new StringBuilder(str.substring(0, indexOf2));
                }
                sb2.append("?");
                sb2.append(str4);
                sb2.append(str3);
                if (str5 != null) {
                    sb2.append(str5);
                }
                return sb2.toString();
            }
            if (str.indexOf("&" + str4, indexOf) < 0) {
                if (str.indexOf("?" + str4, indexOf) < 0) {
                    int indexOf3 = str.indexOf("#");
                    if (indexOf3 < 0) {
                        sb = new StringBuilder(str);
                    } else {
                        str5 = str.substring(indexOf3);
                        str = str.substring(0, indexOf3);
                        sb = new StringBuilder(str);
                    }
                    if (!str.endsWith("&") && !str.endsWith("?")) {
                        sb.append("&");
                    }
                    sb.append(str4);
                    sb.append(str3);
                    if (str5 != null) {
                        sb.append(str5);
                    }
                    return sb.toString();
                }
                return str;
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public static String b(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, map)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String s = s(map);
            if (TextUtils.isEmpty(s)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            int indexOf = str.indexOf("?");
            int indexOf2 = str.indexOf("#");
            if (indexOf2 > 0 && indexOf > indexOf2) {
                indexOf = -1;
            }
            if (indexOf2 < 0) {
                sb.append(str);
                str2 = "";
            } else {
                String substring = str.substring(indexOf2);
                sb.append((CharSequence) str, 0, indexOf2);
                str2 = substring;
            }
            if (indexOf < 0) {
                sb.append("?");
                sb.append(s);
                sb.append(str2);
                return sb.toString();
            }
            if (sb.charAt(sb.length() - 1) != '&' && sb.charAt(sb.length() - 1) != '?') {
                sb.append("&");
            }
            sb.append(s);
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String i(String str, Set<String> set) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, set)) == null) {
            if (TextUtils.isEmpty(str) || set == null || (split = str.split("&")) == null || split.length == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2.length > 0 && !set.contains(split2[0])) {
                    sb.append(str2);
                    sb.append("&");
                }
            }
            int length = sb.length();
            if (length > 0) {
                int i = length - 1;
                if (sb.charAt(i) == '&') {
                    sb.deleteCharAt(i);
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String m(Uri uri, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, uri, set)) == null) {
            if (uri == null) {
                return "";
            }
            if (set != null && set.size() != 0) {
                String uri2 = uri.toString();
                String query = uri.getQuery();
                if (TextUtils.isEmpty(query)) {
                    return uri2;
                }
                String i = i(query, set);
                Uri.Builder builder = new Uri.Builder();
                builder.scheme(uri.getScheme());
                builder.authority(uri.getAuthority());
                builder.path(uri.getPath());
                if (!TextUtils.isEmpty(i)) {
                    builder.query(i);
                }
                return builder.build().toString();
            }
            return uri.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static List<String> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            try {
                for (String str2 : str.split("&")) {
                    arrayList.add(str2);
                }
            } catch (Exception unused) {
                if (a) {
                    Log.d("addQueryList", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith(File.separator)) {
                    str = str.substring(1);
                }
                if (str.endsWith(File.separator)) {
                    return str.substring(0, str.length() - 1);
                }
                return str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String host = Uri.parse(str).getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            if (!host.endsWith(".baidu.com") && !host.equals(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(String str, StringBuffer stringBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, stringBuffer)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str)) {
                try {
                    URL url = new URL(str);
                    String protocol = url.getProtocol();
                    String host = url.getHost();
                    if (!TextUtils.isEmpty(protocol) && !TextUtils.isEmpty(host)) {
                        z = ("http".equals(protocol) || "https".equals(protocol)) ? true : true;
                        stringBuffer.append(protocol);
                        stringBuffer.append("://");
                        stringBuffer.append(host);
                    }
                    stringBuffer.append(str);
                } catch (MalformedURLException unused) {
                    stringBuffer.append(str);
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static String l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(ParamableElem.DIVIDE_PARAM);
                int length = split.length;
                for (int i = 0; i != length; i++) {
                    String trim = split[i].trim();
                    String[] split2 = trim.split("=");
                    if (split2.length >= 2 && TextUtils.equals(str2, split2[0])) {
                        if (split2.length == 2) {
                            return split2[1];
                        }
                        return trim.substring(split2[0].length() + 1);
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String f(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int indexOf = str.indexOf("?");
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return h(f(str));
        }
        return (String) invokeL.objValue;
    }

    public static String j(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, uri)) == null) {
            if (uri == null) {
                return "";
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments != null && !pathSegments.isEmpty()) {
                return pathSegments.get(0);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int indexOf = str.indexOf("?");
            if (indexOf <= 0) {
                return null;
            }
            return str.substring(indexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public static boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            return Pattern.compile("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;{]+[-A-Za-z0-9+&@#/%=~_|}]|(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).*").matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static Uri v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Uri.fromFile(new File(str));
        }
        return (Uri) invokeL.objValue;
    }

    public static String w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Uri.fromFile(new File(str)).toString();
        }
        return (String) invokeL.objValue;
    }

    public static String k(String str, String str2, String str3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{str, str2, str3, Long.valueOf(j)})) == null) {
            return str2 + "=" + str3 + ";domain=" + str + ";path=/;max-age=" + j + ParamableElem.DIVIDE_PARAM;
        }
        return (String) invokeCommon.objValue;
    }

    public static String n(@NonNull String str, @NonNull Uri uri, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65550, null, str, uri, z)) == null) {
            String path = uri.getPath();
            if (TextUtils.isEmpty(path)) {
                return null;
            }
            String substring = path.substring(str.length() + 1);
            if (substring.endsWith(File.separator)) {
                substring = substring.substring(0, substring.length() - 1);
            }
            String replaceAll = substring.replaceAll("/+", "/");
            if (!z && replaceAll.startsWith(File.separator)) {
                return replaceAll.substring(1);
            }
            return replaceAll;
        }
        return (String) invokeLLZ.objValue;
    }

    public static Uri p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("file://") && !str.startsWith("content://")) {
                if (!str.startsWith("/")) {
                    return null;
                }
                return Uri.fromFile(new File(str));
            }
            return Uri.parse(str);
        }
        return (Uri) invokeL.objValue;
    }

    public static Map<String, String> t(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (String str3 : str.split("&")) {
                String[] split = str3.split("=");
                String e = e(split[0]);
                if (split.length > 1) {
                    str2 = e(split[1]);
                } else {
                    str2 = "";
                }
                hashMap.put(e, str2);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static String s(Map<String, String> map) {
        InterceptResult invokeL;
        String encode;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, map)) == null) {
            if (map == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : map.keySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                String str3 = map.get(str2);
                if (str2 == null) {
                    encode = "";
                } else {
                    try {
                        encode = URLEncoder.encode(str2, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        if (a) {
                            throw new RuntimeException("This method requires UTF-8 encoding support", e);
                        }
                    }
                }
                sb.append(encode);
                sb.append("=");
                if (str3 == null) {
                    str = "";
                } else {
                    str = URLEncoder.encode(str3, "UTF-8");
                }
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String u(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, str, str2)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errcode", str);
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str2);
                return jSONObject.toString();
            } catch (JSONException unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
