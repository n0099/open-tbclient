package com.baidu.tieba.shareSDK;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ WriteShareActivity bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.bPF = writeShareActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onClick(com.baidu.tbadk.core.dialog.e eVar) {
        InputMethodManager inputMethodManager;
        q qVar;
        InputMethodManager inputMethodManager2;
        q qVar2;
        WriteShareActivity writeShareActivity = this.bPF;
        inputMethodManager = this.bPF.mInputManager;
        qVar = this.bPF.bPr;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, qVar.adm());
        WriteShareActivity writeShareActivity2 = this.bPF;
        inputMethodManager2 = this.bPF.mInputManager;
        qVar2 = this.bPF.bPr;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, qVar2.adn());
        this.bPF.adf();
        eVar.dismiss();
    }
}
