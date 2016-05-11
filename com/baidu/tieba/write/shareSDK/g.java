package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class g implements e.b {
    final /* synthetic */ WriteShareActivity fad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.fad = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.fad;
        inputMethodManager = this.fad.mInputManager;
        oVar = this.fad.eZN;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.bcl());
        WriteShareActivity writeShareActivity2 = this.fad;
        inputMethodManager2 = this.fad.mInputManager;
        oVar2 = this.fad.eZN;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.aIW());
        this.fad.bce();
        eVar.dismiss();
    }
}
