package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements com.baidu.tieba.j.h {
    private String gYh;
    private String gYi;
    private HashMap<String, com.baidu.tieba.j.f> ice;

    /* loaded from: classes5.dex */
    private static class a {
        private static final com.baidu.tieba.j.h icf = new j();
    }

    public static com.baidu.tieba.j.h bUO() {
        return a.icf;
    }

    private j() {
        this.ice = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bEg() {
        this.gYh = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void aq(int i, String str) {
        bUP().k(this.gYh, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ar(int i, String str) {
        bUP().l(this.gYh, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void as(int i, String str) {
        bUP().m(this.gYh, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bEh() {
        bUP().yS(this.gYh);
    }

    @Override // com.baidu.tieba.j.h
    public void g(int i, int i2, String str) {
        bUP().e(this.gYh, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bEi() {
        bUP().yT(this.gYh);
        df(this.gYh);
    }

    @Override // com.baidu.tieba.j.h
    public void at(int i, String str) {
        bUP().n(this.gYh, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void yW(String str) {
        if (!StringUtils.isNull(this.gYi)) {
            if (yU(this.gYi) || yV(this.gYi)) {
                df(this.gYi);
            } else {
                com.baidu.tieba.j.d.yR(this.gYi);
                this.ice.remove(this.gYh);
            }
            bEg();
            bUP().dp(this.gYi, str);
            this.gYi = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bEj() {
        this.gYi = this.gYh;
    }

    @Override // com.baidu.tieba.j.h
    public void yX(String str) {
        bUP().dq(this.gYh, str);
        if (yU(this.gYh) || yV(this.gYh)) {
            df(this.gYh);
        } else {
            com.baidu.tieba.j.d.yR(this.gYh);
            this.ice.remove(this.gYh);
        }
        this.gYh = null;
    }

    public boolean yU(String str) {
        return bUP().yU(str);
    }

    public boolean yV(String str) {
        return bUP().yV(str);
    }

    public void df(String str) {
        com.baidu.tieba.j.f fVar = this.ice.get(str);
        if (fVar != null) {
            fVar.df(str);
            this.ice.remove(str);
        }
    }

    private com.baidu.tieba.j.f bUP() {
        com.baidu.tieba.j.f fVar = this.ice.get(this.gYh);
        if (fVar == null) {
            return bUQ();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bUQ() {
        i iVar = new i(this.gYh);
        this.ice.put(this.gYh, iVar);
        return iVar;
    }
}
