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
    private d kWy = new d();
    private int kWz = 0;
    private PbModel kzD;

    public void init(Intent intent) {
        this.kWy.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.kWy.uf(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.kzD = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.kWz) {
            this.kWz = i;
            this.kWy.L(fVar);
            if (fVar != null) {
                d dVar = this.kWy;
                if (fVar.getIsNewUrl() != 1 && !fVar.cVO()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f dep() {
        return this.kWy.dep();
    }

    public boolean isFromCDN() {
        return this.kWy.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f deq() {
        return this.kWy.deq();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.kWy.setData(fVar);
        }
    }

    public p<bw> der() {
        return this.kWy.der();
    }

    public Rect des() {
        if (this.kWy.des() == null || this.kWy.des().isEmpty()) {
            return null;
        }
        return this.kWy.des();
    }

    public void ui(boolean z) {
        if (this.kWy.dew().getValue() != null) {
            com.baidu.tieba.pb.data.f aH = this.kzD.aH(this.kWy.dew().getValue());
            if (aH != null) {
                this.kWy.deu().addLast(this.kWy.deq());
                this.kWy.setData(aH);
                this.kWy.aP(!y.isEmpty(aH.cVN()) ? aH.cVN().get(0) : null);
                this.kWy.aO(this.kWy.deu().getLast() != null ? this.kWy.deu().getLast().cVl() : null);
                this.kzD.Ep(z ? 21 : 22);
                this.kzD.j(aH);
                this.kWy.setIsLoading(true);
            }
        }
    }

    public void aQ(bw bwVar) {
        com.baidu.tieba.pb.data.f aH;
        if (bwVar != null && (aH = this.kzD.aH(bwVar)) != null) {
            this.kWy.deu().addLast(this.kWy.deq());
            this.kWy.setData(aH);
            this.kWy.aP(!y.isEmpty(aH.cVN()) ? aH.cVN().get(0) : null);
            this.kWy.aO(this.kWy.deu().getLast() != null ? this.kWy.deu().getLast().cVl() : null);
            this.kzD.Ep(20);
            this.kzD.j(aH);
            this.kWy.setIsLoading(true);
        }
    }

    public void deB() {
        com.baidu.tieba.pb.data.f pollLast = this.kWy.deu().pollLast();
        if (pollLast != null) {
            this.kWy.setData(pollLast);
            this.kWy.aP(!y.isEmpty(pollLast.cVN()) ? pollLast.cVN().get(0) : null);
            this.kWy.aO(this.kWy.deu().peekLast() != null ? this.kWy.deu().peekLast().cVl() : null);
            this.kzD.j(pollLast);
            this.kWy.setIsLoading(true);
        }
    }

    public p<bw> dev() {
        return this.kWy.dev();
    }

    public p<bw> dew() {
        return this.kWy.dew();
    }

    public p<Boolean> dex() {
        return this.kWy.dex();
    }

    public void ug(boolean z) {
        this.kWy.ug(z);
    }

    public p<Boolean> dey() {
        return this.kWy.dey();
    }

    public void uh(boolean z) {
        this.kWy.uh(z);
    }

    public void setIsLoading(boolean z) {
        this.kWy.setIsLoading(z);
    }

    public p<Boolean> dez() {
        return this.kWy.dez();
    }

    public boolean det() {
        return this.kWy.det();
    }

    public p<Integer> deA() {
        return this.kWy.deA();
    }
}
