package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements com.baidu.tieba.j.h {
    private String hyo;
    private String hyp;
    private HashMap<String, com.baidu.tieba.j.f> iEm;

    /* loaded from: classes5.dex */
    private static class a {
        private static final com.baidu.tieba.j.h iEn = new j();
    }

    public static com.baidu.tieba.j.h cgL() {
        return a.iEn;
    }

    private j() {
        this.iEm = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bPB() {
        this.hyo = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void av(int i, String str) {
        cgM().o(this.hyo, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aw(int i, String str) {
        cgM().p(this.hyo, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ax(int i, String str) {
        cgM().q(this.hyo, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bPC() {
        cgM().Bu(this.hyo);
    }

    @Override // com.baidu.tieba.j.h
    public void h(int i, int i2, String str) {
        cgM().e(this.hyo, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bPD() {
        cgM().Bv(this.hyo);
        da(this.hyo);
    }

    @Override // com.baidu.tieba.j.h
    public void ay(int i, String str) {
        cgM().r(this.hyo, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void By(String str) {
        if (!StringUtils.isNull(this.hyp)) {
            if (Bw(this.hyp) || Bx(this.hyp)) {
                da(this.hyp);
            } else {
                com.baidu.tieba.j.d.Bt(this.hyp);
                this.iEm.remove(this.hyo);
            }
            bPB();
            cgM().dF(this.hyp, str);
            this.hyp = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bPE() {
        this.hyp = this.hyo;
    }

    @Override // com.baidu.tieba.j.h
    public void Bz(String str) {
        cgM().dG(this.hyo, str);
        if (Bw(this.hyo) || Bx(this.hyo)) {
            da(this.hyo);
        } else {
            com.baidu.tieba.j.d.Bt(this.hyo);
            this.iEm.remove(this.hyo);
        }
        this.hyo = null;
    }

    public boolean Bw(String str) {
        return cgM().Bw(str);
    }

    public boolean Bx(String str) {
        return cgM().Bx(str);
    }

    public void da(String str) {
        com.baidu.tieba.j.f fVar = this.iEm.get(str);
        if (fVar != null) {
            fVar.da(str);
            this.iEm.remove(str);
        }
    }

    private com.baidu.tieba.j.f cgM() {
        com.baidu.tieba.j.f fVar = this.iEm.get(this.hyo);
        if (fVar == null) {
            return cgN();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f cgN() {
        i iVar = new i(this.hyo);
        this.iEm.put(this.hyo, iVar);
        return iVar;
    }
}
