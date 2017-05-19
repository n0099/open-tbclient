package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fPl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(VcodeActivity vcodeActivity) {
        this.fPl = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fPl.finish();
    }
}
