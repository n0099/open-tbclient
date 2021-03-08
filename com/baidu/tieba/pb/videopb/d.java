package com.baidu.tieba.pb.videopb;

import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.pb.data.f;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d {
    private boolean amh;
    private f lQk;
    private f mnf;
    private Rect mnh;
    private boolean mni;
    private MutableLiveData<cb> mng = new MutableLiveData<>();
    private LinkedList<f> mnj = new LinkedList<>();
    private MutableLiveData<cb> mnk = new MutableLiveData<>();
    private MutableLiveData<cb> mnl = new MutableLiveData<>();
    private MutableLiveData<Boolean> mnm = new MutableLiveData<>();
    private MutableLiveData<Boolean> mnn = new MutableLiveData<>();
    private MutableLiveData<Boolean> mno = new MutableLiveData<>();
    private MutableLiveData<Boolean> jQQ = new MutableLiveData<>();
    private MutableLiveData<Integer> mnp = new MutableLiveData<>();

    public void O(f fVar) {
        this.mnf = fVar;
        setData(fVar);
        this.mnk.setValue(null);
        this.mng.setValue(fVar.dlp());
    }

    public f duH() {
        return this.mnf;
    }

    public f duI() {
        return this.lQk;
    }

    public void setData(f fVar) {
        this.lQk = fVar;
        if (fVar != null) {
            this.mng.setValue(fVar.dlp());
            if (!y.isEmpty(fVar.dlR())) {
                aU(fVar.dlR().get(0));
            }
        }
    }

    public MutableLiveData<cb> duJ() {
        return this.mng;
    }

    public boolean isFromCDN() {
        return this.amh;
    }

    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    public void h(Rect rect) {
        this.mnh = rect;
    }

    public Rect duK() {
        return this.mnh;
    }

    public void wq(boolean z) {
        this.mni = z;
    }

    public boolean duL() {
        return this.mni;
    }

    public LinkedList<f> duM() {
        return this.mnj;
    }

    public void aT(cb cbVar) {
        this.mnk.setValue(cbVar);
    }

    public void aU(cb cbVar) {
        this.mnl.setValue(cbVar);
    }

    public MutableLiveData<cb> duN() {
        return this.mnk;
    }

    public MutableLiveData<cb> duO() {
        return this.mnl;
    }

    public MutableLiveData<Boolean> duP() {
        return this.mnm;
    }

    public void wr(boolean z) {
        this.mnm.setValue(Boolean.valueOf(z));
    }

    public MutableLiveData<Boolean> duQ() {
        return this.mnn;
    }

    public void ws(boolean z) {
        this.mnn.postValue(Boolean.valueOf(z));
    }

    public void setIsLoading(boolean z) {
        this.jQQ.setValue(Boolean.valueOf(z));
    }

    public MutableLiveData<Boolean> cMY() {
        return this.jQQ;
    }

    public MutableLiveData<Integer> duR() {
        return this.mnp;
    }
}
