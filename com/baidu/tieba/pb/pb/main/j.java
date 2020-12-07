package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes22.dex */
public class j {
    private static j lFf;
    private com.baidu.adp.lib.cache.l<byte[]> lFg = null;
    private com.baidu.adp.lib.cache.l<byte[]> lFh = null;

    public static synchronized j doO() {
        j jVar;
        synchronized (j.class) {
            if (lFf == null) {
                lFf = new j();
            }
            jVar = lFf;
        }
        return jVar;
    }

    private j() {
        bfB();
    }

    private void bfB() {
        if (this.lFg == null) {
            this.lFg = com.baidu.tbadk.core.c.a.brq().Bn("tb.pb_mark");
        }
        if (this.lFh == null) {
            this.lFh = com.baidu.tbadk.core.c.a.brq().Bn("tb.pb_normal");
        }
    }

    public void aV(String str, boolean z) {
        if (z) {
            if (this.lFg != null && str != null) {
                this.lFg.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.lFh != null && str != null) {
            this.lFh.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aW(String str, boolean z) {
        l.b<byte[]> bE;
        if (z) {
            if (this.lFg != null && str != null) {
                bE = this.lFg.bE(str);
            }
            bE = null;
        } else {
            if (this.lFh != null && str != null) {
                bE = this.lFh.bE(str);
            }
            bE = null;
        }
        if (bE == null || bE.value == null) {
            return null;
        }
        return bE.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            bfB();
            if (z) {
                this.lFg.set(str, bArr, 604800000L);
            } else {
                this.lFh.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            bfB();
            this.lFg.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
