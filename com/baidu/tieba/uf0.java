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
/* loaded from: classes8.dex */
public class uf0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, pg0> a;
    public final LruCache<String, String> b;
    public final LruCache<String, String> c;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final uf0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-376970675, "Lcom/baidu/tieba/uf0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-376970675, "Lcom/baidu/tieba/uf0$a;");
                    return;
                }
            }
            a = new uf0();
        }
    }

    public uf0() {
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

    public static uf0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (uf0) invokeV.objValue;
    }

    @NonNull
    public final eg0 a(String str, String str2, String str3, @NonNull String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, str4)) == null) {
            eg0 eg0Var = new eg0();
            eg0Var.g = str;
            eg0Var.h(str2);
            eg0Var.d = str3;
            TextUtils.isEmpty(str3);
            eg0Var.p.a = str4;
            eg0Var.r.a = new JSONObject().toString();
            return eg0Var;
        }
        return (eg0) invokeLLLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
        if (r1.equals("batchgetdownloadstatus") != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(de0 de0Var, he0 he0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, de0Var, he0Var) == null) {
            String str = (String) vx0.b(de0Var.d(), "params");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject c = ux0.c(str);
            String optString = c.optString("type", "");
            String e = de0Var.e();
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Context b = pe0.b();
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
                    c(c, he0Var);
                    return;
                case 1:
                    i(c, he0Var);
                    return;
                case 2:
                    g(c, he0Var);
                    return;
                case 3:
                    h(c, he0Var);
                    return;
                case 4:
                    d(c, he0Var);
                    return;
                case 5:
                    e(c, he0Var);
                    return;
                case 6:
                    f(e, c, he0Var);
                    return;
                case 7:
                    j(c, he0Var);
                    return;
                case '\b':
                    m(c, he0Var);
                    return;
                case '\t':
                    n(c, he0Var);
                    return;
                default:
                    return;
            }
        }
    }

    public final void c(JSONObject jSONObject, he0 he0Var) {
        String uri;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, he0Var) == null) && jSONObject != null && he0Var != null) {
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
                        pg0 l = l(optString4, optString5, optJSONObject.optString("packageName", ""), optJSONObject.optString(MigrateStatisticUtils.EXT_INFO, ""), optString3, optString2);
                        if (l != null) {
                            String s = l.s();
                            Uri uri2 = l.r().k;
                            String str = l.r().i + "";
                            if (uri2 == null) {
                                uri = "";
                            } else {
                                uri = uri2.toString();
                            }
                            jSONArray.put(ux0.c(ph0.a(s, str, uri, optString5)));
                        }
                    }
                }
                if (jSONArray.length() <= 0) {
                    ph0.b(he0Var, true, hashMap);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                ux0.f(jSONObject2, "result", jSONArray);
                hashMap.put("data", jSONObject2.toString());
                ph0.b(he0Var, true, hashMap);
            } else if (!TextUtils.isEmpty(optString)) {
                ph0.b(he0Var, false, hashMap);
            }
        }
    }

    public final void d(JSONObject jSONObject, @Nullable he0 he0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, jSONObject, he0Var) != null) || jSONObject == null) {
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
            pg0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.c();
                ph0.c(he0Var, optString3, optString2, optString4, "1");
            }
            ph0.b(he0Var, false, hashMap);
            return;
        }
        ph0.b(he0Var, false, hashMap);
    }

    public final void e(JSONObject jSONObject, @Nullable he0 he0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, jSONObject, he0Var) != null) || jSONObject == null) {
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
            pg0 l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.t();
                ph0.b(he0Var, true, hashMap);
                return;
            }
            ph0.b(he0Var, false, hashMap);
            return;
        }
        ph0.b(he0Var, false, hashMap);
    }

    public final void g(JSONObject jSONObject, @Nullable he0 he0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, jSONObject, he0Var) != null) || jSONObject == null) {
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
            pg0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.r();
                l.t();
                ph0.c(he0Var, optString3, optString2, optString4, "2");
                return;
            }
            ph0.b(he0Var, false, hashMap);
            return;
        }
        ph0.b(he0Var, false, null);
    }

    public final void h(JSONObject jSONObject, @Nullable he0 he0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, jSONObject, he0Var) != null) || jSONObject == null) {
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
            pg0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.r();
                l.t();
                ph0.c(he0Var, optString3, optString2, optString4, "1");
                return;
            }
            ph0.b(he0Var, false, hashMap);
            return;
        }
        ph0.b(he0Var, false, hashMap);
    }

    public final void m(JSONObject jSONObject, @Nullable he0 he0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, jSONObject, he0Var) != null) || jSONObject == null) {
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
        vx0.e(this.c, optString4, optString2);
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            pg0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.x(optString3, optString2, optString7, optString6);
                l.g = optString9;
                ph0.b(he0Var, true, hashMap);
                return;
            }
            ph0.b(he0Var, false, hashMap);
            return;
        }
        ph0.b(he0Var, false, hashMap);
    }

    public final void n(JSONObject jSONObject, @Nullable he0 he0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, jSONObject, he0Var) != null) || jSONObject == null) {
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
        vx0.g(this.c, optString4);
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            pg0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.y(optString3, optString2, optString7, optString6);
                ph0.b(he0Var, true, hashMap);
                return;
            }
            ph0.b(he0Var, false, hashMap);
            return;
        }
        ph0.b(he0Var, false, hashMap);
    }

    public final void f(String str, JSONObject jSONObject, @Nullable he0 he0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048581, this, str, jSONObject, he0Var) != null) || jSONObject == null) {
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
            pg0 l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.r();
                l.t();
                ph0.b(he0Var, true, hashMap);
                return;
            }
            ph0.b(he0Var, oh0.h(optString4), hashMap);
            return;
        }
        ph0.b(he0Var, false, hashMap);
    }

    public final void i(JSONObject jSONObject, @Nullable he0 he0Var) {
        Uri uri;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, he0Var) != null) || jSONObject == null) {
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
            pg0 l = l(optString, optString3, optString6, optString5, optString8, optString7);
            if (l != null) {
                eg0 r = l.r();
                l.t();
                if (r != null && (uri = r.k) != null) {
                    optString4 = uri.toString();
                }
                hashMap.put("data", ph0.a("0", "0", optString4, optString3));
                ph0.b(he0Var, true, hashMap);
                return;
            }
            ph0.b(he0Var, false, hashMap);
            return;
        }
        ph0.b(he0Var, false, hashMap);
    }

    public final void j(JSONObject jSONObject, @Nullable he0 he0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, jSONObject, he0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
        String optString2 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
        JSONObject jSONObject2 = new JSONObject();
        String str = "1";
        if (!TextUtils.isEmpty(optString2) && oh0.c(optString2)) {
            str = "0";
        }
        ux0.f(jSONObject2, "result", str);
        hashMap.put("data", jSONObject2.toString());
        if (he0Var != null) {
            he0Var.a(true, hashMap);
        }
    }

    public final pg0 l(String str, String str2, String str3, String str4, String str5, String str6) {
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
            pg0 pg0Var = this.a.get(str2);
            if (pg0Var == null && !TextUtils.isEmpty(str)) {
                eg0 a2 = a(str, str2, str3, ph0.d(str4));
                if (a2.q == null) {
                    a2.q = new fg0();
                }
                if (a2.p == null) {
                    a2.p = new ig0();
                }
                fg0 fg0Var = a2.q;
                fg0Var.b = str6;
                fg0Var.a = str5;
                if (!TextUtils.isEmpty(str4)) {
                    JSONObject c = ux0.c(str4);
                    a2.q.g = c.optInt("close_v_dl");
                    a2.q.c = c.optString("source");
                    a2.p.h = c.optString("app_name");
                    a2.p.g = c.optString("app_icon");
                    a2.p.i = c.optString("version");
                }
                pg0Var = new pg0(a2);
                this.a.put(str2, pg0Var);
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                this.b.put(str2, str);
            }
            return pg0Var;
        }
        return (pg0) invokeCommon.objValue;
    }
}
