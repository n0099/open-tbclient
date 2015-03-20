package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cvN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(WriteShareActivity writeShareActivity) {
        this.cvN = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        InputMethodManager inputMethodManager;
        q qVar2;
        qVar = this.cvN.cvy;
        qVar.aqD().requestFocus();
        WriteShareActivity writeShareActivity = this.cvN;
        inputMethodManager = this.cvN.mInputManager;
        qVar2 = this.cvN.cvy;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar2.aqD());
    }
}
