package com.baidu.tieba.model;

import android.content.Context;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.adp.a.g f1974a;
    private c b;
    private Context c;

    public a(Context context, com.baidu.adp.a.g gVar) {
        this.f1974a = null;
        this.c = context;
        this.f1974a = gVar;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return false;
        }
        return false;
    }

    public void a() {
        if (this.b == null) {
            this.b = new c(this);
        }
        this.b.setPriority(3);
        this.b.execute(new String[0]);
    }
}
