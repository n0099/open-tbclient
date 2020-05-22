package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes9.dex */
public class j {
    private static j jIh;
    private com.baidu.adp.lib.cache.l<byte[]> jIi = null;
    private com.baidu.adp.lib.cache.l<byte[]> jIj = null;

    public static synchronized j cEc() {
        j jVar;
        synchronized (j.class) {
            if (jIh == null) {
                jIh = new j();
            }
            jVar = jIh;
        }
        return jVar;
    }

    private j() {
        aHS();
    }

    private void aHS() {
        if (this.jIi == null) {
            this.jIi = com.baidu.tbadk.core.c.a.aSS().vL("tb.pb_mark");
        }
        if (this.jIj == null) {
            this.jIj = com.baidu.tbadk.core.c.a.aSS().vL("tb.pb_normal");
        }
    }

    public void aK(String str, boolean z) {
        if (z) {
            if (this.jIi != null && str != null) {
                this.jIi.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.jIj != null && str != null) {
            this.jIj.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aL(String str, boolean z) {
        l.b<byte[]> bt;
        if (z) {
            if (this.jIi != null && str != null) {
                bt = this.jIi.bt(str);
            }
            bt = null;
        } else {
            if (this.jIj != null && str != null) {
                bt = this.jIj.bt(str);
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
                this.jIi.set(str, bArr, 604800000L);
            } else {
                this.jIj.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aHS();
            this.jIi.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
