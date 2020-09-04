package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.arch.lifecycle.w;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes16.dex */
public class e extends w {
    private d kWF = new d();
    private int kWG = 0;
    private PbModel kzK;

    public void init(Intent intent) {
        this.kWF.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.kWF.uh(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.kzK = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.kWG) {
            this.kWG = i;
            this.kWF.L(fVar);
            if (fVar != null) {
                d dVar = this.kWF;
                if (fVar.getIsNewUrl() != 1 && !fVar.cVP()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f deq() {
        return this.kWF.deq();
    }

    public boolean isFromCDN() {
        return this.kWF.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f der() {
        return this.kWF.der();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.kWF.setData(fVar);
        }
    }

    public p<bw> des() {
        return this.kWF.des();
    }

    public Rect det() {
        if (this.kWF.det() == null || this.kWF.det().isEmpty()) {
            return null;
        }
        return this.kWF.det();
    }

    public void uk(boolean z) {
        if (this.kWF.dex().getValue() != null) {
            com.baidu.tieba.pb.data.f aH = this.kzK.aH(this.kWF.dex().getValue());
            if (aH != null) {
                this.kWF.dev().addLast(this.kWF.der());
                this.kWF.setData(aH);
                this.kWF.aP(!y.isEmpty(aH.cVO()) ? aH.cVO().get(0) : null);
                this.kWF.aO(this.kWF.dev().getLast() != null ? this.kWF.dev().getLast().cVm() : null);
                this.kzK.Ep(z ? 21 : 22);
                this.kzK.j(aH);
                this.kWF.setIsLoading(true);
            }
        }
    }

    public void aQ(bw bwVar) {
        com.baidu.tieba.pb.data.f aH;
        if (bwVar != null && (aH = this.kzK.aH(bwVar)) != null) {
            this.kWF.dev().addLast(this.kWF.der());
            this.kWF.setData(aH);
            this.kWF.aP(!y.isEmpty(aH.cVO()) ? aH.cVO().get(0) : null);
            this.kWF.aO(this.kWF.dev().getLast() != null ? this.kWF.dev().getLast().cVm() : null);
            this.kzK.Ep(20);
            this.kzK.j(aH);
            this.kWF.setIsLoading(true);
        }
    }

    public void deC() {
        com.baidu.tieba.pb.data.f pollLast = this.kWF.dev().pollLast();
        if (pollLast != null) {
            this.kWF.setData(pollLast);
            this.kWF.aP(!y.isEmpty(pollLast.cVO()) ? pollLast.cVO().get(0) : null);
            this.kWF.aO(this.kWF.dev().peekLast() != null ? this.kWF.dev().peekLast().cVm() : null);
            this.kzK.j(pollLast);
            this.kWF.setIsLoading(true);
        }
    }

    public p<bw> dew() {
        return this.kWF.dew();
    }

    public p<bw> dex() {
        return this.kWF.dex();
    }

    public p<Boolean> dey() {
        return this.kWF.dey();
    }

    public void ui(boolean z) {
        this.kWF.ui(z);
    }

    public p<Boolean> dez() {
        return this.kWF.dez();
    }

    public void uj(boolean z) {
        this.kWF.uj(z);
    }

    public void setIsLoading(boolean z) {
        this.kWF.setIsLoading(z);
    }

    public p<Boolean> deA() {
        return this.kWF.deA();
    }

    public boolean deu() {
        return this.kWF.deu();
    }

    public p<Integer> deB() {
        return this.kWF.deB();
    }
}
