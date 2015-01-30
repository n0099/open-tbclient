package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.bPF = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        InputMethodManager inputMethodManager;
        q qVar2;
        qVar = this.bPF.bPr;
        qVar.adn().requestFocus();
        WriteShareActivity writeShareActivity = this.bPF;
        inputMethodManager = this.bPF.mInputManager;
        qVar2 = this.bPF.bPr;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar2.adn());
    }
}
