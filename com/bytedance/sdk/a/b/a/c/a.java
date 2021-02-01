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
    private final p ppg;

    public a(p pVar) {
        this.ppg = pVar;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        boolean z = false;
        ab epm = aVar.epm();
        ab.a eqw = epm.eqw();
        ac eqv = epm.eqv();
        if (eqv != null) {
            y epn = eqv.epn();
            if (epn != null) {
                eqw.hm("Content-Type", epn.toString());
            }
            long b2 = eqv.b();
            if (b2 != -1) {
                eqw.hm("Content-Length", Long.toString(b2));
                eqw.YP("Transfer-Encoding");
            } else {
                eqw.hm("Transfer-Encoding", HTTP.CHUNK_CODING);
                eqw.YP("Content-Length");
            }
        }
        if (epm.a("Host") == null) {
            eqw.hm("Host", com.bytedance.sdk.a.b.a.c.a(epm.eoJ(), false));
        }
        if (epm.a(HTTP.CONN_DIRECTIVE) == null) {
            eqw.hm(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        }
        if (epm.a(Headers.ACCEPT_ENCODING) == null && epm.a(Headers.RANGE) == null) {
            z = true;
            eqw.hm(Headers.ACCEPT_ENCODING, "gzip");
        }
        List<o> e = this.ppg.e(epm.eoJ());
        if (!e.isEmpty()) {
            eqw.hm(SM.COOKIE, a(e));
        }
        if (epm.a("User-Agent") == null) {
            eqw.hm("User-Agent", com.bytedance.sdk.a.b.a.d.a());
        }
        com.bytedance.sdk.a.b.b b3 = aVar.b(eqw.eqB());
        e.a(this.ppg, epm.eoJ(), b3.epE());
        b.a f = b3.epG().f(epm);
        if (z && "gzip".equalsIgnoreCase(b3.a("Content-Encoding")) && e.e(b3)) {
            com.bytedance.sdk.a.a.j jVar = new com.bytedance.sdk.a.a.j(b3.epF().epo());
            f.c(b3.epE().epU().YF("Content-Encoding").YF("Content-Length").epV());
            f.a(new h(b3.a("Content-Type"), -1L, com.bytedance.sdk.a.a.l.c(jVar)));
        }
        return f.epJ();
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
