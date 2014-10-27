package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.e {
    public static int bpt = 10;
    private at bpu;
    private WriteData bpv;
    private as bpw;
    private boolean bpx;

    public ar(Context context) {
        super(context);
        this.bpu = null;
        this.bpv = null;
        this.bpw = null;
        this.bpx = false;
    }

    public void dI(boolean z) {
        this.bpx = z;
    }

    public void a(as asVar) {
        this.bpw = asVar;
    }

    public void b(WriteData writeData) {
        this.bpv = writeData;
    }

    public WriteData EC() {
        return this.bpv;
    }

    public boolean TR() {
        if (this.bpv == null) {
            return false;
        }
        if (this.bpu == null) {
            this.bpu = new at(this);
            this.bpu.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bpu != null && !this.bpu.isCancelled()) {
            this.bpu.cancel();
            return false;
        }
        return false;
    }

    public boolean TS() {
        if (this.bpv == null) {
            return true;
        }
        int size = (!this.bpv.getIsBaobao() || this.bpv.getBaobaoImagesInfo() == null) ? 0 : this.bpv.getBaobaoImagesInfo().size() + 0;
        if (this.bpv.getWriteImagesInfo() != null) {
            size += this.bpv.getWriteImagesInfo().size();
        }
        return size <= bpt;
    }
}
