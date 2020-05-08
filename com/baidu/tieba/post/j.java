package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes10.dex */
public class j implements com.baidu.tieba.k.h {
    private String jbM;
    private String mUuid;
    private HashMap<String, com.baidu.tieba.k.f> yL;

    /* loaded from: classes10.dex */
    private static class a {
        private static final com.baidu.tieba.k.h kmu = new j();
    }

    public static com.baidu.tieba.k.h cLl() {
        return a.kmu;
    }

    private j() {
        this.yL = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void crz() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void be(int i, String str) {
        cLm().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bf(int i, String str) {
        cLm().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bg(int i, String str) {
        cLm().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void crA() {
        cLm().GH(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void l(int i, int i2, String str) {
        cLm().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void crB() {
        cLm().GI(this.mUuid);
        ge(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void bh(int i, String str) {
        cLm().t(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void GL(String str) {
        if (!StringUtils.isNull(this.jbM)) {
            if (GJ(this.jbM) || GK(this.jbM)) {
                ge(this.jbM);
            } else {
                com.baidu.tieba.k.d.GG(this.jbM);
                this.yL.remove(this.mUuid);
            }
            crz();
            cLm().ei(this.jbM, str);
            this.jbM = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void crC() {
        this.jbM = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void GM(String str) {
        cLm().ej(this.mUuid, str);
        if (GJ(this.mUuid) || GK(this.mUuid)) {
            ge(this.mUuid);
        } else {
            com.baidu.tieba.k.d.GG(this.mUuid);
            this.yL.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean GJ(String str) {
        return cLm().GJ(str);
    }

    public boolean GK(String str) {
        return cLm().GK(str);
    }

    public void ge(String str) {
        com.baidu.tieba.k.f fVar = this.yL.get(str);
        if (fVar != null) {
            fVar.ge(str);
            this.yL.remove(str);
        }
    }

    private com.baidu.tieba.k.f cLm() {
        com.baidu.tieba.k.f fVar = this.yL.get(this.mUuid);
        if (fVar == null) {
            return cLn();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f cLn() {
        i iVar = new i(this.mUuid);
        this.yL.put(this.mUuid, iVar);
        return iVar;
    }
}
