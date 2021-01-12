package com.bytedance.sdk.a.b;

import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.http.response.ResponseException;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class aa implements h {

    /* renamed from: a  reason: collision with root package name */
    final z f5947a;
    final boolean d;
    private boolean f;
    final com.bytedance.sdk.a.b.a.c.j pjP;
    private t pjQ;
    final ab pjR;

    private aa(z zVar, ab abVar, boolean z) {
        this.f5947a = zVar;
        this.pjR = abVar;
        this.d = z;
        this.pjP = new com.bytedance.sdk.a.b.a.c.j(zVar, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static aa a(z zVar, ab abVar, boolean z) {
        aa aaVar = new aa(zVar, abVar, z);
        aaVar.pjQ = zVar.enX().h(aaVar);
        return aaVar;
    }

    @Override // com.bytedance.sdk.a.b.h
    public b enq() throws IOException {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f = true;
        }
        g();
        this.pjQ.a(this);
        try {
            try {
                this.f5947a.enV().a(this);
                b eob = eob();
                if (eob == null) {
                    throw new IOException(ResponseException.CANCELED);
                }
                return eob;
            } catch (IOException e) {
                this.pjQ.a(this, e);
                throw e;
            }
        } finally {
            this.f5947a.enV().b(this);
        }
    }

    private void g() {
        this.pjP.a(com.bytedance.sdk.a.b.a.g.e.eng().a("response.body().close()"));
    }

    public boolean b() {
        return this.pjP.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: eoa */
    public aa clone() {
        return a(this.f5947a, this.pjR, this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class a extends com.bytedance.sdk.a.b.a.b {
        private final i pjS;
        final /* synthetic */ aa pjT;

        /* JADX INFO: Access modifiers changed from: package-private */
        public String a() {
            return this.pjT.pjR.emp().f();
        }

        @Override // com.bytedance.sdk.a.b.a.b
        protected void b() {
            boolean z = true;
            try {
                try {
                    b eob = this.pjT.eob();
                    try {
                        if (this.pjT.pjP.a()) {
                            this.pjS.a(this.pjT, new IOException(ResponseException.CANCELED));
                        } else {
                            this.pjS.a(this.pjT, eob);
                        }
                    } catch (IOException e) {
                        e = e;
                        if (!z) {
                            this.pjT.pjQ.a(this.pjT, e);
                            this.pjS.a(this.pjT, e);
                        } else {
                            com.bytedance.sdk.a.b.a.g.e.eng().a(4, "Callback failure for " + this.pjT.d(), e);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
            } finally {
                this.pjT.f5947a.enV().b(this);
            }
        }
    }

    String d() {
        return (b() ? "canceled " : "") + (this.d ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + e();
    }

    String e() {
        return this.pjR.emp().m();
    }

    b eob() throws IOException {
        ArrayList arrayList = new ArrayList(this.f5947a.enW());
        arrayList.add(this.pjP);
        arrayList.add(new com.bytedance.sdk.a.b.a.c.a(this.f5947a.enL()));
        arrayList.add(new com.bytedance.sdk.a.b.a.a.a(this.f5947a.enM()));
        arrayList.add(new com.bytedance.sdk.a.b.a.b.a(this.f5947a));
        if (!this.d) {
            arrayList.addAll(this.f5947a.w());
        }
        arrayList.add(new com.bytedance.sdk.a.b.a.c.b(this.d));
        return new com.bytedance.sdk.a.b.a.c.g(arrayList, null, null, null, 0, this.pjR, this, this.pjQ, this.f5947a.a(), this.f5947a.b(), this.f5947a.c()).b(this.pjR);
    }
}
