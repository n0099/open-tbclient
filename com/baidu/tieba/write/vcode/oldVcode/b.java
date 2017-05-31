package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VcodeActivity vcodeActivity) {
        this.fXh = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.fXh;
        inputMethodManager = this.fXh.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.fXh.mEdit);
        this.fXh.showDialog();
        bVar = this.fXh.fXf;
        if (bVar != null) {
            bVar4 = this.fXh.fXf;
            bVar4.cancel();
        }
        this.fXh.fXf = new VcodeActivity.b(this.fXh.fXe);
        bVar2 = this.fXh.fXf;
        bVar2.setPriority(3);
        bVar3 = this.fXh.fXf;
        bVar3.execute(0);
    }
}
