package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class g {
    private static g eEn;
    private com.baidu.adp.lib.cache.l<byte[]> eEo = null;
    private com.baidu.adp.lib.cache.l<byte[]> eEp = null;
    private long eEq = 0;
    private long eEr = 0;

    public static synchronized g aPm() {
        g gVar;
        synchronized (g.class) {
            if (eEn == null) {
                eEn = new g();
            }
            gVar = eEn;
        }
        return gVar;
    }

    private g() {
        afN();
    }

    private void afN() {
        if (this.eEo == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eEo = com.baidu.tbadk.core.c.a.te().cI("tb.pb_mark");
            this.eEr = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eEp == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eEp = com.baidu.tbadk.core.c.a.te().cI("tb.pb_normal");
            this.eEq = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void O(String str, boolean z) {
        if (z) {
            if (this.eEo != null && str != null) {
                this.eEo.b(str, new byte[0], 0L);
            }
        } else if (this.eEp != null && str != null) {
            this.eEp.b(str, new byte[0], 0L);
        }
    }

    public byte[] P(String str, boolean z) {
        l.b<byte[]> W;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eEo != null && str != null) {
                W = this.eEo.W(str);
                j = this.eEr;
            }
            W = null;
        } else {
            if (this.eEp != null && str != null) {
                W = this.eEp.W(str);
                j = this.eEq;
            }
            W = null;
        }
        if (W == null || W.value == null) {
            return null;
        }
        com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
        mVar.ft(1001);
        mVar.aJo = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.FY();
        return W.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            afN();
            if (z) {
                this.eEo.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eEp.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.ft(1001);
            mVar.aJp = currentTimeMillis2;
            mVar.FZ();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            afN();
            this.eEo.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.ft(1001);
            mVar.aJp = currentTimeMillis2;
            mVar.FZ();
        }
    }
}
