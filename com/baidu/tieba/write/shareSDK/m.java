package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity fad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.fad = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.fad;
        inputMethodManager = this.fad.mInputManager;
        oVar = this.fad.eZN;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.bcl());
        WriteShareActivity writeShareActivity2 = this.fad;
        inputMethodManager2 = this.fad.mInputManager;
        oVar2 = this.fad.eZN;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.aIW());
        this.fad.bce();
    }
}
