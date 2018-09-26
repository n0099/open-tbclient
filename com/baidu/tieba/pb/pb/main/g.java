package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes2.dex */
public class g {
    private static g fFK;
    private com.baidu.adp.lib.cache.l<byte[]> fFL = null;
    private com.baidu.adp.lib.cache.l<byte[]> fFM = null;

    public static synchronized g ben() {
        g gVar;
        synchronized (g.class) {
            if (fFK == null) {
                fFK = new g();
            }
            gVar = fFK;
        }
        return gVar;
    }

    private g() {
        auH();
    }

    private void auH() {
        if (this.fFL == null) {
            this.fFL = com.baidu.tbadk.core.c.a.yh().dP("tb.pb_mark");
        }
        if (this.fFM == null) {
            this.fFM = com.baidu.tbadk.core.c.a.yh().dP("tb.pb_normal");
        }
    }

    public void K(String str, boolean z) {
        if (z) {
            if (this.fFL != null && str != null) {
                this.fFL.b(str, new byte[0], 0L);
            }
        } else if (this.fFM != null && str != null) {
            this.fFM.b(str, new byte[0], 0L);
        }
    }

    public byte[] L(String str, boolean z) {
        l.b<byte[]> aF;
        if (z) {
            if (this.fFL != null && str != null) {
                aF = this.fFL.aF(str);
            }
            aF = null;
        } else {
            if (this.fFM != null && str != null) {
                aF = this.fFM.aF(str);
            }
            aF = null;
        }
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            auH();
            if (z) {
                this.fFL.a(str, bArr, 604800000L);
            } else {
                this.fFM.a(str, bArr, 86400000L);
            }
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            auH();
            this.fFL.a(str, bArr, 2592000000L);
        }
    }
}
