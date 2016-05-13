package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity fac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.fac = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.fac;
        inputMethodManager = this.fac.mInputManager;
        oVar = this.fac.eZM;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.bcs());
        WriteShareActivity writeShareActivity2 = this.fac;
        inputMethodManager2 = this.fac.mInputManager;
        oVar2 = this.fac.eZM;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.aIZ());
        this.fac.bcl();
    }
}
