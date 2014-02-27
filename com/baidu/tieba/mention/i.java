package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.cm;
/* loaded from: classes.dex */
final class i implements View.OnClickListener {
    final /* synthetic */ h a;
    private String b = null;
    private String c = null;

    public i(h hVar) {
        this.a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        if (this.b != null && this.b.length() > 0) {
            context = this.a.a;
            cm.a(context, this.b, this.c);
        }
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void b(String str) {
        this.b = str;
    }
}
