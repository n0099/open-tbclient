package com.baidu.tieba.write.write;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.i;
import com.baidu.tieba.write.write.VcodeActivity;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ VcodeActivity cTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VcodeActivity vcodeActivity) {
        this.cTX = vcodeActivity;
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
        VcodeActivity vcodeActivity = this.cTX;
        inputMethodManager = this.cTX.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.cTX.mEdit);
        VcodeActivity vcodeActivity2 = this.cTX;
        Activity pageActivity = this.cTX.getPageContext().getPageActivity();
        String string = this.cTX.getPageContext().getString(i.C0057i.sending);
        onCancelListener = this.cTX.cjo;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.cTX.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        bVar = this.cTX.cTV;
        if (bVar != null) {
            bVar4 = this.cTX.cTV;
            bVar4.cancel();
        }
        this.cTX.cTV = new VcodeActivity.b(this.cTX.cTH);
        bVar2 = this.cTX.cTV;
        bVar2.setPriority(3);
        bVar3 = this.cTX.cTV;
        bVar3.execute(0);
    }
}
