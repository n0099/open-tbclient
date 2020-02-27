package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes9.dex */
public class i {
    private static i iFs;
    private com.baidu.adp.lib.cache.l<byte[]> iFt = null;
    private com.baidu.adp.lib.cache.l<byte[]> iFu = null;

    public static synchronized i cmf() {
        i iVar;
        synchronized (i.class) {
            if (iFs == null) {
                iFs = new i();
            }
            iVar = iFs;
        }
        return iVar;
    }

    private i() {
        auV();
    }

    private void auV() {
        if (this.iFt == null) {
            this.iFt = com.baidu.tbadk.core.c.a.aEz().sP("tb.pb_mark");
        }
        if (this.iFu == null) {
            this.iFu = com.baidu.tbadk.core.c.a.aEz().sP("tb.pb_normal");
        }
    }

    public void ar(String str, boolean z) {
        if (z) {
            if (this.iFt != null && str != null) {
                this.iFt.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.iFu != null && str != null) {
            this.iFu.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] as(String str, boolean z) {
        l.b<byte[]> ad;
        if (z) {
            if (this.iFt != null && str != null) {
                ad = this.iFt.ad(str);
            }
            ad = null;
        } else {
            if (this.iFu != null && str != null) {
                ad = this.iFu.ad(str);
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
            auV();
            if (z) {
                this.iFt.set(str, bArr, 604800000L);
            } else {
                this.iFu.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            auV();
            this.iFt.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
