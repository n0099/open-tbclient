package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.write.VcodeActivity;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fcV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(VcodeActivity vcodeActivity) {
        this.fcV = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.fcV;
        inputMethodManager = this.fcV.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.fcV.dwo);
        this.fcV.Fi();
        bVar = this.fcV.fcR;
        if (bVar != null) {
            bVar4 = this.fcV.fcR;
            bVar4.cancel();
        }
        this.fcV.fcR = new VcodeActivity.b(this.fcV.fcQ);
        bVar2 = this.fcV.fcR;
        bVar2.setPriority(3);
        bVar3 = this.fcV.fcR;
        bVar3.execute(0);
    }
}
