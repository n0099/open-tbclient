package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.cSj = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        InputMethodManager inputMethodManager;
        o oVar2;
        oVar = this.cSj.cRT;
        oVar.auz().requestFocus();
        WriteShareActivity writeShareActivity = this.cSj;
        inputMethodManager = this.cSj.mInputManager;
        oVar2 = this.cSj.cRT;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar2.auz());
    }
}
