package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements com.baidu.tieba.j.h {
    private String hwl;
    private HashMap<String, com.baidu.tieba.j.f> iBR;
    private String mUuid;

    /* loaded from: classes5.dex */
    private static class a {
        private static final com.baidu.tieba.j.h iBS = new j();
    }

    public static com.baidu.tieba.j.h cdJ() {
        return a.iBS;
    }

    private j() {
        this.iBR = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bMz() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void au(int i, String str) {
        cdK().m(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void av(int i, String str) {
        cdK().n(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aw(int i, String str) {
        cdK().o(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bMA() {
        cdK().zO(this.mUuid);
    }

    @Override // com.baidu.tieba.j.h
    public void h(int i, int i2, String str) {
        cdK().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bMB() {
        cdK().zP(this.mUuid);
        dK(this.mUuid);
    }

    @Override // com.baidu.tieba.j.h
    public void ax(int i, String str) {
        cdK().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void zS(String str) {
        if (!StringUtils.isNull(this.hwl)) {
            if (zQ(this.hwl) || zR(this.hwl)) {
                dK(this.hwl);
            } else {
                com.baidu.tieba.j.d.zN(this.hwl);
                this.iBR.remove(this.mUuid);
            }
            bMz();
            cdK().dr(this.hwl, str);
            this.hwl = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bMC() {
        this.hwl = this.mUuid;
    }

    @Override // com.baidu.tieba.j.h
    public void zT(String str) {
        cdK().ds(this.mUuid, str);
        if (zQ(this.mUuid) || zR(this.mUuid)) {
            dK(this.mUuid);
        } else {
            com.baidu.tieba.j.d.zN(this.mUuid);
            this.iBR.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean zQ(String str) {
        return cdK().zQ(str);
    }

    public boolean zR(String str) {
        return cdK().zR(str);
    }

    public void dK(String str) {
        com.baidu.tieba.j.f fVar = this.iBR.get(str);
        if (fVar != null) {
            fVar.dK(str);
            this.iBR.remove(str);
        }
    }

    private com.baidu.tieba.j.f cdK() {
        com.baidu.tieba.j.f fVar = this.iBR.get(this.mUuid);
        if (fVar == null) {
            return cdL();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f cdL() {
        i iVar = new i(this.mUuid);
        this.iBR.put(this.mUuid, iVar);
        return iVar;
    }
}
