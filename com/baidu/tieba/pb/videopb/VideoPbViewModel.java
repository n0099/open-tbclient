package com.baidu.tieba.pb.videopb;

import android.content.Intent;
import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes2.dex */
public class VideoPbViewModel extends ViewModel {
    private PbModel lIY;
    private d mgD = new d();
    private int mgE = 0;

    public void init(Intent intent) {
        this.mgD.h((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.mgD.wd(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.lIY = pbModel;
    }

    public void b(f fVar, int i) {
        boolean z = true;
        if (i >= this.mgE) {
            this.mgE = i;
            this.mgD.O(fVar);
            if (fVar != null) {
                d dVar = this.mgD;
                if (fVar.getIsNewUrl() != 1 && !fVar.dnh()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public f dvW() {
        return this.mgD.dvW();
    }

    public boolean isFromCDN() {
        return this.mgD.isFromCDN();
    }

    public f dvX() {
        return this.mgD.dvX();
    }

    public void c(f fVar, int i) {
        if (i == 3) {
            this.mgD.setData(fVar);
        }
    }

    public MutableLiveData<bz> dvY() {
        return this.mgD.dvY();
    }

    public Rect dvZ() {
        if (this.mgD.dvZ() == null || this.mgD.dvZ().isEmpty()) {
            return null;
        }
        return this.mgD.dvZ();
    }

    public void wg(boolean z) {
        if (this.mgD.dwd().getValue() != null) {
            f aL = this.lIY.aL(this.mgD.dwd().getValue());
            if (aL != null) {
                this.mgD.dwb().addLast(this.mgD.dvX());
                this.mgD.setData(aL);
                this.mgD.aT(!x.isEmpty(aL.dng()) ? aL.dng().get(0) : null);
                this.mgD.aS(this.mgD.dwb().getLast() != null ? this.mgD.dwb().getLast().dmE() : null);
                this.lIY.Hj(z ? 21 : 22);
                this.lIY.j(aL);
                this.mgD.setIsLoading(true);
            }
        }
    }

    public void aU(bz bzVar) {
        f aL;
        if (bzVar != null && (aL = this.lIY.aL(bzVar)) != null) {
            this.mgD.dwb().addLast(this.mgD.dvX());
            this.mgD.setData(aL);
            this.mgD.aT(!x.isEmpty(aL.dng()) ? aL.dng().get(0) : null);
            this.mgD.aS(this.mgD.dwb().getLast() != null ? this.mgD.dwb().getLast().dmE() : null);
            this.lIY.Hj(20);
            this.lIY.j(aL);
            this.mgD.setIsLoading(true);
        }
    }

    public void dwi() {
        f pollLast = this.mgD.dwb().pollLast();
        if (pollLast != null) {
            this.mgD.setData(pollLast);
            this.mgD.aT(!x.isEmpty(pollLast.dng()) ? pollLast.dng().get(0) : null);
            this.mgD.aS(this.mgD.dwb().peekLast() != null ? this.mgD.dwb().peekLast().dmE() : null);
            this.lIY.j(pollLast);
            this.mgD.setIsLoading(true);
        }
    }

    public MutableLiveData<bz> dwc() {
        return this.mgD.dwc();
    }

    public MutableLiveData<bz> dwd() {
        return this.mgD.dwd();
    }

    public MutableLiveData<Boolean> dwe() {
        return this.mgD.dwe();
    }

    public void we(boolean z) {
        this.mgD.we(z);
    }

    public MutableLiveData<Boolean> dwf() {
        return this.mgD.dwf();
    }

    public void wf(boolean z) {
        this.mgD.wf(z);
    }

    public void setIsLoading(boolean z) {
        this.mgD.setIsLoading(z);
    }

    public MutableLiveData<Boolean> dwg() {
        return this.mgD.dwg();
    }

    public boolean dwa() {
        return this.mgD.dwa();
    }

    public MutableLiveData<Integer> dwh() {
        return this.mgD.dwh();
    }
}
