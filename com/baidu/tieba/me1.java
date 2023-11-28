package com.baidu.tieba;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.nad.jni.NADNativeHelper;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.io.UnsupportedEncodingException;
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
public class me1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public ne1 b;
    public int c;
    public volatile boolean d;

    /* loaded from: classes7.dex */
    public class a extends bp0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(me1 me1Var, String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me1Var, str, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = j;
            this.c = j2;
        }

        @Override // com.baidu.tieba.zo0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                BaseVM.n(this.a, this.b, this.c, exc.getMessage(), StickerDataChangeType.UPDATE);
            }
        }

        @Override // com.baidu.tieba.ap0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ap0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                BaseVM.n(this.a, this.b, this.c, BasicPushStatus.SUCCESS_CODE, StickerDataChangeType.UPDATE);
                try {
                    re1.e(str, this.a);
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends bp0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ ne1 d;
        public final /* synthetic */ me1 e;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public b(me1 me1Var, String str, long j, long j2, ne1 ne1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me1Var, str, Long.valueOf(j), Long.valueOf(j2), ne1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = me1Var;
            this.a = str;
            this.b = j;
            this.c = j2;
            this.d = ne1Var;
        }

        @Override // com.baidu.tieba.zo0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                BaseVM.o(this.a, this.b, this.c, exc.getMessage(), "query", this.e.d, "");
                if (!this.e.d && this.e.a != null) {
                    this.e.a.removeCallbacksAndMessages(null);
                    this.e.a.post(new c(this.e, this.a));
                }
            }
        }

        @Override // com.baidu.tieba.ap0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ap0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                BaseVM.o(this.a, this.b, this.c, BasicPushStatus.SUCCESS_CODE, "query", this.e.d, str);
                if (!this.e.d) {
                    this.e.a.removeCallbacksAndMessages(null);
                    try {
                        List<ye1> e = re1.e(str, this.a);
                        if (e != null && e.size() > 0 && e.get(0) != null) {
                            this.d.b(e.get(0));
                        } else if (re1.a(str)) {
                            this.d.a(new Throwable("no ad"));
                        } else {
                            new c(this.e, this.a).run();
                        }
                    } catch (ParseError e2) {
                        e2.printStackTrace();
                        this.d.a(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ me1 a;

        public c(me1 me1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = me1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.d = true;
            ye1 n = we1.n(qe1.b());
            if (this.a.b == null) {
                return;
            }
            if (n != null) {
                n.D = 2;
                this.a.b.b(n);
                return;
            }
            this.a.b.a(new Throwable("no ad"));
        }
    }

    public me1() {
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
        this.a = new Handler(Looper.getMainLooper());
        this.c = 5000;
        this.d = false;
    }

    public final void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || ke1.a().d() == null || !ke1.a().d().has("client_ext") || (optJSONObject = ke1.a().d().optJSONObject("client_ext")) == null) {
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

    public final void f(HashMap<String, String> hashMap) {
        String q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            pf0 a2 = hf0.a();
            if (TextUtils.isEmpty(a2.q())) {
                q = a2.x();
            } else {
                q = a2.q();
            }
            hashMap.put("ver", q);
            hashMap.put("sv", "1.0");
            hashMap.put("uid", a2.u());
            hashMap.put(TiebaStatic.Params.BDID, a2.p());
            hashMap.put("cuid", a2.g());
            String e = zf0.c().e(false);
            if (!TextUtils.isEmpty(e)) {
                hashMap.put(SearchJsBridge.COOKIE_MOD, e);
            }
            String h = zf0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                hashMap.put("ov", h);
            }
            String b2 = zf0.c().b(false);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("imei", b2);
            }
            hashMap.put("ua", a2.r());
            hashMap.put("fmt", "json");
            hashMap.put("apna", a2.k());
            hashMap.put("eid", a2.i());
            hashMap.put("st", "1");
            hashMap.put("ot", "2");
            hashMap.put("nt", String.valueOf(new xo0().c()));
            hashMap.put(Config.EXCEPTION_CRASH_TYPE, "2");
            hashMap.put("is_https", "1");
            String a3 = zf0.c().a(false);
            if (!TextUtils.isEmpty(a3)) {
                hashMap.put(HttpRequest.ANDROID_ID, a3);
            }
            hashMap.put("from", ke1.a().from());
            hashMap.put("cfrom", ke1.a().a());
            hashMap.put("User-Agent", hf0.e());
        }
    }

    public final void g(@NonNull HashMap<String, String> hashMap, String str, String str2, long j) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        int i;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String defaultUserAgent;
        int i2;
        Iterator<ye1> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{hashMap, str, str2, Long.valueOf(j)}) == null) {
            try {
                jSONArray = new JSONArray();
                JSONObject jSONObject4 = new JSONObject();
                new JSONObject();
                if (e4.f().h()) {
                    jSONObject4.put("k", "cmd");
                    jSONObject4.put("v", str2);
                    jSONArray.put(jSONObject4);
                }
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("k", AdExtParam.KEY_NAD_CORE_VERSION);
                jSONObject5.put("v", "5.12.0.110");
                jSONArray.put(jSONObject5);
                jSONObject = new JSONObject();
                List<ye1> s = we1.s();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray2 = new JSONArray();
                TextUtils.equals(str, ke1.a().e());
                if (s != null && s.size() > 0) {
                    Iterator<ye1> it2 = s.iterator();
                    i = 0;
                    while (it2.hasNext()) {
                        ye1 next = it2.next();
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("k", next.c);
                        if (!TextUtils.isEmpty(next.c)) {
                            int f = we1.f(next, qe1.b());
                            StringBuilder sb = new StringBuilder();
                            it = it2;
                            sb.append("onAdSuccess: ");
                            sb.append(f);
                            Log.e("Afd", sb.toString());
                            if (f == 0) {
                                if (next.m()) {
                                    ly0.b(arrayList2, next.c);
                                }
                                if (next.k()) {
                                    ly0.b(arrayList, next.c);
                                }
                            } else if (next.m()) {
                                i |= f;
                            }
                        } else {
                            it = it2;
                        }
                        jSONObject6.put("r", String.valueOf(next.x));
                        if (next.m()) {
                            jSONArray2.put(jSONObject6);
                        }
                        it2 = it;
                    }
                } else {
                    i = 0;
                }
                jSONObject.put("d", jSONArray2);
                jSONObject.put("s", af1.d());
                jSONArray.put(new JSONObject());
                if (TextUtils.equals(str2, "query")) {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("k", "ukey");
                    jSONObject7.put("v", TextUtils.join(",", arrayList));
                    jSONArray.put(jSONObject7);
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("k", "xz_ukey");
                    jSONObject8.put("v", TextUtils.join(",", arrayList2));
                    jSONArray.put(jSONObject8);
                    if (arrayList2.isEmpty()) {
                        if (i == 0) {
                            i = 1;
                        }
                        BaseVM.d = String.valueOf(i);
                    } else {
                        BaseVM.d = "";
                    }
                }
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("k", "logid");
                jSONObject9.put("v", String.valueOf(j));
                jSONArray.put(jSONObject9);
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("k", "uid");
                jSONObject10.put("v", hf0.a().u());
                jSONArray.put(jSONObject10);
                jSONObject2 = new JSONObject();
                jSONObject2.put("k", MigrateStatisticUtils.EXT_INFO);
                jSONObject3 = new JSONObject();
                jSONObject3.put("ipdx", yj0.a().a());
                jSONObject3.put("update_mark", NADNativeHelper.b());
                jSONObject3.put("boot_mark", NADNativeHelper.a());
            } catch (JSONException e) {
                e = e;
            }
            try {
                e(jSONObject3);
                jSONObject3.put("adinfo", jSONObject);
                if (Build.VERSION.SDK_INT < 19) {
                    defaultUserAgent = jf0.c().a();
                } else if (qe1.b() == 0) {
                    defaultUserAgent = yy0.a().b("splash_sp_name").getString("web_view_ua", jf0.c().a());
                } else {
                    defaultUserAgent = WebSettings.getDefaultUserAgent(hf0.b());
                    if (!TextUtils.isEmpty(defaultUserAgent)) {
                        yy0.a().b("splash_sp_name").h("web_view_ua", defaultUserAgent);
                    }
                }
                jSONObject3.put("sys_ua", defaultUserAgent);
                String a2 = s11.b().a();
                if (!TextUtils.isEmpty(a2)) {
                    jSONObject3.put("custom_ua", a2);
                }
                jSONObject2.put("v", jSONObject3.toString());
                jSONArray.put(jSONObject2);
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("k", AdExtParam.KEY_IADEX);
                jSONObject11.put("v", hf0.d().n());
                jSONArray.put(jSONObject11);
                String f2 = zf0.c().f(false);
                if (!TextUtils.isEmpty(f2)) {
                    JSONObject jSONObject12 = new JSONObject();
                    jSONObject12.put("k", "oaid_v");
                    jSONObject12.put("v", f2);
                    jSONArray.put(jSONObject12);
                }
                try {
                    JSONObject jSONObject13 = new JSONObject();
                    jSONObject13.put("k", "encoded_ua_new");
                    jSONObject13.put("v", URLEncoder.encode(hf0.e(), "utf-8"));
                    jSONArray.put(jSONObject13);
                } catch (UnsupportedEncodingException unused) {
                }
                JSONObject jSONObject14 = new JSONObject();
                jSONObject14.put("k", "boot_type");
                jSONObject14.put("v", qe1.b());
                jSONArray.put(jSONObject14);
                JSONObject jSONObject15 = new JSONObject();
                jSONObject15.put("k", "hot_background_time");
                jSONObject15.put("v", ((int) (System.currentTimeMillis() - qe1.a())) / 1000);
                jSONArray.put(jSONObject15);
                JSONObject jSONObject16 = new JSONObject();
                jSONObject16.put("k", "is_block_shake_gesture");
                if (xe1.N()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject16.put("v", i2);
                jSONArray.put(jSONObject16);
                hashMap.put("ext", jSONArray.toString());
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
            }
        }
    }

    public final String h(String str, Map<String, String> map) {
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

    public final ip0 i(String str, String str2, long j) {
        InterceptResult invokeCommon;
        String str3;
        String str4;
        String h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            if (TextUtils.equals("query", str) && xe1.v() && qe1.b() == 0) {
                h = ve1.m().k(str);
            } else {
                String a2 = ge1.a();
                if (TextUtils.equals(str, "query") && xe1.O() && ke1.a().d() != null && !TextUtils.isEmpty(ke1.a().d().optString("host_url"))) {
                    a2 = ke1.a().d().optString("host_url");
                }
                StringBuilder sb = new StringBuilder();
                sb.append(a2);
                if (TextUtils.equals(str, StickerDataChangeType.UPDATE)) {
                    str3 = "?action=update";
                } else {
                    str3 = "?action=query";
                }
                sb.append(str3);
                String sb2 = sb.toString();
                HashMap<String, String> hashMap = new HashMap<>();
                if (TextUtils.equals(str, StickerDataChangeType.UPDATE)) {
                    str4 = String.valueOf(xe1.o());
                } else {
                    str4 = "1";
                }
                hashMap.put("ac", str4);
                hashMap.put("pid", str2);
                hashMap.put("product_id ", hf0.a().t());
                f(hashMap);
                g(hashMap, str2, str, j);
                h = h(sb2, hashMap);
            }
            ip0 ip0Var = new ip0();
            ip0Var.l(h);
            ip0Var.a("User-Agent", hf0.e());
            ip0Var.c();
            return ip0Var;
        }
        return (ip0) invokeCommon.objValue;
    }

    public void j(String str, ne1 ne1Var) {
        Handler handler;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, ne1Var) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            se1.a(String.valueOf(currentTimeMillis));
            ip0 i = i("query", str, currentTimeMillis);
            i.g(this.c);
            JSONObject d = ke1.a().d();
            if (d != null && d.has("query_response_thread")) {
                if (d.optInt("query_response_thread", 0) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                i.i(z);
            }
            po0.b().a().a(i, new b(this, str, currentTimeMillis, System.currentTimeMillis(), ne1Var));
            this.b = ne1Var;
            this.d = false;
            int f = ke1.a().f() - xe1.m();
            this.c = f;
            if (f > 0 && (handler = this.a) != null) {
                handler.postDelayed(new c(this, str), this.c);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String optString = ke1.a().d().optString("na_cpc_update_pid");
            if (TextUtils.isEmpty(optString)) {
                optString = ke1.a().e();
            }
            String str = optString;
            po0.b().a().a(i(StickerDataChangeType.UPDATE, str, currentTimeMillis), new a(this, str, currentTimeMillis, System.currentTimeMillis()));
        }
    }
}
