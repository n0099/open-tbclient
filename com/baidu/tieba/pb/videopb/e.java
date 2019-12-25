package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.arch.lifecycle.w;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes6.dex */
public class e extends w {
    private d iUe = new d();
    private int iUf = 0;
    private PbModel iyT;

    public void init(Intent intent) {
        this.iUe.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.iUe.qC(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void g(PbModel pbModel) {
        this.iyT = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.iUf) {
            this.iUf = i;
            this.iUe.G(fVar);
            if (fVar != null) {
                d dVar = this.iUe;
                if (fVar.getIsNewUrl() != 1 && !fVar.cik()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f cqA() {
        return this.iUe.cqA();
    }

    public boolean isFromCDN() {
        return this.iUe.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f cqB() {
        return this.iUe.cqB();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.iUe.setData(fVar);
        }
    }

    public p<bj> cqC() {
        return this.iUe.cqC();
    }

    public Rect cqD() {
        if (this.iUe.cqD() == null || this.iUe.cqD().isEmpty()) {
            return null;
        }
        return this.iUe.cqD();
    }

    public void qF(boolean z) {
        if (this.iUe.cqH().getValue() != null) {
            com.baidu.tieba.pb.data.f aC = this.iyT.aC(this.iUe.cqH().getValue());
            if (aC != null) {
                this.iUe.cqF().addLast(this.iUe.cqB());
                this.iUe.setData(aC);
                this.iUe.aK(!v.isEmpty(aC.cij()) ? aC.cij().get(0) : null);
                this.iUe.aJ(this.iUe.cqF().getLast() != null ? this.iUe.cqF().getLast().chK() : null);
                this.iyT.yN(z ? 21 : 22);
                this.iyT.h(aC);
                this.iUe.setIsLoading(true);
            }
        }
    }

    public void aL(bj bjVar) {
        com.baidu.tieba.pb.data.f aC;
        if (bjVar != null && (aC = this.iyT.aC(bjVar)) != null) {
            this.iUe.cqF().addLast(this.iUe.cqB());
            this.iUe.setData(aC);
            this.iUe.aK(!v.isEmpty(aC.cij()) ? aC.cij().get(0) : null);
            this.iUe.aJ(this.iUe.cqF().getLast() != null ? this.iUe.cqF().getLast().chK() : null);
            this.iyT.yN(20);
            this.iyT.h(aC);
            this.iUe.setIsLoading(true);
        }
    }

    public void cqM() {
        com.baidu.tieba.pb.data.f pollLast = this.iUe.cqF().pollLast();
        if (pollLast != null) {
            this.iUe.setData(pollLast);
            this.iUe.aK(!v.isEmpty(pollLast.cij()) ? pollLast.cij().get(0) : null);
            this.iUe.aJ(this.iUe.cqF().peekLast() != null ? this.iUe.cqF().peekLast().chK() : null);
            this.iyT.h(pollLast);
            this.iUe.setIsLoading(true);
        }
    }

    public p<bj> cqG() {
        return this.iUe.cqG();
    }

    public p<bj> cqH() {
        return this.iUe.cqH();
    }

    public p<Boolean> cqI() {
        return this.iUe.cqI();
    }

    public void qD(boolean z) {
        this.iUe.qD(z);
    }

    public p<Boolean> cqJ() {
        return this.iUe.cqJ();
    }

    public void qE(boolean z) {
        this.iUe.qE(z);
    }

    public void setIsLoading(boolean z) {
        this.iUe.setIsLoading(z);
    }

    public p<Boolean> cqK() {
        return this.iUe.cqK();
    }

    public boolean cqE() {
        return this.iUe.cqE();
    }

    public void setCurrentTab(int i) {
        this.iUe.setCurrentTab(i);
    }

    public p<Integer> cqL() {
        return this.iUe.cqL();
    }
}
