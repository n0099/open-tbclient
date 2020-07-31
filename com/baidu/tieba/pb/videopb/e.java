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
    private d kGP = new d();
    private int kGQ = 0;
    private PbModel kkj;

    public void init(Intent intent) {
        this.kGP.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.kGP.tw(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.kkj = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.kGQ) {
            this.kGQ = i;
            this.kGP.L(fVar);
            if (fVar != null) {
                d dVar = this.kGP;
                if (fVar.getIsNewUrl() != 1 && !fVar.cLa()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f cTx() {
        return this.kGP.cTx();
    }

    public boolean isFromCDN() {
        return this.kGP.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f cTy() {
        return this.kGP.cTy();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.kGP.setData(fVar);
        }
    }

    public p<bv> cTz() {
        return this.kGP.cTz();
    }

    public Rect cTA() {
        if (this.kGP.cTA() == null || this.kGP.cTA().isEmpty()) {
            return null;
        }
        return this.kGP.cTA();
    }

    public void tz(boolean z) {
        if (this.kGP.cTE().getValue() != null) {
            com.baidu.tieba.pb.data.f aG = this.kkj.aG(this.kGP.cTE().getValue());
            if (aG != null) {
                this.kGP.cTC().addLast(this.kGP.cTy());
                this.kGP.setData(aG);
                this.kGP.aO(!x.isEmpty(aG.cKZ()) ? aG.cKZ().get(0) : null);
                this.kGP.aN(this.kGP.cTC().getLast() != null ? this.kGP.cTC().getLast().cKx() : null);
                this.kkj.BV(z ? 21 : 22);
                this.kkj.j(aG);
                this.kGP.setIsLoading(true);
            }
        }
    }

    public void aP(bv bvVar) {
        com.baidu.tieba.pb.data.f aG;
        if (bvVar != null && (aG = this.kkj.aG(bvVar)) != null) {
            this.kGP.cTC().addLast(this.kGP.cTy());
            this.kGP.setData(aG);
            this.kGP.aO(!x.isEmpty(aG.cKZ()) ? aG.cKZ().get(0) : null);
            this.kGP.aN(this.kGP.cTC().getLast() != null ? this.kGP.cTC().getLast().cKx() : null);
            this.kkj.BV(20);
            this.kkj.j(aG);
            this.kGP.setIsLoading(true);
        }
    }

    public void cTJ() {
        com.baidu.tieba.pb.data.f pollLast = this.kGP.cTC().pollLast();
        if (pollLast != null) {
            this.kGP.setData(pollLast);
            this.kGP.aO(!x.isEmpty(pollLast.cKZ()) ? pollLast.cKZ().get(0) : null);
            this.kGP.aN(this.kGP.cTC().peekLast() != null ? this.kGP.cTC().peekLast().cKx() : null);
            this.kkj.j(pollLast);
            this.kGP.setIsLoading(true);
        }
    }

    public p<bv> cTD() {
        return this.kGP.cTD();
    }

    public p<bv> cTE() {
        return this.kGP.cTE();
    }

    public p<Boolean> cTF() {
        return this.kGP.cTF();
    }

    public void tx(boolean z) {
        this.kGP.tx(z);
    }

    public p<Boolean> cTG() {
        return this.kGP.cTG();
    }

    public void ty(boolean z) {
        this.kGP.ty(z);
    }

    public void setIsLoading(boolean z) {
        this.kGP.setIsLoading(z);
    }

    public p<Boolean> cTH() {
        return this.kGP.cTH();
    }

    public boolean cTB() {
        return this.kGP.cTB();
    }

    public p<Integer> cTI() {
        return this.kGP.cTI();
    }
}
