package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
class dg implements View.OnClickListener {
    final /* synthetic */ df a;
    private String b = null;

    public dg(df dfVar) {
        this.a = dfVar;
    }

    public void a(String str) {
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.a.a;
        ((SubPbActivity) context).a(1, this.b);
    }
}
