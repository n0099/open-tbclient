package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes2.dex */
public class g {
    private static g fht;
    private com.baidu.adp.lib.cache.l<byte[]> fhu = null;
    private com.baidu.adp.lib.cache.l<byte[]> fhv = null;
    private long fhw = 0;
    private long fhx = 0;

    public static synchronized g aXS() {
        g gVar;
        synchronized (g.class) {
            if (fht == null) {
                fht = new g();
            }
            gVar = fht;
        }
        return gVar;
    }

    private g() {
        aob();
    }

    private void aob() {
        if (this.fhu == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fhu = com.baidu.tbadk.core.c.a.tz().cY("tb.pb_mark");
            this.fhx = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.fhv == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.fhv = com.baidu.tbadk.core.c.a.tz().cY("tb.pb_normal");
            this.fhw = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void J(String str, boolean z) {
        if (z) {
            if (this.fhu != null && str != null) {
                this.fhu.b(str, new byte[0], 0L);
            }
        } else if (this.fhv != null && str != null) {
            this.fhv.b(str, new byte[0], 0L);
        }
    }

    public byte[] K(String str, boolean z) {
        l.b<byte[]> ab;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.fhu != null && str != null) {
                ab = this.fhu.ab(str);
                j = this.fhx;
            }
            ab = null;
        } else {
            if (this.fhv != null && str != null) {
                ab = this.fhv.ab(str);
                j = this.fhw;
            }
            ab = null;
        }
        if (ab == null || ab.value == null) {
            return null;
        }
        com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
        lVar.fj(1001);
        lVar.aKX = j + (System.currentTimeMillis() - currentTimeMillis);
        lVar.GU();
        return ab.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            aob();
            if (z) {
                this.fhu.a(str, bArr, 604800000L);
            } else {
                this.fhv.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
            lVar.fj(1001);
            lVar.aKY = currentTimeMillis2;
            lVar.GV();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            aob();
            this.fhu.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
            lVar.fj(1001);
            lVar.aKY = currentTimeMillis2;
            lVar.GV();
        }
    }
}
