package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class cp {
    private static cp eoK;
    private com.baidu.adp.lib.cache.o<byte[]> eoL = null;
    private com.baidu.adp.lib.cache.o<byte[]> eoM = null;
    private long eoN = 0;
    private long eoO = 0;

    public static synchronized cp aNu() {
        cp cpVar;
        synchronized (cp.class) {
            if (eoK == null) {
                eoK = new cp();
            }
            cpVar = eoK;
        }
        return cpVar;
    }

    private cp() {
        ZX();
    }

    private void ZX() {
        if (this.eoL == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eoL = com.baidu.tbadk.core.b.a.sT().cx("tb.pb_mark");
            this.eoO = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eoM == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eoM = com.baidu.tbadk.core.b.a.sT().cx("tb.pb_normal");
            this.eoN = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void J(String str, boolean z) {
        if (z) {
            if (this.eoL != null && str != null) {
                this.eoL.b(str, new byte[0], 0L);
            }
        } else if (this.eoM != null && str != null) {
            this.eoM.b(str, new byte[0], 0L);
        }
    }

    public byte[] K(String str, boolean z) {
        o.c<byte[]> T;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eoL != null && str != null) {
                T = this.eoL.T(str);
                j = this.eoO;
            }
            T = null;
        } else {
            if (this.eoM != null && str != null) {
                T = this.eoM.T(str);
                j = this.eoN;
            }
            T = null;
        }
        if (T == null || T.lo == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
        vVar.fe(1001);
        vVar.aCt = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.Gl();
        return T.lo;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ZX();
            if (z) {
                this.eoL.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eoM.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fe(1001);
            vVar.aCu = currentTimeMillis2;
            vVar.Gm();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ZX();
            this.eoL.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fe(1001);
            vVar.aCu = currentTimeMillis2;
            vVar.Gm();
        }
    }
}
