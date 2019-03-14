package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes4.dex */
public class g {
    private static g hpE;
    private com.baidu.adp.lib.cache.l<byte[]> hpF = null;
    private com.baidu.adp.lib.cache.l<byte[]> hpG = null;

    public static synchronized g bKB() {
        g gVar;
        synchronized (g.class) {
            if (hpE == null) {
                hpE = new g();
            }
            gVar = hpE;
        }
        return gVar;
    }

    private g() {
        SM();
    }

    private void SM() {
        if (this.hpF == null) {
            this.hpF = com.baidu.tbadk.core.c.a.aaW().lu("tb.pb_mark");
        }
        if (this.hpG == null) {
            this.hpG = com.baidu.tbadk.core.c.a.aaW().lu("tb.pb_normal");
        }
    }

    public void am(String str, boolean z) {
        if (z) {
            if (this.hpF != null && str != null) {
                this.hpF.b(str, new byte[0], 0L);
            }
        } else if (this.hpG != null && str != null) {
            this.hpG.b(str, new byte[0], 0L);
        }
    }

    public byte[] an(String str, boolean z) {
        l.b<byte[]> aF;
        if (z) {
            if (this.hpF != null && str != null) {
                aF = this.hpF.aF(str);
            }
            aF = null;
        } else {
            if (this.hpG != null && str != null) {
                aF = this.hpG.aF(str);
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
            SM();
            if (z) {
                this.hpF.a(str, bArr, 604800000L);
            } else {
                this.hpG.a(str, bArr, 86400000L);
            }
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            SM();
            this.hpF.a(str, bArr, 2592000000L);
        }
    }
}
