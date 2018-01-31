package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class i {
    private static i fKt;
    private com.baidu.adp.lib.cache.l<byte[]> fKu = null;
    private com.baidu.adp.lib.cache.l<byte[]> fKv = null;
    private long fKw = 0;
    private long fKx = 0;

    public static synchronized i bbs() {
        i iVar;
        synchronized (i.class) {
            if (fKt == null) {
                fKt = new i();
            }
            iVar = fKt;
        }
        return iVar;
    }

    private i() {
        asW();
    }

    private void asW() {
        if (this.fKu == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fKu = com.baidu.tbadk.core.c.a.Ax().cV("tb.pb_mark");
            this.fKx = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.fKv == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.fKv = com.baidu.tbadk.core.c.a.Ax().cV("tb.pb_normal");
            this.fKw = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void P(String str, boolean z) {
        if (z) {
            if (this.fKu != null && str != null) {
                this.fKu.b(str, new byte[0], 0L);
            }
        } else if (this.fKv != null && str != null) {
            this.fKv.b(str, new byte[0], 0L);
        }
    }

    public byte[] Q(String str, boolean z) {
        l.b<byte[]> ae;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.fKu != null && str != null) {
                ae = this.fKu.ae(str);
                j = this.fKx;
            }
            ae = null;
        } else {
            if (this.fKv != null && str != null) {
                ae = this.fKv.ae(str);
                j = this.fKw;
            }
            ae = null;
        }
        if (ae == null || ae.value == null) {
            return null;
        }
        com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
        mVar.im(1001);
        mVar.byH = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.NM();
        return ae.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            asW();
            if (z) {
                this.fKu.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.fKv.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.im(1001);
            mVar.byI = currentTimeMillis2;
            mVar.NN();
        }
    }

    public void n(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            asW();
            this.fKu.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.im(1001);
            mVar.byI = currentTimeMillis2;
            mVar.NN();
        }
    }
}
