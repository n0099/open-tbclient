package com.baidu.tieba.model;

import android.content.Context;
/* loaded from: classes.dex */
public final class a extends com.baidu.adp.a.e {
    protected com.baidu.adp.a.h a;
    private b b;
    private Context c;

    public a(Context context, com.baidu.adp.a.h hVar) {
        this.a = null;
        this.c = context;
        this.a = hVar;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
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
