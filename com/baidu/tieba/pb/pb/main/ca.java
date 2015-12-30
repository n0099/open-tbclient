package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ca {
    private static ca cGx;
    private com.baidu.adp.lib.cache.o<byte[]> cGy = null;
    private com.baidu.adp.lib.cache.o<byte[]> cGz = null;
    private long cGA = 0;
    private long cGB = 0;

    public static synchronized ca alH() {
        ca caVar;
        synchronized (ca.class) {
            if (cGx == null) {
                cGx = new ca();
            }
            caVar = cGx;
        }
        return caVar;
    }

    private ca() {
        Mp();
    }

    private void Mp() {
        if (this.cGy == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.cGy = com.baidu.tbadk.core.b.a.tc().cB("tb.pb_mark");
            this.cGB = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.cGz == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.cGz = com.baidu.tbadk.core.b.a.tc().cB("tb.pb_normal");
            this.cGA = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void A(String str, boolean z) {
        if (z) {
            if (this.cGy != null && str != null) {
                this.cGy.b(str, new byte[0], 0L);
            }
        } else if (this.cGz != null && str != null) {
            this.cGz.b(str, new byte[0], 0L);
        }
    }

    public byte[] B(String str, boolean z) {
        o.b<byte[]> aa;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.cGy != null && str != null) {
                aa = this.cGy.aa(str);
                j = this.cGB;
            }
            aa = null;
        } else {
            if (this.cGz != null && str != null) {
                aa = this.cGz.aa(str);
                j = this.cGA;
            }
            aa = null;
        }
        if (aa == null || aa.sq == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
        tVar.eF(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        tVar.azX = (System.currentTimeMillis() - currentTimeMillis) + j;
        tVar.ED();
        return aa.sq;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Mp();
            if (z) {
                this.cGy.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.cGz.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eF(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.azY = currentTimeMillis2;
            tVar.EE();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Mp();
            this.cGy.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eF(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.azY = currentTimeMillis2;
            tVar.EE();
        }
    }
}
