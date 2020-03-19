package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes9.dex */
public class i {
    private static i iHh;
    private com.baidu.adp.lib.cache.l<byte[]> iHi = null;
    private com.baidu.adp.lib.cache.l<byte[]> iHj = null;

    public static synchronized i cmD() {
        i iVar;
        synchronized (i.class) {
            if (iHh == null) {
                iHh = new i();
            }
            iVar = iHh;
        }
        return iVar;
    }

    private i() {
        ava();
    }

    private void ava() {
        if (this.iHi == null) {
            this.iHi = com.baidu.tbadk.core.c.a.aEF().sP("tb.pb_mark");
        }
        if (this.iHj == null) {
            this.iHj = com.baidu.tbadk.core.c.a.aEF().sP("tb.pb_normal");
        }
    }

    public void ar(String str, boolean z) {
        if (z) {
            if (this.iHi != null && str != null) {
                this.iHi.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.iHj != null && str != null) {
            this.iHj.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] as(String str, boolean z) {
        l.b<byte[]> ad;
        if (z) {
            if (this.iHi != null && str != null) {
                ad = this.iHi.ad(str);
            }
            ad = null;
        } else {
            if (this.iHj != null && str != null) {
                ad = this.iHj.ad(str);
            }
            ad = null;
        }
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            ava();
            if (z) {
                this.iHi.set(str, bArr, 604800000L);
            } else {
                this.iHj.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            ava();
            this.iHi.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
