package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes4.dex */
public class g {
    private static g hOf;
    private com.baidu.adp.lib.cache.l<byte[]> hOg = null;
    private com.baidu.adp.lib.cache.l<byte[]> hOh = null;

    public static synchronized g bVv() {
        g gVar;
        synchronized (g.class) {
            if (hOf == null) {
                hOf = new g();
            }
            gVar = hOf;
        }
        return gVar;
    }

    private g() {
        Xr();
    }

    private void Xr() {
        if (this.hOg == null) {
            this.hOg = com.baidu.tbadk.core.d.a.agH().mK("tb.pb_mark");
        }
        if (this.hOh == null) {
            this.hOh = com.baidu.tbadk.core.d.a.agH().mK("tb.pb_normal");
        }
    }

    public void as(String str, boolean z) {
        if (z) {
            if (this.hOg != null && str != null) {
                this.hOg.b(str, new byte[0], 0L);
            }
        } else if (this.hOh != null && str != null) {
            this.hOh.b(str, new byte[0], 0L);
        }
    }

    public byte[] at(String str, boolean z) {
        l.b<byte[]> aq;
        if (z) {
            if (this.hOg != null && str != null) {
                aq = this.hOg.aq(str);
            }
            aq = null;
        } else {
            if (this.hOh != null && str != null) {
                aq = this.hOh.aq(str);
            }
            aq = null;
        }
        if (aq == null || aq.value == null) {
            return null;
        }
        return aq.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            Xr();
            if (z) {
                this.hOg.a(str, bArr, 604800000L);
            } else {
                this.hOh.a(str, bArr, 86400000L);
            }
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            Xr();
            this.hOg.a(str, bArr, 2592000000L);
        }
    }
}
