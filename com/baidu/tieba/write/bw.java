package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.a = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aaVar = this.a.d;
        aaVar.a(Integer.parseInt(view.getTag().toString()));
    }
}
