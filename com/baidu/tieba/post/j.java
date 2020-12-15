package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes23.dex */
public class j implements com.baidu.tieba.l.h {
    private HashMap<String, com.baidu.tieba.l.f> AW;
    private String llo;
    private String mUuid;

    /* loaded from: classes23.dex */
    private static class a {
        private static final com.baidu.tieba.l.h mCs = new j();
    }

    public static com.baidu.tieba.l.h dDa() {
        return a.mCs;
    }

    private j() {
        this.AW = new HashMap<>();
    }

    @Override // com.baidu.tieba.l.h
    public void diL() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.l.h
    public void bD(int i, String str) {
        dDb().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.h
    public void bE(int i, String str) {
        dDb().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.h
    public void bF(int i, String str) {
        dDb().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.h
    public void diM() {
        dDb().Pk(this.mUuid);
    }

    @Override // com.baidu.tieba.l.h
    public void o(int i, int i2, String str) {
        dDb().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.l.h
    public void diN() {
        dDb().Pl(this.mUuid);
        kt(this.mUuid);
    }

    @Override // com.baidu.tieba.l.h
    public void bG(int i, String str) {
        dDb().t(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.h
    public void Po(String str) {
        if (!StringUtils.isNull(this.llo)) {
            if (Pm(this.llo) || Pn(this.llo)) {
                kt(this.llo);
            } else {
                com.baidu.tieba.l.d.Pj(this.llo);
                this.AW.remove(this.mUuid);
            }
            diL();
            dDb().fN(this.llo, str);
            this.llo = null;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void diO() {
        this.llo = this.mUuid;
    }

    @Override // com.baidu.tieba.l.h
    public void Pp(String str) {
        dDb().fO(this.mUuid, str);
        if (Pm(this.mUuid) || Pn(this.mUuid)) {
            kt(this.mUuid);
        } else {
            com.baidu.tieba.l.d.Pj(this.mUuid);
            this.AW.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean Pm(String str) {
        return dDb().Pm(str);
    }

    public boolean Pn(String str) {
        return dDb().Pn(str);
    }

    public void kt(String str) {
        com.baidu.tieba.l.f fVar = this.AW.get(str);
        if (fVar != null) {
            fVar.kt(str);
            this.AW.remove(str);
        }
    }

    private com.baidu.tieba.l.f dDb() {
        com.baidu.tieba.l.f fVar = this.AW.get(this.mUuid);
        if (fVar == null) {
            return dDc();
        }
        return fVar;
    }

    private com.baidu.tieba.l.f dDc() {
        i iVar = new i(this.mUuid);
        this.AW.put(this.mUuid, iVar);
        return iVar;
    }
}
