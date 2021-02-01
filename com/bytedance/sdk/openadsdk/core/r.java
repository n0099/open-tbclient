package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidubce.AbstractBceClient;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.kwai.video.player.KsMediaMeta;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.xiaomi.mipush.sdk.Constants;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.stat.VideoPlayerStatistic;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r implements q<com.bytedance.sdk.openadsdk.c.a> {
    private static boolean g = true;

    /* renamed from: a  reason: collision with root package name */
    private final Context f6665a;
    private long e;
    private int f;
    private final ai d = new ai();

    /* renamed from: b  reason: collision with root package name */
    private final boolean f6666b = g();
    private final String c = j();

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Context context) {
        this.f6665a = context;
    }

    private JSONObject a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.d.m mVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            String b2 = (mVar == null || TextUtils.isEmpty(mVar.f6515a)) ? aj.b() : mVar.f6515a;
            if (i == 7) {
                if (mVar != null && mVar.f6516b > 0) {
                    jSONObject2.put("req_type", mVar.f6516b);
                }
            } else if (i == 8 && mVar != null && mVar.c > 0) {
                jSONObject2.put("req_type", mVar.c);
            }
            try {
                String h = p.h().h();
                String i2 = p.h().i();
                String t = i.c().t();
                if (!TextUtils.isEmpty(h) && !TextUtils.isEmpty(i2)) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("version", h);
                    if (adSlot != null) {
                        jSONObject3.put("external_ab_vid", com.bytedance.sdk.openadsdk.j.g.d.a(adSlot.getExternalABVid()));
                        com.bytedance.sdk.openadsdk.utils.u.f("NetApiImpl", "external_ab_vid " + com.bytedance.sdk.openadsdk.j.g.d.a(adSlot.getExternalABVid()));
                    }
                    jSONObject3.put("param", i2);
                    jSONObject3.put("tob_ab_sdk_version", t);
                    jSONObject2.put("abtest", jSONObject3);
                }
            } catch (Throwable th) {
            }
            jSONObject2.put("request_id", b2);
            jSONObject2.put("ad_sdk_version", "3.2.5.1");
            jSONObject2.put("source_type", "app");
            jSONObject2.put("app", b());
            JSONObject d = com.bytedance.sdk.openadsdk.utils.i.d(this.f6665a);
            if (d != null) {
                if (!p.h().x() && !com.bytedance.sdk.openadsdk.downloadnew.a.e.b()) {
                    d.remove("free_space");
                }
                if (adSlot != null && adSlot.getOrientation() > 0) {
                    d.put("orientation", adSlot.getOrientation());
                }
            }
            jSONObject2.put(Config.DEVICE_PART, d);
            jSONObject2.put("user", d());
            jSONObject2.put(com.baidu.fsg.base.statistics.j.c, aj.a());
            jSONObject2.put(TableDefine.UserInfoColumns.COLUMN_IP, e());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(a(adSlot, i, mVar));
            jSONObject2.put("adslots", jSONArray);
            a(jSONObject2, mVar);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject2.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, currentTimeMillis);
            String str = "";
            if (adSlot.getCodeId() != null && b2 != null) {
                str = String.valueOf(currentTimeMillis).concat(adSlot.getCodeId()).concat(b2);
            }
            jSONObject2.put("req_sign", com.bytedance.sdk.openadsdk.utils.j.a(str));
            String k = k();
            String a2 = com.bytedance.sdk.openadsdk.core.a.a(jSONObject2.toString(), e(k));
            String str2 = 2 + k + a2;
            if (b(a2)) {
                jSONObject.put("message", str2);
                jSONObject.put("cypher", 2);
            } else {
                jSONObject.put("message", jSONObject2.toString());
                jSONObject.put("cypher", 0);
            }
            jSONObject.put("ad_sdk_version", "3.2.5.1");
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.d.m mVar) {
        if (mVar != null && mVar.d != null) {
            try {
                jSONObject.put("source_temai_product_ids", mVar.d);
            } catch (Exception e) {
            }
        }
    }

    private boolean a(String str) {
        if (com.bytedance.sdk.openadsdk.core.b.b.a()) {
            return true;
        }
        if (com.bytedance.sdk.openadsdk.core.b.b.a(str)) {
            String b2 = com.bytedance.sdk.openadsdk.core.b.b.b();
            if (TextUtils.isEmpty(b2)) {
                return true;
            }
            com.bytedance.sdk.openadsdk.c.d.a(this.f6665a, b2, System.currentTimeMillis());
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.d.m mVar, final int i, final q.b bVar) {
        if (!com.bytedance.sdk.openadsdk.core.h.j.a()) {
            if (bVar != null) {
                bVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.h.i.a((com.bytedance.sdk.openadsdk.core.h.e) null).c();
        com.bytedance.sdk.openadsdk.core.h.f.a().b();
        com.bytedance.sdk.openadsdk.core.h.b.a().b();
        if (bVar != null) {
            if (a(adSlot.getCodeId())) {
                bVar.a(-8, h.a(-8));
                return;
            }
            final JSONObject a2 = a(adSlot, mVar, i);
            if (a2 == null) {
                bVar.a(-9, h.a(-9));
            } else {
                new com.bytedance.sdk.adnet.b.f(1, aj.q("/api/ad/union/sdk/get_ads/"), a2, new p.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.r.1
                    @Override // com.bytedance.sdk.adnet.core.p.a
                    public void a(com.bytedance.sdk.adnet.core.p<JSONObject> pVar) {
                        boolean z = true;
                        long j = 0;
                        try {
                            j = ((Long) pVar.a("extra_time_start")).longValue();
                        } catch (Throwable th) {
                            z = false;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject e = r.this.e(pVar.f6047a);
                        if (e == null) {
                            r.this.a(bVar);
                            r.this.a(pVar.e, adSlot.getCodeId(), i, null, -1, "mate parse_fail");
                            return;
                        }
                        try {
                            a a3 = a.a(e, adSlot);
                            k.a(r.this.f6665a, a3.i);
                            if (a3.d != 20000) {
                                bVar.a(a3.d, a3.e);
                                r.this.a(pVar.e, adSlot.getCodeId(), i, a3, a3.d, String.valueOf(a3.f));
                            } else if (a3.h == null) {
                                r.this.a(bVar);
                                r.this.a(pVar.e, adSlot.getCodeId(), i, a3, -1, "parse_fail");
                            } else {
                                a3.h.c(e.toString());
                                long currentTimeMillis2 = System.currentTimeMillis();
                                bVar.a(a3.h);
                                Map<String, com.bytedance.sdk.openadsdk.core.d.l> a4 = com.bytedance.sdk.openadsdk.core.d.a.a(a3.h);
                                if (a4 != null) {
                                    com.bytedance.sdk.openadsdk.preload.geckox.c.a().a(a4);
                                }
                                if (z && a3.h.c() != null && !a3.h.c().isEmpty()) {
                                    com.bytedance.sdk.openadsdk.core.d.l lVar = a3.h.c().get(0);
                                    String b2 = aj.b(i);
                                    HashMap hashMap = new HashMap();
                                    if (mVar != null && mVar.f > 0) {
                                        hashMap.put("client_start_time", Long.valueOf(j - mVar.f));
                                        hashMap.put("load_ts", Long.valueOf(mVar.f));
                                        hashMap.put("total_time", Long.valueOf(currentTimeMillis2 - mVar.f));
                                    }
                                    hashMap.put("request_ts", Long.valueOf(j));
                                    hashMap.put("s_revice_ts", Long.valueOf(a3.f6674b));
                                    hashMap.put("s_send_ts", Long.valueOf(a3.c));
                                    hashMap.put("c_revice_ts", Long.valueOf(currentTimeMillis));
                                    hashMap.put("c_end_ts", Long.valueOf(currentTimeMillis2));
                                    hashMap.put("network_time", Long.valueOf(pVar.f));
                                    hashMap.put("go_time", Long.valueOf(a3.f6674b - j));
                                    hashMap.put("sever_time", Integer.valueOf(a3.f6673a));
                                    hashMap.put("back_time", Long.valueOf(currentTimeMillis - a3.c));
                                    hashMap.put("client_end_time", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                                    com.bytedance.sdk.openadsdk.c.d.a(lVar, b2, hashMap);
                                }
                            }
                        } catch (Throwable th2) {
                            com.bytedance.sdk.openadsdk.utils.u.c("NetApiImpl", "get ad error: ", th2);
                            r.this.a(bVar);
                            r.this.a(pVar.e, adSlot.getCodeId(), i, null, -1, "parse_fail");
                        }
                    }

                    @Override // com.bytedance.sdk.adnet.core.p.a
                    public void b(com.bytedance.sdk.adnet.core.p<JSONObject> pVar) {
                        int i2;
                        VAdError vAdError = pVar.pvp;
                        if (vAdError instanceof com.bytedance.sdk.adnet.err.e) {
                            r.this.a(bVar);
                            r.this.a(pVar.e, adSlot.getCodeId(), i, null, -1, h.a(-1));
                            return;
                        }
                        String a3 = h.a(-2);
                        if (vAdError == null || pVar == null) {
                            i2 = -2;
                        } else {
                            i2 = (int) pVar.h;
                            a3 = vAdError.getMessage();
                        }
                        bVar.a(i2, a3);
                        r.this.a(pVar.e, adSlot.getCodeId(), i, null, i2, vAdError instanceof com.bytedance.sdk.adnet.err.g ? "SocketTimeout" : a3);
                    }
                }) { // from class: com.bytedance.sdk.openadsdk.core.r.2
                    @Override // com.bytedance.sdk.adnet.core.Request
                    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                        HashMap hashMap = new HashMap();
                        hashMap.put("ss-sign", s.b(k.a(r.this.f6665a)).d(a2.toString()));
                        return hashMap;
                    }
                }.setRetryPolicy(com.bytedance.sdk.openadsdk.i.e.b().OH(a(i)).OI(0)).setUserAgent(aj.a()).setShouldCache(false).addExtra("extra_time_start", Long.valueOf(System.currentTimeMillis())).build(com.bytedance.sdk.openadsdk.i.e.a(this.f6665a).e());
            }
        }
    }

    private int a(int i) {
        return 10000;
    }

    private boolean b(String str) {
        return !TextUtils.isEmpty(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d A[Catch: Throwable -> 0x00c2, TryCatch #0 {Throwable -> 0x00c2, blocks: (B:15:0x0037, B:17:0x003b, B:19:0x0043, B:21:0x004f, B:25:0x0073, B:28:0x007b, B:30:0x007f, B:31:0x0085, B:33:0x008d, B:34:0x0091, B:36:0x00a9, B:37:0x00ac), top: B:49:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9 A[Catch: Throwable -> 0x00c2, TryCatch #0 {Throwable -> 0x00c2, blocks: (B:15:0x0037, B:17:0x003b, B:19:0x0043, B:21:0x004f, B:25:0x0073, B:28:0x007b, B:30:0x007f, B:31:0x0085, B:33:0x008d, B:34:0x0091, B:36:0x00a9, B:37:0x00ac), top: B:49:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(long j, String str, int i, a aVar, int i2, String str2) {
        String W;
        if (com.bytedance.sdk.openadsdk.core.h.j.a()) {
            if (i == 4 || i == 3) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = h.a(i2);
                }
                com.bytedance.sdk.openadsdk.h.a.c g2 = new com.bytedance.sdk.openadsdk.h.a.c().a(i).b(i2).g(str2);
                com.bytedance.sdk.openadsdk.core.d.l lVar = null;
                String str3 = "";
                if (aVar != null) {
                    try {
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.utils.u.c("NetApiImpl", "uploadAdTypeTimeOutEvent throws exception ", th);
                    }
                    if (aVar.h != null && aVar.h.c() != null && aVar.h.c().size() > 0) {
                        com.bytedance.sdk.openadsdk.core.d.l lVar2 = aVar.h.c().get(0);
                        W = lVar2.W();
                        if (TextUtils.isEmpty(W)) {
                            lVar = lVar2;
                        } else {
                            try {
                                str3 = new JSONObject(W).getString("req_id");
                                lVar = lVar2;
                            } catch (Throwable th2) {
                                lVar = lVar2;
                            }
                        }
                        g2.f((TextUtils.isEmpty(str3) || aVar == null || aVar.h == null) ? str3 : aVar.h.a()).d(lVar == null ? lVar.T() : "").h(W).c(str).a(j).b(aVar == null ? aVar.f6673a : 0L);
                        com.bytedance.sdk.openadsdk.h.a.a().e(g2);
                    }
                }
                W = "";
                g2.f((TextUtils.isEmpty(str3) || aVar == null || aVar.h == null) ? str3 : aVar.h.a()).d(lVar == null ? lVar.T() : "").h(W).c(str).a(j).b(aVar == null ? aVar.f6673a : 0L);
                com.bytedance.sdk.openadsdk.h.a.a().e(g2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    @WorkerThread
    public com.bytedance.sdk.openadsdk.c.h a(List<com.bytedance.sdk.openadsdk.c.a> list) {
        com.bytedance.sdk.adnet.core.p pVar = null;
        boolean z = false;
        if (com.bytedance.sdk.openadsdk.core.h.j.a()) {
            JSONObject jSONObject = new JSONObject();
            try {
                a(list.get(0));
                jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, f());
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.c.a aVar : list) {
                    jSONArray.put(aVar.f6219b);
                }
                jSONObject.put("event", jSONArray);
                jSONObject.put("_gen_time", System.currentTimeMillis());
            } catch (JSONException e) {
            }
            String a2 = com.bytedance.sdk.openadsdk.core.a.a(jSONObject.toString(), com.bytedance.sdk.openadsdk.core.b.b());
            if (!b(a2)) {
                a2 = jSONObject.toString();
            }
            final Map<String, String> d = d(a2);
            com.bytedance.sdk.adnet.b.i eqH = com.bytedance.sdk.adnet.b.i.eqH();
            new com.bytedance.sdk.adnet.b.f(1, aj.g(), a2, eqH) { // from class: com.bytedance.sdk.openadsdk.core.r.3
                @Override // com.bytedance.sdk.adnet.core.Request
                public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                    return d;
                }
            }.setRetryPolicy(com.bytedance.sdk.openadsdk.i.e.b().OH(10000)).setUserAgent(aj.a()).build(com.bytedance.sdk.openadsdk.i.e.a(this.f6665a).d());
            try {
                pVar = eqH.get();
            } catch (Throwable th) {
            }
            boolean z2 = pVar != null && b((JSONObject) pVar.f6047a);
            String str = "error unknown";
            int i = pVar != null ? (int) pVar.h : 0;
            if (!z2 && i == 200) {
                str = "server say not success";
                z = true;
            } else if (pVar != null && pVar.pvp != null) {
                str = pVar.pvp.getMessage();
            }
            c(a2);
            return new com.bytedance.sdk.openadsdk.c.h(z2, i, str, z);
        }
        return null;
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str) && i.c().u()) {
            final Map<String, String> d = d(str);
            new com.bytedance.sdk.adnet.b.f(1, aj.h(), str, com.bytedance.sdk.adnet.b.i.eqH()) { // from class: com.bytedance.sdk.openadsdk.core.r.4
                @Override // com.bytedance.sdk.adnet.core.Request
                public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                    return d;
                }
            }.setRetryPolicy(com.bytedance.sdk.openadsdk.i.e.b().OH(10000)).setUserAgent(aj.a()).build(com.bytedance.sdk.openadsdk.i.e.a(this.f6665a).d());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(@NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, List<FilterWord> list) {
        JSONObject b2;
        if (com.bytedance.sdk.openadsdk.core.h.j.a() && (b2 = b(lVar, list)) != null) {
            new com.bytedance.sdk.adnet.b.h(1, aj.q("/api/ad/union/dislike_event/"), aj.a(b2), null).setRetryPolicy(com.bytedance.sdk.openadsdk.i.e.b().OH(10000)).build(com.bytedance.sdk.openadsdk.i.e.a(this.f6665a).d());
        }
    }

    private JSONObject b(@NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, List<FilterWord> list) {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(this.f6665a);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", "dislike");
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", "3.2.5.1");
            if (a2 != null) {
                jSONObject2.put("latitude", a2.f7566a);
                jSONObject2.put("longitude", a2.f7567b);
            }
            if (lVar != null) {
                jSONObject2.put("extra", lVar.W());
                if (lVar.o() == null) {
                    lVar.b("other");
                }
                jSONObject2.put("dislike_source", lVar.o());
            }
            String b2 = b(list);
            if (b2 != null) {
                jSONObject2.put("comment", b2);
                list.clear();
            } else {
                jSONObject2.put("comment", (Object) null);
            }
            jSONObject2.put("filter_words", c(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private String b(List<FilterWord> list) {
        if (!list.get(0).getId().equals("0:00")) {
            return null;
        }
        return list.get(0).getName();
    }

    private JSONArray c(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        for (FilterWord filterWord : list) {
            jSONArray.put(filterWord.getId());
        }
        return jSONArray;
    }

    @NonNull
    private Map<String, String> d(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", AbstractBceClient.DEFAULT_CONTENT_TYPE);
        if (b(str)) {
            hashMap.put("Content-Encoding", "union_sdk_encode");
        }
        return hashMap;
    }

    private boolean b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.optString("message").equalsIgnoreCase("success");
            } catch (Throwable th) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q.b bVar) {
        bVar.a(-1, h.a(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q.c cVar) {
        cVar.a(-1, h.a(-1));
    }

    private JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", i.c().e());
            jSONObject.put("name", i.c().f());
            c(jSONObject);
            d(jSONObject);
            jSONObject.put("is_paid_app", i.c().g());
            jSONObject.put("apk_sign", s.b(k.a(this.f6665a)).a());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private String c() {
        return com.bytedance.sdk.openadsdk.utils.i.a();
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, "keywords", i.c().h());
            JSONArray a2 = com.bytedance.sdk.openadsdk.utils.q.a(this.f6665a);
            if (a2 != null) {
                jSONObject.put("app_list", a2);
            }
            a(jSONObject, "data", i.c().i());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", aj.d());
            jSONObject.put("version_code", aj.e());
            jSONObject.put("version", aj.f());
        } catch (Exception e) {
        }
    }

    private void d(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(this.f6665a);
        if (a2 != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", a2.f7566a);
                jSONObject2.put("longitude", a2.f7567b);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception e) {
            }
        }
    }

    private String e() {
        return com.bytedance.sdk.openadsdk.utils.i.a(true);
    }

    private JSONObject a(AdSlot adSlot, int i, com.bytedance.sdk.openadsdk.core.d.m mVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", adSlot.getCodeId());
            jSONObject.put("prime_rit", adSlot.getPrimeRit());
            jSONObject.put("show_seq", adSlot.getAdloadSeq());
            jSONObject.put("adtype", i);
            if (mVar != null) {
                jSONObject.put("render_method", mVar.e);
            } else {
                jSONObject.put("render_method", 1);
            }
            jSONObject.put("ptpl_ids", p.h().h(adSlot.getCodeId()));
            jSONObject.put("pos", AdSlot.getPosition(i));
            a(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
            if (adSlot.getNativeAdType() > 0 || i == 9 || i == 5) {
                jSONObject.put("is_origin_ad", true);
            }
            if (mVar != null && mVar.g != null) {
                jSONObject.put("session_params", mVar.g);
            }
            int adCount = adSlot.getAdCount();
            if (i == 7 || i == 8) {
                adCount = 1;
            }
            if (mVar != null && mVar.d != null) {
                adCount = adSlot.getAdCount();
            }
            jSONObject.put("ad_count", adCount);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private void a(JSONObject jSONObject, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject2.put("width", i);
                jSONObject2.put("height", i2);
                jSONArray.put(jSONObject2);
                jSONObject.put(str, jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private void a(com.bytedance.sdk.openadsdk.c.a aVar) {
        if (aVar != null && aVar.f6219b != null) {
            String optString = aVar.f6219b.optString("log_extra", "");
            long e = aj.e(optString);
            int f = aj.f(optString);
            if (e == 0) {
                e = this.e;
            }
            this.e = e;
            this.f = f == 0 ? this.f : f;
        }
    }

    @SuppressLint({"HardwareIds"})
    private JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.baidu.fsg.base.statistics.j.c, aj.a());
            jSONObject.put("udid", k.d(this.f6665a));
            jSONObject.put("openudid", k.c(this.f6665a));
            jSONObject.put("oaid", com.bytedance.sdk.openadsdk.utils.y.a());
            jSONObject.put("ad_sdk_version", "3.2.5.1");
            jSONObject.put("sim_op", a(this.f6665a));
            jSONObject.put("root", this.f6666b ? 1 : 0);
            jSONObject.put("timezone", i());
            jSONObject.put("access", com.bytedance.sdk.openadsdk.utils.x.f(this.f6665a));
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(HttpConstants.DEVICE_TYPE, this.c);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put(KsMediaMeta.KSM_KEY_LANGUAGE, Locale.getDefault().getLanguage());
            jSONObject.put("resolution", ak.d(this.f6665a) + Config.EVENT_HEAT_X + ak.c(this.f6665a));
            jSONObject.put("display_density", b(ak.f(this.f6665a)));
            jSONObject.put("density_dpi", ak.f(this.f6665a));
            jSONObject.put(Config.DEVICE_MAC_ID, c());
            jSONObject.put("device_id", k.a(this.f6665a));
            jSONObject.put("aid", "1371");
            jSONObject.put(Config.ROM, h());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", k.i(this.f6665a));
            jSONObject.put("ut", this.f);
            jSONObject.put("uid", this.e);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private static boolean g() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static String a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Throwable th) {
            return "";
        }
    }

    private static String h() {
        StringBuilder sb = new StringBuilder();
        try {
            if (ad.e()) {
                sb.append("MIUI-");
            } else if (ad.b()) {
                sb.append("FLYME-");
            } else {
                String n = ad.n();
                if (ad.a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable th) {
        }
        return sb.toString();
    }

    private static String b(int i) {
        switch (i) {
            case 120:
                return "ldpi";
            case 160:
                return "mdpi";
            case 240:
                return "hdpi";
            case VideoConstant.THUMBNAIL_WIDTH /* 320 */:
                return "xhdpi";
            case 480:
                return "xxhdpi";
            case 640:
                return "xxxhdpi";
            default:
                return "mdpi";
        }
    }

    private static int i() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        int i = rawOffset >= -12 ? rawOffset : -12;
        if (i > 12) {
            return 12;
        }
        return i;
    }

    private String j() {
        if (com.bytedance.sdk.openadsdk.utils.i.b(this.f6665a)) {
            return Config.TARGET_SDK_VERSION;
        }
        if (com.bytedance.sdk.openadsdk.utils.i.a(this.f6665a)) {
            return "android_pad";
        }
        return HttpConstants.OS_TYPE_VALUE;
    }

    private String k() {
        String a2 = com.bytedance.sdk.openadsdk.core.a.a();
        if (a2 == null) {
            return com.bytedance.sdk.openadsdk.core.b.a();
        }
        return a2;
    }

    private String e(String str) {
        String a2 = com.bytedance.sdk.openadsdk.core.a.a(str);
        if (str == null) {
            String a3 = com.bytedance.sdk.openadsdk.core.b.a();
            return a3.concat(a3).substring(8, 24);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject != null) {
            try {
            } catch (Exception e) {
                jSONObject2 = jSONObject;
            }
            if (g) {
                int optInt = jSONObject.optInt("cypher", -1);
                String optString = jSONObject.optString("message");
                String b2 = (optInt != 2 || TextUtils.isEmpty(optString) || optString.length() < 17) ? optInt == 1 ? com.bytedance.sdk.openadsdk.core.a.b(optString, com.bytedance.sdk.openadsdk.core.b.a()) : optString : com.bytedance.sdk.openadsdk.core.a.b(optString.substring(17), e(optString.substring(1, 17)));
                if (!TextUtils.isEmpty(b2)) {
                    try {
                        jSONObject2 = new JSONObject(b2);
                    } catch (Throwable th) {
                        jSONObject2 = jSONObject;
                    }
                    if (!g) {
                        jSONObject2 = jSONObject;
                    }
                    return jSONObject2;
                }
            }
            jSONObject2 = jSONObject;
            if (!g) {
            }
            return jSONObject2;
        }
        return jSONObject;
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f6673a;

        /* renamed from: b  reason: collision with root package name */
        final long f6674b;
        final long c;
        final int d;
        final String e;
        final int f;
        final String g;
        @Nullable
        public final com.bytedance.sdk.openadsdk.core.d.a h;
        final String i;

        private a(String str, int i, int i2, String str2, int i3, String str3, @Nullable com.bytedance.sdk.openadsdk.core.d.a aVar, long j, long j2) {
            this.f6673a = i;
            this.d = i2;
            this.e = str2;
            this.g = str3;
            this.h = aVar;
            this.i = str;
            this.f = i3;
            this.f6674b = j;
            this.c = j2;
        }

        public static a a(JSONObject jSONObject) {
            return a(jSONObject, null);
        }

        public static a a(JSONObject jSONObject, AdSlot adSlot) {
            String optString = jSONObject.optString(VideoPlayerStatistic.AudienceHiidoCoreStatisticKey.DecodeId);
            int optInt = jSONObject.optInt("processing_time_ms");
            long optLong = jSONObject.optLong("s_receive_ts");
            long optLong2 = jSONObject.optLong("s_send_ts");
            int optInt2 = jSONObject.optInt("status_code");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("request_id");
            int optInt3 = jSONObject.optInt(TiebaInitialize.LogFields.REASON);
            com.bytedance.sdk.openadsdk.core.d.a a2 = com.bytedance.sdk.openadsdk.core.c.a(jSONObject, adSlot);
            if (a2 != null) {
                a2.a(jSONObject.optLong("request_after"));
            }
            return new a(optString, optInt, optInt2, optString2, optInt3, optString3, a2, optLong, optLong2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(JSONObject jSONObject, final q.c cVar) {
        if (!com.bytedance.sdk.openadsdk.core.h.j.a()) {
            if (cVar != null) {
                cVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else if (jSONObject != null && cVar != null) {
            new com.bytedance.sdk.adnet.b.f(1, aj.q("/api/ad/union/sdk/reward_video/reward/"), aj.a(jSONObject), new p.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.r.5
                @Override // com.bytedance.sdk.adnet.core.p.a
                public void a(com.bytedance.sdk.adnet.core.p<JSONObject> pVar) {
                    if (pVar == null || pVar.f6047a == null) {
                        r.this.a(cVar);
                        return;
                    }
                    int optInt = pVar.f6047a.optInt("cypher", -1);
                    String optString = pVar.f6047a.optString("message");
                    JSONObject jSONObject2 = pVar.f6047a;
                    String str = null;
                    if (optInt == 1) {
                        str = com.bytedance.sdk.openadsdk.core.a.b(optString, com.bytedance.sdk.openadsdk.core.b.a());
                    } else if (optInt == 2) {
                        str = aj.k(optString);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            jSONObject2 = new JSONObject(str);
                        } catch (Throwable th) {
                        }
                    }
                    c a2 = c.a(jSONObject2);
                    if (a2.f6677a != 20000) {
                        cVar.a(a2.f6677a, h.a(a2.f6677a));
                    } else if (a2.c == null) {
                        r.this.a(cVar);
                    } else {
                        cVar.a(a2);
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.p.a
                public void b(com.bytedance.sdk.adnet.core.p<JSONObject> pVar) {
                    String a2 = h.a(-2);
                    int i = pVar != null ? (int) pVar.h : -2;
                    if (pVar != null && pVar.pvp != null) {
                        a2 = pVar.pvp.getMessage();
                    }
                    cVar.a(i, a2);
                }
            }).setRetryPolicy(com.bytedance.sdk.openadsdk.i.e.b().OH(10000)).build(com.bytedance.sdk.openadsdk.i.e.a(this.f6665a).d());
        }
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f6677a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f6678b;
        public final com.bytedance.sdk.openadsdk.core.d.r c;

        private c(int i, boolean z, com.bytedance.sdk.openadsdk.core.d.r rVar) {
            this.f6677a = i;
            this.f6678b = z;
            this.c = rVar;
        }

        public static c a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("code");
            boolean optBoolean = jSONObject.optBoolean(SmsLoginView.f.j);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.d.r rVar = new com.bytedance.sdk.openadsdk.core.d.r();
            if (optJSONObject != null) {
                try {
                    rVar.a(optJSONObject.optInt(TiebaInitialize.LogFields.REASON));
                    rVar.b(optJSONObject.optInt("corp_type"));
                    rVar.c(optJSONObject.optInt("reward_amount"));
                    rVar.a(optJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return new c(optInt, optBoolean, rVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(int i, String str, String str2, Bitmap bitmap) {
        if (com.bytedance.sdk.openadsdk.core.h.j.a() && bitmap != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                String a2 = com.bytedance.sdk.openadsdk.utils.j.a(str + ":" + i + ":" + str2);
                jSONObject.put("rit", i);
                jSONObject.put("req_id", str);
                jSONObject.put(LegoListActivityConfig.AD_ID, str2);
                jSONObject.put("sign", a2);
                jSONObject.put("image", com.bytedance.sdk.openadsdk.utils.f.a(bitmap));
            } catch (Throwable th) {
            }
            new com.bytedance.sdk.adnet.b.f(1, aj.q("/union/service/sdk/upload/v2/"), aj.a(jSONObject), (p.a<JSONObject>) null).setRetryPolicy(com.bytedance.sdk.openadsdk.i.e.b().OH(10000)).setShouldCache(false).build(com.bytedance.sdk.openadsdk.i.e.a(this.f6665a).d());
            try {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            } catch (Throwable th2) {
            }
        }
    }

    private JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            String a2 = com.bytedance.sdk.openadsdk.core.a.a(str, com.bytedance.sdk.openadsdk.core.b.a());
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder("id=");
            sb.append(a2).append("&timestamp=");
            sb.append(currentTimeMillis).append("&ext=");
            sb.append(str2);
            String upperCase = com.bytedance.sdk.openadsdk.utils.j.a(sb.toString()).toUpperCase();
            jSONObject.put("id", a2);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("sign", upperCase);
            jSONObject.put("ext", str2);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(String str, String str2, final q.a aVar) {
        if (!com.bytedance.sdk.openadsdk.core.h.j.a()) {
            if (aVar != null) {
                aVar.a(false, -1L, 0L);
            }
        } else if (str != null && str2 != null && aVar != null) {
            new com.bytedance.sdk.adnet.b.f(1, aj.q("/api/ad/union/sdk/material/check/"), aj.a(a(str, str2)), new p.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.r.6
                @Override // com.bytedance.sdk.adnet.core.p.a
                public void a(com.bytedance.sdk.adnet.core.p<JSONObject> pVar) {
                    long j = -1;
                    long j2 = 0;
                    boolean z = false;
                    if (pVar.f6047a != null) {
                        b a2 = b.a(pVar.f6047a);
                        j = a2.f6675a;
                        j2 = pVar.f;
                        z = a2.f6676b;
                    }
                    aVar.a(z, j, j2);
                }

                @Override // com.bytedance.sdk.adnet.core.p.a
                public void b(com.bytedance.sdk.adnet.core.p<JSONObject> pVar) {
                    long j = -1;
                    if (pVar.h != 0) {
                        j = pVar.h;
                    }
                    aVar.a(false, j, pVar.f);
                }
            }).setRetryPolicy(com.bytedance.sdk.openadsdk.i.e.b().OH(800)).build(com.bytedance.sdk.openadsdk.i.e.a(this.f6665a).d());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public com.bytedance.sdk.openadsdk.c.h a(JSONObject jSONObject) {
        String str;
        int i;
        boolean z;
        com.bytedance.sdk.adnet.core.p pVar;
        boolean z2 = true;
        if (com.bytedance.sdk.openadsdk.core.h.j.a() && jSONObject != null && jSONObject.length() > 0) {
            com.bytedance.sdk.adnet.b.i eqH = com.bytedance.sdk.adnet.b.i.eqH();
            new com.bytedance.sdk.adnet.b.f(1, aj.q("/api/ad/union/sdk/stats/batch/"), aj.a(jSONObject), eqH).setRetryPolicy(com.bytedance.sdk.openadsdk.i.e.b().OH(10000)).setUserAgent(aj.a()).build(com.bytedance.sdk.openadsdk.i.e.a(this.f6665a).d());
            try {
                pVar = eqH.get();
            } catch (Throwable th) {
                z2 = false;
                str = "error unknown";
                i = 0;
                z = false;
            }
            if (pVar == null) {
                return new com.bytedance.sdk.openadsdk.c.h(false, 0, "error unknown", false);
            }
            if (pVar.f6047a == 0) {
                z2 = false;
                str = "error unknown";
                z = false;
            } else {
                int optInt = ((JSONObject) pVar.f6047a).optInt("code", -1);
                str = ((JSONObject) pVar.f6047a).optString("data", "");
                z = optInt == 20000;
                if (optInt != 60005) {
                    z2 = false;
                }
            }
            try {
                i = (int) pVar.h;
                try {
                    if (pVar.pvp != null) {
                        str = pVar.pvp.getMessage();
                    }
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                i = 0;
            }
            return new com.bytedance.sdk.openadsdk.c.h(z, i, str, z2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public boolean a(JSONObject jSONObject, int i) {
        boolean z;
        if (com.bytedance.sdk.openadsdk.core.h.j.a()) {
            if (jSONObject == null || jSONObject.length() <= 0) {
                return true;
            }
            com.bytedance.sdk.adnet.b.i eqH = com.bytedance.sdk.adnet.b.i.eqH();
            new com.bytedance.sdk.adnet.b.f(1, "https://i.snssdk.com/inspect/aegis/client/page/", jSONObject, eqH).setRetryPolicy(com.bytedance.sdk.openadsdk.i.e.b().OH(10000).OI(i)).build(com.bytedance.sdk.openadsdk.i.e.a(this.f6665a).d());
            try {
                com.bytedance.sdk.adnet.core.p pVar = eqH.get();
                z = (pVar == null || pVar.f6047a == 0) ? false : "success".equals(((JSONObject) pVar.f6047a).optString("status", "success"));
            } catch (Throwable th) {
                z = false;
            }
            return z;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public com.bytedance.sdk.openadsdk.core.d.p a() {
        com.bytedance.sdk.adnet.core.p pVar;
        if (com.bytedance.sdk.openadsdk.core.h.j.a()) {
            com.bytedance.sdk.adnet.b.i eqH = com.bytedance.sdk.adnet.b.i.eqH();
            new com.bytedance.sdk.adnet.b.j(0, p.h().A(), eqH).setRetryPolicy(com.bytedance.sdk.openadsdk.i.e.b().OH(10000)).setShouldCache(false).build(com.bytedance.sdk.openadsdk.i.e.a(this.f6665a).d());
            try {
                pVar = eqH.get();
            } catch (Exception e) {
                pVar = null;
            }
            if (pVar == null || !pVar.a()) {
                return null;
            }
            return com.bytedance.sdk.openadsdk.core.d.p.d((String) pVar.f6047a);
        }
        return null;
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f6675a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f6676b;

        private b(int i, boolean z) {
            this.f6675a = i;
            this.f6676b = z;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new b(jSONObject.optInt("error_code"), jSONObject.optBoolean("result"));
        }
    }
}
