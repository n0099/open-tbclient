package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class g implements e.b {
    final /* synthetic */ WriteShareActivity cSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.cSj = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.cSj;
        inputMethodManager = this.cSj.mInputManager;
        oVar = this.cSj.cRT;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.auy());
        WriteShareActivity writeShareActivity2 = this.cSj;
        inputMethodManager2 = this.cSj.mInputManager;
        oVar2 = this.cSj.cRT;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.auz());
        this.cSj.aur();
        eVar.dismiss();
    }
}
