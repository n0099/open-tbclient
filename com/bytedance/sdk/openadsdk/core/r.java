package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidubce.AbstractBceClient;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.AppLogHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.ae;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.kwai.video.player.KsMediaMeta;
import d.c.c.b.d.o;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class r implements q<com.bytedance.sdk.openadsdk.c.a> {

    /* renamed from: b  reason: collision with root package name */
    public static String f28264b = null;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f28265h = true;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.r f28266a;

    /* renamed from: c  reason: collision with root package name */
    public final Context f28267c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f28268d = g();

    /* renamed from: e  reason: collision with root package name */
    public final String f28269e = j();

    /* renamed from: f  reason: collision with root package name */
    public long f28270f;

    /* renamed from: g  reason: collision with root package name */
    public int f28271g;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f28297a;

        /* renamed from: b  reason: collision with root package name */
        public final long f28298b;

        /* renamed from: c  reason: collision with root package name */
        public final long f28299c;

        /* renamed from: d  reason: collision with root package name */
        public final int f28300d;

        /* renamed from: e  reason: collision with root package name */
        public final String f28301e;

        /* renamed from: f  reason: collision with root package name */
        public final int f28302f;

        /* renamed from: g  reason: collision with root package name */
        public final String f28303g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.core.d.a f28304h;
        public final String i;

        public a(String str, int i, int i2, String str2, int i3, String str3, @Nullable com.bytedance.sdk.openadsdk.core.d.a aVar, long j, long j2) {
            this.f28297a = i;
            this.f28300d = i2;
            this.f28301e = str2;
            this.f28303g = str3;
            this.f28304h = aVar;
            this.i = str;
            this.f28302f = i3;
            this.f28298b = j;
            this.f28299c = j2;
        }

        public static a a(JSONObject jSONObject) {
            return a(jSONObject, null, null);
        }

        public static a a(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.d.m mVar) {
            String optString = jSONObject.optString("did");
            int optInt = jSONObject.optInt("processing_time_ms");
            long optLong = jSONObject.optLong("s_receive_ts");
            long optLong2 = jSONObject.optLong("s_send_ts");
            int optInt2 = jSONObject.optInt("status_code");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
            int optInt3 = jSONObject.optInt("reason");
            com.bytedance.sdk.openadsdk.core.d.a a2 = com.bytedance.sdk.openadsdk.core.c.a(jSONObject, adSlot, mVar);
            if (a2 != null) {
                a2.a(jSONObject.optLong("request_after"));
            }
            return new a(optString, optInt, optInt2, optString2, optInt3, optString3, a2, optLong, optLong2);
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f28305a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f28306b;

        public b(int i, boolean z) {
            this.f28305a = i;
            this.f28306b = z;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new b(jSONObject.optInt("error_code"), jSONObject.optBoolean("result"));
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f28307a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f28308b;

        /* renamed from: c  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.core.d.u f28309c;

        public c(int i, boolean z, com.bytedance.sdk.openadsdk.core.d.u uVar) {
            this.f28307a = i;
            this.f28308b = z;
            this.f28309c = uVar;
        }

        public static c a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("code");
            boolean optBoolean = jSONObject.optBoolean(SmsLoginView.f.j);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.d.u uVar = new com.bytedance.sdk.openadsdk.core.d.u();
            if (optJSONObject != null) {
                try {
                    uVar.a(optJSONObject.optInt("reason"));
                    uVar.b(optJSONObject.optInt("corp_type"));
                    uVar.c(optJSONObject.optInt("reward_amount"));
                    uVar.a(optJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return new c(optInt, optBoolean, uVar);
        }
    }

    public r(Context context) {
        this.f28267c = context;
    }

    private int a(int i) {
        return 10000;
    }

    public static String b(int i) {
        return i != 120 ? i != 160 ? i != 240 ? i != 320 ? i != 480 ? i != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    private boolean b(String str) {
        try {
            String k = ak.k(str);
            JSONObject jSONObject = !TextUtils.isEmpty(k) ? new JSONObject(k) : null;
            if (jSONObject != null && jSONObject.getJSONObject("smart_look") != null && jSONObject.getString("smart_look_url") != null) {
                f28264b = com.bytedance.sdk.openadsdk.multipro.c.b(jSONObject.getString("smart_look_url"));
                return true;
            }
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.utils.u.a("TTMediationSDK", "NetApiImpl-->异常：", e2.toString());
        }
        return false;
    }

    private boolean c(String str) {
        return !TextUtils.isEmpty(str);
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str) && i.d().w()) {
            final Map<String, String> e2 = e(str);
            d.c.c.b.b.f fVar = new d.c.c.b.b.f(1, ak.i(), str, d.c.c.b.b.i.c()) { // from class: com.bytedance.sdk.openadsdk.core.r.6
                @Override // com.bytedance.sdk.adnet.core.Request
                public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                    return e2;
                }
            };
            d.c.c.b.d.g b2 = com.bytedance.sdk.openadsdk.i.e.b();
            b2.b(10000);
            fVar.setRetryPolicy(b2).setUserAgent(ak.b()).build(com.bytedance.sdk.openadsdk.i.e.c().e());
        }
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

    @SuppressLint({"HardwareIds"})
    private JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", ak.b());
            jSONObject.put("udid", k.d(this.f28267c));
            jSONObject.put("openudid", k.c(this.f28267c));
            jSONObject.put("oaid", com.bytedance.sdk.openadsdk.utils.y.a());
            jSONObject.put("ad_sdk_version", "3.4.5.5");
            jSONObject.put("sim_op", a(this.f28267c));
            jSONObject.put("root", this.f28268d ? 1 : 0);
            jSONObject.put("timezone", i());
            jSONObject.put("access", com.bytedance.sdk.openadsdk.utils.x.f(this.f28267c));
            jSONObject.put(IAdRequestParam.OS, "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_type", this.f28269e);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put(KsMediaMeta.KSM_KEY_LANGUAGE, Locale.getDefault().getLanguage());
            jSONObject.put("resolution", al.d(this.f28267c) + "x" + al.c(this.f28267c));
            jSONObject.put("display_density", b(al.f(this.f28267c)));
            jSONObject.put("density_dpi", al.f(this.f28267c));
            jSONObject.put(Config.DEVICE_MAC_ID, c());
            jSONObject.put(Constants.KEY_DEVICE_ID, k.a(this.f28267c));
            jSONObject.put("aid", "1371");
            jSONObject.put(Config.ROM, h());
            jSONObject.put(PmsConstant.EnvParam.Key.CPU_ABI, Build.CPU_ABI);
            jSONObject.put("build_serial", k.i(this.f28267c));
            jSONObject.put("ut", this.f28271g);
            jSONObject.put("uid", this.f28270f);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static boolean g() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String h() {
        StringBuilder sb = new StringBuilder();
        try {
            if (ae.e()) {
                sb.append("MIUI-");
            } else if (ae.b()) {
                sb.append("FLYME-");
            } else {
                String n = ae.n();
                if (ae.a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static int i() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    private String j() {
        return com.bytedance.sdk.openadsdk.utils.i.c(this.f28267c) ? Config.TARGET_SDK_VERSION : com.bytedance.sdk.openadsdk.utils.i.b(this.f28267c) ? "android_pad" : "android";
    }

    private String k() {
        String a2 = com.bytedance.sdk.openadsdk.core.a.a();
        return a2 == null ? com.bytedance.sdk.openadsdk.core.b.a() : a2;
    }

    private JSONArray c(List<FilterWord> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (FilterWord filterWord : list) {
                jSONArray.put(filterWord.getId());
            }
            return jSONArray;
        }
        return new JSONArray();
    }

    private String e() {
        return com.bytedance.sdk.openadsdk.utils.i.a(true);
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return jSONObject;
        }
        if (f28265h) {
            int optInt = jSONObject.optInt("cypher", -1);
            String optString = jSONObject.optString("message");
            String b2 = optInt == 1 ? com.bytedance.sdk.openadsdk.core.a.b(optString, com.bytedance.sdk.openadsdk.core.b.a()) : optString;
            if (optInt == 2 && !TextUtils.isEmpty(optString) && optString.length() >= 17) {
                b2 = com.bytedance.sdk.openadsdk.core.a.b(optString.substring(17), f(optString.substring(1, 17)));
            }
            if (!TextUtils.isEmpty(b2)) {
                jSONObject2 = new JSONObject(b2);
                return !f28265h ? jSONObject2 : jSONObject;
            }
        }
        jSONObject2 = jSONObject;
        if (!f28265h) {
        }
    }

    private JSONObject b(@NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, List<FilterWord> list) {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(this.f28267c);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", "dislike");
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", "3.4.5.5");
            if (a2 != null) {
                jSONObject2.put("latitude", a2.f30082a);
                jSONObject2.put("longitude", a2.f30083b);
            }
            if (lVar != null) {
                jSONObject2.put("extra", lVar.ap());
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
            jSONObject.put(NotificationCompat.WearableExtender.KEY_ACTIONS, jSONArray);
            PersonalizationPrompt as = lVar.as();
            if (as != null) {
                jSONObject2.put("personalization_prompts", as.toJson());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String c() {
        return com.bytedance.sdk.openadsdk.utils.i.b();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:2|3|(15:8|9|(1:(1:14))(2:69|(1:74))|15|16|17|(10:21|(4:23|24|25|26)(1:66)|27|29|30|(3:32|(1:36)|(1:40))|41|(1:44)|45|(2:47|48)(6:50|51|52|(2:54|55)(1:59)|56|58))|67|29|30|(0)|41|(1:44)|45|(0)(0))|75|9|(0)(0)|15|16|17|(11:19|21|(0)(0)|27|29|30|(0)|41|(0)|45|(0)(0))|67|29|30|(0)|41|(0)|45|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b A[Catch: all -> 0x00ae, TRY_LEAVE, TryCatch #3 {all -> 0x00ae, blocks: (B:23:0x004b, B:25:0x0069, B:27:0x006f, B:29:0x007b), top: B:74:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d9 A[Catch: Exception -> 0x01ae, TryCatch #1 {Exception -> 0x01ae, blocks: (B:36:0x00b0, B:38:0x00d9, B:40:0x00e3, B:42:0x00e9, B:44:0x00f0, B:46:0x00f6, B:47:0x00ff, B:50:0x0149, B:51:0x0159, B:53:0x0164, B:55:0x0168), top: B:71:0x00b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0147 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0164 A[Catch: Exception -> 0x01ae, TryCatch #1 {Exception -> 0x01ae, blocks: (B:36:0x00b0, B:38:0x00d9, B:40:0x00e3, B:42:0x00e9, B:44:0x00f0, B:46:0x00f6, B:47:0x00ff, B:50:0x0149, B:51:0x0159, B:53:0x0164, B:55:0x0168), top: B:71:0x00b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0168 A[Catch: Exception -> 0x01ae, TRY_LEAVE, TryCatch #1 {Exception -> 0x01ae, blocks: (B:36:0x00b0, B:38:0x00d9, B:40:0x00e3, B:42:0x00e9, B:44:0x00f0, B:46:0x00f6, B:47:0x00ff, B:50:0x0149, B:51:0x0159, B:53:0x0164, B:55:0x0168), top: B:71:0x00b0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.d.m mVar, int i, boolean z) {
        String c2;
        JSONObject jSONObject;
        JSONObject e2;
        long currentTimeMillis;
        String str;
        JSONObject jSONObject2;
        String g2;
        String h2;
        String v;
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject jSONObject4 = new JSONObject();
            try {
                if (mVar != null && !TextUtils.isEmpty(mVar.f27878a)) {
                    c2 = mVar.f27878a;
                    if (i != 7) {
                        if (mVar != null && mVar.f27879b > 0) {
                            jSONObject4.put("req_type", mVar.f27879b);
                        }
                    } else if (i == 8 && mVar != null && mVar.f27880c > 0) {
                        jSONObject4.put("req_type", mVar.f27880c);
                    }
                    g2 = p.h().g();
                    h2 = p.h().h();
                    v = i.d().v();
                    if (!TextUtils.isEmpty(g2) && !TextUtils.isEmpty(h2)) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("version", g2);
                        if (adSlot == null) {
                            String a2 = com.bytedance.sdk.openadsdk.k.g.d.a(adSlot.getExternalABVid());
                            jSONObject5.put("external_ab_vid", a2);
                            jSONObject = jSONObject3;
                            try {
                                com.bytedance.sdk.openadsdk.utils.u.c("NetApiImpl", "external_ab_vid ", a2);
                            } catch (Throwable unused) {
                            }
                        } else {
                            jSONObject = jSONObject3;
                        }
                        jSONObject5.put("param", h2);
                        jSONObject5.put("tob_ab_sdk_version", v);
                        jSONObject4.put("abtest", jSONObject5);
                        jSONObject4.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, c2);
                        jSONObject4.put("ad_sdk_version", "3.4.5.5");
                        jSONObject4.put("source_type", "app");
                        jSONObject4.put("logsdk_version", AppLogHelper.getInstance().getSdkVersion());
                        jSONObject4.put("app", b());
                        e2 = com.bytedance.sdk.openadsdk.utils.i.e(this.f28267c);
                        if (e2 != null) {
                            if (!p.h().w() && !com.bytedance.sdk.openadsdk.downloadnew.a.g.b()) {
                                e2.remove(PmsConstant.EnvParam.Key.FREE_SPACE);
                            }
                            if (adSlot != null && adSlot.getOrientation() > 0) {
                                e2.put("orientation", adSlot.getOrientation());
                            }
                        }
                        jSONObject4.put("device", e2);
                        jSONObject4.put("user", d());
                        jSONObject4.put("ua", ak.b());
                        jSONObject4.put("ip", e());
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(a(adSlot, i, mVar));
                        jSONObject4.put("adslots", jSONArray);
                        a(jSONObject4, mVar);
                        currentTimeMillis = System.currentTimeMillis() / 1000;
                        jSONObject4.put("ts", currentTimeMillis);
                        str = "";
                        if (adSlot.getCodeId() != null && c2 != null) {
                            str = String.valueOf(currentTimeMillis).concat(adSlot.getCodeId()).concat(c2);
                        }
                        jSONObject4.put("req_sign", com.bytedance.sdk.openadsdk.utils.j.a(str));
                        if (!z) {
                            jSONObject4.put("ad_sdk_version", "3.4.5.5");
                            return jSONObject4;
                        }
                        String k = k();
                        String a3 = com.bytedance.sdk.openadsdk.core.a.a(jSONObject4.toString(), f(k));
                        String str2 = 2 + k + a3;
                        try {
                            if (c(a3)) {
                                jSONObject2 = jSONObject;
                                jSONObject2.put("message", str2);
                                jSONObject2.put("cypher", 2);
                            } else {
                                jSONObject2 = jSONObject;
                                jSONObject2.put("message", jSONObject4.toString());
                                jSONObject2.put("cypher", 0);
                            }
                            jSONObject2.put("ad_sdk_version", "3.4.5.5");
                            return jSONObject2;
                        } catch (Exception unused2) {
                            return jSONObject2;
                        }
                    }
                    jSONObject = jSONObject3;
                    jSONObject4.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, c2);
                    jSONObject4.put("ad_sdk_version", "3.4.5.5");
                    jSONObject4.put("source_type", "app");
                    jSONObject4.put("logsdk_version", AppLogHelper.getInstance().getSdkVersion());
                    jSONObject4.put("app", b());
                    e2 = com.bytedance.sdk.openadsdk.utils.i.e(this.f28267c);
                    if (e2 != null) {
                    }
                    jSONObject4.put("device", e2);
                    jSONObject4.put("user", d());
                    jSONObject4.put("ua", ak.b());
                    jSONObject4.put("ip", e());
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(a(adSlot, i, mVar));
                    jSONObject4.put("adslots", jSONArray2);
                    a(jSONObject4, mVar);
                    currentTimeMillis = System.currentTimeMillis() / 1000;
                    jSONObject4.put("ts", currentTimeMillis);
                    str = "";
                    if (adSlot.getCodeId() != null) {
                        str = String.valueOf(currentTimeMillis).concat(adSlot.getCodeId()).concat(c2);
                    }
                    jSONObject4.put("req_sign", com.bytedance.sdk.openadsdk.utils.j.a(str));
                    if (!z) {
                    }
                }
                if (!TextUtils.isEmpty(g2)) {
                    JSONObject jSONObject52 = new JSONObject();
                    jSONObject52.put("version", g2);
                    if (adSlot == null) {
                    }
                    jSONObject52.put("param", h2);
                    jSONObject52.put("tob_ab_sdk_version", v);
                    jSONObject4.put("abtest", jSONObject52);
                    jSONObject4.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, c2);
                    jSONObject4.put("ad_sdk_version", "3.4.5.5");
                    jSONObject4.put("source_type", "app");
                    jSONObject4.put("logsdk_version", AppLogHelper.getInstance().getSdkVersion());
                    jSONObject4.put("app", b());
                    e2 = com.bytedance.sdk.openadsdk.utils.i.e(this.f28267c);
                    if (e2 != null) {
                    }
                    jSONObject4.put("device", e2);
                    jSONObject4.put("user", d());
                    jSONObject4.put("ua", ak.b());
                    jSONObject4.put("ip", e());
                    JSONArray jSONArray22 = new JSONArray();
                    jSONArray22.put(a(adSlot, i, mVar));
                    jSONObject4.put("adslots", jSONArray22);
                    a(jSONObject4, mVar);
                    currentTimeMillis = System.currentTimeMillis() / 1000;
                    jSONObject4.put("ts", currentTimeMillis);
                    str = "";
                    if (adSlot.getCodeId() != null) {
                    }
                    jSONObject4.put("req_sign", com.bytedance.sdk.openadsdk.utils.j.a(str));
                    if (!z) {
                    }
                }
                jSONObject4.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, c2);
                jSONObject4.put("ad_sdk_version", "3.4.5.5");
                jSONObject4.put("source_type", "app");
                jSONObject4.put("logsdk_version", AppLogHelper.getInstance().getSdkVersion());
                jSONObject4.put("app", b());
                e2 = com.bytedance.sdk.openadsdk.utils.i.e(this.f28267c);
                if (e2 != null) {
                }
                jSONObject4.put("device", e2);
                jSONObject4.put("user", d());
                jSONObject4.put("ua", ak.b());
                jSONObject4.put("ip", e());
                JSONArray jSONArray222 = new JSONArray();
                jSONArray222.put(a(adSlot, i, mVar));
                jSONObject4.put("adslots", jSONArray222);
                a(jSONObject4, mVar);
                currentTimeMillis = System.currentTimeMillis() / 1000;
                jSONObject4.put("ts", currentTimeMillis);
                str = "";
                if (adSlot.getCodeId() != null) {
                }
                jSONObject4.put("req_sign", com.bytedance.sdk.openadsdk.utils.j.a(str));
                if (!z) {
                }
            } catch (Exception unused3) {
                return jSONObject;
            }
            c2 = ak.c();
            if (i != 7) {
            }
            g2 = p.h().g();
            h2 = p.h().h();
            v = i.d().v();
            jSONObject = jSONObject3;
        } catch (Exception unused4) {
            return jSONObject3;
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", ak.e());
            jSONObject.put("version_code", ak.f());
            jSONObject.put("version", ak.g());
        } catch (Exception unused) {
        }
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, "keywords", i.d().k());
            JSONArray a2 = com.bytedance.sdk.openadsdk.utils.q.a(this.f28267c);
            if (a2 != null) {
                jSONObject.put("app_list", a2);
            }
            a(jSONObject, "data", i.d().l());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void d(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(this.f28267c);
        if (a2 != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", a2.f30082a);
                jSONObject2.put("longitude", a2.f30083b);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private String b(List<FilterWord> list) {
        if (list.get(0).getId().equals("0:00")) {
            return list.get(0).getName();
        }
        return null;
    }

    private String f(String str) {
        String a2 = com.bytedance.sdk.openadsdk.core.a.a(str);
        if (str == null) {
            String a3 = com.bytedance.sdk.openadsdk.core.b.a();
            return a3.concat(a3).substring(8, 24);
        }
        return a2;
    }

    private boolean b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.optString("message").equalsIgnoreCase("success");
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    private JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", i.d().g());
            jSONObject.put("name", i.d().i());
            c(jSONObject);
            d(jSONObject);
            jSONObject.put("is_paid_app", i.d().j());
            jSONObject.put("apk_sign", s.a().c());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.d.m mVar) {
        JSONArray jSONArray;
        if (mVar != null && (jSONArray = mVar.f27881d) != null) {
            try {
                jSONObject.put("source_temai_product_ids", jSONArray);
            } catch (Exception unused) {
            }
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.r rVar) {
        this.f28266a = rVar;
    }

    private boolean a(String str) {
        if (com.bytedance.sdk.openadsdk.core.b.b.a()) {
            return true;
        }
        if (com.bytedance.sdk.openadsdk.core.b.b.a(str)) {
            String b2 = com.bytedance.sdk.openadsdk.core.b.b.b();
            if (!TextUtils.isEmpty(b2)) {
                com.bytedance.sdk.openadsdk.c.d.a(this.f28267c, b2, System.currentTimeMillis());
            }
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
        e.a().c();
        com.bytedance.sdk.openadsdk.l.e.a(new com.bytedance.sdk.openadsdk.l.g("getAd") { // from class: com.bytedance.sdk.openadsdk.core.r.1
            @Override // java.lang.Runnable
            public void run() {
                m.b().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.r.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.openadsdk.core.h.f.a((com.bytedance.sdk.openadsdk.core.h.c) null).c();
                    }
                }, 10000L);
                com.bytedance.sdk.openadsdk.core.h.d.a().b();
                com.bytedance.sdk.openadsdk.core.h.b.a().b();
            }
        }, 10);
        if (bVar == null) {
            return;
        }
        if (a(adSlot.getCodeId())) {
            bVar.a(-8, h.a(-8));
        } else if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
            com.bytedance.sdk.openadsdk.utils.u.a("bidding", "getAd bidAdm有效，则直接解析返回广告：BidAdm->MD5->", com.bytedance.sdk.openadsdk.k.g.b.a(adSlot.getBidAdm()));
            try {
                JSONObject e2 = e(new JSONObject(adSlot.getBidAdm()));
                if (e2 == null) {
                    a(bVar);
                    return;
                }
                a a2 = a.a(e2, adSlot, mVar);
                k.a(this.f28267c, a2.i);
                if (a2.f28300d != 20000) {
                    bVar.a(a2.f28300d, a2.f28301e);
                } else if (a2.f28304h == null) {
                    a(bVar);
                } else {
                    a2.f28304h.c(e2.toString());
                    bVar.a(a2.f28304h);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.c("NetApiImpl", "get ad error: ", th);
                a(bVar);
            }
        } else {
            final JSONObject a3 = a(adSlot, mVar, i, false);
            if (a3 == null) {
                bVar.a(-9, h.a(-9));
                return;
            }
            String l2 = ak.l("/api/ad/union/sdk/get_ads/");
            try {
                boolean b2 = b(adSlot.getExtraSmartLookParam());
                com.bytedance.sdk.openadsdk.utils.u.c("TTMediationSDK", "获取到的smartlook信息：isSmartLook=", Boolean.valueOf(b2), "，type=", Integer.valueOf(i));
                if (b2 && !TextUtils.isEmpty(f28264b)) {
                    if (i == 4) {
                        return;
                    }
                    l2 = f28264b;
                }
                l = l2;
            } catch (Throwable unused) {
                l = ak.l("/api/ad/union/sdk/get_ads/");
            }
            d.c.c.b.b.f fVar = new d.c.c.b.b.f(1, l, a3, new o.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.r.2
                @Override // d.c.c.b.d.o.a
                public void a(d.c.c.b.d.o<JSONObject> oVar) {
                    long j;
                    boolean z;
                    System.currentTimeMillis();
                    try {
                        j = ((Long) oVar.d("extra_time_start")).longValue();
                        z = true;
                    } catch (Throwable unused2) {
                        j = 0;
                        z = false;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject e3 = r.this.e(oVar.f66584a);
                    if (e3 == null) {
                        r.this.a(bVar);
                        r.this.a(oVar.f66588e, adSlot.getCodeId(), i, null, -1, "mate parse_fail");
                        return;
                    }
                    try {
                        a a4 = a.a(e3, adSlot, mVar);
                        k.a(r.this.f28267c, a4.i);
                        if (a4.f28300d != 20000) {
                            bVar.a(a4.f28300d, a4.f28301e);
                            r.this.a(oVar.f66588e, adSlot.getCodeId(), i, a4, a4.f28300d, String.valueOf(a4.f28302f));
                        } else if (a4.f28304h == null) {
                            r.this.a(bVar);
                            r.this.a(oVar.f66588e, adSlot.getCodeId(), i, a4, -1, "parse_fail");
                        } else {
                            a4.f28304h.c(e3.toString());
                            long currentTimeMillis2 = System.currentTimeMillis();
                            bVar.a(a4.f28304h);
                            Map<String, com.bytedance.sdk.openadsdk.core.d.l> a5 = com.bytedance.sdk.openadsdk.core.d.a.a(a4.f28304h);
                            if (a5 != null) {
                                com.bytedance.sdk.openadsdk.d.a.a().a(a5);
                            }
                            if (!z || a4.f28304h.c() == null || a4.f28304h.c().isEmpty()) {
                                return;
                            }
                            r.this.a(mVar, j, currentTimeMillis, a4, currentTimeMillis2, a4.f28304h.c().get(0), ak.b(i));
                            r.this.a(j - mVar.f27883f, a4.f28297a, currentTimeMillis - j, currentTimeMillis2 - currentTimeMillis);
                        }
                    } catch (Throwable th2) {
                        com.bytedance.sdk.openadsdk.utils.u.c("NetApiImpl", "get ad error: ", th2);
                        r.this.a(bVar);
                        r.this.a(oVar.f66588e, adSlot.getCodeId(), i, null, -1, "parse_fail");
                    }
                }

                @Override // d.c.c.b.d.o.a
                public void b(d.c.c.b.d.o<JSONObject> oVar) {
                    int i2;
                    VAdError vAdError = oVar.f66586c;
                    if (!(vAdError instanceof com.bytedance.sdk.adnet.err.e)) {
                        String a4 = h.a(-2);
                        if (vAdError == null || oVar == null) {
                            i2 = -2;
                        } else {
                            a4 = vAdError.getMessage();
                            i2 = (int) oVar.f66591h;
                        }
                        bVar.a(i2, a4);
                        r.this.a(oVar.f66588e, adSlot.getCodeId(), i, null, i2, vAdError instanceof com.bytedance.sdk.adnet.err.g ? "SocketTimeout" : a4);
                        return;
                    }
                    r.this.a(bVar);
                    r.this.a(oVar.f66588e, adSlot.getCodeId(), i, null, -1, h.a(-1));
                }
            }) { // from class: com.bytedance.sdk.openadsdk.core.r.3
                @Override // com.bytedance.sdk.adnet.core.Request
                public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                    HashMap hashMap = new HashMap();
                    hashMap.put("ss-sign", s.a().c(a3.toString()));
                    return hashMap;
                }

                @Override // com.bytedance.sdk.adnet.core.Request
                public Request.b getPriority() {
                    int i2 = i;
                    if (i2 != 4 && i2 != 3) {
                        return super.getPriority();
                    }
                    return Request.b.IMMEDIATE;
                }
            };
            d.c.c.b.d.g b3 = com.bytedance.sdk.openadsdk.i.e.b();
            b3.b(a(i));
            b3.c(0);
            fVar.setRetryPolicy(b3).setUserAgent(ak.b()).setShouldCache(false).addExtra("extra_time_start", Long.valueOf(System.currentTimeMillis())).build(com.bytedance.sdk.openadsdk.i.e.c().f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.core.d.m mVar, long j, long j2, a aVar, long j3, com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        if (p.h().v()) {
            JSONObject jSONObject = new JSONObject();
            long j4 = 0;
            if (mVar != null) {
                try {
                    if (mVar.f27883f > 0) {
                        jSONObject.put("client_start_time", j - mVar.f27883f);
                        j4 = j3 - mVar.f27883f;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            jSONObject.put("network_time", j2 - j);
            jSONObject.put("sever_time", aVar.f28297a);
            jSONObject.put("client_end_time", j3 - j2);
            try {
                com.bytedance.sdk.openadsdk.c.d.a(this.f28267c, lVar, str, "load_ad_time", j4, jSONObject);
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2, long j3, long j4) {
        com.bytedance.sdk.openadsdk.core.d.r rVar = this.f28266a;
        if (rVar == null) {
            return;
        }
        rVar.d(j);
        this.f28266a.e(j3);
        this.f28266a.f(j2);
        this.f28266a.g(j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final int i, final a aVar, final int i2, final String str2) {
        if (com.bytedance.sdk.openadsdk.core.h.g.a()) {
            if (i == 4 || i == 3) {
                com.bytedance.sdk.openadsdk.l.e.a(new com.bytedance.sdk.openadsdk.l.g("uploadAdTypeTimeOutEvent") { // from class: com.bytedance.sdk.openadsdk.core.r.4
                    @Override // java.lang.Runnable
                    public void run() {
                        String str3;
                        String str4;
                        int i3 = i2;
                        com.bytedance.sdk.openadsdk.h.a.b g2 = new com.bytedance.sdk.openadsdk.h.a.b().a(i).b(i3).g(TextUtils.isEmpty(str2) ? h.a(i3) : str2);
                        com.bytedance.sdk.openadsdk.core.d.l lVar = null;
                        try {
                            if (aVar == null || aVar.f28304h == null || aVar.f28304h.c() == null || aVar.f28304h.c().size() <= 0) {
                                str3 = "";
                                str4 = str3;
                            } else {
                                lVar = aVar.f28304h.c().get(0);
                                str3 = lVar.ap();
                                if (!TextUtils.isEmpty(str3)) {
                                    try {
                                        str4 = new JSONObject(str3).getString(IAdRequestParam.REQ_ID);
                                    } catch (Throwable unused) {
                                    }
                                }
                                str4 = "";
                            }
                            if (TextUtils.isEmpty(str4) && aVar != null && aVar.f28304h != null) {
                                str4 = aVar.f28304h.a();
                            }
                            g2.f(str4).d(lVar != null ? lVar.am() : "").h(str3).c(str).a(j).b(aVar != null ? aVar.f28297a : 0L);
                        } catch (Throwable th) {
                            com.bytedance.sdk.openadsdk.utils.u.c("NetApiImpl", "uploadAdTypeTimeOutEvent throws exception ", th);
                        }
                        com.bytedance.sdk.openadsdk.h.a.a().e(g2);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    @WorkerThread
    public com.bytedance.sdk.openadsdk.c.h a(List<com.bytedance.sdk.openadsdk.c.a> list) {
        try {
            d.c.c.b.d.o oVar = null;
            if (com.bytedance.sdk.openadsdk.core.h.g.a()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    a(list.get(0));
                    jSONObject.put("header", f());
                    JSONArray jSONArray = new JSONArray();
                    for (com.bytedance.sdk.openadsdk.c.a aVar : list) {
                        jSONArray.put(aVar.f27221b);
                    }
                    jSONObject.put("event", jSONArray);
                    jSONObject.put("_gen_time", System.currentTimeMillis());
                } catch (JSONException unused) {
                }
                String a2 = com.bytedance.sdk.openadsdk.core.a.a(jSONObject.toString(), com.bytedance.sdk.openadsdk.core.b.b());
                if (!c(a2)) {
                    a2 = jSONObject.toString();
                }
                if (com.bytedance.sdk.openadsdk.utils.u.c()) {
                    com.bytedance.sdk.openadsdk.utils.u.b("adevent", "adevent is :" + jSONObject.toString());
                }
                final Map<String, String> e2 = e(a2);
                d.c.c.b.b.i c2 = d.c.c.b.b.i.c();
                d.c.c.b.b.f fVar = new d.c.c.b.b.f(1, ak.h(), a2, c2) { // from class: com.bytedance.sdk.openadsdk.core.r.5
                    @Override // com.bytedance.sdk.adnet.core.Request
                    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                        return e2;
                    }
                };
                d.c.c.b.d.g b2 = com.bytedance.sdk.openadsdk.i.e.b();
                b2.b(10000);
                fVar.setRetryPolicy(b2).setUserAgent(ak.b()).build(com.bytedance.sdk.openadsdk.i.e.c().e());
                try {
                    oVar = c2.get();
                } catch (Throwable unused2) {
                }
                boolean z = true;
                boolean z2 = oVar != null && b((JSONObject) oVar.f66584a);
                String str = "error unknown";
                int i = oVar != null ? (int) oVar.f66591h : 0;
                if (z2 || i != 200) {
                    if (oVar != null && oVar.f66586c != null) {
                        str = oVar.f66586c.getMessage();
                    }
                    z = false;
                } else {
                    str = "server say not success";
                }
                d(a2);
                return new com.bytedance.sdk.openadsdk.c.h(z2, i, str, z);
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.u.c("NetApiImpl", "uploadEvent error", th);
            return new com.bytedance.sdk.openadsdk.c.h(false, 509, "service_busy", false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(@NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, List<FilterWord> list) {
        JSONObject b2;
        if (com.bytedance.sdk.openadsdk.core.h.g.a() && (b2 = b(lVar, list)) != null) {
            d.c.c.b.b.h hVar = new d.c.c.b.b.h(1, ak.l("/api/ad/union/dislike_event/"), ak.a(b2), null);
            d.c.c.b.d.g b3 = com.bytedance.sdk.openadsdk.i.e.b();
            b3.b(10000);
            hVar.setRetryPolicy(b3).build(com.bytedance.sdk.openadsdk.i.e.c().e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q.b bVar) {
        bVar.a(-1, h.a(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q.c cVar) {
        cVar.a(-1, h.a(-1));
    }

    private void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x014b, code lost:
        if (r15.f27881d == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x014d, code lost:
        r9 = r13.getAdCount();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
            if ((i == 3 || i == 4) && mVar != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("publisher_timeout_control", mVar.f27884g);
                jSONObject4.put("time_out_control", mVar.f27885h);
                jSONObject4.put("time_out", mVar.i);
                jSONObject2.put("splash_time", jSONObject4);
            }
            int i2 = 1;
            if (mVar != null) {
                if (i == 3 || i == 4) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("publisher_timeout_control", mVar.f27884g);
                    jSONObject5.put("time_out_control", mVar.f27885h);
                    jSONObject5.put("time_out", mVar.i);
                    jSONObject2.put("tmax", jSONObject5);
                }
                jSONObject2.put("render_method", mVar.f27882e);
                if (mVar.f27882e == 1) {
                    a(jSONObject2, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
                } else if (mVar.f27882e == 2) {
                    a(jSONObject2, "accepted_size", adSlot.getExpressViewAcceptedWidth(), adSlot.getExpressViewAcceptedHeight());
                }
            } else {
                jSONObject2.put("render_method", 1);
                a(jSONObject2, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            }
            jSONObject2.put("ptpl_ids", p.h().h(adSlot.getCodeId()));
            jSONObject2.put(IAdRequestParam.POS, AdSlot.getPosition(i));
            jSONObject2.put("is_support_dpl", adSlot.isSupportDeepLink());
            jSONObject2.put("if_support_render_control", adSlot.isSupportRenderConrol() ? 1 : 0);
            if (adSlot.getNativeAdType() > 0 || i == 9 || i == 5) {
                jSONObject2.put("is_origin_ad", true);
            }
            if (mVar != null && mVar.j != null) {
                jSONObject2.put("session_params", mVar.j);
            }
            int adCount = adSlot.getAdCount();
            if (i != 7 && i != 8) {
                i2 = adCount;
            }
            jSONObject2.put("ad_count", i2);
            String k = ak.k(adSlot.getExtraSmartLookParam());
            JSONObject jSONObject6 = TextUtils.isEmpty(k) ? null : new JSONObject(k);
            if (jSONObject6 != null && (jSONObject = jSONObject6.getJSONObject("smart_look")) != null && !TextUtils.isEmpty(jSONObject.toString())) {
                jSONObject2.put("smart_look", jSONObject);
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    private void a(JSONObject jSONObject, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i);
            jSONObject2.put("height", i2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void a(JSONObject jSONObject, String str, float f2, float f3) {
        if (f2 <= 0.0f || f3 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", (int) f2);
            jSONObject2.put("height", (int) f3);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void a(com.bytedance.sdk.openadsdk.c.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || (jSONObject = aVar.f27221b) == null) {
            return;
        }
        String optString = jSONObject.optString("log_extra", "");
        long e2 = ak.e(optString);
        int f2 = ak.f(optString);
        if (e2 == 0) {
            e2 = this.f28270f;
        }
        this.f28270f = e2;
        if (f2 == 0) {
            f2 = this.f28271g;
        }
        this.f28271g = f2;
    }

    public static String a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(JSONObject jSONObject, final q.c cVar) {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            if (cVar != null) {
                cVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else if (jSONObject == null || cVar == null) {
        } else {
            d.c.c.b.b.f fVar = new d.c.c.b.b.f(1, ak.l("/api/ad/union/sdk/reward_video/reward/"), ak.a(jSONObject), new o.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.r.7
                @Override // d.c.c.b.d.o.a
                public void a(d.c.c.b.d.o<JSONObject> oVar) {
                    JSONObject jSONObject2;
                    if (oVar != null && (jSONObject2 = oVar.f66584a) != null) {
                        int optInt = jSONObject2.optInt("cypher", -1);
                        String optString = oVar.f66584a.optString("message");
                        JSONObject jSONObject3 = oVar.f66584a;
                        String str = null;
                        if (optInt == 1) {
                            str = com.bytedance.sdk.openadsdk.core.a.b(optString, com.bytedance.sdk.openadsdk.core.b.a());
                        } else if (optInt == 2) {
                            str = ak.k(optString);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                jSONObject3 = new JSONObject(str);
                            } catch (Throwable unused) {
                            }
                        }
                        c a2 = c.a(jSONObject3);
                        int i = a2.f28307a;
                        if (i != 20000) {
                            cVar.a(i, h.a(i));
                            return;
                        } else if (a2.f28309c == null) {
                            r.this.a(cVar);
                            return;
                        } else {
                            cVar.a(a2);
                            return;
                        }
                    }
                    r.this.a(cVar);
                }

                @Override // d.c.c.b.d.o.a
                public void b(d.c.c.b.d.o<JSONObject> oVar) {
                    VAdError vAdError;
                    String a2 = h.a(-2);
                    int i = oVar != null ? (int) oVar.f66591h : -2;
                    if (oVar != null && (vAdError = oVar.f66586c) != null && !TextUtils.isEmpty(vAdError.getMessage())) {
                        a2 = oVar.f66586c.getMessage();
                    }
                    cVar.a(i, a2);
                }
            });
            d.c.c.b.d.g b2 = com.bytedance.sdk.openadsdk.i.e.b();
            b2.b(10000);
            fVar.setRetryPolicy(b2).build(com.bytedance.sdk.openadsdk.i.e.c().e());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public String a(AdSlot adSlot, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.d.m mVar = new com.bytedance.sdk.openadsdk.core.d.m();
        if (7 == adSlot.getAdType()) {
            mVar.f27879b = 1;
        } else if (8 == adSlot.getAdType()) {
            mVar.f27880c = 1;
        } else if (3 == adSlot.getAdType()) {
            mVar.f27883f = System.currentTimeMillis();
        }
        if (p.h().i(adSlot.getCodeId())) {
            mVar.f27882e = 2;
        }
        if (z) {
            mVar.f27882e = 2;
            if (i == 1 || i == 2) {
                adSlot.setNativeAdType(i);
            }
        }
        if (5 == adSlot.getNativeAdType() || 1 == adSlot.getNativeAdType() || 2 == adSlot.getNativeAdType()) {
            mVar.f27882e = 2;
        }
        if (adSlot.getAdType() > 0) {
            adSlot.getAdType();
        }
        JSONObject a2 = a(adSlot, mVar, adSlot.getAdType(), true);
        com.bytedance.sdk.openadsdk.utils.u.b("token", "requestBody=", a2);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("ss-sign", s.a().c(a2.toString()));
            jSONObject2.putOpt("User-Agent", ak.b());
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("bid_request", a2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.utils.u.b("token", "message=", jSONObject);
        String k = k();
        String str = 2 + k + com.bytedance.sdk.openadsdk.core.a.a(jSONObject.toString(), f(k));
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("message", str);
            jSONObject3.put("cypher", 2);
            com.bytedance.sdk.openadsdk.utils.u.b("token", "result=", jSONObject3.toString());
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return "0000000002" + str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public String a(AdSlot adSlot) {
        return a(adSlot, false, -1);
    }

    private JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            String a2 = com.bytedance.sdk.openadsdk.core.a.a(str, com.bytedance.sdk.openadsdk.core.b.a());
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            String upperCase = com.bytedance.sdk.openadsdk.utils.j.a("id=" + a2 + "&timestamp=" + currentTimeMillis + "&ext=" + str2).toUpperCase();
            jSONObject.put("id", a2);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("sign", upperCase);
            jSONObject.put("ext", str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(String str, String str2, final q.a aVar) {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            if (aVar != null) {
                aVar.a(false, -1L, 0L);
            }
        } else if (str == null || str2 == null || aVar == null) {
        } else {
            d.c.c.b.b.f fVar = new d.c.c.b.b.f(1, ak.l("/api/ad/union/sdk/material/check/"), ak.a(a(str, str2)), new o.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.r.8
                @Override // d.c.c.b.d.o.a
                public void a(d.c.c.b.d.o<JSONObject> oVar) {
                    long j;
                    long j2;
                    boolean z;
                    JSONObject jSONObject = oVar.f66584a;
                    if (jSONObject != null) {
                        b a2 = b.a(jSONObject);
                        long j3 = oVar.f66589f;
                        z = a2.f28306b;
                        j = a2.f28305a;
                        j2 = j3;
                    } else {
                        j = -1;
                        j2 = 0;
                        z = false;
                    }
                    aVar.a(z, j, j2);
                }

                @Override // d.c.c.b.d.o.a
                public void b(d.c.c.b.d.o<JSONObject> oVar) {
                    long j = oVar.f66591h;
                    if (j == 0) {
                        j = -1;
                    }
                    aVar.a(false, j, oVar.f66589f);
                }
            });
            d.c.c.b.d.g b2 = com.bytedance.sdk.openadsdk.i.e.b();
            b2.b(800);
            fVar.setRetryPolicy(b2).build(com.bytedance.sdk.openadsdk.i.e.c().e());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public com.bytedance.sdk.openadsdk.c.h a(JSONObject jSONObject) {
        int i;
        boolean z;
        int i2;
        d.c.c.b.d.o oVar;
        if (com.bytedance.sdk.openadsdk.core.h.g.a() && jSONObject != null && jSONObject.length() > 0) {
            d.c.c.b.b.i c2 = d.c.c.b.b.i.c();
            boolean z2 = true;
            d.c.c.b.b.f fVar = new d.c.c.b.b.f(1, ak.l("/api/ad/union/sdk/stats/batch/"), ak.a(jSONObject), c2);
            d.c.c.b.d.g b2 = com.bytedance.sdk.openadsdk.i.e.b();
            b2.b(10000);
            fVar.setRetryPolicy(b2).setUserAgent(ak.b()).build(com.bytedance.sdk.openadsdk.i.e.c().e());
            String str = "error unknown";
            boolean z3 = false;
            try {
                oVar = c2.get();
            } catch (Throwable unused) {
                i = 0;
                z2 = false;
            }
            if (oVar == null) {
                return new com.bytedance.sdk.openadsdk.c.h(false, 0, "error unknown", false);
            }
            if (oVar.f66584a != 0) {
                int optInt = ((JSONObject) oVar.f66584a).optInt("code", -1);
                str = ((JSONObject) oVar.f66584a).optString("data", "");
                z = optInt == 20000;
                if (optInt != 60005) {
                    z2 = false;
                }
            } else {
                z2 = false;
                z = false;
            }
            try {
                i2 = (int) oVar.f66591h;
            } catch (Throwable unused2) {
                z3 = z;
                i = 0;
            }
            try {
                if (oVar.f66586c != null) {
                    str = oVar.f66586c.getMessage();
                }
            } catch (Throwable unused3) {
                i = i2;
                z3 = z;
                z = z3;
                i2 = i;
                return new com.bytedance.sdk.openadsdk.c.h(z, i2, str, z2);
            }
            return new com.bytedance.sdk.openadsdk.c.h(z, i2, str, z2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public boolean a(JSONObject jSONObject, int i) {
        if (com.bytedance.sdk.openadsdk.core.h.g.a()) {
            if (jSONObject == null || jSONObject.length() <= 0) {
                return true;
            }
            d.c.c.b.b.i c2 = d.c.c.b.b.i.c();
            d.c.c.b.b.f fVar = new d.c.c.b.b.f(1, aj.b("https://i.snssdk.com/inspect/aegis/client/page/"), jSONObject, c2);
            d.c.c.b.d.g b2 = com.bytedance.sdk.openadsdk.i.e.b();
            b2.b(10000);
            b2.c(i);
            fVar.setRetryPolicy(b2).build(com.bytedance.sdk.openadsdk.i.e.c().e());
            try {
                d.c.c.b.d.o oVar = c2.get();
                if (oVar == null || oVar.f66584a == 0) {
                    return false;
                }
                return "success".equals(((JSONObject) oVar.f66584a).optString("status", "success"));
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public com.bytedance.sdk.openadsdk.core.d.s a() {
        d.c.c.b.d.o oVar;
        if (com.bytedance.sdk.openadsdk.core.h.g.a()) {
            d.c.c.b.b.i c2 = d.c.c.b.b.i.c();
            d.c.c.b.b.j jVar = new d.c.c.b.b.j(0, aj.b(p.h().z()), c2);
            d.c.c.b.d.g b2 = com.bytedance.sdk.openadsdk.i.e.b();
            b2.b(10000);
            jVar.setRetryPolicy(b2).setShouldCache(false).build(com.bytedance.sdk.openadsdk.i.e.c().e());
            try {
                oVar = c2.get();
            } catch (Exception unused) {
                oVar = null;
            }
            if (oVar == null || !oVar.f()) {
                return null;
            }
            return com.bytedance.sdk.openadsdk.core.d.s.e((String) oVar.f66584a);
        }
        return null;
    }
}
