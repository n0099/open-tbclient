package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes4.dex */
public class g {
    private static g hGU;
    private com.baidu.adp.lib.cache.l<byte[]> hGV = null;
    private com.baidu.adp.lib.cache.l<byte[]> hGW = null;

    public static synchronized g bSp() {
        g gVar;
        synchronized (g.class) {
            if (hGU == null) {
                hGU = new g();
            }
            gVar = hGU;
        }
        return gVar;
    }

    private g() {
        Wx();
    }

    private void Wx() {
        if (this.hGV == null) {
            this.hGV = com.baidu.tbadk.core.c.a.afD().mA("tb.pb_mark");
        }
        if (this.hGW == null) {
            this.hGW = com.baidu.tbadk.core.c.a.afD().mA("tb.pb_normal");
        }
    }

    public void ao(String str, boolean z) {
        if (z) {
            if (this.hGV != null && str != null) {
                this.hGV.b(str, new byte[0], 0L);
            }
        } else if (this.hGW != null && str != null) {
            this.hGW.b(str, new byte[0], 0L);
        }
    }

    public byte[] ap(String str, boolean z) {
        l.b<byte[]> ap;
        if (z) {
            if (this.hGV != null && str != null) {
                ap = this.hGV.ap(str);
            }
            ap = null;
        } else {
            if (this.hGW != null && str != null) {
                ap = this.hGW.ap(str);
            }
            ap = null;
        }
        if (ap == null || ap.value == null) {
            return null;
        }
        return ap.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            Wx();
            if (z) {
                this.hGV.a(str, bArr, 604800000L);
            } else {
                this.hGW.a(str, bArr, 86400000L);
            }
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            Wx();
            this.hGV.a(str, bArr, 2592000000L);
        }
    }
}
