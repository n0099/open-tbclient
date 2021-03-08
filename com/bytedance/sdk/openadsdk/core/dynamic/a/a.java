package com.bytedance.sdk.openadsdk.core.dynamic.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.dynamic.d.c;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.bytedance.sdk.openadsdk.core.dynamic.d.b {

    /* renamed from: a  reason: collision with root package name */
    private String f4409a;
    private String b;
    private int c;
    private String d;
    private l e;
    private JSONObject f;
    private DynamicRootView g;
    private com.bytedance.sdk.openadsdk.core.dynamic.c.a h;
    private Context i;

    public a(Context context) {
        this.i = context;
        this.g = new DynamicRootView(context);
        this.h = new com.bytedance.sdk.openadsdk.core.dynamic.c.a(this.i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(j jVar) {
        this.g.setRenderListener(jVar);
        return this;
    }

    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(SSWebView sSWebView) {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(l lVar) {
        this.e = lVar;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(String str) {
        this.f4409a = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b b(String str) {
        this.b = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(int i) {
        this.c = i;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b c(String str) {
        this.d = str;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(JSONObject jSONObject) {
        this.f = jSONObject;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b b(SSWebView sSWebView) {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
    public com.bytedance.sdk.openadsdk.core.dynamic.d.b a(p pVar) {
        return this;
    }

    public void a() {
        this.h.a(new c() { // from class: com.bytedance.sdk.openadsdk.core.dynamic.a.a.1
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
        this.h.b(c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (fVar == null) {
            this.g.b();
            return;
        }
        try {
            DynamicBaseWidgetImp dynamicBaseWidgetImp = new DynamicBaseWidgetImp(this.i, this.g, fVar);
            a(fVar, dynamicBaseWidgetImp);
            this.g.setDynamicBaseWidget(dynamicBaseWidgetImp);
            this.g.a();
        } catch (Exception e) {
            this.g.b();
        }
    }

    private void a(f fVar, DynamicBaseWidget dynamicBaseWidget) {
        List<f> f;
        if (fVar != null && dynamicBaseWidget != null && (f = fVar.f()) != null && f.size() > 0) {
            for (f fVar2 : fVar.f()) {
                if (fVar2 != null) {
                    DynamicBaseWidget a2 = b.a(this.i, this.g, fVar2);
                    a(fVar2, a2);
                    dynamicBaseWidget.a(a2);
                }
            }
        }
    }

    public DynamicRootView b() {
        return this.g;
    }

    private String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f != null) {
                this.f.put("setting", d());
            }
            jSONObject.put("templateInfo", this.f);
            jSONObject.put("adInfo", new com.bytedance.sdk.openadsdk.core.dynamic.b.a(this.e).a());
            jSONObject.put("appInfo", new com.bytedance.sdk.openadsdk.core.dynamic.b.b().a());
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        if (com.bytedance.sdk.openadsdk.core.p.h() != null && jSONObject != null) {
            try {
                int d = aj.d(this.b);
                int g = com.bytedance.sdk.openadsdk.core.p.h().g(String.valueOf(d));
                boolean b = com.bytedance.sdk.openadsdk.core.p.h().b(String.valueOf(d));
                jSONObject.put("voice_control", com.bytedance.sdk.openadsdk.core.p.h().b(d));
                jSONObject.put("rv_skip_time", g);
                jSONObject.put("fv_skip_show", b);
                jSONObject.put("show_dislike", this.e != null && this.e.aC());
                jSONObject.put("video_adaptation", this.e != null ? this.e.l() : 0);
            } catch (Exception e) {
            }
        }
        return jSONObject;
    }
}
