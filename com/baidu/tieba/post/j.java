package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class j implements com.baidu.tieba.j.h {
    private String fow;
    private String fox;
    private HashMap<String, com.baidu.tieba.j.f> gqS;

    /* loaded from: classes2.dex */
    private static class a {
        private static final com.baidu.tieba.j.h gqT = new j();
    }

    public static com.baidu.tieba.j.h bob() {
        return a.gqT;
    }

    private j() {
        this.gqS = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void aXP() {
        this.fow = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void ab(int i, String str) {
        boc().h(this.fow, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ac(int i, String str) {
        boc().i(this.fow, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ad(int i, String str) {
        boc().j(this.fow, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aXQ() {
        boc().qS(this.fow);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        boc().e(this.fow, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aXR() {
        boc().qT(this.fow);
        qU(this.fow);
    }

    @Override // com.baidu.tieba.j.h
    public void ae(int i, String str) {
        boc().k(this.fow, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void qX(String str) {
        if (!StringUtils.isNull(this.fox)) {
            if (qV(this.fox) || qW(this.fox)) {
                qU(this.fox);
            } else {
                com.baidu.tieba.j.d.qR(this.fox);
                this.gqS.remove(this.fow);
            }
            aXP();
            boc().bP(this.fox, str);
            this.fox = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void aXS() {
        this.fox = this.fow;
    }

    @Override // com.baidu.tieba.j.h
    public void qY(String str) {
        boc().bQ(this.fow, str);
        if (qV(this.fow) || qW(this.fow)) {
            qU(this.fow);
        } else {
            com.baidu.tieba.j.d.qR(this.fow);
            this.gqS.remove(this.fow);
        }
        this.fow = null;
    }

    public boolean qV(String str) {
        return boc().qV(str);
    }

    public boolean qW(String str) {
        return boc().qW(str);
    }

    public void qU(String str) {
        com.baidu.tieba.j.f fVar = this.gqS.get(str);
        if (fVar != null) {
            fVar.qU(str);
            this.gqS.remove(str);
        }
    }

    private com.baidu.tieba.j.f boc() {
        com.baidu.tieba.j.f fVar = this.gqS.get(this.fow);
        if (fVar == null) {
            return bod();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bod() {
        i iVar = new i(this.fow);
        this.gqS.put(this.fow, iVar);
        return iVar;
    }
}
