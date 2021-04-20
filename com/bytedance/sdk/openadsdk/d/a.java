package com.bytedance.sdk.openadsdk.d;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.preload.geckox.a.a.a;
import com.bytedance.sdk.openadsdk.preload.geckox.b;
import com.bytedance.sdk.openadsdk.preload.geckox.h.b;
import com.bytedance.sdk.openadsdk.preload.geckox.model.CheckRequestBodyModel;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f28758a = {"gecko-pangle-lf.snssdk.com", "gecko-pangle-hl.snssdk.com", "gecko-pangle-lq.snssdk.com"};

    /* renamed from: b  reason: collision with root package name */
    public File f28759b;

    /* renamed from: c  reason: collision with root package name */
    public Map.Entry<String, JSONObject> f28760c;

    /* renamed from: com.bytedance.sdk.openadsdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0319a {

        /* renamed from: a  reason: collision with root package name */
        public static a f28763a = new a();
    }

    public static a a() {
        return C0319a.f28763a;
    }

    private String c() {
        String[] G = p.h().G();
        StringBuilder sb = new StringBuilder();
        sb.append("GeckoLog:get gecko hosts from settings ");
        sb.append(G == null ? 0 : G.length);
        u.b("GeckoHub", sb.toString());
        if (G == null) {
            G = f28758a;
        }
        String str = G[new Random().nextInt(G.length)];
        if (TextUtils.isEmpty(str)) {
            str = f28758a[new Random().nextInt(f28758a.length)];
        }
        u.b("GeckoHub", "GeckoLog:random host " + str);
        return str;
    }

    public com.bytedance.sdk.openadsdk.preload.falconx.a.a b() {
        try {
            return new com.bytedance.sdk.openadsdk.preload.falconx.a.a(p.a(), "4ab312f7094810afa84659d3dc6cf0fe", this.f28759b);
        } catch (Throwable th) {
            u.c("GeckoHub", "getGeckoResLoader error", th);
            return null;
        }
    }

    public a() {
        this.f28759b = new File(p.a().getCacheDir() + File.separator + "gecko");
        if (i.d().w()) {
            b.a();
        }
    }

    public void a(final Map<String, l> map) {
        String a2 = k.a(p.a());
        if (TextUtils.isEmpty(a2)) {
            u.b("GeckoHub", "no did so don't preload");
            return;
        }
        com.bytedance.sdk.openadsdk.preload.geckox.a a3 = com.bytedance.sdk.openadsdk.preload.geckox.a.a(new b.a(p.a()).b("4ab312f7094810afa84659d3dc6cf0fe").a("4ab312f7094810afa84659d3dc6cf0fe").a(Long.parseLong("1371")).b(a2).a("9999999.0.0").a(new a.C0336a().a(20).a(com.bytedance.sdk.openadsdk.preload.geckox.a.a.b.f29890c).a()).a(this.f28759b).a(false).c(c()).b(e.a()).a(e.a()).a(new com.bytedance.sdk.openadsdk.preload.geckox.statistic.a() { // from class: com.bytedance.sdk.openadsdk.d.a.1
            @Override // com.bytedance.sdk.openadsdk.preload.geckox.statistic.a
            public void a(String str, JSONObject jSONObject) {
                if ("geckosdk_update_stats".equals(str)) {
                    l lVar = (l) map.get(jSONObject.optString("channel"));
                    if (lVar != null) {
                        d.a.a(str, jSONObject, lVar);
                    }
                }
            }
        }).a());
        HashMap hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        for (String str : map.keySet()) {
            linkedList.add(new CheckRequestBodyModel.TargetChannel(str));
        }
        hashMap.put("4ab312f7094810afa84659d3dc6cf0fe", linkedList);
        a3.a(hashMap);
    }

    private InputStream b(com.bytedance.sdk.openadsdk.preload.falconx.a.a aVar, String str, String str2) throws Exception {
        String str3 = str + File.separator + str2;
        if (aVar.b(str3)) {
            return aVar.a(str3);
        }
        return null;
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("?");
        return indexOf == -1 ? str : str.substring(0, indexOf);
    }

    private JSONObject a(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                if (this.f28760c == null || !str.equals(this.f28760c.getKey())) {
                    u.b("GeckoHub", "refresh cache manifest");
                    com.bytedance.sdk.openadsdk.preload.falconx.a.a aVar = new com.bytedance.sdk.openadsdk.preload.falconx.a.a(p.a(), "4ab312f7094810afa84659d3dc6cf0fe", this.f28759b);
                    String a2 = com.bytedance.sdk.openadsdk.k.g.a.a(aVar.a(str + "/manifest.json"));
                    if (TextUtils.isEmpty(a2)) {
                        u.f("GeckoHub", "getFileInfoInManifest error null");
                        return null;
                    }
                    this.f28760c = new AbstractMap.SimpleEntry(str, new JSONObject(a2));
                }
                JSONObject value = this.f28760c.getValue();
                String a3 = j.a(str2);
                if (value.has(a3)) {
                    return value.getJSONObject(a3);
                }
                String a4 = a(str2);
                if (a4 == null) {
                    return null;
                }
                String a5 = j.a(a4);
                if (value.has(a5)) {
                    return value.getJSONObject(a5);
                }
                return null;
            } catch (Throwable th) {
                u.c("GeckoHub", "getFileInfoInManifest error", th);
            }
        }
        return null;
    }

    public void a(com.bytedance.sdk.openadsdk.preload.falconx.a.a aVar) {
        if (aVar != null) {
            try {
                aVar.a();
            } catch (Throwable th) {
                u.c("GeckoHub", "releaseGeckoResLoader error", th);
            }
        }
    }

    public WebResourceResponse a(com.bytedance.sdk.openadsdk.preload.falconx.a.a aVar, String str, String str2) {
        String optString;
        InputStream b2;
        if (aVar == null) {
            return null;
        }
        try {
            JSONObject a2 = a(str, str2);
            if (a2 == null || (optString = a2.optString("fileName", null)) == null) {
                return null;
            }
            JSONObject jSONObject = a2.has("respHeader") ? a2.getJSONObject("respHeader") : null;
            if (jSONObject == null || (b2 = b(aVar, str, optString)) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return com.bytedance.sdk.openadsdk.preload.falconx.b.a.a(b2, hashMap);
        } catch (Throwable th) {
            u.c("GeckoHub", "findRes error", th);
            return null;
        }
    }
}
