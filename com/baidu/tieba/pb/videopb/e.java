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
    private d lGZ = new d();
    private int lHa = 0;
    private PbModel ljR;

    public void init(Intent intent) {
        this.lGZ.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.lGZ.vn(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.ljR = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.lHa) {
            this.lHa = i;
            this.lGZ.L(fVar);
            if (fVar != null) {
                d dVar = this.lGZ;
                if (fVar.getIsNewUrl() != 1 && !fVar.dgl()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f doL() {
        return this.lGZ.doL();
    }

    public boolean isFromCDN() {
        return this.lGZ.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f doM() {
        return this.lGZ.doM();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.lGZ.setData(fVar);
        }
    }

    public p<bw> doN() {
        return this.lGZ.doN();
    }

    public Rect doO() {
        if (this.lGZ.doO() == null || this.lGZ.doO().isEmpty()) {
            return null;
        }
        return this.lGZ.doO();
    }

    public void vq(boolean z) {
        if (this.lGZ.doS().getValue() != null) {
            com.baidu.tieba.pb.data.f aI = this.ljR.aI(this.lGZ.doS().getValue());
            if (aI != null) {
                this.lGZ.doQ().addLast(this.lGZ.doM());
                this.lGZ.setData(aI);
                this.lGZ.aQ(!y.isEmpty(aI.dgk()) ? aI.dgk().get(0) : null);
                this.lGZ.aP(this.lGZ.doQ().getLast() != null ? this.lGZ.doQ().getLast().dfI() : null);
                this.ljR.FP(z ? 21 : 22);
                this.ljR.j(aI);
                this.lGZ.setIsLoading(true);
            }
        }
    }

    public void aR(bw bwVar) {
        com.baidu.tieba.pb.data.f aI;
        if (bwVar != null && (aI = this.ljR.aI(bwVar)) != null) {
            this.lGZ.doQ().addLast(this.lGZ.doM());
            this.lGZ.setData(aI);
            this.lGZ.aQ(!y.isEmpty(aI.dgk()) ? aI.dgk().get(0) : null);
            this.lGZ.aP(this.lGZ.doQ().getLast() != null ? this.lGZ.doQ().getLast().dfI() : null);
            this.ljR.FP(20);
            this.ljR.j(aI);
            this.lGZ.setIsLoading(true);
        }
    }

    public void doX() {
        com.baidu.tieba.pb.data.f pollLast = this.lGZ.doQ().pollLast();
        if (pollLast != null) {
            this.lGZ.setData(pollLast);
            this.lGZ.aQ(!y.isEmpty(pollLast.dgk()) ? pollLast.dgk().get(0) : null);
            this.lGZ.aP(this.lGZ.doQ().peekLast() != null ? this.lGZ.doQ().peekLast().dfI() : null);
            this.ljR.j(pollLast);
            this.lGZ.setIsLoading(true);
        }
    }

    public p<bw> doR() {
        return this.lGZ.doR();
    }

    public p<bw> doS() {
        return this.lGZ.doS();
    }

    public p<Boolean> doT() {
        return this.lGZ.doT();
    }

    public void vo(boolean z) {
        this.lGZ.vo(z);
    }

    public p<Boolean> doU() {
        return this.lGZ.doU();
    }

    public void vp(boolean z) {
        this.lGZ.vp(z);
    }

    public void setIsLoading(boolean z) {
        this.lGZ.setIsLoading(z);
    }

    public p<Boolean> doV() {
        return this.lGZ.doV();
    }

    public boolean doP() {
        return this.lGZ.doP();
    }

    public p<Integer> doW() {
        return this.lGZ.doW();
    }
}
