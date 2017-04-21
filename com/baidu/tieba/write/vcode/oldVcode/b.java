package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fRn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VcodeActivity vcodeActivity) {
        this.fRn = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.fRn;
        inputMethodManager = this.fRn.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.fRn.mEdit);
        this.fRn.showDialog();
        bVar = this.fRn.fRl;
        if (bVar != null) {
            bVar4 = this.fRn.fRl;
            bVar4.cancel();
        }
        this.fRn.fRl = new VcodeActivity.b(this.fRn.fRk);
        bVar2 = this.fRn.fRl;
        bVar2.setPriority(3);
        bVar3 = this.fRn.fRl;
        bVar3.execute(0);
    }
}
