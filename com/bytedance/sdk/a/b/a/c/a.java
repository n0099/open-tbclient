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
    private final p ppI;

    public a(p pVar) {
        this.ppI = pVar;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        boolean z = false;
        ab epu = aVar.epu();
        ab.a eqE = epu.eqE();
        ac eqD = epu.eqD();
        if (eqD != null) {
            y epv = eqD.epv();
            if (epv != null) {
                eqE.ho("Content-Type", epv.toString());
            }
            long b2 = eqD.b();
            if (b2 != -1) {
                eqE.ho("Content-Length", Long.toString(b2));
                eqE.Zb("Transfer-Encoding");
            } else {
                eqE.ho("Transfer-Encoding", HTTP.CHUNK_CODING);
                eqE.Zb("Content-Length");
            }
        }
        if (epu.a("Host") == null) {
            eqE.ho("Host", com.bytedance.sdk.a.b.a.c.a(epu.eoR(), false));
        }
        if (epu.a(HTTP.CONN_DIRECTIVE) == null) {
            eqE.ho(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        }
        if (epu.a(Headers.ACCEPT_ENCODING) == null && epu.a(Headers.RANGE) == null) {
            z = true;
            eqE.ho(Headers.ACCEPT_ENCODING, "gzip");
        }
        List<o> e = this.ppI.e(epu.eoR());
        if (!e.isEmpty()) {
            eqE.ho(SM.COOKIE, a(e));
        }
        if (epu.a("User-Agent") == null) {
            eqE.ho("User-Agent", com.bytedance.sdk.a.b.a.d.a());
        }
        com.bytedance.sdk.a.b.b b3 = aVar.b(eqE.eqJ());
        e.a(this.ppI, epu.eoR(), b3.epM());
        b.a f = b3.epO().f(epu);
        if (z && "gzip".equalsIgnoreCase(b3.a("Content-Encoding")) && e.e(b3)) {
            com.bytedance.sdk.a.a.j jVar = new com.bytedance.sdk.a.a.j(b3.epN().epw());
            f.c(b3.epM().eqc().YR("Content-Encoding").YR("Content-Length").eqd());
            f.a(new h(b3.a("Content-Type"), -1L, com.bytedance.sdk.a.a.l.c(jVar)));
        }
        return f.epR();
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
