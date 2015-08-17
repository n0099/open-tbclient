package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bi {
    private static bi cbM;
    private com.baidu.adp.lib.cache.o<byte[]> cbN = null;
    private com.baidu.adp.lib.cache.o<byte[]> cbO = null;
    private long cbP = 0;
    private long cbQ = 0;

    public static synchronized bi adv() {
        bi biVar;
        synchronized (bi.class) {
            if (cbM == null) {
                cbM = new bi();
            }
            biVar = cbM;
        }
        return biVar;
    }

    private bi() {
        KG();
    }

    private void KG() {
        if (this.cbN == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.cbN = com.baidu.tbadk.core.b.a.sM().cj("tb.pb_mark");
            this.cbQ = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.cbO == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.cbO = com.baidu.tbadk.core.b.a.sM().cj("tb.pb_normal");
            this.cbP = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void w(String str, boolean z) {
        if (z) {
            if (this.cbN != null && str != null) {
                this.cbN.b(str, new byte[0], 0L);
            }
        } else if (this.cbO != null && str != null) {
            this.cbO.b(str, new byte[0], 0L);
        }
    }

    public byte[] x(String str, boolean z) {
        o.b<byte[]> ac;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.cbN != null && str != null) {
                ac = this.cbN.ac(str);
                j = this.cbQ;
            }
            ac = null;
        } else {
            if (this.cbO != null && str != null) {
                ac = this.cbO.ac(str);
                j = this.cbP;
            }
            ac = null;
        }
        if (ac == null || ac.so == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
        tVar.eq(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        tVar.axs = (System.currentTimeMillis() - currentTimeMillis) + j;
        tVar.Ea();
        return ac.so;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            KG();
            if (z) {
                this.cbN.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.cbO.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eq(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.axt = currentTimeMillis2;
            tVar.Eb();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            KG();
            this.cbN.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eq(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.axt = currentTimeMillis2;
            tVar.Eb();
        }
    }
}
