package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1330a;
    private String b;
    private String c;

    public g(f fVar) {
        this.f1330a = fVar;
        b(null);
        a(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (this.b != null && this.b.length() > 0) {
            context = this.f1330a.f1329a;
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
