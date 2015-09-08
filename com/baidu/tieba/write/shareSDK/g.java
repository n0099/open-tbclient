package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class g implements e.b {
    final /* synthetic */ WriteShareActivity daW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.daW = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.daW;
        inputMethodManager = this.daW.mInputManager;
        oVar = this.daW.daG;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.ayS());
        WriteShareActivity writeShareActivity2 = this.daW;
        inputMethodManager2 = this.daW.mInputManager;
        oVar2 = this.daW.daG;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.akL());
        this.daW.ayL();
        eVar.dismiss();
    }
}
