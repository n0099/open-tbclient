package com.baidu.tieba.write.write;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.n;
import com.baidu.tieba.write.write.VcodeActivity;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ VcodeActivity dQg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VcodeActivity vcodeActivity) {
        this.dQg = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        DialogInterface.OnCancelListener onCancelListener;
        ProgressDialog progressDialog;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.dQg;
        inputMethodManager = this.dQg.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.dQg.mEdit);
        VcodeActivity vcodeActivity2 = this.dQg;
        Activity pageActivity = this.dQg.getPageContext().getPageActivity();
        String string = this.dQg.getPageContext().getString(n.i.sending);
        onCancelListener = this.dQg.cKN;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.dQg.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        bVar = this.dQg.dQe;
        if (bVar != null) {
            bVar4 = this.dQg.dQe;
            bVar4.cancel();
        }
        this.dQg.dQe = new VcodeActivity.b(this.dQg.dPP);
        bVar2 = this.dQg.dQe;
        bVar2.setPriority(3);
        bVar3 = this.dQg.dQe;
        bVar3.execute(0);
    }
}
