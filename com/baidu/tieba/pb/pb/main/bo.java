package com.baidu.tieba.pb.pb.main;

import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bo {
    private static bo bIT;
    private com.baidu.adp.lib.cache.t<byte[]> bIU = null;
    private com.baidu.adp.lib.cache.t<byte[]> bIV = null;
    private long bIW = 0;
    private long bIX = 0;

    public static synchronized bo ZJ() {
        bo boVar;
        synchronized (bo.class) {
            if (bIT == null) {
                bIT = new bo();
            }
            boVar = bIT;
        }
        return boVar;
    }

    private bo() {
        ZK();
    }

    private void ZK() {
        if (this.bIU == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.bIU = com.baidu.tbadk.core.b.a.rc().bW("tb.pb_mark");
            this.bIX = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.bIV == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.bIV = com.baidu.tbadk.core.b.a.rc().bW("tb.pb_normal");
            this.bIW = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void w(String str, boolean z) {
        if (z) {
            if (this.bIU != null && str != null) {
                this.bIU.b(str, new byte[0], 0L);
            }
        } else if (this.bIV != null && str != null) {
            this.bIV.b(str, new byte[0], 0L);
        }
    }

    public byte[] x(String str, boolean z) {
        com.baidu.adp.lib.cache.v<byte[]> ab;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.bIU != null && str != null) {
                ab = this.bIU.ab(str);
                j = this.bIX;
            }
            ab = null;
        } else {
            if (this.bIV != null && str != null) {
                ab = this.bIV.ab(str);
                j = this.bIW;
            }
            ab = null;
        }
        if (ab == null || ab.sf == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
        aaVar.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        aaVar.apv = (System.currentTimeMillis() - currentTimeMillis) + j;
        aaVar.CG();
        return ab.sf;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ZK();
            if (z) {
                this.bIU.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.bIV.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
            aaVar.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            aaVar.apw = currentTimeMillis2;
            aaVar.CH();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ZK();
            this.bIU.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
            aaVar.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            aaVar.apw = currentTimeMillis2;
            aaVar.CH();
        }
    }
}
