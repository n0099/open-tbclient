package com.baidu.tieba.write.shareSDK;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity epq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.epq = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
    }
}
