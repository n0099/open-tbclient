package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class i {
    private static i eVV;
    private com.baidu.adp.lib.cache.l<byte[]> eVW = null;
    private com.baidu.adp.lib.cache.l<byte[]> eVX = null;
    private long eVY = 0;
    private long eVZ = 0;

    public static synchronized i aTY() {
        i iVar;
        synchronized (i.class) {
            if (eVV == null) {
                eVV = new i();
            }
            iVar = eVV;
        }
        return iVar;
    }

    private i() {
        akf();
    }

    private void akf() {
        if (this.eVW == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eVW = com.baidu.tbadk.core.c.a.td().cO("tb.pb_mark");
            this.eVZ = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eVX == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eVX = com.baidu.tbadk.core.c.a.td().cO("tb.pb_normal");
            this.eVY = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void O(String str, boolean z) {
        if (z) {
            if (this.eVW != null && str != null) {
                this.eVW.b(str, new byte[0], 0L);
            }
        } else if (this.eVX != null && str != null) {
            this.eVX.b(str, new byte[0], 0L);
        }
    }

    public byte[] P(String str, boolean z) {
        l.b<byte[]> W;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eVW != null && str != null) {
                W = this.eVW.W(str);
                j = this.eVZ;
            }
            W = null;
        } else {
            if (this.eVX != null && str != null) {
                W = this.eVX.W(str);
                j = this.eVY;
            }
            W = null;
        }
        if (W == null || W.value == null) {
            return null;
        }
        com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
        mVar.fr(1001);
        mVar.aKB = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.Gx();
        return W.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            akf();
            if (z) {
                this.eVW.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eVX.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.fr(1001);
            mVar.aKC = currentTimeMillis2;
            mVar.Gy();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            akf();
            this.eVW.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.fr(1001);
            mVar.aKC = currentTimeMillis2;
            mVar.Gy();
        }
    }
}
