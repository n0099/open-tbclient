package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.cAt = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        q qVar;
        InputMethodManager inputMethodManager2;
        q qVar2;
        WriteShareActivity writeShareActivity = this.cAt;
        inputMethodManager = this.cAt.mInputManager;
        qVar = this.cAt.cAe;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, qVar.asH());
        WriteShareActivity writeShareActivity2 = this.cAt;
        inputMethodManager2 = this.cAt.mInputManager;
        qVar2 = this.cAt.cAe;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, qVar2.asI());
        this.cAt.asA();
    }
}
