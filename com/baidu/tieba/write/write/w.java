package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.write.VcodeActivity;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fcU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(VcodeActivity vcodeActivity) {
        this.fcU = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.fcU;
        inputMethodManager = this.fcU.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.fcU.dwo);
        this.fcU.Fk();
        bVar = this.fcU.fcQ;
        if (bVar != null) {
            bVar4 = this.fcU.fcQ;
            bVar4.cancel();
        }
        this.fcU.fcQ = new VcodeActivity.b(this.fcU.fcP);
        bVar2 = this.fcU.fcQ;
        bVar2.setPriority(3);
        bVar3 = this.fcU.fcQ;
        bVar3.execute(0);
    }
}
