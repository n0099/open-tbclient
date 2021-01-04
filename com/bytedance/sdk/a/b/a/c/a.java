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
/* loaded from: classes4.dex */
public final class a implements x {
    private final p pju;

    public a(p pVar) {
        this.pju = pVar;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        boolean z = false;
        ab eqN = aVar.eqN();
        ab.a erX = eqN.erX();
        ac erW = eqN.erW();
        if (erW != null) {
            y eqO = erW.eqO();
            if (eqO != null) {
                erX.hg("Content-Type", eqO.toString());
            }
            long b2 = erW.b();
            if (b2 != -1) {
                erX.hg("Content-Length", Long.toString(b2));
                erX.YW("Transfer-Encoding");
            } else {
                erX.hg("Transfer-Encoding", HTTP.CHUNK_CODING);
                erX.YW("Content-Length");
            }
        }
        if (eqN.a("Host") == null) {
            erX.hg("Host", com.bytedance.sdk.a.b.a.c.a(eqN.eqk(), false));
        }
        if (eqN.a(HTTP.CONN_DIRECTIVE) == null) {
            erX.hg(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        }
        if (eqN.a(Headers.ACCEPT_ENCODING) == null && eqN.a(Headers.RANGE) == null) {
            z = true;
            erX.hg(Headers.ACCEPT_ENCODING, "gzip");
        }
        List<o> e = this.pju.e(eqN.eqk());
        if (!e.isEmpty()) {
            erX.hg(SM.COOKIE, a(e));
        }
        if (eqN.a("User-Agent") == null) {
            erX.hg("User-Agent", com.bytedance.sdk.a.b.a.d.a());
        }
        com.bytedance.sdk.a.b.b b3 = aVar.b(erX.esc());
        e.a(this.pju, eqN.eqk(), b3.erf());
        b.a f = b3.erh().f(eqN);
        if (z && "gzip".equalsIgnoreCase(b3.a("Content-Encoding")) && e.e(b3)) {
            com.bytedance.sdk.a.a.j jVar = new com.bytedance.sdk.a.a.j(b3.erg().eqP());
            f.c(b3.erf().erw().YM("Content-Encoding").YM("Content-Length").erx());
            f.a(new h(b3.a("Content-Type"), -1L, com.bytedance.sdk.a.a.l.c(jVar)));
        }
        return f.erk();
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
