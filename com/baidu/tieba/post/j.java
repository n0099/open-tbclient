package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes10.dex */
public class j implements com.baidu.tieba.k.h {
    private String jbI;
    private String mUuid;
    private HashMap<String, com.baidu.tieba.k.f> yL;

    /* loaded from: classes10.dex */
    private static class a {
        private static final com.baidu.tieba.k.h kmq = new j();
    }

    public static com.baidu.tieba.k.h cLo() {
        return a.kmq;
    }

    private j() {
        this.yL = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void crC() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void be(int i, String str) {
        cLp().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bf(int i, String str) {
        cLp().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bg(int i, String str) {
        cLp().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void crD() {
        cLp().GE(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void l(int i, int i2, String str) {
        cLp().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void crE() {
        cLp().GF(this.mUuid);
        ge(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void bh(int i, String str) {
        cLp().t(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void GI(String str) {
        if (!StringUtils.isNull(this.jbI)) {
            if (GG(this.jbI) || GH(this.jbI)) {
                ge(this.jbI);
            } else {
                com.baidu.tieba.k.d.GD(this.jbI);
                this.yL.remove(this.mUuid);
            }
            crC();
            cLp().ei(this.jbI, str);
            this.jbI = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void crF() {
        this.jbI = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void GJ(String str) {
        cLp().ej(this.mUuid, str);
        if (GG(this.mUuid) || GH(this.mUuid)) {
            ge(this.mUuid);
        } else {
            com.baidu.tieba.k.d.GD(this.mUuid);
            this.yL.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean GG(String str) {
        return cLp().GG(str);
    }

    public boolean GH(String str) {
        return cLp().GH(str);
    }

    public void ge(String str) {
        com.baidu.tieba.k.f fVar = this.yL.get(str);
        if (fVar != null) {
            fVar.ge(str);
            this.yL.remove(str);
        }
    }

    private com.baidu.tieba.k.f cLp() {
        com.baidu.tieba.k.f fVar = this.yL.get(this.mUuid);
        if (fVar == null) {
            return cLq();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f cLq() {
        i iVar = new i(this.mUuid);
        this.yL.put(this.mUuid, iVar);
        return iVar;
    }
}
