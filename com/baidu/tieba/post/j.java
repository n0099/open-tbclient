package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes10.dex */
public class j implements com.baidu.tieba.k.h {
    private HashMap<String, com.baidu.tieba.k.f> cQ;
    private String irG;
    private String mUuid;

    /* loaded from: classes10.dex */
    private static class a {
        private static final com.baidu.tieba.k.h jCl = new j();
    }

    public static com.baidu.tieba.k.h cAD() {
        return a.jCl;
    }

    private j() {
        this.cQ = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void cgV() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void aP(int i, String str) {
        cAE().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void aQ(int i, String str) {
        cAE().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void aR(int i, String str) {
        cAE().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cgW() {
        cAE().EX(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void l(int i, int i2, String str) {
        cAE().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cgX() {
        cAE().EY(this.mUuid);
        eT(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void aS(int i, String str) {
        cAE().t(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void Fb(String str) {
        if (!StringUtils.isNull(this.irG)) {
            if (EZ(this.irG) || Fa(this.irG)) {
                eT(this.irG);
            } else {
                com.baidu.tieba.k.d.EW(this.irG);
                this.cQ.remove(this.mUuid);
            }
            cgV();
            cAE().dT(this.irG, str);
            this.irG = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void cgY() {
        this.irG = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void Fc(String str) {
        cAE().dU(this.mUuid, str);
        if (EZ(this.mUuid) || Fa(this.mUuid)) {
            eT(this.mUuid);
        } else {
            com.baidu.tieba.k.d.EW(this.mUuid);
            this.cQ.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean EZ(String str) {
        return cAE().EZ(str);
    }

    public boolean Fa(String str) {
        return cAE().Fa(str);
    }

    public void eT(String str) {
        com.baidu.tieba.k.f fVar = this.cQ.get(str);
        if (fVar != null) {
            fVar.eT(str);
            this.cQ.remove(str);
        }
    }

    private com.baidu.tieba.k.f cAE() {
        com.baidu.tieba.k.f fVar = this.cQ.get(this.mUuid);
        if (fVar == null) {
            return cAF();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f cAF() {
        i iVar = new i(this.mUuid);
        this.cQ.put(this.mUuid, iVar);
        return iVar;
    }
}
