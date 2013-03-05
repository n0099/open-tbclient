package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
class dn implements View.OnClickListener {
    final /* synthetic */ dm a;
    private String b = null;

    public dn(dm dmVar) {
        this.a = dmVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.a.a;
        ((SubPbActivity) context).a(1, this.b);
    }

    public void a(String str) {
        this.b = str;
    }
}
