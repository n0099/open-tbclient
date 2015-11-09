package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.dog = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.dog;
        inputMethodManager = this.dog.mInputManager;
        oVar = this.dog.dnQ;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.aCX());
        WriteShareActivity writeShareActivity2 = this.dog;
        inputMethodManager2 = this.dog.mInputManager;
        oVar2 = this.dog.dnQ;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.anu());
        this.dog.aCQ();
    }
}
