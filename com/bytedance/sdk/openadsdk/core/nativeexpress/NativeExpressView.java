package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.core.d.q;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class NativeExpressView extends FrameLayout implements j {
    private final AtomicBoolean A;
    private String B;
    private float C;
    private float D;
    private final AtomicBoolean E;
    private com.bytedance.sdk.openadsdk.c.j F;
    private p G;
    private String H;

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.dislike.b f6923a;

    /* renamed from: b  reason: collision with root package name */
    private TTDislikeDialogAbstract f6924b;
    private String c;
    private String d;
    protected final AtomicBoolean e;
    protected final Context f;
    protected WeakReference<SSWebView> g;
    protected x h;
    protected String i;
    protected AdSlot j;
    protected com.bytedance.sdk.openadsdk.core.d.l k;
    protected TTNativeExpressAd.ExpressVideoAdListener l;
    protected FrameLayout m;
    protected boolean n;
    protected boolean o;
    protected ScheduledFuture<?> p;
    protected c q;
    protected boolean r;
    protected BackupView s;
    private int t;
    private int u;
    private TTNativeExpressAd.ExpressAdInteractionListener v;
    private d w;
    private e x;
    private final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> y;
    private final AtomicBoolean z;

    public NativeExpressView(@NonNull Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot, String str) {
        super(context);
        this.e = new AtomicBoolean(false);
        this.i = "embeded_ad";
        this.y = Collections.synchronizedMap(new HashMap());
        this.z = new AtomicBoolean(false);
        this.A = new AtomicBoolean(false);
        this.B = null;
        this.o = false;
        this.r = false;
        this.E = new AtomicBoolean(false);
        this.H = "{\"id\":0,\"tplId\":0,\"title\":\"\",\"data\":{\"id\":\"root\",\"type\":\"vessel\",\"values\":{\"widthMode\":\"fixed\",\"width\":320,\"height\":320},\"children\":[[{\"type\":\"text\",\"values\":{\"fontSize\":19,\"fontWeight\":500,\"color\":\"#222222\",\"lineHeight\":1.3,\"data\":\"title\"}}],[{\"type\":\"text\",\"values\":{\"fontSize\":15,\"fontWeight\":500,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"subtitle\"}}],[{\"type\":\"image\",\"values\":{},\"children\":[]}],[{\"type\":\"vessel\",\"values\":{\"height\":40,\"paddingTop\":10,\"paddingRight\":15,\"paddingBottom\":10,\"paddingLeft\":15},\"children\":[[{\"type\":\"logo\",\"values\":{}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":6,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"source\"}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":10,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"time\"}},{\"type\":\"empty\",\"values\":{\"height\":18}},{\"type\":\"dislike\",\"values\":{}}]]}]]}}";
        this.i = str;
        this.f = context;
        this.k = lVar;
        a(adSlot);
        a();
    }

    private void a(AdSlot adSlot) {
        this.j = adSlot;
        if (this.j != null) {
            this.C = this.j.getExpressViewAcceptedWidth();
            this.D = this.j.getExpressViewAcceptedHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        setBackgroundColor(0);
        if (getWebView().getParent() != null) {
            ((ViewGroup) getWebView().getParent()).removeView(getWebView());
        }
        getWebView().setBackgroundColor(0);
        addView(getWebView(), new FrameLayout.LayoutParams(-1, -1));
        c();
        b();
        d();
        getWebView().addJavascriptInterface(this.h, "SDK_INJECT_GLOBAL");
    }

    private void c() {
        this.c = this.k.T();
        this.d = this.k.W();
        this.u = 3251;
        this.t = aj.a(this.i);
        this.B = this.j.getCodeId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.G = new p(1, this.i, this.k);
        this.h = new x(this.f);
        this.h.b(getWebView()).a(this.k).a(this.c).b(this.d).a(this.t).c(aj.h(this.k)).a((j) this).a(getTemplateInfo()).a(getWebView()).a(this.G);
    }

    public SSWebView getWebView() {
        if (this.g != null && this.g.get() != null) {
            return this.g.get();
        }
        this.g = com.bytedance.sdk.openadsdk.core.widget.webview.d.a().c();
        return this.g.get();
    }

    private void d() {
        a(getWebView());
        this.F = new com.bytedance.sdk.openadsdk.c.j(this.f, this.k, getWebView()).a(true);
        this.F.a(this.G);
        getWebView().setWebViewClient(new f(this.f, this.h, this.k, this.F, e()));
        getWebView().setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.h, this.F));
        getWebView().setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (NativeExpressView.this.y.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = (com.bytedance.sdk.openadsdk.downloadnew.core.a) NativeExpressView.this.y.get(str);
                    if (aVar != null) {
                        aVar.e();
                        return;
                    }
                    return;
                }
                if (NativeExpressView.this.k != null && NativeExpressView.this.k.I() != null) {
                    NativeExpressView.this.k.I().a();
                }
                com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(NativeExpressView.this.f, str, NativeExpressView.this.k, NativeExpressView.this.i);
                NativeExpressView.this.y.put(str, a2);
                a2.e();
            }
        });
    }

    private boolean e() {
        return !TextUtils.isEmpty(this.i) && this.i.equals("splash_ad");
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            try {
                com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.f).a(false).a(sSWebView);
                sSWebView.setVerticalScrollBarEnabled(false);
                sSWebView.setHorizontalScrollBarEnabled(false);
                sSWebView.clearCache(true);
                sSWebView.clearHistory();
                WebSettings settings = sSWebView.getSettings();
                settings.setUserAgentString(r.a(sSWebView, this.u));
                if (Build.VERSION.SDK_INT >= 21) {
                    settings.setMixedContentMode(0);
                }
                settings.setJavaScriptEnabled(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setCacheMode(2);
                settings.setDomStorageEnabled(true);
                settings.setDatabaseEnabled(true);
                settings.setAppCacheEnabled(true);
                settings.setAllowFileAccess(true);
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
                settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
                settings.setUseWideViewPort(true);
            } catch (Exception e) {
                u.f("NativeExpressView", e.toString());
            }
        }
    }

    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.l = expressVideoAdListener;
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (this.s != null) {
            this.s.setDislikeOuter(tTDislikeDialogAbstract);
        }
        this.f6924b = tTDislikeDialogAbstract;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.dislike.b bVar) {
        if (this.s != null) {
            this.s.setDislikeInner(bVar);
        }
        this.f6923a = bVar;
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.v = expressAdInteractionListener;
    }

    public void setClickCreativeListener(d dVar) {
        this.w = dVar;
    }

    public d getClickCreativeListener() {
        return this.w;
    }

    public e getClickListener() {
        return this.x;
    }

    public void setClickListener(e eVar) {
        this.x = eVar;
    }

    public void setBackupListener(c cVar) {
        this.q = cVar;
    }

    public void g() {
        if (this.h != null && !this.E.get()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("expressShow", true);
                this.h.a("expressShow", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void h() {
        this.A.set(true);
        this.G.a();
        this.p = com.bytedance.sdk.openadsdk.k.a.a().a(new a(1), com.bytedance.sdk.openadsdk.core.p.h().G());
        if (!com.bytedance.sdk.openadsdk.core.widget.webview.a.a.e()) {
            a(false, 0.0f, 0.0f, 102);
            return;
        }
        String c = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d() != null ? com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d().c() : null;
        if (TextUtils.isEmpty(c)) {
            a(false, 0.0f, 0.0f, 102);
            return;
        }
        q b2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this.k);
        if (b2 == null && !f()) {
            a(false, 0.0f, 0.0f, 103);
            return;
        }
        String f = b2 != null ? b2.f() : null;
        if (f() && !TextUtils.isEmpty(this.k.B().a())) {
            f = this.k.B().a();
        }
        if (com.bytedance.sdk.openadsdk.core.widget.webview.a.f.b(f) && !"https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/latest/index.html".equals(c)) {
            a(false, 0.0f, 0.0f, 102);
        } else {
            getWebView().loadUrl(c);
        }
    }

    private boolean f() {
        return (this.k == null || this.k.B() == null || TextUtils.isEmpty(this.k.B().b()) || TextUtils.isEmpty(this.k.B().e())) ? false : true;
    }

    private JSONObject getTemplateInfo() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", HttpConstants.OS_TYPE_VALUE);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.C);
            jSONObject2.put("height", this.D);
            if (this.o) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", getCreativeJson());
            if (this.k.B() != null) {
                str2 = this.k.B().e();
                str = this.k.B().f();
            } else {
                str = null;
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.H = str2;
            } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this.k) != null) {
                this.H = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this.k).e();
            }
            jSONObject.put("template_Plugin", this.H);
            jSONObject.put("diff_template_Plugin", str);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    private JSONObject getCreativeJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", this.k.S());
            if (this.k.I() != null) {
                jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, this.k.I().a());
            }
            JSONArray jSONArray = new JSONArray();
            if (this.k.M() != null) {
                for (int i = 0; i < this.k.M().size(); i++) {
                    com.bytedance.sdk.openadsdk.core.d.k kVar = this.k.M().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", kVar.c());
                    jSONObject2.put("width", kVar.b());
                    jSONObject2.put("url", kVar.a());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", this.k.X());
            jSONObject.put("interaction_type", this.k.H());
            jSONObject.put("title", this.k.Q());
            jSONObject.put("description", this.k.R());
            jSONObject.put("source", this.k.G());
            if (this.k.U() != null) {
                jSONObject.put("comment_num", this.k.U().f());
                jSONObject.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.k.U().e());
                jSONObject.put("app_size", this.k.U().g());
                jSONObject.put("app", this.k.U().h());
            }
            if (this.k.F() != null) {
                jSONObject.put("video", this.k.F().l());
            }
            if (this.k.B() != null) {
                jSONObject.put("dynamic_creative", this.k.B().g());
            }
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.n nVar) {
        if (nVar == null) {
            a(false, 0.0f, 0.0f, 105);
            return;
        }
        boolean a2 = nVar.a();
        a(a2, (float) nVar.b(), (float) nVar.c(), a2 ? 0 : nVar.h());
    }

    private void a(float f, float f2) {
        if (f > 0.0f && f2 > 0.0f) {
            int a2 = (int) ak.a(this.f, f);
            int a3 = (int) ak.a(this.f, f2);
            u.f("ExpressView", "width:" + a2);
            u.f("ExpressView", "height:" + a3);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getWebView().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(a2, a3);
            }
            layoutParams.width = a2;
            layoutParams.height = a3;
            getWebView().setLayoutParams(layoutParams);
        }
    }

    public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (i != -1 && jVar != null) {
            int i2 = jVar.f6803a;
            int i3 = jVar.f6804b;
            int i4 = jVar.c;
            int i5 = jVar.d;
            switch (i) {
                case 1:
                    if (this.m != null) {
                        this.m.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                    }
                    if (this.x != null) {
                        this.x.a(jVar);
                        this.x.a(this, i2, i3, i4, i5);
                    }
                    if (this.v != null) {
                        this.v.onAdClicked(this, this.k.H());
                        return;
                    }
                    return;
                case 2:
                    if (this.w != null) {
                        this.w.a(jVar);
                        this.w.a(this, i2, i3, i4, i5);
                    }
                    if (this.v != null) {
                        this.v.onAdClicked(this, this.k.H());
                        return;
                    }
                    return;
                case 3:
                    if (this.f6924b != null) {
                        this.f6924b.show();
                        return;
                    } else if (this.f6923a != null) {
                        this.f6923a.showDislikeDialog(0);
                        return;
                    } else {
                        return;
                    }
                case 4:
                    if (this.m != null) {
                        this.m.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                    }
                    u.b("ClickCreativeListener", "创意....mAdType=" + this.i + ",!mVideoPause=" + (this.n ? false : true) + "，isAutoPlay=" + aj.i(this.k));
                    if ("embeded_ad".equals(this.i) && n() && !this.n && aj.i(this.k)) {
                        u.b("ClickCreativeListener", "创意....");
                        if (this.w != null) {
                            this.w.a(jVar);
                            this.w.a(this, i2, i3, i4, i5);
                        }
                    } else {
                        u.b("ClickCreativeListener", "普通....");
                        if (this.x != null) {
                            this.x.a(jVar);
                            this.x.a(this, i2, i3, i4, i5);
                        }
                    }
                    if (this.v != null) {
                        this.v.onAdClicked(this, this.k.H());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean n() {
        return this.k != null && this.k.e() == 1 && (this.k.X() == 5 || this.k.X() == 15);
    }

    private void a(int i) {
        com.bytedance.sdk.openadsdk.h.a.a().h(com.bytedance.sdk.openadsdk.h.a.d.b().a(getAdSlotType()).c(this.B).f(aj.h(this.d)).b(i).g(com.bytedance.sdk.openadsdk.core.h.a(i)));
    }

    private void o() {
        com.bytedance.sdk.openadsdk.h.a.a().a(com.bytedance.sdk.openadsdk.h.a.d.b().a(getAdSlotType()).c(this.B).f(aj.h(this.d)).a("dynamic_backup_render_new"));
    }

    private int getAdSlotType() {
        String str = this.i;
        char c = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c = 4;
                    break;
                }
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c = 2;
                    break;
                }
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c = 3;
                    break;
                }
                break;
            case -712491894:
                if (str.equals("embeded_ad")) {
                    c = 0;
                    break;
                }
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c = 6;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c = 5;
                    break;
                }
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            default:
                return 5;
            case 1:
                return 9;
            case 2:
                return 7;
            case 3:
                return 8;
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        u.f("webviewpool", "onAttachedToWindow+++");
        p();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        u.f("webviewpool", "onFinishTemporaryDetach+++");
        p();
    }

    private void p() {
        if (this.z.getAndSet(false) && getWebView().getParent() == null && !this.r) {
            u.f("webviewpool", "attachCallback+++========-----------===========");
            a();
            h();
        }
    }

    private void q() {
        if (!this.z.getAndSet(true) && !this.r) {
            com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.g, j());
        }
    }

    public void i() {
        if (getWebView() != null && !this.E.get()) {
            try {
                getWebView().resumeTimers();
            } catch (Exception e) {
            }
        }
    }

    boolean j() {
        if ("embeded_ad".equals(this.i) || "draw_ad".equals(this.i)) {
            return false;
        }
        this.E.set(true);
        return true;
    }

    public void k() {
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.g, true);
            this.E.set(true);
            this.h = null;
            this.f6923a = null;
            this.f6924b = null;
            this.j = null;
            this.k = null;
            this.v = null;
            this.w = null;
            this.x = null;
            this.y.clear();
            this.l = null;
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            r();
        } catch (Throwable th) {
            u.c("NativeExpressView", "detach error", th);
        }
    }

    public void l() {
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.g, true);
            this.E.set(true);
        } catch (Throwable th) {
            u.a("NativeExpressView", "backupDestroy remove webview error", th);
        }
        try {
            if (this.m != null && this.m.getParent() != null) {
                removeView(this.m);
            }
        } catch (Throwable th2) {
            u.a("NativeExpressView", "backupDestroy remove video container error", th2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
        u.f("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f6929b;

        public a(int i) {
            this.f6929b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6929b == 1) {
                u.c("NativeExpressView", "MSG_RENDER_TIME_OUT-->OnAdRenderRunnable......run....");
                NativeExpressView.this.a(false, 0.0f, 0.0f, 107);
            }
        }
    }

    protected void a(final boolean z, final float f, final float f2, final int i) {
        r();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(z, f, f2, i);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressView.this.b(z, f, f2, i);
                }
            });
        }
    }

    private void r() {
        try {
            if (this.p != null && !this.p.isCancelled()) {
                u.b("NativeExpressView", "MSG_RENDER_TIME_OUT-->mRenderTimeOutFuture-->cancel.....success=" + this.p.cancel(false));
                this.p = null;
            }
        } catch (Throwable th) {
        }
    }

    public boolean m() {
        return this.r;
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.C).intValue();
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.D).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, float f, float f2, int i) {
        boolean z2 = true;
        if (!this.e.getAndSet(true)) {
            if (z) {
                this.G.b();
                a(f, f2);
                if (this.v != null) {
                    this.v.onRenderSuccess(this, f, f2);
                }
            } else {
                this.G.a(i);
                this.G.c();
                this.G.a(true);
                this.r = (this.q == null || !this.q.a(this, i)) ? false : false;
                this.G.d();
                if (this.r) {
                    o();
                    com.bytedance.sdk.openadsdk.c.d.h(com.bytedance.sdk.openadsdk.core.p.a(), this.k, this.i, "dynamic_backup_render", null);
                    this.s = (BackupView) findViewWithTag("tt_express_backup_fl_tag_26");
                    if (this.v != null) {
                        this.v.onRenderSuccess(this, this.s.getRealWidth(), this.s.getRealHeight());
                    }
                } else if (this.v != null) {
                    this.v.onRenderFail(this, com.bytedance.sdk.openadsdk.core.h.a(i), i);
                }
                a(i);
            }
            this.G.l();
            this.G.m();
        }
    }
}
