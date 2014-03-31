package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
final class bp implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.a = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        v vVar;
        vVar = this.a.d;
        vVar.a(Integer.parseInt(view.getTag().toString()));
    }
}
