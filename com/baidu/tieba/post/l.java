package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i.f;
import com.baidu.tieba.i.h;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class l implements h {
    private String eEy;
    private String eEz;
    private HashMap<String, f> fST;

    /* loaded from: classes2.dex */
    private static class a {
        private static final h fSU = new l();
    }

    public static h bkj() {
        return a.fSU;
    }

    private l() {
        this.fST = new HashMap<>();
    }

    @Override // com.baidu.tieba.i.h
    public void aNS() {
        this.eEy = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.i.h
    public void Q(int i, String str) {
        bkk().i(this.eEy, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void R(int i, String str) {
        bkk().j(this.eEy, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void S(int i, String str) {
        bkk().k(this.eEy, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aNT() {
        bkk().oS(this.eEy);
    }

    @Override // com.baidu.tieba.i.h
    public void f(int i, int i2, String str) {
        bkk().c(this.eEy, i, i2, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aNU() {
        bkk().oT(this.eEy);
        oU(this.eEy);
    }

    @Override // com.baidu.tieba.i.h
    public void T(int i, String str) {
        bkk().l(this.eEy, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void oX(String str) {
        if (!StringUtils.isNull(this.eEz)) {
            if (oV(this.eEz) || oW(this.eEz)) {
                oU(this.eEz);
            } else {
                com.baidu.tieba.i.d.oR(this.eEz);
                this.fST.remove(this.eEy);
            }
            aNS();
            bkk().bA(this.eEz, str);
            this.eEz = null;
        }
    }

    @Override // com.baidu.tieba.i.h
    public void aNV() {
        this.eEz = this.eEy;
    }

    @Override // com.baidu.tieba.i.h
    public void oY(String str) {
        bkk().bB(this.eEy, str);
        if (oV(this.eEy) || oW(this.eEy)) {
            oU(this.eEy);
        } else {
            com.baidu.tieba.i.d.oR(this.eEy);
            this.fST.remove(this.eEy);
        }
        this.eEy = null;
    }

    public boolean oV(String str) {
        return bkk().oV(str);
    }

    public boolean oW(String str) {
        return bkk().oW(str);
    }

    public void oU(String str) {
        f fVar = this.fST.get(str);
        if (fVar != null) {
            fVar.oU(str);
            this.fST.remove(str);
        }
    }

    private f bkk() {
        f fVar = this.fST.get(this.eEy);
        if (fVar == null) {
            return bkl();
        }
        return fVar;
    }

    private f bkl() {
        k kVar = new k(this.eEy);
        this.fST.put(this.eEy, kVar);
        return kVar;
    }
}
