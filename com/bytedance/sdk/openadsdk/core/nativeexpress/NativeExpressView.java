package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.u;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class NativeExpressView extends FrameLayout implements j {
    public static int u = 500;
    public final AtomicBoolean A;
    public final AtomicBoolean B;
    public String C;
    public float D;
    public float E;
    public final AtomicBoolean F;
    public com.bytedance.sdk.openadsdk.c.j G;
    public p H;
    public com.bytedance.sdk.openadsdk.core.dynamic.a.a I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public String P;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.b f28496a;

    /* renamed from: b  reason: collision with root package name */
    public TTDislikeDialogAbstract f28497b;

    /* renamed from: c  reason: collision with root package name */
    public String f28498c;

    /* renamed from: d  reason: collision with root package name */
    public String f28499d;

    /* renamed from: e  reason: collision with root package name */
    public int f28500e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f28501f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f28502g;

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<SSWebView> f28503h;
    public x i;
    public String j;
    public AdSlot k;
    public com.bytedance.sdk.openadsdk.core.d.l l;
    public TTNativeExpressAd.ExpressVideoAdListener m;
    public FrameLayout n;
    public boolean o;
    public boolean p;
    public ScheduledFuture<?> q;
    public c r;
    public boolean s;
    public BackupView t;
    public int v;
    public TTNativeExpressAd.ExpressAdInteractionListener w;
    public d x;
    public e y;
    public final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f28512b;

        public a(int i) {
            this.f28512b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f28512b == 1) {
                u.c("NativeExpressView", "MSG_RENDER_TIME_OUT-->OnAdRenderRunnable......run....");
                NativeExpressView.this.a(false, 0.0f, 0.0f, 107, 1);
            }
        }
    }

    public NativeExpressView(@NonNull Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot, String str) {
        super(context);
        this.f28501f = new AtomicBoolean(false);
        this.j = "embeded_ad";
        this.z = Collections.synchronizedMap(new HashMap());
        this.A = new AtomicBoolean(false);
        this.B = new AtomicBoolean(false);
        this.C = null;
        this.p = false;
        this.s = false;
        this.F = new AtomicBoolean(false);
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = 0;
        this.P = "{\"id\":0,\"tplId\":0,\"title\":\"\",\"data\":{\"id\":\"root\",\"type\":\"vessel\",\"values\":{\"widthMode\":\"fixed\",\"width\":320,\"height\":320},\"children\":[[{\"type\":\"text\",\"values\":{\"fontSize\":19,\"fontWeight\":500,\"color\":\"#222222\",\"lineHeight\":1.3,\"data\":\"title\"}}],[{\"type\":\"text\",\"values\":{\"fontSize\":15,\"fontWeight\":500,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"subtitle\"}}],[{\"type\":\"image\",\"values\":{},\"children\":[]}],[{\"type\":\"vessel\",\"values\":{\"height\":40,\"paddingTop\":10,\"paddingRight\":15,\"paddingBottom\":10,\"paddingLeft\":15},\"children\":[[{\"type\":\"logo\",\"values\":{}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":6,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"source\"}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":10,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"time\"}},{\"type\":\"empty\",\"values\":{\"height\":18}},{\"type\":\"dislike\",\"values\":{}}]]}]]}}";
        this.j = str;
        this.f28502g = context;
        this.l = lVar;
        d();
        a(adSlot);
        a();
    }

    private void c() {
        this.f28498c = this.l.am();
        this.f28499d = this.l.ap();
        this.v = 3455;
        this.f28500e = ak.a(this.j);
        this.C = this.k.getCodeId();
    }

    private void d() {
        if ("embeded_ad".equals(this.j)) {
            this.J = true;
            return;
        }
        this.L = false;
        this.N = true;
    }

    private void e() {
        if (this.J) {
            com.bytedance.sdk.openadsdk.core.dynamic.a.a aVar = new com.bytedance.sdk.openadsdk.core.dynamic.a.a(this.f28502g);
            this.I = aVar;
            aVar.a(getWebView()).a(this.l).a(this.f28498c).b(this.f28499d).a(this.f28500e).c(ak.i(this.l)).a(this).a(getTemplateInfo()).b(getWebView()).a(this.H);
        }
    }

    private void f() {
        a(getWebView());
        com.bytedance.sdk.openadsdk.c.j a2 = new com.bytedance.sdk.openadsdk.c.j(this.f28502g, this.l, getWebView()).a(false);
        this.G = a2;
        a2.a(this.H);
        getWebView().setWebViewClient(new f(this.f28502g, this.i, this.l, this.G, n()));
        getWebView().setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.i, this.G));
        getWebView().setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (NativeExpressView.this.z.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = (com.bytedance.sdk.openadsdk.downloadnew.core.a) NativeExpressView.this.z.get(str);
                    if (aVar != null) {
                        aVar.e();
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.core.d.l lVar = NativeExpressView.this.l;
                if (lVar != null && lVar.aa() != null) {
                    NativeExpressView.this.l.aa().a();
                }
                NativeExpressView nativeExpressView = NativeExpressView.this;
                com.bytedance.sdk.openadsdk.downloadnew.core.a a3 = com.bytedance.sdk.openadsdk.downloadnew.a.a(nativeExpressView.f28502g, str, nativeExpressView.l, nativeExpressView.j);
                NativeExpressView.this.z.put(str, a3);
                a3.e();
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getAdSlotType() {
        char c2;
        String str = this.j;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -891990144:
                if (str.equals("stream")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -712491894:
                if (str.equals("embeded_ad")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
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
            case 7:
                return 6;
            default:
                return 5;
        }
    }

    private JSONObject getMiddleTemplateInfo() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.D);
            jSONObject2.put("height", this.E);
            if (this.p) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", a(true));
            String str2 = null;
            if (this.l.T() != null) {
                str2 = this.l.T().e();
                str = this.l.T().f();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.P = str2;
            } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(this.l) != null) {
                this.P = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(this.l).e();
            }
            jSONObject.put("template_Plugin", this.P);
            jSONObject.put("diff_template_Plugin", str);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject getTemplateInfo() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.D);
            jSONObject2.put("height", this.E);
            if (this.p) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", a(false));
            if (this.l.S() != null) {
                str = this.l.S().e();
                str2 = this.l.S().f();
            } else {
                str = null;
                str2 = null;
            }
            if (!TextUtils.isEmpty(str)) {
                this.P = str;
            } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(this.l) != null) {
                this.P = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(this.l).e();
            }
            jSONObject.put("template_Plugin", this.P);
            jSONObject.put("diff_template_Plugin", str2);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean n() {
        return !TextUtils.isEmpty(this.j) && this.j.equals("splash_ad");
    }

    private void o() {
        if (this.J) {
            this.I.a();
        }
    }

    private void p() {
        if (this.J) {
            addView(this.I.b(), new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private boolean q() {
        DynamicRootView b2 = this.I.b();
        return (b2 == null || b2.getChildCount() == 0) ? false : true;
    }

    private boolean r() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.l;
        return lVar != null && lVar.k() == 1 && com.bytedance.sdk.openadsdk.core.d.l.c(this.l);
    }

    private void s() {
        com.bytedance.sdk.openadsdk.h.a.a().a(com.bytedance.sdk.openadsdk.h.a.c.b().a(getAdSlotType()).c(this.C).f(ak.h(this.f28499d)).a("dynamic_backup_render_new"));
    }

    private void t() {
        if (this.A.getAndSet(false) && getWebView().getParent() == null && !this.s) {
            u.f("webviewpool", "attachCallback+++========-----------===========");
            a();
            h();
        }
    }

    private void u() {
        if (this.A.getAndSet(true) || this.s) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.f28503h, j());
    }

    private void v() {
        try {
            if (this.q == null || this.q.isCancelled()) {
                return;
            }
            boolean cancel = this.q.cancel(false);
            u.b("NativeExpressView", "MSG_RENDER_TIME_OUT-->mRenderTimeOutFuture-->cancel.....success=" + cancel);
            this.q = null;
        } catch (Throwable unused) {
        }
    }

    private void w() {
        v();
        this.f28501f.set(true);
    }

    public void b() {
        JSONObject templateInfo;
        this.H = new p(1, this.j, this.l);
        this.i = new x(this.f28502g);
        if ("feed_video_middle_page".equals(this.j)) {
            templateInfo = getMiddleTemplateInfo();
        } else {
            templateInfo = getTemplateInfo();
        }
        this.i.b(getWebView()).a(this.l).b(this.f28498c).c(this.f28499d).a(this.j).a(this.f28500e).d(ak.i(this.l)).a((j) this).a(templateInfo).a(getWebView()).a(this.H);
        e();
    }

    public void g() {
        if (this.i == null || this.F.get()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.i.a("expressShow", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public d getClickCreativeListener() {
        return this.x;
    }

    public e getClickListener() {
        return this.y;
    }

    public int getDynamicShowType() {
        return this.O;
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.E).intValue();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.D).intValue();
    }

    public x getJsObject() {
        return this.i;
    }

    public SSWebView getWebView() {
        WeakReference<SSWebView> weakReference = this.f28503h;
        if (weakReference != null && weakReference.get() != null) {
            return this.f28503h.get();
        }
        WeakReference<SSWebView> c2 = com.bytedance.sdk.openadsdk.core.widget.webview.d.a().c();
        this.f28503h = c2;
        return c2.get();
    }

    public void h() {
        t c2;
        l.a S;
        this.B.set(true);
        this.H.a();
        this.q = com.bytedance.sdk.openadsdk.l.e.d().schedule(new a(1), com.bytedance.sdk.openadsdk.core.p.h().F(), TimeUnit.MILLISECONDS);
        if (!com.bytedance.sdk.openadsdk.core.widget.webview.a.a.e()) {
            o();
            a(false, 0.0f, 0.0f, 102, 1);
            return;
        }
        String c3 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d() != null ? com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d().c() : null;
        if (TextUtils.isEmpty(c3)) {
            o();
            a(false, 0.0f, 0.0f, 102, 1);
            return;
        }
        if ("feed_video_middle_page".equals(this.j)) {
            c2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(this.l);
            com.bytedance.sdk.openadsdk.core.d.l lVar = this.l;
            if (lVar != null) {
                S = lVar.T();
            }
            S = null;
        } else {
            c2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(this.l);
            com.bytedance.sdk.openadsdk.core.d.l lVar2 = this.l;
            if (lVar2 != null) {
                S = lVar2.S();
            }
            S = null;
        }
        if (c2 == null && !a(S)) {
            o();
            a(false, 0.0f, 0.0f, 103, 1);
            return;
        }
        String f2 = c2 != null ? c2.f() : null;
        if (a(S) && !TextUtils.isEmpty(S.a())) {
            f2 = S.a();
        }
        if (com.bytedance.sdk.openadsdk.core.widget.webview.a.f.b(f2) && !"https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/latest/index.html".equals(c3)) {
            o();
            a(false, 0.0f, 0.0f, 102, 1);
            return;
        }
        getWebView().loadUrl(aj.b(c3));
        o();
    }

    public void i() {
        if (getWebView() != null && !this.F.get()) {
            try {
                getWebView().resumeTimers();
            } catch (Exception unused) {
            }
        }
    }

    public boolean j() {
        if ("embeded_ad".equals(this.j) || "draw_ad".equals(this.j)) {
            return false;
        }
        this.F.set(true);
        return true;
    }

    public void k() {
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.f28503h, true);
            this.F.set(true);
            this.i = null;
            this.f28496a = null;
            this.f28497b = null;
            this.k = null;
            this.l = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z.clear();
            this.m = null;
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            v();
        } catch (Throwable th) {
            u.c("NativeExpressView", "detach error", th);
        }
    }

    public void l() {
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.f28503h, true);
            this.F.set(true);
        } catch (Throwable th) {
            u.a("NativeExpressView", "backupDestroy remove webview error", th);
        }
        try {
            if (this.n == null || this.n.getParent() == null) {
                return;
            }
            removeView(this.n);
        } catch (Throwable th2) {
            u.a("NativeExpressView", "backupDestroy remove video container error", th2);
        }
    }

    public boolean m() {
        return this.s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        u.f("webviewpool", "onAttachedToWindow+++");
        t();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
        u.f("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        u.f("webviewpool", "onFinishTemporaryDetach+++");
        t();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        u();
    }

    public void setBackupListener(c cVar) {
        this.r = cVar;
    }

    public void setClickCreativeListener(d dVar) {
        this.x = dVar;
    }

    public void setClickListener(e eVar) {
        this.y = eVar;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.dislike.b bVar) {
        BackupView backupView = this.t;
        if (backupView != null) {
            backupView.setDislikeInner(bVar);
        }
        this.f28496a = bVar;
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.w = expressAdInteractionListener;
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        BackupView backupView = this.t;
        if (backupView != null) {
            backupView.setDislikeOuter(tTDislikeDialogAbstract);
        }
        this.f28497b = tTDislikeDialogAbstract;
    }

    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.m = expressVideoAdListener;
    }

    private void a(AdSlot adSlot) {
        this.k = adSlot;
        if (adSlot == null) {
            return;
        }
        this.D = adSlot.getExpressViewAcceptedWidth();
        this.E = this.k.getExpressViewAcceptedHeight();
    }

    public void a() {
        setBackgroundColor(0);
        if (getWebView().getParent() != null) {
            ((ViewGroup) getWebView().getParent()).removeView(getWebView());
        }
        getWebView().setBackgroundColor(0);
        c();
        b();
        f();
        getWebView().addJavascriptInterface(this.i, "SDK_INJECT_GLOBAL");
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.f28502g).a(false).a(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.clearCache(true);
            sSWebView.clearHistory();
            WebSettings settings = sSWebView.getSettings();
            settings.setUserAgentString(r.a(sSWebView, this.v));
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setCacheMode(2);
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setUseWideViewPort(true);
        } catch (Exception e2) {
            u.f("NativeExpressView", e2.toString());
        }
    }

    private void b(com.bytedance.sdk.openadsdk.core.d.o oVar) {
        if (oVar == null) {
            return;
        }
        boolean z = true;
        if (oVar.a() == 1) {
            this.K = oVar.b();
        } else if (oVar.a() == 2) {
            this.L = (oVar.b() && q()) ? false : false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, float f2, float f3, int i, int i2) {
        if (i2 == 1) {
            this.M = true;
        } else if (i2 == 2) {
            this.N = true;
        }
        if (this.f28501f.get()) {
            return;
        }
        if (!z && i2 == 1) {
            this.H.a(i);
            a(i);
        }
        boolean z2 = false;
        boolean z3 = i == 107;
        if (z && i2 == 1) {
            w();
            this.H.b();
            a(f2, f3);
            a(true, (View) this, f2, f3, i);
        } else if (this.L && (this.M || z3)) {
            this.O = 2;
            w();
            p();
            com.bytedance.sdk.openadsdk.c.d.h(com.bytedance.sdk.openadsdk.core.p.a(), this.l, this.j, "dynamic_backup_native_render", null);
            this.t = (BackupView) findViewWithTag("tt_express_backup_fl_tag_26");
            a(true, (View) this, f2, f3, i);
        } else if (!z3 && (!this.M || !this.N)) {
            return;
        } else {
            w();
            this.H.c();
            this.H.a(true);
            c cVar = this.r;
            if (cVar != null && cVar.a(this, i)) {
                z2 = true;
            }
            this.s = z2;
            this.H.d();
            if (this.s) {
                this.O = 1;
                s();
                com.bytedance.sdk.openadsdk.c.d.h(com.bytedance.sdk.openadsdk.core.p.a(), this.l, this.j, "dynamic_backup_render", null);
                BackupView backupView = (BackupView) findViewWithTag("tt_express_backup_fl_tag_26");
                this.t = backupView;
                float realWidth = backupView == null ? f2 : backupView.getRealWidth();
                BackupView backupView2 = this.t;
                a(true, (View) this, realWidth, backupView2 == null ? f3 : backupView2.getRealHeight(), i);
            } else {
                a(false, (View) this, f2, f3, i);
            }
        }
        this.H.l();
        this.H.m();
    }

    private boolean a(l.a aVar) {
        return (aVar == null || TextUtils.isEmpty(aVar.b()) || TextUtils.isEmpty(aVar.e())) ? false : true;
    }

    private JSONObject a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", this.l.al());
            if (this.l.aa() != null) {
                jSONObject.put("icon", this.l.aa().a());
            }
            JSONArray jSONArray = new JSONArray();
            if (this.l.af() != null) {
                for (int i = 0; i < this.l.af().size(); i++) {
                    com.bytedance.sdk.openadsdk.core.d.k kVar = this.l.af().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", kVar.c());
                    jSONObject2.put("width", kVar.b());
                    jSONObject2.put("url", kVar.a());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", this.l.aq());
            jSONObject.put("interaction_type", this.l.Z());
            jSONObject.put("is_compliance_template", a(this.l));
            jSONObject.put("title", this.l.aj());
            jSONObject.put("description", this.l.ak());
            jSONObject.put("source", this.l.Y());
            if (this.l.an() != null) {
                jSONObject.put("comment_num", this.l.an().f());
                jSONObject.put("score", this.l.an().e());
                jSONObject.put("app_size", this.l.an().g());
                jSONObject.put("app", this.l.an().h());
            }
            if (this.l.X() != null) {
                jSONObject.put("video", this.l.X().m());
            }
            if (z) {
                if (this.l.T() != null) {
                    jSONObject.put("dynamic_creative", this.l.T().g());
                }
            } else if (this.l.S() != null) {
                jSONObject.put("dynamic_creative", this.l.S().g());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return lVar != null && lVar.J() == 2;
    }

    public synchronized void a(com.bytedance.sdk.openadsdk.core.d.o oVar) {
        if (oVar == null) {
            a(false, 0.0f, 0.0f, 105, 1);
            return;
        }
        boolean b2 = oVar.b();
        float c2 = (float) oVar.c();
        float d2 = (float) oVar.d();
        int i = b2 ? 0 : oVar.i();
        b(oVar);
        a(b2, c2, d2, i, oVar.a());
    }

    private void a(float f2, float f3) {
        if (f2 <= 0.0f || f3 <= 0.0f) {
            return;
        }
        int a2 = (int) al.a(this.f28502g, f2);
        int a3 = (int) al.a(this.f28502g, f3);
        u.f("ExpressView", "width:" + a2);
        u.f("ExpressView", "height:" + a3);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getWebView().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(a2, a3);
        }
        layoutParams.width = a2;
        layoutParams.height = a3;
        getWebView().setLayoutParams(layoutParams);
        addView(getWebView());
    }

    public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (i == -1 || jVar == null) {
            return;
        }
        int i2 = jVar.f28157a;
        int i3 = jVar.f28158b;
        int i4 = jVar.f28159c;
        int i5 = jVar.f28160d;
        a(this.j);
        if (i == 1) {
            FrameLayout frameLayout = this.n;
            if (frameLayout != null) {
                frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            e eVar = this.y;
            if (eVar != null) {
                eVar.a(jVar);
                this.y.a(this, i2, i3, i4, i5);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.w;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onAdClicked(this, this.l.Z());
            }
        } else if (i == 2) {
            d dVar = this.x;
            if (dVar != null) {
                dVar.a(jVar);
                this.x.a(this, i2, i3, i4, i5);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.w;
            if (expressAdInteractionListener2 != null) {
                expressAdInteractionListener2.onAdClicked(this, this.l.Z());
            }
        } else if (i == 3) {
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f28497b;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.show();
                return;
            }
            com.bytedance.sdk.openadsdk.dislike.b bVar = this.f28496a;
            if (bVar != null) {
                bVar.showDislikeDialog(0);
            } else {
                TTDelegateActivity.a(getContext(), this.l);
            }
        } else if (i != 4) {
        } else {
            FrameLayout frameLayout2 = this.n;
            if (frameLayout2 != null) {
                frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            u.b("ClickCreativeListener", "创意....mAdType=" + this.j + ",!mVideoPause=" + (true ^ this.o) + "，isAutoPlay=" + ak.j(this.l));
            if ("embeded_ad".equals(this.j) && r() && !this.o && ak.j(this.l)) {
                u.b("ClickCreativeListener", "创意....");
                d dVar2 = this.x;
                if (dVar2 != null) {
                    dVar2.a(jVar);
                    this.x.a(this, i2, i3, i4, i5);
                }
            } else {
                u.b("ClickCreativeListener", "普通....");
                e eVar2 = this.y;
                if (eVar2 != null) {
                    eVar2.a(jVar);
                    this.y.a(this, i2, i3, i4, i5);
                }
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.w;
            if (expressAdInteractionListener3 != null) {
                expressAdInteractionListener3.onAdClicked(this, this.l.Z());
            }
        }
    }

    public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar, boolean z) {
        if (i == -1 || jVar == null) {
            return;
        }
        int i2 = jVar.f28157a;
        int i3 = jVar.f28158b;
        int i4 = jVar.f28159c;
        int i5 = jVar.f28160d;
        if (i == 1) {
            FrameLayout frameLayout = this.n;
            if (frameLayout != null) {
                frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            e eVar = this.y;
            if (eVar != null) {
                a(eVar.d(), z);
                this.y.a(jVar);
                this.y.a(this, i2, i3, i4, i5);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.w;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onAdClicked(this, this.l.Z());
            }
        } else if (i == 2) {
            d dVar = this.x;
            if (dVar != null) {
                a(dVar.d(), z);
                this.x.a(jVar);
                this.x.a(this, i2, i3, i4, i5);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.w;
            if (expressAdInteractionListener2 != null) {
                expressAdInteractionListener2.onAdClicked(this, this.l.Z());
            }
        } else if (i == 3) {
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f28497b;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.show();
                return;
            }
            com.bytedance.sdk.openadsdk.dislike.b bVar = this.f28496a;
            if (bVar != null) {
                bVar.showDislikeDialog(0);
            } else {
                TTDelegateActivity.a(getContext(), this.l);
            }
        } else if (i != 4) {
        } else {
            FrameLayout frameLayout2 = this.n;
            if (frameLayout2 != null) {
                frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            u.b("ClickCreativeListener", "创意....mAdType=" + this.j + ",!mVideoPause=" + (true ^ this.o) + "，isAutoPlay=" + ak.j(this.l));
            if ("embeded_ad".equals(this.j) && r() && !this.o && ak.j(this.l)) {
                u.b("ClickCreativeListener", "创意....");
                d dVar2 = this.x;
                if (dVar2 != null) {
                    a(dVar2.d(), z);
                    this.x.a(jVar);
                    this.x.a(this, i2, i3, i4, i5);
                }
            } else {
                u.b("ClickCreativeListener", "普通....");
                if (this.y != null) {
                    a(this.x.d(), z);
                    this.y.a(jVar);
                    this.y.a(this, i2, i3, i4, i5);
                }
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.w;
            if (expressAdInteractionListener3 != null) {
                expressAdInteractionListener3.onAdClicked(this, this.l.Z());
            }
        }
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, boolean z) {
        if (aVar != null && (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d)) {
            com.bytedance.sdk.openadsdk.downloadnew.a.d dVar = (com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar;
            dVar.d(true);
            dVar.e(z);
        }
    }

    private void a(String str) {
        if (this.l == null || TextUtils.isEmpty(str) || !str.equals("feed_video_middle_page")) {
            return;
        }
        com.bytedance.sdk.openadsdk.c.d.b(com.bytedance.sdk.openadsdk.core.p.a(), this.l, "feed_video_middle_page", "middle_page_click");
    }

    private void a(int i) {
        com.bytedance.sdk.openadsdk.h.a.a().h(com.bytedance.sdk.openadsdk.h.a.c.b().a(getAdSlotType()).c(this.C).f(ak.h(this.f28499d)).b(i).g(com.bytedance.sdk.openadsdk.core.h.a(i)));
    }

    public void a(final boolean z, final float f2, final float f3, final int i, final int i2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(z, f2, f3, i, i2);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    if (nativeExpressView.l == null) {
                        return;
                    }
                    nativeExpressView.b(z, f2, f3, i, i2);
                }
            });
        }
    }

    private void a(boolean z, View view, float f2, float f3, int i) {
        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.w;
        if (expressAdInteractionListener == null) {
            return;
        }
        if (z) {
            expressAdInteractionListener.onRenderSuccess(view, f2, f3);
        } else {
            expressAdInteractionListener.onRenderFail(view, com.bytedance.sdk.openadsdk.core.h.a(i), i);
        }
    }
}
