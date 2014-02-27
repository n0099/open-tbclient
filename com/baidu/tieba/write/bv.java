package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
final class bv implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.a = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        z zVar;
        zVar = this.a.d;
        zVar.a(Integer.parseInt(view.getTag().toString()));
    }
}
