package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.write.VcodeActivity;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ VcodeActivity eMh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(VcodeActivity vcodeActivity) {
        this.eMh = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.eMh;
        inputMethodManager = this.eMh.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.eMh.dsS);
        this.eMh.Hl();
        bVar = this.eMh.eMd;
        if (bVar != null) {
            bVar4 = this.eMh.eMd;
            bVar4.cancel();
        }
        this.eMh.eMd = new VcodeActivity.b(this.eMh.eMc);
        bVar2 = this.eMh.eMd;
        bVar2.setPriority(3);
        bVar3 = this.eMh.eMd;
        bVar3.execute(0);
    }
}
