package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes16.dex */
public class j {
    private static j klA;
    private com.baidu.adp.lib.cache.l<byte[]> klB = null;
    private com.baidu.adp.lib.cache.l<byte[]> klC = null;

    public static synchronized j cMt() {
        j jVar;
        synchronized (j.class) {
            if (klA == null) {
                klA = new j();
            }
            jVar = klA;
        }
        return jVar;
    }

    private j() {
        aMQ();
    }

    private void aMQ() {
        if (this.klB == null) {
            this.klB = com.baidu.tbadk.core.c.a.aYG().xi("tb.pb_mark");
        }
        if (this.klC == null) {
            this.klC = com.baidu.tbadk.core.c.a.aYG().xi("tb.pb_normal");
        }
    }

    public void aK(String str, boolean z) {
        if (z) {
            if (this.klB != null && str != null) {
                this.klB.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.klC != null && str != null) {
            this.klC.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aL(String str, boolean z) {
        l.b<byte[]> bu;
        if (z) {
            if (this.klB != null && str != null) {
                bu = this.klB.bu(str);
            }
            bu = null;
        } else {
            if (this.klC != null && str != null) {
                bu = this.klC.bu(str);
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
                this.klB.set(str, bArr, 604800000L);
            } else {
                this.klC.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aMQ();
            this.klB.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
