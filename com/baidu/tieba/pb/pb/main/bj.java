package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bj {
    private static bj cjf;
    private com.baidu.adp.lib.cache.o<byte[]> cjg = null;
    private com.baidu.adp.lib.cache.o<byte[]> cjh = null;
    private long cji = 0;
    private long cjj = 0;

    public static synchronized bj afD() {
        bj bjVar;
        synchronized (bj.class) {
            if (cjf == null) {
                cjf = new bj();
            }
            bjVar = cjf;
        }
        return bjVar;
    }

    private bj() {
        Kl();
    }

    private void Kl() {
        if (this.cjg == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.cjg = com.baidu.tbadk.core.b.a.sL().cq("tb.pb_mark");
            this.cjj = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.cjh == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.cjh = com.baidu.tbadk.core.b.a.sL().cq("tb.pb_normal");
            this.cji = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void z(String str, boolean z) {
        if (z) {
            if (this.cjg != null && str != null) {
                this.cjg.b(str, new byte[0], 0L);
            }
        } else if (this.cjh != null && str != null) {
            this.cjh.b(str, new byte[0], 0L);
        }
    }

    public byte[] A(String str, boolean z) {
        o.b<byte[]> ac;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.cjg != null && str != null) {
                ac = this.cjg.ac(str);
                j = this.cjj;
            }
            ac = null;
        } else {
            if (this.cjh != null && str != null) {
                ac = this.cjh.ac(str);
                j = this.cji;
            }
            ac = null;
        }
        if (ac == null || ac.sl == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
        tVar.ez(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        tVar.axA = (System.currentTimeMillis() - currentTimeMillis) + j;
        tVar.DU();
        return ac.sl;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Kl();
            if (z) {
                this.cjg.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.cjh.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ez(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.axB = currentTimeMillis2;
            tVar.DV();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Kl();
            this.cjg.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ez(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.axB = currentTimeMillis2;
            tVar.DV();
        }
    }
}
