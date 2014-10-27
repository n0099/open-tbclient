package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
public class bm {
    private static bm bwr;
    private com.baidu.adp.lib.cache.t<byte[]> bws = null;
    private com.baidu.adp.lib.cache.t<byte[]> bwt = null;
    private long bwu = 0;
    private long bwv = 0;

    public static synchronized bm WB() {
        bm bmVar;
        synchronized (bm.class) {
            if (bwr == null) {
                bwr = new bm();
            }
            bmVar = bwr;
        }
        return bmVar;
    }

    private bm() {
        WC();
    }

    private void WC() {
        if (this.bws == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.bws = com.baidu.tbadk.core.a.a.kS().bc("tb.pb_mark");
            this.bwv = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.bwt == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.bwt = com.baidu.tbadk.core.a.a.kS().bc("tb.pb_normal");
            this.bwu = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void y(String str, boolean z) {
        if (z) {
            if (this.bws != null && str != null) {
                this.bws.b(str, new byte[0], 0L);
            }
        } else if (this.bwt != null && str != null) {
            this.bwt.b(str, new byte[0], 0L);
        }
    }

    public byte[] z(String str, boolean z) {
        com.baidu.adp.lib.cache.v<byte[]> G;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.bws != null && str != null) {
                G = this.bws.G(str);
                j = this.bwv;
            }
            G = null;
        } else {
            if (this.bwt != null && str != null) {
                G = this.bwt.G(str);
                j = this.bwu;
            }
            G = null;
        }
        if (G == null || G.value == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.p pVar = new com.baidu.tbadk.performanceLog.p();
        pVar.dm(1001);
        pVar.Zd = (System.currentTimeMillis() - currentTimeMillis) + j;
        pVar.uJ();
        return G.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            WC();
            if (z) {
                this.bws.a(str, bArr, 604800000L);
            } else {
                this.bwt.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.p pVar = new com.baidu.tbadk.performanceLog.p();
            pVar.dm(1001);
            pVar.Ze = currentTimeMillis2;
            pVar.uK();
        }
    }

    public void j(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            WC();
            this.bws.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.p pVar = new com.baidu.tbadk.performanceLog.p();
            pVar.dm(1001);
            pVar.Ze = currentTimeMillis2;
            pVar.uK();
        }
    }
}
