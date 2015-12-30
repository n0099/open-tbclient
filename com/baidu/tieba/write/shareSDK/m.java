package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.dUL = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.dUL;
        inputMethodManager = this.dUL.mInputManager;
        oVar = this.dUL.dUv;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.aKP());
        WriteShareActivity writeShareActivity2 = this.dUL;
        inputMethodManager2 = this.dUL.mInputManager;
        oVar2 = this.dUL.dUv;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.auG());
        this.dUL.aKI();
    }
}
