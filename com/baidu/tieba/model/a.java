package com.baidu.tieba.model;

import android.content.Context;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.d {
    protected com.baidu.adp.base.g a;
    private b b;
    private Context c;

    public a(Context context, com.baidu.adp.base.g gVar) {
        this.a = null;
        this.c = context;
        this.a = gVar;
    }

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
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
