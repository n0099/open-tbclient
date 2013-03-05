package com.baidu.tieba.nearby;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ af a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.a = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            context = this.a.a;
            com.baidu.tieba.c.ai.c(context, (String) view.getTag());
        }
    }
}
