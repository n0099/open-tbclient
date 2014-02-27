package com.baidu.tieba.model;

import android.content.Context;
/* loaded from: classes.dex */
public final class a extends com.baidu.adp.a.d {
    protected com.baidu.adp.a.g a;
    private b b;
    private Context c;

    public a(Context context, com.baidu.adp.a.g gVar) {
        this.a = null;
        this.c = context;
        this.a = gVar;
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return false;
        }
        return false;
    }

    public final void a() {
        if (this.b == null) {
            this.b = new b(this, (byte) 0);
        }
        this.b.setPriority(3);
        this.b.execute(new String[0]);
    }
}
