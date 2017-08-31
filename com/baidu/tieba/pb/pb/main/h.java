package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class h {
    private static h eJT;
    private com.baidu.adp.lib.cache.l<byte[]> eJU = null;
    private com.baidu.adp.lib.cache.l<byte[]> eJV = null;
    private long eJW = 0;
    private long eJX = 0;

    public static synchronized h aRf() {
        h hVar;
        synchronized (h.class) {
            if (eJT == null) {
                eJT = new h();
            }
            hVar = eJT;
        }
        return hVar;
    }

    private h() {
        afF();
    }

    private void afF() {
        if (this.eJU == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eJU = com.baidu.tbadk.core.c.a.tk().cI("tb.pb_mark");
            this.eJX = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eJV == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eJV = com.baidu.tbadk.core.c.a.tk().cI("tb.pb_normal");
            this.eJW = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void R(String str, boolean z) {
        if (z) {
            if (this.eJU != null && str != null) {
                this.eJU.b(str, new byte[0], 0L);
            }
        } else if (this.eJV != null && str != null) {
            this.eJV.b(str, new byte[0], 0L);
        }
    }

    public byte[] S(String str, boolean z) {
        l.b<byte[]> W;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eJU != null && str != null) {
                W = this.eJU.W(str);
                j = this.eJX;
            }
            W = null;
        } else {
            if (this.eJV != null && str != null) {
                W = this.eJV.W(str);
                j = this.eJW;
            }
            W = null;
        }
        if (W == null || W.rY == null) {
            return null;
        }
        com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
        mVar.fi(1001);
        mVar.aJQ = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.Gt();
        return W.rY;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            afF();
            if (z) {
                this.eJU.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eJV.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fi(1001);
            mVar.aJR = currentTimeMillis2;
            mVar.Gu();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            afF();
            this.eJU.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fi(1001);
            mVar.aJR = currentTimeMillis2;
            mVar.Gu();
        }
    }
}
