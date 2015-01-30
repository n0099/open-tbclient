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
    final /* synthetic */ VcodeActivity cgm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(VcodeActivity vcodeActivity) {
        this.cgm = vcodeActivity;
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
        VcodeActivity vcodeActivity = this.cgm;
        inputMethodManager = this.cgm.mInputManager;
        editText = this.cgm.mEdit;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.cgm;
        Activity pageActivity = this.cgm.getPageContext().getPageActivity();
        String string = this.cgm.getPageContext().getString(com.baidu.tieba.z.sending);
        onCancelListener = this.cgm.bHG;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.cgm.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        abVar = this.cgm.cgk;
        if (abVar != null) {
            abVar4 = this.cgm.cgk;
            abVar4.cancel();
        }
        VcodeActivity vcodeActivity3 = this.cgm;
        VcodeActivity vcodeActivity4 = this.cgm;
        writeData = this.cgm.cfW;
        vcodeActivity3.cgk = new ab(vcodeActivity4, writeData);
        abVar2 = this.cgm.cgk;
        abVar2.setPriority(3);
        abVar3 = this.cgm.cgk;
        abVar3.execute(0);
    }
}
