package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.cSj = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.cSj;
        inputMethodManager = this.cSj.mInputManager;
        oVar = this.cSj.cRT;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.auy());
        WriteShareActivity writeShareActivity2 = this.cSj;
        inputMethodManager2 = this.cSj.mInputManager;
        oVar2 = this.cSj.cRT;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.auz());
        this.cSj.aur();
    }
}
