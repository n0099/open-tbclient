package com.baidu.tieba.shareSDK;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ WriteShareActivity bJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WriteShareActivity writeShareActivity) {
        this.bJq = writeShareActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onClick(com.baidu.tbadk.core.dialog.e eVar) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.bJq;
        inputMethodManager = this.bJq.mInputManager;
        oVar = this.bJq.bJe;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.ack());
        WriteShareActivity writeShareActivity2 = this.bJq;
        inputMethodManager2 = this.bJq.mInputManager;
        oVar2 = this.bJq.bJe;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.acl());
        this.bJq.acd();
        eVar.dismiss();
    }
}
