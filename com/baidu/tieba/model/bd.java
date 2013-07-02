package com.baidu.tieba.model;

import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.a.c {
    private bf a = null;
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
        if (this.a == null) {
            this.a = new bf(this);
            this.a.execute(new Integer[0]);
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
