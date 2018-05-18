package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes2.dex */
public class g {
    private static g fiz;
    private com.baidu.adp.lib.cache.l<byte[]> fiA = null;
    private com.baidu.adp.lib.cache.l<byte[]> fiB = null;
    private long fiC = 0;
    private long fiD = 0;

    public static synchronized g aXS() {
        g gVar;
        synchronized (g.class) {
            if (fiz == null) {
                fiz = new g();
            }
            gVar = fiz;
        }
        return gVar;
    }

    private g() {
        aoa();
    }

    private void aoa() {
        if (this.fiA == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fiA = com.baidu.tbadk.core.c.a.ty().cY("tb.pb_mark");
            this.fiD = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.fiB == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.fiB = com.baidu.tbadk.core.c.a.ty().cY("tb.pb_normal");
            this.fiC = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void J(String str, boolean z) {
        if (z) {
            if (this.fiA != null && str != null) {
                this.fiA.b(str, new byte[0], 0L);
            }
        } else if (this.fiB != null && str != null) {
            this.fiB.b(str, new byte[0], 0L);
        }
    }

    public byte[] K(String str, boolean z) {
        l.b<byte[]> ab;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.fiA != null && str != null) {
                ab = this.fiA.ab(str);
                j = this.fiD;
            }
            ab = null;
        } else {
            if (this.fiB != null && str != null) {
                ab = this.fiB.ab(str);
                j = this.fiC;
            }
            ab = null;
        }
        if (ab == null || ab.value == null) {
            return null;
        }
        com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
        lVar.fj(1001);
        lVar.aKY = j + (System.currentTimeMillis() - currentTimeMillis);
        lVar.GS();
        return ab.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            aoa();
            if (z) {
                this.fiA.a(str, bArr, 604800000L);
            } else {
                this.fiB.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
            lVar.fj(1001);
            lVar.aKZ = currentTimeMillis2;
            lVar.GT();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            aoa();
            this.fiA.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l();
            lVar.fj(1001);
            lVar.aKZ = currentTimeMillis2;
            lVar.GT();
        }
    }
}
