package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes17.dex */
public class j implements com.baidu.tieba.k.h {
    private String khw;
    private String mUuid;
    private HashMap<String, com.baidu.tieba.k.f> zK;

    /* loaded from: classes17.dex */
    private static class a {
        private static final com.baidu.tieba.k.h lxq = new j();
    }

    public static com.baidu.tieba.k.h dlh() {
        return a.lxq;
    }

    private j() {
        this.zK = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void cRd() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void bm(int i, String str) {
        dli().n(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bn(int i, String str) {
        dli().o(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bo(int i, String str) {
        dli().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cRe() {
        dli().MB(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void l(int i, int i2, String str) {
        dli().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cRf() {
        dli().MC(this.mUuid);
        ir(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void bp(int i, String str) {
        dli().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void MF(String str) {
        if (!StringUtils.isNull(this.khw)) {
            if (MD(this.khw) || ME(this.khw)) {
                ir(this.khw);
            } else {
                com.baidu.tieba.k.d.MA(this.khw);
                this.zK.remove(this.mUuid);
            }
            cRd();
            dli().fj(this.khw, str);
            this.khw = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void cRg() {
        this.khw = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void MG(String str) {
        dli().fk(this.mUuid, str);
        if (MD(this.mUuid) || ME(this.mUuid)) {
            ir(this.mUuid);
        } else {
            com.baidu.tieba.k.d.MA(this.mUuid);
            this.zK.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean MD(String str) {
        return dli().MD(str);
    }

    public boolean ME(String str) {
        return dli().ME(str);
    }

    public void ir(String str) {
        com.baidu.tieba.k.f fVar = this.zK.get(str);
        if (fVar != null) {
            fVar.ir(str);
            this.zK.remove(str);
        }
    }

    private com.baidu.tieba.k.f dli() {
        com.baidu.tieba.k.f fVar = this.zK.get(this.mUuid);
        if (fVar == null) {
            return dlj();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f dlj() {
        i iVar = new i(this.mUuid);
        this.zK.put(this.mUuid, iVar);
        return iVar;
    }
}
