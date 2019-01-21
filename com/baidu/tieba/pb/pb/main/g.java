package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes6.dex */
public class g {
    private static g fZr;
    private com.baidu.adp.lib.cache.l<byte[]> fZs = null;
    private com.baidu.adp.lib.cache.l<byte[]> fZt = null;

    public static synchronized g bkd() {
        g gVar;
        synchronized (g.class) {
            if (fZr == null) {
                fZr = new g();
            }
            gVar = fZr;
        }
        return gVar;
    }

    private g() {
        aAx();
    }

    private void aAx() {
        if (this.fZs == null) {
            this.fZs = com.baidu.tbadk.core.c.a.BO().eG("tb.pb_mark");
        }
        if (this.fZt == null) {
            this.fZt = com.baidu.tbadk.core.c.a.BO().eG("tb.pb_normal");
        }
    }

    public void S(String str, boolean z) {
        if (z) {
            if (this.fZs != null && str != null) {
                this.fZs.b(str, new byte[0], 0L);
            }
        } else if (this.fZt != null && str != null) {
            this.fZt.b(str, new byte[0], 0L);
        }
    }

    public byte[] T(String str, boolean z) {
        l.b<byte[]> aF;
        if (z) {
            if (this.fZs != null && str != null) {
                aF = this.fZs.aF(str);
            }
            aF = null;
        } else {
            if (this.fZt != null && str != null) {
                aF = this.fZt.aF(str);
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
            aAx();
            if (z) {
                this.fZs.a(str, bArr, 604800000L);
            } else {
                this.fZt.a(str, bArr, 86400000L);
            }
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aAx();
            this.fZs.a(str, bArr, 2592000000L);
        }
    }
}
