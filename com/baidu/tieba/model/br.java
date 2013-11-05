package com.baidu.tieba.model;

import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public class br extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private bt f1923a = null;
    private WriteData b = null;
    private bs c = null;
    private boolean d = false;

    public void a(boolean z) {
        this.d = z;
    }

    public void a(bs bsVar) {
        this.c = bsVar;
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
        if (this.f1923a == null) {
            this.f1923a = new bt(this);
            this.f1923a.execute(new Integer[0]);
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
