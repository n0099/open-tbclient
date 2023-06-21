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
public class ql0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, lm0> a;
    public final LruCache<String, String> b;
    public final LruCache<String, String> c;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final ql0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-485946153, "Lcom/baidu/tieba/ql0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-485946153, "Lcom/baidu/tieba/ql0$a;");
                    return;
                }
            }
            a = new ql0();
        }
    }

    public ql0() {
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

    public static ql0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (ql0) invokeV.objValue;
    }

    @NonNull
    public final am0 a(String str, String str2, String str3, @NonNull String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, str4)) == null) {
            am0 am0Var = new am0();
            am0Var.g = str;
            am0Var.h(str2);
            am0Var.d = str3;
            TextUtils.isEmpty(str3);
            am0Var.p.a = str4;
            am0Var.r.a = new JSONObject().toString();
            return am0Var;
        }
        return (am0) invokeLLLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
        if (r1.equals("batchgetdownloadstatus") != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(zj0 zj0Var, dk0 dk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zj0Var, dk0Var) == null) {
            String str = (String) a31.b(zj0Var.d(), "params");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject c = z21.c(str);
            String optString = c.optString("type", "");
            String e = zj0Var.e();
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Context b = lk0.b();
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
                    c(c, dk0Var);
                    return;
                case 1:
                    i(c, dk0Var);
                    return;
                case 2:
                    g(c, dk0Var);
                    return;
                case 3:
                    h(c, dk0Var);
                    return;
                case 4:
                    d(c, dk0Var);
                    return;
                case 5:
                    e(c, dk0Var);
                    return;
                case 6:
                    f(e, c, dk0Var);
                    return;
                case 7:
                    j(c, dk0Var);
                    return;
                case '\b':
                    m(c, dk0Var);
                    return;
                case '\t':
                    n(c, dk0Var);
                    return;
                default:
                    return;
            }
        }
    }

    public final void c(JSONObject jSONObject, dk0 dk0Var) {
        String uri;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, dk0Var) == null) && jSONObject != null && dk0Var != null) {
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
                        lm0 l = l(optString4, optString5, optJSONObject.optString("packageName", ""), optJSONObject.optString(MigrateStatisticUtils.EXT_INFO, ""), optString3, optString2);
                        if (l != null) {
                            String u = l.u();
                            Uri uri2 = l.t().k;
                            String str = l.t().i + "";
                            if (uri2 == null) {
                                uri = "";
                            } else {
                                uri = uri2.toString();
                            }
                            jSONArray.put(z21.c(fn0.a(u, str, uri, optString5)));
                        }
                    }
                }
                if (jSONArray.length() <= 0) {
                    fn0.b(dk0Var, true, hashMap);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                z21.f(jSONObject2, "result", jSONArray);
                hashMap.put("data", jSONObject2.toString());
                fn0.b(dk0Var, true, hashMap);
            } else if (!TextUtils.isEmpty(optString)) {
                fn0.b(dk0Var, false, hashMap);
            }
        }
    }

    public final void d(JSONObject jSONObject, @Nullable dk0 dk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, jSONObject, dk0Var) != null) || jSONObject == null) {
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
            lm0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.c();
                fn0.c(dk0Var, optString3, optString2, optString4, "1");
            }
            fn0.b(dk0Var, false, hashMap);
            return;
        }
        fn0.b(dk0Var, false, hashMap);
    }

    public final void e(JSONObject jSONObject, @Nullable dk0 dk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, jSONObject, dk0Var) != null) || jSONObject == null) {
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
            lm0 l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.x();
                fn0.b(dk0Var, true, hashMap);
                return;
            }
            fn0.b(dk0Var, false, hashMap);
            return;
        }
        fn0.b(dk0Var, false, hashMap);
    }

    public final void g(JSONObject jSONObject, @Nullable dk0 dk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, jSONObject, dk0Var) != null) || jSONObject == null) {
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
            lm0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.t();
                l.x();
                fn0.c(dk0Var, optString3, optString2, optString4, "2");
                return;
            }
            fn0.b(dk0Var, false, hashMap);
            return;
        }
        fn0.b(dk0Var, false, null);
    }

    public final void h(JSONObject jSONObject, @Nullable dk0 dk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, jSONObject, dk0Var) != null) || jSONObject == null) {
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
            lm0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.t();
                l.x();
                fn0.c(dk0Var, optString3, optString2, optString4, "1");
                return;
            }
            fn0.b(dk0Var, false, hashMap);
            return;
        }
        fn0.b(dk0Var, false, hashMap);
    }

    public final void m(JSONObject jSONObject, @Nullable dk0 dk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, jSONObject, dk0Var) != null) || jSONObject == null) {
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
        a31.e(this.c, optString4, optString2);
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            lm0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.z(optString3, optString2, optString7, optString6);
                fn0.b(dk0Var, true, hashMap);
                return;
            }
            fn0.b(dk0Var, false, hashMap);
            return;
        }
        fn0.b(dk0Var, false, hashMap);
    }

    public final void n(JSONObject jSONObject, @Nullable dk0 dk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, jSONObject, dk0Var) != null) || jSONObject == null) {
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
        a31.g(this.c, optString4);
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            lm0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.A(optString3, optString2, optString7, optString6);
                fn0.b(dk0Var, true, hashMap);
                return;
            }
            fn0.b(dk0Var, false, hashMap);
            return;
        }
        fn0.b(dk0Var, false, hashMap);
    }

    public final void f(String str, JSONObject jSONObject, @Nullable dk0 dk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048581, this, str, jSONObject, dk0Var) != null) || jSONObject == null) {
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
            lm0 l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.t();
                l.x();
                fn0.b(dk0Var, true, hashMap);
                return;
            }
            fn0.b(dk0Var, en0.g(optString4), hashMap);
            return;
        }
        fn0.b(dk0Var, false, hashMap);
    }

    public final void i(JSONObject jSONObject, @Nullable dk0 dk0Var) {
        Uri uri;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, dk0Var) != null) || jSONObject == null) {
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
            lm0 l = l(optString, optString3, optString6, optString5, optString8, optString7);
            if (l != null) {
                am0 t = l.t();
                l.x();
                if (t != null && (uri = t.k) != null) {
                    optString4 = uri.toString();
                }
                hashMap.put("data", fn0.a("0", "0", optString4, optString3));
                fn0.b(dk0Var, true, hashMap);
                return;
            }
            fn0.b(dk0Var, false, hashMap);
            return;
        }
        fn0.b(dk0Var, false, hashMap);
    }

    public final void j(JSONObject jSONObject, @Nullable dk0 dk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, jSONObject, dk0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
        String optString2 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
        JSONObject jSONObject2 = new JSONObject();
        String str = "1";
        if (!TextUtils.isEmpty(optString2) && en0.c(optString2)) {
            str = "0";
        }
        z21.f(jSONObject2, "result", str);
        hashMap.put("data", jSONObject2.toString());
        if (dk0Var != null) {
            dk0Var.a(true, hashMap);
        }
    }

    public final lm0 l(String str, String str2, String str3, String str4, String str5, String str6) {
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
            lm0 lm0Var = this.a.get(str2);
            if (lm0Var == null && !TextUtils.isEmpty(str)) {
                am0 a2 = a(str, str2, str3, fn0.d(str4));
                if (a2.q == null) {
                    a2.q = new bm0();
                }
                if (a2.p == null) {
                    a2.p = new em0();
                }
                bm0 bm0Var = a2.q;
                bm0Var.b = str6;
                bm0Var.a = str5;
                if (!TextUtils.isEmpty(str4)) {
                    JSONObject c = z21.c(str4);
                    a2.q.g = c.optInt("close_v_dl");
                    a2.q.c = c.optString("source");
                    a2.p.h = c.optString("app_name");
                    a2.p.g = c.optString("app_icon");
                    a2.p.i = c.optString("version");
                }
                lm0Var = new lm0(a2);
                this.a.put(str2, lm0Var);
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                this.b.put(str2, str);
            }
            return lm0Var;
        }
        return (lm0) invokeCommon.objValue;
    }
}
