package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity daW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.daW = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.daW;
        inputMethodManager = this.daW.mInputManager;
        oVar = this.daW.daG;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.ayS());
        WriteShareActivity writeShareActivity2 = this.daW;
        inputMethodManager2 = this.daW.mInputManager;
        oVar2 = this.daW.daG;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.akL());
        this.daW.ayL();
    }
}
