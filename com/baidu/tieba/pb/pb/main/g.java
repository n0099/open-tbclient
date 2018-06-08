package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes2.dex */
public class g {
    private static g ftW;
    private com.baidu.adp.lib.cache.l<byte[]> ftX = null;
    private com.baidu.adp.lib.cache.l<byte[]> ftY = null;

    public static synchronized g bcQ() {
        g gVar;
        synchronized (g.class) {
            if (ftW == null) {
                ftW = new g();
            }
            gVar = ftW;
        }
        return gVar;
    }

    private g() {
        asf();
    }

    private void asf() {
        if (this.ftX == null) {
            this.ftX = com.baidu.tbadk.core.c.a.wW().dx("tb.pb_mark");
        }
        if (this.ftY == null) {
            this.ftY = com.baidu.tbadk.core.c.a.wW().dx("tb.pb_normal");
        }
    }

    public void J(String str, boolean z) {
        if (z) {
            if (this.ftX != null && str != null) {
                this.ftX.b(str, new byte[0], 0L);
            }
        } else if (this.ftY != null && str != null) {
            this.ftY.b(str, new byte[0], 0L);
        }
    }

    public byte[] K(String str, boolean z) {
        l.b<byte[]> an;
        if (z) {
            if (this.ftX != null && str != null) {
                an = this.ftX.an(str);
            }
            an = null;
        } else {
            if (this.ftY != null && str != null) {
                an = this.ftY.an(str);
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
            asf();
            if (z) {
                this.ftX.a(str, bArr, 604800000L);
            } else {
                this.ftY.a(str, bArr, 86400000L);
            }
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            asf();
            this.ftX.a(str, bArr, 2592000000L);
        }
    }
}
