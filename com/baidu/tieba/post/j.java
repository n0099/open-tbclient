package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes23.dex */
public class j implements com.baidu.tieba.l.h {
    private HashMap<String, com.baidu.tieba.l.f> AW;
    private String llm;
    private String mUuid;

    /* loaded from: classes23.dex */
    private static class a {
        private static final com.baidu.tieba.l.h mCq = new j();
    }

    public static com.baidu.tieba.l.h dCZ() {
        return a.mCq;
    }

    private j() {
        this.AW = new HashMap<>();
    }

    @Override // com.baidu.tieba.l.h
    public void diK() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.l.h
    public void bD(int i, String str) {
        dDa().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.h
    public void bE(int i, String str) {
        dDa().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.h
    public void bF(int i, String str) {
        dDa().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.h
    public void diL() {
        dDa().Pk(this.mUuid);
    }

    @Override // com.baidu.tieba.l.h
    public void o(int i, int i2, String str) {
        dDa().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.l.h
    public void diM() {
        dDa().Pl(this.mUuid);
        kt(this.mUuid);
    }

    @Override // com.baidu.tieba.l.h
    public void bG(int i, String str) {
        dDa().t(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.h
    public void Po(String str) {
        if (!StringUtils.isNull(this.llm)) {
            if (Pm(this.llm) || Pn(this.llm)) {
                kt(this.llm);
            } else {
                com.baidu.tieba.l.d.Pj(this.llm);
                this.AW.remove(this.mUuid);
            }
            diK();
            dDa().fN(this.llm, str);
            this.llm = null;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void diN() {
        this.llm = this.mUuid;
    }

    @Override // com.baidu.tieba.l.h
    public void Pp(String str) {
        dDa().fO(this.mUuid, str);
        if (Pm(this.mUuid) || Pn(this.mUuid)) {
            kt(this.mUuid);
        } else {
            com.baidu.tieba.l.d.Pj(this.mUuid);
            this.AW.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean Pm(String str) {
        return dDa().Pm(str);
    }

    public boolean Pn(String str) {
        return dDa().Pn(str);
    }

    public void kt(String str) {
        com.baidu.tieba.l.f fVar = this.AW.get(str);
        if (fVar != null) {
            fVar.kt(str);
            this.AW.remove(str);
        }
    }

    private com.baidu.tieba.l.f dDa() {
        com.baidu.tieba.l.f fVar = this.AW.get(this.mUuid);
        if (fVar == null) {
            return dDb();
        }
        return fVar;
    }

    private com.baidu.tieba.l.f dDb() {
        i iVar = new i(this.mUuid);
        this.AW.put(this.mUuid, iVar);
        return iVar;
    }
}
