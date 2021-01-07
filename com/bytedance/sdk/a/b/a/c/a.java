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
        ab eqO = aVar.eqO();
        ab.a erY = eqO.erY();
        ac erX = eqO.erX();
        if (erX != null) {
            y eqP = erX.eqP();
            if (eqP != null) {
                erY.hg("Content-Type", eqP.toString());
            }
            long b2 = erX.b();
            if (b2 != -1) {
                erY.hg("Content-Length", Long.toString(b2));
                erY.YV("Transfer-Encoding");
            } else {
                erY.hg("Transfer-Encoding", HTTP.CHUNK_CODING);
                erY.YV("Content-Length");
            }
        }
        if (eqO.a("Host") == null) {
            erY.hg("Host", com.bytedance.sdk.a.b.a.c.a(eqO.eql(), false));
        }
        if (eqO.a(HTTP.CONN_DIRECTIVE) == null) {
            erY.hg(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        }
        if (eqO.a(Headers.ACCEPT_ENCODING) == null && eqO.a(Headers.RANGE) == null) {
            z = true;
            erY.hg(Headers.ACCEPT_ENCODING, "gzip");
        }
        List<o> e = this.pju.e(eqO.eql());
        if (!e.isEmpty()) {
            erY.hg(SM.COOKIE, a(e));
        }
        if (eqO.a("User-Agent") == null) {
            erY.hg("User-Agent", com.bytedance.sdk.a.b.a.d.a());
        }
        com.bytedance.sdk.a.b.b b3 = aVar.b(erY.esd());
        e.a(this.pju, eqO.eql(), b3.erg());
        b.a f = b3.eri().f(eqO);
        if (z && "gzip".equalsIgnoreCase(b3.a("Content-Encoding")) && e.e(b3)) {
            com.bytedance.sdk.a.a.j jVar = new com.bytedance.sdk.a.a.j(b3.erh().eqQ());
            f.c(b3.erg().erx().YL("Content-Encoding").YL("Content-Length").ery());
            f.a(new h(b3.a("Content-Type"), -1L, com.bytedance.sdk.a.a.l.c(jVar)));
        }
        return f.erl();
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
