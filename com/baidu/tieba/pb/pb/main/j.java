package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes22.dex */
public class j {
    private static j kYH;
    private com.baidu.adp.lib.cache.l<byte[]> kYI = null;
    private com.baidu.adp.lib.cache.l<byte[]> kYJ = null;

    public static synchronized j deu() {
        j jVar;
        synchronized (j.class) {
            if (kYH == null) {
                kYH = new j();
            }
            jVar = kYH;
        }
        return jVar;
    }

    private j() {
        aYK();
    }

    private void aYK() {
        if (this.kYI == null) {
            this.kYI = com.baidu.tbadk.core.c.a.bkE().AE("tb.pb_mark");
        }
        if (this.kYJ == null) {
            this.kYJ = com.baidu.tbadk.core.c.a.bkE().AE("tb.pb_normal");
        }
    }

    public void aS(String str, boolean z) {
        if (z) {
            if (this.kYI != null && str != null) {
                this.kYI.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.kYJ != null && str != null) {
            this.kYJ.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aT(String str, boolean z) {
        l.b<byte[]> bB;
        if (z) {
            if (this.kYI != null && str != null) {
                bB = this.kYI.bB(str);
            }
            bB = null;
        } else {
            if (this.kYJ != null && str != null) {
                bB = this.kYJ.bB(str);
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
            aYK();
            if (z) {
                this.kYI.set(str, bArr, 604800000L);
            } else {
                this.kYJ.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aYK();
            this.kYI.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
