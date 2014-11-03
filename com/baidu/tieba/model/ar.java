package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.e {
    public static int bpH = 10;
    private at bpI;
    private WriteData bpJ;
    private as bpK;
    private boolean bpL;

    public ar(Context context) {
        super(context);
        this.bpI = null;
        this.bpJ = null;
        this.bpK = null;
        this.bpL = false;
    }

    public void dI(boolean z) {
        this.bpL = z;
    }

    public void a(as asVar) {
        this.bpK = asVar;
    }

    public void b(WriteData writeData) {
        this.bpJ = writeData;
    }

    public WriteData EE() {
        return this.bpJ;
    }

    public boolean TU() {
        if (this.bpJ == null) {
            return false;
        }
        if (this.bpI == null) {
            this.bpI = new at(this);
            this.bpI.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bpI != null && !this.bpI.isCancelled()) {
            this.bpI.cancel();
            return false;
        }
        return false;
    }

    public boolean TV() {
        if (this.bpJ == null) {
            return true;
        }
        int size = (!this.bpJ.getIsBaobao() || this.bpJ.getBaobaoImagesInfo() == null) ? 0 : this.bpJ.getBaobaoImagesInfo().size() + 0;
        if (this.bpJ.getWriteImagesInfo() != null) {
            size += this.bpJ.getWriteImagesInfo().size();
        }
        return size <= bpH;
    }
}
