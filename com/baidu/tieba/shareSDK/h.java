package com.baidu.tieba.shareSDK;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ WriteShareActivity bPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.bPE = writeShareActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onClick(com.baidu.tbadk.core.dialog.e eVar) {
        InputMethodManager inputMethodManager;
        q qVar;
        InputMethodManager inputMethodManager2;
        q qVar2;
        WriteShareActivity writeShareActivity = this.bPE;
        inputMethodManager = this.bPE.mInputManager;
        qVar = this.bPE.bPq;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, qVar.adh());
        WriteShareActivity writeShareActivity2 = this.bPE;
        inputMethodManager2 = this.bPE.mInputManager;
        qVar2 = this.bPE.bPq;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, qVar2.adi());
        this.bPE.ada();
        eVar.dismiss();
    }
}
