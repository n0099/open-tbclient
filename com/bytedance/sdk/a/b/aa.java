package com.bytedance.sdk.a.b;

import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.http.response.ResponseException;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class aa implements h {

    /* renamed from: a  reason: collision with root package name */
    final z f6246a;
    final boolean d;
    private boolean f;
    final com.bytedance.sdk.a.b.a.c.j pov;
    private t pow;
    final ab pox;

    private aa(z zVar, ab abVar, boolean z) {
        this.f6246a = zVar;
        this.pox = abVar;
        this.d = z;
        this.pov = new com.bytedance.sdk.a.b.a.c.j(zVar, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static aa a(z zVar, ab abVar, boolean z) {
        aa aaVar = new aa(zVar, abVar, z);
        aaVar.pow = zVar.erR().h(aaVar);
        return aaVar;
    }

    @Override // com.bytedance.sdk.a.b.h
    public b erk() throws IOException {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f = true;
        }
        g();
        this.pow.a(this);
        try {
            try {
                this.f6246a.erP().a(this);
                b erV = erV();
                if (erV == null) {
                    throw new IOException(ResponseException.CANCELED);
                }
                return erV;
            } catch (IOException e) {
                this.pow.a(this, e);
                throw e;
            }
        } finally {
            this.f6246a.erP().b(this);
        }
    }

    private void g() {
        this.pov.a(com.bytedance.sdk.a.b.a.g.e.era().a("response.body().close()"));
    }

    public boolean b() {
        return this.pov.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: erU */
    public aa clone() {
        return a(this.f6246a, this.pox, this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class a extends com.bytedance.sdk.a.b.a.b {
        private final i poy;
        final /* synthetic */ aa poz;

        /* JADX INFO: Access modifiers changed from: package-private */
        public String a() {
            return this.poz.pox.eqk().f();
        }

        @Override // com.bytedance.sdk.a.b.a.b
        protected void b() {
            boolean z = true;
            try {
                try {
                    b erV = this.poz.erV();
                    try {
                        if (this.poz.pov.a()) {
                            this.poy.a(this.poz, new IOException(ResponseException.CANCELED));
                        } else {
                            this.poy.a(this.poz, erV);
                        }
                    } catch (IOException e) {
                        e = e;
                        if (!z) {
                            this.poz.pow.a(this.poz, e);
                            this.poy.a(this.poz, e);
                        } else {
                            com.bytedance.sdk.a.b.a.g.e.era().a(4, "Callback failure for " + this.poz.d(), e);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
            } finally {
                this.poz.f6246a.erP().b(this);
            }
        }
    }

    String d() {
        return (b() ? "canceled " : "") + (this.d ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + e();
    }

    String e() {
        return this.pox.eqk().m();
    }

    b erV() throws IOException {
        ArrayList arrayList = new ArrayList(this.f6246a.erQ());
        arrayList.add(this.pov);
        arrayList.add(new com.bytedance.sdk.a.b.a.c.a(this.f6246a.erF()));
        arrayList.add(new com.bytedance.sdk.a.b.a.a.a(this.f6246a.erG()));
        arrayList.add(new com.bytedance.sdk.a.b.a.b.a(this.f6246a));
        if (!this.d) {
            arrayList.addAll(this.f6246a.w());
        }
        arrayList.add(new com.bytedance.sdk.a.b.a.c.b(this.d));
        return new com.bytedance.sdk.a.b.a.c.g(arrayList, null, null, null, 0, this.pox, this, this.pow, this.f6246a.a(), this.f6246a.b(), this.f6246a.c()).b(this.pox);
    }
}
