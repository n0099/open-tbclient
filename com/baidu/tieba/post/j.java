package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class j implements com.baidu.tieba.j.h {
    private String eQG;
    private String eQH;
    private HashMap<String, com.baidu.tieba.j.f> fSE;

    /* loaded from: classes2.dex */
    private static class a {
        private static final com.baidu.tieba.j.h fSF = new j();
    }

    public static com.baidu.tieba.j.h bhD() {
        return a.fSF;
    }

    private j() {
        this.fSE = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void aRI() {
        this.eQG = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void ac(int i, String str) {
        bhE().j(this.eQG, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ad(int i, String str) {
        bhE().k(this.eQG, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ae(int i, String str) {
        bhE().l(this.eQG, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aRJ() {
        bhE().pB(this.eQG);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        bhE().e(this.eQG, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aRK() {
        bhE().pC(this.eQG);
        pD(this.eQG);
    }

    @Override // com.baidu.tieba.j.h
    public void af(int i, String str) {
        bhE().m(this.eQG, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void pG(String str) {
        if (!StringUtils.isNull(this.eQH)) {
            if (pE(this.eQH) || pF(this.eQH)) {
                pD(this.eQH);
            } else {
                com.baidu.tieba.j.d.pA(this.eQH);
                this.fSE.remove(this.eQG);
            }
            aRI();
            bhE().bz(this.eQH, str);
            this.eQH = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void aRL() {
        this.eQH = this.eQG;
    }

    @Override // com.baidu.tieba.j.h
    public void pH(String str) {
        bhE().bA(this.eQG, str);
        if (pE(this.eQG) || pF(this.eQG)) {
            pD(this.eQG);
        } else {
            com.baidu.tieba.j.d.pA(this.eQG);
            this.fSE.remove(this.eQG);
        }
        this.eQG = null;
    }

    public boolean pE(String str) {
        return bhE().pE(str);
    }

    public boolean pF(String str) {
        return bhE().pF(str);
    }

    public void pD(String str) {
        com.baidu.tieba.j.f fVar = this.fSE.get(str);
        if (fVar != null) {
            fVar.pD(str);
            this.fSE.remove(str);
        }
    }

    private com.baidu.tieba.j.f bhE() {
        com.baidu.tieba.j.f fVar = this.fSE.get(this.eQG);
        if (fVar == null) {
            return bhF();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bhF() {
        i iVar = new i(this.eQG);
        this.fSE.put(this.eQG, iVar);
        return iVar;
    }
}
