package com.baidu.tieba.post;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i.d;
import com.baidu.tieba.i.f;
import com.baidu.tieba.i.h;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public class m implements h {
    private String frY;
    private String frZ;
    private HashMap<String, f> gvQ;

    /* loaded from: classes2.dex */
    private static class a {
        private static final h gvR = new m();
    }

    public static h blj() {
        return a.gvR;
    }

    private m() {
        this.gvQ = new HashMap<>();
    }

    @Override // com.baidu.tieba.i.h
    public void aUZ() {
        this.frY = UUID.randomUUID().toString();
    }

    @Override // com.baidu.tieba.i.h
    public void R(int i, String str) {
        blk().i(this.frY, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void S(int i, String str) {
        blk().j(this.frY, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void T(int i, String str) {
        blk().k(this.frY, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aVa() {
        blk().pf(this.frY);
    }

    @Override // com.baidu.tieba.i.h
    public void h(int i, int i2, String str) {
        blk().d(this.frY, i, i2, str);
    }

    @Override // com.baidu.tieba.i.h
    public void aVb() {
        blk().pg(this.frY);
        ph(this.frY);
    }

    @Override // com.baidu.tieba.i.h
    public void U(int i, String str) {
        blk().l(this.frY, i, str);
    }

    @Override // com.baidu.tieba.i.h
    public void pk(String str) {
        if (!StringUtils.isNull(this.frZ)) {
            if (pi(this.frZ) || pj(this.frZ)) {
                ph(this.frZ);
            } else {
                d.pe(this.frZ);
                this.gvQ.remove(this.frY);
            }
            aUZ();
            blk().bz(this.frZ, str);
            this.frZ = null;
        }
    }

    @Override // com.baidu.tieba.i.h
    public void aVc() {
        this.frZ = this.frY;
    }

    @Override // com.baidu.tieba.i.h
    public void pl(String str) {
        blk().bA(this.frY, str);
        if (pi(this.frY) || pj(this.frY)) {
            ph(this.frY);
        } else {
            d.pe(this.frY);
            this.gvQ.remove(this.frY);
        }
        this.frY = null;
    }

    public boolean pi(String str) {
        return blk().pi(str);
    }

    public boolean pj(String str) {
        return blk().pj(str);
    }

    public void ph(String str) {
        f fVar = this.gvQ.get(str);
        if (fVar != null) {
            fVar.ph(str);
            this.gvQ.remove(str);
        }
    }

    private f blk() {
        f fVar = this.gvQ.get(this.frY);
        if (fVar == null) {
            return bll();
        }
        return fVar;
    }

    private f bll() {
        l lVar = new l(this.frY);
        this.gvQ.put(this.frY, lVar);
        return lVar;
    }
}
