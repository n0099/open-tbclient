package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements com.baidu.tieba.j.h {
    private String gXV;
    private String gXW;
    private HashMap<String, com.baidu.tieba.j.f> ibR;

    /* loaded from: classes5.dex */
    private static class a {
        private static final com.baidu.tieba.j.h ibS = new j();
    }

    public static com.baidu.tieba.j.h bUK() {
        return a.ibS;
    }

    private j() {
        this.ibR = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bEd() {
        this.gXV = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void as(int i, String str) {
        bUL().k(this.gXV, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void at(int i, String str) {
        bUL().l(this.gXV, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void au(int i, String str) {
        bUL().m(this.gXV, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bEe() {
        bUL().yR(this.gXV);
    }

    @Override // com.baidu.tieba.j.h
    public void g(int i, int i2, String str) {
        bUL().e(this.gXV, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bEf() {
        bUL().yS(this.gXV);
        dh(this.gXV);
    }

    @Override // com.baidu.tieba.j.h
    public void av(int i, String str) {
        bUL().n(this.gXV, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void yV(String str) {
        if (!StringUtils.isNull(this.gXW)) {
            if (yT(this.gXW) || yU(this.gXW)) {
                dh(this.gXW);
            } else {
                com.baidu.tieba.j.d.yQ(this.gXW);
                this.ibR.remove(this.gXV);
            }
            bEd();
            bUL().dq(this.gXW, str);
            this.gXW = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bEg() {
        this.gXW = this.gXV;
    }

    @Override // com.baidu.tieba.j.h
    public void yW(String str) {
        bUL().dr(this.gXV, str);
        if (yT(this.gXV) || yU(this.gXV)) {
            dh(this.gXV);
        } else {
            com.baidu.tieba.j.d.yQ(this.gXV);
            this.ibR.remove(this.gXV);
        }
        this.gXV = null;
    }

    public boolean yT(String str) {
        return bUL().yT(str);
    }

    public boolean yU(String str) {
        return bUL().yU(str);
    }

    public void dh(String str) {
        com.baidu.tieba.j.f fVar = this.ibR.get(str);
        if (fVar != null) {
            fVar.dh(str);
            this.ibR.remove(str);
        }
    }

    private com.baidu.tieba.j.f bUL() {
        com.baidu.tieba.j.f fVar = this.ibR.get(this.gXV);
        if (fVar == null) {
            return bUM();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bUM() {
        i iVar = new i(this.gXV);
        this.ibR.put(this.gXV, iVar);
        return iVar;
    }
}
