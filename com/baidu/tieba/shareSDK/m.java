package com.baidu.tieba.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity bNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.bNV = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        q qVar;
        InputMethodManager inputMethodManager2;
        q qVar2;
        WriteShareActivity writeShareActivity = this.bNV;
        inputMethodManager = this.bNV.mInputManager;
        qVar = this.bNV.bNH;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, qVar.acI());
        WriteShareActivity writeShareActivity2 = this.bNV;
        inputMethodManager2 = this.bNV.mInputManager;
        qVar2 = this.bNV.bNH;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, qVar2.acJ());
        this.bNV.acB();
    }
}
