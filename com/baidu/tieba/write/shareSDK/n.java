package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dNm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.dNm = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        InputMethodManager inputMethodManager;
        o oVar2;
        oVar = this.dNm.dMW;
        oVar.asU().requestFocus();
        WriteShareActivity writeShareActivity = this.dNm;
        inputMethodManager = this.dNm.mInputManager;
        oVar2 = this.dNm.dMW;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar2.asU());
    }
}
