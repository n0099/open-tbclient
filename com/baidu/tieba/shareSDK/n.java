package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity bNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.bNV = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        InputMethodManager inputMethodManager;
        q qVar2;
        qVar = this.bNV.bNH;
        qVar.acJ().requestFocus();
        WriteShareActivity writeShareActivity = this.bNV;
        inputMethodManager = this.bNV.mInputManager;
        qVar2 = this.bNV.bNH;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar2.acJ());
    }
}
