package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes4.dex */
public class g {
    private static g hQc;
    private com.baidu.adp.lib.cache.l<byte[]> hQd = null;
    private com.baidu.adp.lib.cache.l<byte[]> hQe = null;

    public static synchronized g bWi() {
        g gVar;
        synchronized (g.class) {
            if (hQc == null) {
                hQc = new g();
            }
            gVar = hQc;
        }
        return gVar;
    }

    private g() {
        Xv();
    }

    private void Xv() {
        if (this.hQd == null) {
            this.hQd = com.baidu.tbadk.core.d.a.agL().mM("tb.pb_mark");
        }
        if (this.hQe == null) {
            this.hQe = com.baidu.tbadk.core.d.a.agL().mM("tb.pb_normal");
        }
    }

    public void as(String str, boolean z) {
        if (z) {
            if (this.hQd != null && str != null) {
                this.hQd.b(str, new byte[0], 0L);
            }
        } else if (this.hQe != null && str != null) {
            this.hQe.b(str, new byte[0], 0L);
        }
    }

    public byte[] at(String str, boolean z) {
        l.b<byte[]> aq;
        if (z) {
            if (this.hQd != null && str != null) {
                aq = this.hQd.aq(str);
            }
            aq = null;
        } else {
            if (this.hQe != null && str != null) {
                aq = this.hQe.aq(str);
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
            Xv();
            if (z) {
                this.hQd.a(str, bArr, 604800000L);
            } else {
                this.hQe.a(str, bArr, 86400000L);
            }
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            Xv();
            this.hQd.a(str, bArr, 2592000000L);
        }
    }
}
