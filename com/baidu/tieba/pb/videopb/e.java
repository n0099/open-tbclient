package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.arch.lifecycle.w;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes21.dex */
public class e extends w {
    private d lNn = new d();
    private int lNo = 0;
    private PbModel lqh;

    public void init(Intent intent) {
        this.lNn.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.lNn.vz(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.lqh = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.lNo) {
            this.lNo = i;
            this.lNn.N(fVar);
            if (fVar != null) {
                d dVar = this.lNn;
                if (fVar.getIsNewUrl() != 1 && !fVar.dik()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f dqN() {
        return this.lNn.dqN();
    }

    public boolean isFromCDN() {
        return this.lNn.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f dqO() {
        return this.lNn.dqO();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.lNn.setData(fVar);
        }
    }

    public p<bx> dqP() {
        return this.lNn.dqP();
    }

    public Rect dqQ() {
        if (this.lNn.dqQ() == null || this.lNn.dqQ().isEmpty()) {
            return null;
        }
        return this.lNn.dqQ();
    }

    public void vC(boolean z) {
        if (this.lNn.dqU().getValue() != null) {
            com.baidu.tieba.pb.data.f aK = this.lqh.aK(this.lNn.dqU().getValue());
            if (aK != null) {
                this.lNn.dqS().addLast(this.lNn.dqO());
                this.lNn.setData(aK);
                this.lNn.aS(!y.isEmpty(aK.dij()) ? aK.dij().get(0) : null);
                this.lNn.aR(this.lNn.dqS().getLast() != null ? this.lNn.dqS().getLast().dhH() : null);
                this.lqh.GA(z ? 21 : 22);
                this.lqh.j(aK);
                this.lNn.setIsLoading(true);
            }
        }
    }

    public void aT(bx bxVar) {
        com.baidu.tieba.pb.data.f aK;
        if (bxVar != null && (aK = this.lqh.aK(bxVar)) != null) {
            this.lNn.dqS().addLast(this.lNn.dqO());
            this.lNn.setData(aK);
            this.lNn.aS(!y.isEmpty(aK.dij()) ? aK.dij().get(0) : null);
            this.lNn.aR(this.lNn.dqS().getLast() != null ? this.lNn.dqS().getLast().dhH() : null);
            this.lqh.GA(20);
            this.lqh.j(aK);
            this.lNn.setIsLoading(true);
        }
    }

    public void dqZ() {
        com.baidu.tieba.pb.data.f pollLast = this.lNn.dqS().pollLast();
        if (pollLast != null) {
            this.lNn.setData(pollLast);
            this.lNn.aS(!y.isEmpty(pollLast.dij()) ? pollLast.dij().get(0) : null);
            this.lNn.aR(this.lNn.dqS().peekLast() != null ? this.lNn.dqS().peekLast().dhH() : null);
            this.lqh.j(pollLast);
            this.lNn.setIsLoading(true);
        }
    }

    public p<bx> dqT() {
        return this.lNn.dqT();
    }

    public p<bx> dqU() {
        return this.lNn.dqU();
    }

    public p<Boolean> dqV() {
        return this.lNn.dqV();
    }

    public void vA(boolean z) {
        this.lNn.vA(z);
    }

    public p<Boolean> dqW() {
        return this.lNn.dqW();
    }

    public void vB(boolean z) {
        this.lNn.vB(z);
    }

    public void setIsLoading(boolean z) {
        this.lNn.setIsLoading(z);
    }

    public p<Boolean> dqX() {
        return this.lNn.dqX();
    }

    public boolean dqR() {
        return this.lNn.dqR();
    }

    public p<Integer> dqY() {
        return this.lNn.dqY();
    }
}
