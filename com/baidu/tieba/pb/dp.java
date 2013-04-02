package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
class dp implements View.OnClickListener {
    final /* synthetic */ Cdo a;
    private String b = null;

    public dp(Cdo cdo) {
        this.a = cdo;
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
