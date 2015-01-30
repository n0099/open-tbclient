package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.bPF = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
    }
}
