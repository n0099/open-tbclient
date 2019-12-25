package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class d {
    private boolean Nf;
    private com.baidu.tieba.pb.data.f iTT;
    private Rect iTV;
    private boolean iTW;
    private com.baidu.tieba.pb.data.f izv;
    private p<bj> iTU = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> iTX = new LinkedList<>();
    private p<bj> iTY = new p<>();
    private p<bj> iTZ = new p<>();
    private p<Boolean> iUa = new p<>();
    private p<Boolean> iUb = new p<>();
    private p<Boolean> iUc = new p<>();
    private p<Integer> iUd = new p<>();

    public void G(com.baidu.tieba.pb.data.f fVar) {
        this.iTT = fVar;
        setData(fVar);
        this.iTY.setValue(null);
        this.iTU.setValue(fVar.chK());
    }

    public com.baidu.tieba.pb.data.f cqA() {
        return this.iTT;
    }

    public com.baidu.tieba.pb.data.f cqB() {
        return this.izv;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.izv = fVar;
        if (fVar != null) {
            this.iTU.setValue(fVar.chK());
            if (!v.isEmpty(fVar.cij())) {
                aK(fVar.cij().get(0));
            }
        }
    }

    public p<bj> cqC() {
        return this.iTU;
    }

    public boolean isFromCDN() {
        return this.Nf;
    }

    public void setFromCDN(boolean z) {
        this.Nf = z;
    }

    public void i(Rect rect) {
        this.iTV = rect;
    }

    public Rect cqD() {
        return this.iTV;
    }

    public void qC(boolean z) {
        this.iTW = z;
    }

    public boolean cqE() {
        return this.iTW;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> cqF() {
        return this.iTX;
    }

    public void aJ(bj bjVar) {
        this.iTY.setValue(bjVar);
    }

    public void aK(bj bjVar) {
        this.iTZ.setValue(bjVar);
    }

    public p<bj> cqG() {
        return this.iTY;
    }

    public p<bj> cqH() {
        return this.iTZ;
    }

    public p<Boolean> cqI() {
        return this.iUa;
    }

    public void qD(boolean z) {
        this.iUa.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cqJ() {
        return this.iUb;
    }

    public void qE(boolean z) {
        this.iUb.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.iUc.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cqK() {
        return this.iUc;
    }

    public void setCurrentTab(int i) {
        this.iUd.setValue(Integer.valueOf(i));
    }

    public p<Integer> cqL() {
        return this.iUd;
    }
}
