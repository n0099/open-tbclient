package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class d {
    private boolean aib;
    private com.baidu.tieba.pb.data.f kGD;
    private Rect kGF;
    private boolean kGG;
    private com.baidu.tieba.pb.data.f kkM;
    private p<bv> kGE = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> kGH = new LinkedList<>();
    private p<bv> kGI = new p<>();
    private p<bv> kGJ = new p<>();
    private p<Boolean> kGK = new p<>();
    private p<Boolean> kGL = new p<>();
    private p<Boolean> kGM = new p<>();
    private p<Boolean> kGN = new p<>();
    private p<Integer> kGO = new p<>();

    public void L(com.baidu.tieba.pb.data.f fVar) {
        this.kGD = fVar;
        setData(fVar);
        this.kGI.setValue(null);
        this.kGE.setValue(fVar.cKx());
    }

    public com.baidu.tieba.pb.data.f cTx() {
        return this.kGD;
    }

    public com.baidu.tieba.pb.data.f cTy() {
        return this.kkM;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kkM = fVar;
        if (fVar != null) {
            this.kGE.setValue(fVar.cKx());
            if (!x.isEmpty(fVar.cKZ())) {
                aO(fVar.cKZ().get(0));
            }
        }
    }

    public p<bv> cTz() {
        return this.kGE;
    }

    public boolean isFromCDN() {
        return this.aib;
    }

    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    public void i(Rect rect) {
        this.kGF = rect;
    }

    public Rect cTA() {
        return this.kGF;
    }

    public void tw(boolean z) {
        this.kGG = z;
    }

    public boolean cTB() {
        return this.kGG;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> cTC() {
        return this.kGH;
    }

    public void aN(bv bvVar) {
        this.kGI.setValue(bvVar);
    }

    public void aO(bv bvVar) {
        this.kGJ.setValue(bvVar);
    }

    public p<bv> cTD() {
        return this.kGI;
    }

    public p<bv> cTE() {
        return this.kGJ;
    }

    public p<Boolean> cTF() {
        return this.kGK;
    }

    public void tx(boolean z) {
        this.kGK.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cTG() {
        return this.kGL;
    }

    public void ty(boolean z) {
        this.kGL.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.kGN.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cTH() {
        return this.kGN;
    }

    public p<Integer> cTI() {
        return this.kGO;
    }
}
