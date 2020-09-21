package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes21.dex */
public class j {
    private static j kJw;
    private com.baidu.adp.lib.cache.l<byte[]> kJx = null;
    private com.baidu.adp.lib.cache.l<byte[]> kJy = null;

    public static synchronized j daL() {
        j jVar;
        synchronized (j.class) {
            if (kJw == null) {
                kJw = new j();
            }
            jVar = kJw;
        }
        return jVar;
    }

    private j() {
        aWc();
    }

    private void aWc() {
        if (this.kJx == null) {
            this.kJx = com.baidu.tbadk.core.c.a.bhV().zS("tb.pb_mark");
        }
        if (this.kJy == null) {
            this.kJy = com.baidu.tbadk.core.c.a.bhV().zS("tb.pb_normal");
        }
    }

    public void aO(String str, boolean z) {
        if (z) {
            if (this.kJx != null && str != null) {
                this.kJx.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.kJy != null && str != null) {
            this.kJy.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aP(String str, boolean z) {
        l.b<byte[]> bB;
        if (z) {
            if (this.kJx != null && str != null) {
                bB = this.kJx.bB(str);
            }
            bB = null;
        } else {
            if (this.kJy != null && str != null) {
                bB = this.kJy.bB(str);
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
            aWc();
            if (z) {
                this.kJx.set(str, bArr, 604800000L);
            } else {
                this.kJy.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aWc();
            this.kJx.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
