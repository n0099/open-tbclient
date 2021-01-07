package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.g;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class c implements com.bytedance.sdk.openadsdk.downloadnew.core.a {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Context> f7394a;

    /* renamed from: b  reason: collision with root package name */
    private String f7395b;
    private com.ss.android.a.a.b.c c;
    private final l d;
    private String e;

    public c(Context context, String str, l lVar, String str2) {
        this.f7394a = new WeakReference<>(context);
        this.d = lVar;
        this.e = str2;
        this.f7395b = str;
        this.c = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(str, str2, lVar, null).eFG();
        a();
    }

    private Context k() {
        return (this.f7394a == null || this.f7394a.get() == null) ? p.a() : this.f7394a.get();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a() {
        m();
    }

    private synchronized void l() {
        e.d().a(this.f7395b, hashCode());
    }

    private synchronized void m() {
        if (n()) {
            e.d().eGF().a(k(), this.c.d(), this.c.u(), null, hashCode());
        } else {
            e.d().a(k(), hashCode(), null, this.c);
        }
    }

    private boolean n() {
        com.bytedance.sdk.openadsdk.core.h.l h = p.h();
        if (h != null) {
            return h.r();
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
        if (this.f7394a != null) {
            this.f7394a.clear();
            this.f7394a = null;
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
            o();
        }
    }

    private boolean a(l lVar) {
        if (lVar == null) {
            return true;
        }
        return !(lVar.A() == 0);
    }

    private void b(l lVar) {
        if (lVar != null) {
            String E = lVar.E();
            String a2 = d.a(lVar);
            String str = "";
            k I = lVar.I();
            if (I != null) {
                str = I.a();
            }
            g.a(lVar.T(), E, new g.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.c.1
                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void a() {
                    c.this.o();
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void c() {
                }
            }, a2, str, lVar.H() == 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        TTCustomController d = i.c().d();
        if (d != null && !d.isCanUseWriteExternal()) {
            try {
                String str = e.f7397a;
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
            e.d().eGF().a(k(), null, true, this.c, null, null, null, hashCode());
        } else {
            e.d().c(this.f7395b, this.c.d(), 2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void f() {
        a(0L);
    }

    public void a(long j) {
        e.d().a(this.f7395b, true);
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
    public void a(int i, a.InterfaceC1030a interfaceC1030a) {
    }
}
