package com.baidu.tieba.shareSDK;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class g implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ WriteShareActivity bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.bJF = writeShareActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onClick(com.baidu.tbadk.core.dialog.e eVar) {
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
        eVar.dismiss();
    }
}
