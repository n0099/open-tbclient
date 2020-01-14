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
    private com.baidu.tieba.pb.data.f iXB;
    private Rect iXD;
    private boolean iXE;
    private p<bj> iXC = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> iXF = new LinkedList<>();
    private p<bj> iXG = new p<>();
    private p<bj> iXH = new p<>();
    private p<Boolean> iXI = new p<>();
    private p<Boolean> iXJ = new p<>();
    private p<Boolean> iXK = new p<>();
    private p<Integer> iXL = new p<>();

    public void G(com.baidu.tieba.pb.data.f fVar) {
        this.iXB = fVar;
        setData(fVar);
        this.iXG.setValue(null);
        this.iXC.setValue(fVar.ciS());
    }

    public com.baidu.tieba.pb.data.f crJ() {
        return this.iXB;
    }

    public com.baidu.tieba.pb.data.f crK() {
        return this.iCZ;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.iCZ = fVar;
        if (fVar != null) {
            this.iXC.setValue(fVar.ciS());
            if (!v.isEmpty(fVar.cjr())) {
                aL(fVar.cjr().get(0));
            }
        }
    }

    public p<bj> crL() {
        return this.iXC;
    }

    public boolean isFromCDN() {
        return this.Nj;
    }

    public void setFromCDN(boolean z) {
        this.Nj = z;
    }

    public void i(Rect rect) {
        this.iXD = rect;
    }

    public Rect crM() {
        return this.iXD;
    }

    public void qP(boolean z) {
        this.iXE = z;
    }

    public boolean crN() {
        return this.iXE;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> crO() {
        return this.iXF;
    }

    public void aK(bj bjVar) {
        this.iXG.setValue(bjVar);
    }

    public void aL(bj bjVar) {
        this.iXH.setValue(bjVar);
    }

    public p<bj> crP() {
        return this.iXG;
    }

    public p<bj> crQ() {
        return this.iXH;
    }

    public p<Boolean> crR() {
        return this.iXI;
    }

    public void qQ(boolean z) {
        this.iXI.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> crS() {
        return this.iXJ;
    }

    public void qR(boolean z) {
        this.iXJ.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.iXK.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> crT() {
        return this.iXK;
    }

    public void setCurrentTab(int i) {
        this.iXL.setValue(Integer.valueOf(i));
    }

    public p<Integer> crU() {
        return this.iXL;
    }
}
