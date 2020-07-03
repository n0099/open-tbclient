package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.arch.lifecycle.w;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes9.dex */
public class e extends w {
    private PbModel kbF;
    private d kxU = new d();
    private int kxV = 0;

    public void init(Intent intent) {
        this.kxU.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.kxU.sQ(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.kbF = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.e eVar, int i) {
        boolean z = true;
        if (i >= this.kxV) {
            this.kxV = i;
            this.kxU.L(eVar);
            if (eVar != null) {
                d dVar = this.kxU;
                if (eVar.getIsNewUrl() != 1 && !eVar.cHp()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.e cPI() {
        return this.kxU.cPI();
    }

    public boolean isFromCDN() {
        return this.kxU.isFromCDN();
    }

    public com.baidu.tieba.pb.data.e cPJ() {
        return this.kxU.cPJ();
    }

    public void c(com.baidu.tieba.pb.data.e eVar, int i) {
        if (i == 3) {
            this.kxU.setData(eVar);
        }
    }

    public p<bu> cPK() {
        return this.kxU.cPK();
    }

    public Rect cPL() {
        if (this.kxU.cPL() == null || this.kxU.cPL().isEmpty()) {
            return null;
        }
        return this.kxU.cPL();
    }

    public void sT(boolean z) {
        if (this.kxU.cPP().getValue() != null) {
            com.baidu.tieba.pb.data.e aJ = this.kbF.aJ(this.kxU.cPP().getValue());
            if (aJ != null) {
                this.kxU.cPN().addLast(this.kxU.cPJ());
                this.kxU.setData(aJ);
                this.kxU.aR(!com.baidu.tbadk.core.util.w.isEmpty(aJ.cHo()) ? aJ.cHo().get(0) : null);
                this.kxU.aQ(this.kxU.cPN().getLast() != null ? this.kxU.cPN().getLast().cGN() : null);
                this.kbF.Bw(z ? 21 : 22);
                this.kbF.j(aJ);
                this.kxU.setIsLoading(true);
            }
        }
    }

    public void aS(bu buVar) {
        com.baidu.tieba.pb.data.e aJ;
        if (buVar != null && (aJ = this.kbF.aJ(buVar)) != null) {
            this.kxU.cPN().addLast(this.kxU.cPJ());
            this.kxU.setData(aJ);
            this.kxU.aR(!com.baidu.tbadk.core.util.w.isEmpty(aJ.cHo()) ? aJ.cHo().get(0) : null);
            this.kxU.aQ(this.kxU.cPN().getLast() != null ? this.kxU.cPN().getLast().cGN() : null);
            this.kbF.Bw(20);
            this.kbF.j(aJ);
            this.kxU.setIsLoading(true);
        }
    }

    public void cPU() {
        com.baidu.tieba.pb.data.e pollLast = this.kxU.cPN().pollLast();
        if (pollLast != null) {
            this.kxU.setData(pollLast);
            this.kxU.aR(!com.baidu.tbadk.core.util.w.isEmpty(pollLast.cHo()) ? pollLast.cHo().get(0) : null);
            this.kxU.aQ(this.kxU.cPN().peekLast() != null ? this.kxU.cPN().peekLast().cGN() : null);
            this.kbF.j(pollLast);
            this.kxU.setIsLoading(true);
        }
    }

    public p<bu> cPO() {
        return this.kxU.cPO();
    }

    public p<bu> cPP() {
        return this.kxU.cPP();
    }

    public p<Boolean> cPQ() {
        return this.kxU.cPQ();
    }

    public void sR(boolean z) {
        this.kxU.sR(z);
    }

    public p<Boolean> cPR() {
        return this.kxU.cPR();
    }

    public void sS(boolean z) {
        this.kxU.sS(z);
    }

    public void setIsLoading(boolean z) {
        this.kxU.setIsLoading(z);
    }

    public p<Boolean> cPS() {
        return this.kxU.cPS();
    }

    public boolean cPM() {
        return this.kxU.cPM();
    }

    public p<Integer> cPT() {
        return this.kxU.cPT();
    }
}
