package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cvN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.cvN = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        q qVar;
        InputMethodManager inputMethodManager2;
        q qVar2;
        WriteShareActivity writeShareActivity = this.cvN;
        inputMethodManager = this.cvN.mInputManager;
        qVar = this.cvN.cvy;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, qVar.aqC());
        WriteShareActivity writeShareActivity2 = this.cvN;
        inputMethodManager2 = this.cvN.mInputManager;
        qVar2 = this.cvN.cvy;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, qVar2.aqD());
        this.cvN.aqv();
    }
}
