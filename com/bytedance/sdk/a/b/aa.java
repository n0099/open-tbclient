package com.bytedance.sdk.a.b;

import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.http.response.ResponseException;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class aa implements h {

    /* renamed from: a  reason: collision with root package name */
    final z f3999a;
    final boolean d;
    private boolean f;
    final com.bytedance.sdk.a.b.a.c.j pwL;
    private t pwM;
    final ab pwN;

    private aa(z zVar, ab abVar, boolean z) {
        this.f3999a = zVar;
        this.pwN = abVar;
        this.d = z;
        this.pwL = new com.bytedance.sdk.a.b.a.c.j(zVar, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static aa a(z zVar, ab abVar, boolean z) {
        aa aaVar = new aa(zVar, abVar, z);
        aaVar.pwM = zVar.eqF().h(aaVar);
        return aaVar;
    }

    @Override // com.bytedance.sdk.a.b.h
    public b epY() throws IOException {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f = true;
        }
        g();
        this.pwM.a(this);
        try {
            try {
                this.f3999a.eqD().a(this);
                b eqJ = eqJ();
                if (eqJ == null) {
                    throw new IOException(ResponseException.CANCELED);
                }
                return eqJ;
            } catch (IOException e) {
                this.pwM.a(this, e);
                throw e;
            }
        } finally {
            this.f3999a.eqD().b(this);
        }
    }

    private void g() {
        this.pwL.a(com.bytedance.sdk.a.b.a.g.e.epO().a("response.body().close()"));
    }

    public boolean b() {
        return this.pwL.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: eqI */
    public aa clone() {
        return a(this.f3999a, this.pwN, this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a extends com.bytedance.sdk.a.b.a.b {
        private final i pwO;
        final /* synthetic */ aa pwP;

        /* JADX INFO: Access modifiers changed from: package-private */
        public String a() {
            return this.pwP.pwN.eoY().f();
        }

        @Override // com.bytedance.sdk.a.b.a.b
        protected void b() {
            boolean z = true;
            try {
                try {
                    b eqJ = this.pwP.eqJ();
                    try {
                        if (this.pwP.pwL.a()) {
                            this.pwO.a(this.pwP, new IOException(ResponseException.CANCELED));
                        } else {
                            this.pwO.a(this.pwP, eqJ);
                        }
                    } catch (IOException e) {
                        e = e;
                        if (!z) {
                            this.pwP.pwM.a(this.pwP, e);
                            this.pwO.a(this.pwP, e);
                        } else {
                            com.bytedance.sdk.a.b.a.g.e.epO().a(4, "Callback failure for " + this.pwP.d(), e);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
            } finally {
                this.pwP.f3999a.eqD().b(this);
            }
        }
    }

    String d() {
        return (b() ? "canceled " : "") + (this.d ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + e();
    }

    String e() {
        return this.pwN.eoY().m();
    }

    b eqJ() throws IOException {
        ArrayList arrayList = new ArrayList(this.f3999a.eqE());
        arrayList.add(this.pwL);
        arrayList.add(new com.bytedance.sdk.a.b.a.c.a(this.f3999a.eqt()));
        arrayList.add(new com.bytedance.sdk.a.b.a.a.a(this.f3999a.equ()));
        arrayList.add(new com.bytedance.sdk.a.b.a.b.a(this.f3999a));
        if (!this.d) {
            arrayList.addAll(this.f3999a.w());
        }
        arrayList.add(new com.bytedance.sdk.a.b.a.c.b(this.d));
        return new com.bytedance.sdk.a.b.a.c.g(arrayList, null, null, null, 0, this.pwN, this, this.pwM, this.f3999a.a(), this.f3999a.b(), this.f3999a.c()).b(this.pwN);
    }
}
