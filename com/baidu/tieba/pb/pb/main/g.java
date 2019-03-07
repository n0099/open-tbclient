package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class g {
    private static g hpK;
    private com.baidu.adp.lib.cache.l<byte[]> hpL = null;
    private com.baidu.adp.lib.cache.l<byte[]> hpM = null;

    public static synchronized g bKB() {
        g gVar;
        synchronized (g.class) {
            if (hpK == null) {
                hpK = new g();
            }
            gVar = hpK;
        }
        return gVar;
    }

    private g() {
        SM();
    }

    private void SM() {
        if (this.hpL == null) {
            this.hpL = com.baidu.tbadk.core.c.a.aaW().lu("tb.pb_mark");
        }
        if (this.hpM == null) {
            this.hpM = com.baidu.tbadk.core.c.a.aaW().lu("tb.pb_normal");
        }
    }

    public void al(String str, boolean z) {
        if (z) {
            if (this.hpL != null && str != null) {
                this.hpL.b(str, new byte[0], 0L);
            }
        } else if (this.hpM != null && str != null) {
            this.hpM.b(str, new byte[0], 0L);
        }
    }

    public byte[] am(String str, boolean z) {
        l.b<byte[]> aF;
        if (z) {
            if (this.hpL != null && str != null) {
                aF = this.hpL.aF(str);
            }
            aF = null;
        } else {
            if (this.hpM != null && str != null) {
                aF = this.hpM.aF(str);
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
                this.hpL.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.hpM.a(str, bArr, 86400000L);
            }
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            SM();
            this.hpL.a(str, bArr, 2592000000L);
        }
    }
}
