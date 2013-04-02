package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
class dr implements View.OnClickListener {
    final /* synthetic */ Cdo a;
    private String b;
    private String c;

    public dr(Cdo cdo) {
        this.a = cdo;
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
