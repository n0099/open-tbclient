package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.dog = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        InputMethodManager inputMethodManager;
        o oVar2;
        oVar = this.dog.dnQ;
        oVar.anu().requestFocus();
        WriteShareActivity writeShareActivity = this.dog;
        inputMethodManager = this.dog.mInputManager;
        oVar2 = this.dog.dnQ;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar2.anu());
    }
}
