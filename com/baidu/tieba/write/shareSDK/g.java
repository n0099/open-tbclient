package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class g implements e.b {
    final /* synthetic */ WriteShareActivity epq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.epq = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.epq;
        inputMethodManager = this.epq.mInputManager;
        oVar = this.epq.epa;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.aTz());
        WriteShareActivity writeShareActivity2 = this.epq;
        inputMethodManager2 = this.epq.mInputManager;
        oVar2 = this.epq.epa;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.aAU());
        this.epq.aTs();
        eVar.dismiss();
    }
}
