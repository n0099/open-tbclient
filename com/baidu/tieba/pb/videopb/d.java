package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class d {
    private boolean ajR;
    private com.baidu.tieba.pb.data.f kIK;
    private com.baidu.tieba.pb.data.f leY;
    private Rect lfa;
    private boolean lfb;
    private p<bw> leZ = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.f> lfc = new LinkedList<>();
    private p<bw> lfd = new p<>();
    private p<bw> lfe = new p<>();
    private p<Boolean> lff = new p<>();
    private p<Boolean> lfg = new p<>();
    private p<Boolean> lfh = new p<>();
    private p<Boolean> lfi = new p<>();
    private p<Integer> lfj = new p<>();

    public void L(com.baidu.tieba.pb.data.f fVar) {
        this.leY = fVar;
        setData(fVar);
        this.lfd.setValue(null);
        this.leZ.setValue(fVar.cYR());
    }

    public com.baidu.tieba.pb.data.f dhU() {
        return this.leY;
    }

    public com.baidu.tieba.pb.data.f dhV() {
        return this.kIK;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kIK = fVar;
        if (fVar != null) {
            this.leZ.setValue(fVar.cYR());
            if (!y.isEmpty(fVar.cZt())) {
                aQ(fVar.cZt().get(0));
            }
        }
    }

    public p<bw> dhW() {
        return this.leZ;
    }

    public boolean isFromCDN() {
        return this.ajR;
    }

    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    public void i(Rect rect) {
        this.lfa = rect;
    }

    public Rect dhX() {
        return this.lfa;
    }

    public void up(boolean z) {
        this.lfb = z;
    }

    public boolean dhY() {
        return this.lfb;
    }

    public LinkedList<com.baidu.tieba.pb.data.f> dhZ() {
        return this.lfc;
    }

    public void aP(bw bwVar) {
        this.lfd.setValue(bwVar);
    }

    public void aQ(bw bwVar) {
        this.lfe.setValue(bwVar);
    }

    public p<bw> dia() {
        return this.lfd;
    }

    public p<bw> dib() {
        return this.lfe;
    }

    public p<Boolean> dic() {
        return this.lff;
    }

    public void uq(boolean z) {
        this.lff.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> did() {
        return this.lfg;
    }

    public void ur(boolean z) {
        this.lfg.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.lfi.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> die() {
        return this.lfi;
    }

    public p<Integer> dif() {
        return this.lfj;
    }
}
