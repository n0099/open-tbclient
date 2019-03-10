package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class g {
    private static g hpL;
    private com.baidu.adp.lib.cache.l<byte[]> hpM = null;
    private com.baidu.adp.lib.cache.l<byte[]> hpN = null;

    public static synchronized g bKC() {
        g gVar;
        synchronized (g.class) {
            if (hpL == null) {
                hpL = new g();
            }
            gVar = hpL;
        }
        return gVar;
    }

    private g() {
        SM();
    }

    private void SM() {
        if (this.hpM == null) {
            this.hpM = com.baidu.tbadk.core.c.a.aaW().lu("tb.pb_mark");
        }
        if (this.hpN == null) {
            this.hpN = com.baidu.tbadk.core.c.a.aaW().lu("tb.pb_normal");
        }
    }

    public void am(String str, boolean z) {
        if (z) {
            if (this.hpM != null && str != null) {
                this.hpM.b(str, new byte[0], 0L);
            }
        } else if (this.hpN != null && str != null) {
            this.hpN.b(str, new byte[0], 0L);
        }
    }

    public byte[] an(String str, boolean z) {
        l.b<byte[]> aF;
        if (z) {
            if (this.hpM != null && str != null) {
                aF = this.hpM.aF(str);
            }
            aF = null;
        } else {
            if (this.hpN != null && str != null) {
                aF = this.hpN.aF(str);
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
                this.hpM.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.hpN.a(str, bArr, 86400000L);
            }
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            SM();
            this.hpM.a(str, bArr, 2592000000L);
        }
    }
}
