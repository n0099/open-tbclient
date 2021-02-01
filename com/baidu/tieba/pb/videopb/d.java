package com.baidu.tieba.pb.videopb;

import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.pb.data.f;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d {
    private boolean akO;
    private f lNT;
    private f mkO;
    private Rect mkQ;
    private boolean mkR;
    private MutableLiveData<cb> mkP = new MutableLiveData<>();
    private LinkedList<f> mkS = new LinkedList<>();
    private MutableLiveData<cb> mkT = new MutableLiveData<>();
    private MutableLiveData<cb> mkU = new MutableLiveData<>();
    private MutableLiveData<Boolean> mkV = new MutableLiveData<>();
    private MutableLiveData<Boolean> mkW = new MutableLiveData<>();
    private MutableLiveData<Boolean> mkX = new MutableLiveData<>();
    private MutableLiveData<Boolean> jOT = new MutableLiveData<>();
    private MutableLiveData<Integer> mkY = new MutableLiveData<>();

    public void O(f fVar) {
        this.mkO = fVar;
        setData(fVar);
        this.mkT.setValue(null);
        this.mkP.setValue(fVar.dkZ());
    }

    public f dur() {
        return this.mkO;
    }

    public f dus() {
        return this.lNT;
    }

    public void setData(f fVar) {
        this.lNT = fVar;
        if (fVar != null) {
            this.mkP.setValue(fVar.dkZ());
            if (!y.isEmpty(fVar.dlB())) {
                aU(fVar.dlB().get(0));
            }
        }
    }

    public MutableLiveData<cb> dut() {
        return this.mkP;
    }

    public boolean isFromCDN() {
        return this.akO;
    }

    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    public void h(Rect rect) {
        this.mkQ = rect;
    }

    public Rect duu() {
        return this.mkQ;
    }

    public void wq(boolean z) {
        this.mkR = z;
    }

    public boolean duv() {
        return this.mkR;
    }

    public LinkedList<f> duw() {
        return this.mkS;
    }

    public void aT(cb cbVar) {
        this.mkT.setValue(cbVar);
    }

    public void aU(cb cbVar) {
        this.mkU.setValue(cbVar);
    }

    public MutableLiveData<cb> dux() {
        return this.mkT;
    }

    public MutableLiveData<cb> duy() {
        return this.mkU;
    }

    public MutableLiveData<Boolean> duz() {
        return this.mkV;
    }

    public void wr(boolean z) {
        this.mkV.setValue(Boolean.valueOf(z));
    }

    public MutableLiveData<Boolean> duA() {
        return this.mkW;
    }

    public void ws(boolean z) {
        this.mkW.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.jOT.setValue(Boolean.valueOf(z));
    }

    public MutableLiveData<Boolean> cML() {
        return this.jOT;
    }

    public MutableLiveData<Integer> duB() {
        return this.mkY;
    }
}
