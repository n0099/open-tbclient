package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class cq {
    private static cq ewx;
    private com.baidu.adp.lib.cache.o<byte[]> ewy = null;
    private com.baidu.adp.lib.cache.o<byte[]> ewz = null;
    private long ewA = 0;
    private long ewB = 0;

    public static synchronized cq aPS() {
        cq cqVar;
        synchronized (cq.class) {
            if (ewx == null) {
                ewx = new cq();
            }
            cqVar = ewx;
        }
        return cqVar;
    }

    private cq() {
        abn();
    }

    private void abn() {
        if (this.ewy == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.ewy = com.baidu.tbadk.core.b.a.tm().cB("tb.pb_mark");
            this.ewB = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.ewz == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.ewz = com.baidu.tbadk.core.b.a.tm().cB("tb.pb_normal");
            this.ewA = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void K(String str, boolean z) {
        if (z) {
            if (this.ewy != null && str != null) {
                this.ewy.b(str, new byte[0], 0L);
            }
        } else if (this.ewz != null && str != null) {
            this.ewz.b(str, new byte[0], 0L);
        }
    }

    public byte[] L(String str, boolean z) {
        o.c<byte[]> T;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.ewy != null && str != null) {
                T = this.ewy.T(str);
                j = this.ewB;
            }
            T = null;
        } else {
            if (this.ewz != null && str != null) {
                T = this.ewz.T(str);
                j = this.ewA;
            }
            T = null;
        }
        if (T == null || T.lp == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
        vVar.fg(1001);
        vVar.aCN = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.Gq();
        return T.lp;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            abn();
            if (z) {
                this.ewy.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.ewz.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fg(1001);
            vVar.aCO = currentTimeMillis2;
            vVar.Gr();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            abn();
            this.ewy.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fg(1001);
            vVar.aCO = currentTimeMillis2;
            vVar.Gr();
        }
    }
}
