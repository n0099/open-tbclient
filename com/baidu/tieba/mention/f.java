package com.baidu.tieba.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a(view);
    }
}
