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
    private PbModel iEg;
    private d iZn = new d();
    private int iZo = 0;

    public void init(Intent intent) {
        this.iZn.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.iZn.qU(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void g(PbModel pbModel) {
        this.iEg = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, int i) {
        boolean z = true;
        if (i >= this.iZo) {
            this.iZo = i;
            this.iZn.I(eVar);
            if (eVar != null) {
                d dVar = this.iZn;
                if (eVar.getIsNewUrl() != 1 && !eVar.ckQ()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.e ctc() {
        return this.iZn.ctc();
    }

    public boolean isFromCDN() {
        return this.iZn.isFromCDN();
    }

    public com.baidu.tieba.pb.data.e ctd() {
        return this.iZn.ctd();
    }

    public void c(com.baidu.tieba.pb.data.e eVar, int i) {
        if (i == 3) {
            this.iZn.setData(eVar);
        }
    }

    public p<bj> cte() {
        return this.iZn.cte();
    }

    public Rect ctf() {
        if (this.iZn.ctf() == null || this.iZn.ctf().isEmpty()) {
            return null;
        }
        return this.iZn.ctf();
    }

    public void qX(boolean z) {
        if (this.iZn.ctj().getValue() != null) {
            com.baidu.tieba.pb.data.e aG = this.iEg.aG(this.iZn.ctj().getValue());
            if (aG != null) {
                this.iZn.cth().addLast(this.iZn.ctd());
                this.iZn.setData(aG);
                this.iZn.aO(!v.isEmpty(aG.ckP()) ? aG.ckP().get(0) : null);
                this.iZn.aN(this.iZn.cth().getLast() != null ? this.iZn.cth().getLast().cks() : null);
                this.iEg.yY(z ? 21 : 22);
                this.iEg.h(aG);
                this.iZn.setIsLoading(true);
            }
        }
    }

    public void aP(bj bjVar) {
        com.baidu.tieba.pb.data.e aG;
        if (bjVar != null && (aG = this.iEg.aG(bjVar)) != null) {
            this.iZn.cth().addLast(this.iZn.ctd());
            this.iZn.setData(aG);
            this.iZn.aO(!v.isEmpty(aG.ckP()) ? aG.ckP().get(0) : null);
            this.iZn.aN(this.iZn.cth().getLast() != null ? this.iZn.cth().getLast().cks() : null);
            this.iEg.yY(20);
            this.iEg.h(aG);
            this.iZn.setIsLoading(true);
        }
    }

    public void cto() {
        com.baidu.tieba.pb.data.e pollLast = this.iZn.cth().pollLast();
        if (pollLast != null) {
            this.iZn.setData(pollLast);
            this.iZn.aO(!v.isEmpty(pollLast.ckP()) ? pollLast.ckP().get(0) : null);
            this.iZn.aN(this.iZn.cth().peekLast() != null ? this.iZn.cth().peekLast().cks() : null);
            this.iEg.h(pollLast);
            this.iZn.setIsLoading(true);
        }
    }

    public p<bj> cti() {
        return this.iZn.cti();
    }

    public p<bj> ctj() {
        return this.iZn.ctj();
    }

    public p<Boolean> ctk() {
        return this.iZn.ctk();
    }

    public void qV(boolean z) {
        this.iZn.qV(z);
    }

    public p<Boolean> ctl() {
        return this.iZn.ctl();
    }

    public void qW(boolean z) {
        this.iZn.qW(z);
    }

    public void setIsLoading(boolean z) {
        this.iZn.setIsLoading(z);
    }

    public p<Boolean> ctm() {
        return this.iZn.ctm();
    }

    public boolean ctg() {
        return this.iZn.ctg();
    }

    public void setCurrentTab(int i) {
        this.iZn.setCurrentTab(i);
    }

    public p<Integer> ctn() {
        return this.iZn.ctn();
    }
}
