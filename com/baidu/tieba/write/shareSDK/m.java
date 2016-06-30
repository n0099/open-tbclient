package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity fFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.fFg = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.fFg;
        inputMethodManager = this.fFg.mInputManager;
        oVar = this.fFg.fEQ;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.bkN());
        WriteShareActivity writeShareActivity2 = this.fFg;
        inputMethodManager2 = this.fFg.mInputManager;
        oVar2 = this.fFg.fEQ;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.aRU());
        this.fFg.bkG();
    }
}
