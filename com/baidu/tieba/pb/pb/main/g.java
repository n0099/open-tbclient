package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes6.dex */
public class g {
    private static g fVB;
    private com.baidu.adp.lib.cache.l<byte[]> fVC = null;
    private com.baidu.adp.lib.cache.l<byte[]> fVD = null;

    public static synchronized g biO() {
        g gVar;
        synchronized (g.class) {
            if (fVB == null) {
                fVB = new g();
            }
            gVar = fVB;
        }
        return gVar;
    }

    private g() {
        azl();
    }

    private void azl() {
        if (this.fVC == null) {
            this.fVC = com.baidu.tbadk.core.c.a.BB().ex("tb.pb_mark");
        }
        if (this.fVD == null) {
            this.fVD = com.baidu.tbadk.core.c.a.BB().ex("tb.pb_normal");
        }
    }

    public void T(String str, boolean z) {
        if (z) {
            if (this.fVC != null && str != null) {
                this.fVC.b(str, new byte[0], 0L);
            }
        } else if (this.fVD != null && str != null) {
            this.fVD.b(str, new byte[0], 0L);
        }
    }

    public byte[] U(String str, boolean z) {
        l.b<byte[]> aF;
        if (z) {
            if (this.fVC != null && str != null) {
                aF = this.fVC.aF(str);
            }
            aF = null;
        } else {
            if (this.fVD != null && str != null) {
                aF = this.fVD.aF(str);
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
            azl();
            if (z) {
                this.fVC.a(str, bArr, 604800000L);
            } else {
                this.fVD.a(str, bArr, 86400000L);
            }
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            azl();
            this.fVC.a(str, bArr, 2592000000L);
        }
    }
}
