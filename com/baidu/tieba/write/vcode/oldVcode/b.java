package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ VcodeActivity gih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VcodeActivity vcodeActivity) {
        this.gih = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.gih;
        inputMethodManager = this.gih.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.gih.mEdit);
        this.gih.showDialog();
        bVar = this.gih.gif;
        if (bVar != null) {
            bVar4 = this.gih.gif;
            bVar4.cancel();
        }
        this.gih.gif = new VcodeActivity.b(this.gih.gie);
        bVar2 = this.gih.gif;
        bVar2.setPriority(3);
        bVar3 = this.gih.gif;
        bVar3.execute(0);
    }
}
