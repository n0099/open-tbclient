package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
final class ai implements View.OnClickListener {
    final /* synthetic */ VcodeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(VcodeActivity vcodeActivity) {
        this.a = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
