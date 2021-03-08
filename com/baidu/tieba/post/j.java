package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes7.dex */
public class j implements com.baidu.tieba.l.g {
    private String lwL;
    private HashMap<String, com.baidu.tieba.l.e> mMap;
    private String mUuid;

    /* loaded from: classes7.dex */
    private static class a {
        private static final com.baidu.tieba.l.g mOA = new j();
    }

    public static com.baidu.tieba.l.g dBx() {
        return a.mOA;
    }

    private j() {
        this.mMap = new HashMap<>();
    }

    @Override // com.baidu.tieba.l.g
    public void dgX() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.l.g
    public void bK(int i, String str) {
        dBy().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void bL(int i, String str) {
        dBy().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void bM(int i, String str) {
        dBy().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void dgY() {
        dBy().OF(this.mUuid);
    }

    @Override // com.baidu.tieba.l.g
    public void o(int i, int i2, String str) {
        dBy().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.l.g
    public void dgZ() {
        dBy().OG(this.mUuid);
        report(this.mUuid);
    }

    @Override // com.baidu.tieba.l.g
    public void bN(int i, String str) {
        dBy().t(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.g
    public void OJ(String str) {
        if (!StringUtils.isNull(this.lwL)) {
            if (OH(this.lwL) || OI(this.lwL)) {
                report(this.lwL);
            } else {
                com.baidu.tieba.l.d.OE(this.lwL);
                this.mMap.remove(this.mUuid);
            }
            dgX();
            dBy().fN(this.lwL, str);
            this.lwL = null;
        }
    }

    @Override // com.baidu.tieba.l.g
    public void dha() {
        this.lwL = this.mUuid;
    }

    @Override // com.baidu.tieba.l.g
    public void OK(String str) {
        dBy().fO(this.mUuid, str);
        if (OH(this.mUuid) || OI(this.mUuid)) {
            report(this.mUuid);
        } else {
            com.baidu.tieba.l.d.OE(this.mUuid);
            this.mMap.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean OH(String str) {
        return dBy().OH(str);
    }

    public boolean OI(String str) {
        return dBy().OI(str);
    }

    public void report(String str) {
        com.baidu.tieba.l.e eVar = this.mMap.get(str);
        if (eVar != null) {
            eVar.report(str);
            this.mMap.remove(str);
        }
    }

    private com.baidu.tieba.l.e dBy() {
        com.baidu.tieba.l.e eVar = this.mMap.get(this.mUuid);
        if (eVar == null) {
            return dBz();
        }
        return eVar;
    }

    private com.baidu.tieba.l.e dBz() {
        i iVar = new i(this.mUuid);
        this.mMap.put(this.mUuid, iVar);
        return iVar;
    }
}
