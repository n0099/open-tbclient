package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes2.dex */
public class i {
    private static i lFS;
    private com.baidu.adp.lib.cache.l<byte[]> lFT = null;
    private com.baidu.adp.lib.cache.l<byte[]> lFU = null;

    public static synchronized i dkJ() {
        i iVar;
        synchronized (i.class) {
            if (lFS == null) {
                lFS = new i();
            }
            iVar = lFS;
        }
        return iVar;
    }

    private i() {
        bef();
    }

    private void bef() {
        if (this.lFT == null) {
            this.lFT = com.baidu.tbadk.core.c.a.bpZ().Aa("tb.pb_mark");
        }
        if (this.lFU == null) {
            this.lFU = com.baidu.tbadk.core.c.a.bpZ().Aa("tb.pb_normal");
        }
    }

    public void aV(String str, boolean z) {
        if (z) {
            if (this.lFT != null && str != null) {
                this.lFT.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.lFU != null && str != null) {
            this.lFU.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aW(String str, boolean z) {
        l.b<byte[]> by;
        if (z) {
            if (this.lFT != null && str != null) {
                by = this.lFT.by(str);
            }
            by = null;
        } else {
            if (this.lFU != null && str != null) {
                by = this.lFU.by(str);
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
            bef();
            if (z) {
                this.lFT.set(str, bArr, 604800000L);
            } else {
                this.lFU.set(str, bArr, 86400000L);
            }
        }
    }

    public void o(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            bef();
            this.lFT.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
