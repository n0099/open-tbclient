package com.baidu.tieba.model;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.e {
    public static int a = 10;
    private at b = null;
    private WriteData c = null;
    private as d = null;
    private boolean e = false;

    public void a(boolean z) {
        this.e = z;
    }

    public void a(as asVar) {
        this.d = asVar;
    }

    public void a(WriteData writeData) {
        this.c = writeData;
    }

    public WriteData a() {
        return this.c;
    }

    public boolean b() {
        if (this.c == null) {
            return false;
        }
        if (this.b == null) {
            this.b = new at(this);
            this.b.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.b != null && !this.b.isCancelled()) {
            this.b.cancel();
            return false;
        }
        return false;
    }

    public boolean c() {
        if (this.c == null) {
            return true;
        }
        int size = (!this.c.getIsBaobao() || this.c.getBaobaoImagesInfo() == null) ? 0 : this.c.getBaobaoImagesInfo().size() + 0;
        if (this.c.getWriteImagesInfo() != null) {
            size += this.c.getWriteImagesInfo().size();
        }
        return size <= a;
    }
}
