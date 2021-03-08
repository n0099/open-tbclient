package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.bytedance.sdk.adnet.core.o;
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

    /* renamed from: a  reason: collision with root package name */
    private static String f4507a = null;
    private static boolean g = true;
    private final Context b;
    private final boolean c = g();
    private final String d = j();
    private long e;
    private int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Context context) {
        this.b = context;
    }

    private JSONObject a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.d.m mVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            String c2 = (mVar == null || TextUtils.isEmpty(mVar.f4400a)) ? aj.c() : mVar.f4400a;
            if (i == 7) {
                if (mVar != null && mVar.b > 0) {
                    jSONObject2.put("req_type", mVar.b);
                }
            } else if (i == 8 && mVar != null && mVar.c > 0) {
                jSONObject2.put("req_type", mVar.c);
            }
            try {
                String g2 = p.h().g();
                String h = p.h().h();
                String u = i.d().u();
                if (!TextUtils.isEmpty(g2) && !TextUtils.isEmpty(h)) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("version", g2);
                    if (adSlot != null) {
                        jSONObject3.put("external_ab_vid", com.bytedance.sdk.openadsdk.i.g.d.a(adSlot.getExternalABVid()));
                        com.bytedance.sdk.openadsdk.utils.u.f("NetApiImpl", "external_ab_vid " + com.bytedance.sdk.openadsdk.i.g.d.a(adSlot.getExternalABVid()));
                    }
                    jSONObject3.put("param", h);
                    jSONObject3.put("tob_ab_sdk_version", u);
                    jSONObject2.put("abtest", jSONObject3);
                }
            } catch (Throwable th) {
            }
            jSONObject2.put("request_id", c2);
            jSONObject2.put("ad_sdk_version", "3.4.0.1");
            jSONObject2.put("source_type", "app");
            jSONObject2.put("logsdk_version", com.bytedance.embedapplog.b.B(HttpConstants.SDK_VERSION_NAME, ""));
            jSONObject2.put("app", b());
            JSONObject d = com.bytedance.sdk.openadsdk.utils.i.d(this.b);
            if (d != null) {
                if (!p.h().w() && !com.bytedance.sdk.openadsdk.downloadnew.a.g.b()) {
                    d.remove("free_space");
                }
                if (adSlot != null && adSlot.getOrientation() > 0) {
                    d.put("orientation", adSlot.getOrientation());
                }
            }
            jSONObject2.put(Config.DEVICE_PART, d);
            jSONObject2.put("user", d());
            jSONObject2.put(com.baidu.fsg.base.statistics.j.c, aj.b());
            jSONObject2.put(TableDefine.UserInfoColumns.COLUMN_IP, e());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(a(adSlot, i, mVar));
            jSONObject2.put("adslots", jSONArray);
            a(jSONObject2, mVar);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject2.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, currentTimeMillis);
            String str = "";
            if (adSlot.getCodeId() != null && c2 != null) {
                str = String.valueOf(currentTimeMillis).concat(adSlot.getCodeId()).concat(c2);
            }
            jSONObject2.put("req_sign", com.bytedance.sdk.openadsdk.utils.j.a(str));
            String k = k();
            String a2 = com.bytedance.sdk.openadsdk.core.a.a(jSONObject2.toString(), f(k));
            String str2 = 2 + k + a2;
            if (c(a2)) {
                jSONObject.put("message", str2);
                jSONObject.put("cypher", 2);
            } else {
                jSONObject.put("message", jSONObject2.toString());
                jSONObject.put("cypher", 0);
            }
            jSONObject.put("ad_sdk_version", "3.4.0.1");
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
            com.bytedance.sdk.openadsdk.c.d.a(this.b, b2, System.currentTimeMillis());
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.d.m mVar, final int i, final q.b bVar) {
        String l;
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            if (bVar != null) {
                bVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.h.f.a((com.bytedance.sdk.openadsdk.core.h.c) null).c();
        com.bytedance.sdk.openadsdk.core.h.d.a().b();
        com.bytedance.sdk.openadsdk.core.h.b.a().b();
        e.a().c();
        if (bVar != null) {
            if (a(adSlot.getCodeId())) {
                bVar.a(-8, h.a(-8));
                return;
            }
            final JSONObject a2 = a(adSlot, mVar, i);
            if (a2 == null) {
                bVar.a(-9, h.a(-9));
                return;
            }
            String l2 = aj.l("/api/ad/union/sdk/get_ads/");
            try {
                boolean b2 = b(adSlot.getExtraSmartLookParam());
                com.bytedance.sdk.openadsdk.utils.u.f("TTMediationSDK", "获取到的smartlook信息：isSmartLook=" + b2 + "，type=" + i);
                if (b2 && !TextUtils.isEmpty(f4507a)) {
                    if (i != 4) {
                        l2 = f4507a;
                    } else {
                        return;
                    }
                }
                l = l2;
            } catch (Throwable th) {
                l = aj.l("/api/ad/union/sdk/get_ads/");
            }
            new com.bytedance.sdk.adnet.b.f(1, l, a2, new o.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.r.1
                @Override // com.bytedance.sdk.adnet.core.o.a
                public void a(com.bytedance.sdk.adnet.core.o<JSONObject> oVar) {
                    boolean z = true;
                    long j = 0;
                    try {
                        j = ((Long) oVar.a("extra_time_start")).longValue();
                    } catch (Throwable th2) {
                        z = false;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject e = r.this.e(oVar.f4049a);
                    if (e == null) {
                        r.this.a(bVar);
                        r.this.a(oVar.e, adSlot.getCodeId(), i, null, -1, "mate parse_fail");
                        return;
                    }
                    try {
                        a a3 = a.a(e, adSlot, mVar);
                        k.a(r.this.b, a3.i);
                        if (a3.d != 20000) {
                            bVar.a(a3.d, a3.e);
                            r.this.a(oVar.e, adSlot.getCodeId(), i, a3, a3.d, String.valueOf(a3.f));
                        } else if (a3.h == null) {
                            r.this.a(bVar);
                            r.this.a(oVar.e, adSlot.getCodeId(), i, a3, -1, "parse_fail");
                        } else {
                            a3.h.c(e.toString());
                            long currentTimeMillis2 = System.currentTimeMillis();
                            bVar.a(a3.h);
                            Map<String, com.bytedance.sdk.openadsdk.core.d.l> a4 = com.bytedance.sdk.openadsdk.core.d.a.a(a3.h);
                            if (a4 != null) {
                                com.bytedance.sdk.openadsdk.gecko.a.a().a(a4);
                            }
                            if (z && a3.h.c() != null && !a3.h.c().isEmpty()) {
                                com.bytedance.sdk.openadsdk.core.d.l lVar = a3.h.c().get(0);
                                String b3 = aj.b(i);
                                HashMap hashMap = new HashMap();
                                if (mVar != null && mVar.f > 0) {
                                    hashMap.put("client_start_time", Long.valueOf(j - mVar.f));
                                    hashMap.put("load_ts", Long.valueOf(mVar.f));
                                    hashMap.put("total_time", Long.valueOf(currentTimeMillis2 - mVar.f));
                                }
                                hashMap.put("request_ts", Long.valueOf(j));
                                hashMap.put("s_revice_ts", Long.valueOf(a3.b));
                                hashMap.put("s_send_ts", Long.valueOf(a3.c));
                                hashMap.put("c_revice_ts", Long.valueOf(currentTimeMillis));
                                hashMap.put("c_end_ts", Long.valueOf(currentTimeMillis2));
                                hashMap.put("network_time", Long.valueOf(oVar.f));
                                hashMap.put("go_time", Long.valueOf(a3.b - j));
                                hashMap.put("sever_time", Integer.valueOf(a3.f4511a));
                                hashMap.put("back_time", Long.valueOf(currentTimeMillis - a3.c));
                                hashMap.put("client_end_time", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                                com.bytedance.sdk.openadsdk.c.d.a(lVar, b3, hashMap);
                            }
                        }
                    } catch (Throwable th3) {
                        com.bytedance.sdk.openadsdk.utils.u.c("NetApiImpl", "get ad error: ", th3);
                        r.this.a(bVar);
                        r.this.a(oVar.e, adSlot.getCodeId(), i, null, -1, "parse_fail");
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.o.a
                public void b(com.bytedance.sdk.adnet.core.o<JSONObject> oVar) {
                    int i2;
                    VAdError vAdError = oVar.pxT;
                    if (vAdError instanceof com.bytedance.sdk.adnet.err.e) {
                        r.this.a(bVar);
                        r.this.a(oVar.e, adSlot.getCodeId(), i, null, -1, h.a(-1));
                        return;
                    }
                    String a3 = h.a(-2);
                    if (vAdError == null || oVar == null) {
                        i2 = -2;
                    } else {
                        i2 = (int) oVar.h;
                        a3 = vAdError.getMessage();
                    }
                    bVar.a(i2, a3);
                    r.this.a(oVar.e, adSlot.getCodeId(), i, null, i2, vAdError instanceof com.bytedance.sdk.adnet.err.g ? "SocketTimeout" : a3);
                }
            }) { // from class: com.bytedance.sdk.openadsdk.core.r.2
                @Override // com.bytedance.sdk.adnet.core.Request
                public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                    HashMap hashMap = new HashMap();
                    hashMap.put("ss-sign", s.b(k.a(r.this.b)).d(a2.toString()));
                    return hashMap;
                }
            }.setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().OM(a(i)).ON(0)).setUserAgent(aj.b()).setShouldCache(false).addExtra("extra_time_start", Long.valueOf(System.currentTimeMillis())).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).e());
        }
    }

    private boolean b(String str) {
        JSONObject jSONObject = null;
        try {
            String k = aj.k(str);
            if (!TextUtils.isEmpty(k)) {
                jSONObject = new JSONObject(k);
            }
            if (jSONObject != null && jSONObject.getJSONObject("smart_look") != null && jSONObject.getString("smart_look_url") != null) {
                f4507a = com.bytedance.sdk.openadsdk.multipro.c.b(jSONObject.getString("smart_look_url"));
                return true;
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.utils.u.b("TTMediationSDK", "NetApiImpl-->异常：" + e.toString());
        }
        return false;
    }

    private int a(int i) {
        return 10000;
    }

    private boolean c(String str) {
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
        String aj;
        if (com.bytedance.sdk.openadsdk.core.h.g.a()) {
            if (i == 4 || i == 3) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = h.a(i2);
                }
                com.bytedance.sdk.openadsdk.g.a.b g2 = new com.bytedance.sdk.openadsdk.g.a.b().a(i).b(i2).g(str2);
                com.bytedance.sdk.openadsdk.core.d.l lVar = null;
                String str3 = "";
                if (aVar != null) {
                    try {
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.utils.u.c("NetApiImpl", "uploadAdTypeTimeOutEvent throws exception ", th);
                    }
                    if (aVar.h != null && aVar.h.c() != null && aVar.h.c().size() > 0) {
                        com.bytedance.sdk.openadsdk.core.d.l lVar2 = aVar.h.c().get(0);
                        aj = lVar2.aj();
                        if (TextUtils.isEmpty(aj)) {
                            lVar = lVar2;
                        } else {
                            try {
                                str3 = new JSONObject(aj).getString("req_id");
                                lVar = lVar2;
                            } catch (Throwable th2) {
                                lVar = lVar2;
                            }
                        }
                        g2.f((TextUtils.isEmpty(str3) || aVar == null || aVar.h == null) ? str3 : aVar.h.a()).d(lVar == null ? lVar.ag() : "").h(aj).c(str).a(j).b(aVar == null ? aVar.f4511a : 0L);
                        com.bytedance.sdk.openadsdk.g.a.a().e(g2);
                    }
                }
                aj = "";
                g2.f((TextUtils.isEmpty(str3) || aVar == null || aVar.h == null) ? str3 : aVar.h.a()).d(lVar == null ? lVar.ag() : "").h(aj).c(str).a(j).b(aVar == null ? aVar.f4511a : 0L);
                com.bytedance.sdk.openadsdk.g.a.a().e(g2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    @WorkerThread
    public com.bytedance.sdk.openadsdk.c.h a(List<com.bytedance.sdk.openadsdk.c.a> list) {
        String str;
        boolean z;
        com.bytedance.sdk.adnet.core.o oVar = null;
        try {
            if (com.bytedance.sdk.openadsdk.core.h.g.a()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    a(list.get(0));
                    jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, f());
                    JSONArray jSONArray = new JSONArray();
                    for (com.bytedance.sdk.openadsdk.c.a aVar : list) {
                        jSONArray.put(aVar.b);
                    }
                    jSONObject.put("event", jSONArray);
                    jSONObject.put("_gen_time", System.currentTimeMillis());
                } catch (JSONException e) {
                }
                String a2 = com.bytedance.sdk.openadsdk.core.a.a(jSONObject.toString(), com.bytedance.sdk.openadsdk.core.b.b());
                if (!c(a2)) {
                    a2 = jSONObject.toString();
                }
                if (com.bytedance.sdk.openadsdk.utils.u.c()) {
                    com.bytedance.sdk.openadsdk.utils.u.b("adevent", "adevent is :" + jSONObject.toString());
                }
                final Map<String, String> e2 = e(a2);
                com.bytedance.sdk.adnet.b.i eqX = com.bytedance.sdk.adnet.b.i.eqX();
                new com.bytedance.sdk.adnet.b.f(1, aj.h(), a2, eqX) { // from class: com.bytedance.sdk.openadsdk.core.r.3
                    @Override // com.bytedance.sdk.adnet.core.Request
                    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                        return e2;
                    }
                }.setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().OM(10000)).setUserAgent(aj.b()).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
                try {
                    oVar = eqX.get();
                } catch (Throwable th) {
                }
                boolean z2 = oVar != null && b((JSONObject) oVar.f4049a);
                int i = oVar != null ? (int) oVar.h : 0;
                if (!z2 && i == 200) {
                    str = "server say not success";
                    z = true;
                } else if (oVar == null || oVar.pxT == null) {
                    str = "error unknown";
                    z = false;
                } else {
                    str = oVar.pxT.getMessage();
                    z = false;
                }
                d(a2);
                return new com.bytedance.sdk.openadsdk.c.h(z2, i, str, z);
            }
            return null;
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.utils.u.c("NetApiImpl", "uploadEvent error", th2);
            return new com.bytedance.sdk.openadsdk.c.h(false, 509, "service_busy", false);
        }
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str) && i.d().v()) {
            final Map<String, String> e = e(str);
            new com.bytedance.sdk.adnet.b.f(1, aj.i(), str, com.bytedance.sdk.adnet.b.i.eqX()) { // from class: com.bytedance.sdk.openadsdk.core.r.4
                @Override // com.bytedance.sdk.adnet.core.Request
                public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                    return e;
                }
            }.setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().OM(10000)).setUserAgent(aj.b()).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(@NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, List<FilterWord> list) {
        JSONObject b2;
        if (com.bytedance.sdk.openadsdk.core.h.g.a() && (b2 = b(lVar, list)) != null) {
            new com.bytedance.sdk.adnet.b.h(1, aj.l("/api/ad/union/dislike_event/"), aj.a(b2), null).setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().OM(10000)).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
        }
    }

    private JSONObject b(@NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, List<FilterWord> list) {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(this.b);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", "dislike");
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", "3.4.0.1");
            if (a2 != null) {
                jSONObject2.put("latitude", a2.f5126a);
                jSONObject2.put("longitude", a2.b);
            }
            if (lVar != null) {
                jSONObject2.put("extra", lVar.aj());
                if (lVar.y() == null) {
                    lVar.c("other");
                }
                jSONObject2.put("dislike_source", lVar.y());
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
    private Map<String, String> e(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", AbstractBceClient.DEFAULT_CONTENT_TYPE);
        if (c(str)) {
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
            jSONObject.put("appid", i.d().f());
            jSONObject.put("name", i.d().g());
            c(jSONObject);
            d(jSONObject);
            jSONObject.put("is_paid_app", i.d().h());
            jSONObject.put("apk_sign", s.b(k.a(this.b)).b());
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
            a(jSONObject, "keywords", i.d().i());
            JSONArray a2 = com.bytedance.sdk.openadsdk.utils.q.a(this.b);
            if (a2 != null) {
                jSONObject.put("app_list", a2);
            }
            a(jSONObject, "data", i.d().j());
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
            jSONObject.put("package_name", aj.e());
            jSONObject.put("version_code", aj.f());
            jSONObject.put("version", aj.g());
        } catch (Exception e) {
        }
    }

    private void d(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(this.b);
        if (a2 != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", a2.f5126a);
                jSONObject2.put("longitude", a2.b);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception e) {
            }
        }
    }

    private String e() {
        return com.bytedance.sdk.openadsdk.utils.i.a(true);
    }

    private JSONObject a(AdSlot adSlot, int i, com.bytedance.sdk.openadsdk.core.d.m mVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("id", adSlot.getCodeId());
            jSONObject2.put("prime_rit", adSlot.getPrimeRit());
            jSONObject2.put("show_seq", adSlot.getAdloadSeq());
            jSONObject2.put("adtype", i);
            if (!TextUtils.isEmpty(adSlot.getAdId()) || !TextUtils.isEmpty(adSlot.getCreativeId())) {
                JSONObject jSONObject3 = new JSONObject();
                if (!TextUtils.isEmpty(adSlot.getAdId())) {
                    jSONObject3.put(LegoListActivityConfig.AD_ID, adSlot.getAdId());
                }
                if (!TextUtils.isEmpty(adSlot.getCreativeId())) {
                    jSONObject3.put("creative_id", adSlot.getCreativeId());
                }
                jSONObject2.put("preview_ads", jSONObject3);
            }
            if (mVar != null) {
                jSONObject2.put("render_method", mVar.e);
                if (mVar.e == 1) {
                    a(jSONObject2, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
                } else if (mVar.e == 2) {
                    a(jSONObject2, "accepted_size", adSlot.getExpressViewAcceptedWidth(), adSlot.getExpressViewAcceptedHeight());
                }
            } else {
                jSONObject2.put("render_method", 1);
                a(jSONObject2, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            }
            jSONObject2.put("ptpl_ids", p.h().h(adSlot.getCodeId()));
            jSONObject2.put("pos", AdSlot.getPosition(i));
            jSONObject2.put("is_support_dpl", adSlot.isSupportDeepLink());
            jSONObject2.put("if_support_render_control", adSlot.isSupportRenderConrol() ? 1 : 0);
            if (adSlot.getNativeAdType() > 0 || i == 9 || i == 5) {
                jSONObject2.put("is_origin_ad", true);
            }
            if (mVar != null && mVar.g != null) {
                jSONObject2.put("session_params", mVar.g);
            }
            int adCount = adSlot.getAdCount();
            if (i == 7 || i == 8) {
                adCount = 1;
            }
            if (mVar != null && mVar.d != null) {
                adCount = adSlot.getAdCount();
            }
            jSONObject2.put("ad_count", adCount);
            String k = aj.k(adSlot.getExtraSmartLookParam());
            JSONObject jSONObject4 = null;
            if (!TextUtils.isEmpty(k)) {
                jSONObject4 = new JSONObject(k);
            }
            if (jSONObject4 != null && (jSONObject = jSONObject4.getJSONObject("smart_look")) != null && !TextUtils.isEmpty(jSONObject.toString())) {
                jSONObject2.put("smart_look", jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONObject2;
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

    private void a(JSONObject jSONObject, String str, float f, float f2) {
        if (f > 0.0f && f2 >= 0.0f) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject2.put("width", (int) f);
                jSONObject2.put("height", (int) f2);
                jSONArray.put(jSONObject2);
                jSONObject.put(str, jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private void a(com.bytedance.sdk.openadsdk.c.a aVar) {
        if (aVar != null && aVar.b != null) {
            String optString = aVar.b.optString("log_extra", "");
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
            jSONObject.put(com.baidu.fsg.base.statistics.j.c, aj.b());
            jSONObject.put("udid", k.d(this.b));
            jSONObject.put("openudid", k.c(this.b));
            jSONObject.put("oaid", com.bytedance.sdk.openadsdk.utils.y.a());
            jSONObject.put("ad_sdk_version", "3.4.0.1");
            jSONObject.put("sim_op", a(this.b));
            jSONObject.put("root", this.c ? 1 : 0);
            jSONObject.put("timezone", i());
            jSONObject.put("access", com.bytedance.sdk.openadsdk.utils.x.f(this.b));
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(HttpConstants.DEVICE_TYPE, this.d);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put(KsMediaMeta.KSM_KEY_LANGUAGE, Locale.getDefault().getLanguage());
            jSONObject.put("resolution", ak.d(this.b) + Config.EVENT_HEAT_X + ak.c(this.b));
            jSONObject.put("display_density", b(ak.f(this.b)));
            jSONObject.put("density_dpi", ak.f(this.b));
            jSONObject.put(Config.DEVICE_MAC_ID, c());
            jSONObject.put("device_id", k.a(this.b));
            jSONObject.put("aid", "1371");
            jSONObject.put(Config.ROM, h());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", k.i(this.b));
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
        if (com.bytedance.sdk.openadsdk.utils.i.b(this.b)) {
            return Config.TARGET_SDK_VERSION;
        }
        if (com.bytedance.sdk.openadsdk.utils.i.a(this.b)) {
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

    private String f(String str) {
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
                String b2 = (optInt != 2 || TextUtils.isEmpty(optString) || optString.length() < 17) ? optInt == 1 ? com.bytedance.sdk.openadsdk.core.a.b(optString, com.bytedance.sdk.openadsdk.core.b.a()) : optString : com.bytedance.sdk.openadsdk.core.a.b(optString.substring(17), f(optString.substring(1, 17)));
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
        final int f4511a;
        final long b;
        final long c;
        final int d;
        final String e;
        final int f;
        final String g;
        @Nullable
        public final com.bytedance.sdk.openadsdk.core.d.a h;
        final String i;

        private a(String str, int i, int i2, String str2, int i3, String str3, @Nullable com.bytedance.sdk.openadsdk.core.d.a aVar, long j, long j2) {
            this.f4511a = i;
            this.d = i2;
            this.e = str2;
            this.g = str3;
            this.h = aVar;
            this.i = str;
            this.f = i3;
            this.b = j;
            this.c = j2;
        }

        public static a a(JSONObject jSONObject) {
            return a(jSONObject, null, null);
        }

        public static a a(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.d.m mVar) {
            String optString = jSONObject.optString(VideoPlayerStatistic.AudienceHiidoCoreStatisticKey.DecodeId);
            int optInt = jSONObject.optInt("processing_time_ms");
            long optLong = jSONObject.optLong("s_receive_ts");
            long optLong2 = jSONObject.optLong("s_send_ts");
            int optInt2 = jSONObject.optInt("status_code");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("request_id");
            int optInt3 = jSONObject.optInt(TiebaInitialize.LogFields.REASON);
            com.bytedance.sdk.openadsdk.core.d.a a2 = com.bytedance.sdk.openadsdk.core.c.a(jSONObject, adSlot, mVar);
            if (a2 != null) {
                a2.a(jSONObject.optLong("request_after"));
            }
            return new a(optString, optInt, optInt2, optString2, optInt3, optString3, a2, optLong, optLong2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(JSONObject jSONObject, final q.c cVar) {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            if (cVar != null) {
                cVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else if (jSONObject != null && cVar != null) {
            new com.bytedance.sdk.adnet.b.f(1, aj.l("/api/ad/union/sdk/reward_video/reward/"), aj.a(jSONObject), new o.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.r.5
                @Override // com.bytedance.sdk.adnet.core.o.a
                public void a(com.bytedance.sdk.adnet.core.o<JSONObject> oVar) {
                    if (oVar == null || oVar.f4049a == null) {
                        r.this.a(cVar);
                        return;
                    }
                    int optInt = oVar.f4049a.optInt("cypher", -1);
                    String optString = oVar.f4049a.optString("message");
                    JSONObject jSONObject2 = oVar.f4049a;
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
                    if (a2.f4513a != 20000) {
                        cVar.a(a2.f4513a, h.a(a2.f4513a));
                    } else if (a2.c == null) {
                        r.this.a(cVar);
                    } else {
                        cVar.a(a2);
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.o.a
                public void b(com.bytedance.sdk.adnet.core.o<JSONObject> oVar) {
                    String a2 = h.a(-2);
                    int i = oVar != null ? (int) oVar.h : -2;
                    if (oVar != null && oVar.pxT != null && !TextUtils.isEmpty(oVar.pxT.getMessage())) {
                        a2 = oVar.pxT.getMessage();
                    }
                    cVar.a(i, a2);
                }
            }).setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().OM(10000)).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
        }
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f4513a;
        public final boolean b;
        public final com.bytedance.sdk.openadsdk.core.d.s c;

        private c(int i, boolean z, com.bytedance.sdk.openadsdk.core.d.s sVar) {
            this.f4513a = i;
            this.b = z;
            this.c = sVar;
        }

        public static c a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("code");
            boolean optBoolean = jSONObject.optBoolean(SmsLoginView.f.j);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.d.s sVar = new com.bytedance.sdk.openadsdk.core.d.s();
            if (optJSONObject != null) {
                try {
                    sVar.a(optJSONObject.optInt(TiebaInitialize.LogFields.REASON));
                    sVar.b(optJSONObject.optInt("corp_type"));
                    sVar.c(optJSONObject.optInt("reward_amount"));
                    sVar.a(optJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return new c(optInt, optBoolean, sVar);
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
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            if (aVar != null) {
                aVar.a(false, -1L, 0L);
            }
        } else if (str != null && str2 != null && aVar != null) {
            new com.bytedance.sdk.adnet.b.f(1, aj.l("/api/ad/union/sdk/material/check/"), aj.a(a(str, str2)), new o.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.r.6
                @Override // com.bytedance.sdk.adnet.core.o.a
                public void a(com.bytedance.sdk.adnet.core.o<JSONObject> oVar) {
                    long j = -1;
                    long j2 = 0;
                    boolean z = false;
                    if (oVar.f4049a != null) {
                        b a2 = b.a(oVar.f4049a);
                        j = a2.f4512a;
                        j2 = oVar.f;
                        z = a2.b;
                    }
                    aVar.a(z, j, j2);
                }

                @Override // com.bytedance.sdk.adnet.core.o.a
                public void b(com.bytedance.sdk.adnet.core.o<JSONObject> oVar) {
                    long j = -1;
                    if (oVar.h != 0) {
                        j = oVar.h;
                    }
                    aVar.a(false, j, oVar.f);
                }
            }).setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().OM(800)).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public com.bytedance.sdk.openadsdk.c.h a(JSONObject jSONObject) {
        String str;
        int i;
        boolean z;
        com.bytedance.sdk.adnet.core.o oVar;
        boolean z2 = true;
        if (com.bytedance.sdk.openadsdk.core.h.g.a() && jSONObject != null && jSONObject.length() > 0) {
            com.bytedance.sdk.adnet.b.i eqX = com.bytedance.sdk.adnet.b.i.eqX();
            new com.bytedance.sdk.adnet.b.f(1, aj.l("/api/ad/union/sdk/stats/batch/"), aj.a(jSONObject), eqX).setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().OM(10000)).setUserAgent(aj.b()).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
            try {
                oVar = eqX.get();
            } catch (Throwable th) {
                z2 = false;
                str = "error unknown";
                i = 0;
                z = false;
            }
            if (oVar == null) {
                return new com.bytedance.sdk.openadsdk.c.h(false, 0, "error unknown", false);
            }
            if (oVar.f4049a == 0) {
                z2 = false;
                str = "error unknown";
                z = false;
            } else {
                int optInt = ((JSONObject) oVar.f4049a).optInt("code", -1);
                str = ((JSONObject) oVar.f4049a).optString("data", "");
                z = optInt == 20000;
                if (optInt != 60005) {
                    z2 = false;
                }
            }
            try {
                i = (int) oVar.h;
                try {
                    if (oVar.pxT != null) {
                        str = oVar.pxT.getMessage();
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
        if (com.bytedance.sdk.openadsdk.core.h.g.a()) {
            if (jSONObject == null || jSONObject.length() <= 0) {
                return true;
            }
            com.bytedance.sdk.adnet.b.i eqX = com.bytedance.sdk.adnet.b.i.eqX();
            new com.bytedance.sdk.adnet.b.f(1, ai.b("https://i.snssdk.com/inspect/aegis/client/page/"), jSONObject, eqX).setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().OM(10000).ON(i)).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
            try {
                com.bytedance.sdk.adnet.core.o oVar = eqX.get();
                z = (oVar == null || oVar.f4049a == 0) ? false : "success".equals(((JSONObject) oVar.f4049a).optString("status", "success"));
            } catch (Throwable th) {
                z = false;
            }
            return z;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public com.bytedance.sdk.openadsdk.core.d.q a() {
        com.bytedance.sdk.adnet.core.o oVar;
        if (com.bytedance.sdk.openadsdk.core.h.g.a()) {
            com.bytedance.sdk.adnet.b.i eqX = com.bytedance.sdk.adnet.b.i.eqX();
            new com.bytedance.sdk.adnet.b.j(0, ai.b(p.h().z()), eqX).setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().OM(10000)).setShouldCache(false).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
            try {
                oVar = eqX.get();
            } catch (Exception e) {
                oVar = null;
            }
            if (oVar == null || !oVar.a()) {
                return null;
            }
            return com.bytedance.sdk.openadsdk.core.d.q.e((String) oVar.f4049a);
        }
        return null;
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f4512a;
        public final boolean b;

        private b(int i, boolean z) {
            this.f4512a = i;
            this.b = z;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new b(jSONObject.optInt("error_code"), jSONObject.optBoolean("result"));
        }
    }
}
