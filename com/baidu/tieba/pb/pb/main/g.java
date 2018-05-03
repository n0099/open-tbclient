package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes2.dex */
public class g {
    private static g fhq;
    private com.baidu.adp.lib.cache.l<byte[]> fhr = null;
    private com.baidu.adp.lib.cache.l<byte[]> fhs = null;
    private long fht = 0;
    private long fhu = 0;

    public static synchronized g aXS() {
        g gVar;
        synchronized (g.class) {
            if (fhq == null) {
                fhq = new g();
            }
            gVar = fhq;
        }
        return gVar;
    }

    private g() {
        aob();
    }

    private void aob() {
        if (this.fhr == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fhr = com.baidu.tbadk.core.c.a.tz().cY("tb.pb_mark");
            this.fhu = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.fhs == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.fhs = com.baidu.tbadk.core.c.a.tz().cY("tb.pb_normal");
            this.fht = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void J(String str, boolean z) {
        if (z) {
            if (this.fhr != null && str != null) {
                this.fhr.b(str, new byte[0], 0L);
            }
        } else if (this.fhs != null && str != null) {
            this.fhs.b(str, new byte[0], 0L);
        }
    }

    public byte[] K(String str, boolean z) {
        l.b<byte[]> ab;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.fhr != null && str != null) {
                ab = this.fhr.ab(str);
                j = this.fhu;
            }
            ab = null;
        } else {
            if (this.fhs != null && str != null) {
                ab = this.fhs.ab(str);
                j = this.fht;
            }
            ab = null;
        }
        if (ab == null || ab.value == null) {
            return null;
        }
        com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
        lVar.fi(1001);
        lVar.aKX = j + (System.currentTimeMillis() - currentTimeMillis);
        lVar.GU();
        return ab.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            aob();
            if (z) {
                this.fhr.a(str, bArr, 604800000L);
            } else {
                this.fhs.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
            lVar.fi(1001);
            lVar.aKY = currentTimeMillis2;
            lVar.GV();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            aob();
            this.fhr.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
            lVar.fi(1001);
            lVar.aKY = currentTimeMillis2;
            lVar.GV();
        }
    }
}
