package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes6.dex */
public class g {
    private static g fOL;
    private com.baidu.adp.lib.cache.l<byte[]> fOM = null;
    private com.baidu.adp.lib.cache.l<byte[]> fON = null;

    public static synchronized g bgW() {
        g gVar;
        synchronized (g.class) {
            if (fOL == null) {
                fOL = new g();
            }
            gVar = fOL;
        }
        return gVar;
    }

    private g() {
        axB();
    }

    private void axB() {
        if (this.fOM == null) {
            this.fOM = com.baidu.tbadk.core.c.a.Ax().ef("tb.pb_mark");
        }
        if (this.fON == null) {
            this.fON = com.baidu.tbadk.core.c.a.Ax().ef("tb.pb_normal");
        }
    }

    public void R(String str, boolean z) {
        if (z) {
            if (this.fOM != null && str != null) {
                this.fOM.b(str, new byte[0], 0L);
            }
        } else if (this.fON != null && str != null) {
            this.fON.b(str, new byte[0], 0L);
        }
    }

    public byte[] S(String str, boolean z) {
        l.b<byte[]> aF;
        if (z) {
            if (this.fOM != null && str != null) {
                aF = this.fOM.aF(str);
            }
            aF = null;
        } else {
            if (this.fON != null && str != null) {
                aF = this.fON.aF(str);
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
            axB();
            if (z) {
                this.fOM.a(str, bArr, 604800000L);
            } else {
                this.fON.a(str, bArr, 86400000L);
            }
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            axB();
            this.fOM.a(str, bArr, 2592000000L);
        }
    }
}
