package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes2.dex */
public class g {
    private static g fND;
    private com.baidu.adp.lib.cache.l<byte[]> fNE = null;
    private com.baidu.adp.lib.cache.l<byte[]> fNF = null;
    private long fNG = 0;
    private long fNH = 0;

    public static synchronized g bcU() {
        g gVar;
        synchronized (g.class) {
            if (fND == null) {
                fND = new g();
            }
            gVar = fND;
        }
        return gVar;
    }

    private g() {
        atM();
    }

    private void atM() {
        if (this.fNE == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fNE = com.baidu.tbadk.core.c.a.AQ().dg("tb.pb_mark");
            this.fNH = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.fNF == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.fNF = com.baidu.tbadk.core.c.a.AQ().dg("tb.pb_normal");
            this.fNG = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void O(String str, boolean z) {
        if (z) {
            if (this.fNE != null && str != null) {
                this.fNE.b(str, new byte[0], 0L);
            }
        } else if (this.fNF != null && str != null) {
            this.fNF.b(str, new byte[0], 0L);
        }
    }

    public byte[] P(String str, boolean z) {
        l.b<byte[]> ae;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.fNE != null && str != null) {
                ae = this.fNE.ae(str);
                j = this.fNH;
            }
            ae = null;
        } else {
            if (this.fNF != null && str != null) {
                ae = this.fNF.ae(str);
                j = this.fNG;
            }
            ae = null;
        }
        if (ae == null || ae.value == null) {
            return null;
        }
        com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
        lVar.ij(1001);
        lVar.bAL = j + (System.currentTimeMillis() - currentTimeMillis);
        lVar.Os();
        return ae.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            atM();
            if (z) {
                this.fNE.a(str, bArr, 604800000L);
            } else {
                this.fNF.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
            lVar.ij(1001);
            lVar.bAM = currentTimeMillis2;
            lVar.Ot();
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            atM();
            this.fNE.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
            lVar.ij(1001);
            lVar.bAM = currentTimeMillis2;
            lVar.Ot();
        }
    }
}
