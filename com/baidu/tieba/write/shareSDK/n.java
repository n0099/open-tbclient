package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity fFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.fFg = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        InputMethodManager inputMethodManager;
        o oVar2;
        oVar = this.fFg.fEQ;
        oVar.aRU().requestFocus();
        WriteShareActivity writeShareActivity = this.fFg;
        inputMethodManager = this.fFg.mInputManager;
        oVar2 = this.fFg.fEQ;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar2.aRU());
    }
}
