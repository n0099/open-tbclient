package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.write.write.VcodeActivity;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ VcodeActivity esx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VcodeActivity vcodeActivity) {
        this.esx = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.esx;
        inputMethodManager = this.esx.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.esx.cYq);
        this.esx.Gp();
        bVar = this.esx.esv;
        if (bVar != null) {
            bVar4 = this.esx.esv;
            bVar4.cancel();
        }
        this.esx.esv = new VcodeActivity.b(this.esx.esg);
        bVar2 = this.esx.esv;
        bVar2.setPriority(3);
        bVar3 = this.esx.esv;
        bVar3.execute(0);
    }
}
