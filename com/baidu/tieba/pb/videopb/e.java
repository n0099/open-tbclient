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
    private PbModel kXs;
    private d luB = new d();
    private int luC = 0;

    public void init(Intent intent) {
        this.luB.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.luB.uW(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.kXs = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.luC) {
            this.luC = i;
            this.luB.L(fVar);
            if (fVar != null) {
                d dVar = this.luB;
                if (fVar.getIsNewUrl() != 1 && !fVar.ddd()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f dlD() {
        return this.luB.dlD();
    }

    public boolean isFromCDN() {
        return this.luB.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f dlE() {
        return this.luB.dlE();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.luB.setData(fVar);
        }
    }

    public p<bw> dlF() {
        return this.luB.dlF();
    }

    public Rect dlG() {
        if (this.luB.dlG() == null || this.luB.dlG().isEmpty()) {
            return null;
        }
        return this.luB.dlG();
    }

    public void uZ(boolean z) {
        if (this.luB.dlK().getValue() != null) {
            com.baidu.tieba.pb.data.f aI = this.kXs.aI(this.luB.dlK().getValue());
            if (aI != null) {
                this.luB.dlI().addLast(this.luB.dlE());
                this.luB.setData(aI);
                this.luB.aQ(!y.isEmpty(aI.ddc()) ? aI.ddc().get(0) : null);
                this.luB.aP(this.luB.dlI().getLast() != null ? this.luB.dlI().getLast().dcA() : null);
                this.kXs.Fw(z ? 21 : 22);
                this.kXs.j(aI);
                this.luB.setIsLoading(true);
            }
        }
    }

    public void aR(bw bwVar) {
        com.baidu.tieba.pb.data.f aI;
        if (bwVar != null && (aI = this.kXs.aI(bwVar)) != null) {
            this.luB.dlI().addLast(this.luB.dlE());
            this.luB.setData(aI);
            this.luB.aQ(!y.isEmpty(aI.ddc()) ? aI.ddc().get(0) : null);
            this.luB.aP(this.luB.dlI().getLast() != null ? this.luB.dlI().getLast().dcA() : null);
            this.kXs.Fw(20);
            this.kXs.j(aI);
            this.luB.setIsLoading(true);
        }
    }

    public void dlP() {
        com.baidu.tieba.pb.data.f pollLast = this.luB.dlI().pollLast();
        if (pollLast != null) {
            this.luB.setData(pollLast);
            this.luB.aQ(!y.isEmpty(pollLast.ddc()) ? pollLast.ddc().get(0) : null);
            this.luB.aP(this.luB.dlI().peekLast() != null ? this.luB.dlI().peekLast().dcA() : null);
            this.kXs.j(pollLast);
            this.luB.setIsLoading(true);
        }
    }

    public p<bw> dlJ() {
        return this.luB.dlJ();
    }

    public p<bw> dlK() {
        return this.luB.dlK();
    }

    public p<Boolean> dlL() {
        return this.luB.dlL();
    }

    public void uX(boolean z) {
        this.luB.uX(z);
    }

    public p<Boolean> dlM() {
        return this.luB.dlM();
    }

    public void uY(boolean z) {
        this.luB.uY(z);
    }

    public void setIsLoading(boolean z) {
        this.luB.setIsLoading(z);
    }

    public p<Boolean> dlN() {
        return this.luB.dlN();
    }

    public boolean dlH() {
        return this.luB.dlH();
    }

    public p<Integer> dlO() {
        return this.luB.dlO();
    }
}
