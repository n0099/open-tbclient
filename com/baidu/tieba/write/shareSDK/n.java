package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.cAu = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        q qVar;
        InputMethodManager inputMethodManager2;
        q qVar2;
        WriteShareActivity writeShareActivity = this.cAu;
        inputMethodManager = this.cAu.mInputManager;
        qVar = this.cAu.cAf;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, qVar.asI());
        WriteShareActivity writeShareActivity2 = this.cAu;
        inputMethodManager2 = this.cAu.mInputManager;
        qVar2 = this.cAu.cAf;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, qVar2.asJ());
        this.cAu.asB();
    }
}
