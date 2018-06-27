package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class j implements com.baidu.tieba.j.h {
    private String fgW;
    private String fgX;
    private HashMap<String, com.baidu.tieba.j.f> gja;

    /* loaded from: classes2.dex */
    private static class a {
        private static final com.baidu.tieba.j.h gjb = new j();
    }

    public static com.baidu.tieba.j.h bnf() {
        return a.gjb;
    }

    private j() {
        this.gja = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void aXm() {
        this.fgW = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void Z(int i, String str) {
        bng().i(this.fgW, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aa(int i, String str) {
        bng().j(this.fgW, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ab(int i, String str) {
        bng().k(this.fgW, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aXn() {
        bng().qs(this.fgW);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        bng().e(this.fgW, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aXo() {
        bng().qt(this.fgW);
        qu(this.fgW);
    }

    @Override // com.baidu.tieba.j.h
    public void ac(int i, String str) {
        bng().l(this.fgW, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void qx(String str) {
        if (!StringUtils.isNull(this.fgX)) {
            if (qv(this.fgX) || qw(this.fgX)) {
                qu(this.fgX);
            } else {
                com.baidu.tieba.j.d.qr(this.fgX);
                this.gja.remove(this.fgW);
            }
            aXm();
            bng().bL(this.fgX, str);
            this.fgX = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void aXp() {
        this.fgX = this.fgW;
    }

    @Override // com.baidu.tieba.j.h
    public void qy(String str) {
        bng().bM(this.fgW, str);
        if (qv(this.fgW) || qw(this.fgW)) {
            qu(this.fgW);
        } else {
            com.baidu.tieba.j.d.qr(this.fgW);
            this.gja.remove(this.fgW);
        }
        this.fgW = null;
    }

    public boolean qv(String str) {
        return bng().qv(str);
    }

    public boolean qw(String str) {
        return bng().qw(str);
    }

    public void qu(String str) {
        com.baidu.tieba.j.f fVar = this.gja.get(str);
        if (fVar != null) {
            fVar.qu(str);
            this.gja.remove(str);
        }
    }

    private com.baidu.tieba.j.f bng() {
        com.baidu.tieba.j.f fVar = this.gja.get(this.fgW);
        if (fVar == null) {
            return bnh();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bnh() {
        i iVar = new i(this.fgW);
        this.gja.put(this.fgW, iVar);
        return iVar;
    }
}
