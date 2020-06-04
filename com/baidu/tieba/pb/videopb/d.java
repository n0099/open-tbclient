package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.graphics.Rect;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class d {
    private boolean aha;
    private com.baidu.tieba.pb.data.e jIA;
    private com.baidu.tieba.pb.data.e kdU;
    private Rect kdW;
    private boolean kdX;
    private p<bk> kdV = new p<>();
    private LinkedList<com.baidu.tieba.pb.data.e> kdY = new LinkedList<>();
    private p<bk> kdZ = new p<>();
    private p<bk> kea = new p<>();
    private p<Boolean> keb = new p<>();
    private p<Boolean> kec = new p<>();
    private p<Boolean> ked = new p<>();
    private p<Integer> kee = new p<>();

    public void K(com.baidu.tieba.pb.data.e eVar) {
        this.kdU = eVar;
        setData(eVar);
        this.kdZ.setValue(null);
        this.kdV.setValue(eVar.cCy());
    }

    public com.baidu.tieba.pb.data.e cLr() {
        return this.kdU;
    }

    public com.baidu.tieba.pb.data.e cLs() {
        return this.jIA;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jIA = eVar;
        if (eVar != null) {
            this.kdV.setValue(eVar.cCy());
            if (!v.isEmpty(eVar.cCY())) {
                aQ(eVar.cCY().get(0));
            }
        }
    }

    public p<bk> cLt() {
        return this.kdV;
    }

    public boolean isFromCDN() {
        return this.aha;
    }

    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    public void i(Rect rect) {
        this.kdW = rect;
    }

    public Rect cLu() {
        return this.kdW;
    }

    public void sC(boolean z) {
        this.kdX = z;
    }

    public boolean cLv() {
        return this.kdX;
    }

    public LinkedList<com.baidu.tieba.pb.data.e> cLw() {
        return this.kdY;
    }

    public void aP(bk bkVar) {
        this.kdZ.setValue(bkVar);
    }

    public void aQ(bk bkVar) {
        this.kea.setValue(bkVar);
    }

    public p<bk> cLx() {
        return this.kdZ;
    }

    public p<bk> cLy() {
        return this.kea;
    }

    public p<Boolean> cLz() {
        return this.keb;
    }

    public void sD(boolean z) {
        this.keb.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cLA() {
        return this.kec;
    }

    public void sE(boolean z) {
        this.kec.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.ked.setValue(Boolean.valueOf(z));
    }

    public p<Boolean> cLB() {
        return this.ked;
    }

    public void setCurrentTab(int i) {
        this.kee.setValue(Integer.valueOf(i));
    }

    public p<Integer> cLC() {
        return this.kee;
    }
}
