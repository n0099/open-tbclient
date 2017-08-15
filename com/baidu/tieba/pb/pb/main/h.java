package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class h {
    private static h eLE;
    private com.baidu.adp.lib.cache.l<byte[]> eLF = null;
    private com.baidu.adp.lib.cache.l<byte[]> eLG = null;
    private long eLH = 0;
    private long eLI = 0;

    public static synchronized h aRT() {
        h hVar;
        synchronized (h.class) {
            if (eLE == null) {
                eLE = new h();
            }
            hVar = eLE;
        }
        return hVar;
    }

    private h() {
        ael();
    }

    private void ael() {
        if (this.eLF == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eLF = com.baidu.tbadk.core.c.a.tn().cP("tb.pb_mark");
            this.eLI = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eLG == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eLG = com.baidu.tbadk.core.c.a.tn().cP("tb.pb_normal");
            this.eLH = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void Q(String str, boolean z) {
        if (z) {
            if (this.eLF != null && str != null) {
                this.eLF.b(str, new byte[0], 0L);
            }
        } else if (this.eLG != null && str != null) {
            this.eLG.b(str, new byte[0], 0L);
        }
    }

    public byte[] R(String str, boolean z) {
        l.c<byte[]> ac;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eLF != null && str != null) {
                ac = this.eLF.ac(str);
                j = this.eLI;
            }
            ac = null;
        } else {
            if (this.eLG != null && str != null) {
                ac = this.eLG.ac(str);
                j = this.eLH;
            }
            ac = null;
        }
        if (ac == null || ac.up == null) {
            return null;
        }
        com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
        mVar.fi(1001);
        mVar.aKl = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.Gv();
        return ac.up;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ael();
            if (z) {
                this.eLF.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eLG.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fi(1001);
            mVar.aKm = currentTimeMillis2;
            mVar.Gw();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ael();
            this.eLF.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fi(1001);
            mVar.aKm = currentTimeMillis2;
            mVar.Gw();
        }
    }
}
