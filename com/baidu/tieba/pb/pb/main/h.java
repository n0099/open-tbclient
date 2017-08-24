package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class h {
    private static h eLG;
    private com.baidu.adp.lib.cache.l<byte[]> eLH = null;
    private com.baidu.adp.lib.cache.l<byte[]> eLI = null;
    private long eLJ = 0;
    private long eLK = 0;

    public static synchronized h aRO() {
        h hVar;
        synchronized (h.class) {
            if (eLG == null) {
                eLG = new h();
            }
            hVar = eLG;
        }
        return hVar;
    }

    private h() {
        aeh();
    }

    private void aeh() {
        if (this.eLH == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eLH = com.baidu.tbadk.core.c.a.to().cS("tb.pb_mark");
            this.eLK = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eLI == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eLI = com.baidu.tbadk.core.c.a.to().cS("tb.pb_normal");
            this.eLJ = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void Q(String str, boolean z) {
        if (z) {
            if (this.eLH != null && str != null) {
                this.eLH.b(str, new byte[0], 0L);
            }
        } else if (this.eLI != null && str != null) {
            this.eLI.b(str, new byte[0], 0L);
        }
    }

    public byte[] R(String str, boolean z) {
        l.c<byte[]> ad;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eLH != null && str != null) {
                ad = this.eLH.ad(str);
                j = this.eLK;
            }
            ad = null;
        } else {
            if (this.eLI != null && str != null) {
                ad = this.eLI.ad(str);
                j = this.eLJ;
            }
            ad = null;
        }
        if (ad == null || ad.up == null) {
            return null;
        }
        com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
        mVar.fi(1001);
        mVar.aKm = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.Gv();
        return ad.up;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            aeh();
            if (z) {
                this.eLH.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eLI.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fi(1001);
            mVar.aKn = currentTimeMillis2;
            mVar.Gw();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            aeh();
            this.eLH.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fi(1001);
            mVar.aKn = currentTimeMillis2;
            mVar.Gw();
        }
    }
}
