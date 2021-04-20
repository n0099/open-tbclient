package com.bytedance.sdk.openadsdk.core.dynamic.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.searchbox.live.interfaces.DI;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.dynamic.d.c;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a implements com.bytedance.sdk.openadsdk.core.dynamic.d.b {

    /* renamed from: a  reason: collision with root package name */
    public String f27939a;

    /* renamed from: b  reason: collision with root package name */
    public String f27940b;

    /* renamed from: c  reason: collision with root package name */
    public int f27941c;

    /* renamed from: d  reason: collision with root package name */
    public String f27942d;

    /* renamed from: e  reason: collision with root package name */
    public l f27943e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f27944f;

    /* renamed from: g  reason: collision with root package name */
    public DynamicRootView f27945g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.dynamic.c.a f27946h;
    public Context i;

    public a(Context context) {
        this.i = context;
        this.f27945g = new DynamicRootView(context);
        this.f27946h = new com.bytedance.sdk.openadsdk.core.dynamic.c.a(this.i);
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        if (p.h() != null) {
            try {
                int d2 = ak.d(this.f27940b);
                int g2 = p.h().g(String.valueOf(d2));
                boolean b2 = p.h().b(String.valueOf(d2));
                jSONObject.put("voice_control", p.h().b(d2));
                jSONObject.put("rv_skip_time", g2);
                jSONObject.put("fv_skip_show", b2);
                jSONObject.put("show_dislike", this.f27943e != null && this.f27943e.aJ());
                jSONObject.put("video_adaptation", this.f27943e != null ? this.f27943e.l() : 0);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(com.bytedance.sdk.openadsdk.c.p pVar) {
        return this;
    }

    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(SSWebView sSWebView) {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b b(SSWebView sSWebView) {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b b(String str) {
        this.f27940b = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b c(String str) {
        this.f27942d = str;
        return this;
    }

    private String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f27944f != null) {
                this.f27944f.put(com.alipay.sdk.sys.a.j, d());
            }
            jSONObject.put("templateInfo", this.f27944f);
            jSONObject.put("adInfo", new com.bytedance.sdk.openadsdk.core.dynamic.b.a(this.f27943e).a());
            jSONObject.put(DI.APP_INFO_NAME, new com.bytedance.sdk.openadsdk.core.dynamic.b.b().a());
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(j jVar) {
        this.f27945g.setRenderListener(jVar);
        return this;
    }

    public DynamicRootView b() {
        return this.f27945g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(l lVar) {
        this.f27943e = lVar;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(String str) {
        this.f27939a = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(int i) {
        this.f27941c = i;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(JSONObject jSONObject) {
        this.f27944f = jSONObject;
        return this;
    }

    public void a() {
        this.f27946h.a(new c() { // from class: com.bytedance.sdk.openadsdk.core.dynamic.a.a.1
            @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.c
            public void a(final f fVar) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dynamic.a.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(fVar);
                    }
                });
            }
        });
        this.f27946h.b(c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (fVar == null) {
            this.f27945g.b();
            return;
        }
        try {
            DynamicBaseWidgetImp dynamicBaseWidgetImp = new DynamicBaseWidgetImp(this.i, this.f27945g, fVar);
            a(fVar, dynamicBaseWidgetImp);
            this.f27945g.setDynamicBaseWidget(dynamicBaseWidgetImp);
            this.f27945g.a();
        } catch (Exception unused) {
            this.f27945g.b();
        }
    }

    private void a(f fVar, DynamicBaseWidget dynamicBaseWidget) {
        List<f> f2;
        if (fVar == null || dynamicBaseWidget == null || (f2 = fVar.f()) == null || f2.size() <= 0) {
            return;
        }
        for (f fVar2 : fVar.f()) {
            if (fVar2 != null) {
                DynamicBaseWidget a2 = b.a(this.i, this.f27945g, fVar2);
                a(fVar2, a2);
                dynamicBaseWidget.a(a2);
            }
        }
    }
}
