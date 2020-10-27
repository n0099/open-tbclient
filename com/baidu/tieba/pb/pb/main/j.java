package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes22.dex */
public class j {
    private static j llg;
    private com.baidu.adp.lib.cache.l<byte[]> llh = null;
    private com.baidu.adp.lib.cache.l<byte[]> lli = null;

    public static synchronized j dhB() {
        j jVar;
        synchronized (j.class) {
            if (llg == null) {
                llg = new j();
            }
            jVar = llg;
        }
        return jVar;
    }

    private j() {
        baD();
    }

    private void baD() {
        if (this.llh == null) {
            this.llh = com.baidu.tbadk.core.c.a.bmx().AX("tb.pb_mark");
        }
        if (this.lli == null) {
            this.lli = com.baidu.tbadk.core.c.a.bmx().AX("tb.pb_normal");
        }
    }

    public void aU(String str, boolean z) {
        if (z) {
            if (this.llh != null && str != null) {
                this.llh.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.lli != null && str != null) {
            this.lli.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] aV(String str, boolean z) {
        l.b<byte[]> bB;
        if (z) {
            if (this.llh != null && str != null) {
                bB = this.llh.bB(str);
            }
            bB = null;
        } else {
            if (this.lli != null && str != null) {
                bB = this.lli.bB(str);
            }
            bB = null;
        }
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            baD();
            if (z) {
                this.llh.set(str, bArr, 604800000L);
            } else {
                this.lli.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            baD();
            this.llh.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
