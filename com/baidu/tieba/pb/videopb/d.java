package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class d {
    private boolean akk;
    private com.baidu.tieba.pb.data.f lGN;
    private Rect lGP;
    private boolean lGQ;
    private com.baidu.tieba.pb.data.f lku;
    private p<bw> lGO = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> lGR = new LinkedList<>();
    private p<bw> lGS = new p<>();
    private p<bw> lGT = new p<>();
    private p<Boolean> lGU = new p<>();
    private p<Boolean> lGV = new p<>();
    private p<Boolean> lGW = new p<>();
    private p<Boolean> lGX = new p<>();
    private p<Integer> lGY = new p<>();

    public void L(com.baidu.tieba.pb.data.f fVar) {
        this.lGN = fVar;
        setData(fVar);
        this.lGS.setValue(null);
        this.lGO.setValue(fVar.dfI());
    }

    public com.baidu.tieba.pb.data.f doL() {
        return this.lGN;
    }

    public com.baidu.tieba.pb.data.f doM() {
        return this.lku;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lku = fVar;
        if (fVar != null) {
            this.lGO.setValue(fVar.dfI());
            if (!y.isEmpty(fVar.dgk())) {
                aQ(fVar.dgk().get(0));
            }
        }
    }

    public p<bw> doN() {
        return this.lGO;
    }

    public boolean isFromCDN() {
        return this.akk;
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    public void i(Rect rect) {
        this.lGP = rect;
    }

    public Rect doO() {
        return this.lGP;
    }

    public void vn(boolean z) {
        this.lGQ = z;
    }

    public boolean doP() {
        return this.lGQ;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> doQ() {
        return this.lGR;
    }

    public void aP(bw bwVar) {
        this.lGS.setValue(bwVar);
    }

    public void aQ(bw bwVar) {
        this.lGT.setValue(bwVar);
    }

    public p<bw> doR() {
        return this.lGS;
    }

    public p<bw> doS() {
        return this.lGT;
    }

    public p<Boolean> doT() {
        return this.lGU;
    }

    public void vo(boolean z) {
        this.lGU.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> doU() {
        return this.lGV;
    }

    public void vp(boolean z) {
        this.lGV.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.lGX.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> doV() {
        return this.lGX;
    }

    public p<Integer> doW() {
        return this.lGY;
    }
}
