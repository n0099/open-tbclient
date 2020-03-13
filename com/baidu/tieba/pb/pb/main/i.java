package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes9.dex */
public class i {
    private static i iFG;
    private com.baidu.adp.lib.cache.l<byte[]> iFH = null;
    private com.baidu.adp.lib.cache.l<byte[]> iFI = null;

    public static synchronized i cmi() {
        i iVar;
        synchronized (i.class) {
            if (iFG == null) {
                iFG = new i();
            }
            iVar = iFG;
        }
        return iVar;
    }

    private i() {
        auX();
    }

    private void auX() {
        if (this.iFH == null) {
            this.iFH = com.baidu.tbadk.core.c.a.aEB().sP("tb.pb_mark");
        }
        if (this.iFI == null) {
            this.iFI = com.baidu.tbadk.core.c.a.aEB().sP("tb.pb_normal");
        }
    }

    public void ar(String str, boolean z) {
        if (z) {
            if (this.iFH != null && str != null) {
                this.iFH.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.iFI != null && str != null) {
            this.iFI.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] as(String str, boolean z) {
        l.b<byte[]> ad;
        if (z) {
            if (this.iFH != null && str != null) {
                ad = this.iFH.ad(str);
            }
            ad = null;
        } else {
            if (this.iFI != null && str != null) {
                ad = this.iFI.ad(str);
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
            auX();
            if (z) {
                this.iFH.set(str, bArr, 604800000L);
            } else {
                this.iFI.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            auX();
            this.iFH.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
