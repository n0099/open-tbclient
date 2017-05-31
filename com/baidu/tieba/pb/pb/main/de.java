package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class de {
    private static de eoh;
    private com.baidu.adp.lib.cache.o<byte[]> eoi = null;
    private com.baidu.adp.lib.cache.o<byte[]> eoj = null;
    private long eok = 0;
    private long eol = 0;

    public static synchronized de aKB() {
        de deVar;
        synchronized (de.class) {
            if (eoh == null) {
                eoh = new de();
            }
            deVar = eoh;
        }
        return deVar;
    }

    private de() {
        Zl();
    }

    private void Zl() {
        if (this.eoi == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eoi = com.baidu.tbadk.core.c.a.sY().cx("tb.pb_mark");
            this.eol = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eoj == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eoj = com.baidu.tbadk.core.c.a.sY().cx("tb.pb_normal");
            this.eok = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void J(String str, boolean z) {
        if (z) {
            if (this.eoi != null && str != null) {
                this.eoi.b(str, new byte[0], 0L);
            }
        } else if (this.eoj != null && str != null) {
            this.eoj.b(str, new byte[0], 0L);
        }
    }

    public byte[] K(String str, boolean z) {
        o.c<byte[]> P;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eoi != null && str != null) {
                P = this.eoi.P(str);
                j = this.eol;
            }
            P = null;
        } else {
            if (this.eoj != null && str != null) {
                P = this.eoj.P(str);
                j = this.eok;
            }
            P = null;
        }
        if (P == null || P.sH == null) {
            return null;
        }
        com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
        vVar.fb(1001);
        vVar.aGz = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.FA();
        return P.sH;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Zl();
            if (z) {
                this.eoi.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eoj.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
            vVar.fb(1001);
            vVar.aGA = currentTimeMillis2;
            vVar.FB();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Zl();
            this.eoi.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
            vVar.fb(1001);
            vVar.aGA = currentTimeMillis2;
            vVar.FB();
        }
    }
}
