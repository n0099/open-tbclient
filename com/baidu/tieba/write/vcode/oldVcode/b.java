package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fFV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VcodeActivity vcodeActivity) {
        this.fFV = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.fFV;
        inputMethodManager = this.fFV.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.fFV.eeG);
        this.fFV.Fs();
        bVar = this.fFV.fFR;
        if (bVar != null) {
            bVar4 = this.fFV.fFR;
            bVar4.cancel();
        }
        this.fFV.fFR = new VcodeActivity.b(this.fFV.fFQ);
        bVar2 = this.fFV.fFR;
        bVar2.setPriority(3);
        bVar3 = this.fFV.fFR;
        bVar3.execute(0);
    }
}
