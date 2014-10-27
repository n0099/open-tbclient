package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity bJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteShareActivity writeShareActivity) {
        this.bJq = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
    }
}
