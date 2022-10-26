package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.nad.jni.NADNativeHelper;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.qq.e.comm.constants.Constants;
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
/* loaded from: classes5.dex */
public class qd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public rd1 b;
    public int c;
    public volatile boolean d;

    /* loaded from: classes5.dex */
    public class a extends mq0 {
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

        public a(qd1 qd1Var, String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qd1Var, str, Long.valueOf(j), Long.valueOf(j2)};
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

        @Override // com.baidu.tieba.kq0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                BaseVM.n(this.a, this.b, this.c, exc.getMessage(), "update");
            }
        }

        @Override // com.baidu.tieba.lq0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lq0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                BaseVM.n(this.a, this.b, this.c, BasicPushStatus.SUCCESS_CODE, "update");
                try {
                    vd1.d(str, this.a);
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends mq0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ rd1 d;
        public final /* synthetic */ qd1 e;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public b(qd1 qd1Var, String str, long j, long j2, rd1 rd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qd1Var, str, Long.valueOf(j), Long.valueOf(j2), rd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qd1Var;
            this.a = str;
            this.b = j;
            this.c = j2;
            this.d = rd1Var;
        }

        @Override // com.baidu.tieba.kq0
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

        @Override // com.baidu.tieba.lq0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lq0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                BaseVM.o(this.a, this.b, this.c, BasicPushStatus.SUCCESS_CODE, "query", this.e.d, str);
                if (!this.e.d) {
                    this.e.a.removeCallbacksAndMessages(null);
                    try {
                        List d = vd1.d(str, this.a);
                        if (d != null && d.size() > 0 && d.get(0) != null) {
                            this.d.b((ce1) d.get(0));
                        } else if (vd1.a(str)) {
                            this.d.a(new Throwable("no ad"));
                        } else {
                            new c(this.e, this.a).run();
                        }
                    } catch (ParseError e) {
                        e.printStackTrace();
                        this.d.a(e);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qd1 a;

        public c(qd1 qd1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qd1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qd1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.d = true;
            ce1 o = ae1.o();
            if (this.a.b == null) {
                return;
            }
            if (o != null) {
                o.D = 2;
                this.a.b.b(o);
                return;
            }
            this.a.b.a(new Throwable("no ad"));
        }
    }

    public qd1() {
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
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || od1.a().d() == null || !od1.a().d().has("client_ext") || (optJSONObject = od1.a().d().optJSONObject("client_ext")) == null) {
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

    public final void f(HashMap hashMap) {
        String n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            ij0 a2 = aj0.a();
            if (TextUtils.isEmpty(a2.n())) {
                n = a2.u();
            } else {
                n = a2.n();
            }
            hashMap.put("ver", n);
            hashMap.put("sv", "1.0");
            hashMap.put("uid", a2.r());
            hashMap.put(TiebaStatic.Params.BDID, a2.m());
            hashMap.put("cuid", a2.g());
            String e = qj0.c().e(false);
            if (!TextUtils.isEmpty(e)) {
                hashMap.put(SearchJsBridge.COOKIE_MOD, e);
            }
            String h = qj0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                hashMap.put("ov", h);
            }
            String b2 = qj0.c().b(false);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("imei", b2);
            }
            hashMap.put("ua", a2.o());
            hashMap.put("fmt", "json");
            hashMap.put("apna", a2.packageName());
            hashMap.put("eid", a2.h());
            hashMap.put("st", "1");
            hashMap.put("ot", "2");
            hashMap.put("nt", String.valueOf(new iq0().c()));
            hashMap.put(Config.EXCEPTION_CRASH_TYPE, "2");
            hashMap.put("is_https", "1");
            String a3 = qj0.c().a(false);
            if (!TextUtils.isEmpty(a3)) {
                hashMap.put(HttpRequest.ANDROID_ID, a3);
            }
            hashMap.put("from", od1.a().from());
            hashMap.put("cfrom", od1.a().a());
            hashMap.put("User-Agent", aj0.e());
        }
    }

    public final void g(HashMap hashMap, String str, String str2, long j) {
        int i;
        Iterator it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{hashMap, str, str2, Long.valueOf(j)}) == null) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                new JSONObject();
                if (x8.f().h()) {
                    jSONObject.put("k", "cmd");
                    jSONObject.put("v", str2);
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("k", AdExtParam.KEY_NAD_CORE_VERSION);
                jSONObject2.put("v", "5.8.0.17");
                jSONArray.put(jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                List t = ae1.t();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray2 = new JSONArray();
                TextUtils.equals(str, od1.a().e());
                if (t != null && t.size() > 0) {
                    Iterator it2 = t.iterator();
                    i = 0;
                    while (it2.hasNext()) {
                        ce1 ce1Var = (ce1) it2.next();
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("k", ce1Var.c);
                        if (!TextUtils.isEmpty(ce1Var.c)) {
                            int e = ae1.e(ce1Var);
                            StringBuilder sb = new StringBuilder();
                            it = it2;
                            sb.append("onAdSuccess: ");
                            sb.append(e);
                            Log.e("Afd", sb.toString());
                            if (e == 0) {
                                if (ce1Var.h()) {
                                    xz0.b(arrayList2, ce1Var.c);
                                }
                                if (ce1Var.f()) {
                                    xz0.b(arrayList, ce1Var.c);
                                }
                            } else if (ce1Var.h()) {
                                i |= e;
                            }
                        } else {
                            it = it2;
                        }
                        jSONObject4.put("r", String.valueOf(ce1Var.x));
                        if (ce1Var.h()) {
                            jSONArray2.put(jSONObject4);
                        }
                        it2 = it;
                    }
                } else {
                    i = 0;
                }
                jSONObject3.put("d", jSONArray2);
                jSONObject3.put("s", ee1.d());
                jSONArray.put(new JSONObject());
                if (TextUtils.equals(str2, "query")) {
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
                        BaseVM.d = String.valueOf(i);
                    } else {
                        BaseVM.d = "";
                    }
                }
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("k", "logid");
                jSONObject7.put("v", String.valueOf(j));
                jSONArray.put(jSONObject7);
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("k", "uid");
                jSONObject8.put("v", aj0.a().r());
                jSONArray.put(jSONObject8);
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("k", "ext_info");
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("ipdx", hn0.a().a());
                jSONObject10.put("update_mark", NADNativeHelper.b());
                jSONObject10.put("boot_mark", NADNativeHelper.a());
                try {
                    e(jSONObject10);
                    jSONObject10.put(Constants.KEYS.AD_INFO, jSONObject3);
                    jSONObject9.put("v", jSONObject10.toString());
                    jSONArray.put(jSONObject9);
                    JSONObject jSONObject11 = new JSONObject();
                    jSONObject11.put("k", AdExtParam.KEY_IADEX);
                    jSONObject11.put("v", aj0.d().l());
                    jSONArray.put(jSONObject11);
                    String f = qj0.c().f(false);
                    if (!TextUtils.isEmpty(f)) {
                        JSONObject jSONObject12 = new JSONObject();
                        jSONObject12.put("k", "oaid_v");
                        jSONObject12.put("v", f);
                        jSONArray.put(jSONObject12);
                    }
                    try {
                        JSONObject jSONObject13 = new JSONObject();
                        jSONObject13.put("k", "encoded_ua_new");
                        jSONObject13.put("v", URLEncoder.encode(aj0.e(), IMAudioTransRequest.CHARSET));
                        jSONArray.put(jSONObject13);
                    } catch (UnsupportedEncodingException unused) {
                    }
                    hashMap.put("ext", jSONArray.toString());
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (JSONException e3) {
                e = e3;
            }
        }
    }

    public final String h(String str, Map map) {
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
                for (Map.Entry entry : map.entrySet()) {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
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

    public final tq0 i(String str, String str2, long j) {
        InterceptResult invokeCommon;
        String str3;
        String str4;
        String h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            if (TextUtils.equals("query", str) && be1.t()) {
                h = zd1.m().k(str);
            } else {
                String a2 = kd1.a();
                if (TextUtils.equals(str, "query") && be1.K() && od1.a().d() != null && !TextUtils.isEmpty(od1.a().d().optString("host_url"))) {
                    a2 = od1.a().d().optString("host_url");
                }
                StringBuilder sb = new StringBuilder();
                sb.append(a2);
                if (TextUtils.equals(str, "update")) {
                    str3 = "?action=update";
                } else {
                    str3 = "?action=query";
                }
                sb.append(str3);
                String sb2 = sb.toString();
                HashMap hashMap = new HashMap();
                if (TextUtils.equals(str, "update")) {
                    str4 = String.valueOf(be1.o());
                } else {
                    str4 = "1";
                }
                hashMap.put("ac", str4);
                hashMap.put("pid", str2);
                hashMap.put("product_id ", aj0.a().q());
                f(hashMap);
                g(hashMap, str2, str, j);
                h = h(sb2, hashMap);
            }
            tq0 tq0Var = new tq0();
            tq0Var.k(h);
            tq0Var.a("User-Agent", aj0.e());
            tq0Var.c();
            return tq0Var;
        }
        return (tq0) invokeCommon.objValue;
    }

    public void j(String str, rd1 rd1Var) {
        Handler handler;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, rd1Var) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            wd1.a(String.valueOf(currentTimeMillis));
            tq0 i = i("query", str, currentTimeMillis);
            i.f = this.c;
            JSONObject d = od1.a().d();
            if (d != null && d.has("query_response_thread")) {
                if (d.optInt("query_response_thread", 0) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                i.h(z);
            }
            aq0.b().a().a(i, new b(this, str, currentTimeMillis, System.currentTimeMillis(), rd1Var));
            this.b = rd1Var;
            this.d = false;
            int f = od1.a().f() - be1.m();
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
            String optString = od1.a().d().optString("na_cpc_update_pid");
            if (TextUtils.isEmpty(optString)) {
                optString = od1.a().e();
            }
            String str = optString;
            aq0.b().a().a(i("update", str, currentTimeMillis), new a(this, str, currentTimeMillis, System.currentTimeMillis()));
        }
    }
}
