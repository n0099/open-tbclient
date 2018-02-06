package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class m implements com.baidu.tieba.i.h {
    private String fvU;
    private String fvV;
    private HashMap<String, com.baidu.tieba.i.f> gxQ;

    /* loaded from: classes2.dex */
    private static class a {
        private static final com.baidu.tieba.i.h gxR = new m();
    }

    public static com.baidu.tieba.i.h bmx() {
        return a.gxR;
    }

    private m() {
        this.gxQ = new HashMap<>();
    }

    @Override // com.baidu.tieba.i.h
    public void aWN() {
        this.fvU = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.i.h
    public void U(int i, String str) {
        bmy().i(this.fvU, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void V(int i, String str) {
        bmy().j(this.fvU, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void W(int i, String str) {
        bmy().k(this.fvU, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aWO() {
        bmy().pv(this.fvU);
    }

    @Override // com.baidu.tieba.i.h
    public void h(int i, int i2, String str) {
        bmy().e(this.fvU, i, i2, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aWP() {
        bmy().pw(this.fvU);
        px(this.fvU);
    }

    @Override // com.baidu.tieba.i.h
    public void X(int i, String str) {
        bmy().l(this.fvU, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void pA(String str) {
        if (!StringUtils.isNull(this.fvV)) {
            if (py(this.fvV) || pz(this.fvV)) {
                px(this.fvV);
            } else {
                com.baidu.tieba.i.d.pu(this.fvV);
                this.gxQ.remove(this.fvU);
            }
            aWN();
            bmy().bz(this.fvV, str);
            this.fvV = null;
        }
    }

    @Override // com.baidu.tieba.i.h
    public void aWQ() {
        this.fvV = this.fvU;
    }

    @Override // com.baidu.tieba.i.h
    public void pB(String str) {
        bmy().bA(this.fvU, str);
        if (py(this.fvU) || pz(this.fvU)) {
            px(this.fvU);
        } else {
            com.baidu.tieba.i.d.pu(this.fvU);
            this.gxQ.remove(this.fvU);
        }
        this.fvU = null;
    }

    public boolean py(String str) {
        return bmy().py(str);
    }

    public boolean pz(String str) {
        return bmy().pz(str);
    }

    public void px(String str) {
        com.baidu.tieba.i.f fVar = this.gxQ.get(str);
        if (fVar != null) {
            fVar.px(str);
            this.gxQ.remove(str);
        }
    }

    private com.baidu.tieba.i.f bmy() {
        com.baidu.tieba.i.f fVar = this.gxQ.get(this.fvU);
        if (fVar == null) {
            return bmz();
        }
        return fVar;
    }

    private com.baidu.tieba.i.f bmz() {
        l lVar = new l(this.fvU);
        this.gxQ.put(this.fvU, lVar);
        return lVar;
    }
}
