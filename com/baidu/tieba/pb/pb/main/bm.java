package com.baidu.tieba.pb.pb.main;

import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bm {
    private static bm bLo;
    private com.baidu.adp.lib.cache.t<byte[]> bLp = null;
    private com.baidu.adp.lib.cache.t<byte[]> bLq = null;
    private long bLr = 0;
    private long bLs = 0;

    public static synchronized bm abl() {
        bm bmVar;
        synchronized (bm.class) {
            if (bLo == null) {
                bLo = new bm();
            }
            bmVar = bLo;
        }
        return bmVar;
    }

    private bm() {
        abm();
    }

    private void abm() {
        if (this.bLp == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.bLp = com.baidu.tbadk.core.b.a.rI().cj("tb.pb_mark");
            this.bLs = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.bLq == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.bLq = com.baidu.tbadk.core.b.a.rI().cj("tb.pb_normal");
            this.bLr = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void w(String str, boolean z) {
        if (z) {
            if (this.bLp != null && str != null) {
                this.bLp.b(str, new byte[0], 0L);
            }
        } else if (this.bLq != null && str != null) {
            this.bLq.b(str, new byte[0], 0L);
        }
    }

    public byte[] x(String str, boolean z) {
        com.baidu.adp.lib.cache.v<byte[]> ad;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.bLp != null && str != null) {
                ad = this.bLp.ad(str);
                j = this.bLs;
            }
            ad = null;
        } else {
            if (this.bLq != null && str != null) {
                ad = this.bLq.ad(str);
                j = this.bLr;
            }
            ad = null;
        }
        if (ad == null || ad.ss == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
        aaVar.el(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        aaVar.aqF = (System.currentTimeMillis() - currentTimeMillis) + j;
        aaVar.Dy();
        return ad.ss;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            abm();
            if (z) {
                this.bLp.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.bLq.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
            aaVar.el(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            aaVar.aqG = currentTimeMillis2;
            aaVar.Dz();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            abm();
            this.bLp.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
            aaVar.el(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            aaVar.aqG = currentTimeMillis2;
            aaVar.Dz();
        }
    }
}
