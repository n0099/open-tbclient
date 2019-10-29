package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes4.dex */
public class g {
    private static g hOH;
    private com.baidu.adp.lib.cache.l<byte[]> hOI = null;
    private com.baidu.adp.lib.cache.l<byte[]> hOJ = null;

    public static synchronized g bTk() {
        g gVar;
        synchronized (g.class) {
            if (hOH == null) {
                hOH = new g();
            }
            gVar = hOH;
        }
        return gVar;
    }

    private g() {
        ack();
    }

    private void ack() {
        if (this.hOI == null) {
            this.hOI = com.baidu.tbadk.core.d.a.akN().nk("tb.pb_mark");
        }
        if (this.hOJ == null) {
            this.hOJ = com.baidu.tbadk.core.d.a.akN().nk("tb.pb_normal");
        }
    }

    public void an(String str, boolean z) {
        if (z) {
            if (this.hOI != null && str != null) {
                this.hOI.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.hOJ != null && str != null) {
            this.hOJ.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] ao(String str, boolean z) {
        l.b<byte[]> Y;
        if (z) {
            if (this.hOI != null && str != null) {
                Y = this.hOI.Y(str);
            }
            Y = null;
        } else {
            if (this.hOJ != null && str != null) {
                Y = this.hOJ.Y(str);
            }
            Y = null;
        }
        if (Y == null || Y.value == null) {
            return null;
        }
        return Y.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            ack();
            if (z) {
                this.hOI.set(str, bArr, 604800000L);
            } else {
                this.hOJ.set(str, bArr, 86400000L);
            }
        }
    }

    public void k(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            ack();
            this.hOI.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
