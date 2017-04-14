package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class cu {
    private static cu ekK;
    private com.baidu.adp.lib.cache.o<byte[]> ekL = null;
    private com.baidu.adp.lib.cache.o<byte[]> ekM = null;
    private long ekN = 0;
    private long ekO = 0;

    public static synchronized cu aLh() {
        cu cuVar;
        synchronized (cu.class) {
            if (ekK == null) {
                ekK = new cu();
            }
            cuVar = ekK;
        }
        return cuVar;
    }

    private cu() {
        Yq();
    }

    private void Yq() {
        if (this.ekL == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.ekL = com.baidu.tbadk.core.c.a.tM().cA("tb.pb_mark");
            this.ekO = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.ekM == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.ekM = com.baidu.tbadk.core.c.a.tM().cA("tb.pb_normal");
            this.ekN = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void M(String str, boolean z) {
        if (z) {
            if (this.ekL != null && str != null) {
                this.ekL.b(str, new byte[0], 0L);
            }
        } else if (this.ekM != null && str != null) {
            this.ekM.b(str, new byte[0], 0L);
        }
    }

    public byte[] N(String str, boolean z) {
        o.c<byte[]> P;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.ekL != null && str != null) {
                P = this.ekL.P(str);
                j = this.ekO;
            }
            P = null;
        } else {
            if (this.ekM != null && str != null) {
                P = this.ekM.P(str);
                j = this.ekN;
            }
            P = null;
        }
        if (P == null || P.sB == null) {
            return null;
        }
        com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
        vVar.fe(1001);
        vVar.aGG = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.GC();
        return P.sB;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Yq();
            if (z) {
                this.ekL.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.ekM.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
            vVar.fe(1001);
            vVar.aGH = currentTimeMillis2;
            vVar.GD();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Yq();
            this.ekL.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
            vVar.fe(1001);
            vVar.aGH = currentTimeMillis2;
            vVar.GD();
        }
    }
}
