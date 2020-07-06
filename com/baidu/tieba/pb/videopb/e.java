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
                if (eVar.getIsNewUrl() != 1 && !eVar.cHq()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.e cPJ() {
        return this.kxU.cPJ();
    }

    public boolean isFromCDN() {
        return this.kxU.isFromCDN();
    }

    public com.baidu.tieba.pb.data.e cPK() {
        return this.kxU.cPK();
    }

    public void c(com.baidu.tieba.pb.data.e eVar, int i) {
        if (i == 3) {
            this.kxU.setData(eVar);
        }
    }

    public p<bu> cPL() {
        return this.kxU.cPL();
    }

    public Rect cPM() {
        if (this.kxU.cPM() == null || this.kxU.cPM().isEmpty()) {
            return null;
        }
        return this.kxU.cPM();
    }

    public void sT(boolean z) {
        if (this.kxU.cPQ().getValue() != null) {
            com.baidu.tieba.pb.data.e aJ = this.kbF.aJ(this.kxU.cPQ().getValue());
            if (aJ != null) {
                this.kxU.cPO().addLast(this.kxU.cPK());
                this.kxU.setData(aJ);
                this.kxU.aR(!com.baidu.tbadk.core.util.w.isEmpty(aJ.cHp()) ? aJ.cHp().get(0) : null);
                this.kxU.aQ(this.kxU.cPO().getLast() != null ? this.kxU.cPO().getLast().cGO() : null);
                this.kbF.Bw(z ? 21 : 22);
                this.kbF.j(aJ);
                this.kxU.setIsLoading(true);
            }
        }
    }

    public void aS(bu buVar) {
        com.baidu.tieba.pb.data.e aJ;
        if (buVar != null && (aJ = this.kbF.aJ(buVar)) != null) {
            this.kxU.cPO().addLast(this.kxU.cPK());
            this.kxU.setData(aJ);
            this.kxU.aR(!com.baidu.tbadk.core.util.w.isEmpty(aJ.cHp()) ? aJ.cHp().get(0) : null);
            this.kxU.aQ(this.kxU.cPO().getLast() != null ? this.kxU.cPO().getLast().cGO() : null);
            this.kbF.Bw(20);
            this.kbF.j(aJ);
            this.kxU.setIsLoading(true);
        }
    }

    public void cPV() {
        com.baidu.tieba.pb.data.e pollLast = this.kxU.cPO().pollLast();
        if (pollLast != null) {
            this.kxU.setData(pollLast);
            this.kxU.aR(!com.baidu.tbadk.core.util.w.isEmpty(pollLast.cHp()) ? pollLast.cHp().get(0) : null);
            this.kxU.aQ(this.kxU.cPO().peekLast() != null ? this.kxU.cPO().peekLast().cGO() : null);
            this.kbF.j(pollLast);
            this.kxU.setIsLoading(true);
        }
    }

    public p<bu> cPP() {
        return this.kxU.cPP();
    }

    public p<bu> cPQ() {
        return this.kxU.cPQ();
    }

    public p<Boolean> cPR() {
        return this.kxU.cPR();
    }

    public void sR(boolean z) {
        this.kxU.sR(z);
    }

    public p<Boolean> cPS() {
        return this.kxU.cPS();
    }

    public void sS(boolean z) {
        this.kxU.sS(z);
    }

    public void setIsLoading(boolean z) {
        this.kxU.setIsLoading(z);
    }

    public p<Boolean> cPT() {
        return this.kxU.cPT();
    }

    public boolean cPN() {
        return this.kxU.cPN();
    }

    public p<Integer> cPU() {
        return this.kxU.cPU();
    }
}
