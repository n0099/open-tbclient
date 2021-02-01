package com.bytedance.sdk.a.b;

import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.http.response.ResponseException;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class aa implements h {

    /* renamed from: a  reason: collision with root package name */
    final z f5949a;
    final boolean d;
    private boolean f;
    final com.bytedance.sdk.a.b.a.c.j pug;
    private t puh;
    final ab pui;

    private aa(z zVar, ab abVar, boolean z) {
        this.f5949a = zVar;
        this.pui = abVar;
        this.d = z;
        this.pug = new com.bytedance.sdk.a.b.a.c.j(zVar, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static aa a(z zVar, ab abVar, boolean z) {
        aa aaVar = new aa(zVar, abVar, z);
        aaVar.puh = zVar.eqq().h(aaVar);
        return aaVar;
    }

    @Override // com.bytedance.sdk.a.b.h
    public b epJ() throws IOException {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f = true;
        }
        g();
        this.puh.a(this);
        try {
            try {
                this.f5949a.eqo().a(this);
                b equ = equ();
                if (equ == null) {
                    throw new IOException(ResponseException.CANCELED);
                }
                return equ;
            } catch (IOException e) {
                this.puh.a(this, e);
                throw e;
            }
        } finally {
            this.f5949a.eqo().b(this);
        }
    }

    private void g() {
        this.pug.a(com.bytedance.sdk.a.b.a.g.e.epz().a("response.body().close()"));
    }

    public boolean b() {
        return this.pug.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: eqt */
    public aa clone() {
        return a(this.f5949a, this.pui, this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a extends com.bytedance.sdk.a.b.a.b {
        private final i puj;
        final /* synthetic */ aa puk;

        /* JADX INFO: Access modifiers changed from: package-private */
        public String a() {
            return this.puk.pui.eoJ().f();
        }

        @Override // com.bytedance.sdk.a.b.a.b
        protected void b() {
            boolean z = true;
            try {
                try {
                    b equ = this.puk.equ();
                    try {
                        if (this.puk.pug.a()) {
                            this.puj.a(this.puk, new IOException(ResponseException.CANCELED));
                        } else {
                            this.puj.a(this.puk, equ);
                        }
                    } catch (IOException e) {
                        e = e;
                        if (!z) {
                            this.puk.puh.a(this.puk, e);
                            this.puj.a(this.puk, e);
                        } else {
                            com.bytedance.sdk.a.b.a.g.e.epz().a(4, "Callback failure for " + this.puk.d(), e);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
            } finally {
                this.puk.f5949a.eqo().b(this);
            }
        }
    }

    String d() {
        return (b() ? "canceled " : "") + (this.d ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + e();
    }

    String e() {
        return this.pui.eoJ().m();
    }

    b equ() throws IOException {
        ArrayList arrayList = new ArrayList(this.f5949a.eqp());
        arrayList.add(this.pug);
        arrayList.add(new com.bytedance.sdk.a.b.a.c.a(this.f5949a.eqe()));
        arrayList.add(new com.bytedance.sdk.a.b.a.a.a(this.f5949a.eqf()));
        arrayList.add(new com.bytedance.sdk.a.b.a.b.a(this.f5949a));
        if (!this.d) {
            arrayList.addAll(this.f5949a.w());
        }
        arrayList.add(new com.bytedance.sdk.a.b.a.c.b(this.d));
        return new com.bytedance.sdk.a.b.a.c.g(arrayList, null, null, null, 0, this.pui, this, this.puh, this.f5949a.a(), this.f5949a.b(), this.f5949a.c()).b(this.pui);
    }
}
