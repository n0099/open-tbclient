package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class cw {
    private static cw emD;
    private com.baidu.adp.lib.cache.o<byte[]> emE = null;
    private com.baidu.adp.lib.cache.o<byte[]> emF = null;
    private long emG = 0;
    private long emH = 0;

    public static synchronized cw aKZ() {
        cw cwVar;
        synchronized (cw.class) {
            if (emD == null) {
                emD = new cw();
            }
            cwVar = emD;
        }
        return cwVar;
    }

    private cw() {
        XS();
    }

    private void XS() {
        if (this.emE == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.emE = com.baidu.tbadk.core.c.a.to().ct("tb.pb_mark");
            this.emH = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.emF == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.emF = com.baidu.tbadk.core.c.a.to().ct("tb.pb_normal");
            this.emG = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void M(String str, boolean z) {
        if (z) {
            if (this.emE != null && str != null) {
                this.emE.b(str, new byte[0], 0L);
            }
        } else if (this.emF != null && str != null) {
            this.emF.b(str, new byte[0], 0L);
        }
    }

    public byte[] N(String str, boolean z) {
        o.c<byte[]> S;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.emE != null && str != null) {
                S = this.emE.S(str);
                j = this.emH;
            }
            S = null;
        } else {
            if (this.emF != null && str != null) {
                S = this.emF.S(str);
                j = this.emG;
            }
            S = null;
        }
        if (S == null || S.te == null) {
            return null;
        }
        com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
        vVar.fb(1001);
        vVar.aGr = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.Ge();
        return S.te;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            XS();
            if (z) {
                this.emE.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.emF.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fb(1001);
            vVar.aGs = currentTimeMillis2;
            vVar.Gf();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            XS();
            this.emE.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fb(1001);
            vVar.aGs = currentTimeMillis2;
            vVar.Gf();
        }
    }
}
