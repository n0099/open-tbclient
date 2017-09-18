package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class h {
    private static h eKN;
    private com.baidu.adp.lib.cache.l<byte[]> eKO = null;
    private com.baidu.adp.lib.cache.l<byte[]> eKP = null;
    private long eKQ = 0;
    private long eKR = 0;

    public static synchronized h aRq() {
        h hVar;
        synchronized (h.class) {
            if (eKN == null) {
                eKN = new h();
            }
            hVar = eKN;
        }
        return hVar;
    }

    private h() {
        afQ();
    }

    private void afQ() {
        if (this.eKO == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eKO = com.baidu.tbadk.core.c.a.tk().cI("tb.pb_mark");
            this.eKR = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eKP == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eKP = com.baidu.tbadk.core.c.a.tk().cI("tb.pb_normal");
            this.eKQ = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void R(String str, boolean z) {
        if (z) {
            if (this.eKO != null && str != null) {
                this.eKO.b(str, new byte[0], 0L);
            }
        } else if (this.eKP != null && str != null) {
            this.eKP.b(str, new byte[0], 0L);
        }
    }

    public byte[] S(String str, boolean z) {
        l.b<byte[]> W;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eKO != null && str != null) {
                W = this.eKO.W(str);
                j = this.eKR;
            }
            W = null;
        } else {
            if (this.eKP != null && str != null) {
                W = this.eKP.W(str);
                j = this.eKQ;
            }
            W = null;
        }
        if (W == null || W.rY == null) {
            return null;
        }
        com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
        mVar.fi(1001);
        mVar.aJN = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.Gt();
        return W.rY;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            afQ();
            if (z) {
                this.eKO.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eKP.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fi(1001);
            mVar.aJO = currentTimeMillis2;
            mVar.Gu();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            afQ();
            this.eKO.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fi(1001);
            mVar.aJO = currentTimeMillis2;
            mVar.Gu();
        }
    }
}
