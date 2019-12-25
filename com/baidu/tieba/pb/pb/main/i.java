package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes6.dex */
public class i {
    private static i iAh;
    private com.baidu.adp.lib.cache.l<byte[]> iAi = null;
    private com.baidu.adp.lib.cache.l<byte[]> iAj = null;

    public static synchronized i cjC() {
        i iVar;
        synchronized (i.class) {
            if (iAh == null) {
                iAh = new i();
            }
            iVar = iAh;
        }
        return iVar;
    }

    private i() {
        aso();
    }

    private void aso() {
        if (this.iAi == null) {
            this.iAi = com.baidu.tbadk.core.c.a.aBV().sw("tb.pb_mark");
        }
        if (this.iAj == null) {
            this.iAj = com.baidu.tbadk.core.c.a.aBV().sw("tb.pb_normal");
        }
    }

    public void ar(String str, boolean z) {
        if (z) {
            if (this.iAi != null && str != null) {
                this.iAi.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.iAj != null && str != null) {
            this.iAj.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] as(String str, boolean z) {
        l.b<byte[]> ad;
        if (z) {
            if (this.iAi != null && str != null) {
                ad = this.iAi.ad(str);
            }
            ad = null;
        } else {
            if (this.iAj != null && str != null) {
                ad = this.iAj.ad(str);
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
            aso();
            if (z) {
                this.iAi.set(str, bArr, 604800000L);
            } else {
                this.iAj.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aso();
            this.iAi.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
