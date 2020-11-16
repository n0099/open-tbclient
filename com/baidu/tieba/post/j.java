package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes22.dex */
public class j implements com.baidu.tieba.l.h {
    private HashMap<String, com.baidu.tieba.l.f> Ab;
    private String kXT;
    private String mUuid;

    /* loaded from: classes22.dex */
    private static class a {
        private static final com.baidu.tieba.l.h mom = new j();
    }

    public static com.baidu.tieba.l.h dxI() {
        return a.mom;
    }

    private j() {
        this.Ab = new HashMap<>();
    }

    @Override // com.baidu.tieba.l.h
    public void ddz() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.l.h
    public void bD(int i, String str) {
        dxJ().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.h
    public void bE(int i, String str) {
        dxJ().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.h
    public void bF(int i, String str) {
        dxJ().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.h
    public void ddA() {
        dxJ().Od(this.mUuid);
    }

    @Override // com.baidu.tieba.l.h
    public void n(int i, int i2, String str) {
        dxJ().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.l.h
    public void ddB() {
        dxJ().Oe(this.mUuid);
        jM(this.mUuid);
    }

    @Override // com.baidu.tieba.l.h
    public void bG(int i, String str) {
        dxJ().t(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.l.h
    public void Oh(String str) {
        if (!StringUtils.isNull(this.kXT)) {
            if (Of(this.kXT) || Og(this.kXT)) {
                jM(this.kXT);
            } else {
                com.baidu.tieba.l.d.Oc(this.kXT);
                this.Ab.remove(this.mUuid);
            }
            ddz();
            dxJ().fI(this.kXT, str);
            this.kXT = null;
        }
    }

    @Override // com.baidu.tieba.l.h
    public void ddC() {
        this.kXT = this.mUuid;
    }

    @Override // com.baidu.tieba.l.h
    public void Oi(String str) {
        dxJ().fJ(this.mUuid, str);
        if (Of(this.mUuid) || Og(this.mUuid)) {
            jM(this.mUuid);
        } else {
            com.baidu.tieba.l.d.Oc(this.mUuid);
            this.Ab.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean Of(String str) {
        return dxJ().Of(str);
    }

    public boolean Og(String str) {
        return dxJ().Og(str);
    }

    public void jM(String str) {
        com.baidu.tieba.l.f fVar = this.Ab.get(str);
        if (fVar != null) {
            fVar.jM(str);
            this.Ab.remove(str);
        }
    }

    private com.baidu.tieba.l.f dxJ() {
        com.baidu.tieba.l.f fVar = this.Ab.get(this.mUuid);
        if (fVar == null) {
            return dxK();
        }
        return fVar;
    }

    private com.baidu.tieba.l.f dxK() {
        i iVar = new i(this.mUuid);
        this.Ab.put(this.mUuid, iVar);
        return iVar;
    }
}
