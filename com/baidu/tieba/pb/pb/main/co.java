package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class co {
    private static co dQq;
    private com.baidu.adp.lib.cache.o<byte[]> dQr = null;
    private com.baidu.adp.lib.cache.o<byte[]> dQs = null;
    private long dQt = 0;
    private long dQu = 0;

    public static synchronized co aFs() {
        co coVar;
        synchronized (co.class) {
            if (dQq == null) {
                dQq = new co();
            }
            coVar = dQq;
        }
        return coVar;
    }

    private co() {
        Uu();
    }

    private void Uu() {
        if (this.dQr == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.dQr = com.baidu.tbadk.core.b.a.rP().cv("tb.pb_mark");
            this.dQu = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.dQs == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.dQs = com.baidu.tbadk.core.b.a.rP().cv("tb.pb_normal");
            this.dQt = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void F(String str, boolean z) {
        if (z) {
            if (this.dQr != null && str != null) {
                this.dQr.b(str, new byte[0], 0L);
            }
        } else if (this.dQs != null && str != null) {
            this.dQs.b(str, new byte[0], 0L);
        }
    }

    public byte[] G(String str, boolean z) {
        o.b<byte[]> Q;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.dQr != null && str != null) {
                Q = this.dQr.Q(str);
                j = this.dQu;
            }
            Q = null;
        } else {
            if (this.dQs != null && str != null) {
                Q = this.dQs.Q(str);
                j = this.dQt;
            }
            Q = null;
        }
        if (Q == null || Q.ix == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
        vVar.eQ(1001);
        vVar.ayw = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.ES();
        return Q.ix;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Uu();
            if (z) {
                this.dQr.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.dQs.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eQ(1001);
            vVar.ayx = currentTimeMillis2;
            vVar.ET();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Uu();
            this.dQr.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eQ(1001);
            vVar.ayx = currentTimeMillis2;
            vVar.ET();
        }
    }
}
