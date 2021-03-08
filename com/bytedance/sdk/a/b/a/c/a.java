package com.bytedance.sdk.a.b.a.c;

import com.baidubce.http.Headers;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.b;
import com.bytedance.sdk.a.b.o;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.x;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.util.List;
import org.apache.http.cookie.SM;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public final class a implements x {
    private final p prN;

    public a(p pVar) {
        this.prN = pVar;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        boolean z = false;
        ab epB = aVar.epB();
        ab.a eqL = epB.eqL();
        ac eqK = epB.eqK();
        if (eqK != null) {
            y epC = eqK.epC();
            if (epC != null) {
                eqL.ho("Content-Type", epC.toString());
            }
            long b = eqK.b();
            if (b != -1) {
                eqL.ho("Content-Length", Long.toString(b));
                eqL.Zi("Transfer-Encoding");
            } else {
                eqL.ho("Transfer-Encoding", HTTP.CHUNK_CODING);
                eqL.Zi("Content-Length");
            }
        }
        if (epB.a("Host") == null) {
            eqL.ho("Host", com.bytedance.sdk.a.b.a.c.a(epB.eoY(), false));
        }
        if (epB.a(HTTP.CONN_DIRECTIVE) == null) {
            eqL.ho(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        }
        if (epB.a(Headers.ACCEPT_ENCODING) == null && epB.a(Headers.RANGE) == null) {
            z = true;
            eqL.ho(Headers.ACCEPT_ENCODING, "gzip");
        }
        List<o> e = this.prN.e(epB.eoY());
        if (!e.isEmpty()) {
            eqL.ho(SM.COOKIE, a(e));
        }
        if (epB.a("User-Agent") == null) {
            eqL.ho("User-Agent", com.bytedance.sdk.a.b.a.d.a());
        }
        com.bytedance.sdk.a.b.b b2 = aVar.b(eqL.eqQ());
        e.a(this.prN, epB.eoY(), b2.epT());
        b.a f = b2.epV().f(epB);
        if (z && "gzip".equalsIgnoreCase(b2.a("Content-Encoding")) && e.e(b2)) {
            com.bytedance.sdk.a.a.j jVar = new com.bytedance.sdk.a.a.j(b2.epU().epD());
            f.c(b2.epT().eqj().YY("Content-Encoding").YY("Content-Length").eqk());
            f.a(new h(b2.a("Content-Type"), -1L, com.bytedance.sdk.a.a.l.c(jVar)));
        }
        return f.epY();
    }

    private String a(List<o> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            o oVar = list.get(i);
            sb.append(oVar.a()).append('=').append(oVar.b());
        }
        return sb.toString();
    }
}
