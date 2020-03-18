package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class d {
    private boolean NK;
    private com.baidu.tieba.pb.data.e iGv;
    private com.baidu.tieba.pb.data.e jaQ;
    private Rect jaS;
    private boolean jaT;
    private p<bj> jaR = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.e> jaU = new LinkedList<>();
    private p<bj> jaV = new p<>();
    private p<bj> jaW = new p<>();
    private p<Boolean> jaX = new p<>();
    private p<Boolean> jaY = new p<>();
    private p<Boolean> jaZ = new p<>();
    private p<Integer> jba = new p<>();

    public void I(com.baidu.tieba.pb.data.e eVar) {
        this.jaQ = eVar;
        setData(eVar);
        this.jaV.setValue(null);
        this.jaR.setValue(eVar.ckP());
    }

    public com.baidu.tieba.pb.data.e ctA() {
        return this.jaQ;
    }

    public com.baidu.tieba.pb.data.e ctB() {
        return this.iGv;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iGv = eVar;
        if (eVar != null) {
            this.jaR.setValue(eVar.ckP());
            if (!v.isEmpty(eVar.clm())) {
                aP(eVar.clm().get(0));
            }
        }
    }

    public p<bj> ctC() {
        return this.jaR;
    }

    public boolean isFromCDN() {
        return this.NK;
    }

    public void setFromCDN(boolean z) {
        this.NK = z;
    }

    public void i(Rect rect) {
        this.jaS = rect;
    }

    public Rect ctD() {
        return this.jaS;
    }

    public void ra(boolean z) {
        this.jaT = z;
    }

    public boolean ctE() {
        return this.jaT;
    }

    public LinkedList<com.baidu.tieba.pb.data.e> ctF() {
        return this.jaU;
    }

    public void aO(bj bjVar) {
        this.jaV.setValue(bjVar);
    }

    public void aP(bj bjVar) {
        this.jaW.setValue(bjVar);
    }

    public p<bj> ctG() {
        return this.jaV;
    }

    public p<bj> ctH() {
        return this.jaW;
    }

    public p<Boolean> ctI() {
        return this.jaX;
    }

    public void rb(boolean z) {
        this.jaX.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> ctJ() {
        return this.jaY;
    }

    public void rc(boolean z) {
        this.jaY.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.jaZ.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> ctK() {
        return this.jaZ;
    }

    public void setCurrentTab(int i) {
        this.jba.setValue(Integer.valueOf(i));
    }

    public p<Integer> ctL() {
        return this.jba;
    }
}
