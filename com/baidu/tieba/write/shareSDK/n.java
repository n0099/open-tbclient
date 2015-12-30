package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.dUL = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        InputMethodManager inputMethodManager;
        o oVar2;
        oVar = this.dUL.dUv;
        oVar.auG().requestFocus();
        WriteShareActivity writeShareActivity = this.dUL;
        inputMethodManager = this.dUL.mInputManager;
        oVar2 = this.dUL.dUv;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar2.auG());
    }
}
