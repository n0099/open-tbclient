package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ VcodeActivity gek;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VcodeActivity vcodeActivity) {
        this.gek = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.gek;
        inputMethodManager = this.gek.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.gek.eIb);
        this.gek.GM();
        bVar = this.gek.geg;
        if (bVar != null) {
            bVar4 = this.gek.geg;
            bVar4.cancel();
        }
        this.gek.geg = new VcodeActivity.b(this.gek.gef);
        bVar2 = this.gek.geg;
        bVar2.setPriority(3);
        bVar3 = this.gek.geg;
        bVar3.execute(0);
    }
}
