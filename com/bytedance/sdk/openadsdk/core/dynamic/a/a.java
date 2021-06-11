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
    public String f28077a;

    /* renamed from: b  reason: collision with root package name */
    public String f28078b;

    /* renamed from: c  reason: collision with root package name */
    public int f28079c;

    /* renamed from: d  reason: collision with root package name */
    public String f28080d;

    /* renamed from: e  reason: collision with root package name */
    public l f28081e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f28082f;

    /* renamed from: g  reason: collision with root package name */
    public DynamicRootView f28083g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.dynamic.c.a f28084h;

    /* renamed from: i  reason: collision with root package name */
    public Context f28085i;

    public a(Context context) {
        this.f28085i = context;
        this.f28083g = new DynamicRootView(context);
        this.f28084h = new com.bytedance.sdk.openadsdk.core.dynamic.c.a(this.f28085i);
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        if (p.h() != null) {
            try {
                int d2 = ak.d(this.f28078b);
                int g2 = p.h().g(String.valueOf(d2));
                boolean b2 = p.h().b(String.valueOf(d2));
                jSONObject.put("voice_control", p.h().b(d2));
                jSONObject.put("rv_skip_time", g2);
                jSONObject.put("fv_skip_show", b2);
                jSONObject.put("show_dislike", this.f28081e != null && this.f28081e.aJ());
                jSONObject.put("video_adaptation", this.f28081e != null ? this.f28081e.l() : 0);
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
        this.f28078b = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b c(String str) {
        this.f28080d = str;
        return this;
    }

    private String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f28082f != null) {
                this.f28082f.put(com.alipay.sdk.sys.a.j, d());
            }
            jSONObject.put("templateInfo", this.f28082f);
            jSONObject.put("adInfo", new com.bytedance.sdk.openadsdk.core.dynamic.b.a(this.f28081e).a());
            jSONObject.put(DI.APP_INFO_NAME, new com.bytedance.sdk.openadsdk.core.dynamic.b.b().a());
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(j jVar) {
        this.f28083g.setRenderListener(jVar);
        return this;
    }

    public DynamicRootView b() {
        return this.f28083g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(l lVar) {
        this.f28081e = lVar;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(String str) {
        this.f28077a = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(int i2) {
        this.f28079c = i2;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(JSONObject jSONObject) {
        this.f28082f = jSONObject;
        return this;
    }

    public void a() {
        this.f28084h.a(new c() { // from class: com.bytedance.sdk.openadsdk.core.dynamic.a.a.1
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
        this.f28084h.b(c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (fVar == null) {
            this.f28083g.b();
            return;
        }
        try {
            DynamicBaseWidgetImp dynamicBaseWidgetImp = new DynamicBaseWidgetImp(this.f28085i, this.f28083g, fVar);
            a(fVar, dynamicBaseWidgetImp);
            this.f28083g.setDynamicBaseWidget(dynamicBaseWidgetImp);
            this.f28083g.a();
        } catch (Exception unused) {
            this.f28083g.b();
        }
    }

    private void a(f fVar, DynamicBaseWidget dynamicBaseWidget) {
        List<f> f2;
        if (fVar == null || dynamicBaseWidget == null || (f2 = fVar.f()) == null || f2.size() <= 0) {
            return;
        }
        for (f fVar2 : fVar.f()) {
            if (fVar2 != null) {
                DynamicBaseWidget a2 = b.a(this.f28085i, this.f28083g, fVar2);
                a(fVar2, a2);
                dynamicBaseWidget.a(a2);
            }
        }
    }
}
