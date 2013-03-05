package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ ak a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, String str, String str2) {
        this.a = akVar;
        this.b = str;
        this.c = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.a.c;
        PersonInfoActivity.a(context, String.valueOf(this.b), this.c);
    }
}
