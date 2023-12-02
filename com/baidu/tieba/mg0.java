package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.utils.LruCache;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class mg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, hh0> a;
    public final LruCache<String, String> b;
    public final LruCache<String, String> c;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final mg0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-605080362, "Lcom/baidu/tieba/mg0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-605080362, "Lcom/baidu/tieba/mg0$a;");
                    return;
                }
            }
            a = new mg0();
        }
    }

    public mg0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LruCache<>(5);
        this.b = new LruCache<>(5);
        this.c = new LruCache<>(5);
    }

    public static mg0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (mg0) invokeV.objValue;
    }

    @NonNull
    public final wg0 a(String str, String str2, String str3, @NonNull String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, str4)) == null) {
            wg0 wg0Var = new wg0();
            wg0Var.g = str;
            wg0Var.h(str2);
            wg0Var.d = str3;
            TextUtils.isEmpty(str3);
            wg0Var.p.a = str4;
            wg0Var.r.a = new JSONObject().toString();
            return wg0Var;
        }
        return (wg0) invokeLLLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
        if (r1.equals("batchgetdownloadstatus") != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ve0 ve0Var, ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ve0Var, ze0Var) == null) {
            String str = (String) py0.b(ve0Var.d(), "params");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject c = oy0.c(str);
            String optString = c.optString("type", "");
            String e = ve0Var.e();
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Context b = hf0.b();
            char c2 = 0;
            if (!NetUtil.a(b) && (TextUtils.equals(optString, "startdownload") || TextUtils.equals(optString, "resumedownload"))) {
                Toast.makeText(b, b.getString(R.string.nad_download_net_tip), 0).show();
                return;
            }
            switch (optString.hashCode()) {
                case -1263192174:
                    if (optString.equals("openapk")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1028248962:
                    if (optString.equals("querypackage")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -690213213:
                    if (optString.equals("register")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -568075006:
                    if (optString.equals("canceldownload")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -515860354:
                    if (optString.equals("pausedownload")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 120066997:
                    if (optString.equals("resumedownload")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 636901206:
                    break;
                case 836015164:
                    if (optString.equals("unregister")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 900442785:
                    if (optString.equals("installapk")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1490291434:
                    if (optString.equals("startdownload")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    c(c, ze0Var);
                    return;
                case 1:
                    i(c, ze0Var);
                    return;
                case 2:
                    g(c, ze0Var);
                    return;
                case 3:
                    h(c, ze0Var);
                    return;
                case 4:
                    d(c, ze0Var);
                    return;
                case 5:
                    e(c, ze0Var);
                    return;
                case 6:
                    f(e, c, ze0Var);
                    return;
                case 7:
                    j(c, ze0Var);
                    return;
                case '\b':
                    m(c, ze0Var);
                    return;
                case '\t':
                    n(c, ze0Var);
                    return;
                default:
                    return;
            }
        }
    }

    public final void c(JSONObject jSONObject, ze0 ze0Var) {
        String uri;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, ze0Var) == null) && jSONObject != null && ze0Var != null) {
            String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
            JSONArray optJSONArray = jSONObject.optJSONArray("query");
            String optString2 = jSONObject.optString("business", "");
            String optString3 = jSONObject.optString("page", "");
            HashMap hashMap = new HashMap();
            hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
            if (optJSONArray != null && optJSONArray.length() > 0 && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString2)) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.optString("url", "")) && !TextUtils.isEmpty(optJSONObject.optString(FontsContractCompat.Columns.FILE_ID, "")) && !TextUtils.isEmpty(optJSONObject.optString(MigrateStatisticUtils.EXT_INFO, ""))) {
                        String optString4 = optJSONObject.optString("url", "");
                        String optString5 = optJSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
                        hh0 l = l(optString4, optString5, optJSONObject.optString("packageName", ""), optJSONObject.optString(MigrateStatisticUtils.EXT_INFO, ""), optString3, optString2);
                        if (l != null) {
                            String t = l.t();
                            Uri uri2 = l.s().k;
                            String str = l.s().i + "";
                            if (uri2 == null) {
                                uri = "";
                            } else {
                                uri = uri2.toString();
                            }
                            jSONArray.put(oy0.c(hi0.a(t, str, uri, optString5)));
                        }
                    }
                }
                if (jSONArray.length() <= 0) {
                    hi0.b(ze0Var, true, hashMap);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                oy0.f(jSONObject2, "result", jSONArray);
                hashMap.put("data", jSONObject2.toString());
                hi0.b(ze0Var, true, hashMap);
            } else if (!TextUtils.isEmpty(optString)) {
                hi0.b(ze0Var, false, hashMap);
            }
        }
    }

    public final void d(JSONObject jSONObject, @Nullable ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, jSONObject, ze0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("uri", "");
        String optString3 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString(MigrateStatisticUtils.EXT_INFO, "");
        String optString6 = jSONObject.optString("business", "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString3);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            hh0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.c();
                hi0.c(ze0Var, optString3, optString2, optString4, "1");
            }
            hi0.b(ze0Var, false, hashMap);
            return;
        }
        hi0.b(ze0Var, false, hashMap);
    }

    public final void e(JSONObject jSONObject, @Nullable ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, jSONObject, ze0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString2 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString3 = jSONObject.optString(MigrateStatisticUtils.EXT_INFO, "");
        String optString4 = jSONObject.optString("packageName", "");
        String optString5 = jSONObject.optString("business", "");
        String optString6 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
            hh0 l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.u();
                hi0.b(ze0Var, true, hashMap);
                return;
            }
            hi0.b(ze0Var, false, hashMap);
            return;
        }
        hi0.b(ze0Var, false, hashMap);
    }

    public final void g(JSONObject jSONObject, @Nullable ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, jSONObject, ze0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("uri", "");
        String optString3 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString(MigrateStatisticUtils.EXT_INFO, "");
        String optString6 = jSONObject.optString("business", "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString3);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            hh0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.s();
                l.u();
                hi0.c(ze0Var, optString3, optString2, optString4, "2");
                return;
            }
            hi0.b(ze0Var, false, hashMap);
            return;
        }
        hi0.b(ze0Var, false, null);
    }

    public final void h(JSONObject jSONObject, @Nullable ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, jSONObject, ze0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("uri", "");
        String optString3 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString(MigrateStatisticUtils.EXT_INFO, "");
        String optString6 = jSONObject.optString("business", "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString3);
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            hh0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.s();
                l.u();
                hi0.c(ze0Var, optString3, optString2, optString4, "1");
                return;
            }
            hi0.b(ze0Var, false, hashMap);
            return;
        }
        hi0.b(ze0Var, false, hashMap);
    }

    public final void m(JSONObject jSONObject, @Nullable ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, jSONObject, ze0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
        String optString3 = jSONObject.optString("action");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString(MigrateStatisticUtils.EXT_INFO, "");
        String optString6 = jSONObject.optString("business", "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        String optString9 = jSONObject.optString("lp_url", "");
        py0.e(this.c, optString4, optString2);
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            hh0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.y(optString3, optString2, optString7, optString6);
                l.g = optString9;
                hi0.b(ze0Var, true, hashMap);
                return;
            }
            hi0.b(ze0Var, false, hashMap);
            return;
        }
        hi0.b(ze0Var, false, hashMap);
    }

    public final void n(JSONObject jSONObject, @Nullable ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, jSONObject, ze0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
        String optString3 = jSONObject.optString("action");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString(MigrateStatisticUtils.EXT_INFO, "");
        String optString6 = jSONObject.optString("business", "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        py0.g(this.c, optString4);
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            hh0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.z(optString3, optString2, optString7, optString6);
                hi0.b(ze0Var, true, hashMap);
                return;
            }
            hi0.b(ze0Var, false, hashMap);
            return;
        }
        hi0.b(ze0Var, false, hashMap);
    }

    public final void f(String str, JSONObject jSONObject, @Nullable ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048581, this, str, jSONObject, ze0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString2 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString3 = jSONObject.optString(MigrateStatisticUtils.EXT_INFO, "");
        String optString4 = jSONObject.optString("packageName", "");
        String optString5 = jSONObject.optString("business", "");
        String optString6 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
            hh0 l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.s();
                l.u();
                hi0.b(ze0Var, true, hashMap);
                return;
            }
            hi0.b(ze0Var, gi0.h(optString4), hashMap);
            return;
        }
        hi0.b(ze0Var, false, hashMap);
    }

    public final void i(JSONObject jSONObject, @Nullable ze0 ze0Var) {
        Uri uri;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, ze0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString3 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString4 = jSONObject.optString("uri", "");
        String optString5 = jSONObject.optString(MigrateStatisticUtils.EXT_INFO, "");
        String optString6 = jSONObject.optString("packageName", "");
        String optString7 = jSONObject.optString("business", "");
        String optString8 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString7)) {
            hh0 l = l(optString, optString3, optString6, optString5, optString8, optString7);
            if (l != null) {
                wg0 s = l.s();
                l.u();
                if (s != null && (uri = s.k) != null) {
                    optString4 = uri.toString();
                }
                hashMap.put("data", hi0.a("0", "0", optString4, optString3));
                hi0.b(ze0Var, true, hashMap);
                return;
            }
            hi0.b(ze0Var, false, hashMap);
            return;
        }
        hi0.b(ze0Var, false, hashMap);
    }

    public final void j(JSONObject jSONObject, @Nullable ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, jSONObject, ze0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
        String optString2 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
        JSONObject jSONObject2 = new JSONObject();
        String str = "1";
        if (!TextUtils.isEmpty(optString2) && gi0.c(optString2)) {
            str = "0";
        }
        oy0.f(jSONObject2, "result", str);
        hashMap.put("data", jSONObject2.toString());
        if (ze0Var != null) {
            ze0Var.a(true, hashMap);
        }
    }

    public final hh0 l(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            if (TextUtils.isEmpty(str2) && this.b.containsValue(str)) {
                for (String str7 : this.b.keySet()) {
                    if (TextUtils.equals(this.b.get(str7), str)) {
                        str2 = str7;
                    }
                }
            }
            if (TextUtils.isEmpty(str) && this.b.containsKey(str2)) {
                str = this.b.get(str2);
            }
            hh0 hh0Var = this.a.get(str2);
            if (hh0Var == null && !TextUtils.isEmpty(str)) {
                wg0 a2 = a(str, str2, str3, hi0.d(str4));
                if (a2.q == null) {
                    a2.q = new xg0();
                }
                if (a2.p == null) {
                    a2.p = new ah0();
                }
                xg0 xg0Var = a2.q;
                xg0Var.b = str6;
                xg0Var.a = str5;
                if (!TextUtils.isEmpty(str4)) {
                    JSONObject c = oy0.c(str4);
                    a2.q.g = c.optInt("close_v_dl");
                    a2.q.c = c.optString("source");
                    a2.p.h = c.optString("app_name");
                    a2.p.g = c.optString("app_icon");
                    a2.p.i = c.optString("version");
                }
                hh0Var = new hh0(a2);
                this.a.put(str2, hh0Var);
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                this.b.put(str2, str);
            }
            return hh0Var;
        }
        return (hh0) invokeCommon.objValue;
    }
}
