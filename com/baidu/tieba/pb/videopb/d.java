package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class d {
    private boolean agt;
    private com.baidu.tieba.pb.data.e jKY;
    private Rect jLa;
    private boolean jLb;
    private com.baidu.tieba.pb.data.e jqC;
    private p<bj> jKZ = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.e> jLc = new LinkedList<>();
    private p<bj> jLd = new p<>();
    private p<bj> jLe = new p<>();
    private p<Boolean> jLf = new p<>();
    private p<Boolean> jLg = new p<>();
    private p<Boolean> jLh = new p<>();
    private p<Integer> jLi = new p<>();

    public void I(com.baidu.tieba.pb.data.e eVar) {
        this.jKY = eVar;
        setData(eVar);
        this.jLd.setValue(null);
        this.jKZ.setValue(eVar.cvu());
    }

    public com.baidu.tieba.pb.data.e cEg() {
        return this.jKY;
    }

    public com.baidu.tieba.pb.data.e cEh() {
        return this.jqC;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jqC = eVar;
        if (eVar != null) {
            this.jKZ.setValue(eVar.cvu());
            if (!v.isEmpty(eVar.cvR())) {
                aQ(eVar.cvR().get(0));
            }
        }
    }

    public p<bj> cEi() {
        return this.jKZ;
    }

    public boolean isFromCDN() {
        return this.agt;
    }

    public void setFromCDN(boolean z) {
        this.agt = z;
    }

    public void i(Rect rect) {
        this.jLa = rect;
    }

    public Rect cEj() {
        return this.jLa;
    }

    public void se(boolean z) {
        this.jLb = z;
    }

    public boolean cEk() {
        return this.jLb;
    }

    public LinkedList<com.baidu.tieba.pb.data.e> cEl() {
        return this.jLc;
    }

    public void aP(bj bjVar) {
        this.jLd.setValue(bjVar);
    }

    public void aQ(bj bjVar) {
        this.jLe.setValue(bjVar);
    }

    public p<bj> cEm() {
        return this.jLd;
    }

    public p<bj> cEn() {
        return this.jLe;
    }

    public p<Boolean> cEo() {
        return this.jLf;
    }

    public void sf(boolean z) {
        this.jLf.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cEp() {
        return this.jLg;
    }

    public void sg(boolean z) {
        this.jLg.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.jLh.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cEq() {
        return this.jLh;
    }

    public void setCurrentTab(int i) {
        this.jLi.setValue(Integer.valueOf(i));
    }

    public p<Integer> cEr() {
        return this.jLi;
    }
}
