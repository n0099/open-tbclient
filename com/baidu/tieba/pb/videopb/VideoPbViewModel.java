package com.baidu.tieba.pb.videopb;

import android.content.Intent;
import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes2.dex */
public class VideoPbViewModel extends ViewModel {
    private PbModel lPy;
    private d mnq = new d();
    private int mnr = 0;

    public void init(Intent intent) {
        this.mnq.h((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.mnq.wq(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.lPy = pbModel;
    }

    public void b(f fVar, int i) {
        boolean z = true;
        if (i >= this.mnr) {
            this.mnr = i;
            this.mnq.O(fVar);
            if (fVar != null) {
                d dVar = this.mnq;
                if (fVar.getIsNewUrl() != 1 && !fVar.dlS()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public f duH() {
        return this.mnq.duH();
    }

    public boolean isFromCDN() {
        return this.mnq.isFromCDN();
    }

    public f duI() {
        return this.mnq.duI();
    }

    public void c(f fVar, int i) {
        if (i == 3) {
            this.mnq.setData(fVar);
        }
    }

    public MutableLiveData<cb> duJ() {
        return this.mnq.duJ();
    }

    public Rect duK() {
        if (this.mnq.duK() == null || this.mnq.duK().isEmpty()) {
            return null;
        }
        return this.mnq.duK();
    }

    public void wt(boolean z) {
        if (this.mnq.duO().getValue() != null) {
            f aM = this.lPy.aM(this.mnq.duO().getValue());
            if (aM != null) {
                this.mnq.duM().addLast(this.mnq.duI());
                this.mnq.setData(aM);
                this.mnq.aU(!y.isEmpty(aM.dlR()) ? aM.dlR().get(0) : null);
                this.mnq.aT(this.mnq.duM().getLast() != null ? this.mnq.duM().getLast().dlp() : null);
                this.lPy.FZ(z ? 21 : 22);
                this.lPy.j(aM);
                this.mnq.setIsLoading(true);
            }
        }
    }

    public void aV(cb cbVar) {
        f aM;
        if (cbVar != null && (aM = this.lPy.aM(cbVar)) != null) {
            this.mnq.duM().addLast(this.mnq.duI());
            this.mnq.setData(aM);
            this.mnq.aU(!y.isEmpty(aM.dlR()) ? aM.dlR().get(0) : null);
            this.mnq.aT(this.mnq.duM().getLast() != null ? this.mnq.duM().getLast().dlp() : null);
            this.lPy.FZ(20);
            this.lPy.j(aM);
            this.mnq.setIsLoading(true);
        }
    }

    public void duS() {
        f pollLast = this.mnq.duM().pollLast();
        if (pollLast != null) {
            this.mnq.setData(pollLast);
            this.mnq.aU(!y.isEmpty(pollLast.dlR()) ? pollLast.dlR().get(0) : null);
            this.mnq.aT(this.mnq.duM().peekLast() != null ? this.mnq.duM().peekLast().dlp() : null);
            this.lPy.j(pollLast);
            this.mnq.setIsLoading(true);
        }
    }

    public MutableLiveData<cb> duN() {
        return this.mnq.duN();
    }

    public MutableLiveData<cb> duO() {
        return this.mnq.duO();
    }

    public MutableLiveData<Boolean> duP() {
        return this.mnq.duP();
    }

    public void wr(boolean z) {
        this.mnq.wr(z);
    }

    public MutableLiveData<Boolean> duQ() {
        return this.mnq.duQ();
    }

    public void ws(boolean z) {
        this.mnq.ws(z);
    }

    public void setIsLoading(boolean z) {
        this.mnq.setIsLoading(z);
    }

    public MutableLiveData<Boolean> cMY() {
        return this.mnq.cMY();
    }

    public boolean duL() {
        return this.mnq.duL();
    }

    public void wq(boolean z) {
        this.mnq.wq(z);
    }

    public MutableLiveData<Integer> duR() {
        return this.mnq.duR();
    }
}
