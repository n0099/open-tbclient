package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i.d;
import com.baidu.tieba.i.f;
import com.baidu.tieba.i.h;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class m implements h {
    private String fqx;
    private String fqy;
    private HashMap<String, f> gGH;

    /* loaded from: classes2.dex */
    private static class a {
        private static final h gGI = new m();
    }

    public static h brQ() {
        return a.gGI;
    }

    private m() {
        this.gGH = new HashMap<>();
    }

    @Override // com.baidu.tieba.i.h
    public void aUU() {
        this.fqx = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.i.h
    public void P(int i, String str) {
        brR().i(this.fqx, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void Q(int i, String str) {
        brR().j(this.fqx, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void R(int i, String str) {
        brR().k(this.fqx, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aUV() {
        brR().pc(this.fqx);
    }

    @Override // com.baidu.tieba.i.h
    public void h(int i, int i2, String str) {
        brR().d(this.fqx, i, i2, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aUW() {
        brR().pd(this.fqx);
        pe(this.fqx);
    }

    @Override // com.baidu.tieba.i.h
    public void S(int i, String str) {
        brR().l(this.fqx, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void ph(String str) {
        if (!StringUtils.isNull(this.fqy)) {
            if (pf(this.fqy) || pg(this.fqy)) {
                pe(this.fqy);
            } else {
                d.pb(this.fqy);
                this.gGH.remove(this.fqx);
            }
            aUU();
            brR().bA(this.fqy, str);
            this.fqy = null;
        }
    }

    @Override // com.baidu.tieba.i.h
    public void aUX() {
        this.fqy = this.fqx;
    }

    @Override // com.baidu.tieba.i.h
    public void pi(String str) {
        brR().bB(this.fqx, str);
        if (pf(this.fqx) || pg(this.fqx)) {
            pe(this.fqx);
        } else {
            d.pb(this.fqx);
            this.gGH.remove(this.fqx);
        }
        this.fqx = null;
    }

    public boolean pf(String str) {
        return brR().pf(str);
    }

    public boolean pg(String str) {
        return brR().pg(str);
    }

    public void pe(String str) {
        f fVar = this.gGH.get(str);
        if (fVar != null) {
            fVar.pe(str);
            this.gGH.remove(str);
        }
    }

    private f brR() {
        f fVar = this.gGH.get(this.fqx);
        if (fVar == null) {
            return brS();
        }
        return fVar;
    }

    private f brS() {
        l lVar = new l(this.fqx);
        this.gGH.put(this.fqx, lVar);
        return lVar;
    }
}
