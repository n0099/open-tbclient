package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i.f;
import com.baidu.tieba.i.h;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class l implements h {
    private String eDq;
    private String eDr;
    private HashMap<String, f> fRV;

    /* loaded from: classes2.dex */
    private static class a {
        private static final h fRW = new l();
    }

    public static h bkb() {
        return a.fRW;
    }

    private l() {
        this.fRV = new HashMap<>();
    }

    @Override // com.baidu.tieba.i.h
    public void aNJ() {
        this.eDq = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.i.h
    public void Q(int i, String str) {
        bkc().i(this.eDq, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void R(int i, String str) {
        bkc().j(this.eDq, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void S(int i, String str) {
        bkc().k(this.eDq, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aNK() {
        bkc().oS(this.eDq);
    }

    @Override // com.baidu.tieba.i.h
    public void f(int i, int i2, String str) {
        bkc().c(this.eDq, i, i2, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aNL() {
        bkc().oT(this.eDq);
        oU(this.eDq);
    }

    @Override // com.baidu.tieba.i.h
    public void T(int i, String str) {
        bkc().l(this.eDq, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void oX(String str) {
        if (!StringUtils.isNull(this.eDr)) {
            if (oV(this.eDr) || oW(this.eDr)) {
                oU(this.eDr);
            } else {
                com.baidu.tieba.i.d.oR(this.eDr);
                this.fRV.remove(this.eDq);
            }
            aNJ();
            bkc().bz(this.eDr, str);
            this.eDr = null;
        }
    }

    @Override // com.baidu.tieba.i.h
    public void aNM() {
        this.eDr = this.eDq;
    }

    @Override // com.baidu.tieba.i.h
    public void oY(String str) {
        bkc().bA(this.eDq, str);
        if (oV(this.eDq) || oW(this.eDq)) {
            oU(this.eDq);
        } else {
            com.baidu.tieba.i.d.oR(this.eDq);
            this.fRV.remove(this.eDq);
        }
        this.eDq = null;
    }

    public boolean oV(String str) {
        return bkc().oV(str);
    }

    public boolean oW(String str) {
        return bkc().oW(str);
    }

    public void oU(String str) {
        f fVar = this.fRV.get(str);
        if (fVar != null) {
            fVar.oU(str);
            this.fRV.remove(str);
        }
    }

    private f bkc() {
        f fVar = this.fRV.get(this.eDq);
        if (fVar == null) {
            return bkd();
        }
        return fVar;
    }

    private f bkd() {
        k kVar = new k(this.eDq);
        this.fRV.put(this.eDq, kVar);
        return kVar;
    }
}
