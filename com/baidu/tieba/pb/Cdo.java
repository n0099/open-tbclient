package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
/* renamed from: com.baidu.tieba.pb.do  reason: invalid class name */
/* loaded from: classes.dex */
class Cdo implements View.OnClickListener {
    final /* synthetic */ dm a;
    private String b = null;

    public Cdo(dm dmVar) {
        this.a = dmVar;
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
