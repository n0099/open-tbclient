package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class cp {
    private static cp ecF;
    private com.baidu.adp.lib.cache.o<byte[]> ecG = null;
    private com.baidu.adp.lib.cache.o<byte[]> ecH = null;
    private long ecI = 0;
    private long ecJ = 0;

    public static synchronized cp aID() {
        cp cpVar;
        synchronized (cp.class) {
            if (ecF == null) {
                ecF = new cp();
            }
            cpVar = ecF;
        }
        return cpVar;
    }

    private cp() {
        Vc();
    }

    private void Vc() {
        if (this.ecG == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.ecG = com.baidu.tbadk.core.b.a.rO().cv("tb.pb_mark");
            this.ecJ = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.ecH == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.ecH = com.baidu.tbadk.core.b.a.rO().cv("tb.pb_normal");
            this.ecI = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void F(String str, boolean z) {
        if (z) {
            if (this.ecG != null && str != null) {
                this.ecG.b(str, new byte[0], 0L);
            }
        } else if (this.ecH != null && str != null) {
            this.ecH.b(str, new byte[0], 0L);
        }
    }

    public byte[] G(String str, boolean z) {
        o.c<byte[]> S;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.ecG != null && str != null) {
                S = this.ecG.S(str);
                j = this.ecJ;
            }
            S = null;
        } else {
            if (this.ecH != null && str != null) {
                S = this.ecH.S(str);
                j = this.ecI;
            }
            S = null;
        }
        if (S == null || S.iZ == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
        vVar.eQ(1001);
        vVar.azm = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.ER();
        return S.iZ;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Vc();
            if (z) {
                this.ecG.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.ecH.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eQ(1001);
            vVar.azn = currentTimeMillis2;
            vVar.ES();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Vc();
            this.ecG.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eQ(1001);
            vVar.azn = currentTimeMillis2;
            vVar.ES();
        }
    }
}
