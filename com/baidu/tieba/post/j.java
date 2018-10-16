package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes4.dex */
public class j implements com.baidu.tieba.j.h {
    private HashMap<String, com.baidu.tieba.j.f> bEL;
    private String fwc;
    private String fwd;

    /* loaded from: classes4.dex */
    private static class a {
        private static final com.baidu.tieba.j.h gyt = new j();
    }

    public static com.baidu.tieba.j.h brq() {
        return a.gyt;
    }

    private j() {
        this.bEL = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bbc() {
        this.fwc = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void ab(int i, String str) {
        brr().h(this.fwc, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ac(int i, String str) {
        brr().i(this.fwc, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ad(int i, String str) {
        brr().j(this.fwc, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bbd() {
        brr().rt(this.fwc);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        brr().e(this.fwc, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bbe() {
        brr().ru(this.fwc);
        dj(this.fwc);
    }

    @Override // com.baidu.tieba.j.h
    public void ae(int i, String str) {
        brr().k(this.fwc, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void rx(String str) {
        if (!StringUtils.isNull(this.fwd)) {
            if (rv(this.fwd) || rw(this.fwd)) {
                dj(this.fwd);
            } else {
                com.baidu.tieba.j.d.rs(this.fwd);
                this.bEL.remove(this.fwc);
            }
            bbc();
            brr().cb(this.fwd, str);
            this.fwd = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bbf() {
        this.fwd = this.fwc;
    }

    @Override // com.baidu.tieba.j.h
    public void ry(String str) {
        brr().cc(this.fwc, str);
        if (rv(this.fwc) || rw(this.fwc)) {
            dj(this.fwc);
        } else {
            com.baidu.tieba.j.d.rs(this.fwc);
            this.bEL.remove(this.fwc);
        }
        this.fwc = null;
    }

    public boolean rv(String str) {
        return brr().rv(str);
    }

    public boolean rw(String str) {
        return brr().rw(str);
    }

    public void dj(String str) {
        com.baidu.tieba.j.f fVar = this.bEL.get(str);
        if (fVar != null) {
            fVar.dj(str);
            this.bEL.remove(str);
        }
    }

    private com.baidu.tieba.j.f brr() {
        com.baidu.tieba.j.f fVar = this.bEL.get(this.fwc);
        if (fVar == null) {
            return brs();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f brs() {
        i iVar = new i(this.fwc);
        this.bEL.put(this.fwc, iVar);
        return iVar;
    }
}
