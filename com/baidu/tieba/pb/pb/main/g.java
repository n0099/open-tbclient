package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes6.dex */
public class g {
    private static g fNm;
    private com.baidu.adp.lib.cache.l<byte[]> fNn = null;
    private com.baidu.adp.lib.cache.l<byte[]> fNo = null;

    public static synchronized g bhz() {
        g gVar;
        synchronized (g.class) {
            if (fNm == null) {
                fNm = new g();
            }
            gVar = fNm;
        }
        return gVar;
    }

    private g() {
        aye();
    }

    private void aye() {
        if (this.fNn == null) {
            this.fNn = com.baidu.tbadk.core.c.a.Aq().ef("tb.pb_mark");
        }
        if (this.fNo == null) {
            this.fNo = com.baidu.tbadk.core.c.a.Aq().ef("tb.pb_normal");
        }
    }

    public void R(String str, boolean z) {
        if (z) {
            if (this.fNn != null && str != null) {
                this.fNn.b(str, new byte[0], 0L);
            }
        } else if (this.fNo != null && str != null) {
            this.fNo.b(str, new byte[0], 0L);
        }
    }

    public byte[] S(String str, boolean z) {
        l.b<byte[]> aF;
        if (z) {
            if (this.fNn != null && str != null) {
                aF = this.fNn.aF(str);
            }
            aF = null;
        } else {
            if (this.fNo != null && str != null) {
                aF = this.fNo.aF(str);
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
            aye();
            if (z) {
                this.fNn.a(str, bArr, 604800000L);
            } else {
                this.fNo.a(str, bArr, 86400000L);
            }
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aye();
            this.fNn.a(str, bArr, 2592000000L);
        }
    }
}
