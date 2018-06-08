package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class j implements com.baidu.tieba.j.h {
    private String fdf;
    private String fdg;
    private HashMap<String, com.baidu.tieba.j.f> geZ;

    /* loaded from: classes2.dex */
    private static class a {
        private static final com.baidu.tieba.j.h gfa = new j();
    }

    public static com.baidu.tieba.j.h bmB() {
        return a.gfa;
    }

    private j() {
        this.geZ = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void aWF() {
        this.fdf = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void ac(int i, String str) {
        bmC().i(this.fdf, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ad(int i, String str) {
        bmC().j(this.fdf, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ae(int i, String str) {
        bmC().k(this.fdf, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aWG() {
        bmC().qs(this.fdf);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        bmC().e(this.fdf, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void aWH() {
        bmC().qt(this.fdf);
        qu(this.fdf);
    }

    @Override // com.baidu.tieba.j.h
    public void af(int i, String str) {
        bmC().l(this.fdf, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void qx(String str) {
        if (!StringUtils.isNull(this.fdg)) {
            if (qv(this.fdg) || qw(this.fdg)) {
                qu(this.fdg);
            } else {
                com.baidu.tieba.j.d.qr(this.fdg);
                this.geZ.remove(this.fdf);
            }
            aWF();
            bmC().bH(this.fdg, str);
            this.fdg = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void aWI() {
        this.fdg = this.fdf;
    }

    @Override // com.baidu.tieba.j.h
    public void qy(String str) {
        bmC().bI(this.fdf, str);
        if (qv(this.fdf) || qw(this.fdf)) {
            qu(this.fdf);
        } else {
            com.baidu.tieba.j.d.qr(this.fdf);
            this.geZ.remove(this.fdf);
        }
        this.fdf = null;
    }

    public boolean qv(String str) {
        return bmC().qv(str);
    }

    public boolean qw(String str) {
        return bmC().qw(str);
    }

    public void qu(String str) {
        com.baidu.tieba.j.f fVar = this.geZ.get(str);
        if (fVar != null) {
            fVar.qu(str);
            this.geZ.remove(str);
        }
    }

    private com.baidu.tieba.j.f bmC() {
        com.baidu.tieba.j.f fVar = this.geZ.get(this.fdf);
        if (fVar == null) {
            return bmD();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bmD() {
        i iVar = new i(this.fdf);
        this.geZ.put(this.fdf, iVar);
        return iVar;
    }
}
