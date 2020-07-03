package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes10.dex */
public class j implements com.baidu.tieba.k.h {
    private String jJm;
    private String mUuid;
    private HashMap<String, com.baidu.tieba.k.f> zl;

    /* loaded from: classes10.dex */
    private static class a {
        private static final com.baidu.tieba.k.h kZt = new j();
    }

    public static com.baidu.tieba.k.h cWS() {
        return a.kZt;
    }

    private j() {
        this.zl = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void cCr() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void bn(int i, String str) {
        cWT().o(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bo(int i, String str) {
        cWT().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bp(int i, String str) {
        cWT().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cCs() {
        cWT().IT(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void l(int i, int i2, String str) {
        cWT().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cCt() {
        cWT().IU(this.mUuid);
        gY(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void bq(int i, String str) {
        cWT().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void IX(String str) {
        if (!StringUtils.isNull(this.jJm)) {
            if (IV(this.jJm) || IW(this.jJm)) {
                gY(this.jJm);
            } else {
                com.baidu.tieba.k.d.IS(this.jJm);
                this.zl.remove(this.mUuid);
            }
            cCr();
            cWT().eP(this.jJm, str);
            this.jJm = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void cCu() {
        this.jJm = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void IY(String str) {
        cWT().eQ(this.mUuid, str);
        if (IV(this.mUuid) || IW(this.mUuid)) {
            gY(this.mUuid);
        } else {
            com.baidu.tieba.k.d.IS(this.mUuid);
            this.zl.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean IV(String str) {
        return cWT().IV(str);
    }

    public boolean IW(String str) {
        return cWT().IW(str);
    }

    public void gY(String str) {
        com.baidu.tieba.k.f fVar = this.zl.get(str);
        if (fVar != null) {
            fVar.gY(str);
            this.zl.remove(str);
        }
    }

    private com.baidu.tieba.k.f cWT() {
        com.baidu.tieba.k.f fVar = this.zl.get(this.mUuid);
        if (fVar == null) {
            return cWU();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f cWU() {
        i iVar = new i(this.mUuid);
        this.zl.put(this.mUuid, iVar);
        return iVar;
    }
}
