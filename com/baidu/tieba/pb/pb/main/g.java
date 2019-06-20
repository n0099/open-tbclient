package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes4.dex */
public class g {
    private static g hGY;
    private com.baidu.adp.lib.cache.l<byte[]> hGZ = null;
    private com.baidu.adp.lib.cache.l<byte[]> hHa = null;

    public static synchronized g bSt() {
        g gVar;
        synchronized (g.class) {
            if (hGY == null) {
                hGY = new g();
            }
            gVar = hGY;
        }
        return gVar;
    }

    private g() {
        Wx();
    }

    private void Wx() {
        if (this.hGZ == null) {
            this.hGZ = com.baidu.tbadk.core.c.a.afD().mz("tb.pb_mark");
        }
        if (this.hHa == null) {
            this.hHa = com.baidu.tbadk.core.c.a.afD().mz("tb.pb_normal");
        }
    }

    public void ao(String str, boolean z) {
        if (z) {
            if (this.hGZ != null && str != null) {
                this.hGZ.b(str, new byte[0], 0L);
            }
        } else if (this.hHa != null && str != null) {
            this.hHa.b(str, new byte[0], 0L);
        }
    }

    public byte[] ap(String str, boolean z) {
        l.b<byte[]> ap;
        if (z) {
            if (this.hGZ != null && str != null) {
                ap = this.hGZ.ap(str);
            }
            ap = null;
        } else {
            if (this.hHa != null && str != null) {
                ap = this.hHa.ap(str);
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
                this.hGZ.a(str, bArr, 604800000L);
            } else {
                this.hHa.a(str, bArr, 86400000L);
            }
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            Wx();
            this.hGZ.a(str, bArr, 2592000000L);
        }
    }
}
