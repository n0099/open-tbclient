package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private ak f1397a;
    private al b;

    public void a(al alVar) {
        this.b = alVar;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        return false;
    }

    public void a(String str) {
        this.f1397a = new ak(this, str);
        this.f1397a.execute(new Void[0]);
    }
}
