package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.cm;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ h a;
    private String b;
    private String c;

    public i(h hVar) {
        this.a = hVar;
        b(null);
        a(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (this.b != null && this.b.length() > 0) {
            context = this.a.a;
            cm.a(context, this.b, this.c);
        }
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(String str) {
        this.b = str;
    }
}
