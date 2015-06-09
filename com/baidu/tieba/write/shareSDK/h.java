package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.write.view.i {
    final /* synthetic */ WriteShareActivity cAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.cAu = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.i
    public void a(com.baidu.tieba.write.view.f fVar) {
        InputMethodManager inputMethodManager;
        q qVar;
        InputMethodManager inputMethodManager2;
        q qVar2;
        WriteShareActivity writeShareActivity = this.cAu;
        inputMethodManager = this.cAu.mInputManager;
        qVar = this.cAu.cAf;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, qVar.asI());
        WriteShareActivity writeShareActivity2 = this.cAu;
        inputMethodManager2 = this.cAu.mInputManager;
        qVar2 = this.cAu.cAf;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, qVar2.asJ());
        this.cAu.asB();
        fVar.dismiss();
    }
}
