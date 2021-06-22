package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
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
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatJellybean;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.webkit.sdk.WebChromeClient;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.am;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
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
/* loaded from: classes6.dex */
public class x implements com.bytedance.sdk.openadsdk.e.b, am.a {

    /* renamed from: f  reason: collision with root package name */
    public static final Map<String, Boolean> f28965f;
    public List<com.bytedance.sdk.openadsdk.core.d.l> B;
    public HashMap<String, j> C;
    public com.bytedance.sdk.openadsdk.c.p F;
    public com.bytedance.sdk.openadsdk.f.a.q G;
    public String H;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f28966a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28967b;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<SSWebView> f28969d;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<Context> f28971g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.e.c f28972h;

    /* renamed from: i  reason: collision with root package name */
    public String f28973i;
    public WeakReference<View> j;
    public String k;
    public int l;
    public String m;
    public com.bytedance.sdk.openadsdk.core.d.l n;
    public com.bytedance.sdk.openadsdk.core.nativeexpress.j p;
    public com.bytedance.sdk.openadsdk.core.nativeexpress.g q;
    public JSONObject r;
    public com.bytedance.sdk.openadsdk.e.d s;
    public com.bytedance.sdk.openadsdk.g.a t;
    public com.bytedance.sdk.openadsdk.g.e u;
    public com.bytedance.sdk.openadsdk.g.d v;
    public JSONObject w;
    public com.bytedance.sdk.openadsdk.core.a.d x;
    public com.bytedance.sdk.openadsdk.g.b y;
    public com.bytedance.sdk.openadsdk.g.h z;
    public boolean o = true;
    public boolean A = true;
    public boolean D = false;
    public boolean E = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28968c = false;

    /* renamed from: e  reason: collision with root package name */
    public am f28970e = new am(Looper.getMainLooper(), this);

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f28988a;

        /* renamed from: b  reason: collision with root package name */
        public String f28989b;

        /* renamed from: c  reason: collision with root package name */
        public String f28990c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f28991d;

        /* renamed from: e  reason: collision with root package name */
        public int f28992e;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f28965f = concurrentHashMap;
        concurrentHashMap.put("log_event", Boolean.TRUE);
        f28965f.put(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, Boolean.TRUE);
        f28965f.put("dispatch_message", Boolean.TRUE);
        f28965f.put("custom_event", Boolean.TRUE);
        f28965f.put("log_event_v3", Boolean.TRUE);
    }

    public x(Context context) {
        this.f28971g = new WeakReference<>(context);
    }

    @MainThread
    private void f(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.c.p pVar;
        if (jSONObject == null || (pVar = this.F) == null) {
            return;
        }
        pVar.b(jSONObject);
    }

    private void g(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.g.b bVar = this.y;
        if (bVar == null || jSONObject == null) {
            return;
        }
        bVar.a(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString("msg", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(JSONObject jSONObject) {
        if (this.q != null && jSONObject != null) {
            try {
                this.q.f(jSONObject.optBoolean("mute", false));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(JSONObject jSONObject) {
        if (this.q != null && jSONObject != null) {
            try {
                this.q.d(jSONObject.optInt("stateType", -1));
            } catch (Exception unused) {
            }
        }
    }

    private boolean j(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.g gVar = this.q;
        if (gVar != null && jSONObject != null) {
            double R = gVar.R();
            int S = this.q.S();
            try {
                jSONObject.put("currentTime", R / 1000.0d);
                jSONObject.put("state", S);
                com.bytedance.sdk.openadsdk.utils.u.b("TTAndroidObject", "currentTime,state:" + S);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(JSONObject jSONObject) {
        x xVar;
        String str;
        int i2;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        com.bytedance.sdk.openadsdk.core.d.j a2;
        int i3;
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.u.b("TTAndroidObject", "TTAndroidObject handleClickEvent");
        try {
            String optString = jSONObject.optString("adId");
            int optInt = jSONObject.optInt("areaType", 1);
            JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
            double d11 = 0.0d;
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("down_x", 0.0d);
                d4 = optJSONObject.optDouble("down_y", 0.0d);
                d5 = optJSONObject.optDouble("up_x", 0.0d);
                d6 = optJSONObject.optDouble("up_y", 0.0d);
                d7 = optJSONObject.optDouble("down_time", 0.0d);
                double optDouble2 = optJSONObject.optDouble("up_time", 0.0d);
                double optDouble3 = optJSONObject.optDouble("button_x", 0.0d);
                double optDouble4 = optJSONObject.optDouble("button_y", 0.0d);
                double optDouble5 = optJSONObject.optDouble("button_width", 0.0d);
                d10 = optJSONObject.optDouble("button_height", 0.0d);
                d11 = optDouble;
                d3 = optDouble2;
                d2 = optDouble3;
                d8 = optDouble4;
                d9 = optDouble5;
                str = optString;
                i2 = optInt;
            } else {
                str = optString;
                i2 = optInt;
                d2 = 0.0d;
                d3 = 0.0d;
                d4 = 0.0d;
                d5 = 0.0d;
                d6 = 0.0d;
                d7 = 0.0d;
                d8 = 0.0d;
                d9 = 0.0d;
                d10 = 0.0d;
            }
            try {
                a2 = new j.a().d((int) d11).c((int) d4).b((int) d5).a((int) d6).b((long) d7).a((long) d3).e((int) d2).f((int) d8).g((int) d9).h((int) d10).a();
                xVar = this;
                i3 = i2;
            } catch (Exception unused) {
                xVar = this;
            }
        } catch (Exception unused2) {
            xVar = this;
        }
        try {
            if (xVar.a(str, i3, a2) || xVar.p == null) {
                return;
            }
            xVar.p.a(i3, a2);
        } catch (Exception unused3) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar = xVar.p;
            if (jVar != null) {
                jVar.a(-1, null);
            }
        }
    }

    private void l(JSONObject jSONObject) {
        double d2;
        boolean z;
        if (this.p == null || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.d.o oVar = new com.bytedance.sdk.openadsdk.core.d.o();
        oVar.a(1);
        try {
            boolean optBoolean = jSONObject.optBoolean("isRenderSuc");
            JSONObject optJSONObject = jSONObject.optJSONObject("AdSize");
            double d3 = 0.0d;
            if (optJSONObject != null) {
                d3 = optJSONObject.optDouble("width");
                d2 = optJSONObject.optDouble("height");
            } else {
                d2 = 0.0d;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("videoInfo");
            if (optJSONObject2 != null) {
                double optDouble = optJSONObject2.optDouble("x");
                double optDouble2 = optJSONObject2.optDouble("y");
                z = optBoolean;
                double optDouble3 = optJSONObject2.optDouble("width");
                double optDouble4 = optJSONObject2.optDouble("height");
                oVar.c(optDouble);
                oVar.d(optDouble2);
                oVar.e(optDouble3);
                oVar.f(optDouble4);
            } else {
                z = optBoolean;
            }
            String optString = jSONObject.optString("message", h.a(101));
            int optInt = jSONObject.optInt("code", 101);
            oVar.a(z);
            oVar.a(d3);
            oVar.b(d2);
            oVar.a(optString);
            oVar.b(optInt);
            this.p.a(oVar);
        } catch (Exception unused) {
            oVar.b(101);
            oVar.a(h.a(101));
            this.p.a(oVar);
        }
    }

    private void m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.u.b("TTAndroidObject", "TTAndroidObject handlerDynamicTrack");
        try {
            Uri parse = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.utils.r.a(parse, this);
            }
        } catch (Exception unused) {
        }
    }

    private void n(JSONObject jSONObject) {
        if (jSONObject == null || this.s == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.s.a(true, optJSONArray);
            } else {
                this.s.a(false, null);
            }
        } catch (Exception unused) {
            this.s.a(false, null);
        }
    }

    private boolean o(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", b(this.B));
        } catch (Exception unused) {
        }
        return true;
    }

    private WebView p() {
        WeakReference<SSWebView> weakReference = this.f28969d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private JSONObject q() {
        try {
            View view = this.j.get();
            SSWebView sSWebView = this.f28969d.get();
            if (view != null && sSWebView != null) {
                int[] b2 = al.b(view);
                int[] b3 = al.b((View) sSWebView);
                if (b2 != null && b3 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", al.b(p.a(), b2[0] - b3[0]));
                    jSONObject.put("y", al.b(p.a(), b2[1] - b3[1]));
                    jSONObject.put("w", al.b(p.a(), view.getWidth()));
                    jSONObject.put("h", al.b(p.a(), view.getHeight()));
                    jSONObject.put("isExist", al.e(view));
                    return jSONObject;
                }
                com.bytedance.sdk.openadsdk.utils.u.f("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
                return null;
            }
            com.bytedance.sdk.openadsdk.utils.u.f("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.u.a("TTAndroidObject", "setCloseButtonInfo error", th);
            return null;
        }
    }

    private List<String> r() {
        return Arrays.asList(DI.APP_INFO_NAME, "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    private void s() {
        com.bytedance.sdk.openadsdk.g.h hVar = this.z;
        if (hVar == null) {
            return;
        }
        hVar.a();
    }

    private void t() {
        com.bytedance.sdk.openadsdk.g.h hVar = this.z;
        if (hVar == null) {
            return;
        }
        hVar.b();
    }

    private void u() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.g gVar = this.q;
        if (gVar != null) {
            gVar.Q();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007f A[Catch: Exception -> 0x0088, TryCatch #0 {Exception -> 0x0088, blocks: (B:4:0x000b, B:9:0x003f, B:11:0x0050, B:13:0x006b, B:17:0x0076, B:19:0x007f, B:20:0x0085, B:10:0x0048), top: B:23:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject v() {
        boolean b2;
        JSONObject jSONObject = new JSONObject();
        if (p.h() != null) {
            try {
                int d2 = ak.d(this.k);
                int c2 = ak.c(this.k);
                int g2 = p.h().g(String.valueOf(d2));
                int e2 = p.h().e(d2);
                boolean b3 = p.h().b(String.valueOf(d2));
                if (c2 != 7 && c2 != 8) {
                    b2 = p.h().a(d2);
                    jSONObject.put("voice_control", b2);
                    jSONObject.put("rv_skip_time", g2);
                    jSONObject.put("fv_skip_show", b3);
                    jSONObject.put("iv_skip_time", e2);
                    jSONObject.put("show_dislike", this.n == null && this.n.aJ());
                    jSONObject.put("video_adaptation", this.n != null ? this.n.l() : 0);
                }
                b2 = p.h().b(d2);
                jSONObject.put("voice_control", b2);
                jSONObject.put("rv_skip_time", g2);
                jSONObject.put("fv_skip_show", b3);
                jSONObject.put("iv_skip_time", e2);
                jSONObject.put("show_dislike", this.n == null && this.n.aJ());
                jSONObject.put("video_adaptation", this.n != null ? this.n.l() : 0);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        Context context;
        List<com.bytedance.sdk.openadsdk.core.d.l> list = this.B;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.C = new HashMap<>();
        WeakReference<SSWebView> weakReference = this.f28969d;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        WeakReference<Context> weakReference2 = this.f28971g;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.d.l lVar : this.B) {
            this.C.put(lVar.am(), new j(context, lVar, sSWebView, this.H));
        }
    }

    private boolean x() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.n;
        if (lVar == null || lVar.az() == null || this.n.C() || this.D || this.n.az().optInt("parent_type") != 2) {
            return false;
        }
        int c2 = ak.c(this.k);
        if (c2 == 8 || c2 == 7) {
            this.D = true;
            return true;
        }
        return false;
    }

    private void y() {
        if (this.f28972h == null) {
            this.f28972h = com.bytedance.sdk.openadsdk.e.a.a(this, this.n);
        }
    }

    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            d(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, 0);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                i(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.x.3
                    @Override // java.lang.Runnable
                    public void run() {
                        x.this.i(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                k(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.x.4
                    @Override // java.lang.Runnable
                    public void run() {
                        x.this.k(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    public boolean d() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.n;
        return lVar != null && lVar.f();
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            m(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    public boolean e() {
        return this.f28968c;
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        j(jSONObject);
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        a("getTemplateInfo", true);
        try {
            if (this.r != null) {
                this.r.put(com.alipay.sdk.sys.a.j, v());
            }
            a("getTemplateInfo", false);
            return this.r.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                h(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.x.2
                    @Override // java.lang.Runnable
                    public void run() {
                        x.this.h(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
            com.bytedance.sdk.openadsdk.utils.u.f("TTAndroidObject", "");
        }
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            l(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void skipVideo() {
        u();
    }

    private void e(JSONObject jSONObject) throws Exception {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.n;
        if (lVar == null || TextUtils.isEmpty(lVar.j())) {
            return;
        }
        jSONObject.put("playable_style", this.n.j());
    }

    private void p(JSONObject jSONObject) {
        WebView p;
        if (jSONObject == null || (p = p()) == null) {
            return;
        }
        String str = "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject.toString() + SmallTailInfo.EMOTION_SUFFIX;
        com.bytedance.sdk.openadsdk.utils.t.a(p, str);
        if (com.bytedance.sdk.openadsdk.utils.u.a()) {
            com.bytedance.sdk.openadsdk.utils.u.a("TTAndroidObject", "js_msg " + str);
        }
    }

    public x b(SSWebView sSWebView) {
        this.f28969d = new WeakReference<>(sSWebView);
        return this;
    }

    public com.bytedance.sdk.openadsdk.core.d.l c() {
        return this.n;
    }

    public x d(String str) {
        this.m = str;
        return this;
    }

    private void d(JSONObject jSONObject) throws Exception {
        if (!TextUtils.isEmpty(this.f28973i)) {
            jSONObject.put(IAdRequestParam.CELL_ID, this.f28973i);
        }
        if (!TextUtils.isEmpty(this.k)) {
            jSONObject.put("log_extra", this.k);
        }
        if (TextUtils.isEmpty(this.m)) {
            return;
        }
        jSONObject.put("download_url", this.m);
    }

    public x b(boolean z) {
        this.E = z;
        return this;
    }

    public x c(String str) {
        this.k = str;
        return this;
    }

    public void f() {
        a((JSONObject) null, new com.bytedance.sdk.openadsdk.g.c() { // from class: com.bytedance.sdk.openadsdk.core.x.6
            @Override // com.bytedance.sdk.openadsdk.g.c
            public void a(boolean z, List<com.bytedance.sdk.openadsdk.core.d.l> list) {
                x.this.B = list;
                x.this.w();
                x.this.g();
            }
        });
    }

    public void g() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", b(this.B));
            a("materialMeta", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void o() {
        com.bytedance.sdk.openadsdk.e.c cVar = this.f28972h;
        if (cVar != null) {
            cVar.c();
        }
    }

    private void e(String str) {
        try {
            String str2 = new String(Base64.decode(str, 2));
            com.bytedance.sdk.openadsdk.utils.u.b("TTAndroidObject", str2);
            JSONArray jSONArray = new JSONArray(str2);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                a aVar = new a();
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        aVar.f28988a = optJSONObject.optString("__msg_type", null);
                        aVar.f28989b = optJSONObject.optString("__callback_id", null);
                        aVar.f28990c = optJSONObject.optString(WebChromeClient.KEY_FUNCTION_NAME);
                        aVar.f28991d = optJSONObject.optJSONObject("params");
                        aVar.f28992e = optJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(aVar.f28988a) && !TextUtils.isEmpty(aVar.f28990c)) {
                    Message obtainMessage = this.f28970e.obtainMessage(11);
                    obtainMessage.obj = aVar;
                    this.f28970e.sendMessage(obtainMessage);
                }
            }
        } catch (Exception unused2) {
            if (com.bytedance.sdk.openadsdk.utils.u.a()) {
                com.bytedance.sdk.openadsdk.utils.u.d("TTAndroidObject", "failed to parse jsbridge msg queue " + str);
                return;
            }
            com.bytedance.sdk.openadsdk.utils.u.d("TTAndroidObject", "failed to parse jsbridge msg queue");
        }
    }

    private boolean f(String str) {
        return TextUtils.isEmpty(str) || !"click_other".equals(str) || h();
    }

    public x b(String str) {
        this.f28973i = str;
        return this;
    }

    public x c(boolean z) {
        this.A = z;
        return this;
    }

    public boolean h() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.n;
        return lVar != null && lVar.I() == 1;
    }

    public void i() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.n;
        if (lVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.g.a(this.f28971g.get(), lVar.W());
    }

    public x a(String str) {
        this.H = str;
        return this;
    }

    public void b() {
        WeakReference<Context> weakReference = this.f28971g;
        if (weakReference == null || weakReference.get() == null || !(this.f28971g.get() instanceof TTMiddlePageActivity)) {
            return;
        }
        ((Activity) this.f28971g.get()).finish();
    }

    public void c(JSONObject jSONObject) {
        String str;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.u.b("TTAndroidObject", "TTAndroidObject handleNewClickEvent");
        try {
            String optString = jSONObject.optString("adId");
            int optInt = jSONObject.optInt("areaType", 1);
            boolean z = jSONObject.optInt("downloadDialogStatus", 2) == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
            double d11 = 0.0d;
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("down_x", 0.0d);
                d4 = optJSONObject.optDouble("down_y", 0.0d);
                d5 = optJSONObject.optDouble("up_x", 0.0d);
                double optDouble2 = optJSONObject.optDouble("up_y", 0.0d);
                double optDouble3 = optJSONObject.optDouble("down_time", 0.0d);
                double optDouble4 = optJSONObject.optDouble("up_time", 0.0d);
                double optDouble5 = optJSONObject.optDouble("button_x", 0.0d);
                double optDouble6 = optJSONObject.optDouble("button_y", 0.0d);
                double optDouble7 = optJSONObject.optDouble("button_width", 0.0d);
                str = optString;
                d10 = optJSONObject.optDouble("button_height", 0.0d);
                d11 = optDouble;
                d3 = optDouble2;
                d2 = optDouble3;
                d6 = optDouble4;
                d7 = optDouble5;
                d8 = optDouble6;
                d9 = optDouble7;
            } else {
                str = optString;
                d2 = 0.0d;
                d3 = 0.0d;
                d4 = 0.0d;
                d5 = 0.0d;
                d6 = 0.0d;
                d7 = 0.0d;
                d8 = 0.0d;
                d9 = 0.0d;
                d10 = 0.0d;
            }
            com.bytedance.sdk.openadsdk.core.d.j a2 = new j.a().d((int) d11).c((int) d4).b((int) d5).a((int) d3).b((long) d2).a((long) d6).e((int) d7).f((int) d8).g((int) d9).h((int) d10).a();
            if (this.p != null) {
                this.p.a(optInt, a2, !z);
            }
            a(str, optInt, a2);
        } catch (Exception unused) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar = this.p;
            if (jVar != null) {
                jVar.a(-1, null, true);
            }
        }
    }

    private void h(String str) {
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView p = p();
                    if (p != null) {
                        com.bytedance.sdk.openadsdk.utils.t.a(p, "javascript:ToutiaoJSBridge._fetchQueue()");
                    }
                } else if (str.startsWith("bytedance://private/setresult/")) {
                    int indexOf = str.indexOf(38, 30);
                    if (indexOf <= 0) {
                        return;
                    }
                    String substring = str.substring(30, indexOf);
                    String substring2 = str.substring(indexOf + 1);
                    if (substring.equals("SCENE_FETCHQUEUE") && substring2.length() > 0) {
                        e(substring2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public x a(SSWebView sSWebView) {
        com.bytedance.sdk.openadsdk.f.a.q b2 = com.bytedance.sdk.openadsdk.f.a.q.a(sSWebView).a("ToutiaoJSBridge").a(new com.bytedance.sdk.openadsdk.f.a.l() { // from class: com.bytedance.sdk.openadsdk.core.x.1
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
        }).a(i.d().w()).b(true).a().b();
        this.G = b2;
        com.bytedance.sdk.openadsdk.f.b.f.a(b2, this);
        com.bytedance.sdk.openadsdk.f.b.b.a(this.G, this);
        com.bytedance.sdk.openadsdk.f.b.h.a(this.G);
        com.bytedance.sdk.openadsdk.f.b.e.a(this.G);
        com.bytedance.sdk.openadsdk.f.b.g.a(this.G, sSWebView);
        com.bytedance.sdk.openadsdk.f.b.c.a(this.G, this);
        com.bytedance.sdk.openadsdk.f.b.d.a(this.G, this);
        com.bytedance.sdk.openadsdk.f.b.i.a(this.G, this);
        com.bytedance.sdk.openadsdk.f.b.a.a(this.G, this);
        return this;
    }

    private String g(String str) {
        return this.p == null ? ak.a(this.l) : str;
    }

    public void j() {
        com.bytedance.sdk.openadsdk.utils.g.a(this.n, this.f28971g.get(), l());
    }

    public void m() {
        com.bytedance.sdk.openadsdk.e.c cVar = this.f28972h;
        if (cVar != null) {
            cVar.a();
        }
        if (x()) {
            f();
        }
    }

    public void n() {
        com.bytedance.sdk.openadsdk.e.c cVar = this.f28972h;
        if (cVar != null) {
            cVar.b();
        }
    }

    public x b(JSONObject jSONObject) {
        this.w = jSONObject;
        return this;
    }

    public static JSONArray b(List<com.bytedance.sdk.openadsdk.core.d.l> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            jSONArray.put(list.get(i2).aL());
        }
        return jSONArray;
    }

    private void d(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "event");
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            p(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void b(@NonNull Uri uri) {
        long j;
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if (!PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(host) && !"dispatch_message".equals(host)) {
                    com.bytedance.sdk.openadsdk.utils.u.d("TTAndroidObject", "handlrUir: not match schema host");
                    return;
                }
                h(uri.toString());
                return;
            }
            String queryParameter = uri.getQueryParameter("category");
            String queryParameter2 = uri.getQueryParameter("tag");
            String queryParameter3 = uri.getQueryParameter(NotificationCompatJellybean.KEY_LABEL);
            if (f(queryParameter3)) {
                long j2 = 0;
                try {
                    j = Long.parseLong(uri.getQueryParameter("value"));
                } catch (Exception unused) {
                    j = 0;
                }
                try {
                    j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
                } catch (Exception unused2) {
                }
                long j3 = j2;
                JSONObject jSONObject = null;
                String queryParameter4 = uri.getQueryParameter("extra");
                if (!TextUtils.isEmpty(queryParameter4)) {
                    try {
                        jSONObject = new JSONObject(queryParameter4);
                    } catch (Exception unused3) {
                    }
                }
                com.bytedance.sdk.openadsdk.c.d.a(queryParameter, g(queryParameter2), queryParameter3, j, j3, PrefetchEvent.STATE_CLICK.equals(queryParameter3) ? q(jSONObject) : jSONObject);
            }
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.utils.u.b("TTAndroidObject", "handleUri exception: ", e2);
        }
    }

    private JSONObject q(JSONObject jSONObject) {
        if (this.f28966a != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String optString = jSONObject.optString("ad_extra_data", null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                for (Map.Entry<String, Object> entry : this.f28966a.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e2) {
                com.bytedance.sdk.openadsdk.utils.u.b(e2.toString());
            }
        }
        return jSONObject;
    }

    public com.bytedance.sdk.openadsdk.f.a.q a() {
        return this.G;
    }

    public x a(com.bytedance.sdk.openadsdk.c.p pVar) {
        this.F = pVar;
        return this;
    }

    public x a(boolean z) {
        this.f28967b = z;
        return this;
    }

    public x a(View view) {
        this.j = new WeakReference<>(view);
        return this;
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

    public String l() {
        return ak.a(this.l);
    }

    public x a(int i2) {
        this.l = i2;
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

    public void b(String str, JSONObject jSONObject) {
        try {
            if (this.G != null) {
                this.G.a(str, (String) jSONObject);
            }
        } catch (Throwable th) {
            Log.e("TTAndroidObject", "sendJsMsg2020 error", th);
        }
    }

    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.n;
        if (lVar == null) {
            return jSONObject;
        }
        String W = lVar.W();
        if (TextUtils.isEmpty(W)) {
            return jSONObject;
        }
        try {
            return new JSONObject(W);
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    public x a(com.bytedance.sdk.openadsdk.core.a.d dVar) {
        this.x = dVar;
        return this;
    }

    public x a(JSONObject jSONObject) {
        this.r = jSONObject;
        return this;
    }

    public x a(Map<String, Object> map) {
        this.f28966a = map;
        return this;
    }

    public x a(com.bytedance.sdk.openadsdk.g.a aVar) {
        this.t = aVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            p(jSONObject2);
        } catch (Exception unused) {
        }
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

    private void a(JSONObject jSONObject, int i2) throws Exception {
        JSONArray jSONArray = new JSONArray();
        for (String str : r()) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02e2, code lost:
        if (r5 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0308, code lost:
        if (r5 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x030a, code lost:
        r3 = r5;
     */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject a(a aVar, int i2) throws Exception {
        char c2;
        JSONObject jSONObject;
        Context context;
        WeakReference<Context> weakReference;
        Context context2;
        Context context3;
        if (NotificationCompat.CATEGORY_CALL.equals(aVar.f28988a)) {
            if (i.d().w()) {
                StringBuilder sb = new StringBuilder();
                sb.append("[JSB-REQ] version:");
                sb.append(i2);
                sb.append(" method:");
                sb.append(aVar.f28990c);
                sb.append(" params=");
                JSONObject jSONObject2 = aVar.f28991d;
                sb.append(jSONObject2 != null ? jSONObject2.toString() : "");
                Log.d("TTAndroidObject", sb.toString());
            }
            JSONObject jSONObject3 = new JSONObject();
            String str = aVar.f28990c;
            int i3 = -1;
            switch (str.hashCode()) {
                case -2036781162:
                    if (str.equals("subscribe_app_ad")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1423303823:
                    if (str.equals("adInfo")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1330994877:
                    if (str.equals("pauseWebView")) {
                        c2 = 27;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1169135450:
                    if (str.equals("changeVideoState")) {
                        c2 = 21;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -844321441:
                    if (str.equals("webview_time_track")) {
                        c2 = DecodedBitStreamParser.GS;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -800853518:
                    if (str.equals("clickEvent")) {
                        c2 = 16;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -794273169:
                    if (str.equals(DI.APP_INFO_NAME)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -715147645:
                    if (str.equals("getScreenSize")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -489318846:
                    if (str.equals("getMaterialMeta")) {
                        c2 = 24;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -278382602:
                    if (str.equals("send_temai_product_ids")) {
                        c2 = 23;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -173752734:
                    if (str.equals("getTeMaiAds")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 27837080:
                    if (str.equals("download_app_ad")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 105049135:
                    if (str.equals("unsubscribe_app_ad")) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 352242576:
                    if (str.equals("getDownloadStatus")) {
                        c2 = DecodedBitStreamParser.RS;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 399543522:
                    if (str.equals("getCloseButtonInfo")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 402955465:
                    if (str.equals("isViewable")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 442647767:
                    if (str.equals("sendReward")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 571273292:
                    if (str.equals("dynamicTrack")) {
                        c2 = 18;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 650209982:
                    if (str.equals("getTemplateInfo")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 672928467:
                    if (str.equals("cancel_download_app_ad")) {
                        c2 = '\r';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 711635577:
                    if (str.equals("getCurrentVideoState")) {
                        c2 = 22;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 885131792:
                    if (str.equals("getVolume")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1107374321:
                    if (str.equals("pauseWebViewTimers")) {
                        c2 = DecodedBitStreamParser.FS;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1151744482:
                    if (str.equals("muteVideo")) {
                        c2 = 20;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1237100796:
                    if (str.equals("renderDidFinish")) {
                        c2 = 17;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1532142616:
                    if (str.equals("removeLoading")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1634511418:
                    if (str.equals("endcard_load")) {
                        c2 = JSONLexer.EOI;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1713585602:
                    if (str.equals("getNetworkData")) {
                        c2 = 25;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1731806400:
                    if (str.equals("playable_style")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2086000188:
                    if (str.equals("skipVideo")) {
                        c2 = 19;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2105008900:
                    if (str.equals("landscape_click")) {
                        c2 = 15;
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
                    a(jSONObject3, aVar.f28992e);
                    break;
                case 1:
                    d(jSONObject3);
                    break;
                case 2:
                    e(jSONObject3);
                    break;
                case 3:
                    JSONObject jSONObject4 = this.r;
                    if (jSONObject4 != null) {
                        jSONObject4.put(com.alipay.sdk.sys.a.j, v());
                    }
                    jSONObject3 = this.r;
                    break;
                case 4:
                    jSONObject = this.w;
                    break;
                case 5:
                    jSONObject3.put("viewStatus", this.E ? 1 : 0);
                    break;
                case 6:
                    com.bytedance.sdk.openadsdk.g.a aVar2 = this.t;
                    if (aVar2 != null) {
                        int b2 = aVar2.b();
                        int a2 = this.t.a();
                        jSONObject3.put("width", b2);
                        jSONObject3.put("height", a2);
                        break;
                    }
                    break;
                case 7:
                    jSONObject = q();
                    break;
                case '\b':
                    AudioManager audioManager = (AudioManager) p.a().getSystemService("audio");
                    if (audioManager != null) {
                        i3 = audioManager.getStreamVolume(3);
                        com.bytedance.sdk.openadsdk.utils.u.b("TTAndroidObject", "音乐音量 >>>> AudioManager-->currentVolume=" + i3);
                    }
                    jSONObject3.put("endcard_mute", i3 <= 0);
                    break;
                case '\t':
                    com.bytedance.sdk.openadsdk.g.d dVar = this.v;
                    if (dVar != null) {
                        dVar.a();
                        break;
                    }
                    break;
                case '\n':
                    this.f28968c = true;
                    com.bytedance.sdk.openadsdk.g.e eVar = this.u;
                    if (eVar != null) {
                        eVar.a();
                        break;
                    }
                    break;
                case 11:
                    y();
                    WeakReference<Context> weakReference2 = this.f28971g;
                    if (weakReference2 != null && (context = weakReference2.get()) != null) {
                        this.f28972h.a(context, aVar.f28991d, this.k, this.l, this.o);
                        break;
                    }
                    break;
                case '\f':
                    com.bytedance.sdk.openadsdk.core.a.d dVar2 = this.x;
                    if (dVar2 != null) {
                        dVar2.a(this.A);
                        break;
                    } else if (this.f28972h != null && (weakReference = this.f28971g) != null && (context2 = weakReference.get()) != null) {
                        this.f28972h.a(context2, aVar.f28991d);
                        break;
                    }
                    break;
                case '\r':
                    com.bytedance.sdk.openadsdk.e.c cVar = this.f28972h;
                    if (cVar != null) {
                        cVar.b(aVar.f28991d);
                        break;
                    }
                    break;
                case 14:
                    com.bytedance.sdk.openadsdk.e.c cVar2 = this.f28972h;
                    if (cVar2 != null) {
                        cVar2.a(aVar.f28991d);
                        break;
                    }
                    break;
                case 15:
                    WeakReference<Context> weakReference3 = this.f28971g;
                    if (weakReference3 != null && (context3 = weakReference3.get()) != null && (context3 instanceof com.bytedance.sdk.openadsdk.core.video.c.b)) {
                        ((com.bytedance.sdk.openadsdk.core.video.c.b) context3).W();
                        break;
                    }
                    break;
                case 16:
                    k(aVar.f28991d);
                    break;
                case 17:
                    l(aVar.f28991d);
                    break;
                case 18:
                    m(aVar.f28991d);
                    break;
                case 19:
                    u();
                    break;
                case 20:
                    h(aVar.f28991d);
                    break;
                case 21:
                    i(aVar.f28991d);
                    break;
                case 22:
                    j(jSONObject3);
                    break;
                case 23:
                    n(aVar.f28991d);
                    break;
                case 24:
                    o(jSONObject3);
                    break;
                case 25:
                    a(aVar, jSONObject3);
                    break;
                case 26:
                    g(aVar.f28991d);
                    break;
                case 27:
                    s();
                    break;
                case 28:
                    t();
                    break;
                case 29:
                    f(aVar.f28991d);
                    break;
                case 30:
                    jSONObject3 = com.bytedance.sdk.openadsdk.f.b.e.a(aVar.f28991d);
                    break;
            }
            if (i2 == 1 && !TextUtils.isEmpty(aVar.f28989b)) {
                c(aVar.f28989b, jSONObject3);
                if (i.d().w()) {
                    Log.d("TTAndroidObject", "[JSB-RSP] version:" + i2 + " data=" + jSONObject3);
                }
            }
            return jSONObject3;
        }
        return null;
    }

    private void a(String str, boolean z) {
        if (this.F == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.F.a(str);
        } else {
            this.F.b(str);
        }
    }

    private void a(final a aVar, final JSONObject jSONObject) {
        if (aVar == null) {
            return;
        }
        try {
            a(aVar.f28991d, new com.bytedance.sdk.openadsdk.g.c() { // from class: com.bytedance.sdk.openadsdk.core.x.5
                @Override // com.bytedance.sdk.openadsdk.g.c
                public void a(boolean z, List<com.bytedance.sdk.openadsdk.core.d.l> list) {
                    if (z) {
                        try {
                            jSONObject.put("creatives", x.b(list));
                            x.this.c(aVar.f28989b, jSONObject);
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    x.this.c(aVar.f28989b, jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    private boolean a(String str, int i2, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        HashMap<String, j> hashMap;
        j jVar2;
        if (TextUtils.isEmpty(str) || (hashMap = this.C) == null || (jVar2 = hashMap.get(str)) == null) {
            return false;
        }
        jVar2.a(i2, jVar);
        return true;
    }

    public void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.g.c cVar) {
        a(jSONObject, cVar, (AdSlot) null);
    }

    public void a(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.g.c cVar, AdSlot adSlot) {
        if (cVar == null) {
            return;
        }
        try {
            if (this.n != null && !TextUtils.isEmpty(this.k)) {
                int c2 = ak.c(this.k);
                AdSlot p = this.n.p();
                if (p != null) {
                    adSlot = p;
                }
                com.bytedance.sdk.openadsdk.core.d.m mVar = new com.bytedance.sdk.openadsdk.core.d.m();
                if (this.n.S() != null) {
                    mVar.f28098e = 2;
                }
                JSONObject az = this.n.az();
                if (az == null) {
                    az = new JSONObject();
                }
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        az.put(next, jSONObject.opt(next));
                    }
                }
                mVar.j = az;
                p.f().a(adSlot, mVar, c2, new q.b() { // from class: com.bytedance.sdk.openadsdk.core.x.7
                    @Override // com.bytedance.sdk.openadsdk.core.q.b
                    public void a(int i2, String str) {
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
                return;
            }
            cVar.a(false, null);
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.utils.u.c("TTAndroidObject", "get ads error", e2);
        }
    }

    public void a(AdSlot adSlot) {
        a((JSONObject) null, new com.bytedance.sdk.openadsdk.g.c() { // from class: com.bytedance.sdk.openadsdk.core.x.8
            @Override // com.bytedance.sdk.openadsdk.g.c
            public void a(boolean z, List<com.bytedance.sdk.openadsdk.core.d.l> list) {
                x.this.B = list;
                x.this.w();
                x.this.g();
            }
        }, adSlot);
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        if ("bytedance".equals(uri.getScheme())) {
            return f28965f.containsKey(uri.getHost());
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        if (message != null && message.what == 11) {
            Object obj = message.obj;
            if (obj instanceof a) {
                try {
                    a((a) obj, 1);
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.b
    public void a(String str, JSONObject jSONObject) {
        d(str, jSONObject);
    }
}
