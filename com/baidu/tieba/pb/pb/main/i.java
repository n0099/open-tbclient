package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes7.dex */
public class i {
    private static i iDL;
    private com.baidu.adp.lib.cache.l<byte[]> iDM = null;
    private com.baidu.adp.lib.cache.l<byte[]> iDN = null;

    public static synchronized i ckK() {
        i iVar;
        synchronized (i.class) {
            if (iDL == null) {
                iDL = new i();
            }
            iVar = iDL;
        }
        return iVar;
    }

    private i() {
        asH();
    }

    private void asH() {
        if (this.iDM == null) {
            this.iDM = com.baidu.tbadk.core.c.a.aCo().sz("tb.pb_mark");
        }
        if (this.iDN == null) {
            this.iDN = com.baidu.tbadk.core.c.a.aCo().sz("tb.pb_normal");
        }
    }

    public void ar(String str, boolean z) {
        if (z) {
            if (this.iDM != null && str != null) {
                this.iDM.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.iDN != null && str != null) {
            this.iDN.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] as(String str, boolean z) {
        l.b<byte[]> ad;
        if (z) {
            if (this.iDM != null && str != null) {
                ad = this.iDM.ad(str);
            }
            ad = null;
        } else {
            if (this.iDN != null && str != null) {
                ad = this.iDN.ad(str);
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
            asH();
            if (z) {
                this.iDM.set(str, bArr, 604800000L);
            } else {
                this.iDN.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            asH();
            this.iDM.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
