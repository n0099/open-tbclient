package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bp {
    private static bp bCh;
    private com.baidu.adp.lib.cache.t<byte[]> bCi = null;
    private com.baidu.adp.lib.cache.t<byte[]> bCj = null;
    private long bCk = 0;
    private long bCl = 0;

    public static synchronized bp XB() {
        bp bpVar;
        synchronized (bp.class) {
            if (bCh == null) {
                bCh = new bp();
            }
            bpVar = bCh;
        }
        return bpVar;
    }

    private bp() {
        XC();
    }

    private void XC() {
        if (this.bCi == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.bCi = com.baidu.tbadk.core.a.a.nO().bP("tb.pb_mark");
            this.bCl = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.bCj == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.bCj = com.baidu.tbadk.core.a.a.nO().bP("tb.pb_normal");
            this.bCk = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void w(String str, boolean z) {
        if (z) {
            if (this.bCi != null && str != null) {
                this.bCi.b(str, new byte[0], 0L);
            }
        } else if (this.bCj != null && str != null) {
            this.bCj.b(str, new byte[0], 0L);
        }
    }

    public byte[] x(String str, boolean z) {
        com.baidu.adp.lib.cache.v<byte[]> U;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.bCi != null && str != null) {
                U = this.bCi.U(str);
                j = this.bCl;
            }
            U = null;
        } else {
            if (this.bCj != null && str != null) {
                U = this.bCj.U(str);
                j = this.bCk;
            }
            U = null;
        }
        if (U == null || U.gL == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
        wVar.dX(1001);
        wVar.agR = (System.currentTimeMillis() - currentTimeMillis) + j;
        wVar.zo();
        return U.gL;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            XC();
            if (z) {
                this.bCi.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.bCj.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
            wVar.dX(1001);
            wVar.agS = currentTimeMillis2;
            wVar.zp();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            XC();
            this.bCi.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
            wVar.dX(1001);
            wVar.agS = currentTimeMillis2;
            wVar.zp();
        }
    }
}
