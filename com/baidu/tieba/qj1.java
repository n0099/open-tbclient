package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.nad.jni.NADNativeHelper;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.atomData.AbsMsgImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qj1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qj1 b;

        public a(qj1 qj1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qj1Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                String f = this.b.f(this.a, currentTimeMillis);
                String f2 = this.b.f(this.a, 86400000 + currentTimeMillis);
                String f3 = this.b.f(this.a, 172800000 + currentTimeMillis);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AbsMsgImageActivityConfig.CURRENT_URL, f);
                    jSONObject.put("tomorrow_url", f2);
                    jSONObject.put("after_tomorrow_url", f3);
                    jSONObject.put("cache_time", currentTimeMillis);
                } catch (JSONException unused) {
                }
                q31.a().b("splash_sp_name").i("splash_query_cache_url", jSONObject.toString(), false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final qj1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-487763373, "Lcom/baidu/tieba/qj1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-487763373, "Lcom/baidu/tieba/qj1$b;");
                    return;
                }
            }
            a = new qj1(null);
        }
    }

    public qj1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static qj1 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (qj1) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && sj1.v()) {
            h("query");
        }
    }

    public /* synthetic */ qj1(a aVar) {
        this();
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return f(str, System.currentTimeMillis());
        }
        return (String) invokeL.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            u41.d(new a(this, str), "cache splash request url");
        }
    }

    public final void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || fj1.a().d() == null || !fj1.a().d().has("client_ext") || (optJSONObject = fj1.a().d().optJSONObject("client_ext")) == null) {
            return;
        }
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject.put(next, optJSONObject.opt(next));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final String j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            int a2 = l61.a(j, System.currentTimeMillis());
            if (a2 >= 2) {
                return q31.a().b("splash_sp_name").getString("after_tomorrow_reason", "");
            }
            if (a2 == 1) {
                return q31.a().b("splash_sp_name").getString("tomorrow_reason", "");
            }
            return q31.a().b("splash_sp_name").getString("current_reason", "");
        }
        return (String) invokeJ.objValue;
    }

    public final void b(HashMap<String, String> hashMap) {
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            ak0 a2 = sj0.a();
            if (TextUtils.isEmpty(a2.p())) {
                p = a2.w();
            } else {
                p = a2.p();
            }
            hashMap.put("ver", p);
            hashMap.put("sv", "1.0");
            hashMap.put("uid", a2.t());
            hashMap.put(TiebaStatic.Params.BDID, a2.o());
            hashMap.put("cuid", a2.g());
            String e = kk0.c().e(false);
            if (!TextUtils.isEmpty(e)) {
                hashMap.put(SearchJsBridge.COOKIE_MOD, e);
            }
            String h = kk0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                hashMap.put("ov", h);
            }
            String b2 = kk0.c().b(false);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("imei", b2);
            }
            hashMap.put("ua", a2.q());
            hashMap.put("fmt", "json");
            hashMap.put("apna", a2.packageName());
            hashMap.put("eid", a2.i());
            hashMap.put("st", "1");
            hashMap.put("ot", "2");
            hashMap.put("nt", String.valueOf(new ft0().c()));
            hashMap.put(Config.EXCEPTION_CRASH_TYPE, "2");
            hashMap.put("is_https", "1");
            String a3 = kk0.c().a(false);
            if (!TextUtils.isEmpty(a3)) {
                hashMap.put(HttpRequest.ANDROID_ID, a3);
            }
            hashMap.put("from", fj1.a().from());
            hashMap.put("cfrom", fj1.a().a());
            hashMap.put("User-Agent", sj0.e());
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:4|5|6|(1:8)|9|(3:52|53|(15:55|(6:58|(2:60|(4:62|(1:64)|65|(1:67))(2:68|(1:70)))|71|(2:73|74)(1:76)|75|56)|77|12|(2:14|(4:(1:17)|18|19|20)(1:50))(1:51)|21|(1:23)(3:38|39|(1:41)(2:42|(1:44)))|24|(1:26)|27|(1:29)|30|31|32|34))|11|12|(0)(0)|21|(0)(0)|24|(0)|27|(0)|30|31|32|34) */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fb A[Catch: JSONException -> 0x02ae, TryCatch #3 {JSONException -> 0x02ae, blocks: (B:11:0x005b, B:13:0x0061, B:14:0x0066, B:16:0x006c, B:18:0x0086, B:20:0x00a3, B:22:0x00a9, B:23:0x00ae, B:25:0x00b4, B:26:0x00ba, B:28:0x00c0, B:29:0x00c1, B:31:0x00d2, B:34:0x00dd, B:36:0x00fb, B:40:0x012c), top: B:78:0x005b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01aa A[Catch: JSONException -> 0x02b2, TRY_LEAVE, TryCatch #4 {JSONException -> 0x02b2, blocks: (B:5:0x000c, B:8:0x0024, B:9:0x002f, B:42:0x0136, B:45:0x0147, B:47:0x01aa, B:58:0x01f4, B:60:0x0207, B:61:0x020c, B:63:0x0242, B:64:0x0252, B:65:0x026c, B:43:0x013a, B:49:0x01b3, B:52:0x01bd, B:53:0x01d2, B:55:0x01e0), top: B:80:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b3 A[Catch: all -> 0x01ec, TRY_ENTER, TRY_LEAVE, TryCatch #4 {JSONException -> 0x02b2, blocks: (B:5:0x000c, B:8:0x0024, B:9:0x002f, B:42:0x0136, B:45:0x0147, B:47:0x01aa, B:58:0x01f4, B:60:0x0207, B:61:0x020c, B:63:0x0242, B:64:0x0252, B:65:0x026c, B:43:0x013a, B:49:0x01b3, B:52:0x01bd, B:53:0x01d2, B:55:0x01e0), top: B:80:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0207 A[Catch: JSONException -> 0x02b2, TryCatch #4 {JSONException -> 0x02b2, blocks: (B:5:0x000c, B:8:0x0024, B:9:0x002f, B:42:0x0136, B:45:0x0147, B:47:0x01aa, B:58:0x01f4, B:60:0x0207, B:61:0x020c, B:63:0x0242, B:64:0x0252, B:65:0x026c, B:43:0x013a, B:49:0x01b3, B:52:0x01bd, B:53:0x01d2, B:55:0x01e0), top: B:80:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0242 A[Catch: JSONException -> 0x02b2, TRY_LEAVE, TryCatch #4 {JSONException -> 0x02b2, blocks: (B:5:0x000c, B:8:0x0024, B:9:0x002f, B:42:0x0136, B:45:0x0147, B:47:0x01aa, B:58:0x01f4, B:60:0x0207, B:61:0x020c, B:63:0x0242, B:64:0x0252, B:65:0x026c, B:43:0x013a, B:49:0x01b3, B:52:0x01bd, B:53:0x01d2, B:55:0x01e0), top: B:80:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(@NonNull HashMap<String, String> hashMap, String str, String str2, long j) {
        int i;
        qj1 qj1Var;
        String defaultUserAgent;
        String a2;
        String f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{hashMap, str, str2, Long.valueOf(j)}) == null) {
            long j2 = j;
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                if (p8.f().h()) {
                    jSONObject.put("k", "cmd");
                    jSONObject.put("v", str2);
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("k", AdExtParam.KEY_NAD_CORE_VERSION);
                jSONObject2.put("v", "5.12.0.98");
                jSONArray.put(jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                List<tj1> s = rj1.s();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray2 = new JSONArray();
                if (s != null) {
                    try {
                        if (s.size() > 0) {
                            Iterator<tj1> it = s.iterator();
                            i = 0;
                            while (it.hasNext()) {
                                tj1 next = it.next();
                                JSONObject jSONObject4 = new JSONObject();
                                Iterator<tj1> it2 = it;
                                jSONObject4.put("k", next.c);
                                if (!TextUtils.isEmpty(next.c)) {
                                    int h = rj1.h(next, false, 0, j2);
                                    Log.e("RequestUrlManager", "onAdSuccess: " + h);
                                    if (h == 0) {
                                        if (next.m()) {
                                            d31.b(arrayList2, next.c);
                                        }
                                        if (next.k()) {
                                            d31.b(arrayList, next.c);
                                        }
                                    } else if (next.m()) {
                                        i |= h;
                                    }
                                }
                                jSONObject4.put("r", String.valueOf(next.x));
                                if (next.m()) {
                                    jSONArray2.put(jSONObject4);
                                }
                                j2 = j;
                                it = it2;
                            }
                            jSONObject3.put("d", jSONArray2);
                            jSONObject3.put("s", vj1.d());
                            jSONArray.put(new JSONObject());
                            if (!TextUtils.equals(str2, "query")) {
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject5.put("k", "ukey");
                                jSONObject5.put("v", TextUtils.join(",", arrayList));
                                jSONArray.put(jSONObject5);
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("k", "xz_ukey");
                                jSONObject6.put("v", TextUtils.join(",", arrayList2));
                                jSONArray.put(jSONObject6);
                                if (arrayList2.isEmpty()) {
                                    if (i == 0) {
                                        i = 1;
                                    }
                                    String valueOf = String.valueOf(i);
                                    BaseVM.d = valueOf;
                                    qj1Var = this;
                                    qj1Var.n(j, valueOf);
                                } else {
                                    qj1Var = this;
                                    BaseVM.d = "";
                                }
                            } else {
                                qj1Var = this;
                            }
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put("k", "logid");
                            jSONObject7.put("v", String.valueOf(j));
                            jSONArray.put(jSONObject7);
                            JSONObject jSONObject8 = new JSONObject();
                            jSONObject8.put("k", "uid");
                            jSONObject8.put("v", sj0.a().t());
                            jSONArray.put(jSONObject8);
                            JSONObject jSONObject9 = new JSONObject();
                            jSONObject9.put("k", MigrateStatisticUtils.EXT_INFO);
                            JSONObject jSONObject10 = new JSONObject();
                            jSONObject10.put("ipdx", jo0.a().a());
                            jSONObject10.put("update_mark", NADNativeHelper.b());
                            jSONObject10.put("boot_mark", NADNativeHelper.a());
                            qj1Var.a(jSONObject10);
                            if (Build.VERSION.SDK_INT >= 19) {
                                defaultUserAgent = uj0.c().a();
                            } else if (lj1.b() == 0) {
                                defaultUserAgent = q31.a().b("splash_sp_name").getString("web_view_ua", uj0.c().a());
                            } else {
                                defaultUserAgent = WebSettings.getDefaultUserAgent(sj0.b());
                                if (!TextUtils.isEmpty(defaultUserAgent)) {
                                    q31.a().b("splash_sp_name").h("web_view_ua", defaultUserAgent);
                                }
                            }
                            jSONObject10.put("sys_ua", defaultUserAgent);
                            a2 = k61.b().a();
                            if (!TextUtils.isEmpty(a2)) {
                                jSONObject10.put("custom_ua", a2);
                            }
                            jSONObject10.put("adinfo", jSONObject3);
                            jSONObject9.put("v", jSONObject10.toString());
                            jSONArray.put(jSONObject9);
                            JSONObject jSONObject11 = new JSONObject();
                            jSONObject11.put("k", AdExtParam.KEY_IADEX);
                            jSONObject11.put("v", sj0.d().m());
                            jSONArray.put(jSONObject11);
                            f = kk0.c().f(false);
                            if (!TextUtils.isEmpty(f)) {
                                JSONObject jSONObject12 = new JSONObject();
                                jSONObject12.put("k", "oaid_v");
                                jSONObject12.put("v", f);
                                jSONArray.put(jSONObject12);
                            }
                            JSONObject jSONObject13 = new JSONObject();
                            jSONObject13.put("k", "encoded_ua_new");
                            jSONObject13.put("v", URLEncoder.encode(sj0.e(), "utf-8"));
                            jSONArray.put(jSONObject13);
                            JSONObject jSONObject14 = new JSONObject();
                            jSONObject14.put("k", "boot_type");
                            jSONObject14.put("v", "__boot_type__");
                            jSONArray.put(jSONObject14);
                            JSONObject jSONObject15 = new JSONObject();
                            jSONObject15.put("k", "hot_background_time");
                            jSONObject15.put("v", "__hot_background_time__");
                            jSONArray.put(jSONObject15);
                            JSONObject jSONObject16 = new JSONObject();
                            jSONObject16.put("k", "is_block_shake_gesture");
                            jSONObject16.put("v", "__is_block_shake_gesture__");
                            jSONArray.put(jSONObject16);
                            hashMap.put("ext", jSONArray.toString());
                        }
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                        return;
                    }
                }
                i = 0;
                jSONObject3.put("d", jSONArray2);
                jSONObject3.put("s", vj1.d());
                jSONArray.put(new JSONObject());
                if (!TextUtils.equals(str2, "query")) {
                }
                JSONObject jSONObject72 = new JSONObject();
                jSONObject72.put("k", "logid");
                jSONObject72.put("v", String.valueOf(j));
                jSONArray.put(jSONObject72);
                JSONObject jSONObject82 = new JSONObject();
                jSONObject82.put("k", "uid");
                jSONObject82.put("v", sj0.a().t());
                jSONArray.put(jSONObject82);
                JSONObject jSONObject92 = new JSONObject();
                jSONObject92.put("k", MigrateStatisticUtils.EXT_INFO);
                JSONObject jSONObject102 = new JSONObject();
                jSONObject102.put("ipdx", jo0.a().a());
                jSONObject102.put("update_mark", NADNativeHelper.b());
                jSONObject102.put("boot_mark", NADNativeHelper.a());
                qj1Var.a(jSONObject102);
                if (Build.VERSION.SDK_INT >= 19) {
                }
                jSONObject102.put("sys_ua", defaultUserAgent);
                a2 = k61.b().a();
                if (!TextUtils.isEmpty(a2)) {
                }
                jSONObject102.put("adinfo", jSONObject3);
                jSONObject92.put("v", jSONObject102.toString());
                jSONArray.put(jSONObject92);
                JSONObject jSONObject112 = new JSONObject();
                jSONObject112.put("k", AdExtParam.KEY_IADEX);
                jSONObject112.put("v", sj0.d().m());
                jSONArray.put(jSONObject112);
                f = kk0.c().f(false);
                if (!TextUtils.isEmpty(f)) {
                }
                JSONObject jSONObject132 = new JSONObject();
                jSONObject132.put("k", "encoded_ua_new");
                jSONObject132.put("v", URLEncoder.encode(sj0.e(), "utf-8"));
                jSONArray.put(jSONObject132);
                JSONObject jSONObject142 = new JSONObject();
                jSONObject142.put("k", "boot_type");
                jSONObject142.put("v", "__boot_type__");
                jSONArray.put(jSONObject142);
                JSONObject jSONObject152 = new JSONObject();
                jSONObject152.put("k", "hot_background_time");
                jSONObject152.put("v", "__hot_background_time__");
                jSONArray.put(jSONObject152);
                JSONObject jSONObject162 = new JSONObject();
                jSONObject162.put("k", "is_block_shake_gesture");
                jSONObject162.put("v", "__is_block_shake_gesture__");
                jSONArray.put(jSONObject162);
                hashMap.put("ext", jSONArray.toString());
            } catch (JSONException e2) {
                e = e2;
            }
        }
    }

    public final String d(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        String query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, map)) == null) {
            if (map != null && map.size() != 0) {
                URI create = URI.create(str);
                if (TextUtils.isEmpty(create.getQuery())) {
                    query = "";
                } else {
                    query = create.getQuery();
                }
                StringBuilder sb = new StringBuilder(query);
                if (sb.length() > 0) {
                    sb.append('&');
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append('&');
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                try {
                    return new URI(create.getScheme(), create.getAuthority(), create.getPath(), sb.toString(), create.getFragment()).toString();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public String f(String str, long j) {
        InterceptResult invokeLJ;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, str, j)) == null) {
            String a2 = bj1.a();
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            if (TextUtils.equals(str, StickerDataChangeType.UPDATE)) {
                str2 = "?action=update";
            } else {
                str2 = "?action=query";
            }
            sb.append(str2);
            String sb2 = sb.toString();
            String i = i(str);
            HashMap<String, String> hashMap = new HashMap<>();
            if (TextUtils.equals(str, StickerDataChangeType.UPDATE)) {
                str3 = String.valueOf(sj1.o());
            } else {
                str3 = "1";
            }
            hashMap.put("ac", str3);
            hashMap.put("pid", i);
            hashMap.put("product_id ", sj0.a().s());
            b(hashMap);
            c(hashMap, i, str, j);
            return d(sb2, hashMap);
        }
        return (String) invokeLJ.objValue;
    }

    public final String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.equals(str, StickerDataChangeType.UPDATE)) {
                String optString = fj1.a().d().optString("na_cpc_update_pid");
                if (TextUtils.isEmpty(optString)) {
                    return fj1.a().e();
                }
                return optString;
            }
            return sj1.l();
        }
        return (String) invokeL.objValue;
    }

    public String k(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (TextUtils.equals(str, "query")) {
                str2 = l(str);
                Log.d("RequestUrlManager", " getQueryUrl from cache url ： " + str2);
            } else {
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = e(str);
                Log.d("RequestUrlManager", " getQueryUrl NOCache url ： " + str2);
            }
            String replace = str2.replace("__boot_type__", String.valueOf(lj1.b())).replace("__hot_background_time__", String.valueOf((System.currentTimeMillis() - lj1.a()) / 1000));
            if (sj1.N()) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            return replace.replace("__is_block_shake_gesture__", str3);
        }
        return (String) invokeL.objValue;
    }

    public String l(String str) {
        InterceptResult invokeL;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            String string = q31.a().b("splash_sp_name").getString("splash_query_cache_url", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                long optLong = jSONObject.optLong("cache_time");
                int a2 = l61.a(optLong, System.currentTimeMillis());
                if (a2 >= 2) {
                    optString = jSONObject.optString("after_tomorrow_url");
                } else if (a2 == 1) {
                    optString = jSONObject.optString("tomorrow_url");
                } else {
                    optString = jSONObject.optString(AbsMsgImageActivityConfig.CURRENT_URL);
                }
                String str2 = optString;
                if (!TextUtils.isEmpty(str2)) {
                    BaseVM.d = j(optLong);
                    if (bh0.a) {
                        return str2 + "&cache_time=" + (optLong / 1000);
                    }
                    return str2;
                }
                return str2;
            } catch (JSONException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public final void n(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048588, this, j, str) == null) {
            int a2 = l61.a(System.currentTimeMillis(), j);
            if (a2 >= 2) {
                q31.a().b("splash_sp_name").h("after_tomorrow_reason", str);
            } else if (a2 == 1) {
                q31.a().b("splash_sp_name").h("tomorrow_reason", str);
            } else {
                q31.a().b("splash_sp_name").h("current_reason", str);
            }
        }
    }
}
