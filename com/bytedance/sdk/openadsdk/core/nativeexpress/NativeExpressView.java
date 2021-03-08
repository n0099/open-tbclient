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
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.u;
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
    private final AtomicBoolean A;
    private final AtomicBoolean B;
    private String C;
    private float D;
    private float E;
    private final AtomicBoolean F;
    private com.bytedance.sdk.openadsdk.c.j G;
    private p H;
    private com.bytedance.sdk.openadsdk.core.dynamic.a.a I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private int O;
    private String P;

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.dislike.b f4478a;
    private TTDislikeDialogAbstract b;
    private String c;
    private String d;
    private int e;
    protected final AtomicBoolean f;
    protected final Context g;
    protected WeakReference<SSWebView> h;
    protected x i;
    protected String j;
    protected AdSlot k;
    protected com.bytedance.sdk.openadsdk.core.d.l l;
    protected TTNativeExpressAd.ExpressVideoAdListener m;
    protected FrameLayout n;
    protected boolean o;
    protected boolean p;
    protected ScheduledFuture<?> q;
    protected c r;
    protected boolean s;
    protected BackupView t;
    private int v;
    private TTNativeExpressAd.ExpressAdInteractionListener w;
    private d x;
    private e y;
    private final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> z;

    public NativeExpressView(@NonNull Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot, String str) {
        super(context);
        this.f = new AtomicBoolean(false);
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
        this.g = context;
        this.l = lVar;
        d();
        a(adSlot);
        a();
    }

    private void a(AdSlot adSlot) {
        this.k = adSlot;
        if (this.k != null) {
            this.D = this.k.getExpressViewAcceptedWidth();
            this.E = this.k.getExpressViewAcceptedHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    private void c() {
        this.c = this.l.ag();
        this.d = this.l.aj();
        this.v = 3401;
        this.e = aj.a(this.j);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        JSONObject templateInfo;
        this.H = new p(1, this.j, this.l);
        this.i = new x(this.g);
        if ("feed_video_middle_page".equals(this.j)) {
            templateInfo = getMiddleTemplateInfo();
        } else {
            templateInfo = getTemplateInfo();
        }
        this.i.b(getWebView()).a(this.l).b(this.c).c(this.d).a(this.j).a(this.e).d(aj.i(this.l)).a((j) this).a(templateInfo).a(getWebView()).a(this.H);
        e();
    }

    private void e() {
        if (this.J) {
            this.I = new com.bytedance.sdk.openadsdk.core.dynamic.a.a(this.g);
            this.I.a(getWebView()).a(this.l).a(this.c).b(this.d).a(this.e).c(aj.i(this.l)).a(this).a(getTemplateInfo()).b(getWebView()).a(this.H);
        }
    }

    public SSWebView getWebView() {
        if (this.h != null && this.h.get() != null) {
            return this.h.get();
        }
        this.h = com.bytedance.sdk.openadsdk.core.widget.webview.d.a().c();
        return this.h.get();
    }

    private void f() {
        a(getWebView());
        this.G = new com.bytedance.sdk.openadsdk.c.j(this.g, this.l, getWebView()).a(false);
        this.G.a(this.H);
        getWebView().setWebViewClient(new f(this.g, this.i, this.l, this.G, n()));
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
                if (NativeExpressView.this.l != null && NativeExpressView.this.l.U() != null) {
                    NativeExpressView.this.l.U().a();
                }
                com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(NativeExpressView.this.g, str, NativeExpressView.this.l, NativeExpressView.this.j);
                NativeExpressView.this.z.put(str, a2);
                a2.e();
            }
        });
    }

    private boolean n() {
        return !TextUtils.isEmpty(this.j) && this.j.equals("splash_ad");
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            try {
                com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.g).a(false).a(sSWebView);
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
            } catch (Exception e) {
                u.f("NativeExpressView", e.toString());
            }
        }
    }

    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.m = expressVideoAdListener;
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (this.t != null) {
            this.t.setDislikeOuter(tTDislikeDialogAbstract);
        }
        this.b = tTDislikeDialogAbstract;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.dislike.b bVar) {
        if (this.t != null) {
            this.t.setDislikeInner(bVar);
        }
        this.f4478a = bVar;
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.w = expressAdInteractionListener;
    }

    public void setClickCreativeListener(d dVar) {
        this.x = dVar;
    }

    public d getClickCreativeListener() {
        return this.x;
    }

    public e getClickListener() {
        return this.y;
    }

    public void setClickListener(e eVar) {
        this.y = eVar;
    }

    public void setBackupListener(c cVar) {
        this.r = cVar;
    }

    public void g() {
        if (this.i != null && !this.F.get()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("expressShow", true);
                this.i.a("expressShow", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void h() {
        com.bytedance.sdk.openadsdk.core.d.r c;
        l.a M;
        this.B.set(true);
        this.H.a();
        this.q = com.bytedance.sdk.openadsdk.j.e.c().schedule(new a(1), com.bytedance.sdk.openadsdk.core.p.h().F(), TimeUnit.MILLISECONDS);
        if (!com.bytedance.sdk.openadsdk.core.widget.webview.a.a.e()) {
            o();
            a(false, 0.0f, 0.0f, 102, 1);
            return;
        }
        String c2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d() != null ? com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d().c() : null;
        if (TextUtils.isEmpty(c2)) {
            o();
            a(false, 0.0f, 0.0f, 102, 1);
            return;
        }
        if ("feed_video_middle_page".equals(this.j)) {
            c = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(this.l);
            if (this.l != null) {
                M = this.l.N();
            }
            M = null;
        } else {
            c = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(this.l);
            if (this.l != null) {
                M = this.l.M();
            }
            M = null;
        }
        if (c == null && !a(M)) {
            o();
            a(false, 0.0f, 0.0f, 103, 1);
            return;
        }
        String f = c != null ? c.f() : null;
        if (a(M) && !TextUtils.isEmpty(M.a())) {
            f = M.a();
        }
        if (com.bytedance.sdk.openadsdk.core.widget.webview.a.f.b(f) && !"https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/latest/index.html".equals(c2)) {
            o();
            a(false, 0.0f, 0.0f, 102, 1);
            return;
        }
        getWebView().loadUrl(ai.b(c2));
        o();
    }

    private boolean a(l.a aVar) {
        return (aVar == null || TextUtils.isEmpty(aVar.b()) || TextUtils.isEmpty(aVar.e())) ? false : true;
    }

    private JSONObject getTemplateInfo() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", HttpConstants.OS_TYPE_VALUE);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.D);
            jSONObject2.put("height", this.E);
            if (this.p) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", a(false));
            if (this.l.M() != null) {
                str2 = this.l.M().e();
                str = this.l.M().f();
            } else {
                str = null;
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.P = str2;
            } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(this.l) != null) {
                this.P = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(this.l).e();
            }
            jSONObject.put("template_Plugin", this.P);
            jSONObject.put("diff_template_Plugin", str);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    private JSONObject a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", this.l.af());
            if (this.l.U() != null) {
                jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, this.l.U().a());
            }
            JSONArray jSONArray = new JSONArray();
            if (this.l.Z() != null) {
                for (int i = 0; i < this.l.Z().size(); i++) {
                    com.bytedance.sdk.openadsdk.core.d.k kVar = this.l.Z().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", kVar.c());
                    jSONObject2.put("width", kVar.b());
                    jSONObject2.put("url", kVar.a());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", this.l.ak());
            jSONObject.put("interaction_type", this.l.T());
            jSONObject.put("is_compliance_template", a(this.l));
            jSONObject.put("title", this.l.ad());
            jSONObject.put("description", this.l.ae());
            jSONObject.put("source", this.l.S());
            if (this.l.ah() != null) {
                jSONObject.put("comment_num", this.l.ah().f());
                jSONObject.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.l.ah().e());
                jSONObject.put("app_size", this.l.ah().g());
                jSONObject.put("app", this.l.ah().h());
            }
            if (this.l.R() != null) {
                jSONObject.put("video", this.l.R().m());
            }
            if (z) {
                if (this.l.N() != null) {
                    jSONObject.put("dynamic_creative", this.l.N().g());
                }
            } else if (this.l.M() != null) {
                jSONObject.put("dynamic_creative", this.l.M().g());
            }
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    private JSONObject getMiddleTemplateInfo() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", HttpConstants.OS_TYPE_VALUE);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.D);
            jSONObject2.put("height", this.E);
            if (this.p) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", a(true));
            if (this.l.N() != null) {
                String e = this.l.N().e();
                str = this.l.N().f();
                str2 = e;
            } else {
                str = null;
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.P = str2;
            } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(this.l) != null) {
                this.P = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(this.l).e();
            }
            jSONObject.put("template_Plugin", this.P);
            jSONObject.put("diff_template_Plugin", str);
        } catch (Exception e2) {
        }
        return jSONObject;
    }

    private boolean a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return lVar != null && lVar.J() == 2;
    }

    public synchronized void a(com.bytedance.sdk.openadsdk.core.d.o oVar) {
        synchronized (this) {
            if (oVar == null) {
                a(false, 0.0f, 0.0f, 105, 1);
            } else {
                boolean b = oVar.b();
                float c = (float) oVar.c();
                float d = (float) oVar.d();
                int i = b ? 0 : oVar.i();
                b(oVar);
                a(b, c, d, i, oVar.a());
            }
        }
    }

    private void b(com.bytedance.sdk.openadsdk.core.d.o oVar) {
        boolean z = true;
        if (oVar != null) {
            if (oVar.a() == 1) {
                this.K = oVar.b();
            } else if (oVar.a() == 2) {
                this.L = (oVar.b() && q()) ? false : false;
            }
        }
    }

    private void o() {
        if (this.J) {
            this.I.a();
        }
    }

    private void a(float f, float f2) {
        if (f > 0.0f && f2 > 0.0f) {
            int a2 = (int) ak.a(this.g, f);
            int a3 = (int) ak.a(this.g, f2);
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
    }

    private void p() {
        if (this.J) {
            addView(this.I.b(), new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private boolean q() {
        DynamicRootView b = this.I.b();
        return (b == null || b.getChildCount() == 0) ? false : true;
    }

    public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (i != -1 && jVar != null) {
            int i2 = jVar.f4395a;
            int i3 = jVar.b;
            int i4 = jVar.c;
            int i5 = jVar.d;
            a(this.j);
            switch (i) {
                case 1:
                    if (this.n != null) {
                        this.n.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                    }
                    if (this.y != null) {
                        this.y.a(jVar);
                        this.y.a(this, i2, i3, i4, i5);
                    }
                    if (this.w != null) {
                        this.w.onAdClicked(this, this.l.T());
                        return;
                    }
                    return;
                case 2:
                    if (this.x != null) {
                        this.x.a(jVar);
                        this.x.a(this, i2, i3, i4, i5);
                    }
                    if (this.w != null) {
                        this.w.onAdClicked(this, this.l.T());
                        return;
                    }
                    return;
                case 3:
                    if (this.b != null) {
                        this.b.show();
                        return;
                    } else if (this.f4478a != null) {
                        this.f4478a.showDislikeDialog(0);
                        return;
                    } else {
                        TTDelegateActivity.a(this.l);
                        return;
                    }
                case 4:
                    if (this.n != null) {
                        this.n.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                    }
                    u.b("ClickCreativeListener", "创意....mAdType=" + this.j + ",!mVideoPause=" + (this.o ? false : true) + "，isAutoPlay=" + aj.j(this.l));
                    if ("embeded_ad".equals(this.j) && r() && !this.o && aj.j(this.l)) {
                        u.b("ClickCreativeListener", "创意....");
                        if (this.x != null) {
                            this.x.a(jVar);
                            this.x.a(this, i2, i3, i4, i5);
                        }
                    } else {
                        u.b("ClickCreativeListener", "普通....");
                        if (this.y != null) {
                            this.y.a(jVar);
                            this.y.a(this, i2, i3, i4, i5);
                        }
                    }
                    if (this.w != null) {
                        this.w.onAdClicked(this, this.l.T());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar, boolean z) {
        if (i != -1 && jVar != null) {
            int i2 = jVar.f4395a;
            int i3 = jVar.b;
            int i4 = jVar.c;
            int i5 = jVar.d;
            switch (i) {
                case 1:
                    if (this.n != null) {
                        this.n.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                    }
                    if (this.y != null) {
                        a(this.y.d(), z);
                        this.y.a(jVar);
                        this.y.a(this, i2, i3, i4, i5);
                    }
                    if (this.w != null) {
                        this.w.onAdClicked(this, this.l.T());
                        return;
                    }
                    return;
                case 2:
                    if (this.x != null) {
                        a(this.x.d(), z);
                        this.x.a(jVar);
                        this.x.a(this, i2, i3, i4, i5);
                    }
                    if (this.w != null) {
                        this.w.onAdClicked(this, this.l.T());
                        return;
                    }
                    return;
                case 3:
                    if (this.b != null) {
                        this.b.show();
                        return;
                    } else if (this.f4478a != null) {
                        this.f4478a.showDislikeDialog(0);
                        return;
                    } else {
                        TTDelegateActivity.a(this.l);
                        return;
                    }
                case 4:
                    if (this.n != null) {
                        this.n.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                    }
                    u.b("ClickCreativeListener", "创意....mAdType=" + this.j + ",!mVideoPause=" + (!this.o) + "，isAutoPlay=" + aj.j(this.l));
                    if ("embeded_ad".equals(this.j) && r() && !this.o && aj.j(this.l)) {
                        u.b("ClickCreativeListener", "创意....");
                        if (this.x != null) {
                            a(this.x.d(), z);
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
                    if (this.w != null) {
                        this.w.onAdClicked(this, this.l.T());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, boolean z) {
        if (aVar != null && (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d)) {
            ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).d(true);
            ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).e(z);
        }
    }

    private void a(String str) {
        if (this.l != null && !TextUtils.isEmpty(str) && str.equals("feed_video_middle_page")) {
            com.bytedance.sdk.openadsdk.c.d.b(com.bytedance.sdk.openadsdk.core.p.a(), this.l, "feed_video_middle_page", "middle_page_click");
        }
    }

    private boolean r() {
        return this.l != null && this.l.k() == 1 && com.bytedance.sdk.openadsdk.core.d.l.c(this.l);
    }

    private void a(int i) {
        com.bytedance.sdk.openadsdk.g.a.a().h(com.bytedance.sdk.openadsdk.g.a.c.b().a(getAdSlotType()).c(this.C).f(aj.h(this.d)).b(i).g(com.bytedance.sdk.openadsdk.core.h.a(i)));
    }

    private void s() {
        com.bytedance.sdk.openadsdk.g.a.a().a(com.bytedance.sdk.openadsdk.g.a.c.b().a(getAdSlotType()).c(this.C).f(aj.h(this.d)).a("dynamic_backup_render_new"));
    }

    private int getAdSlotType() {
        String str = this.j;
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
            case -891990144:
                if (str.equals("stream")) {
                    c = 7;
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
            case 7:
                return 6;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        u.f("webviewpool", "onAttachedToWindow+++");
        t();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        u.f("webviewpool", "onFinishTemporaryDetach+++");
        t();
    }

    private void t() {
        if (this.A.getAndSet(false) && getWebView().getParent() == null && !this.s) {
            u.f("webviewpool", "attachCallback+++========-----------===========");
            a();
            h();
        }
    }

    private void u() {
        if (!this.A.getAndSet(true) && !this.s) {
            com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.h, j());
        }
    }

    public void i() {
        if (getWebView() != null && !this.F.get()) {
            try {
                getWebView().resumeTimers();
            } catch (Exception e) {
            }
        }
    }

    boolean j() {
        if ("embeded_ad".equals(this.j) || "draw_ad".equals(this.j)) {
            return false;
        }
        this.F.set(true);
        return true;
    }

    public void k() {
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.h, true);
            this.F.set(true);
            this.i = null;
            this.f4478a = null;
            this.b = null;
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
            com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.h, true);
            this.F.set(true);
        } catch (Throwable th) {
            u.a("NativeExpressView", "backupDestroy remove webview error", th);
        }
        try {
            if (this.n != null && this.n.getParent() != null) {
                removeView(this.n);
            }
        } catch (Throwable th2) {
            u.a("NativeExpressView", "backupDestroy remove video container error", th2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
        u.f("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        private int b;

        public a(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b == 1) {
                u.c("NativeExpressView", "MSG_RENDER_TIME_OUT-->OnAdRenderRunnable......run....");
                NativeExpressView.this.a(false, 0.0f, 0.0f, 107, 1);
            }
        }
    }

    protected void a(final boolean z, final float f, final float f2, final int i, final int i2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(z, f, f2, i, i2);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (NativeExpressView.this.l != null) {
                        NativeExpressView.this.b(z, f, f2, i, i2);
                    }
                }
            });
        }
    }

    private void v() {
        try {
            if (this.q != null && !this.q.isCancelled()) {
                u.b("NativeExpressView", "MSG_RENDER_TIME_OUT-->mRenderTimeOutFuture-->cancel.....success=" + this.q.cancel(false));
                this.q = null;
            }
        } catch (Throwable th) {
        }
    }

    public boolean m() {
        return this.s;
    }

    public int getDynamicShowType() {
        return this.O;
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.D).intValue();
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.E).intValue();
    }

    private void w() {
        v();
        this.f.set(true);
    }

    private void a(boolean z, View view, float f, float f2, int i) {
        if (this.w != null) {
            if (z) {
                this.w.onRenderSuccess(view, f, f2);
            } else {
                this.w.onRenderFail(view, com.bytedance.sdk.openadsdk.core.h.a(i), i);
            }
        }
    }

    public x getJsObject() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, float f, float f2, int i, int i2) {
        if (i2 == 1) {
            this.M = true;
        } else if (i2 == 2) {
            this.N = true;
        }
        if (!this.f.get()) {
            if (!z && i2 == 1) {
                this.H.a(i);
                a(i);
            }
            boolean z2 = i == 107;
            if (z && i2 == 1) {
                w();
                this.H.b();
                a(f, f2);
                a(true, (View) this, f, f2, i);
            } else if (this.L && (this.M || z2)) {
                this.O = 2;
                w();
                p();
                com.bytedance.sdk.openadsdk.c.d.h(com.bytedance.sdk.openadsdk.core.p.a(), this.l, this.j, "dynamic_backup_native_render", null);
                this.t = (BackupView) findViewWithTag("tt_express_backup_fl_tag_26");
                a(true, (View) this, f, f2, i);
            } else if (z2 || (this.M && this.N)) {
                w();
                this.H.c();
                this.H.a(true);
                this.s = this.r != null && this.r.a(this, i);
                this.H.d();
                if (this.s) {
                    this.O = 1;
                    s();
                    com.bytedance.sdk.openadsdk.c.d.h(com.bytedance.sdk.openadsdk.core.p.a(), this.l, this.j, "dynamic_backup_render", null);
                    this.t = (BackupView) findViewWithTag("tt_express_backup_fl_tag_26");
                    a(true, (View) this, this.t == null ? f : this.t.getRealWidth(), this.t == null ? f2 : this.t.getRealHeight(), i);
                } else {
                    a(false, (View) this, f, f2, i);
                }
            } else {
                return;
            }
            this.H.l();
            this.H.m();
        }
    }
}
