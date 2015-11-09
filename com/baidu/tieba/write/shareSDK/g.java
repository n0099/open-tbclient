package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class g implements e.b {
    final /* synthetic */ WriteShareActivity dog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.dog = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.dog;
        inputMethodManager = this.dog.mInputManager;
        oVar = this.dog.dnQ;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.aCX());
        WriteShareActivity writeShareActivity2 = this.dog;
        inputMethodManager2 = this.dog.mInputManager;
        oVar2 = this.dog.dnQ;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.anu());
        this.dog.aCQ();
        eVar.dismiss();
    }
}
