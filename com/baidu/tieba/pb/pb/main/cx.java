package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class cx {
    private static cx ejK;
    private com.baidu.adp.lib.cache.o<byte[]> ejL = null;
    private com.baidu.adp.lib.cache.o<byte[]> ejM = null;
    private long ejN = 0;
    private long ejO = 0;

    public static synchronized cx aLE() {
        cx cxVar;
        synchronized (cx.class) {
            if (ejK == null) {
                ejK = new cx();
            }
            cxVar = ejK;
        }
        return cxVar;
    }

    private cx() {
        WU();
    }

    private void WU() {
        if (this.ejL == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.ejL = com.baidu.tbadk.core.c.a.sR().cA("tb.pb_mark");
            this.ejO = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.ejM == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.ejM = com.baidu.tbadk.core.c.a.sR().cA("tb.pb_normal");
            this.ejN = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void L(String str, boolean z) {
        if (z) {
            if (this.ejL != null && str != null) {
                this.ejL.b(str, new byte[0], 0L);
            }
        } else if (this.ejM != null && str != null) {
            this.ejM.b(str, new byte[0], 0L);
        }
    }

    public byte[] M(String str, boolean z) {
        o.c<byte[]> T;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.ejL != null && str != null) {
                T = this.ejL.T(str);
                j = this.ejO;
            }
            T = null;
        } else {
            if (this.ejM != null && str != null) {
                T = this.ejM.T(str);
                j = this.ejN;
            }
            T = null;
        }
        if (T == null || T.lj == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
        vVar.fh(1001);
        vVar.aAZ = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.FK();
        return T.lj;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            WU();
            if (z) {
                this.ejL.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.ejM.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fh(1001);
            vVar.aBa = currentTimeMillis2;
            vVar.FL();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            WU();
            this.ejL.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fh(1001);
            vVar.aBa = currentTimeMillis2;
            vVar.FL();
        }
    }
}
