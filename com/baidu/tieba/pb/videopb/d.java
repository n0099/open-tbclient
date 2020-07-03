package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class d {
    private boolean aik;
    private com.baidu.tieba.pb.data.e kck;
    private com.baidu.tieba.pb.data.e kxJ;
    private Rect kxL;
    private boolean kxM;
    private p<bu> kxK = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.e> kxN = new LinkedList<>();
    private p<bu> kxO = new p<>();
    private p<bu> kxP = new p<>();
    private p<Boolean> kxQ = new p<>();
    private p<Boolean> kxR = new p<>();
    private p<Boolean> kxS = new p<>();
    private p<Integer> kxT = new p<>();

    public void L(com.baidu.tieba.pb.data.e eVar) {
        this.kxJ = eVar;
        setData(eVar);
        this.kxO.setValue(null);
        this.kxK.setValue(eVar.cGN());
    }

    public com.baidu.tieba.pb.data.e cPI() {
        return this.kxJ;
    }

    public com.baidu.tieba.pb.data.e cPJ() {
        return this.kck;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.kck = eVar;
        if (eVar != null) {
            this.kxK.setValue(eVar.cGN());
            if (!w.isEmpty(eVar.cHo())) {
                aR(eVar.cHo().get(0));
            }
        }
    }

    public p<bu> cPK() {
        return this.kxK;
    }

    public boolean isFromCDN() {
        return this.aik;
    }

    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    public void i(Rect rect) {
        this.kxL = rect;
    }

    public Rect cPL() {
        return this.kxL;
    }

    public void sQ(boolean z) {
        this.kxM = z;
    }

    public boolean cPM() {
        return this.kxM;
    }

    public LinkedList<com.baidu.tieba.pb.data.e> cPN() {
        return this.kxN;
    }

    public void aQ(bu buVar) {
        this.kxO.setValue(buVar);
    }

    public void aR(bu buVar) {
        this.kxP.setValue(buVar);
    }

    public p<bu> cPO() {
        return this.kxO;
    }

    public p<bu> cPP() {
        return this.kxP;
    }

    public p<Boolean> cPQ() {
        return this.kxQ;
    }

    public void sR(boolean z) {
        this.kxQ.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cPR() {
        return this.kxR;
    }

    public void sS(boolean z) {
        this.kxR.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.kxS.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cPS() {
        return this.kxS;
    }

    public p<Integer> cPT() {
        return this.kxT;
    }
}
