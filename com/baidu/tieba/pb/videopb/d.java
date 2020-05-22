package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class d {
    private boolean aha;
    private com.baidu.tieba.pb.data.e jHu;
    private com.baidu.tieba.pb.data.e kcO;
    private Rect kcQ;
    private boolean kcR;
    private p<bk> kcP = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.e> kcS = new LinkedList<>();
    private p<bk> kcT = new p<>();
    private p<bk> kcU = new p<>();
    private p<Boolean> kcV = new p<>();
    private p<Boolean> kcW = new p<>();
    private p<Boolean> kcX = new p<>();
    private p<Integer> kcY = new p<>();

    public void K(com.baidu.tieba.pb.data.e eVar) {
        this.kcO = eVar;
        setData(eVar);
        this.kcT.setValue(null);
        this.kcP.setValue(eVar.cCi());
    }

    public com.baidu.tieba.pb.data.e cLb() {
        return this.kcO;
    }

    public com.baidu.tieba.pb.data.e cLc() {
        return this.jHu;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jHu = eVar;
        if (eVar != null) {
            this.kcP.setValue(eVar.cCi());
            if (!v.isEmpty(eVar.cCI())) {
                aQ(eVar.cCI().get(0));
            }
        }
    }

    public p<bk> cLd() {
        return this.kcP;
    }

    public boolean isFromCDN() {
        return this.aha;
    }

    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    public void i(Rect rect) {
        this.kcQ = rect;
    }

    public Rect cLe() {
        return this.kcQ;
    }

    public void sC(boolean z) {
        this.kcR = z;
    }

    public boolean cLf() {
        return this.kcR;
    }

    public LinkedList<com.baidu.tieba.pb.data.e> cLg() {
        return this.kcS;
    }

    public void aP(bk bkVar) {
        this.kcT.setValue(bkVar);
    }

    public void aQ(bk bkVar) {
        this.kcU.setValue(bkVar);
    }

    public p<bk> cLh() {
        return this.kcT;
    }

    public p<bk> cLi() {
        return this.kcU;
    }

    public p<Boolean> cLj() {
        return this.kcV;
    }

    public void sD(boolean z) {
        this.kcV.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cLk() {
        return this.kcW;
    }

    public void sE(boolean z) {
        this.kcW.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.kcX.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cLl() {
        return this.kcX;
    }

    public void setCurrentTab(int i) {
        this.kcY.setValue(Integer.valueOf(i));
    }

    public p<Integer> cLm() {
        return this.kcY;
    }
}
