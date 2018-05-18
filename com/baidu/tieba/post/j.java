package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class j implements com.baidu.tieba.j.h {
    private String eRN;
    private String eRO;
    private HashMap<String, com.baidu.tieba.j.f> fTK;

    /* loaded from: classes2.dex */
    private static class a {
        private static final com.baidu.tieba.j.h fTL = new j();
    }

    public static com.baidu.tieba.j.h bhD() {
        return a.fTL;
    }

    private j() {
        this.fTK = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void aRI() {
        this.eRN = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void ac(int i, String str) {
        bhE().j(this.eRN, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ad(int i, String str) {
        bhE().k(this.eRN, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ae(int i, String str) {
        bhE().l(this.eRN, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aRJ() {
        bhE().pE(this.eRN);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        bhE().e(this.eRN, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aRK() {
        bhE().pF(this.eRN);
        pG(this.eRN);
    }

    @Override // com.baidu.tieba.j.h
    public void af(int i, String str) {
        bhE().m(this.eRN, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void pJ(String str) {
        if (!StringUtils.isNull(this.eRO)) {
            if (pH(this.eRO) || pI(this.eRO)) {
                pG(this.eRO);
            } else {
                com.baidu.tieba.j.d.pD(this.eRO);
                this.fTK.remove(this.eRN);
            }
            aRI();
            bhE().bz(this.eRO, str);
            this.eRO = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void aRL() {
        this.eRO = this.eRN;
    }

    @Override // com.baidu.tieba.j.h
    public void pK(String str) {
        bhE().bA(this.eRN, str);
        if (pH(this.eRN) || pI(this.eRN)) {
            pG(this.eRN);
        } else {
            com.baidu.tieba.j.d.pD(this.eRN);
            this.fTK.remove(this.eRN);
        }
        this.eRN = null;
    }

    public boolean pH(String str) {
        return bhE().pH(str);
    }

    public boolean pI(String str) {
        return bhE().pI(str);
    }

    public void pG(String str) {
        com.baidu.tieba.j.f fVar = this.fTK.get(str);
        if (fVar != null) {
            fVar.pG(str);
            this.fTK.remove(str);
        }
    }

    private com.baidu.tieba.j.f bhE() {
        com.baidu.tieba.j.f fVar = this.fTK.get(this.eRN);
        if (fVar == null) {
            return bhF();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bhF() {
        i iVar = new i(this.eRN);
        this.fTK.put(this.eRN, iVar);
        return iVar;
    }
}
