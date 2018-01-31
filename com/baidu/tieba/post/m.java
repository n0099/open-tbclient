package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i.d;
import com.baidu.tieba.i.f;
import com.baidu.tieba.i.h;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class m implements h {
    private String fst;
    private String fsu;
    private HashMap<String, f> gwl;

    /* loaded from: classes2.dex */
    private static class a {
        private static final h gwm = new m();
    }

    public static h blk() {
        return a.gwm;
    }

    private m() {
        this.gwl = new HashMap<>();
    }

    @Override // com.baidu.tieba.i.h
    public void aVe() {
        this.fst = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.i.h
    public void T(int i, String str) {
        bll().i(this.fst, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void U(int i, String str) {
        bll().j(this.fst, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void V(int i, String str) {
        bll().k(this.fst, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aVf() {
        bll().pm(this.fst);
    }

    @Override // com.baidu.tieba.i.h
    public void h(int i, int i2, String str) {
        bll().d(this.fst, i, i2, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aVg() {
        bll().pn(this.fst);
        po(this.fst);
    }

    @Override // com.baidu.tieba.i.h
    public void W(int i, String str) {
        bll().l(this.fst, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void pr(String str) {
        if (!StringUtils.isNull(this.fsu)) {
            if (pp(this.fsu) || pq(this.fsu)) {
                po(this.fsu);
            } else {
                d.pl(this.fsu);
                this.gwl.remove(this.fst);
            }
            aVe();
            bll().by(this.fsu, str);
            this.fsu = null;
        }
    }

    @Override // com.baidu.tieba.i.h
    public void aVh() {
        this.fsu = this.fst;
    }

    @Override // com.baidu.tieba.i.h
    public void ps(String str) {
        bll().bz(this.fst, str);
        if (pp(this.fst) || pq(this.fst)) {
            po(this.fst);
        } else {
            d.pl(this.fst);
            this.gwl.remove(this.fst);
        }
        this.fst = null;
    }

    public boolean pp(String str) {
        return bll().pp(str);
    }

    public boolean pq(String str) {
        return bll().pq(str);
    }

    public void po(String str) {
        f fVar = this.gwl.get(str);
        if (fVar != null) {
            fVar.po(str);
            this.gwl.remove(str);
        }
    }

    private f bll() {
        f fVar = this.gwl.get(this.fst);
        if (fVar == null) {
            return blm();
        }
        return fVar;
    }

    private f blm() {
        l lVar = new l(this.fst);
        this.gwl.put(this.fst, lVar);
        return lVar;
    }
}
