package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bv {
    private static bv ckl;
    private com.baidu.adp.lib.cache.o<byte[]> ckm = null;
    private com.baidu.adp.lib.cache.o<byte[]> ckn = null;
    private long cko = 0;
    private long ckp = 0;

    public static synchronized bv agi() {
        bv bvVar;
        synchronized (bv.class) {
            if (ckl == null) {
                ckl = new bv();
            }
            bvVar = ckl;
        }
        return bvVar;
    }

    private bv() {
        KB();
    }

    private void KB() {
        if (this.ckm == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.ckm = com.baidu.tbadk.core.b.a.sO().cq("tb.pb_mark");
            this.ckp = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.ckn == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.ckn = com.baidu.tbadk.core.b.a.sO().cq("tb.pb_normal");
            this.cko = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void z(String str, boolean z) {
        if (z) {
            if (this.ckm != null && str != null) {
                this.ckm.b(str, new byte[0], 0L);
            }
        } else if (this.ckn != null && str != null) {
            this.ckn.b(str, new byte[0], 0L);
        }
    }

    public byte[] A(String str, boolean z) {
        o.b<byte[]> aa;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.ckm != null && str != null) {
                aa = this.ckm.aa(str);
                j = this.ckp;
            }
            aa = null;
        } else {
            if (this.ckn != null && str != null) {
                aa = this.ckn.aa(str);
                j = this.cko;
            }
            aa = null;
        }
        if (aa == null || aa.sl == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
        tVar.ex(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        tVar.awp = (System.currentTimeMillis() - currentTimeMillis) + j;
        tVar.DN();
        return aa.sl;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            KB();
            if (z) {
                this.ckm.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.ckn.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ex(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.awq = currentTimeMillis2;
            tVar.DO();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            KB();
            this.ckm.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ex(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            tVar.awq = currentTimeMillis2;
            tVar.DO();
        }
    }
}
