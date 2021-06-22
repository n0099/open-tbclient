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
    public String f28159a;

    /* renamed from: b  reason: collision with root package name */
    public String f28160b;

    /* renamed from: c  reason: collision with root package name */
    public int f28161c;

    /* renamed from: d  reason: collision with root package name */
    public String f28162d;

    /* renamed from: e  reason: collision with root package name */
    public l f28163e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f28164f;

    /* renamed from: g  reason: collision with root package name */
    public DynamicRootView f28165g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.dynamic.c.a f28166h;

    /* renamed from: i  reason: collision with root package name */
    public Context f28167i;

    public a(Context context) {
        this.f28167i = context;
        this.f28165g = new DynamicRootView(context);
        this.f28166h = new com.bytedance.sdk.openadsdk.core.dynamic.c.a(this.f28167i);
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        if (p.h() != null) {
            try {
                int d2 = ak.d(this.f28160b);
                int g2 = p.h().g(String.valueOf(d2));
                boolean b2 = p.h().b(String.valueOf(d2));
                jSONObject.put("voice_control", p.h().b(d2));
                jSONObject.put("rv_skip_time", g2);
                jSONObject.put("fv_skip_show", b2);
                jSONObject.put("show_dislike", this.f28163e != null && this.f28163e.aJ());
                jSONObject.put("video_adaptation", this.f28163e != null ? this.f28163e.l() : 0);
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
        this.f28160b = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b c(String str) {
        this.f28162d = str;
        return this;
    }

    private String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f28164f != null) {
                this.f28164f.put(com.alipay.sdk.sys.a.j, d());
            }
            jSONObject.put("templateInfo", this.f28164f);
            jSONObject.put("adInfo", new com.bytedance.sdk.openadsdk.core.dynamic.b.a(this.f28163e).a());
            jSONObject.put(DI.APP_INFO_NAME, new com.bytedance.sdk.openadsdk.core.dynamic.b.b().a());
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(j jVar) {
        this.f28165g.setRenderListener(jVar);
        return this;
    }

    public DynamicRootView b() {
        return this.f28165g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(l lVar) {
        this.f28163e = lVar;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(String str) {
        this.f28159a = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(int i2) {
        this.f28161c = i2;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(JSONObject jSONObject) {
        this.f28164f = jSONObject;
        return this;
    }

    public void a() {
        this.f28166h.a(new c() { // from class: com.bytedance.sdk.openadsdk.core.dynamic.a.a.1
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
        this.f28166h.b(c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (fVar == null) {
            this.f28165g.b();
            return;
        }
        try {
            DynamicBaseWidgetImp dynamicBaseWidgetImp = new DynamicBaseWidgetImp(this.f28167i, this.f28165g, fVar);
            a(fVar, dynamicBaseWidgetImp);
            this.f28165g.setDynamicBaseWidget(dynamicBaseWidgetImp);
            this.f28165g.a();
        } catch (Exception unused) {
            this.f28165g.b();
        }
    }

    private void a(f fVar, DynamicBaseWidget dynamicBaseWidget) {
        List<f> f2;
        if (fVar == null || dynamicBaseWidget == null || (f2 = fVar.f()) == null || f2.size() <= 0) {
            return;
        }
        for (f fVar2 : fVar.f()) {
            if (fVar2 != null) {
                DynamicBaseWidget a2 = b.a(this.f28167i, this.f28165g, fVar2);
                a(fVar2, a2);
                dynamicBaseWidget.a(a2);
            }
        }
    }
}
