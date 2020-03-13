package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.arch.lifecycle.w;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes9.dex */
public class e extends w {
    private PbModel iEu;
    private d iZB = new d();
    private int iZC = 0;

    public void init(Intent intent) {
        this.iZB.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.iZB.qU(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void g(PbModel pbModel) {
        this.iEu = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, int i) {
        boolean z = true;
        if (i >= this.iZC) {
            this.iZC = i;
            this.iZB.I(eVar);
            if (eVar != null) {
                d dVar = this.iZB;
                if (eVar.getIsNewUrl() != 1 && !eVar.ckT()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.e ctf() {
        return this.iZB.ctf();
    }

    public boolean isFromCDN() {
        return this.iZB.isFromCDN();
    }

    public com.baidu.tieba.pb.data.e ctg() {
        return this.iZB.ctg();
    }

    public void c(com.baidu.tieba.pb.data.e eVar, int i) {
        if (i == 3) {
            this.iZB.setData(eVar);
        }
    }

    public p<bj> cth() {
        return this.iZB.cth();
    }

    public Rect cti() {
        if (this.iZB.cti() == null || this.iZB.cti().isEmpty()) {
            return null;
        }
        return this.iZB.cti();
    }

    public void qX(boolean z) {
        if (this.iZB.ctm().getValue() != null) {
            com.baidu.tieba.pb.data.e aG = this.iEu.aG(this.iZB.ctm().getValue());
            if (aG != null) {
                this.iZB.ctk().addLast(this.iZB.ctg());
                this.iZB.setData(aG);
                this.iZB.aO(!v.isEmpty(aG.ckS()) ? aG.ckS().get(0) : null);
                this.iZB.aN(this.iZB.ctk().getLast() != null ? this.iZB.ctk().getLast().ckv() : null);
                this.iEu.yY(z ? 21 : 22);
                this.iEu.h(aG);
                this.iZB.setIsLoading(true);
            }
        }
    }

    public void aP(bj bjVar) {
        com.baidu.tieba.pb.data.e aG;
        if (bjVar != null && (aG = this.iEu.aG(bjVar)) != null) {
            this.iZB.ctk().addLast(this.iZB.ctg());
            this.iZB.setData(aG);
            this.iZB.aO(!v.isEmpty(aG.ckS()) ? aG.ckS().get(0) : null);
            this.iZB.aN(this.iZB.ctk().getLast() != null ? this.iZB.ctk().getLast().ckv() : null);
            this.iEu.yY(20);
            this.iEu.h(aG);
            this.iZB.setIsLoading(true);
        }
    }

    public void ctr() {
        com.baidu.tieba.pb.data.e pollLast = this.iZB.ctk().pollLast();
        if (pollLast != null) {
            this.iZB.setData(pollLast);
            this.iZB.aO(!v.isEmpty(pollLast.ckS()) ? pollLast.ckS().get(0) : null);
            this.iZB.aN(this.iZB.ctk().peekLast() != null ? this.iZB.ctk().peekLast().ckv() : null);
            this.iEu.h(pollLast);
            this.iZB.setIsLoading(true);
        }
    }

    public p<bj> ctl() {
        return this.iZB.ctl();
    }

    public p<bj> ctm() {
        return this.iZB.ctm();
    }

    public p<Boolean> ctn() {
        return this.iZB.ctn();
    }

    public void qV(boolean z) {
        this.iZB.qV(z);
    }

    public p<Boolean> cto() {
        return this.iZB.cto();
    }

    public void qW(boolean z) {
        this.iZB.qW(z);
    }

    public void setIsLoading(boolean z) {
        this.iZB.setIsLoading(z);
    }

    public p<Boolean> ctp() {
        return this.iZB.ctp();
    }

    public boolean ctj() {
        return this.iZB.ctj();
    }

    public void setCurrentTab(int i) {
        this.iZB.setCurrentTab(i);
    }

    public p<Integer> ctq() {
        return this.iZB.ctq();
    }
}
