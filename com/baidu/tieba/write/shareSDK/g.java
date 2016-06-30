package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class g implements e.b {
    final /* synthetic */ WriteShareActivity fFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.fFg = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.fFg;
        inputMethodManager = this.fFg.mInputManager;
        oVar = this.fFg.fEQ;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.bkN());
        WriteShareActivity writeShareActivity2 = this.fFg;
        inputMethodManager2 = this.fFg.mInputManager;
        oVar2 = this.fFg.fEQ;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.aRU());
        this.fFg.bkG();
        eVar.dismiss();
    }
}
