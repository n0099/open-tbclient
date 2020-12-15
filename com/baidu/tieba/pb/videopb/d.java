package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class d {
    private boolean alo;
    private com.baidu.tieba.pb.data.f lEv;
    private com.baidu.tieba.pb.data.f mbf;
    private Rect mbh;
    private boolean mbi;
    private p<by> mbg = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> mbj = new LinkedList<>();
    private p<by> mbk = new p<>();
    private p<by> mbl = new p<>();
    private p<Boolean> mbm = new p<>();
    private p<Boolean> mbn = new p<>();
    private p<Boolean> mbo = new p<>();
    private p<Boolean> mbp = new p<>();
    private p<Integer> mbq = new p<>();

    public void O(com.baidu.tieba.pb.data.f fVar) {
        this.mbf = fVar;
        setData(fVar);
        this.mbk.setValue(null);
        this.mbg.setValue(fVar.dmU());
    }

    public com.baidu.tieba.pb.data.f dwh() {
        return this.mbf;
    }

    public com.baidu.tieba.pb.data.f dwi() {
        return this.lEv;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lEv = fVar;
        if (fVar != null) {
            this.mbg.setValue(fVar.dmU());
            if (!y.isEmpty(fVar.dnx())) {
                aS(fVar.dnx().get(0));
            }
        }
    }

    public p<by> dwj() {
        return this.mbg;
    }

    public boolean isFromCDN() {
        return this.alo;
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    public void i(Rect rect) {
        this.mbh = rect;
    }

    public Rect dwk() {
        return this.mbh;
    }

    public void wc(boolean z) {
        this.mbi = z;
    }

    public boolean dwl() {
        return this.mbi;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> dwm() {
        return this.mbj;
    }

    public void aR(by byVar) {
        this.mbk.setValue(byVar);
    }

    public void aS(by byVar) {
        this.mbl.setValue(byVar);
    }

    public p<by> dwn() {
        return this.mbk;
    }

    public p<by> dwo() {
        return this.mbl;
    }

    public p<Boolean> dwp() {
        return this.mbm;
    }

    public void wd(boolean z) {
        this.mbm.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> dwq() {
        return this.mbn;
    }

    public void we(boolean z) {
        this.mbn.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.mbp.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> dwr() {
        return this.mbp;
    }

    public p<Integer> dws() {
        return this.mbq;
    }
}
