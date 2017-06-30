package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class dl {
    private static dl exm;
    private com.baidu.adp.lib.cache.o<byte[]> exn = null;
    private com.baidu.adp.lib.cache.o<byte[]> exo = null;
    private long exp = 0;
    private long exq = 0;

    public static synchronized dl aOy() {
        dl dlVar;
        synchronized (dl.class) {
            if (exm == null) {
                exm = new dl();
            }
            dlVar = exm;
        }
        return dlVar;
    }

    private dl() {
        acO();
    }

    private void acO() {
        if (this.exn == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.exn = com.baidu.tbadk.core.c.a.sW().cE("tb.pb_mark");
            this.exq = System.currentTimeMillis() - currentTimeMillis;
        }
        if (this.exo == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.exo = com.baidu.tbadk.core.c.a.sW().cE("tb.pb_normal");
            this.exp = System.currentTimeMillis() - currentTimeMillis2;
        }
    }

    public void O(String str, boolean z) {
        if (z) {
            if (this.exn != null && str != null) {
                this.exn.b(str, new byte[0], 0L);
            }
        } else if (this.exo != null && str != null) {
            this.exo.b(str, new byte[0], 0L);
        }
    }

    public byte[] P(String str, boolean z) {
        o.c<byte[]> U;
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        if (z) {
            if (this.exn != null && str != null) {
                U = this.exn.U(str);
                j = this.exq;
            }
            U = null;
        } else {
            if (this.exo != null && str != null) {
                U = this.exo.U(str);
                j = this.exp;
            }
            U = null;
        }
        if (U == null || U.sG == null) {
            return null;
        }
        com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
        vVar.fd(1001);
        vVar.aHN = (System.currentTimeMillis() - currentTimeMillis) + j;
        vVar.FX();
        return U.sG;
    }

    public void a(String str, boolean z, byte[] bArr) {
        if (str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            acO();
            if (z) {
                this.exn.a(str, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                this.exo.a(str, bArr, 86400000L);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
            vVar.fd(1001);
            vVar.aHO = currentTimeMillis2;
            vVar.FY();
        }
    }

    public void l(String str, byte[] bArr) {
        if (bArr != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            acO();
            this.exn.a(str, bArr, 2592000000L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v();
            vVar.fd(1001);
            vVar.aHO = currentTimeMillis2;
            vVar.FY();
        }
    }
}
