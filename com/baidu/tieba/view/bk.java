package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnClickListener {
    final /* synthetic */ bj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar) {
        this.a = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        bj bjVar = this.a;
        i = this.a.q;
        bjVar.a(i);
    }
}
