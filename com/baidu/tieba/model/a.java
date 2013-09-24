package com.baidu.tieba.model;

import android.content.Context;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.adp.a.e f1387a;
    private b b;
    private Context c;

    public a(Context context, com.baidu.adp.a.e eVar) {
        this.f1387a = null;
        this.c = context;
        this.f1387a = eVar;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return false;
        }
        return false;
    }

    public void a() {
        if (this.b == null) {
            this.b = new b(this, null);
        }
        this.b.setPriority(3);
        this.b.execute(new String[0]);
    }
}
