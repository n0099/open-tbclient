package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bp {
    private static bp bCi;
    private com.baidu.adp.lib.cache.t<byte[]> bCj = null;
    private com.baidu.adp.lib.cache.t<byte[]> bCk = null;
    private long bCl = 0;
    private long bCm = 0;

    public static synchronized bp XG() {
        bp bpVar;
        synchronized (bp.class) {
            if (bCi == null) {
                bCi = new bp();
            }
            bpVar = bCi;
        }
        return bpVar;
    }

    private bp() {
        XH();
    }

    private void XH() {
        if (this.bCj == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.bCj = com.baidu.tbadk.core.a.a.nV().bS("tb.pb_mark");
            this.bCm = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.bCk == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.bCk = com.baidu.tbadk.core.a.a.nV().bS("tb.pb_normal");
            this.bCl = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void w(String str, boolean z) {
        if (z) {
            if (this.bCj != null && str != null) {
                this.bCj.b(str, new byte[0], 0L);
            }
        } else if (this.bCk != null && str != null) {
            this.bCk.b(str, new byte[0], 0L);
        }
    }

    public byte[] x(String str, boolean z) {
        com.baidu.adp.lib.cache.v<byte[]> U;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.bCj != null && str != null) {
                U = this.bCj.U(str);
                j = this.bCm;
            }
            U = null;
        } else {
            if (this.bCk != null && str != null) {
                U = this.bCk.U(str);
                j = this.bCl;
            }
            U = null;
        }
        if (U == null || U.gL == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
        wVar.dX(1001);
        wVar.agU = (System.currentTimeMillis() - currentTimeMillis) + j;
        wVar.zu();
        return U.gL;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            XH();
            if (z) {
                this.bCj.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.bCk.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
            wVar.dX(1001);
            wVar.agV = currentTimeMillis2;
            wVar.zv();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            XH();
            this.bCj.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
            wVar.dX(1001);
            wVar.agV = currentTimeMillis2;
            wVar.zv();
        }
    }
}
