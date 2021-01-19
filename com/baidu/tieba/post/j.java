package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes7.dex */
public class j implements com.baidu.tieba.l.g {
    private String lmo;
    private HashMap<String, com.baidu.tieba.l.e> mMap;
    private String mUuid;

    /* loaded from: classes7.dex */
    private static class a {
        private static final com.baidu.tieba.l.g mDc = new j();
    }

    public static com.baidu.tieba.l.g dyY() {
        return a.mDc;
    }

    private j() {
        this.mMap = new HashMap<>();
    }

    @Override // com.baidu.tieba.l.g
    public void deH() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.l.g
    public void bE(int i, String str) {
        dyZ().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void bF(int i, String str) {
        dyZ().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void bG(int i, String str) {
        dyZ().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void deI() {
        dyZ().NK(this.mUuid);
    }

    @Override // com.baidu.tieba.l.g
    public void p(int i, int i2, String str) {
        dyZ().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.l.g
    public void deJ() {
        dyZ().NL(this.mUuid);
        report(this.mUuid);
    }

    @Override // com.baidu.tieba.l.g
    public void bH(int i, String str) {
        dyZ().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void NO(String str) {
        if (!StringUtils.isNull(this.lmo)) {
            if (NM(this.lmo) || NN(this.lmo)) {
                report(this.lmo);
            } else {
                com.baidu.tieba.l.d.NJ(this.lmo);
                this.mMap.remove(this.mUuid);
            }
            deH();
            dyZ().fN(this.lmo, str);
            this.lmo = null;
        }
    }

    @Override // com.baidu.tieba.l.g
    public void deK() {
        this.lmo = this.mUuid;
    }

    @Override // com.baidu.tieba.l.g
    public void NP(String str) {
        dyZ().fO(this.mUuid, str);
        if (NM(this.mUuid) || NN(this.mUuid)) {
            report(this.mUuid);
        } else {
            com.baidu.tieba.l.d.NJ(this.mUuid);
            this.mMap.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean NM(String str) {
        return dyZ().NM(str);
    }

    public boolean NN(String str) {
        return dyZ().NN(str);
    }

    public void report(String str) {
        com.baidu.tieba.l.e eVar = this.mMap.get(str);
        if (eVar != null) {
            eVar.report(str);
            this.mMap.remove(str);
        }
    }

    private com.baidu.tieba.l.e dyZ() {
        com.baidu.tieba.l.e eVar = this.mMap.get(this.mUuid);
        if (eVar == null) {
            return dza();
        }
        return eVar;
    }

    private com.baidu.tieba.l.e dza() {
        i iVar = new i(this.mUuid);
        this.mMap.put(this.mUuid, iVar);
        return iVar;
    }
}
