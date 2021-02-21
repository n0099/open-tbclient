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
    final com.bytedance.sdk.a.b.a.c.j puG;
    private t puH;
    final ab puI;

    private aa(z zVar, ab abVar, boolean z) {
        this.f5949a = zVar;
        this.puI = abVar;
        this.d = z;
        this.puG = new com.bytedance.sdk.a.b.a.c.j(zVar, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static aa a(z zVar, ab abVar, boolean z) {
        aa aaVar = new aa(zVar, abVar, z);
        aaVar.puH = zVar.eqy().h(aaVar);
        return aaVar;
    }

    @Override // com.bytedance.sdk.a.b.h
    public b epR() throws IOException {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f = true;
        }
        g();
        this.puH.a(this);
        try {
            try {
                this.f5949a.eqw().a(this);
                b eqC = eqC();
                if (eqC == null) {
                    throw new IOException(ResponseException.CANCELED);
                }
                return eqC;
            } catch (IOException e) {
                this.puH.a(this, e);
                throw e;
            }
        } finally {
            this.f5949a.eqw().b(this);
        }
    }

    private void g() {
        this.puG.a(com.bytedance.sdk.a.b.a.g.e.epH().a("response.body().close()"));
    }

    public boolean b() {
        return this.puG.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: eqB */
    public aa clone() {
        return a(this.f5949a, this.puI, this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a extends com.bytedance.sdk.a.b.a.b {
        private final i puJ;
        final /* synthetic */ aa puK;

        /* JADX INFO: Access modifiers changed from: package-private */
        public String a() {
            return this.puK.puI.eoR().f();
        }

        @Override // com.bytedance.sdk.a.b.a.b
        protected void b() {
            boolean z = true;
            try {
                try {
                    b eqC = this.puK.eqC();
                    try {
                        if (this.puK.puG.a()) {
                            this.puJ.a(this.puK, new IOException(ResponseException.CANCELED));
                        } else {
                            this.puJ.a(this.puK, eqC);
                        }
                    } catch (IOException e) {
                        e = e;
                        if (!z) {
                            this.puK.puH.a(this.puK, e);
                            this.puJ.a(this.puK, e);
                        } else {
                            com.bytedance.sdk.a.b.a.g.e.epH().a(4, "Callback failure for " + this.puK.d(), e);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
            } finally {
                this.puK.f5949a.eqw().b(this);
            }
        }
    }

    String d() {
        return (b() ? "canceled " : "") + (this.d ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + e();
    }

    String e() {
        return this.puI.eoR().m();
    }

    b eqC() throws IOException {
        ArrayList arrayList = new ArrayList(this.f5949a.eqx());
        arrayList.add(this.puG);
        arrayList.add(new com.bytedance.sdk.a.b.a.c.a(this.f5949a.eqm()));
        arrayList.add(new com.bytedance.sdk.a.b.a.a.a(this.f5949a.eqn()));
        arrayList.add(new com.bytedance.sdk.a.b.a.b.a(this.f5949a));
        if (!this.d) {
            arrayList.addAll(this.f5949a.w());
        }
        arrayList.add(new com.bytedance.sdk.a.b.a.c.b(this.d));
        return new com.bytedance.sdk.a.b.a.c.g(arrayList, null, null, null, 0, this.puI, this, this.puH, this.f5949a.a(), this.f5949a.b(), this.f5949a.c()).b(this.puI);
    }
}
