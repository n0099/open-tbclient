package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class cg {
    private static cg dkr;
    private com.baidu.adp.lib.cache.o<byte[]> dks = null;
    private com.baidu.adp.lib.cache.o<byte[]> dkt = null;
    private long dku = 0;
    private long dkv = 0;

    public static synchronized cg axk() {
        cg cgVar;
        synchronized (cg.class) {
            if (dkr == null) {
                dkr = new cg();
            }
            cgVar = dkr;
        }
        return cgVar;
    }

    private cg() {
        OS();
    }

    private void OS() {
        if (this.dks == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.dks = com.baidu.tbadk.core.b.a.rS().cw("tb.pb_mark");
            this.dkv = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.dkt == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.dkt = com.baidu.tbadk.core.b.a.rS().cw("tb.pb_normal");
            this.dku = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void D(String str, boolean z) {
        if (z) {
            if (this.dks != null && str != null) {
                this.dks.b(str, new byte[0], 0L);
            }
        } else if (this.dkt != null && str != null) {
            this.dkt.b(str, new byte[0], 0L);
        }
    }

    public byte[] E(String str, boolean z) {
        o.b<byte[]> Q;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.dks != null && str != null) {
                Q = this.dks.Q(str);
                j = this.dkv;
            }
            Q = null;
        } else {
            if (this.dkt != null && str != null) {
                Q = this.dkt.Q(str);
                j = this.dku;
            }
            Q = null;
        }
        if (Q == null || Q.iz == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
        vVar.eL(1001);
        vVar.axG = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.EJ();
        return Q.iz;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            OS();
            if (z) {
                this.dks.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.dkt.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eL(1001);
            vVar.axH = currentTimeMillis2;
            vVar.EK();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            OS();
            this.dks.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eL(1001);
            vVar.axH = currentTimeMillis2;
            vVar.EK();
        }
    }
}
