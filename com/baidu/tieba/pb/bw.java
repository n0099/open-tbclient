package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnClickListener {
    final /* synthetic */ bv a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar) {
        this.a = bvVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            context = this.a.a;
            com.baidu.tieba.c.ah.c(context, (String) view.getTag());
        }
    }
}
