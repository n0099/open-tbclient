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
    private final p peP;

    public a(p pVar) {
        this.peP = pVar;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        boolean z = false;
        ab emS = aVar.emS();
        ab.a eod = emS.eod();
        ac eoc = emS.eoc();
        if (eoc != null) {
            y emT = eoc.emT();
            if (emT != null) {
                eod.hf("Content-Type", emT.toString());
            }
            long b2 = eoc.b();
            if (b2 != -1) {
                eod.hf("Content-Length", Long.toString(b2));
                eod.XN("Transfer-Encoding");
            } else {
                eod.hf("Transfer-Encoding", HTTP.CHUNK_CODING);
                eod.XN("Content-Length");
            }
        }
        if (emS.a("Host") == null) {
            eod.hf("Host", com.bytedance.sdk.a.b.a.c.a(emS.emp(), false));
        }
        if (emS.a(HTTP.CONN_DIRECTIVE) == null) {
            eod.hf(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        }
        if (emS.a(Headers.ACCEPT_ENCODING) == null && emS.a(Headers.RANGE) == null) {
            z = true;
            eod.hf(Headers.ACCEPT_ENCODING, "gzip");
        }
        List<o> e = this.peP.e(emS.emp());
        if (!e.isEmpty()) {
            eod.hf(SM.COOKIE, a(e));
        }
        if (emS.a("User-Agent") == null) {
            eod.hf("User-Agent", com.bytedance.sdk.a.b.a.d.a());
        }
        com.bytedance.sdk.a.b.b b3 = aVar.b(eod.eoj());
        e.a(this.peP, emS.emp(), b3.enl());
        b.a f = b3.enn().f(emS);
        if (z && "gzip".equalsIgnoreCase(b3.a("Content-Encoding")) && e.e(b3)) {
            com.bytedance.sdk.a.a.j jVar = new com.bytedance.sdk.a.a.j(b3.enm().emU());
            f.c(b3.enl().enB().XD("Content-Encoding").XD("Content-Length").enC());
            f.a(new h(b3.a("Content-Type"), -1L, com.bytedance.sdk.a.a.l.c(jVar)));
        }
        return f.enq();
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
