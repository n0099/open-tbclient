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
    private PbModel iFV;
    private d jbb = new d();
    private int jbc = 0;

    public void init(Intent intent) {
        this.jbb.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.jbb.ra(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void g(PbModel pbModel) {
        this.iFV = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, int i) {
        boolean z = true;
        if (i >= this.jbc) {
            this.jbc = i;
            this.jbb.I(eVar);
            if (eVar != null) {
                d dVar = this.jbb;
                if (eVar.getIsNewUrl() != 1 && !eVar.cln()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.e ctA() {
        return this.jbb.ctA();
    }

    public boolean isFromCDN() {
        return this.jbb.isFromCDN();
    }

    public com.baidu.tieba.pb.data.e ctB() {
        return this.jbb.ctB();
    }

    public void c(com.baidu.tieba.pb.data.e eVar, int i) {
        if (i == 3) {
            this.jbb.setData(eVar);
        }
    }

    public p<bj> ctC() {
        return this.jbb.ctC();
    }

    public Rect ctD() {
        if (this.jbb.ctD() == null || this.jbb.ctD().isEmpty()) {
            return null;
        }
        return this.jbb.ctD();
    }

    public void rd(boolean z) {
        if (this.jbb.ctH().getValue() != null) {
            com.baidu.tieba.pb.data.e aH = this.iFV.aH(this.jbb.ctH().getValue());
            if (aH != null) {
                this.jbb.ctF().addLast(this.jbb.ctB());
                this.jbb.setData(aH);
                this.jbb.aP(!v.isEmpty(aH.clm()) ? aH.clm().get(0) : null);
                this.jbb.aO(this.jbb.ctF().getLast() != null ? this.jbb.ctF().getLast().ckP() : null);
                this.iFV.zg(z ? 21 : 22);
                this.iFV.h(aH);
                this.jbb.setIsLoading(true);
            }
        }
    }

    public void aQ(bj bjVar) {
        com.baidu.tieba.pb.data.e aH;
        if (bjVar != null && (aH = this.iFV.aH(bjVar)) != null) {
            this.jbb.ctF().addLast(this.jbb.ctB());
            this.jbb.setData(aH);
            this.jbb.aP(!v.isEmpty(aH.clm()) ? aH.clm().get(0) : null);
            this.jbb.aO(this.jbb.ctF().getLast() != null ? this.jbb.ctF().getLast().ckP() : null);
            this.iFV.zg(20);
            this.iFV.h(aH);
            this.jbb.setIsLoading(true);
        }
    }

    public void ctM() {
        com.baidu.tieba.pb.data.e pollLast = this.jbb.ctF().pollLast();
        if (pollLast != null) {
            this.jbb.setData(pollLast);
            this.jbb.aP(!v.isEmpty(pollLast.clm()) ? pollLast.clm().get(0) : null);
            this.jbb.aO(this.jbb.ctF().peekLast() != null ? this.jbb.ctF().peekLast().ckP() : null);
            this.iFV.h(pollLast);
            this.jbb.setIsLoading(true);
        }
    }

    public p<bj> ctG() {
        return this.jbb.ctG();
    }

    public p<bj> ctH() {
        return this.jbb.ctH();
    }

    public p<Boolean> ctI() {
        return this.jbb.ctI();
    }

    public void rb(boolean z) {
        this.jbb.rb(z);
    }

    public p<Boolean> ctJ() {
        return this.jbb.ctJ();
    }

    public void rc(boolean z) {
        this.jbb.rc(z);
    }

    public void setIsLoading(boolean z) {
        this.jbb.setIsLoading(z);
    }

    public p<Boolean> ctK() {
        return this.jbb.ctK();
    }

    public boolean ctE() {
        return this.jbb.ctE();
    }

    public void setCurrentTab(int i) {
        this.jbb.setCurrentTab(i);
    }

    public p<Integer> ctL() {
        return this.jbb.ctL();
    }
}
