package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ VcodeActivity bTG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(VcodeActivity vcodeActivity) {
        this.bTG = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bTG.finish();
    }
}
