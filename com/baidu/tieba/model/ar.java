package com.baidu.tieba.model;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public final class ar extends com.baidu.adp.a.e {
    private at a = null;
    private WriteData b = null;
    private as c = null;
    private boolean d = false;

    public final void a(boolean z) {
        this.d = z;
    }

    public final void a(as asVar) {
        this.c = asVar;
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
            this.a = new at(this);
            this.a.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }
}
