package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes4.dex */
public class g {
    private static g hNl;
    private com.baidu.adp.lib.cache.l<byte[]> hNm = null;
    private com.baidu.adp.lib.cache.l<byte[]> hNn = null;

    public static synchronized g bVf() {
        g gVar;
        synchronized (g.class) {
            if (hNl == null) {
                hNl = new g();
            }
            gVar = hNl;
        }
        return gVar;
    }

    private g() {
        Xr();
    }

    private void Xr() {
        if (this.hNm == null) {
            this.hNm = com.baidu.tbadk.core.d.a.agF().mK("tb.pb_mark");
        }
        if (this.hNn == null) {
            this.hNn = com.baidu.tbadk.core.d.a.agF().mK("tb.pb_normal");
        }
    }

    public void as(String str, boolean z) {
        if (z) {
            if (this.hNm != null && str != null) {
                this.hNm.b(str, new byte[0], 0L);
            }
        } else if (this.hNn != null && str != null) {
            this.hNn.b(str, new byte[0], 0L);
        }
    }

    public byte[] at(String str, boolean z) {
        l.b<byte[]> aq;
        if (z) {
            if (this.hNm != null && str != null) {
                aq = this.hNm.aq(str);
            }
            aq = null;
        } else {
            if (this.hNn != null && str != null) {
                aq = this.hNn.aq(str);
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
                this.hNm.a(str, bArr, 604800000L);
            } else {
                this.hNn.a(str, bArr, 86400000L);
            }
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            Xr();
            this.hNm.a(str, bArr, 2592000000L);
        }
    }
}
