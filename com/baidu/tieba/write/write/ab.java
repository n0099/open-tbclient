package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ VcodeActivity cxw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(VcodeActivity vcodeActivity) {
        this.cxw = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cxw.finish();
    }
}
