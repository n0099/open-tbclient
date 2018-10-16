package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes6.dex */
public class g {
    private static g fNl;
    private com.baidu.adp.lib.cache.l<byte[]> fNm = null;
    private com.baidu.adp.lib.cache.l<byte[]> fNn = null;

    public static synchronized g bhz() {
        g gVar;
        synchronized (g.class) {
            if (fNl == null) {
                fNl = new g();
            }
            gVar = fNl;
        }
        return gVar;
    }

    private g() {
        ayd();
    }

    private void ayd() {
        if (this.fNm == null) {
            this.fNm = com.baidu.tbadk.core.c.a.Aq().ef("tb.pb_mark");
        }
        if (this.fNn == null) {
            this.fNn = com.baidu.tbadk.core.c.a.Aq().ef("tb.pb_normal");
        }
    }

    public void R(String str, boolean z) {
        if (z) {
            if (this.fNm != null && str != null) {
                this.fNm.b(str, new byte[0], 0L);
            }
        } else if (this.fNn != null && str != null) {
            this.fNn.b(str, new byte[0], 0L);
        }
    }

    public byte[] S(String str, boolean z) {
        l.b<byte[]> aF;
        if (z) {
            if (this.fNm != null && str != null) {
                aF = this.fNm.aF(str);
            }
            aF = null;
        } else {
            if (this.fNn != null && str != null) {
                aF = this.fNn.aF(str);
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
            ayd();
            if (z) {
                this.fNm.a(str, bArr, 604800000L);
            } else {
                this.fNn.a(str, bArr, 86400000L);
            }
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            ayd();
            this.fNm.a(str, bArr, 2592000000L);
        }
    }
}
