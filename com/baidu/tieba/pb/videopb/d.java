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
    private f lJI;
    private f mgr;
    private Rect mgt;
    private boolean mgu;
    private MutableLiveData<bz> mgs = new MutableLiveData<>();
    private LinkedList<f> mgv = new LinkedList<>();
    private MutableLiveData<bz> mgw = new MutableLiveData<>();
    private MutableLiveData<bz> mgx = new MutableLiveData<>();
    private MutableLiveData<Boolean> mgy = new MutableLiveData<>();
    private MutableLiveData<Boolean> mgz = new MutableLiveData<>();
    private MutableLiveData<Boolean> mgA = new MutableLiveData<>();
    private MutableLiveData<Boolean> mgB = new MutableLiveData<>();
    private MutableLiveData<Integer> mgC = new MutableLiveData<>();

    public void O(f fVar) {
        this.mgr = fVar;
        setData(fVar);
        this.mgw.setValue(null);
        this.mgs.setValue(fVar.dmE());
    }

    public f dvW() {
        return this.mgr;
    }

    public f dvX() {
        return this.lJI;
    }

    public void setData(f fVar) {
        this.lJI = fVar;
        if (fVar != null) {
            this.mgs.setValue(fVar.dmE());
            if (!x.isEmpty(fVar.dng())) {
                aT(fVar.dng().get(0));
            }
        }
    }

    public MutableLiveData<bz> dvY() {
        return this.mgs;
    }

    public boolean isFromCDN() {
        return this.alQ;
    }

    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    public void h(Rect rect) {
        this.mgt = rect;
    }

    public Rect dvZ() {
        return this.mgt;
    }

    public void wd(boolean z) {
        this.mgu = z;
    }

    public boolean dwa() {
        return this.mgu;
    }

    public LinkedList<f> dwb() {
        return this.mgv;
    }

    public void aS(bz bzVar) {
        this.mgw.setValue(bzVar);
    }

    public void aT(bz bzVar) {
        this.mgx.setValue(bzVar);
    }

    public MutableLiveData<bz> dwc() {
        return this.mgw;
    }

    public MutableLiveData<bz> dwd() {
        return this.mgx;
    }

    public MutableLiveData<Boolean> dwe() {
        return this.mgy;
    }

    public void we(boolean z) {
        this.mgy.setValue(Boolean.valueOf(z));
    }

    public MutableLiveData<Boolean> dwf() {
        return this.mgz;
    }

    public void wf(boolean z) {
        this.mgz.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.mgB.setValue(Boolean.valueOf(z));
    }

    public MutableLiveData<Boolean> dwg() {
        return this.mgB;
    }

    public MutableLiveData<Integer> dwh() {
        return this.mgC;
    }
}
