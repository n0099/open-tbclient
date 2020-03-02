package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class d {
    private boolean NJ;
    private com.baidu.tieba.pb.data.e iEI;
    private com.baidu.tieba.pb.data.e iZe;
    private Rect iZg;
    private boolean iZh;
    private p<bj> iZf = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.e> iZi = new LinkedList<>();
    private p<bj> iZj = new p<>();
    private p<bj> iZk = new p<>();
    private p<Boolean> iZl = new p<>();
    private p<Boolean> iZm = new p<>();
    private p<Boolean> iZn = new p<>();
    private p<Integer> iZo = new p<>();

    public void I(com.baidu.tieba.pb.data.e eVar) {
        this.iZe = eVar;
        setData(eVar);
        this.iZj.setValue(null);
        this.iZf.setValue(eVar.cku());
    }

    public com.baidu.tieba.pb.data.e cte() {
        return this.iZe;
    }

    public com.baidu.tieba.pb.data.e ctf() {
        return this.iEI;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iEI = eVar;
        if (eVar != null) {
            this.iZf.setValue(eVar.cku());
            if (!v.isEmpty(eVar.ckR())) {
                aO(eVar.ckR().get(0));
            }
        }
    }

    public p<bj> ctg() {
        return this.iZf;
    }

    public boolean isFromCDN() {
        return this.NJ;
    }

    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    public void i(Rect rect) {
        this.iZg = rect;
    }

    public Rect cth() {
        return this.iZg;
    }

    public void qU(boolean z) {
        this.iZh = z;
    }

    public boolean cti() {
        return this.iZh;
    }

    public LinkedList<com.baidu.tieba.pb.data.e> ctj() {
        return this.iZi;
    }

    public void aN(bj bjVar) {
        this.iZj.setValue(bjVar);
    }

    public void aO(bj bjVar) {
        this.iZk.setValue(bjVar);
    }

    public p<bj> ctk() {
        return this.iZj;
    }

    public p<bj> ctl() {
        return this.iZk;
    }

    public p<Boolean> ctm() {
        return this.iZl;
    }

    public void qV(boolean z) {
        this.iZl.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> ctn() {
        return this.iZm;
    }

    public void qW(boolean z) {
        this.iZm.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.iZn.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cto() {
        return this.iZn;
    }

    public void setCurrentTab(int i) {
        this.iZo.setValue(Integer.valueOf(i));
    }

    public p<Integer> ctp() {
        return this.iZo;
    }
}
