package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class h {
    private static h eJK;
    private com.baidu.adp.lib.cache.l<byte[]> eJL = null;
    private com.baidu.adp.lib.cache.l<byte[]> eJM = null;
    private long eJN = 0;
    private long eJO = 0;

    public static synchronized h aRm() {
        h hVar;
        synchronized (h.class) {
            if (eJK == null) {
                eJK = new h();
            }
            hVar = eJK;
        }
        return hVar;
    }

    private h() {
        adQ();
    }

    private void adQ() {
        if (this.eJL == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eJL = com.baidu.tbadk.core.c.a.tn().cP("tb.pb_mark");
            this.eJO = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eJM == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eJM = com.baidu.tbadk.core.c.a.tn().cP("tb.pb_normal");
            this.eJN = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void P(String str, boolean z) {
        if (z) {
            if (this.eJL != null && str != null) {
                this.eJL.b(str, new byte[0], 0L);
            }
        } else if (this.eJM != null && str != null) {
            this.eJM.b(str, new byte[0], 0L);
        }
    }

    public byte[] Q(String str, boolean z) {
        l.c<byte[]> ac;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eJL != null && str != null) {
                ac = this.eJL.ac(str);
                j = this.eJO;
            }
            ac = null;
        } else {
            if (this.eJM != null && str != null) {
                ac = this.eJM.ac(str);
                j = this.eJN;
            }
            ac = null;
        }
        if (ac == null || ac.um == null) {
            return null;
        }
        com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
        mVar.fi(1001);
        mVar.aKk = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.Gv();
        return ac.um;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            adQ();
            if (z) {
                this.eJL.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eJM.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fi(1001);
            mVar.aKl = currentTimeMillis2;
            mVar.Gw();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            adQ();
            this.eJL.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fi(1001);
            mVar.aKl = currentTimeMillis2;
            mVar.Gw();
        }
    }
}
