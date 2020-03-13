package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class d {
    private boolean NJ;
    private com.baidu.tieba.pb.data.e iEU;
    private com.baidu.tieba.pb.data.e iZq;
    private Rect iZs;
    private boolean iZt;
    private p<bj> iZr = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.e> iZu = new LinkedList<>();
    private p<bj> iZv = new p<>();
    private p<bj> iZw = new p<>();
    private p<Boolean> iZx = new p<>();
    private p<Boolean> iZy = new p<>();
    private p<Boolean> iZz = new p<>();
    private p<Integer> iZA = new p<>();

    public void I(com.baidu.tieba.pb.data.e eVar) {
        this.iZq = eVar;
        setData(eVar);
        this.iZv.setValue(null);
        this.iZr.setValue(eVar.ckv());
    }

    public com.baidu.tieba.pb.data.e ctf() {
        return this.iZq;
    }

    public com.baidu.tieba.pb.data.e ctg() {
        return this.iEU;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iEU = eVar;
        if (eVar != null) {
            this.iZr.setValue(eVar.ckv());
            if (!v.isEmpty(eVar.ckS())) {
                aO(eVar.ckS().get(0));
            }
        }
    }

    public p<bj> cth() {
        return this.iZr;
    }

    public boolean isFromCDN() {
        return this.NJ;
    }

    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    public void i(Rect rect) {
        this.iZs = rect;
    }

    public Rect cti() {
        return this.iZs;
    }

    public void qU(boolean z) {
        this.iZt = z;
    }

    public boolean ctj() {
        return this.iZt;
    }

    public LinkedList<com.baidu.tieba.pb.data.e> ctk() {
        return this.iZu;
    }

    public void aN(bj bjVar) {
        this.iZv.setValue(bjVar);
    }

    public void aO(bj bjVar) {
        this.iZw.setValue(bjVar);
    }

    public p<bj> ctl() {
        return this.iZv;
    }

    public p<bj> ctm() {
        return this.iZw;
    }

    public p<Boolean> ctn() {
        return this.iZx;
    }

    public void qV(boolean z) {
        this.iZx.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cto() {
        return this.iZy;
    }

    public void qW(boolean z) {
        this.iZy.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.iZz.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> ctp() {
        return this.iZz;
    }

    public void setCurrentTab(int i) {
        this.iZA.setValue(Integer.valueOf(i));
    }

    public p<Integer> ctq() {
        return this.iZA;
    }
}
