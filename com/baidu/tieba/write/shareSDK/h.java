package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.write.view.i {
    final /* synthetic */ WriteShareActivity cwd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.cwd = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.i
    public void onClick(com.baidu.tieba.write.view.f fVar) {
        InputMethodManager inputMethodManager;
        q qVar;
        InputMethodManager inputMethodManager2;
        q qVar2;
        WriteShareActivity writeShareActivity = this.cwd;
        inputMethodManager = this.cwd.mInputManager;
        qVar = this.cwd.cvO;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, qVar.aqR());
        WriteShareActivity writeShareActivity2 = this.cwd;
        inputMethodManager2 = this.cwd.mInputManager;
        qVar2 = this.cwd.cvO;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, qVar2.aqS());
        this.cwd.aqK();
        fVar.dismiss();
    }
}
