package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity epq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.epq = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        InputMethodManager inputMethodManager;
        o oVar2;
        oVar = this.epq.epa;
        oVar.aAU().requestFocus();
        WriteShareActivity writeShareActivity = this.epq;
        inputMethodManager = this.epq.mInputManager;
        oVar2 = this.epq.epa;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar2.aAU());
    }
}
