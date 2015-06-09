package com.baidu.tieba.write.write;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ VcodeActivity cCi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(VcodeActivity vcodeActivity) {
        this.cCi = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        DialogInterface.OnCancelListener onCancelListener;
        ProgressDialog progressDialog;
        ah ahVar;
        WriteData writeData;
        ah ahVar2;
        ah ahVar3;
        ah ahVar4;
        VcodeActivity vcodeActivity = this.cCi;
        inputMethodManager = this.cCi.mInputManager;
        editText = this.cCi.mEdit;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.cCi;
        Activity pageActivity = this.cCi.getPageContext().getPageActivity();
        String string = this.cCi.getPageContext().getString(com.baidu.tieba.t.sending);
        onCancelListener = this.cCi.bSJ;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.cCi.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        ahVar = this.cCi.cCg;
        if (ahVar != null) {
            ahVar4 = this.cCi.cCg;
            ahVar4.cancel();
        }
        VcodeActivity vcodeActivity3 = this.cCi;
        VcodeActivity vcodeActivity4 = this.cCi;
        writeData = this.cCi.cBS;
        vcodeActivity3.cCg = new ah(vcodeActivity4, writeData);
        ahVar2 = this.cCi.cCg;
        ahVar2.setPriority(3);
        ahVar3 = this.cCi.cCg;
        ahVar3.execute(0);
    }
}
