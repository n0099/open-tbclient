package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes22.dex */
public class j {
    private static j lFh;
    private com.baidu.adp.lib.cache.l<byte[]> lFi = null;
    private com.baidu.adp.lib.cache.l<byte[]> lFj = null;

    public static synchronized j doP() {
        j jVar;
        synchronized (j.class) {
            if (lFh == null) {
                lFh = new j();
            }
            jVar = lFh;
        }
        return jVar;
    }

    private j() {
        bfB();
    }

    private void bfB() {
        if (this.lFi == null) {
            this.lFi = com.baidu.tbadk.core.c.a.brq().Bn("tb.pb_mark");
        }
        if (this.lFj == null) {
            this.lFj = com.baidu.tbadk.core.c.a.brq().Bn("tb.pb_normal");
        }
    }

    public void aV(String str, boolean z) {
        if (z) {
            if (this.lFi != null && str != null) {
                this.lFi.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.lFj != null && str != null) {
            this.lFj.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aW(String str, boolean z) {
        l.b<byte[]> bE;
        if (z) {
            if (this.lFi != null && str != null) {
                bE = this.lFi.bE(str);
            }
            bE = null;
        } else {
            if (this.lFj != null && str != null) {
                bE = this.lFj.bE(str);
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
                this.lFi.set(str, bArr, 604800000L);
            } else {
                this.lFj.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            bfB();
            this.lFi.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
