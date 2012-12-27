package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    final /* synthetic */ bt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bt btVar) {
        this.a = btVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (view.getTag() == null || !(view.getTag() instanceof String)) {
            return;
        }
        context = this.a.a;
        com.baidu.tieba.c.ag.c(context, (String) view.getTag());
    }
}
