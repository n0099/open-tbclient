package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class cz {
    private static cz eiz;
    private com.baidu.adp.lib.cache.o<byte[]> eiA = null;
    private com.baidu.adp.lib.cache.o<byte[]> eiB = null;
    private long eiC = 0;
    private long eiD = 0;

    public static synchronized cz aJH() {
        cz czVar;
        synchronized (cz.class) {
            if (eiz == null) {
                eiz = new cz();
            }
            czVar = eiz;
        }
        return czVar;
    }

    private cz() {
        Yi();
    }

    private void Yi() {
        if (this.eiA == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eiA = com.baidu.tbadk.core.c.a.sZ().cy("tb.pb_mark");
            this.eiD = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eiB == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eiB = com.baidu.tbadk.core.c.a.sZ().cy("tb.pb_normal");
            this.eiC = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void M(String str, boolean z) {
        if (z) {
            if (this.eiA != null && str != null) {
                this.eiA.b(str, new byte[0], 0L);
            }
        } else if (this.eiB != null && str != null) {
            this.eiB.b(str, new byte[0], 0L);
        }
    }

    public byte[] N(String str, boolean z) {
        o.c<byte[]> P;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eiA != null && str != null) {
                P = this.eiA.P(str);
                j = this.eiD;
            }
            P = null;
        } else {
            if (this.eiB != null && str != null) {
                P = this.eiB.P(str);
                j = this.eiC;
            }
            P = null;
        }
        if (P == null || P.sH == null) {
            return null;
        }
        com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
        vVar.fa(1001);
        vVar.aGM = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.FG();
        return P.sH;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Yi();
            if (z) {
                this.eiA.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eiB.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
            vVar.fa(1001);
            vVar.aGN = currentTimeMillis2;
            vVar.FH();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Yi();
            this.eiA.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
            vVar.fa(1001);
            vVar.aGN = currentTimeMillis2;
            vVar.FH();
        }
    }
}
