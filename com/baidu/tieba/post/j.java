package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes4.dex */
public class j implements com.baidu.tieba.j.h {
    private HashMap<String, com.baidu.tieba.j.f> bEL;
    private String fwd;
    private String fwe;

    /* loaded from: classes4.dex */
    private static class a {
        private static final com.baidu.tieba.j.h gyu = new j();
    }

    public static com.baidu.tieba.j.h brq() {
        return a.gyu;
    }

    private j() {
        this.bEL = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bbc() {
        this.fwd = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void ab(int i, String str) {
        brr().h(this.fwd, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ac(int i, String str) {
        brr().i(this.fwd, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ad(int i, String str) {
        brr().j(this.fwd, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bbd() {
        brr().rt(this.fwd);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        brr().e(this.fwd, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bbe() {
        brr().ru(this.fwd);
        dj(this.fwd);
    }

    @Override // com.baidu.tieba.j.h
    public void ae(int i, String str) {
        brr().k(this.fwd, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void rx(String str) {
        if (!StringUtils.isNull(this.fwe)) {
            if (rv(this.fwe) || rw(this.fwe)) {
                dj(this.fwe);
            } else {
                com.baidu.tieba.j.d.rs(this.fwe);
                this.bEL.remove(this.fwd);
            }
            bbc();
            brr().cb(this.fwe, str);
            this.fwe = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bbf() {
        this.fwe = this.fwd;
    }

    @Override // com.baidu.tieba.j.h
    public void ry(String str) {
        brr().cc(this.fwd, str);
        if (rv(this.fwd) || rw(this.fwd)) {
            dj(this.fwd);
        } else {
            com.baidu.tieba.j.d.rs(this.fwd);
            this.bEL.remove(this.fwd);
        }
        this.fwd = null;
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
        com.baidu.tieba.j.f fVar = this.bEL.get(this.fwd);
        if (fVar == null) {
            return brs();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f brs() {
        i iVar = new i(this.fwd);
        this.bEL.put(this.fwd, iVar);
        return iVar;
    }
}
