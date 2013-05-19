package com.baidu.tieba.nearby;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ ae a;
    private String b;
    private String c;

    public ah(ae aeVar) {
        this.a = aeVar;
        b(null);
        a(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.a.a;
        PersonInfoActivity.a(context, this.b, this.c);
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(String str) {
        this.b = str;
    }
}
