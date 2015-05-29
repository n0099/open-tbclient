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
    final /* synthetic */ VcodeActivity cCh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(VcodeActivity vcodeActivity) {
        this.cCh = vcodeActivity;
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
        VcodeActivity vcodeActivity = this.cCh;
        inputMethodManager = this.cCh.mInputManager;
        editText = this.cCh.mEdit;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.cCh;
        Activity pageActivity = this.cCh.getPageContext().getPageActivity();
        String string = this.cCh.getPageContext().getString(com.baidu.tieba.t.sending);
        onCancelListener = this.cCh.bSI;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.cCh.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        ahVar = this.cCh.cCf;
        if (ahVar != null) {
            ahVar4 = this.cCh.cCf;
            ahVar4.cancel();
        }
        VcodeActivity vcodeActivity3 = this.cCh;
        VcodeActivity vcodeActivity4 = this.cCh;
        writeData = this.cCh.cBR;
        vcodeActivity3.cCf = new ah(vcodeActivity4, writeData);
        ahVar2 = this.cCh.cCf;
        ahVar2.setPriority(3);
        ahVar3 = this.cCh.cCf;
        ahVar3.execute(0);
    }
}
