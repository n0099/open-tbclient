package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class j implements com.baidu.tieba.j.h {
    private String fgZ;
    private String fha;
    private HashMap<String, com.baidu.tieba.j.f> gjA;

    /* loaded from: classes2.dex */
    private static class a {
        private static final com.baidu.tieba.j.h gjB = new j();
    }

    public static com.baidu.tieba.j.h blv() {
        return a.gjB;
    }

    private j() {
        this.gjA = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void aVB() {
        this.fgZ = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void ab(int i, String str) {
        blw().h(this.fgZ, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ac(int i, String str) {
        blw().i(this.fgZ, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ad(int i, String str) {
        blw().j(this.fgZ, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aVC() {
        blw().qn(this.fgZ);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        blw().e(this.fgZ, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aVD() {
        blw().qo(this.fgZ);
        qp(this.fgZ);
    }

    @Override // com.baidu.tieba.j.h
    public void ae(int i, String str) {
        blw().k(this.fgZ, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void qs(String str) {
        if (!StringUtils.isNull(this.fha)) {
            if (qq(this.fha) || qr(this.fha)) {
                qp(this.fha);
            } else {
                com.baidu.tieba.j.d.qm(this.fha);
                this.gjA.remove(this.fgZ);
            }
            aVB();
            blw().bH(this.fha, str);
            this.fha = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void aVE() {
        this.fha = this.fgZ;
    }

    @Override // com.baidu.tieba.j.h
    public void qt(String str) {
        blw().bI(this.fgZ, str);
        if (qq(this.fgZ) || qr(this.fgZ)) {
            qp(this.fgZ);
        } else {
            com.baidu.tieba.j.d.qm(this.fgZ);
            this.gjA.remove(this.fgZ);
        }
        this.fgZ = null;
    }

    public boolean qq(String str) {
        return blw().qq(str);
    }

    public boolean qr(String str) {
        return blw().qr(str);
    }

    public void qp(String str) {
        com.baidu.tieba.j.f fVar = this.gjA.get(str);
        if (fVar != null) {
            fVar.qp(str);
            this.gjA.remove(str);
        }
    }

    private com.baidu.tieba.j.f blw() {
        com.baidu.tieba.j.f fVar = this.gjA.get(this.fgZ);
        if (fVar == null) {
            return blx();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f blx() {
        i iVar = new i(this.fgZ);
        this.gjA.put(this.fgZ, iVar);
        return iVar;
    }
}
