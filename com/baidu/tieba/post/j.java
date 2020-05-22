package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes10.dex */
public class j implements com.baidu.tieba.k.h {
    private String jqP;
    private String mUuid;
    private HashMap<String, com.baidu.tieba.k.f> yL;

    /* loaded from: classes10.dex */
    private static class a {
        private static final com.baidu.tieba.k.h kEp = new j();
    }

    public static com.baidu.tieba.k.h cSm() {
        return a.kEp;
    }

    private j() {
        this.yL = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void cyd() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void bj(int i, String str) {
        cSn().o(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bk(int i, String str) {
        cSn().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bl(int i, String str) {
        cSn().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cye() {
        cSn().Iq(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void l(int i, int i2, String str) {
        cSn().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cyf() {
        cSn().Ir(this.mUuid);
        gQ(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void bm(int i, String str) {
        cSn().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void Iu(String str) {
        if (!StringUtils.isNull(this.jqP)) {
            if (Is(this.jqP) || It(this.jqP)) {
                gQ(this.jqP);
            } else {
                com.baidu.tieba.k.d.Ip(this.jqP);
                this.yL.remove(this.mUuid);
            }
            cyd();
            cSn().eJ(this.jqP, str);
            this.jqP = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void cyg() {
        this.jqP = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void Iv(String str) {
        cSn().eK(this.mUuid, str);
        if (Is(this.mUuid) || It(this.mUuid)) {
            gQ(this.mUuid);
        } else {
            com.baidu.tieba.k.d.Ip(this.mUuid);
            this.yL.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean Is(String str) {
        return cSn().Is(str);
    }

    public boolean It(String str) {
        return cSn().It(str);
    }

    public void gQ(String str) {
        com.baidu.tieba.k.f fVar = this.yL.get(str);
        if (fVar != null) {
            fVar.gQ(str);
            this.yL.remove(str);
        }
    }

    private com.baidu.tieba.k.f cSn() {
        com.baidu.tieba.k.f fVar = this.yL.get(this.mUuid);
        if (fVar == null) {
            return cSo();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f cSo() {
        i iVar = new i(this.mUuid);
        this.yL.put(this.mUuid, iVar);
        return iVar;
    }
}
