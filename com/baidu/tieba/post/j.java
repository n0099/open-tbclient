package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes8.dex */
public class j implements com.baidu.tieba.l.g {
    private String lqY;
    private HashMap<String, com.baidu.tieba.l.e> mMap;
    private String mUuid;

    /* loaded from: classes8.dex */
    private static class a {
        private static final com.baidu.tieba.l.g mHJ = new j();
    }

    public static com.baidu.tieba.l.g dCQ() {
        return a.mHJ;
    }

    private j() {
        this.mMap = new HashMap<>();
    }

    @Override // com.baidu.tieba.l.g
    public void diz() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.l.g
    public void bD(int i, String str) {
        dCR().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void bE(int i, String str) {
        dCR().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void bF(int i, String str) {
        dCR().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void diA() {
        dCR().OR(this.mUuid);
    }

    @Override // com.baidu.tieba.l.g
    public void p(int i, int i2, String str) {
        dCR().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.l.g
    public void diB() {
        dCR().OS(this.mUuid);
        report(this.mUuid);
    }

    @Override // com.baidu.tieba.l.g
    public void bG(int i, String str) {
        dCR().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void OV(String str) {
        if (!StringUtils.isNull(this.lqY)) {
            if (OT(this.lqY) || OU(this.lqY)) {
                report(this.lqY);
            } else {
                com.baidu.tieba.l.d.OQ(this.lqY);
                this.mMap.remove(this.mUuid);
            }
            diz();
            dCR().fO(this.lqY, str);
            this.lqY = null;
        }
    }

    @Override // com.baidu.tieba.l.g
    public void diC() {
        this.lqY = this.mUuid;
    }

    @Override // com.baidu.tieba.l.g
    public void OW(String str) {
        dCR().fP(this.mUuid, str);
        if (OT(this.mUuid) || OU(this.mUuid)) {
            report(this.mUuid);
        } else {
            com.baidu.tieba.l.d.OQ(this.mUuid);
            this.mMap.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean OT(String str) {
        return dCR().OT(str);
    }

    public boolean OU(String str) {
        return dCR().OU(str);
    }

    public void report(String str) {
        com.baidu.tieba.l.e eVar = this.mMap.get(str);
        if (eVar != null) {
            eVar.report(str);
            this.mMap.remove(str);
        }
    }

    private com.baidu.tieba.l.e dCR() {
        com.baidu.tieba.l.e eVar = this.mMap.get(this.mUuid);
        if (eVar == null) {
            return dCS();
        }
        return eVar;
    }

    private com.baidu.tieba.l.e dCS() {
        i iVar = new i(this.mUuid);
        this.mMap.put(this.mUuid, iVar);
        return iVar;
    }
}
