package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes22.dex */
public class j {
    private static j lrh;
    private com.baidu.adp.lib.cache.l<byte[]> lri = null;
    private com.baidu.adp.lib.cache.l<byte[]> lrj = null;

    public static synchronized j dkd() {
        j jVar;
        synchronized (j.class) {
            if (lrh == null) {
                lrh = new j();
            }
            jVar = lrh;
        }
        return jVar;
    }

    private j() {
        bdd();
    }

    private void bdd() {
        if (this.lri == null) {
            this.lri = com.baidu.tbadk.core.c.a.boX().Bl("tb.pb_mark");
        }
        if (this.lrj == null) {
            this.lrj = com.baidu.tbadk.core.c.a.boX().Bl("tb.pb_normal");
        }
    }

    public void aU(String str, boolean z) {
        if (z) {
            if (this.lri != null && str != null) {
                this.lri.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.lrj != null && str != null) {
            this.lrj.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aV(String str, boolean z) {
        l.b<byte[]> bB;
        if (z) {
            if (this.lri != null && str != null) {
                bB = this.lri.bB(str);
            }
            bB = null;
        } else {
            if (this.lrj != null && str != null) {
                bB = this.lrj.bB(str);
            }
            bB = null;
        }
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            bdd();
            if (z) {
                this.lri.set(str, bArr, 604800000L);
            } else {
                this.lrj.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            bdd();
            this.lri.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
