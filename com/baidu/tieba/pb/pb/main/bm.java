package com.baidu.tieba.pb.pb.main;

import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bm {
    private static bm bLn;
    private com.baidu.adp.lib.cache.t<byte[]> bLo = null;
    private com.baidu.adp.lib.cache.t<byte[]> bLp = null;
    private long bLq = 0;
    private long bLr = 0;

    public static synchronized bm abk() {
        bm bmVar;
        synchronized (bm.class) {
            if (bLn == null) {
                bLn = new bm();
            }
            bmVar = bLn;
        }
        return bmVar;
    }

    private bm() {
        abl();
    }

    private void abl() {
        if (this.bLo == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.bLo = com.baidu.tbadk.core.b.a.rI().cj("tb.pb_mark");
            this.bLr = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.bLp == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.bLp = com.baidu.tbadk.core.b.a.rI().cj("tb.pb_normal");
            this.bLq = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void w(String str, boolean z) {
        if (z) {
            if (this.bLo != null && str != null) {
                this.bLo.b(str, new byte[0], 0L);
            }
        } else if (this.bLp != null && str != null) {
            this.bLp.b(str, new byte[0], 0L);
        }
    }

    public byte[] x(String str, boolean z) {
        com.baidu.adp.lib.cache.v<byte[]> ad;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.bLo != null && str != null) {
                ad = this.bLo.ad(str);
                j = this.bLr;
            }
            ad = null;
        } else {
            if (this.bLp != null && str != null) {
                ad = this.bLp.ad(str);
                j = this.bLq;
            }
            ad = null;
        }
        if (ad == null || ad.ss == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
        aaVar.el(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        aaVar.aqF = (System.currentTimeMillis() - currentTimeMillis) + j;
        aaVar.Dx();
        return ad.ss;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            abl();
            if (z) {
                this.bLo.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.bLp.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
            aaVar.el(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            aaVar.aqG = currentTimeMillis2;
            aaVar.Dy();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            abl();
            this.bLo.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
            aaVar.el(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            aaVar.aqG = currentTimeMillis2;
            aaVar.Dy();
        }
    }
}
