package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes16.dex */
public class j {
    private static j kAS;
    private com.baidu.adp.lib.cache.l<byte[]> kAT = null;
    private com.baidu.adp.lib.cache.l<byte[]> kAU = null;

    public static synchronized j cXh() {
        j jVar;
        synchronized (j.class) {
            if (kAS == null) {
                kAS = new j();
            }
            jVar = kAS;
        }
        return jVar;
    }

    private j() {
        aVq();
    }

    private void aVq() {
        if (this.kAT == null) {
            this.kAT = com.baidu.tbadk.core.c.a.bhb().zw("tb.pb_mark");
        }
        if (this.kAU == null) {
            this.kAU = com.baidu.tbadk.core.c.a.bhb().zw("tb.pb_normal");
        }
    }

    public void aO(String str, boolean z) {
        if (z) {
            if (this.kAT != null && str != null) {
                this.kAT.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.kAU != null && str != null) {
            this.kAU.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aP(String str, boolean z) {
        l.b<byte[]> bz;
        if (z) {
            if (this.kAT != null && str != null) {
                bz = this.kAT.bz(str);
            }
            bz = null;
        } else {
            if (this.kAU != null && str != null) {
                bz = this.kAU.bz(str);
            }
            bz = null;
        }
        if (bz == null || bz.value == null) {
            return null;
        }
        return bz.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            aVq();
            if (z) {
                this.kAT.set(str, bArr, 604800000L);
            } else {
                this.kAU.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aVq();
            this.kAT.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
