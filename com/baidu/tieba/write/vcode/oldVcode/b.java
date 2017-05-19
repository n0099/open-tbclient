package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fPl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VcodeActivity vcodeActivity) {
        this.fPl = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.fPl;
        inputMethodManager = this.fPl.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.fPl.mEdit);
        this.fPl.showDialog();
        bVar = this.fPl.fPj;
        if (bVar != null) {
            bVar4 = this.fPl.fPj;
            bVar4.cancel();
        }
        this.fPl.fPj = new VcodeActivity.b(this.fPl.fPi);
        bVar2 = this.fPl.fPj;
        bVar2.setPriority(3);
        bVar3 = this.fPl.fPj;
        bVar3.execute(0);
    }
}
