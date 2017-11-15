package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class i {
    private static i eNg;
    private com.baidu.adp.lib.cache.l<byte[]> eNh = null;
    private com.baidu.adp.lib.cache.l<byte[]> eNi = null;
    private long eNj = 0;
    private long eNk = 0;

    public static synchronized i aSv() {
        i iVar;
        synchronized (i.class) {
            if (eNg == null) {
                eNg = new i();
            }
            iVar = eNg;
        }
        return iVar;
    }

    private i() {
        aid();
    }

    private void aid() {
        if (this.eNh == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eNh = com.baidu.tbadk.core.c.a.td().cO("tb.pb_mark");
            this.eNk = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eNi == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eNi = com.baidu.tbadk.core.c.a.td().cO("tb.pb_normal");
            this.eNj = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void M(String str, boolean z) {
        if (z) {
            if (this.eNh != null && str != null) {
                this.eNh.b(str, new byte[0], 0L);
            }
        } else if (this.eNi != null && str != null) {
            this.eNi.b(str, new byte[0], 0L);
        }
    }

    public byte[] N(String str, boolean z) {
        l.b<byte[]> W;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eNh != null && str != null) {
                W = this.eNh.W(str);
                j = this.eNk;
            }
            W = null;
        } else {
            if (this.eNi != null && str != null) {
                W = this.eNi.W(str);
                j = this.eNj;
            }
            W = null;
        }
        if (W == null || W.value == null) {
            return null;
        }
        com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
        mVar.fs(1001);
        mVar.aJT = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.Gp();
        return W.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            aid();
            if (z) {
                this.eNh.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eNi.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fs(1001);
            mVar.aJU = currentTimeMillis2;
            mVar.Gq();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            aid();
            this.eNh.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.fs(1001);
            mVar.aJU = currentTimeMillis2;
            mVar.Gq();
        }
    }
}
