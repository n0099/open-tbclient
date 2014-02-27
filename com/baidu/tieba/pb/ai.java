package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
final class ai implements View.OnClickListener {
    final /* synthetic */ ah a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar, String str, String str2) {
        this.a = ahVar;
        this.b = str;
        this.c = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.a.c;
        com.baidu.tieba.person.cm.a(context, String.valueOf(this.b), this.c);
    }
}
