package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes17.dex */
public class j implements com.baidu.tieba.k.h {
    private String jRR;
    private String mUuid;
    private HashMap<String, com.baidu.tieba.k.f> zl;

    /* loaded from: classes17.dex */
    private static class a {
        private static final com.baidu.tieba.k.h lgK = new j();
    }

    public static com.baidu.tieba.k.h daa() {
        return a.lgK;
    }

    private j() {
        this.zl = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void cGn() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void bp(int i, String str) {
        dab().o(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bq(int i, String str) {
        dab().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void br(int i, String str) {
        dab().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cGo() {
        dab().JI(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void m(int i, int i2, String str) {
        dab().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cGp() {
        dab().JJ(this.mUuid);
        gW(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void bs(int i, String str) {
        dab().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void JM(String str) {
        if (!StringUtils.isNull(this.jRR)) {
            if (JK(this.jRR) || JL(this.jRR)) {
                gW(this.jRR);
            } else {
                com.baidu.tieba.k.d.JH(this.jRR);
                this.zl.remove(this.mUuid);
            }
            cGn();
            dab().eR(this.jRR, str);
            this.jRR = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void cGq() {
        this.jRR = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void JN(String str) {
        dab().eS(this.mUuid, str);
        if (JK(this.mUuid) || JL(this.mUuid)) {
            gW(this.mUuid);
        } else {
            com.baidu.tieba.k.d.JH(this.mUuid);
            this.zl.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean JK(String str) {
        return dab().JK(str);
    }

    public boolean JL(String str) {
        return dab().JL(str);
    }

    public void gW(String str) {
        com.baidu.tieba.k.f fVar = this.zl.get(str);
        if (fVar != null) {
            fVar.gW(str);
            this.zl.remove(str);
        }
    }

    private com.baidu.tieba.k.f dab() {
        com.baidu.tieba.k.f fVar = this.zl.get(this.mUuid);
        if (fVar == null) {
            return dac();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f dac() {
        i iVar = new i(this.mUuid);
        this.zl.put(this.mUuid, iVar);
        return iVar;
    }
}
