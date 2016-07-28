package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VcodeActivity vcodeActivity) {
        this.fRW = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.fRW;
        inputMethodManager = this.fRW.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.fRW.ezv);
        this.fRW.Ft();
        bVar = this.fRW.fRS;
        if (bVar != null) {
            bVar4 = this.fRW.fRS;
            bVar4.cancel();
        }
        this.fRW.fRS = new VcodeActivity.b(this.fRW.fRR);
        bVar2 = this.fRW.fRS;
        bVar2.setPriority(3);
        bVar3 = this.fRW.fRS;
        bVar3.execute(0);
    }
}
