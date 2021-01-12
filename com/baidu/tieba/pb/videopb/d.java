package com.baidu.tieba.pb.videopb;

import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.pb.data.f;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d {
    private boolean akY;
    private f lFd;
    private f mbL;
    private Rect mbN;
    private boolean mbO;
    private MutableLiveData<bz> mbM = new MutableLiveData<>();
    private LinkedList<f> mbP = new LinkedList<>();
    private MutableLiveData<bz> mbQ = new MutableLiveData<>();
    private MutableLiveData<bz> mbR = new MutableLiveData<>();
    private MutableLiveData<Boolean> mbS = new MutableLiveData<>();
    private MutableLiveData<Boolean> mbT = new MutableLiveData<>();
    private MutableLiveData<Boolean> mbU = new MutableLiveData<>();
    private MutableLiveData<Boolean> mbV = new MutableLiveData<>();
    private MutableLiveData<Integer> mbW = new MutableLiveData<>();

    public void O(f fVar) {
        this.mbL = fVar;
        setData(fVar);
        this.mbQ.setValue(null);
        this.mbM.setValue(fVar.diN());
    }

    public f dsf() {
        return this.mbL;
    }

    public f dsg() {
        return this.lFd;
    }

    public void setData(f fVar) {
        this.lFd = fVar;
        if (fVar != null) {
            this.mbM.setValue(fVar.diN());
            if (!x.isEmpty(fVar.djp())) {
                aT(fVar.djp().get(0));
            }
        }
    }

    public MutableLiveData<bz> dsh() {
        return this.mbM;
    }

    public boolean isFromCDN() {
        return this.akY;
    }

    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    public void h(Rect rect) {
        this.mbN = rect;
    }

    public Rect dsi() {
        return this.mbN;
    }

    public void vZ(boolean z) {
        this.mbO = z;
    }

    public boolean dsj() {
        return this.mbO;
    }

    public LinkedList<f> dsk() {
        return this.mbP;
    }

    public void aS(bz bzVar) {
        this.mbQ.setValue(bzVar);
    }

    public void aT(bz bzVar) {
        this.mbR.setValue(bzVar);
    }

    public MutableLiveData<bz> dsl() {
        return this.mbQ;
    }

    public MutableLiveData<bz> dsm() {
        return this.mbR;
    }

    public MutableLiveData<Boolean> dsn() {
        return this.mbS;
    }

    public void wa(boolean z) {
        this.mbS.setValue(Boolean.valueOf(z));
    }

    public MutableLiveData<Boolean> dso() {
        return this.mbT;
    }

    public void wb(boolean z) {
        this.mbT.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.mbV.setValue(Boolean.valueOf(z));
    }

    public MutableLiveData<Boolean> dsp() {
        return this.mbV;
    }

    public MutableLiveData<Integer> dsq() {
        return this.mbW;
    }
}
