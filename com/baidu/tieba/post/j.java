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
        private static final com.baidu.tieba.l.g mHK = new j();
    }

    public static com.baidu.tieba.l.g dCP() {
        return a.mHK;
    }

    private j() {
        this.mMap = new HashMap<>();
    }

    @Override // com.baidu.tieba.l.g
    public void diy() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.l.g
    public void bD(int i, String str) {
        dCQ().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void bE(int i, String str) {
        dCQ().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void bF(int i, String str) {
        dCQ().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void diz() {
        dCQ().OS(this.mUuid);
    }

    @Override // com.baidu.tieba.l.g
    public void p(int i, int i2, String str) {
        dCQ().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.l.g
    public void diA() {
        dCQ().OT(this.mUuid);
        report(this.mUuid);
    }

    @Override // com.baidu.tieba.l.g
    public void bG(int i, String str) {
        dCQ().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void OW(String str) {
        if (!StringUtils.isNull(this.lqY)) {
            if (OU(this.lqY) || OV(this.lqY)) {
                report(this.lqY);
            } else {
                com.baidu.tieba.l.d.OR(this.lqY);
                this.mMap.remove(this.mUuid);
            }
            diy();
            dCQ().fO(this.lqY, str);
            this.lqY = null;
        }
    }

    @Override // com.baidu.tieba.l.g
    public void diB() {
        this.lqY = this.mUuid;
    }

    @Override // com.baidu.tieba.l.g
    public void OX(String str) {
        dCQ().fP(this.mUuid, str);
        if (OU(this.mUuid) || OV(this.mUuid)) {
            report(this.mUuid);
        } else {
            com.baidu.tieba.l.d.OR(this.mUuid);
            this.mMap.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean OU(String str) {
        return dCQ().OU(str);
    }

    public boolean OV(String str) {
        return dCQ().OV(str);
    }

    public void report(String str) {
        com.baidu.tieba.l.e eVar = this.mMap.get(str);
        if (eVar != null) {
            eVar.report(str);
            this.mMap.remove(str);
        }
    }

    private com.baidu.tieba.l.e dCQ() {
        com.baidu.tieba.l.e eVar = this.mMap.get(this.mUuid);
        if (eVar == null) {
            return dCR();
        }
        return eVar;
    }

    private com.baidu.tieba.l.e dCR() {
        i iVar = new i(this.mUuid);
        this.mMap.put(this.mUuid, iVar);
        return iVar;
    }
}
