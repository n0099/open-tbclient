package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class g implements e.b {
    final /* synthetic */ WriteShareActivity eJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.eJm = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.eJm;
        inputMethodManager = this.eJm.mInputManager;
        oVar = this.eJm.eIW;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.aZZ());
        WriteShareActivity writeShareActivity2 = this.eJm;
        inputMethodManager2 = this.eJm.mInputManager;
        oVar2 = this.eJm.eIW;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.aII());
        this.eJm.aZS();
        eVar.dismiss();
    }
}
