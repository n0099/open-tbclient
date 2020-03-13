package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes10.dex */
public class j implements com.baidu.tieba.k.h {
    private HashMap<String, com.baidu.tieba.k.f> cR;
    private String iqg;
    private String mUuid;

    /* loaded from: classes10.dex */
    private static class a {
        private static final com.baidu.tieba.k.h jAM = new j();
    }

    public static com.baidu.tieba.k.h cAj() {
        return a.jAM;
    }

    private j() {
        this.cR = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void cgB() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void aP(int i, String str) {
        cAk().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void aQ(int i, String str) {
        cAk().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void aR(int i, String str) {
        cAk().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cgC() {
        cAk().EX(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void l(int i, int i2, String str) {
        cAk().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cgD() {
        cAk().EY(this.mUuid);
        eU(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void aS(int i, String str) {
        cAk().t(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void Fb(String str) {
        if (!StringUtils.isNull(this.iqg)) {
            if (EZ(this.iqg) || Fa(this.iqg)) {
                eU(this.iqg);
            } else {
                com.baidu.tieba.k.d.EW(this.iqg);
                this.cR.remove(this.mUuid);
            }
            cgB();
            cAk().dV(this.iqg, str);
            this.iqg = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void cgE() {
        this.iqg = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void Fc(String str) {
        cAk().dW(this.mUuid, str);
        if (EZ(this.mUuid) || Fa(this.mUuid)) {
            eU(this.mUuid);
        } else {
            com.baidu.tieba.k.d.EW(this.mUuid);
            this.cR.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean EZ(String str) {
        return cAk().EZ(str);
    }

    public boolean Fa(String str) {
        return cAk().Fa(str);
    }

    public void eU(String str) {
        com.baidu.tieba.k.f fVar = this.cR.get(str);
        if (fVar != null) {
            fVar.eU(str);
            this.cR.remove(str);
        }
    }

    private com.baidu.tieba.k.f cAk() {
        com.baidu.tieba.k.f fVar = this.cR.get(this.mUuid);
        if (fVar == null) {
            return cAl();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f cAl() {
        i iVar = new i(this.mUuid);
        this.cR.put(this.mUuid, iVar);
        return iVar;
    }
}
