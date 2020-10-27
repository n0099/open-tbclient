package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes23.dex */
public class j implements com.baidu.tieba.k.h {
    private HashMap<String, com.baidu.tieba.k.f> Ab;
    private String kRF;
    private String mUuid;

    /* loaded from: classes23.dex */
    private static class a {
        private static final com.baidu.tieba.k.h mhU = new j();
    }

    public static com.baidu.tieba.k.h dvG() {
        return a.mhU;
    }

    private j() {
        this.Ab = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void dbA() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void bB(int i, String str) {
        dvH().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bC(int i, String str) {
        dvH().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bD(int i, String str) {
        dvH().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void dbB() {
        dvH().Oq(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void o(int i, int i2, String str) {
        dvH().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void dbC() {
        dvH().Or(this.mUuid);
        jF(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void bE(int i, String str) {
        dvH().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void Ou(String str) {
        if (!StringUtils.isNull(this.kRF)) {
            if (Os(this.kRF) || Ot(this.kRF)) {
                jF(this.kRF);
            } else {
                com.baidu.tieba.k.d.Op(this.kRF);
                this.Ab.remove(this.mUuid);
            }
            dbA();
            dvH().fI(this.kRF, str);
            this.kRF = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void dbD() {
        this.kRF = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void Ov(String str) {
        dvH().fJ(this.mUuid, str);
        if (Os(this.mUuid) || Ot(this.mUuid)) {
            jF(this.mUuid);
        } else {
            com.baidu.tieba.k.d.Op(this.mUuid);
            this.Ab.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean Os(String str) {
        return dvH().Os(str);
    }

    public boolean Ot(String str) {
        return dvH().Ot(str);
    }

    public void jF(String str) {
        com.baidu.tieba.k.f fVar = this.Ab.get(str);
        if (fVar != null) {
            fVar.jF(str);
            this.Ab.remove(str);
        }
    }

    private com.baidu.tieba.k.f dvH() {
        com.baidu.tieba.k.f fVar = this.Ab.get(this.mUuid);
        if (fVar == null) {
            return dvI();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f dvI() {
        i iVar = new i(this.mUuid);
        this.Ab.put(this.mUuid, iVar);
        return iVar;
    }
}
