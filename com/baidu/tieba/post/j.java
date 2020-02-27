package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes10.dex */
public class j implements com.baidu.tieba.k.h {
    private HashMap<String, com.baidu.tieba.k.f> cR;
    private String ipS;
    private String mUuid;

    /* loaded from: classes10.dex */
    private static class a {
        private static final com.baidu.tieba.k.h jAy = new j();
    }

    public static com.baidu.tieba.k.h cAg() {
        return a.jAy;
    }

    private j() {
        this.cR = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void cgy() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void aP(int i, String str) {
        cAh().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void aQ(int i, String str) {
        cAh().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void aR(int i, String str) {
        cAh().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cgz() {
        cAh().EW(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void l(int i, int i2, String str) {
        cAh().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cgA() {
        cAh().EX(this.mUuid);
        eU(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void aS(int i, String str) {
        cAh().t(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void Fa(String str) {
        if (!StringUtils.isNull(this.ipS)) {
            if (EY(this.ipS) || EZ(this.ipS)) {
                eU(this.ipS);
            } else {
                com.baidu.tieba.k.d.EV(this.ipS);
                this.cR.remove(this.mUuid);
            }
            cgy();
            cAh().dV(this.ipS, str);
            this.ipS = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void cgB() {
        this.ipS = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void Fb(String str) {
        cAh().dW(this.mUuid, str);
        if (EY(this.mUuid) || EZ(this.mUuid)) {
            eU(this.mUuid);
        } else {
            com.baidu.tieba.k.d.EV(this.mUuid);
            this.cR.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean EY(String str) {
        return cAh().EY(str);
    }

    public boolean EZ(String str) {
        return cAh().EZ(str);
    }

    public void eU(String str) {
        com.baidu.tieba.k.f fVar = this.cR.get(str);
        if (fVar != null) {
            fVar.eU(str);
            this.cR.remove(str);
        }
    }

    private com.baidu.tieba.k.f cAh() {
        com.baidu.tieba.k.f fVar = this.cR.get(this.mUuid);
        if (fVar == null) {
            return cAi();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f cAi() {
        i iVar = new i(this.mUuid);
        this.cR.put(this.mUuid, iVar);
        return iVar;
    }
}
