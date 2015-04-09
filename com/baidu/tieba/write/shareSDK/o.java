package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cwd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(WriteShareActivity writeShareActivity) {
        this.cwd = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        InputMethodManager inputMethodManager;
        q qVar2;
        qVar = this.cwd.cvO;
        qVar.aqS().requestFocus();
        WriteShareActivity writeShareActivity = this.cwd;
        inputMethodManager = this.cwd.mInputManager;
        qVar2 = this.cwd.cvO;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar2.aqS());
    }
}
