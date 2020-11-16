package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class d {
    private boolean akn;
    private com.baidu.tieba.pb.data.f lNb;
    private Rect lNd;
    private boolean lNe;
    private com.baidu.tieba.pb.data.f lqK;
    private p<bx> lNc = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> lNf = new LinkedList<>();
    private p<bx> lNg = new p<>();
    private p<bx> lNh = new p<>();
    private p<Boolean> lNi = new p<>();
    private p<Boolean> lNj = new p<>();
    private p<Boolean> lNk = new p<>();
    private p<Boolean> lNl = new p<>();
    private p<Integer> lNm = new p<>();

    public void N(com.baidu.tieba.pb.data.f fVar) {
        this.lNb = fVar;
        setData(fVar);
        this.lNg.setValue(null);
        this.lNc.setValue(fVar.dhH());
    }

    public com.baidu.tieba.pb.data.f dqN() {
        return this.lNb;
    }

    public com.baidu.tieba.pb.data.f dqO() {
        return this.lqK;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lqK = fVar;
        if (fVar != null) {
            this.lNc.setValue(fVar.dhH());
            if (!y.isEmpty(fVar.dij())) {
                aS(fVar.dij().get(0));
            }
        }
    }

    public p<bx> dqP() {
        return this.lNc;
    }

    public boolean isFromCDN() {
        return this.akn;
    }

    public void setFromCDN(boolean z) {
        this.akn = z;
    }

    public void i(Rect rect) {
        this.lNd = rect;
    }

    public Rect dqQ() {
        return this.lNd;
    }

    public void vz(boolean z) {
        this.lNe = z;
    }

    public boolean dqR() {
        return this.lNe;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> dqS() {
        return this.lNf;
    }

    public void aR(bx bxVar) {
        this.lNg.setValue(bxVar);
    }

    public void aS(bx bxVar) {
        this.lNh.setValue(bxVar);
    }

    public p<bx> dqT() {
        return this.lNg;
    }

    public p<bx> dqU() {
        return this.lNh;
    }

    public p<Boolean> dqV() {
        return this.lNi;
    }

    public void vA(boolean z) {
        this.lNi.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> dqW() {
        return this.lNj;
    }

    public void vB(boolean z) {
        this.lNj.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.lNl.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> dqX() {
        return this.lNl;
    }

    public p<Integer> dqY() {
        return this.lNm;
    }
}
