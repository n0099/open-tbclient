package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class i {
    private static i fIy;
    private com.baidu.adp.lib.cache.l<byte[]> fIz = null;
    private com.baidu.adp.lib.cache.l<byte[]> fIA = null;
    private long fIB = 0;
    private long fIC = 0;

    public static synchronized i bbj() {
        i iVar;
        synchronized (i.class) {
            if (fIy == null) {
                fIy = new i();
            }
            iVar = fIy;
        }
        return iVar;
    }

    private i() {
        arO();
    }

    private void arO() {
        if (this.fIz == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.fIz = com.baidu.tbadk.core.c.a.AE().cV("tb.pb_mark");
            this.fIC = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.fIA == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.fIA = com.baidu.tbadk.core.c.a.AE().cV("tb.pb_normal");
            this.fIB = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void P(String str, boolean z) {
        if (z) {
            if (this.fIz != null && str != null) {
                this.fIz.b(str, new byte[0], 0L);
            }
        } else if (this.fIA != null && str != null) {
            this.fIA.b(str, new byte[0], 0L);
        }
    }

    public byte[] Q(String str, boolean z) {
        l.b<byte[]> ae;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.fIz != null && str != null) {
                ae = this.fIz.ae(str);
                j = this.fIC;
            }
            ae = null;
        } else {
            if (this.fIA != null && str != null) {
                ae = this.fIA.ae(str);
                j = this.fIB;
            }
            ae = null;
        }
        if (ae == null || ae.value == null) {
            return null;
        }
        com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
        mVar.iq(1001);
        mVar.byp = j + (System.currentTimeMillis() - currentTimeMillis);
        mVar.NW();
        return ae.value;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            arO();
            if (z) {
                this.fIz.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.fIA.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.iq(1001);
            mVar.byq = currentTimeMillis2;
            mVar.NX();
        }
    }

    public void m(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            arO();
            this.fIz.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m();
            mVar.iq(1001);
            mVar.byq = currentTimeMillis2;
            mVar.NX();
        }
    }
}
