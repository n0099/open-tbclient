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
    private PbModel lDQ;
    private d mbp = new d();
    private int mbq = 0;

    public void init(Intent intent) {
        this.mbp.i((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
        this.mbp.wc(intent.getBooleanExtra("key_jump_to_comment_area", false));
    }

    public void i(PbModel pbModel) {
        this.lDQ = pbModel;
    }

    public void b(com.baidu.tieba.pb.data.f fVar, int i) {
        boolean z = true;
        if (i >= this.mbq) {
            this.mbq = i;
            this.mbp.O(fVar);
            if (fVar != null) {
                d dVar = this.mbp;
                if (fVar.getIsNewUrl() != 1 && !fVar.dnx()) {
                    z = false;
                }
                dVar.setFromCDN(z);
            }
        }
    }

    public com.baidu.tieba.pb.data.f dwg() {
        return this.mbp.dwg();
    }

    public boolean isFromCDN() {
        return this.mbp.isFromCDN();
    }

    public com.baidu.tieba.pb.data.f dwh() {
        return this.mbp.dwh();
    }

    public void c(com.baidu.tieba.pb.data.f fVar, int i) {
        if (i == 3) {
            this.mbp.setData(fVar);
        }
    }

    public p<by> dwi() {
        return this.mbp.dwi();
    }

    public Rect dwj() {
        if (this.mbp.dwj() == null || this.mbp.dwj().isEmpty()) {
            return null;
        }
        return this.mbp.dwj();
    }

    public void wf(boolean z) {
        if (this.mbp.dwn().getValue() != null) {
            com.baidu.tieba.pb.data.f aK = this.lDQ.aK(this.mbp.dwn().getValue());
            if (aK != null) {
                this.mbp.dwl().addLast(this.mbp.dwh());
                this.mbp.setData(aK);
                this.mbp.aS(!y.isEmpty(aK.dnw()) ? aK.dnw().get(0) : null);
                this.mbp.aR(this.mbp.dwl().getLast() != null ? this.mbp.dwl().getLast().dmT() : null);
                this.lDQ.Hq(z ? 21 : 22);
                this.lDQ.j(aK);
                this.mbp.setIsLoading(true);
            }
        }
    }

    public void aT(by byVar) {
        com.baidu.tieba.pb.data.f aK;
        if (byVar != null && (aK = this.lDQ.aK(byVar)) != null) {
            this.mbp.dwl().addLast(this.mbp.dwh());
            this.mbp.setData(aK);
            this.mbp.aS(!y.isEmpty(aK.dnw()) ? aK.dnw().get(0) : null);
            this.mbp.aR(this.mbp.dwl().getLast() != null ? this.mbp.dwl().getLast().dmT() : null);
            this.lDQ.Hq(20);
            this.lDQ.j(aK);
            this.mbp.setIsLoading(true);
        }
    }

    public void dws() {
        com.baidu.tieba.pb.data.f pollLast = this.mbp.dwl().pollLast();
        if (pollLast != null) {
            this.mbp.setData(pollLast);
            this.mbp.aS(!y.isEmpty(pollLast.dnw()) ? pollLast.dnw().get(0) : null);
            this.mbp.aR(this.mbp.dwl().peekLast() != null ? this.mbp.dwl().peekLast().dmT() : null);
            this.lDQ.j(pollLast);
            this.mbp.setIsLoading(true);
        }
    }

    public p<by> dwm() {
        return this.mbp.dwm();
    }

    public p<by> dwn() {
        return this.mbp.dwn();
    }

    public p<Boolean> dwo() {
        return this.mbp.dwo();
    }

    public void wd(boolean z) {
        this.mbp.wd(z);
    }

    public p<Boolean> dwp() {
        return this.mbp.dwp();
    }

    public void we(boolean z) {
        this.mbp.we(z);
    }

    public void setIsLoading(boolean z) {
        this.mbp.setIsLoading(z);
    }

    public p<Boolean> dwq() {
        return this.mbp.dwq();
    }

    public boolean dwk() {
        return this.mbp.dwk();
    }

    public p<Integer> dwr() {
        return this.mbp.dwr();
    }
}
