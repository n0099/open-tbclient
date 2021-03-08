package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes2.dex */
public class i {
    private static i lQZ;
    private com.baidu.adp.lib.cache.l<byte[]> lRa = null;
    private com.baidu.adp.lib.cache.l<byte[]> lRb = null;

    public static synchronized i dnm() {
        i iVar;
        synchronized (i.class) {
            if (lQZ == null) {
                lQZ = new i();
            }
            iVar = lQZ;
        }
        return iVar;
    }

    private i() {
        beu();
    }

    private void beu() {
        if (this.lRa == null) {
            this.lRa = com.baidu.tbadk.core.c.a.bqt().Ay("tb.pb_mark");
        }
        if (this.lRb == null) {
            this.lRb = com.baidu.tbadk.core.c.a.bqt().Ay("tb.pb_normal");
        }
    }

    public void aU(String str, boolean z) {
        if (z) {
            if (this.lRa != null && str != null) {
                this.lRa.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.lRb != null && str != null) {
            this.lRb.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aV(String str, boolean z) {
        l.b<byte[]> bC;
        if (z) {
            if (this.lRa != null && str != null) {
                bC = this.lRa.bC(str);
            }
            bC = null;
        } else {
            if (this.lRb != null && str != null) {
                bC = this.lRb.bC(str);
            }
            bC = null;
        }
        if (bC == null || bC.value == null) {
            return null;
        }
        return bC.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            beu();
            if (z) {
                this.lRa.set(str, bArr, 604800000L);
            } else {
                this.lRb.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            beu();
            this.lRa.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
