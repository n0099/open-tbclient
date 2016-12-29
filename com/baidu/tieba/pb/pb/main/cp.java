package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class cp {
    private static cp eaS;
    private com.baidu.adp.lib.cache.o<byte[]> eaT = null;
    private com.baidu.adp.lib.cache.o<byte[]> eaU = null;
    private long eaV = 0;
    private long eaW = 0;

    public static synchronized cp aJR() {
        cp cpVar;
        synchronized (cp.class) {
            if (eaS == null) {
                eaS = new cp();
            }
            cpVar = eaS;
        }
        return cpVar;
    }

    private cp() {
        VA();
    }

    private void VA() {
        if (this.eaT == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eaT = com.baidu.tbadk.core.b.a.sX().cC("tb.pb_mark");
            this.eaW = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eaU == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eaU = com.baidu.tbadk.core.b.a.sX().cC("tb.pb_normal");
            this.eaV = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void L(String str, boolean z) {
        if (z) {
            if (this.eaT != null && str != null) {
                this.eaT.b(str, new byte[0], 0L);
            }
        } else if (this.eaU != null && str != null) {
            this.eaU.b(str, new byte[0], 0L);
        }
    }

    public byte[] M(String str, boolean z) {
        o.c<byte[]> T;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eaT != null && str != null) {
                T = this.eaT.T(str);
                j = this.eaW;
            }
            T = null;
        } else {
            if (this.eaU != null && str != null) {
                T = this.eaU.T(str);
                j = this.eaV;
            }
            T = null;
        }
        if (T == null || T.lp == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
        vVar.fg(1001);
        vVar.aCh = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.FQ();
        return T.lp;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            VA();
            if (z) {
                this.eaT.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eaU.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fg(1001);
            vVar.aCi = currentTimeMillis2;
            vVar.FR();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            VA();
            this.eaT.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fg(1001);
            vVar.aCi = currentTimeMillis2;
            vVar.FR();
        }
    }
}
