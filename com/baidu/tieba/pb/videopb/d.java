package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class d {
    private boolean ajr;
    private com.baidu.tieba.pb.data.f kAg;
    private com.baidu.tieba.pb.data.f kWm;
    private Rect kWo;
    private boolean kWp;
    private p<bw> kWn = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> kWq = new LinkedList<>();
    private p<bw> kWr = new p<>();
    private p<bw> kWs = new p<>();
    private p<Boolean> kWt = new p<>();
    private p<Boolean> kWu = new p<>();
    private p<Boolean> kWv = new p<>();
    private p<Boolean> kWw = new p<>();
    private p<Integer> kWx = new p<>();

    public void L(com.baidu.tieba.pb.data.f fVar) {
        this.kWm = fVar;
        setData(fVar);
        this.kWr.setValue(null);
        this.kWn.setValue(fVar.cVl());
    }

    public com.baidu.tieba.pb.data.f dep() {
        return this.kWm;
    }

    public com.baidu.tieba.pb.data.f deq() {
        return this.kAg;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kAg = fVar;
        if (fVar != null) {
            this.kWn.setValue(fVar.cVl());
            if (!y.isEmpty(fVar.cVN())) {
                aP(fVar.cVN().get(0));
            }
        }
    }

    public p<bw> der() {
        return this.kWn;
    }

    public boolean isFromCDN() {
        return this.ajr;
    }

    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    public void i(Rect rect) {
        this.kWo = rect;
    }

    public Rect des() {
        return this.kWo;
    }

    public void uf(boolean z) {
        this.kWp = z;
    }

    public boolean det() {
        return this.kWp;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> deu() {
        return this.kWq;
    }

    public void aO(bw bwVar) {
        this.kWr.setValue(bwVar);
    }

    public void aP(bw bwVar) {
        this.kWs.setValue(bwVar);
    }

    public p<bw> dev() {
        return this.kWr;
    }

    public p<bw> dew() {
        return this.kWs;
    }

    public p<Boolean> dex() {
        return this.kWt;
    }

    public void ug(boolean z) {
        this.kWt.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> dey() {
        return this.kWu;
    }

    public void uh(boolean z) {
        this.kWu.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.kWw.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> dez() {
        return this.kWw;
    }

    public p<Integer> deA() {
        return this.kWx;
    }
}
