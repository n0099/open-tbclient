package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ VcodeActivity gcb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VcodeActivity vcodeActivity) {
        this.gcb = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.gcb;
        inputMethodManager = this.gcb.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.gcb.eFX);
        this.gcb.GN();
        bVar = this.gcb.gbX;
        if (bVar != null) {
            bVar4 = this.gcb.gbX;
            bVar4.cancel();
        }
        this.gcb.gbX = new VcodeActivity.b(this.gcb.gbW);
        bVar2 = this.gcb.gbX;
        bVar2.setPriority(3);
        bVar3 = this.gcb.gbX;
        bVar3.execute(0);
    }
}
