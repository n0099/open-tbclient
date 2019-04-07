package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements com.baidu.tieba.j.h {
    private String gXU;
    private String gXV;
    private HashMap<String, com.baidu.tieba.j.f> ibQ;

    /* loaded from: classes5.dex */
    private static class a {
        private static final com.baidu.tieba.j.h ibR = new j();
    }

    public static com.baidu.tieba.j.h bUK() {
        return a.ibR;
    }

    private j() {
        this.ibQ = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bEd() {
        this.gXU = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void as(int i, String str) {
        bUL().k(this.gXU, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void at(int i, String str) {
        bUL().l(this.gXU, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void au(int i, String str) {
        bUL().m(this.gXU, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bEe() {
        bUL().yR(this.gXU);
    }

    @Override // com.baidu.tieba.j.h
    public void g(int i, int i2, String str) {
        bUL().e(this.gXU, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bEf() {
        bUL().yS(this.gXU);
        dh(this.gXU);
    }

    @Override // com.baidu.tieba.j.h
    public void av(int i, String str) {
        bUL().n(this.gXU, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void yV(String str) {
        if (!StringUtils.isNull(this.gXV)) {
            if (yT(this.gXV) || yU(this.gXV)) {
                dh(this.gXV);
            } else {
                com.baidu.tieba.j.d.yQ(this.gXV);
                this.ibQ.remove(this.gXU);
            }
            bEd();
            bUL().dq(this.gXV, str);
            this.gXV = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bEg() {
        this.gXV = this.gXU;
    }

    @Override // com.baidu.tieba.j.h
    public void yW(String str) {
        bUL().dr(this.gXU, str);
        if (yT(this.gXU) || yU(this.gXU)) {
            dh(this.gXU);
        } else {
            com.baidu.tieba.j.d.yQ(this.gXU);
            this.ibQ.remove(this.gXU);
        }
        this.gXU = null;
    }

    public boolean yT(String str) {
        return bUL().yT(str);
    }

    public boolean yU(String str) {
        return bUL().yU(str);
    }

    public void dh(String str) {
        com.baidu.tieba.j.f fVar = this.ibQ.get(str);
        if (fVar != null) {
            fVar.dh(str);
            this.ibQ.remove(str);
        }
    }

    private com.baidu.tieba.j.f bUL() {
        com.baidu.tieba.j.f fVar = this.ibQ.get(this.gXU);
        if (fVar == null) {
            return bUM();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bUM() {
        i iVar = new i(this.gXU);
        this.ibQ.put(this.gXU, iVar);
        return iVar;
    }
}
