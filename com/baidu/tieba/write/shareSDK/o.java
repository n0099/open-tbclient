package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(WriteShareActivity writeShareActivity) {
        this.cAt = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        InputMethodManager inputMethodManager;
        q qVar2;
        qVar = this.cAt.cAe;
        qVar.asI().requestFocus();
        WriteShareActivity writeShareActivity = this.cAt;
        inputMethodManager = this.cAt.mInputManager;
        qVar2 = this.cAt.cAe;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, qVar2.asI());
    }
}
