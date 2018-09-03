package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes2.dex */
public class g {
    private static g fxT;
    private com.baidu.adp.lib.cache.l<byte[]> fxU = null;
    private com.baidu.adp.lib.cache.l<byte[]> fxV = null;

    public static synchronized g bbM() {
        g gVar;
        synchronized (g.class) {
            if (fxT == null) {
                fxT = new g();
            }
            gVar = fxT;
        }
        return gVar;
    }

    private g() {
        asT();
    }

    private void asT() {
        if (this.fxU == null) {
            this.fxU = com.baidu.tbadk.core.c.a.xa().dx("tb.pb_mark");
        }
        if (this.fxV == null) {
            this.fxV = com.baidu.tbadk.core.c.a.xa().dx("tb.pb_normal");
        }
    }

    public void J(String str, boolean z) {
        if (z) {
            if (this.fxU != null && str != null) {
                this.fxU.b(str, new byte[0], 0L);
            }
        } else if (this.fxV != null && str != null) {
            this.fxV.b(str, new byte[0], 0L);
        }
    }

    public byte[] K(String str, boolean z) {
        l.b<byte[]> ao;
        if (z) {
            if (this.fxU != null && str != null) {
                ao = this.fxU.ao(str);
            }
            ao = null;
        } else {
            if (this.fxV != null && str != null) {
                ao = this.fxV.ao(str);
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
            asT();
            if (z) {
                this.fxU.a(str, bArr, 604800000L);
            } else {
                this.fxV.a(str, bArr, 86400000L);
            }
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            asT();
            this.fxU.a(str, bArr, 2592000000L);
        }
    }
}
