package com.baidu.tieba.pb.videopb;

import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.pb.data.f;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d {
    private boolean alQ;
    private f lJH;
    private f mgq;
    private Rect mgs;
    private boolean mgt;
    private MutableLiveData<bz> mgr = new MutableLiveData<>();
    private LinkedList<f> mgu = new LinkedList<>();
    private MutableLiveData<bz> mgv = new MutableLiveData<>();
    private MutableLiveData<bz> mgw = new MutableLiveData<>();
    private MutableLiveData<Boolean> mgx = new MutableLiveData<>();
    private MutableLiveData<Boolean> mgy = new MutableLiveData<>();
    private MutableLiveData<Boolean> mgz = new MutableLiveData<>();
    private MutableLiveData<Boolean> mgA = new MutableLiveData<>();
    private MutableLiveData<Integer> mgB = new MutableLiveData<>();

    public void O(f fVar) {
        this.mgq = fVar;
        setData(fVar);
        this.mgv.setValue(null);
        this.mgr.setValue(fVar.dmF());
    }

    public f dvX() {
        return this.mgq;
    }

    public f dvY() {
        return this.lJH;
    }

    public void setData(f fVar) {
        this.lJH = fVar;
        if (fVar != null) {
            this.mgr.setValue(fVar.dmF());
            if (!x.isEmpty(fVar.dnh())) {
                aT(fVar.dnh().get(0));
            }
        }
    }

    public MutableLiveData<bz> dvZ() {
        return this.mgr;
    }

    public boolean isFromCDN() {
        return this.alQ;
    }

    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    public void h(Rect rect) {
        this.mgs = rect;
    }

    public Rect dwa() {
        return this.mgs;
    }

    public void wd(boolean z) {
        this.mgt = z;
    }

    public boolean dwb() {
        return this.mgt;
    }

    public LinkedList<f> dwc() {
        return this.mgu;
    }

    public void aS(bz bzVar) {
        this.mgv.setValue(bzVar);
    }

    public void aT(bz bzVar) {
        this.mgw.setValue(bzVar);
    }

    public MutableLiveData<bz> dwd() {
        return this.mgv;
    }

    public MutableLiveData<bz> dwe() {
        return this.mgw;
    }

    public MutableLiveData<Boolean> dwf() {
        return this.mgx;
    }

    public void we(boolean z) {
        this.mgx.setValue(Boolean.valueOf(z));
    }

    public MutableLiveData<Boolean> dwg() {
        return this.mgy;
    }

    public void wf(boolean z) {
        this.mgy.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.mgA.setValue(Boolean.valueOf(z));
    }

    public MutableLiveData<Boolean> dwh() {
        return this.mgA;
    }

    public MutableLiveData<Integer> dwi() {
        return this.mgB;
    }
}
