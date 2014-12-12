package com.baidu.tieba.write;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ VcodeActivity ceN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(VcodeActivity vcodeActivity) {
        this.ceN = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        DialogInterface.OnCancelListener onCancelListener;
        ProgressDialog progressDialog;
        ab abVar;
        WriteData writeData;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        VcodeActivity vcodeActivity = this.ceN;
        inputMethodManager = this.ceN.mInputManager;
        editText = this.ceN.mEdit;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.ceN;
        Activity pageActivity = this.ceN.getPageContext().getPageActivity();
        String string = this.ceN.getPageContext().getString(com.baidu.tieba.z.sending);
        onCancelListener = this.ceN.bFV;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.ceN.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        abVar = this.ceN.ceL;
        if (abVar != null) {
            abVar4 = this.ceN.ceL;
            abVar4.cancel();
        }
        VcodeActivity vcodeActivity3 = this.ceN;
        VcodeActivity vcodeActivity4 = this.ceN;
        writeData = this.ceN.cex;
        vcodeActivity3.ceL = new ab(vcodeActivity4, writeData);
        abVar2 = this.ceN.ceL;
        abVar2.setPriority(3);
        abVar3 = this.ceN.ceL;
        abVar3.execute(0);
    }
}
