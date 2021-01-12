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
    private PbModel lEs;
    private d mbX = new d();
    private int mbY = 0;

    public void init(Intent intent) {
        this.mbX.h((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.mbX.vZ(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.lEs = pbModel;
    }

    public void b(f fVar, int i) {
        boolean z = true;
        if (i >= this.mbY) {
            this.mbY = i;
            this.mbX.O(fVar);
            if (fVar != null) {
                d dVar = this.mbX;
                if (fVar.getIsNewUrl() != 1 && !fVar.djq()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public f dsf() {
        return this.mbX.dsf();
    }

    public boolean isFromCDN() {
        return this.mbX.isFromCDN();
    }

    public f dsg() {
        return this.mbX.dsg();
    }

    public void c(f fVar, int i) {
        if (i == 3) {
            this.mbX.setData(fVar);
        }
    }

    public MutableLiveData<bz> dsh() {
        return this.mbX.dsh();
    }

    public Rect dsi() {
        if (this.mbX.dsi() == null || this.mbX.dsi().isEmpty()) {
            return null;
        }
        return this.mbX.dsi();
    }

    public void wc(boolean z) {
        if (this.mbX.dsm().getValue() != null) {
            f aL = this.lEs.aL(this.mbX.dsm().getValue());
            if (aL != null) {
                this.mbX.dsk().addLast(this.mbX.dsg());
                this.mbX.setData(aL);
                this.mbX.aT(!x.isEmpty(aL.djp()) ? aL.djp().get(0) : null);
                this.mbX.aS(this.mbX.dsk().getLast() != null ? this.mbX.dsk().getLast().diN() : null);
                this.lEs.FD(z ? 21 : 22);
                this.lEs.j(aL);
                this.mbX.setIsLoading(true);
            }
        }
    }

    public void aU(bz bzVar) {
        f aL;
        if (bzVar != null && (aL = this.lEs.aL(bzVar)) != null) {
            this.mbX.dsk().addLast(this.mbX.dsg());
            this.mbX.setData(aL);
            this.mbX.aT(!x.isEmpty(aL.djp()) ? aL.djp().get(0) : null);
            this.mbX.aS(this.mbX.dsk().getLast() != null ? this.mbX.dsk().getLast().diN() : null);
            this.lEs.FD(20);
            this.lEs.j(aL);
            this.mbX.setIsLoading(true);
        }
    }

    public void dsr() {
        f pollLast = this.mbX.dsk().pollLast();
        if (pollLast != null) {
            this.mbX.setData(pollLast);
            this.mbX.aT(!x.isEmpty(pollLast.djp()) ? pollLast.djp().get(0) : null);
            this.mbX.aS(this.mbX.dsk().peekLast() != null ? this.mbX.dsk().peekLast().diN() : null);
            this.lEs.j(pollLast);
            this.mbX.setIsLoading(true);
        }
    }

    public MutableLiveData<bz> dsl() {
        return this.mbX.dsl();
    }

    public MutableLiveData<bz> dsm() {
        return this.mbX.dsm();
    }

    public MutableLiveData<Boolean> dsn() {
        return this.mbX.dsn();
    }

    public void wa(boolean z) {
        this.mbX.wa(z);
    }

    public MutableLiveData<Boolean> dso() {
        return this.mbX.dso();
    }

    public void wb(boolean z) {
        this.mbX.wb(z);
    }

    public void setIsLoading(boolean z) {
        this.mbX.setIsLoading(z);
    }

    public MutableLiveData<Boolean> dsp() {
        return this.mbX.dsp();
    }

    public boolean dsj() {
        return this.mbX.dsj();
    }

    public MutableLiveData<Integer> dsq() {
        return this.mbX.dsq();
    }
}
