package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
final class bd implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.f();
    }
}
