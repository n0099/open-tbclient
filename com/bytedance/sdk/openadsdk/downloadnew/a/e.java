package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.h.h;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.g;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e implements com.bytedance.sdk.openadsdk.downloadnew.core.a {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f29241a;

    /* renamed from: b  reason: collision with root package name */
    public String f29242b;

    /* renamed from: c  reason: collision with root package name */
    public d.o.a.a.a.c.d f29243c;

    /* renamed from: d  reason: collision with root package name */
    public final l f29244d;

    /* renamed from: e  reason: collision with root package name */
    public String f29245e;

    /* renamed from: f  reason: collision with root package name */
    public d.o.a.a.a.c.b f29246f;

    /* renamed from: g  reason: collision with root package name */
    public d.o.a.a.a.c.c f29247g;

    public e(Context context, String str, l lVar, String str2) {
        this.f29241a = new WeakReference<>(context);
        this.f29244d = lVar;
        this.f29245e = str2;
        this.f29242b = str;
        this.f29243c = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(str, str2, lVar, null).p();
        this.f29246f = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f29244d).e();
        this.f29247g = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f29244d, this.f29245e).d();
        a();
    }

    private Context k() {
        WeakReference<Context> weakReference = this.f29241a;
        return (weakReference == null || weakReference.get() == null) ? p.a() : this.f29241a.get();
    }

    private synchronized void l() {
        g.d().f(this.f29242b, hashCode());
    }

    private synchronized void m() {
        if (n()) {
            g.d().n().b(k(), this.f29243c.d(), this.f29243c.u(), null, hashCode());
        } else {
            g.d().d(k(), hashCode(), null, this.f29243c);
        }
    }

    private boolean n() {
        h h2 = p.h();
        if (h2 != null) {
            return h2.p();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_type", 3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        TTCustomController e2 = i.d().e();
        if (e2 != null && !e2.isCanUseWriteExternal()) {
            try {
                String str = g.f29250a;
                String absolutePath = Environment.getDataDirectory().getAbsolutePath();
                if (str != null) {
                    if (!str.startsWith(absolutePath)) {
                        return;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (n()) {
            g.d().n().c(k(), null, true, this.f29243c, this.f29247g, this.f29246f, null, hashCode());
        } else {
            g.d().g(this.f29242b, this.f29243c.d(), 2, this.f29247g, this.f29246f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(int i, a.InterfaceC0317a interfaceC0317a) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean a(boolean z) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean b(boolean z) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void d() {
        l();
        WeakReference<Context> weakReference = this.f29241a;
        if (weakReference != null) {
            weakReference.clear();
            this.f29241a = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void e() {
        if (a(this.f29244d)) {
            b(this.f29244d);
        } else {
            p();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void f() {
        a(0L);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void g() {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean h() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean i() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a() {
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void b() {
        m();
    }

    private boolean a(l lVar) {
        if (lVar == null) {
            return true;
        }
        return !(lVar.L() == 0);
    }

    private void b(final l lVar) {
        if (lVar == null) {
            return;
        }
        String W = lVar.W();
        String a2 = f.a(lVar);
        k aa = lVar.aa();
        String a3 = aa != null ? aa.a() : "";
        boolean z = lVar.Z() == 4;
        com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, this.f29245e, "pop_up", o());
        com.bytedance.sdk.openadsdk.utils.g.a(k(), lVar.am(), W, new g.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.e.1
            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void a() {
                e.this.p();
                com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, e.this.f29245e, "pop_up_download", e.this.o());
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void c() {
                com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, e.this.f29245e, "pop_up_cancel", e.this.o());
            }
        }, a2, a3, z);
    }

    public void a(long j) {
        g.d().i(this.f29242b, true);
    }
}
