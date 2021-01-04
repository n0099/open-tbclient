package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes2.dex */
public class i {
    private static i lKx;
    private com.baidu.adp.lib.cache.l<byte[]> lKy = null;
    private com.baidu.adp.lib.cache.l<byte[]> lKz = null;

    public static synchronized i doB() {
        i iVar;
        synchronized (i.class) {
            if (lKx == null) {
                lKx = new i();
            }
            iVar = lKx;
        }
        return iVar;
    }

    private i() {
        bhY();
    }

    private void bhY() {
        if (this.lKy == null) {
            this.lKy = com.baidu.tbadk.core.c.a.btS().Bm("tb.pb_mark");
        }
        if (this.lKz == null) {
            this.lKz = com.baidu.tbadk.core.c.a.btS().Bm("tb.pb_normal");
        }
    }

    public void aV(String str, boolean z) {
        if (z) {
            if (this.lKy != null && str != null) {
                this.lKy.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.lKz != null && str != null) {
            this.lKz.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aW(String str, boolean z) {
        l.b<byte[]> by;
        if (z) {
            if (this.lKy != null && str != null) {
                by = this.lKy.by(str);
            }
            by = null;
        } else {
            if (this.lKz != null && str != null) {
                by = this.lKz.by(str);
            }
            by = null;
        }
        if (by == null || by.value == null) {
            return null;
        }
        return by.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            bhY();
            if (z) {
                this.lKy.set(str, bArr, 604800000L);
            } else {
                this.lKz.set(str, bArr, 86400000L);
            }
        }
    }

    public void o(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            bhY();
            this.lKy.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
