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
    public String f28800a;

    /* renamed from: b  reason: collision with root package name */
    public String f28801b;

    /* renamed from: c  reason: collision with root package name */
    public int f28802c;

    /* renamed from: d  reason: collision with root package name */
    public String f28803d;

    /* renamed from: e  reason: collision with root package name */
    public l f28804e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f28805f;

    /* renamed from: g  reason: collision with root package name */
    public DynamicRootView f28806g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.dynamic.c.a f28807h;

    /* renamed from: i  reason: collision with root package name */
    public Context f28808i;

    public a(Context context) {
        this.f28808i = context;
        this.f28806g = new DynamicRootView(context);
        this.f28807h = new com.bytedance.sdk.openadsdk.core.dynamic.c.a(this.f28808i);
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        if (p.h() != null) {
            try {
                int d2 = ak.d(this.f28801b);
                int g2 = p.h().g(String.valueOf(d2));
                boolean b2 = p.h().b(String.valueOf(d2));
                jSONObject.put("voice_control", p.h().b(d2));
                jSONObject.put("rv_skip_time", g2);
                jSONObject.put("fv_skip_show", b2);
                jSONObject.put("show_dislike", this.f28804e != null && this.f28804e.aJ());
                jSONObject.put("video_adaptation", this.f28804e != null ? this.f28804e.l() : 0);
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
        this.f28801b = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b c(String str) {
        this.f28803d = str;
        return this;
    }

    private String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f28805f != null) {
                this.f28805f.put(com.alipay.sdk.sys.a.j, d());
            }
            jSONObject.put("templateInfo", this.f28805f);
            jSONObject.put("adInfo", new com.bytedance.sdk.openadsdk.core.dynamic.b.a(this.f28804e).a());
            jSONObject.put(DI.APP_INFO_NAME, new com.bytedance.sdk.openadsdk.core.dynamic.b.b().a());
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(j jVar) {
        this.f28806g.setRenderListener(jVar);
        return this;
    }

    public DynamicRootView b() {
        return this.f28806g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(l lVar) {
        this.f28804e = lVar;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(String str) {
        this.f28800a = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(int i2) {
        this.f28802c = i2;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(JSONObject jSONObject) {
        this.f28805f = jSONObject;
        return this;
    }

    public void a() {
        this.f28807h.a(new c() { // from class: com.bytedance.sdk.openadsdk.core.dynamic.a.a.1
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
        this.f28807h.b(c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (fVar == null) {
            this.f28806g.b();
            return;
        }
        try {
            DynamicBaseWidgetImp dynamicBaseWidgetImp = new DynamicBaseWidgetImp(this.f28808i, this.f28806g, fVar);
            a(fVar, dynamicBaseWidgetImp);
            this.f28806g.setDynamicBaseWidget(dynamicBaseWidgetImp);
            this.f28806g.a();
        } catch (Exception unused) {
            this.f28806g.b();
        }
    }

    private void a(f fVar, DynamicBaseWidget dynamicBaseWidget) {
        List<f> f2;
        if (fVar == null || dynamicBaseWidget == null || (f2 = fVar.f()) == null || f2.size() <= 0) {
            return;
        }
        for (f fVar2 : fVar.f()) {
            if (fVar2 != null) {
                DynamicBaseWidget a2 = b.a(this.f28808i, this.f28806g, fVar2);
                a(fVar2, a2);
                dynamicBaseWidget.a(a2);
            }
        }
    }
}
