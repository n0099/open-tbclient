package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes2.dex */
public class i {
    private static i lKw;
    private com.baidu.adp.lib.cache.l<byte[]> lKx = null;
    private com.baidu.adp.lib.cache.l<byte[]> lKy = null;

    public static synchronized i doC() {
        i iVar;
        synchronized (i.class) {
            if (lKw == null) {
                lKw = new i();
            }
            iVar = lKw;
        }
        return iVar;
    }

    private i() {
        bhZ();
    }

    private void bhZ() {
        if (this.lKx == null) {
            this.lKx = com.baidu.tbadk.core.c.a.btT().Bl("tb.pb_mark");
        }
        if (this.lKy == null) {
            this.lKy = com.baidu.tbadk.core.c.a.btT().Bl("tb.pb_normal");
        }
    }

    public void aV(String str, boolean z) {
        if (z) {
            if (this.lKx != null && str != null) {
                this.lKx.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.lKy != null && str != null) {
            this.lKy.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aW(String str, boolean z) {
        l.b<byte[]> by;
        if (z) {
            if (this.lKx != null && str != null) {
                by = this.lKx.by(str);
            }
            by = null;
        } else {
            if (this.lKy != null && str != null) {
                by = this.lKy.by(str);
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
            bhZ();
            if (z) {
                this.lKx.set(str, bArr, 604800000L);
            } else {
                this.lKy.set(str, bArr, 86400000L);
            }
        }
    }

    public void o(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            bhZ();
            this.lKx.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
