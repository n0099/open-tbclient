package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.ala.helper.AlaConstants;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.am;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class x implements com.bytedance.sdk.openadsdk.e.b, am.a {
    private static final Map<String, Boolean> f = new ConcurrentHashMap();
    private List<com.bytedance.sdk.openadsdk.core.d.l> B;
    private HashMap<String, j> C;
    private com.bytedance.sdk.openadsdk.c.p F;
    private com.bytedance.sdk.openadsdk.f.a.q G;

    /* renamed from: a  reason: collision with root package name */
    protected Map<String, Object> f7146a;

    /* renamed from: b  reason: collision with root package name */
    boolean f7147b;
    private WeakReference<SSWebView> d;
    private WeakReference<Context> g;
    private com.bytedance.sdk.openadsdk.e.c h;
    private String i;
    private WeakReference<View> j;
    private String k;
    private int l;
    private String m;
    private com.bytedance.sdk.openadsdk.core.d.l n;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.j p;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.g q;
    private JSONObject r;
    private com.bytedance.sdk.openadsdk.e.d s;
    private com.bytedance.sdk.openadsdk.g.a t;
    private com.bytedance.sdk.openadsdk.g.e u;
    private com.bytedance.sdk.openadsdk.g.d v;
    private JSONObject w;
    private com.bytedance.sdk.openadsdk.core.a.d x;
    private com.bytedance.sdk.openadsdk.g.b y;
    private com.bytedance.sdk.openadsdk.g.h z;
    private boolean o = true;
    private boolean A = true;
    private boolean D = false;
    private boolean E = false;
    boolean c = false;
    private am e = new am(Looper.getMainLooper(), this);

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f7160a;

        /* renamed from: b  reason: collision with root package name */
        public String f7161b;
        public String c;
        public JSONObject d;
        public int e;
    }

    static {
        f.put("log_event", Boolean.TRUE);
        f.put(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, Boolean.TRUE);
        f.put("dispatch_message", Boolean.TRUE);
        f.put("custom_event", Boolean.TRUE);
        f.put("log_event_v3", Boolean.TRUE);
    }

    public x(Context context) {
        this.g = new WeakReference<>(context);
    }

    public x a(SSWebView sSWebView) {
        this.G = com.bytedance.sdk.openadsdk.f.a.q.a(sSWebView).a("ToutiaoJSBridge").a(new com.bytedance.sdk.openadsdk.f.a.l() { // from class: com.bytedance.sdk.openadsdk.core.x.1
            @Override // com.bytedance.sdk.openadsdk.f.a.l
            @NonNull
            public <T> T a(@NonNull String str, @NonNull Type type) {
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.f.a.l
            @NonNull
            public <T> String a(@NonNull T t) {
                return null;
            }
        }).a(i.c().u()).b(true).a().b();
        com.bytedance.sdk.openadsdk.f.b.b.a(this.G, this);
        com.bytedance.sdk.openadsdk.f.b.a.a(this.G, this);
        com.bytedance.sdk.openadsdk.f.b.d.a(this.G);
        com.bytedance.sdk.openadsdk.f.b.c.a(this.G, sSWebView);
        return this;
    }

    private WebView j() {
        if (this.d != null) {
            return this.d.get();
        }
        return null;
    }

    public x b(SSWebView sSWebView) {
        this.d = new WeakReference<>(sSWebView);
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.c.p pVar) {
        this.F = pVar;
        return this;
    }

    public x a(boolean z) {
        this.f7147b = z;
        return this;
    }

    public x b(boolean z) {
        this.E = z;
        return this;
    }

    public x a(String str) {
        this.i = str;
        return this;
    }

    public x a(View view) {
        this.j = new WeakReference<>(view);
        return this;
    }

    private JSONObject k() {
        JSONObject jSONObject;
        try {
            View view = this.j.get();
            SSWebView sSWebView = this.d.get();
            if (view == null || sSWebView == null) {
                com.bytedance.sdk.openadsdk.utils.u.f("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
                jSONObject = null;
            } else {
                int[] b2 = ak.b(view);
                int[] b3 = ak.b((View) sSWebView);
                if (b2 == null || b3 == null) {
                    com.bytedance.sdk.openadsdk.utils.u.f("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
                    jSONObject = null;
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("x", ak.b(p.a(), b2[0] - b3[0]));
                    jSONObject2.put("y", ak.b(p.a(), b2[1] - b3[1]));
                    jSONObject2.put("w", ak.b(p.a(), view.getWidth()));
                    jSONObject2.put("h", ak.b(p.a(), view.getHeight()));
                    jSONObject2.put("isExist", ak.e(view));
                    jSONObject = jSONObject2;
                }
            }
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.u.a("TTAndroidObject", "setCloseButtonInfo error", th);
            return null;
        }
    }

    public x a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.n = lVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.g.b bVar) {
        this.y = bVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.g.h hVar) {
        this.z = hVar;
        return this;
    }

    public com.bytedance.sdk.openadsdk.core.d.l a() {
        return this.n;
    }

    public boolean b() {
        return this.n != null && this.n.b();
    }

    public x b(String str) {
        this.k = str;
        return this;
    }

    public x a(int i) {
        this.l = i;
        return this;
    }

    public x c(String str) {
        this.m = str;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar) {
        this.p = jVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.core.nativeexpress.g gVar) {
        this.q = gVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.e.d dVar) {
        this.s = dVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.core.a.d dVar) {
        this.x = dVar;
        return this;
    }

    public x c(boolean z) {
        this.A = z;
        return this;
    }

    public x a(JSONObject jSONObject) {
        this.r = jSONObject;
        return this;
    }

    public x b(JSONObject jSONObject) {
        this.w = jSONObject;
        return this;
    }

    public x a(Map<String, Object> map) {
        this.f7146a = map;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.g.a aVar) {
        this.t = aVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.g.e eVar) {
        this.u = eVar;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.g.d dVar) {
        this.v = dVar;
        return this;
    }

    public x a(List<com.bytedance.sdk.openadsdk.core.d.l> list) {
        this.B = list;
        return this;
    }

    public boolean c() {
        return this.c;
    }

    private List<String> l() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    private void a(JSONObject jSONObject, int i) throws Exception {
        JSONArray jSONArray = new JSONArray();
        for (String str : l()) {
            jSONArray.put(str);
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.a.a.a());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.a.a.e());
        jSONObject.put("aid", com.bytedance.sdk.openadsdk.a.a.b());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.a.a.c());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.a.a.d());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.a.a.f());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.a.a.a(p.a()));
    }

    private void c(JSONObject jSONObject) throws Exception {
        if (!TextUtils.isEmpty(this.i)) {
            jSONObject.put(IXAdRequestInfo.CELL_ID, this.i);
        }
        if (!TextUtils.isEmpty(this.k)) {
            jSONObject.put("log_extra", this.k);
        }
        if (!TextUtils.isEmpty(this.m)) {
            jSONObject.put("download_url", this.m);
        }
    }

    private void d(JSONObject jSONObject) throws Exception {
        if (this.n != null && !TextUtils.isEmpty(this.n.d())) {
            jSONObject.put("playable_style", this.n.d());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x028a, code lost:
        if (r0 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject a(a aVar, int i) throws Exception {
        char c;
        JSONObject jSONObject;
        Context context;
        Context context2;
        Context context3;
        int i2;
        if (!NotificationCompat.CATEGORY_CALL.equals(aVar.f7160a)) {
            return null;
        }
        if (i.c().u()) {
            Log.d("TTAndroidObject", "[JSB-REQ] version:" + i + " method:" + aVar.c + " params=" + (aVar.d != null ? aVar.d.toString() : ""));
        }
        JSONObject jSONObject2 = new JSONObject();
        String str = aVar.c;
        switch (str.hashCode()) {
            case -2036781162:
                if (str.equals("subscribe_app_ad")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1423303823:
                if (str.equals("adInfo")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1330994877:
                if (str.equals("pauseWebView")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case -1169135450:
                if (str.equals("changeVideoState")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case -844321441:
                if (str.equals("webview_time_track")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case -800853518:
                if (str.equals("clickEvent")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case -794273169:
                if (str.equals("appInfo")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -715147645:
                if (str.equals("getScreenSize")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -489318846:
                if (str.equals("getMaterialMeta")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case -278382602:
                if (str.equals("send_temai_product_ids")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case -173752734:
                if (str.equals("getTeMaiAds")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 27837080:
                if (str.equals("download_app_ad")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 105049135:
                if (str.equals("unsubscribe_app_ad")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 399543522:
                if (str.equals("getCloseButtonInfo")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 402955465:
                if (str.equals("isViewable")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 442647767:
                if (str.equals("sendReward")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 571273292:
                if (str.equals("dynamicTrack")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 650209982:
                if (str.equals("getTemplateInfo")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 672928467:
                if (str.equals("cancel_download_app_ad")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 711635577:
                if (str.equals("getCurrentVideoState")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 885131792:
                if (str.equals("getVolume")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1107374321:
                if (str.equals("pauseWebViewTimers")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case 1151744482:
                if (str.equals("muteVideo")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 1237100796:
                if (str.equals("renderDidFinish")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1532142616:
                if (str.equals("removeLoading")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 1634511418:
                if (str.equals("endcard_load")) {
                    c = JSONLexer.EOI;
                    break;
                }
                c = 65535;
                break;
            case 1713585602:
                if (str.equals("getNetworkData")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 1731806400:
                if (str.equals("playable_style")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2086000188:
                if (str.equals("skipVideo")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 2105008900:
                if (str.equals("landscape_click")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                a(jSONObject2, aVar.e);
                jSONObject = jSONObject2;
                break;
            case 1:
                c(jSONObject2);
                jSONObject = jSONObject2;
                break;
            case 2:
                d(jSONObject2);
                jSONObject = jSONObject2;
                break;
            case 3:
                if (this.r != null) {
                    this.r.put("setting", p());
                }
                jSONObject = this.r;
                break;
            case 4:
                if (this.w != null) {
                    jSONObject = this.w;
                    break;
                }
                jSONObject = jSONObject2;
                break;
            case 5:
                jSONObject2.put("viewStatus", this.E ? 1 : 0);
                jSONObject = jSONObject2;
                break;
            case 6:
                if (this.t != null) {
                    int b2 = this.t.b();
                    int a2 = this.t.a();
                    jSONObject2.put("width", b2);
                    jSONObject2.put("height", a2);
                    jSONObject = jSONObject2;
                    break;
                }
                jSONObject = jSONObject2;
                break;
            case 7:
                jSONObject = k();
                break;
            case '\b':
                AudioManager audioManager = (AudioManager) p.a().getSystemService("audio");
                if (audioManager != null) {
                    i2 = audioManager.getStreamVolume(3);
                    com.bytedance.sdk.openadsdk.utils.u.b("TTAndroidObject", "音乐音量 >>>> AudioManager-->currentVolume=" + i2);
                } else {
                    i2 = -1;
                }
                jSONObject2.put("endcard_mute", i2 <= 0);
                jSONObject = jSONObject2;
                break;
            case '\t':
                if (this.v != null) {
                    this.v.a();
                    jSONObject = jSONObject2;
                    break;
                }
                jSONObject = jSONObject2;
                break;
            case '\n':
                this.c = true;
                if (this.u != null) {
                    this.u.a();
                    jSONObject = jSONObject2;
                    break;
                }
                jSONObject = jSONObject2;
                break;
            case 11:
                s();
                if (this.g != null && (context3 = this.g.get()) != null) {
                    this.h.a(context3, aVar.d, this.k, this.l, this.o);
                    jSONObject = jSONObject2;
                    break;
                }
                jSONObject = jSONObject2;
                break;
            case '\f':
                if (this.x != null) {
                    this.x.a(this.A);
                    jSONObject = jSONObject2;
                    break;
                } else {
                    if (this.h != null) {
                        if (this.g != null && (context2 = this.g.get()) != null) {
                            this.h.a(context2, aVar.d);
                        }
                        jSONObject = jSONObject2;
                        break;
                    }
                    jSONObject = jSONObject2;
                    break;
                }
                break;
            case '\r':
                if (this.h != null) {
                }
                this.h.b(aVar.d);
                jSONObject = jSONObject2;
                break;
            case 14:
                if (this.h != null) {
                    this.h.a(aVar.d);
                    jSONObject = jSONObject2;
                    break;
                }
                jSONObject = jSONObject2;
                break;
            case 15:
                if (this.g != null && (context = this.g.get()) != null && (context instanceof com.bytedance.sdk.openadsdk.core.video.b.b)) {
                    ((com.bytedance.sdk.openadsdk.core.video.b.b) context).S();
                    jSONObject = jSONObject2;
                    break;
                }
                jSONObject = jSONObject2;
                break;
            case 16:
                j(aVar.d);
                jSONObject = jSONObject2;
                break;
            case 17:
                k(aVar.d);
                jSONObject = jSONObject2;
                break;
            case 18:
                l(aVar.d);
                jSONObject = jSONObject2;
                break;
            case 19:
                o();
                jSONObject = jSONObject2;
                break;
            case 20:
                g(aVar.d);
                jSONObject = jSONObject2;
                break;
            case 21:
                h(aVar.d);
                jSONObject = jSONObject2;
                break;
            case 22:
                i(jSONObject2);
                jSONObject = jSONObject2;
                break;
            case 23:
                m(aVar.d);
                jSONObject = jSONObject2;
                break;
            case 24:
                n(jSONObject2);
                jSONObject = jSONObject2;
                break;
            case 25:
                a(aVar, jSONObject2);
                jSONObject = jSONObject2;
                break;
            case 26:
                f(aVar.d);
                jSONObject = jSONObject2;
                break;
            case 27:
                m();
                jSONObject = jSONObject2;
                break;
            case 28:
                n();
                jSONObject = jSONObject2;
                break;
            case 29:
                e(aVar.d);
                jSONObject = jSONObject2;
                break;
            default:
                jSONObject = jSONObject2;
                break;
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.f7161b)) {
                b(aVar.f7161b, jSONObject);
                if (i.c().u()) {
                    Log.d("TTAndroidObject", "[JSB-RSP] version:" + i + " data=" + jSONObject);
                    return jSONObject;
                }
                return jSONObject;
            }
            return jSONObject;
        }
        if (i == 3) {
        }
        return jSONObject;
    }

    private void e(JSONObject jSONObject) {
        if (jSONObject != null && this.F != null) {
            this.F.b(jSONObject);
        }
    }

    private void a(String str, boolean z) {
        if (this.F != null && !TextUtils.isEmpty(str)) {
            if (z) {
                this.F.a(str);
            } else {
                this.F.b(str);
            }
        }
    }

    private void m() {
        if (this.z != null) {
            this.z.a();
        }
    }

    private void n() {
        if (this.z != null) {
            this.z.b();
        }
    }

    private void f(JSONObject jSONObject) {
        if (this.y != null && jSONObject != null) {
            this.y.a(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString("msg", ""));
        }
    }

    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            c(jSONObject);
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, 0);
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        a("getTemplateInfo", true);
        try {
            if (this.r != null) {
                this.r.put("setting", p());
            }
            a("getTemplateInfo", false);
            return this.r.toString();
        } catch (Exception e) {
            return "";
        }
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            k(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                g(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.x.2
                    @Override // java.lang.Runnable
                    public void run() {
                        x.this.g(jSONObject);
                    }
                });
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.utils.u.f("TTAndroidObject", "");
        }
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            l(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                h(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.x.3
                    @Override // java.lang.Runnable
                    public void run() {
                        x.this.h(jSONObject);
                    }
                });
            }
        } catch (Exception e) {
        }
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                j(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.x.4
                    @Override // java.lang.Runnable
                    public void run() {
                        x.this.j(jSONObject);
                    }
                });
            }
        } catch (Exception e) {
        }
    }

    @JavascriptInterface
    public void skipVideo() {
        o();
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        i(jSONObject);
        return jSONObject.toString();
    }

    private void o() {
        if (this.q != null) {
            this.q.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONObject jSONObject) {
        if (this.q != null && jSONObject != null) {
            try {
                this.q.e(jSONObject.optBoolean("mute", false));
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(JSONObject jSONObject) {
        if (this.q != null && jSONObject != null) {
            try {
                this.q.d(jSONObject.optInt("stateType", -1));
            } catch (Exception e) {
            }
        }
    }

    private boolean i(JSONObject jSONObject) {
        if (this.q == null || jSONObject == null) {
            return false;
        }
        double N = this.q.N();
        int O = this.q.O();
        try {
            jSONObject.put("currentTime", N / 1000.0d);
            jSONObject.put("state", O);
            com.bytedance.sdk.openadsdk.utils.u.b("TTAndroidObject", "currentTime,state:" + O);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private JSONObject p() {
        JSONObject jSONObject = new JSONObject();
        if (p.h() != null && jSONObject != null) {
            try {
                int d = aj.d(this.k);
                int g = p.h().g(String.valueOf(d));
                boolean b2 = p.h().b(String.valueOf(d));
                jSONObject.put("voice_control", p.h().b(d));
                jSONObject.put("rv_skip_time", g);
                jSONObject.put("fv_skip_show", b2);
                jSONObject.put("show_dislike", this.n != null && this.n.ak());
                jSONObject.put("video_adaptation", this.n != null ? this.n.f() : 0);
            } catch (Exception e) {
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONObject jSONObject) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("adId");
                int optInt = jSONObject.optInt("areaType", 1);
                JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
                if (optJSONObject == null) {
                    d = 0.0d;
                    d2 = 0.0d;
                    d3 = 0.0d;
                    d4 = 0.0d;
                    d5 = 0.0d;
                    d6 = 0.0d;
                    d7 = 0.0d;
                    d8 = 0.0d;
                    d9 = 0.0d;
                    d10 = 0.0d;
                } else {
                    d10 = optJSONObject.optDouble("down_x", 0.0d);
                    d9 = optJSONObject.optDouble("down_y", 0.0d);
                    d8 = optJSONObject.optDouble("up_x", 0.0d);
                    d7 = optJSONObject.optDouble("up_y", 0.0d);
                    d6 = optJSONObject.optDouble("down_time", 0.0d);
                    d5 = optJSONObject.optDouble("up_time", 0.0d);
                    d4 = optJSONObject.optDouble("button_x", 0.0d);
                    d3 = optJSONObject.optDouble("button_y", 0.0d);
                    double optDouble = optJSONObject.optDouble("button_width", 0.0d);
                    d = optJSONObject.optDouble("button_height", 0.0d);
                    d2 = optDouble;
                }
                com.bytedance.sdk.openadsdk.core.d.j a2 = new j.a().d((int) d10).c((int) d9).b((int) d8).a((int) d7).b((long) d6).a((long) d5).e((int) d4).f((int) d3).g((int) d2).h((int) d).a();
                if (this.p != null) {
                    this.p.a(optInt, a2);
                }
                a(optString, optInt, a2);
            } catch (Exception e) {
                if (this.p != null) {
                    this.p.a(-1, null);
                }
            }
        }
    }

    private void k(JSONObject jSONObject) {
        if (this.p != null && jSONObject != null) {
            com.bytedance.sdk.openadsdk.core.d.n nVar = new com.bytedance.sdk.openadsdk.core.d.n();
            try {
                boolean optBoolean = jSONObject.optBoolean("isRenderSuc");
                JSONObject optJSONObject = jSONObject.optJSONObject("AdSize");
                double d = 0.0d;
                double d2 = 0.0d;
                if (optJSONObject != null) {
                    d = optJSONObject.optDouble("width");
                    d2 = optJSONObject.optDouble("height");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject(AlaConstants.STAT_VIDEO_INFO);
                if (optJSONObject2 != null) {
                    double optDouble = optJSONObject2.optDouble("x");
                    double optDouble2 = optJSONObject2.optDouble("y");
                    double optDouble3 = optJSONObject2.optDouble("width");
                    double optDouble4 = optJSONObject2.optDouble("height");
                    nVar.c(optDouble);
                    nVar.d(optDouble2);
                    nVar.e(optDouble3);
                    nVar.f(optDouble4);
                }
                String optString = jSONObject.optString("message", h.a(101));
                int optInt = jSONObject.optInt("code", 101);
                nVar.a(optBoolean);
                nVar.a(d);
                nVar.b(d2);
                nVar.a(optString);
                nVar.a(optInt);
                this.p.a(nVar);
            } catch (Exception e) {
                nVar.a(101);
                nVar.a(h.a(101));
                this.p.a(nVar);
            }
        }
    }

    private void l(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Uri parse = Uri.parse(jSONObject.optString("trackData"));
                if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                    com.bytedance.sdk.openadsdk.utils.r.a(parse, this);
                }
            } catch (Exception e) {
            }
        }
    }

    private void m(JSONObject jSONObject) {
        if (jSONObject != null && this.s != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("temaiProductIds");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.s.a(true, optJSONArray);
                } else {
                    this.s.a(false, null);
                }
            } catch (Exception e) {
                this.s.a(false, null);
            }
        }
    }

    private boolean n(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", b(this.B));
        } catch (Exception e) {
        }
        return true;
    }

    private void a(final a aVar, final JSONObject jSONObject) {
        if (aVar != null) {
            try {
                a(aVar.d, new com.bytedance.sdk.openadsdk.g.c() { // from class: com.bytedance.sdk.openadsdk.core.x.5
                    @Override // com.bytedance.sdk.openadsdk.g.c
                    public void a(boolean z, List<com.bytedance.sdk.openadsdk.core.d.l> list) {
                        if (!z) {
                            x.this.b(aVar.f7161b, jSONObject);
                            return;
                        }
                        try {
                            jSONObject.put("creatives", x.b(list));
                            x.this.b(aVar.f7161b, jSONObject);
                        } catch (Exception e) {
                        }
                    }
                });
            } catch (Exception e) {
            }
        }
    }

    public void d() {
        a((JSONObject) null, new com.bytedance.sdk.openadsdk.g.c() { // from class: com.bytedance.sdk.openadsdk.core.x.6
            @Override // com.bytedance.sdk.openadsdk.g.c
            public void a(boolean z, List<com.bytedance.sdk.openadsdk.core.d.l> list) {
                x.this.B = list;
                x.this.q();
                x.this.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        SSWebView sSWebView;
        Context context;
        if (this.B != null && this.B.size() > 0) {
            this.C = new HashMap<>();
            if (this.d == null) {
                sSWebView = null;
            } else {
                sSWebView = this.d.get();
            }
            if (this.g != null && (context = this.g.get()) != null) {
                for (com.bytedance.sdk.openadsdk.core.d.l lVar : this.B) {
                    this.C.put(lVar.T(), new j(context, lVar, sSWebView));
                }
            }
        }
    }

    private void a(String str, int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        j jVar2;
        if (!TextUtils.isEmpty(str) && this.C != null && (jVar2 = this.C.get(str)) != null) {
            jVar2.a(i, jVar);
        }
    }

    public void a(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.g.c cVar) {
        if (cVar != null) {
            try {
                if (this.n == null || TextUtils.isEmpty(this.k)) {
                    cVar.a(false, null);
                    return;
                }
                int c = aj.c(this.k);
                AdSlot j = this.n.j();
                com.bytedance.sdk.openadsdk.core.d.m mVar = new com.bytedance.sdk.openadsdk.core.d.m();
                if (this.n.B() != null) {
                    mVar.e = 2;
                }
                JSONObject af = this.n.af();
                JSONObject jSONObject2 = af == null ? new JSONObject() : af;
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject2.put(next, jSONObject.opt(next));
                    }
                }
                mVar.g = jSONObject2;
                p.f().a(j, mVar, c, new q.b() { // from class: com.bytedance.sdk.openadsdk.core.x.7
                    @Override // com.bytedance.sdk.openadsdk.core.q.b
                    public void a(int i, String str) {
                        cVar.a(false, null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.q.b
                    public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                        if (aVar.c() != null && !aVar.c().isEmpty()) {
                            cVar.a(true, aVar.c());
                        } else {
                            cVar.a(false, null);
                        }
                    }
                });
            } catch (Exception e) {
            }
        }
    }

    public void e() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", b(this.B));
            a("materialMeta", jSONObject);
        } catch (Exception e) {
        }
    }

    public static JSONArray b(List<com.bytedance.sdk.openadsdk.core.d.l> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(list.get(i).am());
        }
        return jSONArray;
    }

    private boolean r() {
        if (this.n == null || this.n.af() == null || this.n.s() || this.D || this.n.af().optInt("parent_type") != 2) {
            return false;
        }
        int c = aj.c(this.k);
        if (c == 8 || c == 7) {
            this.D = true;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", BuyTBeanActivityConfig.CALLBACK);
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            o(jSONObject2);
        } catch (Exception e) {
        }
    }

    private void o(JSONObject jSONObject) {
        WebView j;
        if (jSONObject != null && (j = j()) != null) {
            String str = "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject.toString() + ")";
            com.bytedance.sdk.openadsdk.utils.t.a(j, str);
            if (com.bytedance.sdk.openadsdk.utils.u.a()) {
                com.bytedance.sdk.openadsdk.utils.u.a("TTAndroidObject", "js_msg " + str);
            }
        }
    }

    private void c(String str, JSONObject jSONObject) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("__msg_type", "event");
                jSONObject2.put("__event_id", str);
                if (jSONObject != null) {
                    jSONObject2.put("__params", jSONObject);
                }
                o(jSONObject2);
            }
        } catch (Exception e) {
        }
    }

    private void d(String str) {
        try {
            String str2 = new String(Base64.decode(str, 2));
            com.bytedance.sdk.openadsdk.utils.u.b("TTAndroidObject", str2);
            JSONArray jSONArray = new JSONArray(str2);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                a aVar = new a();
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        aVar.f7160a = optJSONObject.optString("__msg_type", null);
                        aVar.f7161b = optJSONObject.optString("__callback_id", null);
                        aVar.c = optJSONObject.optString("func");
                        aVar.d = optJSONObject.optJSONObject("params");
                        aVar.e = optJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable th) {
                }
                if (!TextUtils.isEmpty(aVar.f7160a) && !TextUtils.isEmpty(aVar.c)) {
                    Message obtainMessage = this.e.obtainMessage(11);
                    obtainMessage.obj = aVar;
                    this.e.sendMessage(obtainMessage);
                }
            }
        } catch (Exception e) {
            if (com.bytedance.sdk.openadsdk.utils.u.a()) {
                com.bytedance.sdk.openadsdk.utils.u.d("TTAndroidObject", "failed to parse jsbridge msg queue " + str);
            } else {
                com.bytedance.sdk.openadsdk.utils.u.d("TTAndroidObject", "failed to parse jsbridge msg queue");
            }
        }
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if ("bytedance".equals(uri.getScheme())) {
                return f.containsKey(uri.getHost());
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void b(@NonNull Uri uri) {
        long j;
        JSONObject jSONObject;
        long j2 = 0;
        try {
            String host = uri.getHost();
            if ("log_event".equals(host) || "custom_event".equals(host) || "log_event_v3".equals(host)) {
                String queryParameter = uri.getQueryParameter("category");
                String queryParameter2 = uri.getQueryParameter("tag");
                String queryParameter3 = uri.getQueryParameter("label");
                try {
                    j = Long.parseLong(uri.getQueryParameter("value"));
                } catch (Exception e) {
                    j = 0;
                }
                try {
                    j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
                } catch (Exception e2) {
                }
                String queryParameter4 = uri.getQueryParameter("extra");
                if (TextUtils.isEmpty(queryParameter4)) {
                    jSONObject = null;
                } else {
                    try {
                        jSONObject = new JSONObject(queryParameter4);
                    } catch (Exception e3) {
                        jSONObject = null;
                    }
                }
                if ("click".equals(queryParameter3)) {
                    jSONObject = p(jSONObject);
                }
                com.bytedance.sdk.openadsdk.c.d.a(queryParameter, e(queryParameter2), queryParameter3, j, j2, jSONObject);
            } else if (PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(host) || "dispatch_message".equals(host)) {
                f(uri.toString());
            } else {
                com.bytedance.sdk.openadsdk.utils.u.d("TTAndroidObject", "handlrUir: not match schema host");
            }
        } catch (Exception e4) {
            com.bytedance.sdk.openadsdk.utils.u.b("TTAndroidObject", "handleUri exception: ", e4);
        }
    }

    private JSONObject p(JSONObject jSONObject) {
        if (this.f7146a != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String optString = jSONObject.optString("ad_extra_data", null);
                JSONObject jSONObject3 = optString != null ? new JSONObject(optString) : jSONObject2;
                for (Map.Entry<String, Object> entry : this.f7146a.entrySet()) {
                    jSONObject3.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject3.toString());
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.utils.u.b(e.toString());
            }
        }
        return jSONObject;
    }

    public String f() {
        return aj.a(this.l);
    }

    private String e(String str) {
        if (this.p == null) {
            return aj.a(this.l);
        }
        return str;
    }

    private void f(String str) {
        int length;
        int indexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView j = j();
                    if (j != null) {
                        com.bytedance.sdk.openadsdk.utils.t.a(j, "javascript:ToutiaoJSBridge._fetchQueue()");
                    }
                } else if (str.startsWith("bytedance://private/setresult/") && (indexOf = str.indexOf(38, (length = "bytedance://private/setresult/".length()))) > 0) {
                    String substring = str.substring(length, indexOf);
                    String substring2 = str.substring(indexOf + 1);
                    if (substring.equals("SCENE_FETCHQUEUE") && substring2.length() > 0) {
                        d(substring2);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void g() {
        if (this.h != null) {
            this.h.a();
        }
        if (r()) {
            d();
        }
    }

    public void h() {
        if (this.h != null) {
            this.h.b();
        }
    }

    public void i() {
        if (this.h != null) {
            this.h.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        if (message != null) {
            switch (message.what) {
                case 11:
                    if (message.obj instanceof a) {
                        try {
                            a((a) message.obj, 1);
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void s() {
        if (this.h == null) {
            this.h = com.bytedance.sdk.openadsdk.e.a.a(this, this.n);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.b
    public void a(String str, JSONObject jSONObject) {
        c(str, jSONObject);
    }
}
