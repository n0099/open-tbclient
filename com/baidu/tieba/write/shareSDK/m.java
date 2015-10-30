package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dmy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.dmy = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.dmy;
        inputMethodManager = this.dmy.mInputManager;
        oVar = this.dmy.dmi;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.aCh());
        WriteShareActivity writeShareActivity2 = this.dmy;
        inputMethodManager2 = this.dmy.mInputManager;
        oVar2 = this.dmy.dmi;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.amO());
        this.dmy.aCa();
    }
}
