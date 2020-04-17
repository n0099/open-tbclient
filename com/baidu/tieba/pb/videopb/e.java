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
    private d jLj = new d();
    private int jLk = 0;
    private PbModel jqc;

    public void init(Intent intent) {
        this.jLj.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.jLj.se(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void g(PbModel pbModel) {
        this.jqc = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, int i) {
        boolean z = true;
        if (i >= this.jLk) {
            this.jLk = i;
            this.jLj.I(eVar);
            if (eVar != null) {
                d dVar = this.jLj;
                if (eVar.getIsNewUrl() != 1 && !eVar.cvS()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.e cEg() {
        return this.jLj.cEg();
    }

    public boolean isFromCDN() {
        return this.jLj.isFromCDN();
    }

    public com.baidu.tieba.pb.data.e cEh() {
        return this.jLj.cEh();
    }

    public void c(com.baidu.tieba.pb.data.e eVar, int i) {
        if (i == 3) {
            this.jLj.setData(eVar);
        }
    }

    public p<bj> cEi() {
        return this.jLj.cEi();
    }

    public Rect cEj() {
        if (this.jLj.cEj() == null || this.jLj.cEj().isEmpty()) {
            return null;
        }
        return this.jLj.cEj();
    }

    public void sh(boolean z) {
        if (this.jLj.cEn().getValue() != null) {
            com.baidu.tieba.pb.data.e aI = this.jqc.aI(this.jLj.cEn().getValue());
            if (aI != null) {
                this.jLj.cEl().addLast(this.jLj.cEh());
                this.jLj.setData(aI);
                this.jLj.aQ(!v.isEmpty(aI.cvR()) ? aI.cvR().get(0) : null);
                this.jLj.aP(this.jLj.cEl().getLast() != null ? this.jLj.cEl().getLast().cvu() : null);
                this.jqc.zH(z ? 21 : 22);
                this.jqc.h(aI);
                this.jLj.setIsLoading(true);
            }
        }
    }

    public void aR(bj bjVar) {
        com.baidu.tieba.pb.data.e aI;
        if (bjVar != null && (aI = this.jqc.aI(bjVar)) != null) {
            this.jLj.cEl().addLast(this.jLj.cEh());
            this.jLj.setData(aI);
            this.jLj.aQ(!v.isEmpty(aI.cvR()) ? aI.cvR().get(0) : null);
            this.jLj.aP(this.jLj.cEl().getLast() != null ? this.jLj.cEl().getLast().cvu() : null);
            this.jqc.zH(20);
            this.jqc.h(aI);
            this.jLj.setIsLoading(true);
        }
    }

    public void cEs() {
        com.baidu.tieba.pb.data.e pollLast = this.jLj.cEl().pollLast();
        if (pollLast != null) {
            this.jLj.setData(pollLast);
            this.jLj.aQ(!v.isEmpty(pollLast.cvR()) ? pollLast.cvR().get(0) : null);
            this.jLj.aP(this.jLj.cEl().peekLast() != null ? this.jLj.cEl().peekLast().cvu() : null);
            this.jqc.h(pollLast);
            this.jLj.setIsLoading(true);
        }
    }

    public p<bj> cEm() {
        return this.jLj.cEm();
    }

    public p<bj> cEn() {
        return this.jLj.cEn();
    }

    public p<Boolean> cEo() {
        return this.jLj.cEo();
    }

    public void sf(boolean z) {
        this.jLj.sf(z);
    }

    public p<Boolean> cEp() {
        return this.jLj.cEp();
    }

    public void sg(boolean z) {
        this.jLj.sg(z);
    }

    public void setIsLoading(boolean z) {
        this.jLj.setIsLoading(z);
    }

    public p<Boolean> cEq() {
        return this.jLj.cEq();
    }

    public boolean cEk() {
        return this.jLj.cEk();
    }

    public void setCurrentTab(int i) {
        this.jLj.setCurrentTab(i);
    }

    public p<Integer> cEr() {
        return this.jLj.cEr();
    }
}
