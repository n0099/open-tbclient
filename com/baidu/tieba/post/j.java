package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements com.baidu.tieba.j.h {
    private String hwu;
    private String hwv;
    private HashMap<String, com.baidu.tieba.j.f> iBU;

    /* loaded from: classes5.dex */
    private static class a {
        private static final com.baidu.tieba.j.h iBV = new j();
    }

    public static com.baidu.tieba.j.h cfX() {
        return a.iBV;
    }

    private j() {
        this.iBU = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bOO() {
        this.hwu = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void av(int i, String str) {
        cfY().o(this.hwu, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aw(int i, String str) {
        cfY().p(this.hwu, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ax(int i, String str) {
        cfY().q(this.hwu, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bOP() {
        cfY().AV(this.hwu);
    }

    @Override // com.baidu.tieba.j.h
    public void h(int i, int i2, String str) {
        cfY().e(this.hwu, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bOQ() {
        cfY().AW(this.hwu);
        cY(this.hwu);
    }

    @Override // com.baidu.tieba.j.h
    public void ay(int i, String str) {
        cfY().r(this.hwu, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void AZ(String str) {
        if (!StringUtils.isNull(this.hwv)) {
            if (AX(this.hwv) || AY(this.hwv)) {
                cY(this.hwv);
            } else {
                com.baidu.tieba.j.d.AU(this.hwv);
                this.iBU.remove(this.hwu);
            }
            bOO();
            cfY().dD(this.hwv, str);
            this.hwv = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bOR() {
        this.hwv = this.hwu;
    }

    @Override // com.baidu.tieba.j.h
    public void Ba(String str) {
        cfY().dE(this.hwu, str);
        if (AX(this.hwu) || AY(this.hwu)) {
            cY(this.hwu);
        } else {
            com.baidu.tieba.j.d.AU(this.hwu);
            this.iBU.remove(this.hwu);
        }
        this.hwu = null;
    }

    public boolean AX(String str) {
        return cfY().AX(str);
    }

    public boolean AY(String str) {
        return cfY().AY(str);
    }

    public void cY(String str) {
        com.baidu.tieba.j.f fVar = this.iBU.get(str);
        if (fVar != null) {
            fVar.cY(str);
            this.iBU.remove(str);
        }
    }

    private com.baidu.tieba.j.f cfY() {
        com.baidu.tieba.j.f fVar = this.iBU.get(this.hwu);
        if (fVar == null) {
            return cfZ();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f cfZ() {
        i iVar = new i(this.hwu);
        this.iBU.put(this.hwu, iVar);
        return iVar;
    }
}
