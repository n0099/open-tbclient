package com.baidu.tieba.model;

import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public class bj extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private bl f1420a = null;
    private WriteData b = null;
    private bk c = null;
    private boolean d = false;

    public void a(boolean z) {
        this.d = z;
    }

    public void a(bk bkVar) {
        this.c = bkVar;
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
        if (this.f1420a == null) {
            this.f1420a = new bl(this);
            this.f1420a.execute(new Integer[0]);
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
