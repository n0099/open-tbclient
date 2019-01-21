package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes4.dex */
public class j implements com.baidu.tieba.j.h {
    private HashMap<String, com.baidu.tieba.j.f> bJR;
    private String fHV;
    private String fHW;

    /* loaded from: classes4.dex */
    private static class a {
        private static final com.baidu.tieba.j.h gKH = new j();
    }

    public static com.baidu.tieba.j.h btZ() {
        return a.gKH;
    }

    private j() {
        this.bJR = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bdD() {
        this.fHV = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void aa(int i, String str) {
        bua().h(this.fHV, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ab(int i, String str) {
        bua().i(this.fHV, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ac(int i, String str) {
        bua().j(this.fHV, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bdE() {
        bua().sp(this.fHV);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        bua().e(this.fHV, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bdF() {
        bua().sq(this.fHV);
        dt(this.fHV);
    }

    @Override // com.baidu.tieba.j.h
    public void ad(int i, String str) {
        bua().k(this.fHV, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void su(String str) {
        if (!StringUtils.isNull(this.fHW)) {
            if (ss(this.fHW) || st(this.fHW)) {
                dt(this.fHW);
            } else {
                com.baidu.tieba.j.d.so(this.fHW);
                this.bJR.remove(this.fHV);
            }
            bdD();
            bua().ch(this.fHW, str);
            this.fHW = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bdG() {
        this.fHW = this.fHV;
    }

    @Override // com.baidu.tieba.j.h
    public void sv(String str) {
        bua().ci(this.fHV, str);
        if (ss(this.fHV) || st(this.fHV)) {
            dt(this.fHV);
        } else {
            com.baidu.tieba.j.d.so(this.fHV);
            this.bJR.remove(this.fHV);
        }
        this.fHV = null;
    }

    public boolean ss(String str) {
        return bua().ss(str);
    }

    public boolean st(String str) {
        return bua().st(str);
    }

    public void dt(String str) {
        com.baidu.tieba.j.f fVar = this.bJR.get(str);
        if (fVar != null) {
            fVar.dt(str);
            this.bJR.remove(str);
        }
    }

    private com.baidu.tieba.j.f bua() {
        com.baidu.tieba.j.f fVar = this.bJR.get(this.fHV);
        if (fVar == null) {
            return bub();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bub() {
        i iVar = new i(this.fHV);
        this.bJR.put(this.fHV, iVar);
        return iVar;
    }
}
