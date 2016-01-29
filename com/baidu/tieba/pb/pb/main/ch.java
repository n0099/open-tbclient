package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ch {
    private static ch cOb;
    private com.baidu.adp.lib.cache.o<byte[]> cOc = null;
    private com.baidu.adp.lib.cache.o<byte[]> cOd = null;
    private long cOe = 0;
    private long cOf = 0;

    public static synchronized ch apK() {
        ch chVar;
        synchronized (ch.class) {
            if (cOb == null) {
                cOb = new ch();
            }
            chVar = cOb;
        }
        return chVar;
    }

    private ch() {
        Oi();
    }

    private void Oi() {
        if (this.cOc == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.cOc = com.baidu.tbadk.core.b.a.ug().cA("tb.pb_mark");
            this.cOf = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.cOd == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.cOd = com.baidu.tbadk.core.b.a.ug().cA("tb.pb_normal");
            this.cOe = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void A(String str, boolean z) {
        if (z) {
            if (this.cOc != null && str != null) {
                this.cOc.b(str, new byte[0], 0L);
            }
        } else if (this.cOd != null && str != null) {
            this.cOd.b(str, new byte[0], 0L);
        }
    }

    public byte[] B(String str, boolean z) {
        o.b<byte[]> Z;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.cOc != null && str != null) {
                Z = this.cOc.Z(str);
                j = this.cOf;
            }
            Z = null;
        } else {
            if (this.cOd != null && str != null) {
                Z = this.cOd.Z(str);
                j = this.cOe;
            }
            Z = null;
        }
        if (Z == null || Z.sz == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
        vVar.eZ(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        vVar.aAM = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.FU();
        return Z.sz;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Oi();
            if (z) {
                this.cOc.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.cOd.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eZ(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            vVar.aAN = currentTimeMillis2;
            vVar.FV();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Oi();
            this.cOc.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eZ(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            vVar.aAN = currentTimeMillis2;
            vVar.FV();
        }
    }
}
