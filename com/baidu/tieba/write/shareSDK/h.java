package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.write.view.i {
    final /* synthetic */ WriteShareActivity cAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.cAt = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.i
    public void a(com.baidu.tieba.write.view.f fVar) {
        InputMethodManager inputMethodManager;
        q qVar;
        InputMethodManager inputMethodManager2;
        q qVar2;
        WriteShareActivity writeShareActivity = this.cAt;
        inputMethodManager = this.cAt.mInputManager;
        qVar = this.cAt.cAe;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, qVar.asH());
        WriteShareActivity writeShareActivity2 = this.cAt;
        inputMethodManager2 = this.cAt.mInputManager;
        qVar2 = this.cAt.cAe;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, qVar2.asI());
        this.cAt.asA();
        fVar.dismiss();
    }
}
