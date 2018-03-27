package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes2.dex */
public class g {
    private static g fNI;
    private com.baidu.adp.lib.cache.l<byte[]> fNJ = null;
    private com.baidu.adp.lib.cache.l<byte[]> fNK = null;
    private long fNL = 0;
    private long fNM = 0;

    public static synchronized g bcU() {
        g gVar;
        synchronized (g.class) {
            if (fNI == null) {
                fNI = new g();
            }
            gVar = fNI;
        }
        return gVar;
    }

    private g() {
        atM();
    }

    private void atM() {
        if (this.fNJ == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fNJ = com.baidu.tbadk.core.c.a.AR().dg("tb.pb_mark");
            this.fNM = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.fNK == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.fNK = com.baidu.tbadk.core.c.a.AR().dg("tb.pb_normal");
            this.fNL = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void N(String str, boolean z) {
        if (z) {
            if (this.fNJ != null && str != null) {
                this.fNJ.b(str, new byte[0], 0L);
            }
        } else if (this.fNK != null && str != null) {
            this.fNK.b(str, new byte[0], 0L);
        }
    }

    public byte[] O(String str, boolean z) {
        l.b<byte[]> ae;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.fNJ != null && str != null) {
                ae = this.fNJ.ae(str);
                j = this.fNM;
            }
            ae = null;
        } else {
            if (this.fNK != null && str != null) {
                ae = this.fNK.ae(str);
                j = this.fNL;
            }
            ae = null;
        }
        if (ae == null || ae.value == null) {
            return null;
        }
        com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
        lVar.ij(1001);
        lVar.bAB = j + (System.currentTimeMillis() - currentTimeMillis);
        lVar.Os();
        return ae.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            atM();
            if (z) {
                this.fNJ.a(str, bArr, 604800000L);
            } else {
                this.fNK.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
            lVar.ij(1001);
            lVar.bAC = currentTimeMillis2;
            lVar.Ot();
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            atM();
            this.fNJ.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
            lVar.ij(1001);
            lVar.bAC = currentTimeMillis2;
            lVar.Ot();
        }
    }
}
