package com.baidu.tieba.pb.image;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
final class z implements View.OnClickListener {
    final /* synthetic */ y a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, String str, String str2) {
        this.a = yVar;
        this.b = str;
        this.c = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        context = this.a.c;
        a.a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(context, String.valueOf(this.b), this.c)));
    }
}
