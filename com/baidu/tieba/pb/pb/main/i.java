package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class i {
    private static i eMM;
    private com.baidu.adp.lib.cache.l<byte[]> eMN = null;
    private com.baidu.adp.lib.cache.l<byte[]> eMO = null;
    private long eMP = 0;
    private long eMQ = 0;

    public static synchronized i aSn() {
        i iVar;
        synchronized (i.class) {
            if (eMM == null) {
                eMM = new i();
            }
            iVar = eMM;
        }
        return iVar;
    }

    private i() {
        ahP();
    }

    private void ahP() {
        if (this.eMN == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eMN = com.baidu.tbadk.core.c.a.td().cO("tb.pb_mark");
            this.eMQ = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eMO == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eMO = com.baidu.tbadk.core.c.a.td().cO("tb.pb_normal");
            this.eMP = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void M(String str, boolean z) {
        if (z) {
            if (this.eMN != null && str != null) {
                this.eMN.b(str, new byte[0], 0L);
            }
        } else if (this.eMO != null && str != null) {
            this.eMO.b(str, new byte[0], 0L);
        }
    }

    public byte[] N(String str, boolean z) {
        l.b<byte[]> W;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eMN != null && str != null) {
                W = this.eMN.W(str);
                j = this.eMQ;
            }
            W = null;
        } else {
            if (this.eMO != null && str != null) {
                W = this.eMO.W(str);
                j = this.eMP;
            }
            W = null;
        }
        if (W == null || W.value == null) {
            return null;
        }
        com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
        mVar.ft(1001);
        mVar.aJL = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.Ge();
        return W.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ahP();
            if (z) {
                this.eMN.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eMO.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.ft(1001);
            mVar.aJM = currentTimeMillis2;
            mVar.Gf();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ahP();
            this.eMN.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m();
            mVar.ft(1001);
            mVar.aJM = currentTimeMillis2;
            mVar.Gf();
        }
    }
}
