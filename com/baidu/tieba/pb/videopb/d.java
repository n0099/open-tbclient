package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class d {
    private boolean akk;
    private com.baidu.tieba.pb.data.f lMJ;
    private Rect lML;
    private boolean lMM;
    private com.baidu.tieba.pb.data.f lqv;
    private p<bw> lMK = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> lMN = new LinkedList<>();
    private p<bw> lMO = new p<>();
    private p<bw> lMP = new p<>();
    private p<Boolean> lMQ = new p<>();
    private p<Boolean> lMR = new p<>();
    private p<Boolean> lMS = new p<>();
    private p<Boolean> lMT = new p<>();
    private p<Integer> lMU = new p<>();

    public void L(com.baidu.tieba.pb.data.f fVar) {
        this.lMJ = fVar;
        setData(fVar);
        this.lMO.setValue(null);
        this.lMK.setValue(fVar.dik());
    }

    public com.baidu.tieba.pb.data.f drn() {
        return this.lMJ;
    }

    public com.baidu.tieba.pb.data.f dro() {
        return this.lqv;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lqv = fVar;
        if (fVar != null) {
            this.lMK.setValue(fVar.dik());
            if (!y.isEmpty(fVar.diM())) {
                aQ(fVar.diM().get(0));
            }
        }
    }

    public p<bw> drp() {
        return this.lMK;
    }

    public boolean isFromCDN() {
        return this.akk;
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    public void i(Rect rect) {
        this.lML = rect;
    }

    public Rect drq() {
        return this.lML;
    }

    public void vw(boolean z) {
        this.lMM = z;
    }

    public boolean drr() {
        return this.lMM;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> drs() {
        return this.lMN;
    }

    public void aP(bw bwVar) {
        this.lMO.setValue(bwVar);
    }

    public void aQ(bw bwVar) {
        this.lMP.setValue(bwVar);
    }

    public p<bw> drt() {
        return this.lMO;
    }

    public p<bw> dru() {
        return this.lMP;
    }

    public p<Boolean> drv() {
        return this.lMQ;
    }

    public void vx(boolean z) {
        this.lMQ.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> drw() {
        return this.lMR;
    }

    public void vy(boolean z) {
        this.lMR.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.lMT.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> drx() {
        return this.lMT;
    }

    public p<Integer> dry() {
        return this.lMU;
    }
}
