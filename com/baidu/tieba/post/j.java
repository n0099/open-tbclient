package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes4.dex */
public class j implements com.baidu.tieba.j.h {
    private HashMap<String, com.baidu.tieba.j.f> bJa;
    private String fEi;
    private String fEj;

    /* loaded from: classes4.dex */
    private static class a {
        private static final com.baidu.tieba.j.h gGL = new j();
    }

    public static com.baidu.tieba.j.h bsF() {
        return a.gGL;
    }

    private j() {
        this.bJa = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bcq() {
        this.fEi = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void X(int i, String str) {
        bsG().h(this.fEi, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void Y(int i, String str) {
        bsG().i(this.fEi, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void Z(int i, String str) {
        bsG().j(this.fEi, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bcr() {
        bsG().rW(this.fEi);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        bsG().e(this.fEi, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bcs() {
        bsG().rX(this.fEi);
        ds(this.fEi);
    }

    @Override // com.baidu.tieba.j.h
    public void aa(int i, String str) {
        bsG().k(this.fEi, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void sa(String str) {
        if (!StringUtils.isNull(this.fEj)) {
            if (rY(this.fEj) || rZ(this.fEj)) {
                ds(this.fEj);
            } else {
                com.baidu.tieba.j.d.rV(this.fEj);
                this.bJa.remove(this.fEi);
            }
            bcq();
            bsG().cg(this.fEj, str);
            this.fEj = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bct() {
        this.fEj = this.fEi;
    }

    @Override // com.baidu.tieba.j.h
    public void sb(String str) {
        bsG().ch(this.fEi, str);
        if (rY(this.fEi) || rZ(this.fEi)) {
            ds(this.fEi);
        } else {
            com.baidu.tieba.j.d.rV(this.fEi);
            this.bJa.remove(this.fEi);
        }
        this.fEi = null;
    }

    public boolean rY(String str) {
        return bsG().rY(str);
    }

    public boolean rZ(String str) {
        return bsG().rZ(str);
    }

    public void ds(String str) {
        com.baidu.tieba.j.f fVar = this.bJa.get(str);
        if (fVar != null) {
            fVar.ds(str);
            this.bJa.remove(str);
        }
    }

    private com.baidu.tieba.j.f bsG() {
        com.baidu.tieba.j.f fVar = this.bJa.get(this.fEi);
        if (fVar == null) {
            return bsH();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bsH() {
        i iVar = new i(this.fEi);
        this.bJa.put(this.fEi, iVar);
        return iVar;
    }
}
