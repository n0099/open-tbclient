package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes9.dex */
public class i {
    private static i iFu;
    private com.baidu.adp.lib.cache.l<byte[]> iFv = null;
    private com.baidu.adp.lib.cache.l<byte[]> iFw = null;

    public static synchronized i cmh() {
        i iVar;
        synchronized (i.class) {
            if (iFu == null) {
                iFu = new i();
            }
            iVar = iFu;
        }
        return iVar;
    }

    private i() {
        auX();
    }

    private void auX() {
        if (this.iFv == null) {
            this.iFv = com.baidu.tbadk.core.c.a.aEB().sP("tb.pb_mark");
        }
        if (this.iFw == null) {
            this.iFw = com.baidu.tbadk.core.c.a.aEB().sP("tb.pb_normal");
        }
    }

    public void ar(String str, boolean z) {
        if (z) {
            if (this.iFv != null && str != null) {
                this.iFv.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.iFw != null && str != null) {
            this.iFw.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] as(String str, boolean z) {
        l.b<byte[]> ad;
        if (z) {
            if (this.iFv != null && str != null) {
                ad = this.iFv.ad(str);
            }
            ad = null;
        } else {
            if (this.iFw != null && str != null) {
                ad = this.iFw.ad(str);
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
                this.iFv.set(str, bArr, 604800000L);
            } else {
                this.iFw.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            auX();
            this.iFv.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
