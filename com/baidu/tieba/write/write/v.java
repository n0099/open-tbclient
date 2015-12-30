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
    final /* synthetic */ VcodeActivity dXE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VcodeActivity vcodeActivity) {
        this.dXE = vcodeActivity;
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
        VcodeActivity vcodeActivity = this.dXE;
        inputMethodManager = this.dXE.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.dXE.mEdit);
        VcodeActivity vcodeActivity2 = this.dXE;
        Activity pageActivity = this.dXE.getPageContext().getPageActivity();
        String string = this.dXE.getPageContext().getString(n.j.sending);
        onCancelListener = this.dXE.cPd;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.dXE.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        bVar = this.dXE.dXC;
        if (bVar != null) {
            bVar4 = this.dXE.dXC;
            bVar4.cancel();
        }
        this.dXE.dXC = new VcodeActivity.b(this.dXE.dXn);
        bVar2 = this.dXE.dXC;
        bVar2.setPriority(3);
        bVar3 = this.dXE.dXC;
        bVar3.execute(0);
    }
}
