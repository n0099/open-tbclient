package com.baidu.tieba.pb.pb.main;

import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bp {
    private static bp bJh;
    private com.baidu.adp.lib.cache.t<byte[]> bJi = null;
    private com.baidu.adp.lib.cache.t<byte[]> bJj = null;
    private long bJk = 0;
    private long bJl = 0;

    public static synchronized bp ZW() {
        bp bpVar;
        synchronized (bp.class) {
            if (bJh == null) {
                bJh = new bp();
            }
            bpVar = bJh;
        }
        return bpVar;
    }

    private bp() {
        ZX();
    }

    private void ZX() {
        if (this.bJi == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.bJi = com.baidu.tbadk.core.b.a.rc().bW("tb.pb_mark");
            this.bJl = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.bJj == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.bJj = com.baidu.tbadk.core.b.a.rc().bW("tb.pb_normal");
            this.bJk = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void w(String str, boolean z) {
        if (z) {
            if (this.bJi != null && str != null) {
                this.bJi.b(str, new byte[0], 0L);
            }
        } else if (this.bJj != null && str != null) {
            this.bJj.b(str, new byte[0], 0L);
        }
    }

    public byte[] x(String str, boolean z) {
        com.baidu.adp.lib.cache.v<byte[]> ab;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.bJi != null && str != null) {
                ab = this.bJi.ab(str);
                j = this.bJl;
            }
            ab = null;
        } else {
            if (this.bJj != null && str != null) {
                ab = this.bJj.ab(str);
                j = this.bJk;
            }
            ab = null;
        }
        if (ab == null || ab.sf == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
        aaVar.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        aaVar.apD = (System.currentTimeMillis() - currentTimeMillis) + j;
        aaVar.CM();
        return ab.sf;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ZX();
            if (z) {
                this.bJi.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.bJj.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
            aaVar.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            aaVar.apE = currentTimeMillis2;
            aaVar.CN();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ZX();
            this.bJi.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
            aaVar.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            aaVar.apE = currentTimeMillis2;
            aaVar.CN();
        }
    }
}
