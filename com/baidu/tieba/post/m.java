package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class m implements com.baidu.tieba.i.h {
    private String fvI;
    private String fvJ;
    private HashMap<String, com.baidu.tieba.i.f> gxF;

    /* loaded from: classes2.dex */
    private static class a {
        private static final com.baidu.tieba.i.h gxG = new m();
    }

    public static com.baidu.tieba.i.h bmw() {
        return a.gxG;
    }

    private m() {
        this.gxF = new HashMap<>();
    }

    @Override // com.baidu.tieba.i.h
    public void aWM() {
        this.fvI = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.i.h
    public void U(int i, String str) {
        bmx().i(this.fvI, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void V(int i, String str) {
        bmx().j(this.fvI, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void W(int i, String str) {
        bmx().k(this.fvI, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aWN() {
        bmx().pv(this.fvI);
    }

    @Override // com.baidu.tieba.i.h
    public void h(int i, int i2, String str) {
        bmx().e(this.fvI, i, i2, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aWO() {
        bmx().pw(this.fvI);
        px(this.fvI);
    }

    @Override // com.baidu.tieba.i.h
    public void X(int i, String str) {
        bmx().l(this.fvI, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void pA(String str) {
        if (!StringUtils.isNull(this.fvJ)) {
            if (py(this.fvJ) || pz(this.fvJ)) {
                px(this.fvJ);
            } else {
                com.baidu.tieba.i.d.pu(this.fvJ);
                this.gxF.remove(this.fvI);
            }
            aWM();
            bmx().bz(this.fvJ, str);
            this.fvJ = null;
        }
    }

    @Override // com.baidu.tieba.i.h
    public void aWP() {
        this.fvJ = this.fvI;
    }

    @Override // com.baidu.tieba.i.h
    public void pB(String str) {
        bmx().bA(this.fvI, str);
        if (py(this.fvI) || pz(this.fvI)) {
            px(this.fvI);
        } else {
            com.baidu.tieba.i.d.pu(this.fvI);
            this.gxF.remove(this.fvI);
        }
        this.fvI = null;
    }

    public boolean py(String str) {
        return bmx().py(str);
    }

    public boolean pz(String str) {
        return bmx().pz(str);
    }

    public void px(String str) {
        com.baidu.tieba.i.f fVar = this.gxF.get(str);
        if (fVar != null) {
            fVar.px(str);
            this.gxF.remove(str);
        }
    }

    private com.baidu.tieba.i.f bmx() {
        com.baidu.tieba.i.f fVar = this.gxF.get(this.fvI);
        if (fVar == null) {
            return bmy();
        }
        return fVar;
    }

    private com.baidu.tieba.i.f bmy() {
        l lVar = new l(this.fvI);
        this.gxF.put(this.fvI, lVar);
        return lVar;
    }
}
