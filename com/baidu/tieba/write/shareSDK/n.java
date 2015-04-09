package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cwd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.cwd = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        q qVar;
        InputMethodManager inputMethodManager2;
        q qVar2;
        WriteShareActivity writeShareActivity = this.cwd;
        inputMethodManager = this.cwd.mInputManager;
        qVar = this.cwd.cvO;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, qVar.aqR());
        WriteShareActivity writeShareActivity2 = this.cwd;
        inputMethodManager2 = this.cwd.mInputManager;
        qVar2 = this.cwd.cvO;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, qVar2.aqS());
        this.cwd.aqK();
    }
}
