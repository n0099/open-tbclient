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

    public static h bki() {
        return a.fSP;
    }

    private l() {
        this.fSO = new HashMap<>();
    }

    @Override // com.baidu.tieba.i.h
    public void aNR() {
        this.eEu = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.i.h
    public void Q(int i, String str) {
        bkj().i(this.eEu, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void R(int i, String str) {
        bkj().j(this.eEu, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void S(int i, String str) {
        bkj().k(this.eEu, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aNS() {
        bkj().oS(this.eEu);
    }

    @Override // com.baidu.tieba.i.h
    public void f(int i, int i2, String str) {
        bkj().c(this.eEu, i, i2, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aNT() {
        bkj().oT(this.eEu);
        oU(this.eEu);
    }

    @Override // com.baidu.tieba.i.h
    public void T(int i, String str) {
        bkj().l(this.eEu, i, str);
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
            aNR();
            bkj().bA(this.eEv, str);
            this.eEv = null;
        }
    }

    @Override // com.baidu.tieba.i.h
    public void aNU() {
        this.eEv = this.eEu;
    }

    @Override // com.baidu.tieba.i.h
    public void oY(String str) {
        bkj().bB(this.eEu, str);
        if (oV(this.eEu) || oW(this.eEu)) {
            oU(this.eEu);
        } else {
            com.baidu.tieba.i.d.oR(this.eEu);
            this.fSO.remove(this.eEu);
        }
        this.eEu = null;
    }

    public boolean oV(String str) {
        return bkj().oV(str);
    }

    public boolean oW(String str) {
        return bkj().oW(str);
    }

    public void oU(String str) {
        f fVar = this.fSO.get(str);
        if (fVar != null) {
            fVar.oU(str);
            this.fSO.remove(str);
        }
    }

    private f bkj() {
        f fVar = this.fSO.get(this.eEu);
        if (fVar == null) {
            return bkk();
        }
        return fVar;
    }

    private f bkk() {
        k kVar = new k(this.eEu);
        this.fSO.put(this.eEu, kVar);
        return kVar;
    }
}
