package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity daW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteShareActivity writeShareActivity) {
        this.daW = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        InputMethodManager inputMethodManager;
        o oVar2;
        oVar = this.daW.daG;
        oVar.akL().requestFocus();
        WriteShareActivity writeShareActivity = this.daW;
        inputMethodManager = this.daW.mInputManager;
        oVar2 = this.daW.daG;
        writeShareActivity.ShowSoftKeyPad(inputMethodManager, oVar2.akL());
    }
}
