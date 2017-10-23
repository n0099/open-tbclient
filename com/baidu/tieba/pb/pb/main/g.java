package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class g {
    private static g eDZ;
    private com.baidu.adp.lib.cache.l<byte[]> eEa = null;
    private com.baidu.adp.lib.cache.l<byte[]> eEb = null;
    private long eEc = 0;
    private long eEd = 0;

    public static synchronized g aPh() {
        g gVar;
        synchronized (g.class) {
            if (eDZ == null) {
                eDZ = new g();
            }
            gVar = eDZ;
        }
        return gVar;
    }

    private g() {
        afI();
    }

    private void afI() {
        if (this.eEa == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eEa = com.baidu.tbadk.core.c.a.sX().cH("tb.pb_mark");
            this.eEd = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eEb == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eEb = com.baidu.tbadk.core.c.a.sX().cH("tb.pb_normal");
            this.eEc = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void O(String str, boolean z) {
        if (z) {
            if (this.eEa != null && str != null) {
                this.eEa.b(str, new byte[0], 0L);
            }
        } else if (this.eEb != null && str != null) {
            this.eEb.b(str, new byte[0], 0L);
        }
    }

    public byte[] P(String str, boolean z) {
        l.b<byte[]> W;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eEa != null && str != null) {
                W = this.eEa.W(str);
                j = this.eEd;
            }
            W = null;
        } else {
            if (this.eEb != null && str != null) {
                W = this.eEb.W(str);
                j = this.eEc;
            }
            W = null;
        }
        if (W == null || W.value == null) {
            return null;
        }
        com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
        mVar.fs(1001);
        mVar.aJb = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.FS();
        return W.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            afI();
            if (z) {
                this.eEa.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eEb.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.fs(1001);
            mVar.aJc = currentTimeMillis2;
            mVar.FT();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            afI();
            this.eEa.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.fs(1001);
            mVar.aJc = currentTimeMillis2;
            mVar.FT();
        }
    }
}
