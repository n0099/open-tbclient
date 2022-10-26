package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ si0 a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ boolean c;

        public a(si0 si0Var, Map map, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si0Var, map, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = si0Var;
            this.b = map;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xi0.t(this.a, this.b, this.c);
            }
        }
    }

    public static void t(si0 si0Var, Map map, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(65555, null, si0Var, map, z) != null) || si0Var == null) {
            return;
        }
        si0Var.a(z, map);
    }

    public static Map w(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65558, null, str, i, str2)) == null) {
            Map u = u(i, str2);
            if (str != null) {
                u.put("data", str);
            }
            return u;
        }
        return (Map) invokeLIL.objValue;
    }

    public static Map b(si0 si0Var, oi0 oi0Var, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{si0Var, oi0Var, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return c(si0Var, oi0Var, null, i, z);
        }
        return (Map) invokeCommon.objValue;
    }

    public static Map d(si0 si0Var, String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{si0Var, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return e(si0Var, str, null, i, z);
        }
        return (Map) invokeCommon.objValue;
    }

    public static void s(si0 si0Var, Map map, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{si0Var, map, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (oj0.a()) {
                t(si0Var, map, z);
            } else {
                oj0.b(new a(si0Var, map, z));
            }
        }
    }

    public static Map c(si0 si0Var, oi0 oi0Var, String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{si0Var, oi0Var, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Map v = v(str, i);
            if (oi0Var != null) {
                String str2 = (String) zz0.b(oi0Var.d(), WebChromeClient.KEY_ARG_CALLBACK);
                if (!TextUtils.isEmpty(str2)) {
                    zz0.e(v, WebChromeClient.KEY_ARG_CALLBACK, str2);
                }
            }
            s(si0Var, v, i, z);
            return v;
        }
        return (Map) invokeCommon.objValue;
    }

    public static Map e(si0 si0Var, String str, String str2, int i, boolean z) {
        InterceptResult invokeCommon;
        oi0 oi0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{si0Var, str, str2, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (!TextUtils.isEmpty(str)) {
                oi0Var = new oi0(str);
            } else {
                oi0Var = null;
            }
            return c(si0Var, oi0Var, str2, i, z);
        }
        return (Map) invokeCommon.objValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return !TextUtils.isEmpty(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return TextUtils.equals("vendor/ad", str);
        }
        return invokeL.booleanValue;
    }

    public static String i(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (xz0.g(pathSegments)) {
                return null;
            }
            return (String) xz0.d(pathSegments, xz0.l(pathSegments) - 1);
        }
        return (String) invokeL.objValue;
    }

    public static String m(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            return uri.getScheme();
        }
        return (String) invokeL.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return TextUtils.equals("dlink", i(Uri.parse(str)));
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Uri.parse(str) == null) {
                r(str);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            i01.b(new ClogBuilder().y(ClogBuilder.LogType.EXCEPTION).k("1").l("1002").m(str));
        }
    }

    public static String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (!str.startsWith("javascript:")) {
                    str = "javascript:" + str;
                }
                return str + "('" + str2 + "');";
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            if (i != 0) {
                if (i != 101) {
                    if (i != 201) {
                        if (i != 202) {
                            if (i != 301) {
                                if (i != 302) {
                                    switch (i) {
                                        case 401:
                                            return aj0.b().getString(R.string.obfuscated_res_0x7f0f0c0d);
                                        case 402:
                                            return aj0.b().getString(R.string.obfuscated_res_0x7f0f0c0a);
                                        case 403:
                                            return aj0.b().getString(R.string.obfuscated_res_0x7f0f0c0b);
                                        default:
                                            return aj0.b().getString(R.string.obfuscated_res_0x7f0f0c12);
                                    }
                                }
                                return aj0.b().getString(R.string.obfuscated_res_0x7f0f0c0c);
                            }
                            return aj0.b().getString(R.string.obfuscated_res_0x7f0f0c0e);
                        }
                        return aj0.b().getString(R.string.obfuscated_res_0x7f0f0c11);
                    }
                    return aj0.b().getString(R.string.obfuscated_res_0x7f0f0c12);
                }
                return aj0.b().getString(R.string.obfuscated_res_0x7f0f0c0f);
            }
            return aj0.b().getString(R.string.obfuscated_res_0x7f0f0c10);
        }
        return (String) invokeI.objValue;
    }

    public static String k(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            String host = uri.getHost();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(host)) {
                sb.append(host);
            }
            List<String> pathSegments = uri.getPathSegments();
            if (!xz0.g(pathSegments)) {
                for (int i = 0; i < xz0.l(pathSegments) - 1; i++) {
                    sb.append("/");
                    sb.append((String) xz0.d(pathSegments, i));
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String p(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, map)) == null) {
            if (map == null || zz0.b(map, WebChromeClient.KEY_ARG_CALLBACK) == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            yz0.f(jSONObject, "status", zz0.b(map, "status"));
            yz0.f(jSONObject, "message", zz0.b(map, "message"));
            yz0.f(jSONObject, "data", zz0.b(map, "data"));
            return h((String) zz0.b(map, WebChromeClient.KEY_ARG_CALLBACK), yz0.a(jSONObject.toString()));
        }
        return (String) invokeL.objValue;
    }

    public static HashMap l(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, uri)) == null) {
            HashMap hashMap = new HashMap();
            if (uri != null) {
                try {
                    Set<String> queryParameterNames = uri.getQueryParameterNames();
                    if (queryParameterNames != null) {
                        for (String str : queryParameterNames) {
                            hashMap.put(str, uri.getQueryParameter(str));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static void q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, str2) == null) {
            ClogBuilder m = new ClogBuilder().y(ClogBuilder.LogType.EXCEPTION).k("1").l(DpStatConstants.FILECACHE_CLOSE_TYPE_OPT_IS_LIVE).m(str);
            if (!TextUtils.isEmpty(str2)) {
                m.p(str2);
            }
            i01.b(m);
        }
    }

    public static Map u(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65556, null, i, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", String.valueOf(i));
            hashMap.put("message", str);
            return hashMap;
        }
        return (Map) invokeIL.objValue;
    }

    public static Map v(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, str, i)) == null) {
            return w(str, i, j(i));
        }
        return (Map) invokeLI.objValue;
    }
}
