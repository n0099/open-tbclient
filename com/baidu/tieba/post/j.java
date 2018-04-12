package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class j implements com.baidu.tieba.j.h {
    private String eQJ;
    private String eQK;
    private HashMap<String, com.baidu.tieba.j.f> fSH;

    /* loaded from: classes2.dex */
    private static class a {
        private static final com.baidu.tieba.j.h fSI = new j();
    }

    public static com.baidu.tieba.j.h bhD() {
        return a.fSI;
    }

    private j() {
        this.fSH = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void aRI() {
        this.eQJ = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void ac(int i, String str) {
        bhE().j(this.eQJ, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ad(int i, String str) {
        bhE().k(this.eQJ, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ae(int i, String str) {
        bhE().l(this.eQJ, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aRJ() {
        bhE().pB(this.eQJ);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        bhE().e(this.eQJ, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aRK() {
        bhE().pC(this.eQJ);
        pD(this.eQJ);
    }

    @Override // com.baidu.tieba.j.h
    public void af(int i, String str) {
        bhE().m(this.eQJ, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void pG(String str) {
        if (!StringUtils.isNull(this.eQK)) {
            if (pE(this.eQK) || pF(this.eQK)) {
                pD(this.eQK);
            } else {
                com.baidu.tieba.j.d.pA(this.eQK);
                this.fSH.remove(this.eQJ);
            }
            aRI();
            bhE().bz(this.eQK, str);
            this.eQK = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void aRL() {
        this.eQK = this.eQJ;
    }

    @Override // com.baidu.tieba.j.h
    public void pH(String str) {
        bhE().bA(this.eQJ, str);
        if (pE(this.eQJ) || pF(this.eQJ)) {
            pD(this.eQJ);
        } else {
            com.baidu.tieba.j.d.pA(this.eQJ);
            this.fSH.remove(this.eQJ);
        }
        this.eQJ = null;
    }

    public boolean pE(String str) {
        return bhE().pE(str);
    }

    public boolean pF(String str) {
        return bhE().pF(str);
    }

    public void pD(String str) {
        com.baidu.tieba.j.f fVar = this.fSH.get(str);
        if (fVar != null) {
            fVar.pD(str);
            this.fSH.remove(str);
        }
    }

    private com.baidu.tieba.j.f bhE() {
        com.baidu.tieba.j.f fVar = this.fSH.get(this.eQJ);
        if (fVar == null) {
            return bhF();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bhF() {
        i iVar = new i(this.eQJ);
        this.fSH.put(this.eQJ, iVar);
        return iVar;
    }
}
