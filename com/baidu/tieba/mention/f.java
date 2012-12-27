package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e a;
    private String b;
    private String c;

    public f(e eVar) {
        this.a = eVar;
        b(null);
        a(null);
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(String str) {
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (this.b == null || this.b.length() <= 0) {
            return;
        }
        context = this.a.a;
        PersonInfoActivity.a(context, this.b, this.c);
    }
}
