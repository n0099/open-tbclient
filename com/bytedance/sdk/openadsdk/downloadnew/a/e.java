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
    private WeakReference<Context> f4722a;
    private String b;
    private com.ss.android.a.a.b.c c;
    private final l d;
    private String e;
    private com.ss.android.a.a.b.a f;
    private com.ss.android.a.a.b.b g;

    public e(Context context, String str, l lVar, String str2) {
        this.f4722a = new WeakReference<>(context);
        this.d = lVar;
        this.e = str2;
        this.b = str;
        this.c = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(str, str2, lVar, null).eEs();
        this.f = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.d).eEq();
        this.g = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.d, this.e).eEr();
        a();
    }

    private Context k() {
        return (this.f4722a == null || this.f4722a.get() == null) ? p.a() : this.f4722a.get();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a() {
        m();
    }

    private synchronized void l() {
        g.d().a(this.b, hashCode());
    }

    private synchronized void m() {
        if (n()) {
            g.d().eFs().a(k(), this.c.d(), this.c.u(), (com.ss.android.a.a.b.d) null, hashCode());
        } else {
            g.d().a(k(), hashCode(), null, this.c);
        }
    }

    private boolean n() {
        h h = p.h();
        if (h != null) {
            return h.q();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void b() {
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void d() {
        l();
        if (this.f4722a != null) {
            this.f4722a.clear();
            this.f4722a = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void e() {
        if (a(this.d)) {
            b(this.d);
        } else {
            p();
        }
    }

    private boolean a(l lVar) {
        if (lVar == null) {
            return true;
        }
        return !(lVar.L() == 0);
    }

    private void b(final l lVar) {
        if (lVar != null) {
            String Q = lVar.Q();
            String a2 = f.a(lVar);
            String str = "";
            k U = lVar.U();
            if (U != null) {
                str = U.a();
            }
            boolean z = lVar.T() == 4;
            com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, this.e, "pop_up", o());
            com.bytedance.sdk.openadsdk.utils.g.a(lVar.ag(), Q, new g.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.e.1
                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void a() {
                    e.this.p();
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, e.this.e, "pop_up_download", e.this.o());
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void c() {
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, e.this.e, "pop_up_cancel", e.this.o());
                }
            }, a2, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_type", 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        TTCustomController e = i.d().e();
        if (e != null && !e.isCanUseWriteExternal()) {
            try {
                String str = g.f4724a;
                String absolutePath = Environment.getDataDirectory().getAbsolutePath();
                if (str != null) {
                    if (!str.startsWith(absolutePath)) {
                        return;
                    }
                }
            } catch (Throwable th) {
            }
        }
        if (n()) {
            g.d().eFs().a(k(), null, true, this.c, this.g, this.f, null, hashCode());
        } else {
            g.d().a(this.b, this.c.d(), 2, this.g, this.f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void f() {
        a(0L);
    }

    public void a(long j) {
        g.d().a(this.b, true);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void g() {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean a(boolean z) {
        return false;
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
    public boolean b(boolean z) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(int i, a.InterfaceC1029a interfaceC1029a) {
    }
}
