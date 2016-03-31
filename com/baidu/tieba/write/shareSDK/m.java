package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity eJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.eJm = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.eJm;
        inputMethodManager = this.eJm.mInputManager;
        oVar = this.eJm.eIW;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.aZZ());
        WriteShareActivity writeShareActivity2 = this.eJm;
        inputMethodManager2 = this.eJm.mInputManager;
        oVar2 = this.eJm.eIW;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.aII());
        this.eJm.aZS();
    }
}
