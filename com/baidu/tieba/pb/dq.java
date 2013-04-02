package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
class dq implements View.OnClickListener {
    final /* synthetic */ Cdo a;
    private String b = null;

    public dq(Cdo cdo) {
        this.a = cdo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.a.a;
        ((SubPbActivity) context).c(this.b);
    }

    public void a(String str) {
        this.b = str;
    }
}
