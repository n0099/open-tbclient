package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements com.baidu.tieba.j.h {
    private String hvC;
    private String hvD;
    private HashMap<String, com.baidu.tieba.j.f> iAQ;

    /* loaded from: classes5.dex */
    private static class a {
        private static final com.baidu.tieba.j.h iAR = new j();
    }

    public static com.baidu.tieba.j.h cfF() {
        return a.iAR;
    }

    private j() {
        this.iAQ = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bOA() {
        this.hvC = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void av(int i, String str) {
        cfG().o(this.hvC, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aw(int i, String str) {
        cfG().p(this.hvC, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ax(int i, String str) {
        cfG().q(this.hvC, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bOB() {
        cfG().AU(this.hvC);
    }

    @Override // com.baidu.tieba.j.h
    public void h(int i, int i2, String str) {
        cfG().e(this.hvC, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bOC() {
        cfG().AV(this.hvC);
        cY(this.hvC);
    }

    @Override // com.baidu.tieba.j.h
    public void ay(int i, String str) {
        cfG().r(this.hvC, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void AY(String str) {
        if (!StringUtils.isNull(this.hvD)) {
            if (AW(this.hvD) || AX(this.hvD)) {
                cY(this.hvD);
            } else {
                com.baidu.tieba.j.d.AT(this.hvD);
                this.iAQ.remove(this.hvC);
            }
            bOA();
            cfG().dD(this.hvD, str);
            this.hvD = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bOD() {
        this.hvD = this.hvC;
    }

    @Override // com.baidu.tieba.j.h
    public void AZ(String str) {
        cfG().dE(this.hvC, str);
        if (AW(this.hvC) || AX(this.hvC)) {
            cY(this.hvC);
        } else {
            com.baidu.tieba.j.d.AT(this.hvC);
            this.iAQ.remove(this.hvC);
        }
        this.hvC = null;
    }

    public boolean AW(String str) {
        return cfG().AW(str);
    }

    public boolean AX(String str) {
        return cfG().AX(str);
    }

    public void cY(String str) {
        com.baidu.tieba.j.f fVar = this.iAQ.get(str);
        if (fVar != null) {
            fVar.cY(str);
            this.iAQ.remove(str);
        }
    }

    private com.baidu.tieba.j.f cfG() {
        com.baidu.tieba.j.f fVar = this.iAQ.get(this.hvC);
        if (fVar == null) {
            return cfH();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f cfH() {
        i iVar = new i(this.hvC);
        this.iAQ.put(this.hvC, iVar);
        return iVar;
    }
}
