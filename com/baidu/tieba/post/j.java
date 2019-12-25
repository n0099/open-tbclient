package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes7.dex */
public class j implements com.baidu.tieba.j.h {
    private HashMap<String, com.baidu.tieba.j.f> cR;
    private String ikn;
    private String mUuid;

    /* loaded from: classes7.dex */
    private static class a {
        private static final com.baidu.tieba.j.h jwb = new j();
    }

    public static com.baidu.tieba.j.h cxC() {
        return a.jwb;
    }

    private j() {
        this.cR = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void cdL() {
        this.mUuid = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void aJ(int i, String str) {
        cxD().p(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aK(int i, String str) {
        cxD().q(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aL(int i, String str) {
        cxD().r(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void cdM() {
        cxD().Ew(this.mUuid);
    }

    @Override // com.baidu.tieba.j.h
    public void j(int i, int i2, String str) {
        cxD().e(this.mUuid, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void cdN() {
        cxD().Ex(this.mUuid);
        eB(this.mUuid);
    }

    @Override // com.baidu.tieba.j.h
    public void aM(int i, String str) {
        cxD().s(this.mUuid, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void EA(String str) {
        if (!StringUtils.isNull(this.ikn)) {
            if (Ey(this.ikn) || Ez(this.ikn)) {
                eB(this.ikn);
            } else {
                com.baidu.tieba.j.d.Ev(this.ikn);
                this.cR.remove(this.mUuid);
            }
            cdL();
            cxD().dK(this.ikn, str);
            this.ikn = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void cdO() {
        this.ikn = this.mUuid;
    }

    @Override // com.baidu.tieba.j.h
    public void EB(String str) {
        cxD().dL(this.mUuid, str);
        if (Ey(this.mUuid) || Ez(this.mUuid)) {
            eB(this.mUuid);
        } else {
            com.baidu.tieba.j.d.Ev(this.mUuid);
            this.cR.remove(this.mUuid);
        }
        this.mUuid = null;
    }

    public boolean Ey(String str) {
        return cxD().Ey(str);
    }

    public boolean Ez(String str) {
        return cxD().Ez(str);
    }

    public void eB(String str) {
        com.baidu.tieba.j.f fVar = this.cR.get(str);
        if (fVar != null) {
            fVar.eB(str);
            this.cR.remove(str);
        }
    }

    private com.baidu.tieba.j.f cxD() {
        com.baidu.tieba.j.f fVar = this.cR.get(this.mUuid);
        if (fVar == null) {
            return cxE();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f cxE() {
        i iVar = new i(this.mUuid);
        this.cR.put(this.mUuid, iVar);
        return iVar;
    }
}
