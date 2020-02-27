package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class d {
    private boolean NJ;
    private com.baidu.tieba.pb.data.e iEG;
    private com.baidu.tieba.pb.data.e iZc;
    private Rect iZe;
    private boolean iZf;
    private p<bj> iZd = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.e> iZg = new LinkedList<>();
    private p<bj> iZh = new p<>();
    private p<bj> iZi = new p<>();
    private p<Boolean> iZj = new p<>();
    private p<Boolean> iZk = new p<>();
    private p<Boolean> iZl = new p<>();
    private p<Integer> iZm = new p<>();

    public void I(com.baidu.tieba.pb.data.e eVar) {
        this.iZc = eVar;
        setData(eVar);
        this.iZh.setValue(null);
        this.iZd.setValue(eVar.cks());
    }

    public com.baidu.tieba.pb.data.e ctc() {
        return this.iZc;
    }

    public com.baidu.tieba.pb.data.e ctd() {
        return this.iEG;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iEG = eVar;
        if (eVar != null) {
            this.iZd.setValue(eVar.cks());
            if (!v.isEmpty(eVar.ckP())) {
                aO(eVar.ckP().get(0));
            }
        }
    }

    public p<bj> cte() {
        return this.iZd;
    }

    public boolean isFromCDN() {
        return this.NJ;
    }

    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    public void i(Rect rect) {
        this.iZe = rect;
    }

    public Rect ctf() {
        return this.iZe;
    }

    public void qU(boolean z) {
        this.iZf = z;
    }

    public boolean ctg() {
        return this.iZf;
    }

    public LinkedList<com.baidu.tieba.pb.data.e> cth() {
        return this.iZg;
    }

    public void aN(bj bjVar) {
        this.iZh.setValue(bjVar);
    }

    public void aO(bj bjVar) {
        this.iZi.setValue(bjVar);
    }

    public p<bj> cti() {
        return this.iZh;
    }

    public p<bj> ctj() {
        return this.iZi;
    }

    public p<Boolean> ctk() {
        return this.iZj;
    }

    public void qV(boolean z) {
        this.iZj.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> ctl() {
        return this.iZk;
    }

    public void qW(boolean z) {
        this.iZk.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.iZl.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> ctm() {
        return this.iZl;
    }

    public void setCurrentTab(int i) {
        this.iZm.setValue(Integer.valueOf(i));
    }

    public p<Integer> ctn() {
        return this.iZm;
    }
}
