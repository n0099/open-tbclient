package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class d {
    private boolean akj;
    private com.baidu.tieba.pb.data.f kXV;
    private com.baidu.tieba.pb.data.f lup;
    private Rect lur;
    private boolean lus;
    private p<bw> luq = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> lut = new LinkedList<>();
    private p<bw> luu = new p<>();
    private p<bw> luv = new p<>();
    private p<Boolean> luw = new p<>();
    private p<Boolean> lux = new p<>();
    private p<Boolean> luy = new p<>();
    private p<Boolean> luz = new p<>();
    private p<Integer> luA = new p<>();

    public void L(com.baidu.tieba.pb.data.f fVar) {
        this.lup = fVar;
        setData(fVar);
        this.luu.setValue(null);
        this.luq.setValue(fVar.dcA());
    }

    public com.baidu.tieba.pb.data.f dlD() {
        return this.lup;
    }

    public com.baidu.tieba.pb.data.f dlE() {
        return this.kXV;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kXV = fVar;
        if (fVar != null) {
            this.luq.setValue(fVar.dcA());
            if (!y.isEmpty(fVar.ddc())) {
                aQ(fVar.ddc().get(0));
            }
        }
    }

    public p<bw> dlF() {
        return this.luq;
    }

    public boolean isFromCDN() {
        return this.akj;
    }

    public void setFromCDN(boolean z) {
        this.akj = z;
    }

    public void i(Rect rect) {
        this.lur = rect;
    }

    public Rect dlG() {
        return this.lur;
    }

    public void uW(boolean z) {
        this.lus = z;
    }

    public boolean dlH() {
        return this.lus;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> dlI() {
        return this.lut;
    }

    public void aP(bw bwVar) {
        this.luu.setValue(bwVar);
    }

    public void aQ(bw bwVar) {
        this.luv.setValue(bwVar);
    }

    public p<bw> dlJ() {
        return this.luu;
    }

    public p<bw> dlK() {
        return this.luv;
    }

    public p<Boolean> dlL() {
        return this.luw;
    }

    public void uX(boolean z) {
        this.luw.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> dlM() {
        return this.lux;
    }

    public void uY(boolean z) {
        this.lux.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.luz.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> dlN() {
        return this.luz;
    }

    public p<Integer> dlO() {
        return this.luA;
    }
}
