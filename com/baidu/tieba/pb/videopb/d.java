package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class d {
    private boolean Nj;
    private com.baidu.tieba.pb.data.f iCZ;
    private com.baidu.tieba.pb.data.f iXw;
    private Rect iXy;
    private boolean iXz;
    private p<bj> iXx = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> iXA = new LinkedList<>();
    private p<bj> iXB = new p<>();
    private p<bj> iXC = new p<>();
    private p<Boolean> iXD = new p<>();
    private p<Boolean> iXE = new p<>();
    private p<Boolean> iXF = new p<>();
    private p<Integer> iXG = new p<>();

    public void G(com.baidu.tieba.pb.data.f fVar) {
        this.iXw = fVar;
        setData(fVar);
        this.iXB.setValue(null);
        this.iXx.setValue(fVar.ciS());
    }

    public com.baidu.tieba.pb.data.f crH() {
        return this.iXw;
    }

    public com.baidu.tieba.pb.data.f crI() {
        return this.iCZ;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.iCZ = fVar;
        if (fVar != null) {
            this.iXx.setValue(fVar.ciS());
            if (!v.isEmpty(fVar.cjr())) {
                aL(fVar.cjr().get(0));
            }
        }
    }

    public p<bj> crJ() {
        return this.iXx;
    }

    public boolean isFromCDN() {
        return this.Nj;
    }

    public void setFromCDN(boolean z) {
        this.Nj = z;
    }

    public void i(Rect rect) {
        this.iXy = rect;
    }

    public Rect crK() {
        return this.iXy;
    }

    public void qP(boolean z) {
        this.iXz = z;
    }

    public boolean crL() {
        return this.iXz;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> crM() {
        return this.iXA;
    }

    public void aK(bj bjVar) {
        this.iXB.setValue(bjVar);
    }

    public void aL(bj bjVar) {
        this.iXC.setValue(bjVar);
    }

    public p<bj> crN() {
        return this.iXB;
    }

    public p<bj> crO() {
        return this.iXC;
    }

    public p<Boolean> crP() {
        return this.iXD;
    }

    public void qQ(boolean z) {
        this.iXD.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> crQ() {
        return this.iXE;
    }

    public void qR(boolean z) {
        this.iXE.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.iXF.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> crR() {
        return this.iXF;
    }

    public void setCurrentTab(int i) {
        this.iXG.setValue(Integer.valueOf(i));
    }

    public p<Integer> crS() {
        return this.iXG;
    }
}
