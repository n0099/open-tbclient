package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class h {
    private static h eIx;
    private com.baidu.adp.lib.cache.l<byte[]> eIy = null;
    private com.baidu.adp.lib.cache.l<byte[]> eIz = null;
    private long eIA = 0;
    private long eIB = 0;

    public static synchronized h aRb() {
        h hVar;
        synchronized (h.class) {
            if (eIx == null) {
                eIx = new h();
            }
            hVar = eIx;
        }
        return hVar;
    }

    private h() {
        adL();
    }

    private void adL() {
        if (this.eIy == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eIy = com.baidu.tbadk.core.c.a.td().cJ("tb.pb_mark");
            this.eIB = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eIz == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eIz = com.baidu.tbadk.core.c.a.td().cJ("tb.pb_normal");
            this.eIA = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void Q(String str, boolean z) {
        if (z) {
            if (this.eIy != null && str != null) {
                this.eIy.b(str, new byte[0], 0L);
            }
        } else if (this.eIz != null && str != null) {
            this.eIz.b(str, new byte[0], 0L);
        }
    }

    public byte[] R(String str, boolean z) {
        l.c<byte[]> W;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eIy != null && str != null) {
                W = this.eIy.W(str);
                j = this.eIB;
            }
            W = null;
        } else {
            if (this.eIz != null && str != null) {
                W = this.eIz.W(str);
                j = this.eIA;
            }
            W = null;
        }
        if (W == null || W.sG == null) {
            return null;
        }
        com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
        mVar.fg(1001);
        mVar.aIV = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.Gn();
        return W.sG;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            adL();
            if (z) {
                this.eIy.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eIz.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fg(1001);
            mVar.aIW = currentTimeMillis2;
            mVar.Go();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            adL();
            this.eIy.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fg(1001);
            mVar.aIW = currentTimeMillis2;
            mVar.Go();
        }
    }
}
