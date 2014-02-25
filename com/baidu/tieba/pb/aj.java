package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    final /* synthetic */ ah a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar, String str, String str2) {
        this.a = ahVar;
        this.b = str;
        this.c = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.a.c;
        com.baidu.tieba.person.cm.a(context, this.b, this.c);
    }
}
