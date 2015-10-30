package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dmy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.dmy = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        InputMethodManager inputMethodManager;
        o oVar2;
        oVar = this.dmy.dmi;
        oVar.amO().requestFocus();
        WriteShareActivity writeShareActivity = this.dmy;
        inputMethodManager = this.dmy.mInputManager;
        oVar2 = this.dmy.dmi;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar2.amO());
    }
}
