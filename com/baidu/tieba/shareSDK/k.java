package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity bJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.bJq = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        InputMethodManager inputMethodManager;
        o oVar2;
        oVar = this.bJq.bJe;
        oVar.acl().requestFocus();
        WriteShareActivity writeShareActivity = this.bJq;
        inputMethodManager = this.bJq.mInputManager;
        oVar2 = this.bJq.bJe;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar2.acl());
    }
}
