package com.baidu.tieba.write.shareSDK;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class g implements e.b {
    final /* synthetic */ WriteShareActivity fac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteShareActivity writeShareActivity) {
        this.fac = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        InputMethodManager inputMethodManager;
        o oVar;
        InputMethodManager inputMethodManager2;
        o oVar2;
        WriteShareActivity writeShareActivity = this.fac;
        inputMethodManager = this.fac.mInputManager;
        oVar = this.fac.eZM;
        writeShareActivity.HidenSoftKeyPad(inputMethodManager, oVar.bcs());
        WriteShareActivity writeShareActivity2 = this.fac;
        inputMethodManager2 = this.fac.mInputManager;
        oVar2 = this.fac.eZM;
        writeShareActivity2.HidenSoftKeyPad(inputMethodManager2, oVar2.aIZ());
        this.fac.bcl();
        eVar.dismiss();
    }
}
