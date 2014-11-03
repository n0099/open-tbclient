package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.bJF = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        p pVar;
        InputMethodManager inputMethodManager2;
        p pVar2;
        WriteShareActivity writeShareActivity = this.bJF;
        inputMethodManager = this.bJF.mInputManager;
        pVar = this.bJF.bJs;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, pVar.acn());
        WriteShareActivity writeShareActivity2 = this.bJF;
        inputMethodManager2 = this.bJF.mInputManager;
        pVar2 = this.bJF.bJs;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, pVar2.aco());
        this.bJF.acg();
    }
}
