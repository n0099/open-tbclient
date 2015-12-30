package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class g implements e.b {
    final /* synthetic */ WriteShareActivity dUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.dUL = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.dUL;
        inputMethodManager = this.dUL.mInputManager;
        oVar = this.dUL.dUv;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.aKP());
        WriteShareActivity writeShareActivity2 = this.dUL;
        inputMethodManager2 = this.dUL.mInputManager;
        oVar2 = this.dUL.dUv;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.auG());
        this.dUL.aKI();
        eVar.dismiss();
    }
}
