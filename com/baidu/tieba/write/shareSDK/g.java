package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class g implements e.b {
    final /* synthetic */ WriteShareActivity dNm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.dNm = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.dNm;
        inputMethodManager = this.dNm.mInputManager;
        oVar = this.dNm.dMW;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.aIu());
        WriteShareActivity writeShareActivity2 = this.dNm;
        inputMethodManager2 = this.dNm.mInputManager;
        oVar2 = this.dNm.dMW;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.asU());
        this.dNm.aIn();
        eVar.dismiss();
    }
}
