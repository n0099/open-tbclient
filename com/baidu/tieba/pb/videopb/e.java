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
    private d iXM = new d();
    private int iXN = 0;

    public void init(Intent intent) {
        this.iXM.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.iXM.qP(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void g(PbModel pbModel) {
        this.iCx = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.iXN) {
            this.iXN = i;
            this.iXM.G(fVar);
            if (fVar != null) {
                d dVar = this.iXM;
                if (fVar.getIsNewUrl() != 1 && !fVar.cjs()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f crJ() {
        return this.iXM.crJ();
    }

    public boolean isFromCDN() {
        return this.iXM.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f crK() {
        return this.iXM.crK();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.iXM.setData(fVar);
        }
    }

    public p<bj> crL() {
        return this.iXM.crL();
    }

    public Rect crM() {
        if (this.iXM.crM() == null || this.iXM.crM().isEmpty()) {
            return null;
        }
        return this.iXM.crM();
    }

    public void qS(boolean z) {
        if (this.iXM.crQ().getValue() != null) {
            com.baidu.tieba.pb.data.f aD = this.iCx.aD(this.iXM.crQ().getValue());
            if (aD != null) {
                this.iXM.crO().addLast(this.iXM.crK());
                this.iXM.setData(aD);
                this.iXM.aL(!v.isEmpty(aD.cjr()) ? aD.cjr().get(0) : null);
                this.iXM.aK(this.iXM.crO().getLast() != null ? this.iXM.crO().getLast().ciS() : null);
                this.iCx.yS(z ? 21 : 22);
                this.iCx.h(aD);
                this.iXM.setIsLoading(true);
            }
        }
    }

    public void aM(bj bjVar) {
        com.baidu.tieba.pb.data.f aD;
        if (bjVar != null && (aD = this.iCx.aD(bjVar)) != null) {
            this.iXM.crO().addLast(this.iXM.crK());
            this.iXM.setData(aD);
            this.iXM.aL(!v.isEmpty(aD.cjr()) ? aD.cjr().get(0) : null);
            this.iXM.aK(this.iXM.crO().getLast() != null ? this.iXM.crO().getLast().ciS() : null);
            this.iCx.yS(20);
            this.iCx.h(aD);
            this.iXM.setIsLoading(true);
        }
    }

    public void crV() {
        com.baidu.tieba.pb.data.f pollLast = this.iXM.crO().pollLast();
        if (pollLast != null) {
            this.iXM.setData(pollLast);
            this.iXM.aL(!v.isEmpty(pollLast.cjr()) ? pollLast.cjr().get(0) : null);
            this.iXM.aK(this.iXM.crO().peekLast() != null ? this.iXM.crO().peekLast().ciS() : null);
            this.iCx.h(pollLast);
            this.iXM.setIsLoading(true);
        }
    }

    public p<bj> crP() {
        return this.iXM.crP();
    }

    public p<bj> crQ() {
        return this.iXM.crQ();
    }

    public p<Boolean> crR() {
        return this.iXM.crR();
    }

    public void qQ(boolean z) {
        this.iXM.qQ(z);
    }

    public p<Boolean> crS() {
        return this.iXM.crS();
    }

    public void qR(boolean z) {
        this.iXM.qR(z);
    }

    public void setIsLoading(boolean z) {
        this.iXM.setIsLoading(z);
    }

    public p<Boolean> crT() {
        return this.iXM.crT();
    }

    public boolean crN() {
        return this.iXM.crN();
    }

    public void setCurrentTab(int i) {
        this.iXM.setCurrentTab(i);
    }

    public p<Integer> crU() {
        return this.iXM.crU();
    }
}
