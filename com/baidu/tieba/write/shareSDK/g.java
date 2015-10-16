package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class g implements e.b {
    final /* synthetic */ WriteShareActivity dmy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.dmy = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.dmy;
        inputMethodManager = this.dmy.mInputManager;
        oVar = this.dmy.dmi;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.aCl());
        WriteShareActivity writeShareActivity2 = this.dmy;
        inputMethodManager2 = this.dmy.mInputManager;
        oVar2 = this.dmy.dmi;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.amS());
        this.dmy.aCe();
        eVar.dismiss();
    }
}
