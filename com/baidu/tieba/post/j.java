package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes8.dex */
public class j implements com.baidu.tieba.l.g {
    private String luJ;
    private HashMap<String, com.baidu.tieba.l.e> mMap;
    private String mUuid;

    /* loaded from: classes8.dex */
    private static class a {
        private static final com.baidu.tieba.l.g mMy = new j();
    }

    public static com.baidu.tieba.l.g dBp() {
        return a.mMy;
    }

    private j() {
        this.mMap = new HashMap<>();
    }

    @Override // com.baidu.tieba.l.g
    public void dgO() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.l.g
    public void bK(int i, String str) {
        dBq().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void bL(int i, String str) {
        dBq().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void bM(int i, String str) {
        dBq().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void dgP() {
        dBq().Oz(this.mUuid);
    }

    @Override // com.baidu.tieba.l.g
    public void o(int i, int i2, String str) {
        dBq().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.l.g
    public void dgQ() {
        dBq().OA(this.mUuid);
        report(this.mUuid);
    }

    @Override // com.baidu.tieba.l.g
    public void bN(int i, String str) {
        dBq().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void OD(String str) {
        if (!StringUtils.isNull(this.luJ)) {
            if (OB(this.luJ) || OC(this.luJ)) {
                report(this.luJ);
            } else {
                com.baidu.tieba.l.d.Oy(this.luJ);
                this.mMap.remove(this.mUuid);
            }
            dgO();
            dBq().fN(this.luJ, str);
            this.luJ = null;
        }
    }

    @Override // com.baidu.tieba.l.g
    public void dgR() {
        this.luJ = this.mUuid;
    }

    @Override // com.baidu.tieba.l.g
    public void OE(String str) {
        dBq().fO(this.mUuid, str);
        if (OB(this.mUuid) || OC(this.mUuid)) {
            report(this.mUuid);
        } else {
            com.baidu.tieba.l.d.Oy(this.mUuid);
            this.mMap.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean OB(String str) {
        return dBq().OB(str);
    }

    public boolean OC(String str) {
        return dBq().OC(str);
    }

    public void report(String str) {
        com.baidu.tieba.l.e eVar = this.mMap.get(str);
        if (eVar != null) {
            eVar.report(str);
            this.mMap.remove(str);
        }
    }

    private com.baidu.tieba.l.e dBq() {
        com.baidu.tieba.l.e eVar = this.mMap.get(this.mUuid);
        if (eVar == null) {
            return dBr();
        }
        return eVar;
    }

    private com.baidu.tieba.l.e dBr() {
        i iVar = new i(this.mUuid);
        this.mMap.put(this.mUuid, iVar);
        return iVar;
    }
}
