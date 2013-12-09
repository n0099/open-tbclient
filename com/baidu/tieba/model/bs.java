package com.baidu.tieba.model;

import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private bu f2014a = null;
    private WriteData b = null;
    private bt c = null;
    private boolean d = false;

    public void a(boolean z) {
        this.d = z;
    }

    public void a(bt btVar) {
        this.c = btVar;
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
        if (this.f2014a == null) {
            this.f2014a = new bu(this);
            this.f2014a.execute(new Integer[0]);
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
