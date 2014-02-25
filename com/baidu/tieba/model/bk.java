package com.baidu.tieba.model;

import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public class bk extends com.baidu.adp.a.d {
    private bm a = null;
    private WriteData b = null;
    private bl c = null;
    private boolean d = false;

    public void a(boolean z) {
        this.d = z;
    }

    public void a(bl blVar) {
        this.c = blVar;
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
            this.a = new bm(this);
            this.a.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }
}
