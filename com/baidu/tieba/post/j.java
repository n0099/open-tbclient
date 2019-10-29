package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements com.baidu.tieba.j.h {
    private String hxc;
    private HashMap<String, com.baidu.tieba.j.f> iCI;
    private String mUuid;

    /* loaded from: classes5.dex */
    private static class a {
        private static final com.baidu.tieba.j.h iCJ = new j();
    }

    public static com.baidu.tieba.j.h cdL() {
        return a.iCJ;
    }

    private j() {
        this.iCI = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bMB() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void av(int i, String str) {
        cdM().m(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aw(int i, String str) {
        cdM().n(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ax(int i, String str) {
        cdM().o(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bMC() {
        cdM().zO(this.mUuid);
    }

    @Override // com.baidu.tieba.j.h
    public void h(int i, int i2, String str) {
        cdM().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bMD() {
        cdM().zP(this.mUuid);
        dK(this.mUuid);
    }

    @Override // com.baidu.tieba.j.h
    public void ay(int i, String str) {
        cdM().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void zS(String str) {
        if (!StringUtils.isNull(this.hxc)) {
            if (zQ(this.hxc) || zR(this.hxc)) {
                dK(this.hxc);
            } else {
                com.baidu.tieba.j.d.zN(this.hxc);
                this.iCI.remove(this.mUuid);
            }
            bMB();
            cdM().dr(this.hxc, str);
            this.hxc = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bME() {
        this.hxc = this.mUuid;
    }

    @Override // com.baidu.tieba.j.h
    public void zT(String str) {
        cdM().ds(this.mUuid, str);
        if (zQ(this.mUuid) || zR(this.mUuid)) {
            dK(this.mUuid);
        } else {
            com.baidu.tieba.j.d.zN(this.mUuid);
            this.iCI.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean zQ(String str) {
        return cdM().zQ(str);
    }

    public boolean zR(String str) {
        return cdM().zR(str);
    }

    public void dK(String str) {
        com.baidu.tieba.j.f fVar = this.iCI.get(str);
        if (fVar != null) {
            fVar.dK(str);
            this.iCI.remove(str);
        }
    }

    private com.baidu.tieba.j.f cdM() {
        com.baidu.tieba.j.f fVar = this.iCI.get(this.mUuid);
        if (fVar == null) {
            return cdN();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f cdN() {
        i iVar = new i(this.mUuid);
        this.iCI.put(this.mUuid, iVar);
        return iVar;
    }
}
