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
/* loaded from: classes6.dex */
public class a implements com.bytedance.sdk.openadsdk.core.dynamic.d.b {

    /* renamed from: a  reason: collision with root package name */
    public String f28045a;

    /* renamed from: b  reason: collision with root package name */
    public String f28046b;

    /* renamed from: c  reason: collision with root package name */
    public int f28047c;

    /* renamed from: d  reason: collision with root package name */
    public String f28048d;

    /* renamed from: e  reason: collision with root package name */
    public l f28049e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f28050f;

    /* renamed from: g  reason: collision with root package name */
    public DynamicRootView f28051g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.dynamic.c.a f28052h;

    /* renamed from: i  reason: collision with root package name */
    public Context f28053i;

    public a(Context context) {
        this.f28053i = context;
        this.f28051g = new DynamicRootView(context);
        this.f28052h = new com.bytedance.sdk.openadsdk.core.dynamic.c.a(this.f28053i);
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        if (p.h() != null) {
            try {
                int d2 = ak.d(this.f28046b);
                int g2 = p.h().g(String.valueOf(d2));
                boolean b2 = p.h().b(String.valueOf(d2));
                jSONObject.put("voice_control", p.h().b(d2));
                jSONObject.put("rv_skip_time", g2);
                jSONObject.put("fv_skip_show", b2);
                jSONObject.put("show_dislike", this.f28049e != null && this.f28049e.aJ());
                jSONObject.put("video_adaptation", this.f28049e != null ? this.f28049e.l() : 0);
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
        this.f28046b = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b c(String str) {
        this.f28048d = str;
        return this;
    }

    private String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f28050f != null) {
                this.f28050f.put(com.alipay.sdk.sys.a.j, d());
            }
            jSONObject.put("templateInfo", this.f28050f);
            jSONObject.put("adInfo", new com.bytedance.sdk.openadsdk.core.dynamic.b.a(this.f28049e).a());
            jSONObject.put(DI.APP_INFO_NAME, new com.bytedance.sdk.openadsdk.core.dynamic.b.b().a());
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(j jVar) {
        this.f28051g.setRenderListener(jVar);
        return this;
    }

    public DynamicRootView b() {
        return this.f28051g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(l lVar) {
        this.f28049e = lVar;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(String str) {
        this.f28045a = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(int i2) {
        this.f28047c = i2;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(JSONObject jSONObject) {
        this.f28050f = jSONObject;
        return this;
    }

    public void a() {
        this.f28052h.a(new c() { // from class: com.bytedance.sdk.openadsdk.core.dynamic.a.a.1
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
        this.f28052h.b(c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (fVar == null) {
            this.f28051g.b();
            return;
        }
        try {
            DynamicBaseWidgetImp dynamicBaseWidgetImp = new DynamicBaseWidgetImp(this.f28053i, this.f28051g, fVar);
            a(fVar, dynamicBaseWidgetImp);
            this.f28051g.setDynamicBaseWidget(dynamicBaseWidgetImp);
            this.f28051g.a();
        } catch (Exception unused) {
            this.f28051g.b();
        }
    }

    private void a(f fVar, DynamicBaseWidget dynamicBaseWidget) {
        List<f> f2;
        if (fVar == null || dynamicBaseWidget == null || (f2 = fVar.f()) == null || f2.size() <= 0) {
            return;
        }
        for (f fVar2 : fVar.f()) {
            if (fVar2 != null) {
                DynamicBaseWidget a2 = b.a(this.f28053i, this.f28051g, fVar2);
                a(fVar2, a2);
                dynamicBaseWidget.a(a2);
            }
        }
    }
}
