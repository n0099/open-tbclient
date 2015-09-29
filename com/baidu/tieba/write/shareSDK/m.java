package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dlY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.dlY = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.dlY;
        inputMethodManager = this.dlY.mInputManager;
        oVar = this.dlY.dlI;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.aCb());
        WriteShareActivity writeShareActivity2 = this.dlY;
        inputMethodManager2 = this.dlY.mInputManager;
        oVar2 = this.dlY.dlI;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.amS());
        this.dlY.aBU();
    }
}
