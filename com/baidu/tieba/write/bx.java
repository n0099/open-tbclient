package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
final class bx implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.a = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WriteMultiImgsActivity.b(this.a);
    }
}
