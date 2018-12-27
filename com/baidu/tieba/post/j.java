package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes4.dex */
public class j implements com.baidu.tieba.j.h {
    private HashMap<String, com.baidu.tieba.j.f> bJd;
    private String fHa;
    private String fHb;

    /* loaded from: classes4.dex */
    private static class a {
        private static final com.baidu.tieba.j.h gJC = new j();
    }

    public static com.baidu.tieba.j.h btq() {
        return a.gJC;
    }

    private j() {
        this.bJd = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bdd() {
        this.fHa = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void Y(int i, String str) {
        btr().h(this.fHa, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void Z(int i, String str) {
        btr().i(this.fHa, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aa(int i, String str) {
        btr().j(this.fHa, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bde() {
        btr().rZ(this.fHa);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        btr().e(this.fHa, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bdf() {
        btr().sa(this.fHa);
        ds(this.fHa);
    }

    @Override // com.baidu.tieba.j.h
    public void ab(int i, String str) {
        btr().k(this.fHa, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void sd(String str) {
        if (!StringUtils.isNull(this.fHb)) {
            if (sb(this.fHb) || sc(this.fHb)) {
                ds(this.fHb);
            } else {
                com.baidu.tieba.j.d.rY(this.fHb);
                this.bJd.remove(this.fHa);
            }
            bdd();
            btr().cg(this.fHb, str);
            this.fHb = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bdg() {
        this.fHb = this.fHa;
    }

    @Override // com.baidu.tieba.j.h
    public void se(String str) {
        btr().ch(this.fHa, str);
        if (sb(this.fHa) || sc(this.fHa)) {
            ds(this.fHa);
        } else {
            com.baidu.tieba.j.d.rY(this.fHa);
            this.bJd.remove(this.fHa);
        }
        this.fHa = null;
    }

    public boolean sb(String str) {
        return btr().sb(str);
    }

    public boolean sc(String str) {
        return btr().sc(str);
    }

    public void ds(String str) {
        com.baidu.tieba.j.f fVar = this.bJd.get(str);
        if (fVar != null) {
            fVar.ds(str);
            this.bJd.remove(str);
        }
    }

    private com.baidu.tieba.j.f btr() {
        com.baidu.tieba.j.f fVar = this.bJd.get(this.fHa);
        if (fVar == null) {
            return bts();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bts() {
        i iVar = new i(this.fHa);
        this.bJd.put(this.fHa, iVar);
        return iVar;
    }
}
