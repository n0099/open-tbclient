package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes6.dex */
public class g {
    private static g fYt;
    private com.baidu.adp.lib.cache.l<byte[]> fYu = null;
    private com.baidu.adp.lib.cache.l<byte[]> fYv = null;

    public static synchronized g bjz() {
        g gVar;
        synchronized (g.class) {
            if (fYt == null) {
                fYt = new g();
            }
            gVar = fYt;
        }
        return gVar;
    }

    private g() {
        aAa();
    }

    private void aAa() {
        if (this.fYu == null) {
            this.fYu = com.baidu.tbadk.core.c.a.BB().ex("tb.pb_mark");
        }
        if (this.fYv == null) {
            this.fYv = com.baidu.tbadk.core.c.a.BB().ex("tb.pb_normal");
        }
    }

    public void T(String str, boolean z) {
        if (z) {
            if (this.fYu != null && str != null) {
                this.fYu.b(str, new byte[0], 0L);
            }
        } else if (this.fYv != null && str != null) {
            this.fYv.b(str, new byte[0], 0L);
        }
    }

    public byte[] U(String str, boolean z) {
        l.b<byte[]> aF;
        if (z) {
            if (this.fYu != null && str != null) {
                aF = this.fYu.aF(str);
            }
            aF = null;
        } else {
            if (this.fYv != null && str != null) {
                aF = this.fYv.aF(str);
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
            aAa();
            if (z) {
                this.fYu.a(str, bArr, 604800000L);
            } else {
                this.fYv.a(str, bArr, 86400000L);
            }
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aAa();
            this.fYu.a(str, bArr, 2592000000L);
        }
    }
}
