package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnClickListener {
    final /* synthetic */ cd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cd cdVar) {
        this.a = cdVar;
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
