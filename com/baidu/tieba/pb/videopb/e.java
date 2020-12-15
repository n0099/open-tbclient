package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.arch.lifecycle.w;
import android.content.Intent;
import android.graphics.Rect;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes22.dex */
public class e extends w {
    private PbModel lDS;
    private d mbr = new d();
    private int mbs = 0;

    public void init(Intent intent) {
        this.mbr.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.mbr.wc(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.lDS = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.mbs) {
            this.mbs = i;
            this.mbr.O(fVar);
            if (fVar != null) {
                d dVar = this.mbr;
                if (fVar.getIsNewUrl() != 1 && !fVar.dny()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f dwh() {
        return this.mbr.dwh();
    }

    public boolean isFromCDN() {
        return this.mbr.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f dwi() {
        return this.mbr.dwi();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.mbr.setData(fVar);
        }
    }

    public p<by> dwj() {
        return this.mbr.dwj();
    }

    public Rect dwk() {
        if (this.mbr.dwk() == null || this.mbr.dwk().isEmpty()) {
            return null;
        }
        return this.mbr.dwk();
    }

    public void wf(boolean z) {
        if (this.mbr.dwo().getValue() != null) {
            com.baidu.tieba.pb.data.f aK = this.lDS.aK(this.mbr.dwo().getValue());
            if (aK != null) {
                this.mbr.dwm().addLast(this.mbr.dwi());
                this.mbr.setData(aK);
                this.mbr.aS(!y.isEmpty(aK.dnx()) ? aK.dnx().get(0) : null);
                this.mbr.aR(this.mbr.dwm().getLast() != null ? this.mbr.dwm().getLast().dmU() : null);
                this.lDS.Hq(z ? 21 : 22);
                this.lDS.j(aK);
                this.mbr.setIsLoading(true);
            }
        }
    }

    public void aT(by byVar) {
        com.baidu.tieba.pb.data.f aK;
        if (byVar != null && (aK = this.lDS.aK(byVar)) != null) {
            this.mbr.dwm().addLast(this.mbr.dwi());
            this.mbr.setData(aK);
            this.mbr.aS(!y.isEmpty(aK.dnx()) ? aK.dnx().get(0) : null);
            this.mbr.aR(this.mbr.dwm().getLast() != null ? this.mbr.dwm().getLast().dmU() : null);
            this.lDS.Hq(20);
            this.lDS.j(aK);
            this.mbr.setIsLoading(true);
        }
    }

    public void dwt() {
        com.baidu.tieba.pb.data.f pollLast = this.mbr.dwm().pollLast();
        if (pollLast != null) {
            this.mbr.setData(pollLast);
            this.mbr.aS(!y.isEmpty(pollLast.dnx()) ? pollLast.dnx().get(0) : null);
            this.mbr.aR(this.mbr.dwm().peekLast() != null ? this.mbr.dwm().peekLast().dmU() : null);
            this.lDS.j(pollLast);
            this.mbr.setIsLoading(true);
        }
    }

    public p<by> dwn() {
        return this.mbr.dwn();
    }

    public p<by> dwo() {
        return this.mbr.dwo();
    }

    public p<Boolean> dwp() {
        return this.mbr.dwp();
    }

    public void wd(boolean z) {
        this.mbr.wd(z);
    }

    public p<Boolean> dwq() {
        return this.mbr.dwq();
    }

    public void we(boolean z) {
        this.mbr.we(z);
    }

    public void setIsLoading(boolean z) {
        this.mbr.setIsLoading(z);
    }

    public p<Boolean> dwr() {
        return this.mbr.dwr();
    }

    public boolean dwl() {
        return this.mbr.dwl();
    }

    public p<Integer> dws() {
        return this.mbr.dws();
    }
}
