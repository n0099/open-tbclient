package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class i {
    private static i fJY;
    private com.baidu.adp.lib.cache.l<byte[]> fJZ = null;
    private com.baidu.adp.lib.cache.l<byte[]> fKa = null;
    private long fKb = 0;
    private long fKc = 0;

    public static synchronized i bbn() {
        i iVar;
        synchronized (i.class) {
            if (fJY == null) {
                fJY = new i();
            }
            iVar = fJY;
        }
        return iVar;
    }

    private i() {
        asR();
    }

    private void asR() {
        if (this.fJZ == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fJZ = com.baidu.tbadk.core.c.a.Aw().cV("tb.pb_mark");
            this.fKc = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.fKa == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.fKa = com.baidu.tbadk.core.c.a.Aw().cV("tb.pb_normal");
            this.fKb = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void P(String str, boolean z) {
        if (z) {
            if (this.fJZ != null && str != null) {
                this.fJZ.b(str, new byte[0], 0L);
            }
        } else if (this.fKa != null && str != null) {
            this.fKa.b(str, new byte[0], 0L);
        }
    }

    public byte[] Q(String str, boolean z) {
        l.b<byte[]> ae;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.fJZ != null && str != null) {
                ae = this.fJZ.ae(str);
                j = this.fKc;
            }
            ae = null;
        } else {
            if (this.fKa != null && str != null) {
                ae = this.fKa.ae(str);
                j = this.fKb;
            }
            ae = null;
        }
        if (ae == null || ae.value == null) {
            return null;
        }
        com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
        mVar.im(1001);
        mVar.byy = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.NK();
        return ae.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            asR();
            if (z) {
                this.fJZ.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.fKa.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.im(1001);
            mVar.byz = currentTimeMillis2;
            mVar.NL();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            asR();
            this.fJZ.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.im(1001);
            mVar.byz = currentTimeMillis2;
            mVar.NL();
        }
    }
}
