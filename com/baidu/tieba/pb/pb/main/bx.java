package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bx {
    private static bx cCK;
    private com.baidu.adp.lib.cache.o<byte[]> cCL = null;
    private com.baidu.adp.lib.cache.o<byte[]> cCM = null;
    private long cCN = 0;
    private long cCO = 0;

    public static synchronized bx akA() {
        bx bxVar;
        synchronized (bx.class) {
            if (cCK == null) {
                cCK = new bx();
            }
            bxVar = cCK;
        }
        return bxVar;
    }

    private bx() {
        LW();
    }

    private void LW() {
        if (this.cCL == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.cCL = com.baidu.tbadk.core.b.a.ts().cy("tb.pb_mark");
            this.cCO = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.cCM == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.cCM = com.baidu.tbadk.core.b.a.ts().cy("tb.pb_normal");
            this.cCN = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void B(String str, boolean z) {
        if (z) {
            if (this.cCL != null && str != null) {
                this.cCL.b(str, new byte[0], 0L);
            }
        } else if (this.cCM != null && str != null) {
            this.cCM.b(str, new byte[0], 0L);
        }
    }

    public byte[] C(String str, boolean z) {
        o.b<byte[]> aa;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.cCL != null && str != null) {
                aa = this.cCL.aa(str);
                j = this.cCO;
            }
            aa = null;
        } else {
            if (this.cCM != null && str != null) {
                aa = this.cCM.aa(str);
                j = this.cCN;
            }
            aa = null;
        }
        if (aa == null || aa.sm == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
        tVar.eL(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        tVar.ayu = (System.currentTimeMillis() - currentTimeMillis) + j;
        tVar.EO();
        return aa.sm;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            LW();
            if (z) {
                this.cCL.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.cCM.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eL(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.ayv = currentTimeMillis2;
            tVar.EP();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            LW();
            this.cCL.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eL(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.ayv = currentTimeMillis2;
            tVar.EP();
        }
    }
}
