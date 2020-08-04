package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.arch.lifecycle.w;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes16.dex */
public class e extends w {
    private d kGR = new d();
    private int kGS = 0;
    private PbModel kkl;

    public void init(Intent intent) {
        this.kGR.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.kGR.tw(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.kkl = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.kGS) {
            this.kGS = i;
            this.kGR.L(fVar);
            if (fVar != null) {
                d dVar = this.kGR;
                if (fVar.getIsNewUrl() != 1 && !fVar.cLa()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f cTx() {
        return this.kGR.cTx();
    }

    public boolean isFromCDN() {
        return this.kGR.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f cTy() {
        return this.kGR.cTy();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.kGR.setData(fVar);
        }
    }

    public p<bv> cTz() {
        return this.kGR.cTz();
    }

    public Rect cTA() {
        if (this.kGR.cTA() == null || this.kGR.cTA().isEmpty()) {
            return null;
        }
        return this.kGR.cTA();
    }

    public void tz(boolean z) {
        if (this.kGR.cTE().getValue() != null) {
            com.baidu.tieba.pb.data.f aG = this.kkl.aG(this.kGR.cTE().getValue());
            if (aG != null) {
                this.kGR.cTC().addLast(this.kGR.cTy());
                this.kGR.setData(aG);
                this.kGR.aO(!x.isEmpty(aG.cKZ()) ? aG.cKZ().get(0) : null);
                this.kGR.aN(this.kGR.cTC().getLast() != null ? this.kGR.cTC().getLast().cKx() : null);
                this.kkl.BV(z ? 21 : 22);
                this.kkl.j(aG);
                this.kGR.setIsLoading(true);
            }
        }
    }

    public void aP(bv bvVar) {
        com.baidu.tieba.pb.data.f aG;
        if (bvVar != null && (aG = this.kkl.aG(bvVar)) != null) {
            this.kGR.cTC().addLast(this.kGR.cTy());
            this.kGR.setData(aG);
            this.kGR.aO(!x.isEmpty(aG.cKZ()) ? aG.cKZ().get(0) : null);
            this.kGR.aN(this.kGR.cTC().getLast() != null ? this.kGR.cTC().getLast().cKx() : null);
            this.kkl.BV(20);
            this.kkl.j(aG);
            this.kGR.setIsLoading(true);
        }
    }

    public void cTJ() {
        com.baidu.tieba.pb.data.f pollLast = this.kGR.cTC().pollLast();
        if (pollLast != null) {
            this.kGR.setData(pollLast);
            this.kGR.aO(!x.isEmpty(pollLast.cKZ()) ? pollLast.cKZ().get(0) : null);
            this.kGR.aN(this.kGR.cTC().peekLast() != null ? this.kGR.cTC().peekLast().cKx() : null);
            this.kkl.j(pollLast);
            this.kGR.setIsLoading(true);
        }
    }

    public p<bv> cTD() {
        return this.kGR.cTD();
    }

    public p<bv> cTE() {
        return this.kGR.cTE();
    }

    public p<Boolean> cTF() {
        return this.kGR.cTF();
    }

    public void tx(boolean z) {
        this.kGR.tx(z);
    }

    public p<Boolean> cTG() {
        return this.kGR.cTG();
    }

    public void ty(boolean z) {
        this.kGR.ty(z);
    }

    public void setIsLoading(boolean z) {
        this.kGR.setIsLoading(z);
    }

    public p<Boolean> cTH() {
        return this.kGR.cTH();
    }

    public boolean cTB() {
        return this.kGR.cTB();
    }

    public p<Integer> cTI() {
        return this.kGR.cTI();
    }
}
