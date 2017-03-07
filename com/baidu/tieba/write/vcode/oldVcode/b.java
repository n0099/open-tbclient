package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fNi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VcodeActivity vcodeActivity) {
        this.fNi = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.fNi;
        inputMethodManager = this.fNi.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.fNi.mEdit);
        this.fNi.showDialog();
        bVar = this.fNi.fNg;
        if (bVar != null) {
            bVar4 = this.fNi.fNg;
            bVar4.cancel();
        }
        this.fNi.fNg = new VcodeActivity.b(this.fNi.fNf);
        bVar2 = this.fNi.fNg;
        bVar2.setPriority(3);
        bVar3 = this.fNi.fNg;
        bVar3.execute(0);
    }
}
