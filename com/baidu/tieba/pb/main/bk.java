package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
public class bk {
    private static bk a;
    private com.baidu.adp.lib.cache.t<byte[]> b = null;
    private com.baidu.adp.lib.cache.t<byte[]> c = null;

    public static synchronized bk a() {
        bk bkVar;
        synchronized (bk.class) {
            if (a == null) {
                a = new bk();
            }
            bkVar = a;
        }
        return bkVar;
    }

    private bk() {
        b();
    }

    private void b() {
        if (this.b == null) {
            this.b = com.baidu.tbadk.core.a.a.a().a("tb.pb_mark");
        }
        if (this.c == null) {
            this.c = com.baidu.tbadk.core.a.a.a().a("tb.pb_normal");
        }
    }

    public void a(String str, boolean z) {
        if (z) {
            if (this.b != null && str != null) {
                this.b.b(str, new byte[0], 0L);
            }
        } else if (this.c != null && str != null) {
            this.c.b(str, new byte[0], 0L);
        }
    }

    public byte[] b(String str, boolean z) {
        com.baidu.adp.lib.cache.v<byte[]> b;
        if (z) {
            if (this.b != null && str != null) {
                b = this.b.b(str);
            }
            b = null;
        } else {
            if (this.c != null && str != null) {
                b = this.c.b(str);
            }
            b = null;
        }
        if (b == null || b.b == null) {
            return null;
        }
        return b.b;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            b();
            if (z) {
                this.b.b(str, bArr, 604800000L);
            } else {
                this.c.b(str, bArr, 86400000L);
            }
        }
    }

    public void a(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            b();
            this.b.b(str, bArr, 2592000000L);
        }
    }
}
