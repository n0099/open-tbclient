package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class cx {
    private static cx dih;
    private com.baidu.adp.lib.cache.o<byte[]> dii = null;
    private com.baidu.adp.lib.cache.o<byte[]> dij = null;
    private long dik = 0;
    private long dil = 0;

    public static synchronized cx awR() {
        cx cxVar;
        synchronized (cx.class) {
            if (dih == null) {
                dih = new cx();
            }
            cxVar = dih;
        }
        return cxVar;
    }

    private cx() {
        PX();
    }

    private void PX() {
        if (this.dii == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.dii = com.baidu.tbadk.core.b.a.um().cy("tb.pb_mark");
            this.dil = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.dij == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.dij = com.baidu.tbadk.core.b.a.um().cy("tb.pb_normal");
            this.dik = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void B(String str, boolean z) {
        if (z) {
            if (this.dii != null && str != null) {
                this.dii.b(str, new byte[0], 0L);
            }
        } else if (this.dij != null && str != null) {
            this.dij.b(str, new byte[0], 0L);
        }
    }

    public byte[] C(String str, boolean z) {
        o.b<byte[]> Z;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.dii != null && str != null) {
                Z = this.dii.Z(str);
                j = this.dil;
            }
            Z = null;
        } else {
            if (this.dij != null && str != null) {
                Z = this.dij.Z(str);
                j = this.dik;
            }
            Z = null;
        }
        if (Z == null || Z.sI == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
        vVar.fh(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        vVar.aBD = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.GQ();
        return Z.sI;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            PX();
            if (z) {
                this.dii.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.dij.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fh(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            vVar.aBE = currentTimeMillis2;
            vVar.GR();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            PX();
            this.dii.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fh(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            vVar.aBE = currentTimeMillis2;
            vVar.GR();
        }
    }
}
