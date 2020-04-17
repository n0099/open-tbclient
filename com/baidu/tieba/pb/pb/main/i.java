package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes9.dex */
public class i {
    private static i jro;
    private com.baidu.adp.lib.cache.l<byte[]> jrp = null;
    private com.baidu.adp.lib.cache.l<byte[]> jrq = null;

    public static synchronized i cxj() {
        i iVar;
        synchronized (i.class) {
            if (jro == null) {
                jro = new i();
            }
            iVar = jro;
        }
        return iVar;
    }

    private i() {
        aDl();
    }

    private void aDl() {
        if (this.jrp == null) {
            this.jrp = com.baidu.tbadk.core.c.a.aMT().uc("tb.pb_mark");
        }
        if (this.jrq == null) {
            this.jrq = com.baidu.tbadk.core.c.a.aMT().uc("tb.pb_normal");
        }
    }

    public void ax(String str, boolean z) {
        if (z) {
            if (this.jrp != null && str != null) {
                this.jrp.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.jrq != null && str != null) {
            this.jrq.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] ay(String str, boolean z) {
        l.b<byte[]> bs;
        if (z) {
            if (this.jrp != null && str != null) {
                bs = this.jrp.bs(str);
            }
            bs = null;
        } else {
            if (this.jrq != null && str != null) {
                bs = this.jrq.bs(str);
            }
            bs = null;
        }
        if (bs == null || bs.value == null) {
            return null;
        }
        return bs.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            aDl();
            if (z) {
                this.jrp.set(str, bArr, 604800000L);
            } else {
                this.jrq.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aDl();
            this.jrp.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
