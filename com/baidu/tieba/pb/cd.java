package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
class cd implements View.OnClickListener {
    final /* synthetic */ ca a;
    private String b = null;
    private int c = 0;
    private int d = 0;

    public cd(ca caVar) {
        this.a = caVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.a.a;
        ((PbActivity) context).a(this.c, this.b, this.d);
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.d = i;
    }
}
