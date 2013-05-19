package com.baidu.tieba.nearby;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ ae a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.a = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            context = this.a.a;
            com.baidu.tieba.d.ag.c(context, (String) view.getTag());
        }
    }
}
