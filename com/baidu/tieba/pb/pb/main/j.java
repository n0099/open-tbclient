package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes9.dex */
public class j {
    private static j kcW;
    private com.baidu.adp.lib.cache.l<byte[]> kcX = null;
    private com.baidu.adp.lib.cache.l<byte[]> kcY = null;

    public static synchronized j cIJ() {
        j jVar;
        synchronized (j.class) {
            if (kcW == null) {
                kcW = new j();
            }
            jVar = kcW;
        }
        return jVar;
    }

    private j() {
        aIY();
    }

    private void aIY() {
        if (this.kcX == null) {
            this.kcX = com.baidu.tbadk.core.c.a.aUM().wb("tb.pb_mark");
        }
        if (this.kcY == null) {
            this.kcY = com.baidu.tbadk.core.c.a.aUM().wb("tb.pb_normal");
        }
    }

    public void aM(String str, boolean z) {
        if (z) {
            if (this.kcX != null && str != null) {
                this.kcX.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.kcY != null && str != null) {
            this.kcY.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aN(String str, boolean z) {
        l.b<byte[]> bu;
        if (z) {
            if (this.kcX != null && str != null) {
                bu = this.kcX.bu(str);
            }
            bu = null;
        } else {
            if (this.kcY != null && str != null) {
                bu = this.kcY.bu(str);
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
            aIY();
            if (z) {
                this.kcX.set(str, bArr, 604800000L);
            } else {
                this.kcY.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aIY();
            this.kcX.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
