package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes21.dex */
public class j {
    private static j lrw;
    private com.baidu.adp.lib.cache.l<byte[]> lrx = null;
    private com.baidu.adp.lib.cache.l<byte[]> lry = null;

    public static synchronized j djz() {
        j jVar;
        synchronized (j.class) {
            if (lrw == null) {
                lrw = new j();
            }
            jVar = lrw;
        }
        return jVar;
    }

    private j() {
        bcw();
    }

    private void bcw() {
        if (this.lrx == null) {
            this.lrx = com.baidu.tbadk.core.c.a.bob().AG("tb.pb_mark");
        }
        if (this.lry == null) {
            this.lry = com.baidu.tbadk.core.c.a.bob().AG("tb.pb_normal");
        }
    }

    public void aU(String str, boolean z) {
        if (z) {
            if (this.lrx != null && str != null) {
                this.lrx.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.lry != null && str != null) {
            this.lry.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aV(String str, boolean z) {
        l.b<byte[]> bB;
        if (z) {
            if (this.lrx != null && str != null) {
                bB = this.lrx.bB(str);
            }
            bB = null;
        } else {
            if (this.lry != null && str != null) {
                bB = this.lry.bB(str);
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
            bcw();
            if (z) {
                this.lrx.set(str, bArr, 604800000L);
            } else {
                this.lry.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            bcw();
            this.lrx.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
