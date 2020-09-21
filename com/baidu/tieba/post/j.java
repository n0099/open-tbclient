package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes22.dex */
public class j implements com.baidu.tieba.k.h {
    private String kpW;
    private String mUuid;
    private HashMap<String, com.baidu.tieba.k.f> zK;

    /* loaded from: classes22.dex */
    private static class a {
        private static final com.baidu.tieba.k.h lGh = new j();
    }

    public static com.baidu.tieba.k.h doO() {
        return a.lGh;
    }

    private j() {
        this.zK = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void cUJ() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void bq(int i, String str) {
        doP().n(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void br(int i, String str) {
        doP().o(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bs(int i, String str) {
        doP().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cUK() {
        doP().Nd(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void m(int i, int i2, String str) {
        doP().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cUL() {
        doP().Ne(this.mUuid);
        iK(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void bt(int i, String str) {
        doP().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void Nh(String str) {
        if (!StringUtils.isNull(this.kpW)) {
            if (Nf(this.kpW) || Ng(this.kpW)) {
                iK(this.kpW);
            } else {
                com.baidu.tieba.k.d.Nc(this.kpW);
                this.zK.remove(this.mUuid);
            }
            cUJ();
            doP().fw(this.kpW, str);
            this.kpW = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void cUM() {
        this.kpW = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void Ni(String str) {
        doP().fx(this.mUuid, str);
        if (Nf(this.mUuid) || Ng(this.mUuid)) {
            iK(this.mUuid);
        } else {
            com.baidu.tieba.k.d.Nc(this.mUuid);
            this.zK.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean Nf(String str) {
        return doP().Nf(str);
    }

    public boolean Ng(String str) {
        return doP().Ng(str);
    }

    public void iK(String str) {
        com.baidu.tieba.k.f fVar = this.zK.get(str);
        if (fVar != null) {
            fVar.iK(str);
            this.zK.remove(str);
        }
    }

    private com.baidu.tieba.k.f doP() {
        com.baidu.tieba.k.f fVar = this.zK.get(this.mUuid);
        if (fVar == null) {
            return doQ();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f doQ() {
        i iVar = new i(this.mUuid);
        this.zK.put(this.mUuid, iVar);
        return iVar;
    }
}
