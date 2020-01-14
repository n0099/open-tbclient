package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes8.dex */
public class j implements com.baidu.tieba.j.h {
    private HashMap<String, com.baidu.tieba.j.f> cQ;
    private String inT;
    private String mUuid;

    /* loaded from: classes8.dex */
    private static class a {
        private static final com.baidu.tieba.j.h jzI = new j();
    }

    public static com.baidu.tieba.j.h cyL() {
        return a.jzI;
    }

    private j() {
        this.cQ = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void ceU() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void aP(int i, String str) {
        cyM().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aQ(int i, String str) {
        cyM().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aR(int i, String str) {
        cyM().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ceV() {
        cyM().EG(this.mUuid);
    }

    @Override // com.baidu.tieba.j.h
    public void l(int i, int i2, String str) {
        cyM().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ceW() {
        cyM().EH(this.mUuid);
        eE(this.mUuid);
    }

    @Override // com.baidu.tieba.j.h
    public void aS(int i, String str) {
        cyM().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void EK(String str) {
        if (!StringUtils.isNull(this.inT)) {
            if (EI(this.inT) || EJ(this.inT)) {
                eE(this.inT);
            } else {
                com.baidu.tieba.j.d.EF(this.inT);
                this.cQ.remove(this.mUuid);
            }
            ceU();
            cyM().dM(this.inT, str);
            this.inT = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void ceX() {
        this.inT = this.mUuid;
    }

    @Override // com.baidu.tieba.j.h
    public void EL(String str) {
        cyM().dN(this.mUuid, str);
        if (EI(this.mUuid) || EJ(this.mUuid)) {
            eE(this.mUuid);
        } else {
            com.baidu.tieba.j.d.EF(this.mUuid);
            this.cQ.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean EI(String str) {
        return cyM().EI(str);
    }

    public boolean EJ(String str) {
        return cyM().EJ(str);
    }

    public void eE(String str) {
        com.baidu.tieba.j.f fVar = this.cQ.get(str);
        if (fVar != null) {
            fVar.eE(str);
            this.cQ.remove(str);
        }
    }

    private com.baidu.tieba.j.f cyM() {
        com.baidu.tieba.j.f fVar = this.cQ.get(this.mUuid);
        if (fVar == null) {
            return cyN();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f cyN() {
        i iVar = new i(this.mUuid);
        this.cQ.put(this.mUuid, iVar);
        return iVar;
    }
}
