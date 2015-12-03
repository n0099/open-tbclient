package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dNm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.dNm = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.dNm;
        inputMethodManager = this.dNm.mInputManager;
        oVar = this.dNm.dMW;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.aIu());
        WriteShareActivity writeShareActivity2 = this.dNm;
        inputMethodManager2 = this.dNm.mInputManager;
        oVar2 = this.dNm.dMW;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.asU());
        this.dNm.aIn();
    }
}
