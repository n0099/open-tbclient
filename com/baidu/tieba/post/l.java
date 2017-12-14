package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i.f;
import com.baidu.tieba.i.h;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class l implements h {
    private String eEu;
    private String eEv;
    private HashMap<String, f> fSO;

    /* loaded from: classes2.dex */
    private static class a {
        private static final h fSP = new l();
    }

    public static h bkj() {
        return a.fSP;
    }

    private l() {
        this.fSO = new HashMap<>();
    }

    @Override // com.baidu.tieba.i.h
    public void aNS() {
        this.eEu = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.i.h
    public void Q(int i, String str) {
        bkk().i(this.eEu, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void R(int i, String str) {
        bkk().j(this.eEu, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void S(int i, String str) {
        bkk().k(this.eEu, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aNT() {
        bkk().oS(this.eEu);
    }

    @Override // com.baidu.tieba.i.h
    public void f(int i, int i2, String str) {
        bkk().c(this.eEu, i, i2, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aNU() {
        bkk().oT(this.eEu);
        oU(this.eEu);
    }

    @Override // com.baidu.tieba.i.h
    public void T(int i, String str) {
        bkk().l(this.eEu, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void oX(String str) {
        if (!StringUtils.isNull(this.eEv)) {
            if (oV(this.eEv) || oW(this.eEv)) {
                oU(this.eEv);
            } else {
                com.baidu.tieba.i.d.oR(this.eEv);
                this.fSO.remove(this.eEu);
            }
            aNS();
            bkk().bA(this.eEv, str);
            this.eEv = null;
        }
    }

    @Override // com.baidu.tieba.i.h
    public void aNV() {
        this.eEv = this.eEu;
    }

    @Override // com.baidu.tieba.i.h
    public void oY(String str) {
        bkk().bB(this.eEu, str);
        if (oV(this.eEu) || oW(this.eEu)) {
            oU(this.eEu);
        } else {
            com.baidu.tieba.i.d.oR(this.eEu);
            this.fSO.remove(this.eEu);
        }
        this.eEu = null;
    }

    public boolean oV(String str) {
        return bkk().oV(str);
    }

    public boolean oW(String str) {
        return bkk().oW(str);
    }

    public void oU(String str) {
        f fVar = this.fSO.get(str);
        if (fVar != null) {
            fVar.oU(str);
            this.fSO.remove(str);
        }
    }

    private f bkk() {
        f fVar = this.fSO.get(this.eEu);
        if (fVar == null) {
            return bkl();
        }
        return fVar;
    }

    private f bkl() {
        k kVar = new k(this.eEu);
        this.fSO.put(this.eEu, kVar);
        return kVar;
    }
}
