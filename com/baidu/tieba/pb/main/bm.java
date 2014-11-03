package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
public class bm {
    private static bm bwF;
    private com.baidu.adp.lib.cache.t<byte[]> bwG = null;
    private com.baidu.adp.lib.cache.t<byte[]> bwH = null;
    private long bwI = 0;
    private long bwJ = 0;

    public static synchronized bm WE() {
        bm bmVar;
        synchronized (bm.class) {
            if (bwF == null) {
                bwF = new bm();
            }
            bmVar = bwF;
        }
        return bmVar;
    }

    private bm() {
        WF();
    }

    private void WF() {
        if (this.bwG == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.bwG = com.baidu.tbadk.core.a.a.kS().bc("tb.pb_mark");
            this.bwJ = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.bwH == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.bwH = com.baidu.tbadk.core.a.a.kS().bc("tb.pb_normal");
            this.bwI = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void y(String str, boolean z) {
        if (z) {
            if (this.bwG != null && str != null) {
                this.bwG.b(str, new byte[0], 0L);
            }
        } else if (this.bwH != null && str != null) {
            this.bwH.b(str, new byte[0], 0L);
        }
    }

    public byte[] z(String str, boolean z) {
        com.baidu.adp.lib.cache.v<byte[]> G;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.bwG != null && str != null) {
                G = this.bwG.G(str);
                j = this.bwJ;
            }
            G = null;
        } else {
            if (this.bwH != null && str != null) {
                G = this.bwH.G(str);
                j = this.bwI;
            }
            G = null;
        }
        if (G == null || G.value == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.p pVar = new com.baidu.tbadk.performanceLog.p();
        pVar.dm(1001);
        pVar.Zh = (System.currentTimeMillis() - currentTimeMillis) + j;
        pVar.uL();
        return G.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            WF();
            if (z) {
                this.bwG.a(str, bArr, 604800000L);
            } else {
                this.bwH.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.p pVar = new com.baidu.tbadk.performanceLog.p();
            pVar.dm(1001);
            pVar.Zi = currentTimeMillis2;
            pVar.uM();
        }
    }

    public void j(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            WF();
            this.bwG.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.p pVar = new com.baidu.tbadk.performanceLog.p();
            pVar.dm(1001);
            pVar.Zi = currentTimeMillis2;
            pVar.uM();
        }
    }
}
