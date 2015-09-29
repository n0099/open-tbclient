package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dlY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.dlY = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        InputMethodManager inputMethodManager;
        o oVar2;
        oVar = this.dlY.dlI;
        oVar.amS().requestFocus();
        WriteShareActivity writeShareActivity = this.dlY;
        inputMethodManager = this.dlY.mInputManager;
        oVar2 = this.dlY.dlI;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar2.amS());
    }
}
