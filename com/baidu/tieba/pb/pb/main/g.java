package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes2.dex */
public class g {
    private static g fxO;
    private com.baidu.adp.lib.cache.l<byte[]> fxP = null;
    private com.baidu.adp.lib.cache.l<byte[]> fxQ = null;

    public static synchronized g bdy() {
        g gVar;
        synchronized (g.class) {
            if (fxO == null) {
                fxO = new g();
            }
            gVar = fxO;
        }
        return gVar;
    }

    private g() {
        asq();
    }

    private void asq() {
        if (this.fxP == null) {
            this.fxP = com.baidu.tbadk.core.c.a.xj().dA("tb.pb_mark");
        }
        if (this.fxQ == null) {
            this.fxQ = com.baidu.tbadk.core.c.a.xj().dA("tb.pb_normal");
        }
    }

    public void K(String str, boolean z) {
        if (z) {
            if (this.fxP != null && str != null) {
                this.fxP.b(str, new byte[0], 0L);
            }
        } else if (this.fxQ != null && str != null) {
            this.fxQ.b(str, new byte[0], 0L);
        }
    }

    public byte[] L(String str, boolean z) {
        l.b<byte[]> an;
        if (z) {
            if (this.fxP != null && str != null) {
                an = this.fxP.an(str);
            }
            an = null;
        } else {
            if (this.fxQ != null && str != null) {
                an = this.fxQ.an(str);
            }
            an = null;
        }
        if (an == null || an.value == null) {
            return null;
        }
        return an.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            asq();
            if (z) {
                this.fxP.a(str, bArr, 604800000L);
            } else {
                this.fxQ.a(str, bArr, 86400000L);
            }
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            asq();
            this.fxP.a(str, bArr, 2592000000L);
        }
    }
}
