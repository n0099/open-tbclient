package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.arch.lifecycle.w;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes9.dex */
public class e extends w {
    private PbModel jHV;
    private d kef = new d();
    private int keg = 0;

    public void init(Intent intent) {
        this.kef.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.kef.sC(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.jHV = pbModel;
    }

    public void c(com.baidu.tieba.pb.data.e eVar, int i) {
        boolean z = true;
        if (i >= this.keg) {
            this.keg = i;
            this.kef.K(eVar);
            if (eVar != null) {
                d dVar = this.kef;
                if (eVar.getIsNewUrl() != 1 && !eVar.cCZ()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.e cLr() {
        return this.kef.cLr();
    }

    public boolean isFromCDN() {
        return this.kef.isFromCDN();
    }

    public com.baidu.tieba.pb.data.e cLs() {
        return this.kef.cLs();
    }

    public void d(com.baidu.tieba.pb.data.e eVar, int i) {
        if (i == 3) {
            this.kef.setData(eVar);
        }
    }

    public p<bk> cLt() {
        return this.kef.cLt();
    }

    public Rect cLu() {
        if (this.kef.cLu() == null || this.kef.cLu().isEmpty()) {
            return null;
        }
        return this.kef.cLu();
    }

    public void sF(boolean z) {
        if (this.kef.cLy().getValue() != null) {
            com.baidu.tieba.pb.data.e aI = this.jHV.aI(this.kef.cLy().getValue());
            if (aI != null) {
                this.kef.cLw().addLast(this.kef.cLs());
                this.kef.setData(aI);
                this.kef.aQ(!v.isEmpty(aI.cCY()) ? aI.cCY().get(0) : null);
                this.kef.aP(this.kef.cLw().getLast() != null ? this.kef.cLw().getLast().cCy() : null);
                this.jHV.Au(z ? 21 : 22);
                this.jHV.j(aI);
                this.kef.setIsLoading(true);
            }
        }
    }

    public void aR(bk bkVar) {
        com.baidu.tieba.pb.data.e aI;
        if (bkVar != null && (aI = this.jHV.aI(bkVar)) != null) {
            this.kef.cLw().addLast(this.kef.cLs());
            this.kef.setData(aI);
            this.kef.aQ(!v.isEmpty(aI.cCY()) ? aI.cCY().get(0) : null);
            this.kef.aP(this.kef.cLw().getLast() != null ? this.kef.cLw().getLast().cCy() : null);
            this.jHV.Au(20);
            this.jHV.j(aI);
            this.kef.setIsLoading(true);
        }
    }

    public void cLD() {
        com.baidu.tieba.pb.data.e pollLast = this.kef.cLw().pollLast();
        if (pollLast != null) {
            this.kef.setData(pollLast);
            this.kef.aQ(!v.isEmpty(pollLast.cCY()) ? pollLast.cCY().get(0) : null);
            this.kef.aP(this.kef.cLw().peekLast() != null ? this.kef.cLw().peekLast().cCy() : null);
            this.jHV.j(pollLast);
            this.kef.setIsLoading(true);
        }
    }

    public p<bk> cLx() {
        return this.kef.cLx();
    }

    public p<bk> cLy() {
        return this.kef.cLy();
    }

    public p<Boolean> cLz() {
        return this.kef.cLz();
    }

    public void sD(boolean z) {
        this.kef.sD(z);
    }

    public p<Boolean> cLA() {
        return this.kef.cLA();
    }

    public void sE(boolean z) {
        this.kef.sE(z);
    }

    public void setIsLoading(boolean z) {
        this.kef.setIsLoading(z);
    }

    public p<Boolean> cLB() {
        return this.kef.cLB();
    }

    public boolean cLv() {
        return this.kef.cLv();
    }

    public void setCurrentTab(int i) {
        this.kef.setCurrentTab(i);
    }

    public p<Integer> cLC() {
        return this.kef.cLC();
    }
}
