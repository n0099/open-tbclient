package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bj {
    private static bj ciU;
    private com.baidu.adp.lib.cache.o<byte[]> ciV = null;
    private com.baidu.adp.lib.cache.o<byte[]> ciW = null;
    private long ciX = 0;
    private long ciY = 0;

    public static synchronized bj afH() {
        bj bjVar;
        synchronized (bj.class) {
            if (ciU == null) {
                ciU = new bj();
            }
            bjVar = ciU;
        }
        return bjVar;
    }

    private bj() {
        Kp();
    }

    private void Kp() {
        if (this.ciV == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.ciV = com.baidu.tbadk.core.b.a.sO().cp("tb.pb_mark");
            this.ciY = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.ciW == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.ciW = com.baidu.tbadk.core.b.a.sO().cp("tb.pb_normal");
            this.ciX = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void z(String str, boolean z) {
        if (z) {
            if (this.ciV != null && str != null) {
                this.ciV.b(str, new byte[0], 0L);
            }
        } else if (this.ciW != null && str != null) {
            this.ciW.b(str, new byte[0], 0L);
        }
    }

    public byte[] A(String str, boolean z) {
        o.b<byte[]> ac;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.ciV != null && str != null) {
                ac = this.ciV.ac(str);
                j = this.ciY;
            }
            ac = null;
        } else {
            if (this.ciW != null && str != null) {
                ac = this.ciW.ac(str);
                j = this.ciX;
            }
            ac = null;
        }
        if (ac == null || ac.sl == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
        tVar.ez(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        tVar.axz = (System.currentTimeMillis() - currentTimeMillis) + j;
        tVar.DX();
        return ac.sl;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Kp();
            if (z) {
                this.ciV.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.ciW.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ez(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.axA = currentTimeMillis2;
            tVar.DY();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Kp();
            this.ciV.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ez(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.axA = currentTimeMillis2;
            tVar.DY();
        }
    }
}
