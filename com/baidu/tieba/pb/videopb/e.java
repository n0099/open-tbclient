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
    private PbModel iEi;
    private d iZp = new d();
    private int iZq = 0;

    public void init(Intent intent) {
        this.iZp.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.iZp.qU(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void g(PbModel pbModel) {
        this.iEi = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, int i) {
        boolean z = true;
        if (i >= this.iZq) {
            this.iZq = i;
            this.iZp.I(eVar);
            if (eVar != null) {
                d dVar = this.iZp;
                if (eVar.getIsNewUrl() != 1 && !eVar.ckS()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.e cte() {
        return this.iZp.cte();
    }

    public boolean isFromCDN() {
        return this.iZp.isFromCDN();
    }

    public com.baidu.tieba.pb.data.e ctf() {
        return this.iZp.ctf();
    }

    public void c(com.baidu.tieba.pb.data.e eVar, int i) {
        if (i == 3) {
            this.iZp.setData(eVar);
        }
    }

    public p<bj> ctg() {
        return this.iZp.ctg();
    }

    public Rect cth() {
        if (this.iZp.cth() == null || this.iZp.cth().isEmpty()) {
            return null;
        }
        return this.iZp.cth();
    }

    public void qX(boolean z) {
        if (this.iZp.ctl().getValue() != null) {
            com.baidu.tieba.pb.data.e aG = this.iEi.aG(this.iZp.ctl().getValue());
            if (aG != null) {
                this.iZp.ctj().addLast(this.iZp.ctf());
                this.iZp.setData(aG);
                this.iZp.aO(!v.isEmpty(aG.ckR()) ? aG.ckR().get(0) : null);
                this.iZp.aN(this.iZp.ctj().getLast() != null ? this.iZp.ctj().getLast().cku() : null);
                this.iEi.yY(z ? 21 : 22);
                this.iEi.h(aG);
                this.iZp.setIsLoading(true);
            }
        }
    }

    public void aP(bj bjVar) {
        com.baidu.tieba.pb.data.e aG;
        if (bjVar != null && (aG = this.iEi.aG(bjVar)) != null) {
            this.iZp.ctj().addLast(this.iZp.ctf());
            this.iZp.setData(aG);
            this.iZp.aO(!v.isEmpty(aG.ckR()) ? aG.ckR().get(0) : null);
            this.iZp.aN(this.iZp.ctj().getLast() != null ? this.iZp.ctj().getLast().cku() : null);
            this.iEi.yY(20);
            this.iEi.h(aG);
            this.iZp.setIsLoading(true);
        }
    }

    public void ctq() {
        com.baidu.tieba.pb.data.e pollLast = this.iZp.ctj().pollLast();
        if (pollLast != null) {
            this.iZp.setData(pollLast);
            this.iZp.aO(!v.isEmpty(pollLast.ckR()) ? pollLast.ckR().get(0) : null);
            this.iZp.aN(this.iZp.ctj().peekLast() != null ? this.iZp.ctj().peekLast().cku() : null);
            this.iEi.h(pollLast);
            this.iZp.setIsLoading(true);
        }
    }

    public p<bj> ctk() {
        return this.iZp.ctk();
    }

    public p<bj> ctl() {
        return this.iZp.ctl();
    }

    public p<Boolean> ctm() {
        return this.iZp.ctm();
    }

    public void qV(boolean z) {
        this.iZp.qV(z);
    }

    public p<Boolean> ctn() {
        return this.iZp.ctn();
    }

    public void qW(boolean z) {
        this.iZp.qW(z);
    }

    public void setIsLoading(boolean z) {
        this.iZp.setIsLoading(z);
    }

    public p<Boolean> cto() {
        return this.iZp.cto();
    }

    public boolean cti() {
        return this.iZp.cti();
    }

    public void setCurrentTab(int i) {
        this.iZp.setCurrentTab(i);
    }

    public p<Integer> ctp() {
        return this.iZp.ctp();
    }
}
