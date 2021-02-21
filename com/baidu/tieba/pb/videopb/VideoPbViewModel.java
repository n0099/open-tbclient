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
    private PbModel lNw;
    private d mlo = new d();
    private int mlp = 0;

    public void init(Intent intent) {
        this.mlo.h((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.mlo.wq(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.lNw = pbModel;
    }

    public void b(f fVar, int i) {
        boolean z = true;
        if (i >= this.mlp) {
            this.mlp = i;
            this.mlo.O(fVar);
            if (fVar != null) {
                d dVar = this.mlo;
                if (fVar.getIsNewUrl() != 1 && !fVar.dlJ()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public f duy() {
        return this.mlo.duy();
    }

    public boolean isFromCDN() {
        return this.mlo.isFromCDN();
    }

    public f duz() {
        return this.mlo.duz();
    }

    public void c(f fVar, int i) {
        if (i == 3) {
            this.mlo.setData(fVar);
        }
    }

    public MutableLiveData<cb> duA() {
        return this.mlo.duA();
    }

    public Rect duB() {
        if (this.mlo.duB() == null || this.mlo.duB().isEmpty()) {
            return null;
        }
        return this.mlo.duB();
    }

    public void wt(boolean z) {
        if (this.mlo.duF().getValue() != null) {
            f aM = this.lNw.aM(this.mlo.duF().getValue());
            if (aM != null) {
                this.mlo.duD().addLast(this.mlo.duz());
                this.mlo.setData(aM);
                this.mlo.aU(!y.isEmpty(aM.dlI()) ? aM.dlI().get(0) : null);
                this.mlo.aT(this.mlo.duD().getLast() != null ? this.mlo.duD().getLast().dlg() : null);
                this.lNw.FW(z ? 21 : 22);
                this.lNw.j(aM);
                this.mlo.setIsLoading(true);
            }
        }
    }

    public void aV(cb cbVar) {
        f aM;
        if (cbVar != null && (aM = this.lNw.aM(cbVar)) != null) {
            this.mlo.duD().addLast(this.mlo.duz());
            this.mlo.setData(aM);
            this.mlo.aU(!y.isEmpty(aM.dlI()) ? aM.dlI().get(0) : null);
            this.mlo.aT(this.mlo.duD().getLast() != null ? this.mlo.duD().getLast().dlg() : null);
            this.lNw.FW(20);
            this.lNw.j(aM);
            this.mlo.setIsLoading(true);
        }
    }

    public void duJ() {
        f pollLast = this.mlo.duD().pollLast();
        if (pollLast != null) {
            this.mlo.setData(pollLast);
            this.mlo.aU(!y.isEmpty(pollLast.dlI()) ? pollLast.dlI().get(0) : null);
            this.mlo.aT(this.mlo.duD().peekLast() != null ? this.mlo.duD().peekLast().dlg() : null);
            this.lNw.j(pollLast);
            this.mlo.setIsLoading(true);
        }
    }

    public MutableLiveData<cb> duE() {
        return this.mlo.duE();
    }

    public MutableLiveData<cb> duF() {
        return this.mlo.duF();
    }

    public MutableLiveData<Boolean> duG() {
        return this.mlo.duG();
    }

    public void wr(boolean z) {
        this.mlo.wr(z);
    }

    public MutableLiveData<Boolean> duH() {
        return this.mlo.duH();
    }

    public void ws(boolean z) {
        this.mlo.ws(z);
    }

    public void setIsLoading(boolean z) {
        this.mlo.setIsLoading(z);
    }

    public MutableLiveData<Boolean> cMS() {
        return this.mlo.cMS();
    }

    public boolean duC() {
        return this.mlo.duC();
    }

    public void wq(boolean z) {
        this.mlo.wq(z);
    }

    public MutableLiveData<Integer> duI() {
        return this.mlo.duI();
    }
}
