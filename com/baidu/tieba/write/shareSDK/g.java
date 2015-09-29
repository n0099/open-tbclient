package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class g implements e.b {
    final /* synthetic */ WriteShareActivity dlY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.dlY = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.dlY;
        inputMethodManager = this.dlY.mInputManager;
        oVar = this.dlY.dlI;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.aCb());
        WriteShareActivity writeShareActivity2 = this.dlY;
        inputMethodManager2 = this.dlY.mInputManager;
        oVar2 = this.dlY.dlI;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.amS());
        this.dlY.aBU();
        eVar.dismiss();
    }
}
