package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ VcodeActivity glO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VcodeActivity vcodeActivity) {
        this.glO = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.glO;
        inputMethodManager = this.glO.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.glO.eOA);
        this.glO.GP();
        bVar = this.glO.glK;
        if (bVar != null) {
            bVar4 = this.glO.glK;
            bVar4.cancel();
        }
        this.glO.glK = new VcodeActivity.b(this.glO.glJ);
        bVar2 = this.glO.glK;
        bVar2.setPriority(3);
        bVar3 = this.glO.glK;
        bVar3.execute(0);
    }
}
