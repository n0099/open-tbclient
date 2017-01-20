package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fIO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VcodeActivity vcodeActivity) {
        this.fIO = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.fIO;
        inputMethodManager = this.fIO.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.fIO.mEdit);
        this.fIO.showDialog();
        bVar = this.fIO.fIM;
        if (bVar != null) {
            bVar4 = this.fIO.fIM;
            bVar4.cancel();
        }
        this.fIO.fIM = new VcodeActivity.b(this.fIO.fIL);
        bVar2 = this.fIO.fIM;
        bVar2.setPriority(3);
        bVar3 = this.fIO.fIM;
        bVar3.execute(0);
    }
}
