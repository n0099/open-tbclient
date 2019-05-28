package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes4.dex */
public class g {
    private static g hGX;
    private com.baidu.adp.lib.cache.l<byte[]> hGY = null;
    private com.baidu.adp.lib.cache.l<byte[]> hGZ = null;

    public static synchronized g bSs() {
        g gVar;
        synchronized (g.class) {
            if (hGX == null) {
                hGX = new g();
            }
            gVar = hGX;
        }
        return gVar;
    }

    private g() {
        Wx();
    }

    private void Wx() {
        if (this.hGY == null) {
            this.hGY = com.baidu.tbadk.core.c.a.afD().mA("tb.pb_mark");
        }
        if (this.hGZ == null) {
            this.hGZ = com.baidu.tbadk.core.c.a.afD().mA("tb.pb_normal");
        }
    }

    public void ao(String str, boolean z) {
        if (z) {
            if (this.hGY != null && str != null) {
                this.hGY.b(str, new byte[0], 0L);
            }
        } else if (this.hGZ != null && str != null) {
            this.hGZ.b(str, new byte[0], 0L);
        }
    }

    public byte[] ap(String str, boolean z) {
        l.b<byte[]> ap;
        if (z) {
            if (this.hGY != null && str != null) {
                ap = this.hGY.ap(str);
            }
            ap = null;
        } else {
            if (this.hGZ != null && str != null) {
                ap = this.hGZ.ap(str);
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
                this.hGY.a(str, bArr, 604800000L);
            } else {
                this.hGZ.a(str, bArr, 86400000L);
            }
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            Wx();
            this.hGY.a(str, bArr, 2592000000L);
        }
    }
}
