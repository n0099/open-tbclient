package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class j implements com.baidu.tieba.j.h {
    private String fhf;
    private String fhg;
    private HashMap<String, com.baidu.tieba.j.f> gjB;

    /* loaded from: classes2.dex */
    private static class a {
        private static final com.baidu.tieba.j.h gjC = new j();
    }

    public static com.baidu.tieba.j.h bly() {
        return a.gjC;
    }

    private j() {
        this.gjB = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void aVF() {
        this.fhf = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void ab(int i, String str) {
        blz().i(this.fhf, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ac(int i, String str) {
        blz().j(this.fhf, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ad(int i, String str) {
        blz().k(this.fhf, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aVG() {
        blz().ql(this.fhf);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        blz().e(this.fhf, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aVH() {
        blz().qm(this.fhf);
        qn(this.fhf);
    }

    @Override // com.baidu.tieba.j.h
    public void ae(int i, String str) {
        blz().l(this.fhf, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void qq(String str) {
        if (!StringUtils.isNull(this.fhg)) {
            if (qo(this.fhg) || qp(this.fhg)) {
                qn(this.fhg);
            } else {
                com.baidu.tieba.j.d.qk(this.fhg);
                this.gjB.remove(this.fhf);
            }
            aVF();
            blz().bH(this.fhg, str);
            this.fhg = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void aVI() {
        this.fhg = this.fhf;
    }

    @Override // com.baidu.tieba.j.h
    public void qr(String str) {
        blz().bI(this.fhf, str);
        if (qo(this.fhf) || qp(this.fhf)) {
            qn(this.fhf);
        } else {
            com.baidu.tieba.j.d.qk(this.fhf);
            this.gjB.remove(this.fhf);
        }
        this.fhf = null;
    }

    public boolean qo(String str) {
        return blz().qo(str);
    }

    public boolean qp(String str) {
        return blz().qp(str);
    }

    public void qn(String str) {
        com.baidu.tieba.j.f fVar = this.gjB.get(str);
        if (fVar != null) {
            fVar.qn(str);
            this.gjB.remove(str);
        }
    }

    private com.baidu.tieba.j.f blz() {
        com.baidu.tieba.j.f fVar = this.gjB.get(this.fhf);
        if (fVar == null) {
            return blA();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f blA() {
        i iVar = new i(this.fhf);
        this.gjB.put(this.fhf, iVar);
        return iVar;
    }
}
