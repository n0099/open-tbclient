package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class cp {
    private static cp eqI;
    private com.baidu.adp.lib.cache.o<byte[]> eqJ = null;
    private com.baidu.adp.lib.cache.o<byte[]> eqK = null;
    private long eqL = 0;
    private long eqM = 0;

    public static synchronized cp aOc() {
        cp cpVar;
        synchronized (cp.class) {
            if (eqI == null) {
                eqI = new cp();
            }
            cpVar = eqI;
        }
        return cpVar;
    }

    private cp() {
        aal();
    }

    private void aal() {
        if (this.eqJ == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eqJ = com.baidu.tbadk.core.b.a.ti().cz("tb.pb_mark");
            this.eqM = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eqK == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eqK = com.baidu.tbadk.core.b.a.ti().cz("tb.pb_normal");
            this.eqL = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void K(String str, boolean z) {
        if (z) {
            if (this.eqJ != null && str != null) {
                this.eqJ.b(str, new byte[0], 0L);
            }
        } else if (this.eqK != null && str != null) {
            this.eqK.b(str, new byte[0], 0L);
        }
    }

    public byte[] L(String str, boolean z) {
        o.c<byte[]> T;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eqJ != null && str != null) {
                T = this.eqJ.T(str);
                j = this.eqM;
            }
            T = null;
        } else {
            if (this.eqK != null && str != null) {
                T = this.eqK.T(str);
                j = this.eqL;
            }
            T = null;
        }
        if (T == null || T.lo == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
        vVar.fd(1001);
        vVar.aBW = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.Gk();
        return T.lo;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            aal();
            if (z) {
                this.eqJ.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eqK.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fd(1001);
            vVar.aBX = currentTimeMillis2;
            vVar.Gl();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            aal();
            this.eqJ.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fd(1001);
            vVar.aBX = currentTimeMillis2;
            vVar.Gl();
        }
    }
}
