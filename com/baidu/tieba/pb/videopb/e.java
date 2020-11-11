package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.arch.lifecycle.w;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes22.dex */
public class e extends w {
    private d lMV = new d();
    private int lMW = 0;
    private PbModel lpS;

    public void init(Intent intent) {
        this.lMV.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.lMV.vw(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.lpS = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.lMW) {
            this.lMW = i;
            this.lMV.L(fVar);
            if (fVar != null) {
                d dVar = this.lMV;
                if (fVar.getIsNewUrl() != 1 && !fVar.diN()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f drn() {
        return this.lMV.drn();
    }

    public boolean isFromCDN() {
        return this.lMV.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f dro() {
        return this.lMV.dro();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.lMV.setData(fVar);
        }
    }

    public p<bw> drp() {
        return this.lMV.drp();
    }

    public Rect drq() {
        if (this.lMV.drq() == null || this.lMV.drq().isEmpty()) {
            return null;
        }
        return this.lMV.drq();
    }

    public void vz(boolean z) {
        if (this.lMV.dru().getValue() != null) {
            com.baidu.tieba.pb.data.f aI = this.lpS.aI(this.lMV.dru().getValue());
            if (aI != null) {
                this.lMV.drs().addLast(this.lMV.dro());
                this.lMV.setData(aI);
                this.lMV.aQ(!y.isEmpty(aI.diM()) ? aI.diM().get(0) : null);
                this.lMV.aP(this.lMV.drs().getLast() != null ? this.lMV.drs().getLast().dik() : null);
                this.lpS.Gc(z ? 21 : 22);
                this.lpS.j(aI);
                this.lMV.setIsLoading(true);
            }
        }
    }

    public void aR(bw bwVar) {
        com.baidu.tieba.pb.data.f aI;
        if (bwVar != null && (aI = this.lpS.aI(bwVar)) != null) {
            this.lMV.drs().addLast(this.lMV.dro());
            this.lMV.setData(aI);
            this.lMV.aQ(!y.isEmpty(aI.diM()) ? aI.diM().get(0) : null);
            this.lMV.aP(this.lMV.drs().getLast() != null ? this.lMV.drs().getLast().dik() : null);
            this.lpS.Gc(20);
            this.lpS.j(aI);
            this.lMV.setIsLoading(true);
        }
    }

    public void drz() {
        com.baidu.tieba.pb.data.f pollLast = this.lMV.drs().pollLast();
        if (pollLast != null) {
            this.lMV.setData(pollLast);
            this.lMV.aQ(!y.isEmpty(pollLast.diM()) ? pollLast.diM().get(0) : null);
            this.lMV.aP(this.lMV.drs().peekLast() != null ? this.lMV.drs().peekLast().dik() : null);
            this.lpS.j(pollLast);
            this.lMV.setIsLoading(true);
        }
    }

    public p<bw> drt() {
        return this.lMV.drt();
    }

    public p<bw> dru() {
        return this.lMV.dru();
    }

    public p<Boolean> drv() {
        return this.lMV.drv();
    }

    public void vx(boolean z) {
        this.lMV.vx(z);
    }

    public p<Boolean> drw() {
        return this.lMV.drw();
    }

    public void vy(boolean z) {
        this.lMV.vy(z);
    }

    public void setIsLoading(boolean z) {
        this.lMV.setIsLoading(z);
    }

    public p<Boolean> drx() {
        return this.lMV.drx();
    }

    public boolean drr() {
        return this.lMV.drr();
    }

    public p<Integer> dry() {
        return this.lMV.dry();
    }
}
