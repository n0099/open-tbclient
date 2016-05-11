package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity fad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.fad = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        InputMethodManager inputMethodManager;
        o oVar2;
        oVar = this.fad.eZN;
        oVar.aIW().requestFocus();
        WriteShareActivity writeShareActivity = this.fad;
        inputMethodManager = this.fad.mInputManager;
        oVar2 = this.fad.eZN;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar2.aIW());
    }
}
