package com.baidu.tieba.model;

import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public final class bk extends com.baidu.adp.a.d {
    private bm a = null;
    private WriteData b = null;
    private bl c = null;
    private boolean d = false;

    public final void a(boolean z) {
        this.d = z;
    }

    public final void a(bl blVar) {
        this.c = blVar;
    }

    public final void a(WriteData writeData) {
        this.b = writeData;
    }

    public final WriteData a() {
        return this.b;
    }

    public final boolean b() {
        if (this.b == null) {
            return false;
        }
        if (this.a == null) {
            this.a = new bm(this);
            this.a.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }
}
