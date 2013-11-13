package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2065a;
    final /* synthetic */ String b;
    final /* synthetic */ ag c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, String str, String str2) {
        this.c = agVar;
        this.f2065a = str;
        this.b = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.c.c;
        PersonInfoActivity.a(context, String.valueOf(this.f2065a), this.b);
    }
}
