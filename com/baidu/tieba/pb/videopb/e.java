package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.arch.lifecycle.w;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes21.dex */
public class e extends w {
    private PbModel kIh;
    private d lfk = new d();
    private int lfl = 0;

    public void init(Intent intent) {
        this.lfk.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.lfk.up(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.kIh = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.lfl) {
            this.lfl = i;
            this.lfk.L(fVar);
            if (fVar != null) {
                d dVar = this.lfk;
                if (fVar.getIsNewUrl() != 1 && !fVar.cZu()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f dhU() {
        return this.lfk.dhU();
    }

    public boolean isFromCDN() {
        return this.lfk.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f dhV() {
        return this.lfk.dhV();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.lfk.setData(fVar);
        }
    }

    public p<bw> dhW() {
        return this.lfk.dhW();
    }

    public Rect dhX() {
        if (this.lfk.dhX() == null || this.lfk.dhX().isEmpty()) {
            return null;
        }
        return this.lfk.dhX();
    }

    public void us(boolean z) {
        if (this.lfk.dib().getValue() != null) {
            com.baidu.tieba.pb.data.f aI = this.kIh.aI(this.lfk.dib().getValue());
            if (aI != null) {
                this.lfk.dhZ().addLast(this.lfk.dhV());
                this.lfk.setData(aI);
                this.lfk.aQ(!y.isEmpty(aI.cZt()) ? aI.cZt().get(0) : null);
                this.lfk.aP(this.lfk.dhZ().getLast() != null ? this.lfk.dhZ().getLast().cYR() : null);
                this.kIh.EQ(z ? 21 : 22);
                this.kIh.j(aI);
                this.lfk.setIsLoading(true);
            }
        }
    }

    public void aR(bw bwVar) {
        com.baidu.tieba.pb.data.f aI;
        if (bwVar != null && (aI = this.kIh.aI(bwVar)) != null) {
            this.lfk.dhZ().addLast(this.lfk.dhV());
            this.lfk.setData(aI);
            this.lfk.aQ(!y.isEmpty(aI.cZt()) ? aI.cZt().get(0) : null);
            this.lfk.aP(this.lfk.dhZ().getLast() != null ? this.lfk.dhZ().getLast().cYR() : null);
            this.kIh.EQ(20);
            this.kIh.j(aI);
            this.lfk.setIsLoading(true);
        }
    }

    public void dig() {
        com.baidu.tieba.pb.data.f pollLast = this.lfk.dhZ().pollLast();
        if (pollLast != null) {
            this.lfk.setData(pollLast);
            this.lfk.aQ(!y.isEmpty(pollLast.cZt()) ? pollLast.cZt().get(0) : null);
            this.lfk.aP(this.lfk.dhZ().peekLast() != null ? this.lfk.dhZ().peekLast().cYR() : null);
            this.kIh.j(pollLast);
            this.lfk.setIsLoading(true);
        }
    }

    public p<bw> dia() {
        return this.lfk.dia();
    }

    public p<bw> dib() {
        return this.lfk.dib();
    }

    public p<Boolean> dic() {
        return this.lfk.dic();
    }

    public void uq(boolean z) {
        this.lfk.uq(z);
    }

    public p<Boolean> did() {
        return this.lfk.did();
    }

    public void ur(boolean z) {
        this.lfk.ur(z);
    }

    public void setIsLoading(boolean z) {
        this.lfk.setIsLoading(z);
    }

    public p<Boolean> die() {
        return this.lfk.die();
    }

    public boolean dhY() {
        return this.lfk.dhY();
    }

    public p<Integer> dif() {
        return this.lfk.dif();
    }
}
