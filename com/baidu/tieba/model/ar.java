package com.baidu.tieba.model;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.d {
    private at a = null;
    private WriteData b = null;
    private as c = null;
    private boolean d = false;

    public void a(boolean z) {
        this.d = z;
    }

    public void a(as asVar) {
        this.c = asVar;
    }

    public void a(WriteData writeData) {
        this.b = writeData;
    }

    public WriteData a() {
        return this.b;
    }

    public boolean b() {
        if (this.b == null) {
            return false;
        }
        if (this.a == null) {
            this.a = new at(this);
            this.a.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        return false;
    }
}
