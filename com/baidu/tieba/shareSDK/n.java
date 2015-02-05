package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity bPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.bPE = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        InputMethodManager inputMethodManager;
        q qVar2;
        qVar = this.bPE.bPq;
        qVar.adi().requestFocus();
        WriteShareActivity writeShareActivity = this.bPE;
        inputMethodManager = this.bPE.mInputManager;
        qVar2 = this.bPE.bPq;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar2.adi());
    }
}
