package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class d {
    private boolean agw;
    private com.baidu.tieba.pb.data.e jLc;
    private Rect jLe;
    private boolean jLf;
    private com.baidu.tieba.pb.data.e jqG;
    private p<bj> jLd = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.e> jLg = new LinkedList<>();
    private p<bj> jLh = new p<>();
    private p<bj> jLi = new p<>();
    private p<Boolean> jLj = new p<>();
    private p<Boolean> jLk = new p<>();
    private p<Boolean> jLl = new p<>();
    private p<Integer> jLm = new p<>();

    public void I(com.baidu.tieba.pb.data.e eVar) {
        this.jLc = eVar;
        setData(eVar);
        this.jLh.setValue(null);
        this.jLd.setValue(eVar.cvr());
    }

    public com.baidu.tieba.pb.data.e cEd() {
        return this.jLc;
    }

    public com.baidu.tieba.pb.data.e cEe() {
        return this.jqG;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jqG = eVar;
        if (eVar != null) {
            this.jLd.setValue(eVar.cvr());
            if (!v.isEmpty(eVar.cvO())) {
                aQ(eVar.cvO().get(0));
            }
        }
    }

    public p<bj> cEf() {
        return this.jLd;
    }

    public boolean isFromCDN() {
        return this.agw;
    }

    public void setFromCDN(boolean z) {
        this.agw = z;
    }

    public void i(Rect rect) {
        this.jLe = rect;
    }

    public Rect cEg() {
        return this.jLe;
    }

    public void se(boolean z) {
        this.jLf = z;
    }

    public boolean cEh() {
        return this.jLf;
    }

    public LinkedList<com.baidu.tieba.pb.data.e> cEi() {
        return this.jLg;
    }

    public void aP(bj bjVar) {
        this.jLh.setValue(bjVar);
    }

    public void aQ(bj bjVar) {
        this.jLi.setValue(bjVar);
    }

    public p<bj> cEj() {
        return this.jLh;
    }

    public p<bj> cEk() {
        return this.jLi;
    }

    public p<Boolean> cEl() {
        return this.jLj;
    }

    public void sf(boolean z) {
        this.jLj.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cEm() {
        return this.jLk;
    }

    public void sg(boolean z) {
        this.jLk.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.jLl.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cEn() {
        return this.jLl;
    }

    public void setCurrentTab(int i) {
        this.jLm.setValue(Integer.valueOf(i));
    }

    public p<Integer> cEo() {
        return this.jLm;
    }
}
