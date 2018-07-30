package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes2.dex */
public class g {
    private static g fya;
    private com.baidu.adp.lib.cache.l<byte[]> fyb = null;
    private com.baidu.adp.lib.cache.l<byte[]> fyc = null;

    public static synchronized g bbR() {
        g gVar;
        synchronized (g.class) {
            if (fya == null) {
                fya = new g();
            }
            gVar = fya;
        }
        return gVar;
    }

    private g() {
        asU();
    }

    private void asU() {
        if (this.fyb == null) {
            this.fyb = com.baidu.tbadk.core.c.a.xb().dx("tb.pb_mark");
        }
        if (this.fyc == null) {
            this.fyc = com.baidu.tbadk.core.c.a.xb().dx("tb.pb_normal");
        }
    }

    public void J(String str, boolean z) {
        if (z) {
            if (this.fyb != null && str != null) {
                this.fyb.b(str, new byte[0], 0L);
            }
        } else if (this.fyc != null && str != null) {
            this.fyc.b(str, new byte[0], 0L);
        }
    }

    public byte[] K(String str, boolean z) {
        l.b<byte[]> ao;
        if (z) {
            if (this.fyb != null && str != null) {
                ao = this.fyb.ao(str);
            }
            ao = null;
        } else {
            if (this.fyc != null && str != null) {
                ao = this.fyc.ao(str);
            }
            ao = null;
        }
        if (ao == null || ao.value == null) {
            return null;
        }
        return ao.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            asU();
            if (z) {
                this.fyb.a(str, bArr, 604800000L);
            } else {
                this.fyc.a(str, bArr, 86400000L);
            }
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            asU();
            this.fyb.a(str, bArr, 2592000000L);
        }
    }
}
