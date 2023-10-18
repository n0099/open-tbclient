package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes7.dex */
public class me0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he0 a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ boolean c;

        public a(he0 he0Var, Map map, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he0Var, map, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he0Var;
            this.b = map;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                me0.t(this.a, this.b, this.c);
            }
        }
    }

    public static void t(he0 he0Var, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(65555, null, he0Var, map, z) != null) || he0Var == null) {
            return;
        }
        he0Var.a(z, map);
    }

    public static Map<String, String> w(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65558, null, str, i, str2)) == null) {
            Map<String, String> u = u(i, str2);
            if (str != null) {
                u.put("data", str);
            }
            return u;
        }
        return (Map) invokeLIL.objValue;
    }

    public static Map<String, String> b(he0 he0Var, @Nullable de0 de0Var, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{he0Var, de0Var, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return c(he0Var, de0Var, null, i, z);
        }
        return (Map) invokeCommon.objValue;
    }

    public static Map<String, String> d(he0 he0Var, String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{he0Var, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return e(he0Var, str, null, i, z);
        }
        return (Map) invokeCommon.objValue;
    }

    public static void s(he0 he0Var, Map<String, String> map, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{he0Var, map, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (ef0.b()) {
                t(he0Var, map, z);
            } else {
                ef0.c(new a(he0Var, map, z));
            }
        }
    }

    public static Map<String, String> c(he0 he0Var, @Nullable de0 de0Var, @Nullable String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{he0Var, de0Var, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Map<String, String> v = v(str, i);
            if (de0Var != null) {
                String str2 = (String) vx0.b(de0Var.d(), WebChromeClient.KEY_ARG_CALLBACK);
                if (!TextUtils.isEmpty(str2)) {
                    vx0.e(v, WebChromeClient.KEY_ARG_CALLBACK, str2);
                }
            }
            s(he0Var, v, i, z);
            return v;
        }
        return (Map) invokeCommon.objValue;
    }

    public static Map<String, String> e(he0 he0Var, String str, @Nullable String str2, int i, boolean z) {
        InterceptResult invokeCommon;
        de0 de0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{he0Var, str, str2, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (!TextUtils.isEmpty(str)) {
                de0Var = new de0(str);
            } else {
                de0Var = null;
            }
            return c(he0Var, de0Var, str2, i, z);
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
            if (tx0.g(pathSegments)) {
                return null;
            }
            return (String) tx0.d(pathSegments, tx0.l(pathSegments) - 1);
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
            jy0.e(new ClogBuilder().y(ClogBuilder.LogType.EXCEPTION).k("1").l("1002").m(str));
        }
    }

    @Nullable
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
            Context b = pe0.b();
            if (b == null) {
                return "applicationContext为空";
            }
            if (i != 0) {
                if (i != 101) {
                    if (i != 201) {
                        if (i != 202) {
                            if (i != 301) {
                                if (i != 302) {
                                    switch (i) {
                                        case 401:
                                            return b.getString(R.string.nad_scheme_err_message_action_sec_check_fail);
                                        case 402:
                                            return b.getString(R.string.nad_scheme_err_message_action_acl_check_fail);
                                        case 403:
                                            return b.getString(R.string.nad_scheme_err_message_action_allow_close);
                                        default:
                                            return b.getString(R.string.nad_scheme_err_message_parse_fail);
                                    }
                                }
                                return b.getString(R.string.nad_scheme_err_message_action_notfound);
                            }
                            return b.getString(R.string.nad_scheme_err_message_module_notfound);
                        }
                        return b.getString(R.string.nad_scheme_err_message_params_parse_fail);
                    }
                    return b.getString(R.string.nad_scheme_err_message_parse_fail);
                }
                return b.getString(R.string.nad_scheme_err_message_not_support);
            }
            return b.getString(R.string.nad_scheme_err_message_ok);
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
            if (!tx0.g(pathSegments)) {
                for (int i = 0; i < tx0.l(pathSegments) - 1; i++) {
                    sb.append("/");
                    sb.append((String) tx0.d(pathSegments, i));
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String p(@Nullable Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, map)) == null) {
            if (map == null || vx0.b(map, WebChromeClient.KEY_ARG_CALLBACK) == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            ux0.f(jSONObject, "status", vx0.b(map, "status"));
            ux0.f(jSONObject, "message", vx0.b(map, "message"));
            ux0.f(jSONObject, "data", vx0.b(map, "data"));
            return h((String) vx0.b(map, WebChromeClient.KEY_ARG_CALLBACK), ux0.a(jSONObject.toString()));
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static HashMap<String, String> l(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, uri)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
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
            jy0.e(m);
        }
    }

    public static Map<String, String> u(int i, String str) {
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

    public static Map<String, String> v(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, str, i)) == null) {
            return w(str, i, j(i));
        }
        return (Map) invokeLI.objValue;
    }
}
