package com.baidu.tieba.model;

import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public class bi extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private bk f1349a = null;
    private WriteData b = null;
    private bj c = null;
    private boolean d = false;

    public void a(boolean z) {
        this.d = z;
    }

    public void a(bj bjVar) {
        this.c = bjVar;
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
        if (this.f1349a == null) {
            this.f1349a = new bk(this);
            this.f1349a.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        return false;
    }
}
