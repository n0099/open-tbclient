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
/* loaded from: classes5.dex */
public class e implements com.bytedance.sdk.openadsdk.downloadnew.core.a {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f28935a;

    /* renamed from: b  reason: collision with root package name */
    public String f28936b;

    /* renamed from: c  reason: collision with root package name */
    public d.p.a.a.a.c.d f28937c;

    /* renamed from: d  reason: collision with root package name */
    public final l f28938d;

    /* renamed from: e  reason: collision with root package name */
    public String f28939e;

    /* renamed from: f  reason: collision with root package name */
    public d.p.a.a.a.c.b f28940f;

    /* renamed from: g  reason: collision with root package name */
    public d.p.a.a.a.c.c f28941g;

    public e(Context context, String str, l lVar, String str2) {
        this.f28935a = new WeakReference<>(context);
        this.f28938d = lVar;
        this.f28939e = str2;
        this.f28936b = str;
        this.f28937c = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(str, str2, lVar, null).p();
        this.f28940f = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f28938d).e();
        this.f28941g = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f28938d, this.f28939e).d();
        a();
    }

    private Context k() {
        WeakReference<Context> weakReference = this.f28935a;
        return (weakReference == null || weakReference.get() == null) ? p.a() : this.f28935a.get();
    }

    private synchronized void l() {
        g.d().f(this.f28936b, hashCode());
    }

    private synchronized void m() {
        if (n()) {
            g.d().n().b(k(), this.f28937c.d(), this.f28937c.u(), null, hashCode());
        } else {
            g.d().d(k(), hashCode(), null, this.f28937c);
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
                String str = g.f28944a;
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
            g.d().n().c(k(), null, true, this.f28937c, this.f28941g, this.f28940f, null, hashCode());
        } else {
            g.d().g(this.f28936b, this.f28937c.d(), 2, this.f28941g, this.f28940f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(int i, a.InterfaceC0322a interfaceC0322a) {
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
        WeakReference<Context> weakReference = this.f28935a;
        if (weakReference != null) {
            weakReference.clear();
            this.f28935a = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void e() {
        if (a(this.f28938d)) {
            b(this.f28938d);
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
        com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, this.f28939e, "pop_up", o());
        com.bytedance.sdk.openadsdk.utils.g.a(k(), lVar.am(), W, new g.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.e.1
            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void a() {
                e.this.p();
                com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, e.this.f28939e, "pop_up_download", e.this.o());
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void c() {
                com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, e.this.f28939e, "pop_up_cancel", e.this.o());
            }
        }, a2, a3, z);
    }

    public void a(long j) {
        g.d().i(this.f28936b, true);
    }
}
