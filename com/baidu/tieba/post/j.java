package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes4.dex */
public class j implements com.baidu.tieba.j.h {
    private HashMap<String, com.baidu.tieba.j.f> bJQ;
    private String fHU;
    private String fHV;

    /* loaded from: classes4.dex */
    private static class a {
        private static final com.baidu.tieba.j.h gKG = new j();
    }

    public static com.baidu.tieba.j.h btZ() {
        return a.gKG;
    }

    private j() {
        this.bJQ = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bdD() {
        this.fHU = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void aa(int i, String str) {
        bua().h(this.fHU, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ab(int i, String str) {
        bua().i(this.fHU, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ac(int i, String str) {
        bua().j(this.fHU, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bdE() {
        bua().sp(this.fHU);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        bua().e(this.fHU, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bdF() {
        bua().sq(this.fHU);
        dt(this.fHU);
    }

    @Override // com.baidu.tieba.j.h
    public void ad(int i, String str) {
        bua().k(this.fHU, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void su(String str) {
        if (!StringUtils.isNull(this.fHV)) {
            if (ss(this.fHV) || st(this.fHV)) {
                dt(this.fHV);
            } else {
                com.baidu.tieba.j.d.so(this.fHV);
                this.bJQ.remove(this.fHU);
            }
            bdD();
            bua().ch(this.fHV, str);
            this.fHV = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bdG() {
        this.fHV = this.fHU;
    }

    @Override // com.baidu.tieba.j.h
    public void sv(String str) {
        bua().ci(this.fHU, str);
        if (ss(this.fHU) || st(this.fHU)) {
            dt(this.fHU);
        } else {
            com.baidu.tieba.j.d.so(this.fHU);
            this.bJQ.remove(this.fHU);
        }
        this.fHU = null;
    }

    public boolean ss(String str) {
        return bua().ss(str);
    }

    public boolean st(String str) {
        return bua().st(str);
    }

    public void dt(String str) {
        com.baidu.tieba.j.f fVar = this.bJQ.get(str);
        if (fVar != null) {
            fVar.dt(str);
            this.bJQ.remove(str);
        }
    }

    private com.baidu.tieba.j.f bua() {
        com.baidu.tieba.j.f fVar = this.bJQ.get(this.fHU);
        if (fVar == null) {
            return bub();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bub() {
        i iVar = new i(this.fHU);
        this.bJQ.put(this.fHU, iVar);
        return iVar;
    }
}
