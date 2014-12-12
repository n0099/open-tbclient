package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bp {
    private static bp bAy;
    private com.baidu.adp.lib.cache.t<byte[]> bAz = null;
    private com.baidu.adp.lib.cache.t<byte[]> bAA = null;
    private long bAB = 0;
    private long bAC = 0;

    public static synchronized bp Xb() {
        bp bpVar;
        synchronized (bp.class) {
            if (bAy == null) {
                bAy = new bp();
            }
            bpVar = bAy;
        }
        return bpVar;
    }

    private bp() {
        Xc();
    }

    private void Xc() {
        if (this.bAz == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.bAz = com.baidu.tbadk.core.a.a.nS().bU("tb.pb_mark");
            this.bAC = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.bAA == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.bAA = com.baidu.tbadk.core.a.a.nS().bU("tb.pb_normal");
            this.bAB = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void w(String str, boolean z) {
        if (z) {
            if (this.bAz != null && str != null) {
                this.bAz.b(str, new byte[0], 0L);
            }
        } else if (this.bAA != null && str != null) {
            this.bAA.b(str, new byte[0], 0L);
        }
    }

    public byte[] x(String str, boolean z) {
        com.baidu.adp.lib.cache.v<byte[]> U;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.bAz != null && str != null) {
                U = this.bAz.U(str);
                j = this.bAC;
            }
            U = null;
        } else {
            if (this.bAA != null && str != null) {
                U = this.bAA.U(str);
                j = this.bAB;
            }
            U = null;
        }
        if (U == null || U.gJ == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
        wVar.dR(1001);
        wVar.agw = (System.currentTimeMillis() - currentTimeMillis) + j;
        wVar.zd();
        return U.gJ;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Xc();
            if (z) {
                this.bAz.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.bAA.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
            wVar.dR(1001);
            wVar.agx = currentTimeMillis2;
            wVar.ze();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Xc();
            this.bAz.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
            wVar.dR(1001);
            wVar.agx = currentTimeMillis2;
            wVar.ze();
        }
    }
}
