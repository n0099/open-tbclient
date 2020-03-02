package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes10.dex */
public class j implements com.baidu.tieba.k.h {
    private HashMap<String, com.baidu.tieba.k.f> cR;
    private String ipU;
    private String mUuid;

    /* loaded from: classes10.dex */
    private static class a {
        private static final com.baidu.tieba.k.h jAA = new j();
    }

    public static com.baidu.tieba.k.h cAi() {
        return a.jAA;
    }

    private j() {
        this.cR = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void cgA() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void aP(int i, String str) {
        cAj().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void aQ(int i, String str) {
        cAj().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void aR(int i, String str) {
        cAj().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cgB() {
        cAj().EW(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void l(int i, int i2, String str) {
        cAj().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cgC() {
        cAj().EX(this.mUuid);
        eU(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void aS(int i, String str) {
        cAj().t(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void Fa(String str) {
        if (!StringUtils.isNull(this.ipU)) {
            if (EY(this.ipU) || EZ(this.ipU)) {
                eU(this.ipU);
            } else {
                com.baidu.tieba.k.d.EV(this.ipU);
                this.cR.remove(this.mUuid);
            }
            cgA();
            cAj().dV(this.ipU, str);
            this.ipU = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void cgD() {
        this.ipU = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void Fb(String str) {
        cAj().dW(this.mUuid, str);
        if (EY(this.mUuid) || EZ(this.mUuid)) {
            eU(this.mUuid);
        } else {
            com.baidu.tieba.k.d.EV(this.mUuid);
            this.cR.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean EY(String str) {
        return cAj().EY(str);
    }

    public boolean EZ(String str) {
        return cAj().EZ(str);
    }

    public void eU(String str) {
        com.baidu.tieba.k.f fVar = this.cR.get(str);
        if (fVar != null) {
            fVar.eU(str);
            this.cR.remove(str);
        }
    }

    private com.baidu.tieba.k.f cAj() {
        com.baidu.tieba.k.f fVar = this.cR.get(this.mUuid);
        if (fVar == null) {
            return cAk();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f cAk() {
        i iVar = new i(this.mUuid);
        this.cR.put(this.mUuid, iVar);
        return iVar;
    }
}
