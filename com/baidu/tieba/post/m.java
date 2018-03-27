package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class m implements com.baidu.tieba.i.h {
    private String fvY;
    private String fvZ;
    private HashMap<String, com.baidu.tieba.i.f> gxV;

    /* loaded from: classes2.dex */
    private static class a {
        private static final com.baidu.tieba.i.h gxW = new m();
    }

    public static com.baidu.tieba.i.h bmx() {
        return a.gxW;
    }

    private m() {
        this.gxV = new HashMap<>();
    }

    @Override // com.baidu.tieba.i.h
    public void aWN() {
        this.fvY = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.i.h
    public void U(int i, String str) {
        bmy().i(this.fvY, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void V(int i, String str) {
        bmy().j(this.fvY, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void W(int i, String str) {
        bmy().k(this.fvY, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aWO() {
        bmy().pv(this.fvY);
    }

    @Override // com.baidu.tieba.i.h
    public void h(int i, int i2, String str) {
        bmy().e(this.fvY, i, i2, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aWP() {
        bmy().pw(this.fvY);
        px(this.fvY);
    }

    @Override // com.baidu.tieba.i.h
    public void X(int i, String str) {
        bmy().l(this.fvY, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void pA(String str) {
        if (!StringUtils.isNull(this.fvZ)) {
            if (py(this.fvZ) || pz(this.fvZ)) {
                px(this.fvZ);
            } else {
                com.baidu.tieba.i.d.pu(this.fvZ);
                this.gxV.remove(this.fvY);
            }
            aWN();
            bmy().bz(this.fvZ, str);
            this.fvZ = null;
        }
    }

    @Override // com.baidu.tieba.i.h
    public void aWQ() {
        this.fvZ = this.fvY;
    }

    @Override // com.baidu.tieba.i.h
    public void pB(String str) {
        bmy().bA(this.fvY, str);
        if (py(this.fvY) || pz(this.fvY)) {
            px(this.fvY);
        } else {
            com.baidu.tieba.i.d.pu(this.fvY);
            this.gxV.remove(this.fvY);
        }
        this.fvY = null;
    }

    public boolean py(String str) {
        return bmy().py(str);
    }

    public boolean pz(String str) {
        return bmy().pz(str);
    }

    public void px(String str) {
        com.baidu.tieba.i.f fVar = this.gxV.get(str);
        if (fVar != null) {
            fVar.px(str);
            this.gxV.remove(str);
        }
    }

    private com.baidu.tieba.i.f bmy() {
        com.baidu.tieba.i.f fVar = this.gxV.get(this.fvY);
        if (fVar == null) {
            return bmz();
        }
        return fVar;
    }

    private com.baidu.tieba.i.f bmz() {
        l lVar = new l(this.fvY);
        this.gxV.put(this.fvY, lVar);
        return lVar;
    }
}
