package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    final /* synthetic */ VcodeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(VcodeActivity vcodeActivity) {
        this.a = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
