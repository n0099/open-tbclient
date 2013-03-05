package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
class ce implements View.OnClickListener {
    final /* synthetic */ ca a;
    private String b = null;
    private int c = 0;

    public ce(ca caVar) {
        this.a = caVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.a.a;
        ((PbActivity) context).a(this.b, this.c);
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(int i) {
        this.c = i;
    }
}
