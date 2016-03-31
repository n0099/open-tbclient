package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity eJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.eJm = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        InputMethodManager inputMethodManager;
        o oVar2;
        oVar = this.eJm.eIW;
        oVar.aII().requestFocus();
        WriteShareActivity writeShareActivity = this.eJm;
        inputMethodManager = this.eJm.mInputManager;
        oVar2 = this.eJm.eIW;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar2.aII());
    }
}
