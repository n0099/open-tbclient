package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class cu {
    private static cu enb;
    private com.baidu.adp.lib.cache.o<byte[]> enc = null;
    private com.baidu.adp.lib.cache.o<byte[]> ene = null;
    private long enf = 0;
    private long eng = 0;

    public static synchronized cu aMi() {
        cu cuVar;
        synchronized (cu.class) {
            if (enb == null) {
                enb = new cu();
            }
            cuVar = enb;
        }
        return cuVar;
    }

    private cu() {
        Zr();
    }

    private void Zr() {
        if (this.enc == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.enc = com.baidu.tbadk.core.c.a.tM().cA("tb.pb_mark");
            this.eng = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.ene == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.ene = com.baidu.tbadk.core.c.a.tM().cA("tb.pb_normal");
            this.enf = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void M(String str, boolean z) {
        if (z) {
            if (this.enc != null && str != null) {
                this.enc.b(str, new byte[0], 0L);
            }
        } else if (this.ene != null && str != null) {
            this.ene.b(str, new byte[0], 0L);
        }
    }

    public byte[] N(String str, boolean z) {
        o.c<byte[]> P;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.enc != null && str != null) {
                P = this.enc.P(str);
                j = this.eng;
            }
            P = null;
        } else {
            if (this.ene != null && str != null) {
                P = this.ene.P(str);
                j = this.enf;
            }
            P = null;
        }
        if (P == null || P.sG == null) {
            return null;
        }
        com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
        vVar.fe(1001);
        vVar.aGI = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.GC();
        return P.sG;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Zr();
            if (z) {
                this.enc.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.ene.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
            vVar.fe(1001);
            vVar.aGJ = currentTimeMillis2;
            vVar.GD();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Zr();
            this.enc.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
            vVar.fe(1001);
            vVar.aGJ = currentTimeMillis2;
            vVar.GD();
        }
    }
}
