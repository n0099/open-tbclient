package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1295a;
    private String b;
    private String c;

    public f(e eVar) {
        this.f1295a = eVar;
        b(null);
        a(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (this.b != null && this.b.length() > 0) {
            context = this.f1295a.f1294a;
            PersonInfoActivity.a(context, this.b, this.c);
        }
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(String str) {
        this.b = str;
    }
}
