package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes2.dex */
public class i {
    private static i lOX;
    private com.baidu.adp.lib.cache.l<byte[]> lOY = null;
    private com.baidu.adp.lib.cache.l<byte[]> lOZ = null;

    public static synchronized i dnd() {
        i iVar;
        synchronized (i.class) {
            if (lOX == null) {
                lOX = new i();
            }
            iVar = lOX;
        }
        return iVar;
    }

    private i() {
        bes();
    }

    private void bes() {
        if (this.lOY == null) {
            this.lOY = com.baidu.tbadk.core.c.a.bqr().Ar("tb.pb_mark");
        }
        if (this.lOZ == null) {
            this.lOZ = com.baidu.tbadk.core.c.a.bqr().Ar("tb.pb_normal");
        }
    }

    public void aU(String str, boolean z) {
        if (z) {
            if (this.lOY != null && str != null) {
                this.lOY.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.lOZ != null && str != null) {
            this.lOZ.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aV(String str, boolean z) {
        l.b<byte[]> by;
        if (z) {
            if (this.lOY != null && str != null) {
                by = this.lOY.by(str);
            }
            by = null;
        } else {
            if (this.lOZ != null && str != null) {
                by = this.lOZ.by(str);
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
            bes();
            if (z) {
                this.lOY.set(str, bArr, 604800000L);
            } else {
                this.lOZ.set(str, bArr, 86400000L);
            }
        }
    }

    public void o(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            bes();
            this.lOY.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
