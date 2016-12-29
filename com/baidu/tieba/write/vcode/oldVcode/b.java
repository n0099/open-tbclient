package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fAr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VcodeActivity vcodeActivity) {
        this.fAr = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.fAr;
        inputMethodManager = this.fAr.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.fAr.erW);
        this.fAr.Gl();
        bVar = this.fAr.fAn;
        if (bVar != null) {
            bVar4 = this.fAr.fAn;
            bVar4.cancel();
        }
        this.fAr.fAn = new VcodeActivity.b(this.fAr.fAm);
        bVar2 = this.fAr.fAn;
        bVar2.setPriority(3);
        bVar3 = this.fAr.fAn;
        bVar3.execute(0);
    }
}
