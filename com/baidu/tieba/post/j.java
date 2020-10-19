package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes23.dex */
public class j implements com.baidu.tieba.k.h {
    private HashMap<String, com.baidu.tieba.k.f> Ab;
    private String kFi;
    private String mUuid;

    /* loaded from: classes23.dex */
    private static class a {
        private static final com.baidu.tieba.k.h lVv = new j();
    }

    public static com.baidu.tieba.k.h dsz() {
        return a.lVv;
    }

    private j() {
        this.Ab = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void cYs() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void bA(int i, String str) {
        dsA().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bB(int i, String str) {
        dsA().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bC(int i, String str) {
        dsA().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cYt() {
        dsA().NS(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void n(int i, int i2, String str) {
        dsA().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cYu() {
        dsA().NT(this.mUuid);
        jm(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void bD(int i, String str) {
        dsA().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void NW(String str) {
        if (!StringUtils.isNull(this.kFi)) {
            if (NU(this.kFi) || NV(this.kFi)) {
                jm(this.kFi);
            } else {
                com.baidu.tieba.k.d.NR(this.kFi);
                this.Ab.remove(this.mUuid);
            }
            cYs();
            dsA().fD(this.kFi, str);
            this.kFi = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void cYv() {
        this.kFi = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void NX(String str) {
        dsA().fE(this.mUuid, str);
        if (NU(this.mUuid) || NV(this.mUuid)) {
            jm(this.mUuid);
        } else {
            com.baidu.tieba.k.d.NR(this.mUuid);
            this.Ab.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean NU(String str) {
        return dsA().NU(str);
    }

    public boolean NV(String str) {
        return dsA().NV(str);
    }

    public void jm(String str) {
        com.baidu.tieba.k.f fVar = this.Ab.get(str);
        if (fVar != null) {
            fVar.jm(str);
            this.Ab.remove(str);
        }
    }

    private com.baidu.tieba.k.f dsA() {
        com.baidu.tieba.k.f fVar = this.Ab.get(this.mUuid);
        if (fVar == null) {
            return dsB();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f dsB() {
        i iVar = new i(this.mUuid);
        this.Ab.put(this.mUuid, iVar);
        return iVar;
    }
}
