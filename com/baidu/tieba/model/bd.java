package com.baidu.tieba.model;

import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private bf f1034a = null;
    private WriteData b = null;
    private be c = null;
    private boolean d = false;

    public void a(boolean z) {
        this.d = z;
    }

    public void a(be beVar) {
        this.c = beVar;
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
        if (this.f1034a == null) {
            this.f1034a = new bf(this);
            this.f1034a.execute(new Integer[0]);
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
