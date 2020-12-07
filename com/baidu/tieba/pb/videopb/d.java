package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class d {
    private boolean alo;
    private com.baidu.tieba.pb.data.f lEt;
    private com.baidu.tieba.pb.data.f mbd;
    private Rect mbf;
    private boolean mbg;
    private p<by> mbe = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> mbh = new LinkedList<>();
    private p<by> mbi = new p<>();
    private p<by> mbj = new p<>();
    private p<Boolean> mbk = new p<>();
    private p<Boolean> mbl = new p<>();
    private p<Boolean> mbm = new p<>();
    private p<Boolean> mbn = new p<>();
    private p<Integer> mbo = new p<>();

    public void O(com.baidu.tieba.pb.data.f fVar) {
        this.mbd = fVar;
        setData(fVar);
        this.mbi.setValue(null);
        this.mbe.setValue(fVar.dmT());
    }

    public com.baidu.tieba.pb.data.f dwg() {
        return this.mbd;
    }

    public com.baidu.tieba.pb.data.f dwh() {
        return this.lEt;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lEt = fVar;
        if (fVar != null) {
            this.mbe.setValue(fVar.dmT());
            if (!y.isEmpty(fVar.dnw())) {
                aS(fVar.dnw().get(0));
            }
        }
    }

    public p<by> dwi() {
        return this.mbe;
    }

    public boolean isFromCDN() {
        return this.alo;
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    public void i(Rect rect) {
        this.mbf = rect;
    }

    public Rect dwj() {
        return this.mbf;
    }

    public void wc(boolean z) {
        this.mbg = z;
    }

    public boolean dwk() {
        return this.mbg;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> dwl() {
        return this.mbh;
    }

    public void aR(by byVar) {
        this.mbi.setValue(byVar);
    }

    public void aS(by byVar) {
        this.mbj.setValue(byVar);
    }

    public p<by> dwm() {
        return this.mbi;
    }

    public p<by> dwn() {
        return this.mbj;
    }

    public p<Boolean> dwo() {
        return this.mbk;
    }

    public void wd(boolean z) {
        this.mbk.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> dwp() {
        return this.mbl;
    }

    public void we(boolean z) {
        this.mbl.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.mbn.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> dwq() {
        return this.mbn;
    }

    public p<Integer> dwr() {
        return this.mbo;
    }
}
