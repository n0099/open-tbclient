package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.arch.lifecycle.w;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes7.dex */
public class e extends w {
    private PbModel iCx;
    private d iXH = new d();
    private int iXI = 0;

    public void init(Intent intent) {
        this.iXH.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.iXH.qP(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void g(PbModel pbModel) {
        this.iCx = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.iXI) {
            this.iXI = i;
            this.iXH.G(fVar);
            if (fVar != null) {
                d dVar = this.iXH;
                if (fVar.getIsNewUrl() != 1 && !fVar.cjs()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f crH() {
        return this.iXH.crH();
    }

    public boolean isFromCDN() {
        return this.iXH.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f crI() {
        return this.iXH.crI();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.iXH.setData(fVar);
        }
    }

    public p<bj> crJ() {
        return this.iXH.crJ();
    }

    public Rect crK() {
        if (this.iXH.crK() == null || this.iXH.crK().isEmpty()) {
            return null;
        }
        return this.iXH.crK();
    }

    public void qS(boolean z) {
        if (this.iXH.crO().getValue() != null) {
            com.baidu.tieba.pb.data.f aD = this.iCx.aD(this.iXH.crO().getValue());
            if (aD != null) {
                this.iXH.crM().addLast(this.iXH.crI());
                this.iXH.setData(aD);
                this.iXH.aL(!v.isEmpty(aD.cjr()) ? aD.cjr().get(0) : null);
                this.iXH.aK(this.iXH.crM().getLast() != null ? this.iXH.crM().getLast().ciS() : null);
                this.iCx.yS(z ? 21 : 22);
                this.iCx.h(aD);
                this.iXH.setIsLoading(true);
            }
        }
    }

    public void aM(bj bjVar) {
        com.baidu.tieba.pb.data.f aD;
        if (bjVar != null && (aD = this.iCx.aD(bjVar)) != null) {
            this.iXH.crM().addLast(this.iXH.crI());
            this.iXH.setData(aD);
            this.iXH.aL(!v.isEmpty(aD.cjr()) ? aD.cjr().get(0) : null);
            this.iXH.aK(this.iXH.crM().getLast() != null ? this.iXH.crM().getLast().ciS() : null);
            this.iCx.yS(20);
            this.iCx.h(aD);
            this.iXH.setIsLoading(true);
        }
    }

    public void crT() {
        com.baidu.tieba.pb.data.f pollLast = this.iXH.crM().pollLast();
        if (pollLast != null) {
            this.iXH.setData(pollLast);
            this.iXH.aL(!v.isEmpty(pollLast.cjr()) ? pollLast.cjr().get(0) : null);
            this.iXH.aK(this.iXH.crM().peekLast() != null ? this.iXH.crM().peekLast().ciS() : null);
            this.iCx.h(pollLast);
            this.iXH.setIsLoading(true);
        }
    }

    public p<bj> crN() {
        return this.iXH.crN();
    }

    public p<bj> crO() {
        return this.iXH.crO();
    }

    public p<Boolean> crP() {
        return this.iXH.crP();
    }

    public void qQ(boolean z) {
        this.iXH.qQ(z);
    }

    public p<Boolean> crQ() {
        return this.iXH.crQ();
    }

    public void qR(boolean z) {
        this.iXH.qR(z);
    }

    public void setIsLoading(boolean z) {
        this.iXH.setIsLoading(z);
    }

    public p<Boolean> crR() {
        return this.iXH.crR();
    }

    public boolean crL() {
        return this.iXH.crL();
    }

    public void setCurrentTab(int i) {
        this.iXH.setCurrentTab(i);
    }

    public p<Integer> crS() {
        return this.iXH.crS();
    }
}
