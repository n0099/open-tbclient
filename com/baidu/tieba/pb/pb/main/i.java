package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class i {
    private static i eUN;
    private com.baidu.adp.lib.cache.l<byte[]> eUO = null;
    private com.baidu.adp.lib.cache.l<byte[]> eUP = null;
    private long eUQ = 0;
    private long eUR = 0;

    public static synchronized i aTP() {
        i iVar;
        synchronized (i.class) {
            if (eUN == null) {
                eUN = new i();
            }
            iVar = eUN;
        }
        return iVar;
    }

    private i() {
        ajY();
    }

    private void ajY() {
        if (this.eUO == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.eUO = com.baidu.tbadk.core.c.a.tg().cO("tb.pb_mark");
            this.eUR = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.eUP == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.eUP = com.baidu.tbadk.core.c.a.tg().cO("tb.pb_normal");
            this.eUQ = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void N(String str, boolean z) {
        if (z) {
            if (this.eUO != null && str != null) {
                this.eUO.b(str, new byte[0], 0L);
            }
        } else if (this.eUP != null && str != null) {
            this.eUP.b(str, new byte[0], 0L);
        }
    }

    public byte[] O(String str, boolean z) {
        l.b<byte[]> W;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.eUO != null && str != null) {
                W = this.eUO.W(str);
                j = this.eUR;
            }
            W = null;
        } else {
            if (this.eUP != null && str != null) {
                W = this.eUP.W(str);
                j = this.eUQ;
            }
            W = null;
        }
        if (W == null || W.value == null) {
            return null;
        }
        com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
        mVar.fr(1001);
        mVar.aKu = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.Gw();
        return W.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ajY();
            if (z) {
                this.eUO.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.eUP.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.fr(1001);
            mVar.aKv = currentTimeMillis2;
            mVar.Gx();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ajY();
            this.eUO.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.fr(1001);
            mVar.aKv = currentTimeMillis2;
            mVar.Gx();
        }
    }
}
