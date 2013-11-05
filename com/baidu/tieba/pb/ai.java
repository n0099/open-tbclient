package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2045a;
    final /* synthetic */ String b;
    final /* synthetic */ ah c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar, String str, String str2) {
        this.c = ahVar;
        this.f2045a = str;
        this.b = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.c.c;
        PersonInfoActivity.a(context, String.valueOf(this.f2045a), this.b);
    }
}
