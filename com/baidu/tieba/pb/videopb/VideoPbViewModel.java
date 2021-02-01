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
    private PbModel lNh;
    private d mkZ = new d();
    private int mla = 0;

    public void init(Intent intent) {
        this.mkZ.h((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.mkZ.wq(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.lNh = pbModel;
    }

    public void b(f fVar, int i) {
        boolean z = true;
        if (i >= this.mla) {
            this.mla = i;
            this.mkZ.O(fVar);
            if (fVar != null) {
                d dVar = this.mkZ;
                if (fVar.getIsNewUrl() != 1 && !fVar.dlC()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public f dur() {
        return this.mkZ.dur();
    }

    public boolean isFromCDN() {
        return this.mkZ.isFromCDN();
    }

    public f dus() {
        return this.mkZ.dus();
    }

    public void c(f fVar, int i) {
        if (i == 3) {
            this.mkZ.setData(fVar);
        }
    }

    public MutableLiveData<cb> dut() {
        return this.mkZ.dut();
    }

    public Rect duu() {
        if (this.mkZ.duu() == null || this.mkZ.duu().isEmpty()) {
            return null;
        }
        return this.mkZ.duu();
    }

    public void wt(boolean z) {
        if (this.mkZ.duy().getValue() != null) {
            f aM = this.lNh.aM(this.mkZ.duy().getValue());
            if (aM != null) {
                this.mkZ.duw().addLast(this.mkZ.dus());
                this.mkZ.setData(aM);
                this.mkZ.aU(!y.isEmpty(aM.dlB()) ? aM.dlB().get(0) : null);
                this.mkZ.aT(this.mkZ.duw().getLast() != null ? this.mkZ.duw().getLast().dkZ() : null);
                this.lNh.FW(z ? 21 : 22);
                this.lNh.j(aM);
                this.mkZ.setIsLoading(true);
            }
        }
    }

    public void aV(cb cbVar) {
        f aM;
        if (cbVar != null && (aM = this.lNh.aM(cbVar)) != null) {
            this.mkZ.duw().addLast(this.mkZ.dus());
            this.mkZ.setData(aM);
            this.mkZ.aU(!y.isEmpty(aM.dlB()) ? aM.dlB().get(0) : null);
            this.mkZ.aT(this.mkZ.duw().getLast() != null ? this.mkZ.duw().getLast().dkZ() : null);
            this.lNh.FW(20);
            this.lNh.j(aM);
            this.mkZ.setIsLoading(true);
        }
    }

    public void duC() {
        f pollLast = this.mkZ.duw().pollLast();
        if (pollLast != null) {
            this.mkZ.setData(pollLast);
            this.mkZ.aU(!y.isEmpty(pollLast.dlB()) ? pollLast.dlB().get(0) : null);
            this.mkZ.aT(this.mkZ.duw().peekLast() != null ? this.mkZ.duw().peekLast().dkZ() : null);
            this.lNh.j(pollLast);
            this.mkZ.setIsLoading(true);
        }
    }

    public MutableLiveData<cb> dux() {
        return this.mkZ.dux();
    }

    public MutableLiveData<cb> duy() {
        return this.mkZ.duy();
    }

    public MutableLiveData<Boolean> duz() {
        return this.mkZ.duz();
    }

    public void wr(boolean z) {
        this.mkZ.wr(z);
    }

    public MutableLiveData<Boolean> duA() {
        return this.mkZ.duA();
    }

    public void ws(boolean z) {
        this.mkZ.ws(z);
    }

    public void setIsLoading(boolean z) {
        this.mkZ.setIsLoading(z);
    }

    public MutableLiveData<Boolean> cML() {
        return this.mkZ.cML();
    }

    public boolean duv() {
        return this.mkZ.duv();
    }

    public void wq(boolean z) {
        this.mkZ.wq(z);
    }

    public MutableLiveData<Integer> duB() {
        return this.mkZ.duB();
    }
}
