package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes8.dex */
public class j implements com.baidu.tieba.l.g {
    private String luv;
    private HashMap<String, com.baidu.tieba.l.e> mMap;
    private String mUuid;

    /* loaded from: classes8.dex */
    private static class a {
        private static final com.baidu.tieba.l.g mMj = new j();
    }

    public static com.baidu.tieba.l.g dBi() {
        return a.mMj;
    }

    private j() {
        this.mMap = new HashMap<>();
    }

    @Override // com.baidu.tieba.l.g
    public void dgH() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.l.g
    public void bK(int i, String str) {
        dBj().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void bL(int i, String str) {
        dBj().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void bM(int i, String str) {
        dBj().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void dgI() {
        dBj().Oy(this.mUuid);
    }

    @Override // com.baidu.tieba.l.g
    public void o(int i, int i2, String str) {
        dBj().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.l.g
    public void dgJ() {
        dBj().Oz(this.mUuid);
        report(this.mUuid);
    }

    @Override // com.baidu.tieba.l.g
    public void bN(int i, String str) {
        dBj().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void OC(String str) {
        if (!StringUtils.isNull(this.luv)) {
            if (OA(this.luv) || OB(this.luv)) {
                report(this.luv);
            } else {
                com.baidu.tieba.l.d.Ox(this.luv);
                this.mMap.remove(this.mUuid);
            }
            dgH();
            dBj().fN(this.luv, str);
            this.luv = null;
        }
    }

    @Override // com.baidu.tieba.l.g
    public void dgK() {
        this.luv = this.mUuid;
    }

    @Override // com.baidu.tieba.l.g
    public void OD(String str) {
        dBj().fO(this.mUuid, str);
        if (OA(this.mUuid) || OB(this.mUuid)) {
            report(this.mUuid);
        } else {
            com.baidu.tieba.l.d.Ox(this.mUuid);
            this.mMap.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean OA(String str) {
        return dBj().OA(str);
    }

    public boolean OB(String str) {
        return dBj().OB(str);
    }

    public void report(String str) {
        com.baidu.tieba.l.e eVar = this.mMap.get(str);
        if (eVar != null) {
            eVar.report(str);
            this.mMap.remove(str);
        }
    }

    private com.baidu.tieba.l.e dBj() {
        com.baidu.tieba.l.e eVar = this.mMap.get(this.mUuid);
        if (eVar == null) {
            return dBk();
        }
        return eVar;
    }

    private com.baidu.tieba.l.e dBk() {
        i iVar = new i(this.mUuid);
        this.mMap.put(this.mUuid, iVar);
        return iVar;
    }
}
