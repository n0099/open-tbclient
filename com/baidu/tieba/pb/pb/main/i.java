package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class i {
    private static i eVQ;
    private com.baidu.adp.lib.cache.l<byte[]> eVR = null;
    private com.baidu.adp.lib.cache.l<byte[]> eVS = null;
    private long eVT = 0;
    private long eVU = 0;

    public static synchronized i aTX() {
        i iVar;
        synchronized (i.class) {
            if (eVQ == null) {
                eVQ = new i();
            }
            iVar = eVQ;
        }
        return iVar;
    }

    private i() {
        akf();
    }

    private void akf() {
        if (this.eVR == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eVR = com.baidu.tbadk.core.c.a.td().cO("tb.pb_mark");
            this.eVU = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eVS == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eVS = com.baidu.tbadk.core.c.a.td().cO("tb.pb_normal");
            this.eVT = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void O(String str, boolean z) {
        if (z) {
            if (this.eVR != null && str != null) {
                this.eVR.b(str, new byte[0], 0L);
            }
        } else if (this.eVS != null && str != null) {
            this.eVS.b(str, new byte[0], 0L);
        }
    }

    public byte[] P(String str, boolean z) {
        l.b<byte[]> W;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eVR != null && str != null) {
                W = this.eVR.W(str);
                j = this.eVU;
            }
            W = null;
        } else {
            if (this.eVS != null && str != null) {
                W = this.eVS.W(str);
                j = this.eVT;
            }
            W = null;
        }
        if (W == null || W.value == null) {
            return null;
        }
        com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
        mVar.fr(1001);
        mVar.aKy = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.Gx();
        return W.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            akf();
            if (z) {
                this.eVR.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eVS.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.fr(1001);
            mVar.aKz = currentTimeMillis2;
            mVar.Gy();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            akf();
            this.eVR.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.fr(1001);
            mVar.aKz = currentTimeMillis2;
            mVar.Gy();
        }
    }
}
