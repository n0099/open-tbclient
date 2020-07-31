package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes16.dex */
public class j {
    private static j kly;
    private com.baidu.adp.lib.cache.l<byte[]> klz = null;
    private com.baidu.adp.lib.cache.l<byte[]> klA = null;

    public static synchronized j cMt() {
        j jVar;
        synchronized (j.class) {
            if (kly == null) {
                kly = new j();
            }
            jVar = kly;
        }
        return jVar;
    }

    private j() {
        aMQ();
    }

    private void aMQ() {
        if (this.klz == null) {
            this.klz = com.baidu.tbadk.core.c.a.aYG().xi("tb.pb_mark");
        }
        if (this.klA == null) {
            this.klA = com.baidu.tbadk.core.c.a.aYG().xi("tb.pb_normal");
        }
    }

    public void aK(String str, boolean z) {
        if (z) {
            if (this.klz != null && str != null) {
                this.klz.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.klA != null && str != null) {
            this.klA.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aL(String str, boolean z) {
        l.b<byte[]> bu;
        if (z) {
            if (this.klz != null && str != null) {
                bu = this.klz.bu(str);
            }
            bu = null;
        } else {
            if (this.klA != null && str != null) {
                bu = this.klA.bu(str);
            }
            bu = null;
        }
        if (bu == null || bu.value == null) {
            return null;
        }
        return bu.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            aMQ();
            if (z) {
                this.klz.set(str, bArr, 604800000L);
            } else {
                this.klA.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aMQ();
            this.klz.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
