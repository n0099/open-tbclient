package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes16.dex */
public class j {
    private static j kAZ;
    private com.baidu.adp.lib.cache.l<byte[]> kBa = null;
    private com.baidu.adp.lib.cache.l<byte[]> kBb = null;

    public static synchronized j cXi() {
        j jVar;
        synchronized (j.class) {
            if (kAZ == null) {
                kAZ = new j();
            }
            jVar = kAZ;
        }
        return jVar;
    }

    private j() {
        aVq();
    }

    private void aVq() {
        if (this.kBa == null) {
            this.kBa = com.baidu.tbadk.core.c.a.bhb().zx("tb.pb_mark");
        }
        if (this.kBb == null) {
            this.kBb = com.baidu.tbadk.core.c.a.bhb().zx("tb.pb_normal");
        }
    }

    public void aO(String str, boolean z) {
        if (z) {
            if (this.kBa != null && str != null) {
                this.kBa.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.kBb != null && str != null) {
            this.kBb.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aP(String str, boolean z) {
        l.b<byte[]> bz;
        if (z) {
            if (this.kBa != null && str != null) {
                bz = this.kBa.bz(str);
            }
            bz = null;
        } else {
            if (this.kBb != null && str != null) {
                bz = this.kBb.bz(str);
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
                this.kBa.set(str, bArr, 604800000L);
            } else {
                this.kBb.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aVq();
            this.kBa.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
