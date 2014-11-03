package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.bJF = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        InputMethodManager inputMethodManager;
        p pVar2;
        pVar = this.bJF.bJs;
        pVar.aco().requestFocus();
        WriteShareActivity writeShareActivity = this.bJF;
        inputMethodManager = this.bJF.mInputManager;
        pVar2 = this.bJF.bJs;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, pVar2.aco());
    }
}
