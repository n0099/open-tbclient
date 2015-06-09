package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(WriteShareActivity writeShareActivity) {
        this.cAu = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        InputMethodManager inputMethodManager;
        q qVar2;
        qVar = this.cAu.cAf;
        qVar.asJ().requestFocus();
        WriteShareActivity writeShareActivity = this.cAu;
        inputMethodManager = this.cAu.mInputManager;
        qVar2 = this.cAu.cAf;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar2.asJ());
    }
}
