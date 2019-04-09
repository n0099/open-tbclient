package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
/* loaded from: classes4.dex */
public class g {
    private static g hps;
    private com.baidu.adp.lib.cache.l<byte[]> hpt = null;
    private com.baidu.adp.lib.cache.l<byte[]> hpu = null;

    public static synchronized g bKy() {
        g gVar;
        synchronized (g.class) {
            if (hps == null) {
                hps = new g();
            }
            gVar = hps;
        }
        return gVar;
    }

    private g() {
        SK();
    }

    private void SK() {
        if (this.hpt == null) {
            this.hpt = com.baidu.tbadk.core.c.a.aaT().lv("tb.pb_mark");
        }
        if (this.hpu == null) {
            this.hpu = com.baidu.tbadk.core.c.a.aaT().lv("tb.pb_normal");
        }
    }

    public void am(String str, boolean z) {
        if (z) {
            if (this.hpt != null && str != null) {
                this.hpt.b(str, new byte[0], 0L);
            }
        } else if (this.hpu != null && str != null) {
            this.hpu.b(str, new byte[0], 0L);
        }
    }

    public byte[] an(String str, boolean z) {
        l.b<byte[]> aF;
        if (z) {
            if (this.hpt != null && str != null) {
                aF = this.hpt.aF(str);
            }
            aF = null;
        } else {
            if (this.hpu != null && str != null) {
                aF = this.hpu.aF(str);
            }
            aF = null;
        }
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            SK();
            if (z) {
                this.hpt.a(str, bArr, 604800000L);
            } else {
                this.hpu.a(str, bArr, 86400000L);
            }
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            SK();
            this.hpt.a(str, bArr, 2592000000L);
        }
    }
}
