package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
final class i implements View.OnClickListener {
    final /* synthetic */ g a;
    private String b = null;
    private String c = null;

    public i(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        if (this.b != null && this.b.length() > 0) {
            com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
            context = this.a.a;
            a.a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(context, this.b, this.c)));
        }
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void b(String str) {
        this.b = str;
    }
}
