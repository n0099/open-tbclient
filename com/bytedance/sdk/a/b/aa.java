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
    final com.bytedance.sdk.a.b.a.c.j pjQ;
    private t pjR;
    final ab pjS;

    private aa(z zVar, ab abVar, boolean z) {
        this.f5947a = zVar;
        this.pjS = abVar;
        this.d = z;
        this.pjQ = new com.bytedance.sdk.a.b.a.c.j(zVar, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static aa a(z zVar, ab abVar, boolean z) {
        aa aaVar = new aa(zVar, abVar, z);
        aaVar.pjR = zVar.enX().h(aaVar);
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
        this.pjR.a(this);
        try {
            try {
                this.f5947a.enV().a(this);
                b eob = eob();
                if (eob == null) {
                    throw new IOException(ResponseException.CANCELED);
                }
                return eob;
            } catch (IOException e) {
                this.pjR.a(this, e);
                throw e;
            }
        } finally {
            this.f5947a.enV().b(this);
        }
    }

    private void g() {
        this.pjQ.a(com.bytedance.sdk.a.b.a.g.e.eng().a("response.body().close()"));
    }

    public boolean b() {
        return this.pjQ.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: eoa */
    public aa clone() {
        return a(this.f5947a, this.pjS, this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class a extends com.bytedance.sdk.a.b.a.b {
        private final i pjT;
        final /* synthetic */ aa pjU;

        /* JADX INFO: Access modifiers changed from: package-private */
        public String a() {
            return this.pjU.pjS.emp().f();
        }

        @Override // com.bytedance.sdk.a.b.a.b
        protected void b() {
            boolean z = true;
            try {
                try {
                    b eob = this.pjU.eob();
                    try {
                        if (this.pjU.pjQ.a()) {
                            this.pjT.a(this.pjU, new IOException(ResponseException.CANCELED));
                        } else {
                            this.pjT.a(this.pjU, eob);
                        }
                    } catch (IOException e) {
                        e = e;
                        if (!z) {
                            this.pjU.pjR.a(this.pjU, e);
                            this.pjT.a(this.pjU, e);
                        } else {
                            com.bytedance.sdk.a.b.a.g.e.eng().a(4, "Callback failure for " + this.pjU.d(), e);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
            } finally {
                this.pjU.f5947a.enV().b(this);
            }
        }
    }

    String d() {
        return (b() ? "canceled " : "") + (this.d ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + e();
    }

    String e() {
        return this.pjS.emp().m();
    }

    b eob() throws IOException {
        ArrayList arrayList = new ArrayList(this.f5947a.enW());
        arrayList.add(this.pjQ);
        arrayList.add(new com.bytedance.sdk.a.b.a.c.a(this.f5947a.enL()));
        arrayList.add(new com.bytedance.sdk.a.b.a.a.a(this.f5947a.enM()));
        arrayList.add(new com.bytedance.sdk.a.b.a.b.a(this.f5947a));
        if (!this.d) {
            arrayList.addAll(this.f5947a.w());
        }
        arrayList.add(new com.bytedance.sdk.a.b.a.c.b(this.d));
        return new com.bytedance.sdk.a.b.a.c.g(arrayList, null, null, null, 0, this.pjS, this, this.pjR, this.f5947a.a(), this.f5947a.b(), this.f5947a.c()).b(this.pjS);
    }
}
