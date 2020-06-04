package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes10.dex */
public class j implements com.baidu.tieba.k.h {
    private String jrV;
    private String mUuid;
    private HashMap<String, com.baidu.tieba.k.f> yL;

    /* loaded from: classes10.dex */
    private static class a {
        private static final com.baidu.tieba.k.h kFx = new j();
    }

    public static com.baidu.tieba.k.h cSC() {
        return a.kFx;
    }

    private j() {
        this.yL = new HashMap<>();
    }

    @Override // com.baidu.tieba.k.h
    public void cyu() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.k.h
    public void bj(int i, String str) {
        cSD().o(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bk(int i, String str) {
        cSD().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void bl(int i, String str) {
        cSD().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cyv() {
        cSD().Ir(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void l(int i, int i2, String str) {
        cSD().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.k.h
    public void cyw() {
        cSD().Is(this.mUuid);
        gQ(this.mUuid);
    }

    @Override // com.baidu.tieba.k.h
    public void bm(int i, String str) {
        cSD().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.k.h
    public void Iv(String str) {
        if (!StringUtils.isNull(this.jrV)) {
            if (It(this.jrV) || Iu(this.jrV)) {
                gQ(this.jrV);
            } else {
                com.baidu.tieba.k.d.Iq(this.jrV);
                this.yL.remove(this.mUuid);
            }
            cyu();
            cSD().eJ(this.jrV, str);
            this.jrV = null;
        }
    }

    @Override // com.baidu.tieba.k.h
    public void cyx() {
        this.jrV = this.mUuid;
    }

    @Override // com.baidu.tieba.k.h
    public void Iw(String str) {
        cSD().eK(this.mUuid, str);
        if (It(this.mUuid) || Iu(this.mUuid)) {
            gQ(this.mUuid);
        } else {
            com.baidu.tieba.k.d.Iq(this.mUuid);
            this.yL.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean It(String str) {
        return cSD().It(str);
    }

    public boolean Iu(String str) {
        return cSD().Iu(str);
    }

    public void gQ(String str) {
        com.baidu.tieba.k.f fVar = this.yL.get(str);
        if (fVar != null) {
            fVar.gQ(str);
            this.yL.remove(str);
        }
    }

    private com.baidu.tieba.k.f cSD() {
        com.baidu.tieba.k.f fVar = this.yL.get(this.mUuid);
        if (fVar == null) {
            return cSE();
        }
        return fVar;
    }

    private com.baidu.tieba.k.f cSE() {
        i iVar = new i(this.mUuid);
        this.yL.put(this.mUuid, iVar);
        return iVar;
    }
}
