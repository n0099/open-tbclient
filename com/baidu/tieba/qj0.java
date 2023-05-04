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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class qj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, lk0> a;
    public final LruCache<String, String> b;
    public final LruCache<String, String> c;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final qj0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-487793195, "Lcom/baidu/tieba/qj0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-487793195, "Lcom/baidu/tieba/qj0$a;");
                    return;
                }
            }
            a = new qj0();
        }
    }

    public qj0() {
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

    public static qj0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (qj0) invokeV.objValue;
    }

    @NonNull
    public final ak0 a(String str, String str2, String str3, @NonNull String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, str4)) == null) {
            ak0 ak0Var = new ak0();
            ak0Var.g = str;
            ak0Var.h(str2);
            ak0Var.d = str3;
            TextUtils.isEmpty(str3);
            ak0Var.p.a = str4;
            ak0Var.r.a = new JSONObject().toString();
            return ak0Var;
        }
        return (ak0) invokeLLLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
        if (r1.equals("batchgetdownloadstatus") != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(zh0 zh0Var, di0 di0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zh0Var, di0Var) == null) {
            String str = (String) a11.b(zh0Var.d(), "params");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject c = z01.c(str);
            String optString = c.optString("type", "");
            String e = zh0Var.e();
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Context b = li0.b();
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
                    if (optString.equals(MiPushClient.COMMAND_REGISTER)) {
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
                    if (optString.equals(MiPushClient.COMMAND_UNREGISTER)) {
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
                    c(c, di0Var);
                    return;
                case 1:
                    i(c, di0Var);
                    return;
                case 2:
                    g(c, di0Var);
                    return;
                case 3:
                    h(c, di0Var);
                    return;
                case 4:
                    d(c, di0Var);
                    return;
                case 5:
                    e(c, di0Var);
                    return;
                case 6:
                    f(e, c, di0Var);
                    return;
                case 7:
                    j(c, di0Var);
                    return;
                case '\b':
                    m(c, di0Var);
                    return;
                case '\t':
                    n(c, di0Var);
                    return;
                default:
                    return;
            }
        }
    }

    public final void c(JSONObject jSONObject, di0 di0Var) {
        String uri;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, di0Var) == null) && jSONObject != null && di0Var != null) {
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
                    if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.optString("url", "")) && !TextUtils.isEmpty(optJSONObject.optString(FontsContractCompat.Columns.FILE_ID, "")) && !TextUtils.isEmpty(optJSONObject.optString("ext_info", ""))) {
                        String optString4 = optJSONObject.optString("url", "");
                        String optString5 = optJSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
                        lk0 l = l(optString4, optString5, optJSONObject.optString("packageName", ""), optJSONObject.optString("ext_info", ""), optString3, optString2);
                        if (l != null) {
                            String u = l.u();
                            Uri uri2 = l.t().k;
                            String str = l.t().i + "";
                            if (uri2 == null) {
                                uri = "";
                            } else {
                                uri = uri2.toString();
                            }
                            jSONArray.put(z01.c(fl0.a(u, str, uri, optString5)));
                        }
                    }
                }
                if (jSONArray.length() <= 0) {
                    fl0.b(di0Var, true, hashMap);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                z01.f(jSONObject2, "result", jSONArray);
                hashMap.put("data", jSONObject2.toString());
                fl0.b(di0Var, true, hashMap);
            } else if (!TextUtils.isEmpty(optString)) {
                fl0.b(di0Var, false, hashMap);
            }
        }
    }

    public final void d(JSONObject jSONObject, @Nullable di0 di0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, jSONObject, di0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("uri", "");
        String optString3 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString("business", "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString3);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            lk0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.c();
                fl0.c(di0Var, optString3, optString2, optString4, "1");
            }
            fl0.b(di0Var, false, hashMap);
            return;
        }
        fl0.b(di0Var, false, hashMap);
    }

    public final void e(JSONObject jSONObject, @Nullable di0 di0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, jSONObject, di0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString2 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString3 = jSONObject.optString("ext_info", "");
        String optString4 = jSONObject.optString("packageName", "");
        String optString5 = jSONObject.optString("business", "");
        String optString6 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
            lk0 l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.x();
                fl0.b(di0Var, true, hashMap);
                return;
            }
            fl0.b(di0Var, false, hashMap);
            return;
        }
        fl0.b(di0Var, false, hashMap);
    }

    public final void g(JSONObject jSONObject, @Nullable di0 di0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, jSONObject, di0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("uri", "");
        String optString3 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString("business", "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString3);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            lk0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.t();
                l.x();
                fl0.c(di0Var, optString3, optString2, optString4, "2");
                return;
            }
            fl0.b(di0Var, false, hashMap);
            return;
        }
        fl0.b(di0Var, false, null);
    }

    public final void h(JSONObject jSONObject, @Nullable di0 di0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, jSONObject, di0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("uri", "");
        String optString3 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString("business", "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString3);
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            lk0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.t();
                l.x();
                fl0.c(di0Var, optString3, optString2, optString4, "1");
                return;
            }
            fl0.b(di0Var, false, hashMap);
            return;
        }
        fl0.b(di0Var, false, hashMap);
    }

    public final void m(JSONObject jSONObject, @Nullable di0 di0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, jSONObject, di0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
        String optString3 = jSONObject.optString("action");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString("business", "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        a11.e(this.c, optString4, optString2);
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            lk0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.z(optString3, optString2, optString7, optString6);
                fl0.b(di0Var, true, hashMap);
                return;
            }
            fl0.b(di0Var, false, hashMap);
            return;
        }
        fl0.b(di0Var, false, hashMap);
    }

    public final void n(JSONObject jSONObject, @Nullable di0 di0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, jSONObject, di0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
        String optString3 = jSONObject.optString("action");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString("business", "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        a11.g(this.c, optString4);
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            lk0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.A(optString3, optString2, optString7, optString6);
                fl0.b(di0Var, true, hashMap);
                return;
            }
            fl0.b(di0Var, false, hashMap);
            return;
        }
        fl0.b(di0Var, false, hashMap);
    }

    public final void f(String str, JSONObject jSONObject, @Nullable di0 di0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048581, this, str, jSONObject, di0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString2 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString3 = jSONObject.optString("ext_info", "");
        String optString4 = jSONObject.optString("packageName", "");
        String optString5 = jSONObject.optString("business", "");
        String optString6 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
            lk0 l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.t();
                l.x();
                fl0.b(di0Var, true, hashMap);
                return;
            }
            fl0.b(di0Var, el0.g(optString4), hashMap);
            return;
        }
        fl0.b(di0Var, false, hashMap);
    }

    public final void i(JSONObject jSONObject, @Nullable di0 di0Var) {
        Uri uri;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, di0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString3 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString4 = jSONObject.optString("uri", "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString("packageName", "");
        String optString7 = jSONObject.optString("business", "");
        String optString8 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString7)) {
            lk0 l = l(optString, optString3, optString6, optString5, optString8, optString7);
            if (l != null) {
                ak0 t = l.t();
                l.x();
                if (t != null && (uri = t.k) != null) {
                    optString4 = uri.toString();
                }
                hashMap.put("data", fl0.a("0", "0", optString4, optString3));
                fl0.b(di0Var, true, hashMap);
                return;
            }
            fl0.b(di0Var, false, hashMap);
            return;
        }
        fl0.b(di0Var, false, hashMap);
    }

    public final void j(JSONObject jSONObject, @Nullable di0 di0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, jSONObject, di0Var) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
        String optString2 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
        JSONObject jSONObject2 = new JSONObject();
        String str = "1";
        if (!TextUtils.isEmpty(optString2) && el0.c(optString2)) {
            str = "0";
        }
        z01.f(jSONObject2, "result", str);
        hashMap.put("data", jSONObject2.toString());
        if (di0Var != null) {
            di0Var.a(true, hashMap);
        }
    }

    public final lk0 l(String str, String str2, String str3, String str4, String str5, String str6) {
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
            lk0 lk0Var = this.a.get(str2);
            if (lk0Var == null && !TextUtils.isEmpty(str)) {
                ak0 a2 = a(str, str2, str3, fl0.d(str4));
                if (a2.q == null) {
                    a2.q = new bk0();
                }
                if (a2.p == null) {
                    a2.p = new ek0();
                }
                bk0 bk0Var = a2.q;
                bk0Var.b = str6;
                bk0Var.a = str5;
                if (!TextUtils.isEmpty(str4)) {
                    JSONObject c = z01.c(str4);
                    a2.q.g = c.optInt("close_v_dl");
                    a2.q.c = c.optString("source");
                    a2.p.h = c.optString("app_name");
                    a2.p.g = c.optString("app_icon");
                    a2.p.i = c.optString("version");
                }
                lk0Var = new lk0(a2);
                this.a.put(str2, lk0Var);
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                this.b.put(str2, str);
            }
            return lk0Var;
        }
        return (lk0) invokeCommon.objValue;
    }
}
