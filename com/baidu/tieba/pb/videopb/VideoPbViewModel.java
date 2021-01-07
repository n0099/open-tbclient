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
    private PbModel lIX;
    private d mgC = new d();
    private int mgD = 0;

    public void init(Intent intent) {
        this.mgC.h((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.mgC.wd(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.lIX = pbModel;
    }

    public void b(f fVar, int i) {
        boolean z = true;
        if (i >= this.mgD) {
            this.mgD = i;
            this.mgC.O(fVar);
            if (fVar != null) {
                d dVar = this.mgC;
                if (fVar.getIsNewUrl() != 1 && !fVar.dni()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public f dvX() {
        return this.mgC.dvX();
    }

    public boolean isFromCDN() {
        return this.mgC.isFromCDN();
    }

    public f dvY() {
        return this.mgC.dvY();
    }

    public void c(f fVar, int i) {
        if (i == 3) {
            this.mgC.setData(fVar);
        }
    }

    public MutableLiveData<bz> dvZ() {
        return this.mgC.dvZ();
    }

    public Rect dwa() {
        if (this.mgC.dwa() == null || this.mgC.dwa().isEmpty()) {
            return null;
        }
        return this.mgC.dwa();
    }

    public void wg(boolean z) {
        if (this.mgC.dwe().getValue() != null) {
            f aL = this.lIX.aL(this.mgC.dwe().getValue());
            if (aL != null) {
                this.mgC.dwc().addLast(this.mgC.dvY());
                this.mgC.setData(aL);
                this.mgC.aT(!x.isEmpty(aL.dnh()) ? aL.dnh().get(0) : null);
                this.mgC.aS(this.mgC.dwc().getLast() != null ? this.mgC.dwc().getLast().dmF() : null);
                this.lIX.Hj(z ? 21 : 22);
                this.lIX.j(aL);
                this.mgC.setIsLoading(true);
            }
        }
    }

    public void aU(bz bzVar) {
        f aL;
        if (bzVar != null && (aL = this.lIX.aL(bzVar)) != null) {
            this.mgC.dwc().addLast(this.mgC.dvY());
            this.mgC.setData(aL);
            this.mgC.aT(!x.isEmpty(aL.dnh()) ? aL.dnh().get(0) : null);
            this.mgC.aS(this.mgC.dwc().getLast() != null ? this.mgC.dwc().getLast().dmF() : null);
            this.lIX.Hj(20);
            this.lIX.j(aL);
            this.mgC.setIsLoading(true);
        }
    }

    public void dwj() {
        f pollLast = this.mgC.dwc().pollLast();
        if (pollLast != null) {
            this.mgC.setData(pollLast);
            this.mgC.aT(!x.isEmpty(pollLast.dnh()) ? pollLast.dnh().get(0) : null);
            this.mgC.aS(this.mgC.dwc().peekLast() != null ? this.mgC.dwc().peekLast().dmF() : null);
            this.lIX.j(pollLast);
            this.mgC.setIsLoading(true);
        }
    }

    public MutableLiveData<bz> dwd() {
        return this.mgC.dwd();
    }

    public MutableLiveData<bz> dwe() {
        return this.mgC.dwe();
    }

    public MutableLiveData<Boolean> dwf() {
        return this.mgC.dwf();
    }

    public void we(boolean z) {
        this.mgC.we(z);
    }

    public MutableLiveData<Boolean> dwg() {
        return this.mgC.dwg();
    }

    public void wf(boolean z) {
        this.mgC.wf(z);
    }

    public void setIsLoading(boolean z) {
        this.mgC.setIsLoading(z);
    }

    public MutableLiveData<Boolean> dwh() {
        return this.mgC.dwh();
    }

    public boolean dwb() {
        return this.mgC.dwb();
    }

    public MutableLiveData<Integer> dwi() {
        return this.mgC.dwi();
    }
}
