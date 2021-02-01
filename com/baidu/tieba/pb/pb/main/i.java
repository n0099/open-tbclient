package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes2.dex */
public class i {
    private static i lOI;
    private com.baidu.adp.lib.cache.l<byte[]> lOJ = null;
    private com.baidu.adp.lib.cache.l<byte[]> lOK = null;

    public static synchronized i dmW() {
        i iVar;
        synchronized (i.class) {
            if (lOI == null) {
                lOI = new i();
            }
            iVar = lOI;
        }
        return iVar;
    }

    private i() {
        bes();
    }

    private void bes() {
        if (this.lOJ == null) {
            this.lOJ = com.baidu.tbadk.core.c.a.bqr().Ar("tb.pb_mark");
        }
        if (this.lOK == null) {
            this.lOK = com.baidu.tbadk.core.c.a.bqr().Ar("tb.pb_normal");
        }
    }

    public void aU(String str, boolean z) {
        if (z) {
            if (this.lOJ != null && str != null) {
                this.lOJ.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.lOK != null && str != null) {
            this.lOK.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aV(String str, boolean z) {
        l.b<byte[]> by;
        if (z) {
            if (this.lOJ != null && str != null) {
                by = this.lOJ.by(str);
            }
            by = null;
        } else {
            if (this.lOK != null && str != null) {
                by = this.lOK.by(str);
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
                this.lOJ.set(str, bArr, 604800000L);
            } else {
                this.lOK.set(str, bArr, 86400000L);
            }
        }
    }

    public void o(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            bes();
            this.lOJ.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
