package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes4.dex */
public class g {
    private static g hNQ;
    private com.baidu.adp.lib.cache.l<byte[]> hNR = null;
    private com.baidu.adp.lib.cache.l<byte[]> hNS = null;

    public static synchronized g bTi() {
        g gVar;
        synchronized (g.class) {
            if (hNQ == null) {
                hNQ = new g();
            }
            gVar = hNQ;
        }
        return gVar;
    }

    private g() {
        aci();
    }

    private void aci() {
        if (this.hNR == null) {
            this.hNR = com.baidu.tbadk.core.d.a.akL().nk("tb.pb_mark");
        }
        if (this.hNS == null) {
            this.hNS = com.baidu.tbadk.core.d.a.akL().nk("tb.pb_normal");
        }
    }

    public void an(String str, boolean z) {
        if (z) {
            if (this.hNR != null && str != null) {
                this.hNR.asyncSet(str, new byte[0], 0L);
            }
        } else if (this.hNS != null && str != null) {
            this.hNS.asyncSet(str, new byte[0], 0L);
        }
    }

    public byte[] ao(String str, boolean z) {
        l.b<byte[]> Y;
        if (z) {
            if (this.hNR != null && str != null) {
                Y = this.hNR.Y(str);
            }
            Y = null;
        } else {
            if (this.hNS != null && str != null) {
                Y = this.hNS.Y(str);
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
            aci();
            if (z) {
                this.hNR.set(str, bArr, 604800000L);
            } else {
                this.hNS.set(str, bArr, 86400000L);
            }
        }
    }

    public void k(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            aci();
            this.hNR.set(str, bArr, BdKVCache.MILLS_30Days);
        }
    }
}
