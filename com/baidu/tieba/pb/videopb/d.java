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
    private f lOi;
    private f mld;
    private Rect mlf;
    private boolean mlg;
    private MutableLiveData<cb> mle = new MutableLiveData<>();
    private LinkedList<f> mlh = new LinkedList<>();
    private MutableLiveData<cb> mli = new MutableLiveData<>();
    private MutableLiveData<cb> mlj = new MutableLiveData<>();
    private MutableLiveData<Boolean> mlk = new MutableLiveData<>();
    private MutableLiveData<Boolean> mll = new MutableLiveData<>();
    private MutableLiveData<Boolean> mlm = new MutableLiveData<>();
    private MutableLiveData<Boolean> jPh = new MutableLiveData<>();
    private MutableLiveData<Integer> mln = new MutableLiveData<>();

    public void O(f fVar) {
        this.mld = fVar;
        setData(fVar);
        this.mli.setValue(null);
        this.mle.setValue(fVar.dlg());
    }

    public f duy() {
        return this.mld;
    }

    public f duz() {
        return this.lOi;
    }

    public void setData(f fVar) {
        this.lOi = fVar;
        if (fVar != null) {
            this.mle.setValue(fVar.dlg());
            if (!y.isEmpty(fVar.dlI())) {
                aU(fVar.dlI().get(0));
            }
        }
    }

    public MutableLiveData<cb> duA() {
        return this.mle;
    }

    public boolean isFromCDN() {
        return this.akO;
    }

    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    public void h(Rect rect) {
        this.mlf = rect;
    }

    public Rect duB() {
        return this.mlf;
    }

    public void wq(boolean z) {
        this.mlg = z;
    }

    public boolean duC() {
        return this.mlg;
    }

    public LinkedList<f> duD() {
        return this.mlh;
    }

    public void aT(cb cbVar) {
        this.mli.setValue(cbVar);
    }

    public void aU(cb cbVar) {
        this.mlj.setValue(cbVar);
    }

    public MutableLiveData<cb> duE() {
        return this.mli;
    }

    public MutableLiveData<cb> duF() {
        return this.mlj;
    }

    public MutableLiveData<Boolean> duG() {
        return this.mlk;
    }

    public void wr(boolean z) {
        this.mlk.setValue(Boolean.valueOf(z));
    }

    public MutableLiveData<Boolean> duH() {
        return this.mll;
    }

    public void ws(boolean z) {
        this.mll.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.jPh.setValue(Boolean.valueOf(z));
    }

    public MutableLiveData<Boolean> cMS() {
        return this.jPh;
    }

    public MutableLiveData<Integer> duI() {
        return this.mln;
    }
}
