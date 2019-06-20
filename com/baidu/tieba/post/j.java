package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements com.baidu.tieba.j.h {
    private String hpq;
    private String hpr;
    private HashMap<String, com.baidu.tieba.j.f> iuz;

    /* loaded from: classes5.dex */
    private static class a {
        private static final com.baidu.tieba.j.h iuA = new j();
    }

    public static com.baidu.tieba.j.h ccO() {
        return a.iuA;
    }

    private j() {
        this.iuz = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bLS() {
        this.hpq = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void av(int i, String str) {
        ccP().o(this.hpq, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aw(int i, String str) {
        ccP().p(this.hpq, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ax(int i, String str) {
        ccP().q(this.hpq, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bLT() {
        ccP().Aj(this.hpq);
    }

    @Override // com.baidu.tieba.j.h
    public void h(int i, int i2, String str) {
        ccP().e(this.hpq, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bLU() {
        ccP().Ak(this.hpq);
        cT(this.hpq);
    }

    @Override // com.baidu.tieba.j.h
    public void ay(int i, String str) {
        ccP().r(this.hpq, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void An(String str) {
        if (!StringUtils.isNull(this.hpr)) {
            if (Al(this.hpr) || Am(this.hpr)) {
                cT(this.hpr);
            } else {
                com.baidu.tieba.j.d.Ai(this.hpr);
                this.iuz.remove(this.hpq);
            }
            bLS();
            ccP().dC(this.hpr, str);
            this.hpr = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bLV() {
        this.hpr = this.hpq;
    }

    @Override // com.baidu.tieba.j.h
    public void Ao(String str) {
        ccP().dD(this.hpq, str);
        if (Al(this.hpq) || Am(this.hpq)) {
            cT(this.hpq);
        } else {
            com.baidu.tieba.j.d.Ai(this.hpq);
            this.iuz.remove(this.hpq);
        }
        this.hpq = null;
    }

    public boolean Al(String str) {
        return ccP().Al(str);
    }

    public boolean Am(String str) {
        return ccP().Am(str);
    }

    public void cT(String str) {
        com.baidu.tieba.j.f fVar = this.iuz.get(str);
        if (fVar != null) {
            fVar.cT(str);
            this.iuz.remove(str);
        }
    }

    private com.baidu.tieba.j.f ccP() {
        com.baidu.tieba.j.f fVar = this.iuz.get(this.hpq);
        if (fVar == null) {
            return ccQ();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f ccQ() {
        i iVar = new i(this.hpq);
        this.iuz.put(this.hpq, iVar);
        return iVar;
    }
}
