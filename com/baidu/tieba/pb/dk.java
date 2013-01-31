package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
class dk implements View.OnClickListener {
    final /* synthetic */ dh a;
    private String b;
    private String c;

    public dk(dh dhVar) {
        this.a = dhVar;
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
