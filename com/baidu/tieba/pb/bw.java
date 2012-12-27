package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
class bw implements View.OnClickListener {
    final /* synthetic */ bt a;
    private String b = null;
    private int c = 0;
    private int d = 0;

    public bw(bt btVar) {
        this.a = btVar;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(int i) {
        this.d = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.a.a;
        ((PbActivity) context).a(this.c, this.b, this.d);
    }
}
