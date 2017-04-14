package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fOR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VcodeActivity vcodeActivity) {
        this.fOR = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.fOR;
        inputMethodManager = this.fOR.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.fOR.mEdit);
        this.fOR.showDialog();
        bVar = this.fOR.fOP;
        if (bVar != null) {
            bVar4 = this.fOR.fOP;
            bVar4.cancel();
        }
        this.fOR.fOP = new VcodeActivity.b(this.fOR.fOO);
        bVar2 = this.fOR.fOP;
        bVar2.setPriority(3);
        bVar3 = this.fOR.fOP;
        bVar3.execute(0);
    }
}
