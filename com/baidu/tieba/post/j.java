package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public class j implements com.baidu.tieba.j.h {
    private String hpp;
    private String hpq;
    private HashMap<String, com.baidu.tieba.j.f> iuy;

    /* loaded from: classes5.dex */
    private static class a {
        private static final com.baidu.tieba.j.h iuz = new j();
    }

    public static com.baidu.tieba.j.h ccN() {
        return a.iuz;
    }

    private j() {
        this.iuy = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void bLR() {
        this.hpp = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void av(int i, String str) {
        ccO().o(this.hpp, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aw(int i, String str) {
        ccO().p(this.hpp, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ax(int i, String str) {
        ccO().q(this.hpp, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bLS() {
        ccO().Ah(this.hpp);
    }

    @Override // com.baidu.tieba.j.h
    public void h(int i, int i2, String str) {
        ccO().e(this.hpp, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void bLT() {
        ccO().Ai(this.hpp);
        cU(this.hpp);
    }

    @Override // com.baidu.tieba.j.h
    public void ay(int i, String str) {
        ccO().r(this.hpp, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void Al(String str) {
        if (!StringUtils.isNull(this.hpq)) {
            if (Aj(this.hpq) || Ak(this.hpq)) {
                cU(this.hpq);
            } else {
                com.baidu.tieba.j.d.Ag(this.hpq);
                this.iuy.remove(this.hpp);
            }
            bLR();
            ccO().dC(this.hpq, str);
            this.hpq = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void bLU() {
        this.hpq = this.hpp;
    }

    @Override // com.baidu.tieba.j.h
    public void Am(String str) {
        ccO().dD(this.hpp, str);
        if (Aj(this.hpp) || Ak(this.hpp)) {
            cU(this.hpp);
        } else {
            com.baidu.tieba.j.d.Ag(this.hpp);
            this.iuy.remove(this.hpp);
        }
        this.hpp = null;
    }

    public boolean Aj(String str) {
        return ccO().Aj(str);
    }

    public boolean Ak(String str) {
        return ccO().Ak(str);
    }

    public void cU(String str) {
        com.baidu.tieba.j.f fVar = this.iuy.get(str);
        if (fVar != null) {
            fVar.cU(str);
            this.iuy.remove(str);
        }
    }

    private com.baidu.tieba.j.f ccO() {
        com.baidu.tieba.j.f fVar = this.iuy.get(this.hpp);
        if (fVar == null) {
            return ccP();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f ccP() {
        i iVar = new i(this.hpp);
        this.iuy.put(this.hpp, iVar);
        return iVar;
    }
}
