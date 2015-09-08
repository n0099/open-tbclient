package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bi {
    private static bi ccH;
    private com.baidu.adp.lib.cache.o<byte[]> ccI = null;
    private com.baidu.adp.lib.cache.o<byte[]> ccJ = null;
    private long ccK = 0;
    private long ccL = 0;

    public static synchronized bi adI() {
        bi biVar;
        synchronized (bi.class) {
            if (ccH == null) {
                ccH = new bi();
            }
            biVar = ccH;
        }
        return biVar;
    }

    private bi() {
        Ku();
    }

    private void Ku() {
        if (this.ccI == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.ccI = com.baidu.tbadk.core.b.a.sR().cp("tb.pb_mark");
            this.ccL = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.ccJ == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.ccJ = com.baidu.tbadk.core.b.a.sR().cp("tb.pb_normal");
            this.ccK = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void y(String str, boolean z) {
        if (z) {
            if (this.ccI != null && str != null) {
                this.ccI.b(str, new byte[0], 0L);
            }
        } else if (this.ccJ != null && str != null) {
            this.ccJ.b(str, new byte[0], 0L);
        }
    }

    public byte[] z(String str, boolean z) {
        o.b<byte[]> ac;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.ccI != null && str != null) {
                ac = this.ccI.ac(str);
                j = this.ccL;
            }
            ac = null;
        } else {
            if (this.ccJ != null && str != null) {
                ac = this.ccJ.ac(str);
                j = this.ccK;
            }
            ac = null;
        }
        if (ac == null || ac.sl == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
        tVar.ey(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        tVar.aza = (System.currentTimeMillis() - currentTimeMillis) + j;
        tVar.Ek();
        return ac.sl;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Ku();
            if (z) {
                this.ccI.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.ccJ.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ey(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.azb = currentTimeMillis2;
            tVar.El();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Ku();
            this.ccI.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ey(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.azb = currentTimeMillis2;
            tVar.El();
        }
    }
}
