package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes2.dex */
public class g {
    private static g fNs;
    private com.baidu.adp.lib.cache.l<byte[]> fNt = null;
    private com.baidu.adp.lib.cache.l<byte[]> fNu = null;
    private long fNv = 0;
    private long fNw = 0;

    public static synchronized g bcT() {
        g gVar;
        synchronized (g.class) {
            if (fNs == null) {
                fNs = new g();
            }
            gVar = fNs;
        }
        return gVar;
    }

    private g() {
        atL();
    }

    private void atL() {
        if (this.fNt == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fNt = com.baidu.tbadk.core.c.a.AQ().dg("tb.pb_mark");
            this.fNw = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.fNu == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.fNu = com.baidu.tbadk.core.c.a.AQ().dg("tb.pb_normal");
            this.fNv = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void N(String str, boolean z) {
        if (z) {
            if (this.fNt != null && str != null) {
                this.fNt.b(str, new byte[0], 0L);
            }
        } else if (this.fNu != null && str != null) {
            this.fNu.b(str, new byte[0], 0L);
        }
    }

    public byte[] O(String str, boolean z) {
        l.b<byte[]> ae;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.fNt != null && str != null) {
                ae = this.fNt.ae(str);
                j = this.fNw;
            }
            ae = null;
        } else {
            if (this.fNu != null && str != null) {
                ae = this.fNu.ae(str);
                j = this.fNv;
            }
            ae = null;
        }
        if (ae == null || ae.value == null) {
            return null;
        }
        com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
        lVar.ij(1001);
        lVar.bAy = j + (System.currentTimeMillis() - currentTimeMillis);
        lVar.Or();
        return ae.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            atL();
            if (z) {
                this.fNt.a(str, bArr, 604800000L);
            } else {
                this.fNu.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
            lVar.ij(1001);
            lVar.bAz = currentTimeMillis2;
            lVar.Os();
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            atL();
            this.fNt.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
            lVar.ij(1001);
            lVar.bAz = currentTimeMillis2;
            lVar.Os();
        }
    }
}
