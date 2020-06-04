package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes9.dex */
public class j {
    private static j jJn;
    private com.baidu.adp.lib.cache.l<byte[]> jJo = null;
    private com.baidu.adp.lib.cache.l<byte[]> jJp = null;

    public static synchronized j cEs() {
        j jVar;
        synchronized (j.class) {
            if (jJn == null) {
                jJn = new j();
            }
            jVar = jJn;
        }
        return jVar;
    }

    private j() {
        aHS();
    }

    private void aHS() {
        if (this.jJo == null) {
            this.jJo = com.baidu.tbadk.core.c.a.aSS().vL("tb.pb_mark");
        }
        if (this.jJp == null) {
            this.jJp = com.baidu.tbadk.core.c.a.aSS().vL("tb.pb_normal");
        }
    }

    public void aK(String str, boolean z) {
        if (z) {
            if (this.jJo != null && str != null) {
                this.jJo.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.jJp != null && str != null) {
            this.jJp.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aL(String str, boolean z) {
        l.b<byte[]> bt;
        if (z) {
            if (this.jJo != null && str != null) {
                bt = this.jJo.bt(str);
            }
            bt = null;
        } else {
            if (this.jJp != null && str != null) {
                bt = this.jJp.bt(str);
            }
            bt = null;
        }
        if (bt == null || bt.value == null) {
            return null;
        }
        return bt.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            aHS();
            if (z) {
                this.jJo.set(str, bArr, 604800000L);
            } else {
                this.jJp.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aHS();
            this.jJo.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
