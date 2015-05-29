package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ VcodeActivity cCh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(VcodeActivity vcodeActivity) {
        this.cCh = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cCh.finish();
    }
}
