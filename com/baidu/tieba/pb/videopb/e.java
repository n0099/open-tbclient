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
    private PbModel jGP;
    private d kcZ = new d();
    private int kda = 0;

    public void init(Intent intent) {
        this.kcZ.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.kcZ.sC(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.jGP = pbModel;
    }

    public void c(com.baidu.tieba.pb.data.e eVar, int i) {
        boolean z = true;
        if (i >= this.kda) {
            this.kda = i;
            this.kcZ.K(eVar);
            if (eVar != null) {
                d dVar = this.kcZ;
                if (eVar.getIsNewUrl() != 1 && !eVar.cCJ()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.e cLb() {
        return this.kcZ.cLb();
    }

    public boolean isFromCDN() {
        return this.kcZ.isFromCDN();
    }

    public com.baidu.tieba.pb.data.e cLc() {
        return this.kcZ.cLc();
    }

    public void d(com.baidu.tieba.pb.data.e eVar, int i) {
        if (i == 3) {
            this.kcZ.setData(eVar);
        }
    }

    public p<bk> cLd() {
        return this.kcZ.cLd();
    }

    public Rect cLe() {
        if (this.kcZ.cLe() == null || this.kcZ.cLe().isEmpty()) {
            return null;
        }
        return this.kcZ.cLe();
    }

    public void sF(boolean z) {
        if (this.kcZ.cLi().getValue() != null) {
            com.baidu.tieba.pb.data.e aI = this.jGP.aI(this.kcZ.cLi().getValue());
            if (aI != null) {
                this.kcZ.cLg().addLast(this.kcZ.cLc());
                this.kcZ.setData(aI);
                this.kcZ.aQ(!v.isEmpty(aI.cCI()) ? aI.cCI().get(0) : null);
                this.kcZ.aP(this.kcZ.cLg().getLast() != null ? this.kcZ.cLg().getLast().cCi() : null);
                this.jGP.As(z ? 21 : 22);
                this.jGP.j(aI);
                this.kcZ.setIsLoading(true);
            }
        }
    }

    public void aR(bk bkVar) {
        com.baidu.tieba.pb.data.e aI;
        if (bkVar != null && (aI = this.jGP.aI(bkVar)) != null) {
            this.kcZ.cLg().addLast(this.kcZ.cLc());
            this.kcZ.setData(aI);
            this.kcZ.aQ(!v.isEmpty(aI.cCI()) ? aI.cCI().get(0) : null);
            this.kcZ.aP(this.kcZ.cLg().getLast() != null ? this.kcZ.cLg().getLast().cCi() : null);
            this.jGP.As(20);
            this.jGP.j(aI);
            this.kcZ.setIsLoading(true);
        }
    }

    public void cLn() {
        com.baidu.tieba.pb.data.e pollLast = this.kcZ.cLg().pollLast();
        if (pollLast != null) {
            this.kcZ.setData(pollLast);
            this.kcZ.aQ(!v.isEmpty(pollLast.cCI()) ? pollLast.cCI().get(0) : null);
            this.kcZ.aP(this.kcZ.cLg().peekLast() != null ? this.kcZ.cLg().peekLast().cCi() : null);
            this.jGP.j(pollLast);
            this.kcZ.setIsLoading(true);
        }
    }

    public p<bk> cLh() {
        return this.kcZ.cLh();
    }

    public p<bk> cLi() {
        return this.kcZ.cLi();
    }

    public p<Boolean> cLj() {
        return this.kcZ.cLj();
    }

    public void sD(boolean z) {
        this.kcZ.sD(z);
    }

    public p<Boolean> cLk() {
        return this.kcZ.cLk();
    }

    public void sE(boolean z) {
        this.kcZ.sE(z);
    }

    public void setIsLoading(boolean z) {
        this.kcZ.setIsLoading(z);
    }

    public p<Boolean> cLl() {
        return this.kcZ.cLl();
    }

    public boolean cLf() {
        return this.kcZ.cLf();
    }

    public void setCurrentTab(int i) {
        this.kcZ.setCurrentTab(i);
    }

    public p<Integer> cLm() {
        return this.kcZ.cLm();
    }
}
