package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes9.dex */
public class i {
    private static i jrs;
    private com.baidu.adp.lib.cache.l<byte[]> jrt = null;
    private com.baidu.adp.lib.cache.l<byte[]> jru = null;

    public static synchronized i cxh() {
        i iVar;
        synchronized (i.class) {
            if (jrs == null) {
                jrs = new i();
            }
            iVar = jrs;
        }
        return iVar;
    }

    private i() {
        aDl();
    }

    private void aDl() {
        if (this.jrt == null) {
            this.jrt = com.baidu.tbadk.core.c.a.aMR().uf("tb.pb_mark");
        }
        if (this.jru == null) {
            this.jru = com.baidu.tbadk.core.c.a.aMR().uf("tb.pb_normal");
        }
    }

    public void ax(String str, boolean z) {
        if (z) {
            if (this.jrt != null && str != null) {
                this.jrt.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.jru != null && str != null) {
            this.jru.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] ay(String str, boolean z) {
        l.b<byte[]> bs;
        if (z) {
            if (this.jrt != null && str != null) {
                bs = this.jrt.bs(str);
            }
            bs = null;
        } else {
            if (this.jru != null && str != null) {
                bs = this.jru.bs(str);
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
                this.jrt.set(str, bArr, 604800000L);
            } else {
                this.jru.set(str, bArr, 86400000L);
            }
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aDl();
            this.jrt.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
