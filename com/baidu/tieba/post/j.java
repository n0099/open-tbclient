package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes4.dex */
public class j implements com.baidu.tieba.j.h {
    private HashMap<String, com.baidu.tieba.j.f> bFx;
    private String fxs;
    private String fxt;

    /* loaded from: classes4.dex */
    private static class a {
        private static final com.baidu.tieba.j.h gzV = new j();
    }

    public static com.baidu.tieba.j.h bqM() {
        return a.gzV;
    }

    private j() {
        this.bFx = new HashMap<>();
    }

    @Override // com.baidu.tieba.j.h
    public void baz() {
        this.fxs = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.j.h
    public void X(int i, String str) {
        bqN().h(this.fxs, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void Y(int i, String str) {
        bqN().i(this.fxs, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void Z(int i, String str) {
        bqN().j(this.fxs, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void baA() {
        bqN().ru(this.fxs);
    }

    @Override // com.baidu.tieba.j.h
    public void e(int i, int i2, String str) {
        bqN().e(this.fxs, i, i2, str);
    }

    @Override // com.baidu.tieba.j.h
    public void baB() {
        bqN().rv(this.fxs);
        dj(this.fxs);
    }

    @Override // com.baidu.tieba.j.h
    public void aa(int i, String str) {
        bqN().k(this.fxs, i, str);
    }

    @Override // com.baidu.tieba.j.h
    public void ry(String str) {
        if (!StringUtils.isNull(this.fxt)) {
            if (rw(this.fxt) || rx(this.fxt)) {
                dj(this.fxt);
            } else {
                com.baidu.tieba.j.d.rt(this.fxt);
                this.bFx.remove(this.fxs);
            }
            baz();
            bqN().cb(this.fxt, str);
            this.fxt = null;
        }
    }

    @Override // com.baidu.tieba.j.h
    public void baC() {
        this.fxt = this.fxs;
    }

    @Override // com.baidu.tieba.j.h
    public void rz(String str) {
        bqN().cc(this.fxs, str);
        if (rw(this.fxs) || rx(this.fxs)) {
            dj(this.fxs);
        } else {
            com.baidu.tieba.j.d.rt(this.fxs);
            this.bFx.remove(this.fxs);
        }
        this.fxs = null;
    }

    public boolean rw(String str) {
        return bqN().rw(str);
    }

    public boolean rx(String str) {
        return bqN().rx(str);
    }

    public void dj(String str) {
        com.baidu.tieba.j.f fVar = this.bFx.get(str);
        if (fVar != null) {
            fVar.dj(str);
            this.bFx.remove(str);
        }
    }

    private com.baidu.tieba.j.f bqN() {
        com.baidu.tieba.j.f fVar = this.bFx.get(this.fxs);
        if (fVar == null) {
            return bqO();
        }
        return fVar;
    }

    private com.baidu.tieba.j.f bqO() {
        i iVar = new i(this.fxs);
        this.bFx.put(this.fxs, iVar);
        return iVar;
    }
}
