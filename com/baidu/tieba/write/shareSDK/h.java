package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.write.view.i {
    final /* synthetic */ WriteShareActivity cvN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.cvN = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.i
    public void onClick(com.baidu.tieba.write.view.f fVar) {
        InputMethodManager inputMethodManager;
        q qVar;
        InputMethodManager inputMethodManager2;
        q qVar2;
        WriteShareActivity writeShareActivity = this.cvN;
        inputMethodManager = this.cvN.mInputManager;
        qVar = this.cvN.cvy;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, qVar.aqC());
        WriteShareActivity writeShareActivity2 = this.cvN;
        inputMethodManager2 = this.cvN.mInputManager;
        qVar2 = this.cvN.cvy;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, qVar2.aqD());
        this.cvN.aqv();
        fVar.dismiss();
    }
}
