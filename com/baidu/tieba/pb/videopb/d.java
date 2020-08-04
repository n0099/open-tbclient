package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class d {
    private boolean aib;
    private com.baidu.tieba.pb.data.f kGF;
    private Rect kGH;
    private boolean kGI;
    private com.baidu.tieba.pb.data.f kkO;
    private p<bv> kGG = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> kGJ = new LinkedList<>();
    private p<bv> kGK = new p<>();
    private p<bv> kGL = new p<>();
    private p<Boolean> kGM = new p<>();
    private p<Boolean> kGN = new p<>();
    private p<Boolean> kGO = new p<>();
    private p<Boolean> kGP = new p<>();
    private p<Integer> kGQ = new p<>();

    public void L(com.baidu.tieba.pb.data.f fVar) {
        this.kGF = fVar;
        setData(fVar);
        this.kGK.setValue(null);
        this.kGG.setValue(fVar.cKx());
    }

    public com.baidu.tieba.pb.data.f cTx() {
        return this.kGF;
    }

    public com.baidu.tieba.pb.data.f cTy() {
        return this.kkO;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kkO = fVar;
        if (fVar != null) {
            this.kGG.setValue(fVar.cKx());
            if (!x.isEmpty(fVar.cKZ())) {
                aO(fVar.cKZ().get(0));
            }
        }
    }

    public p<bv> cTz() {
        return this.kGG;
    }

    public boolean isFromCDN() {
        return this.aib;
    }

    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    public void i(Rect rect) {
        this.kGH = rect;
    }

    public Rect cTA() {
        return this.kGH;
    }

    public void tw(boolean z) {
        this.kGI = z;
    }

    public boolean cTB() {
        return this.kGI;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> cTC() {
        return this.kGJ;
    }

    public void aN(bv bvVar) {
        this.kGK.setValue(bvVar);
    }

    public void aO(bv bvVar) {
        this.kGL.setValue(bvVar);
    }

    public p<bv> cTD() {
        return this.kGK;
    }

    public p<bv> cTE() {
        return this.kGL;
    }

    public p<Boolean> cTF() {
        return this.kGM;
    }

    public void tx(boolean z) {
        this.kGM.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cTG() {
        return this.kGN;
    }

    public void ty(boolean z) {
        this.kGN.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.kGP.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cTH() {
        return this.kGP;
    }

    public p<Integer> cTI() {
        return this.kGQ;
    }
}
