package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class d {
    private boolean ajt;
    private com.baidu.tieba.pb.data.f kAn;
    private com.baidu.tieba.pb.data.f kWt;
    private Rect kWv;
    private boolean kWw;
    private p<bw> kWu = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> kWx = new LinkedList<>();
    private p<bw> kWy = new p<>();
    private p<bw> kWz = new p<>();
    private p<Boolean> kWA = new p<>();
    private p<Boolean> kWB = new p<>();
    private p<Boolean> kWC = new p<>();
    private p<Boolean> kWD = new p<>();
    private p<Integer> kWE = new p<>();

    public void L(com.baidu.tieba.pb.data.f fVar) {
        this.kWt = fVar;
        setData(fVar);
        this.kWy.setValue(null);
        this.kWu.setValue(fVar.cVm());
    }

    public com.baidu.tieba.pb.data.f deq() {
        return this.kWt;
    }

    public com.baidu.tieba.pb.data.f der() {
        return this.kAn;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kAn = fVar;
        if (fVar != null) {
            this.kWu.setValue(fVar.cVm());
            if (!y.isEmpty(fVar.cVO())) {
                aP(fVar.cVO().get(0));
            }
        }
    }

    public p<bw> des() {
        return this.kWu;
    }

    public boolean isFromCDN() {
        return this.ajt;
    }

    public void setFromCDN(boolean z) {
        this.ajt = z;
    }

    public void i(Rect rect) {
        this.kWv = rect;
    }

    public Rect det() {
        return this.kWv;
    }

    public void uh(boolean z) {
        this.kWw = z;
    }

    public boolean deu() {
        return this.kWw;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> dev() {
        return this.kWx;
    }

    public void aO(bw bwVar) {
        this.kWy.setValue(bwVar);
    }

    public void aP(bw bwVar) {
        this.kWz.setValue(bwVar);
    }

    public p<bw> dew() {
        return this.kWy;
    }

    public p<bw> dex() {
        return this.kWz;
    }

    public p<Boolean> dey() {
        return this.kWA;
    }

    public void ui(boolean z) {
        this.kWA.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> dez() {
        return this.kWB;
    }

    public void uj(boolean z) {
        this.kWB.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.kWD.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> deA() {
        return this.kWD;
    }

    public p<Integer> deB() {
        return this.kWE;
    }
}
