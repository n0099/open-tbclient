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
    final /* synthetic */ VcodeActivity cgl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(VcodeActivity vcodeActivity) {
        this.cgl = vcodeActivity;
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
        VcodeActivity vcodeActivity = this.cgl;
        inputMethodManager = this.cgl.mInputManager;
        editText = this.cgl.mEdit;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.cgl;
        Activity pageActivity = this.cgl.getPageContext().getPageActivity();
        String string = this.cgl.getPageContext().getString(com.baidu.tieba.z.sending);
        onCancelListener = this.cgl.bHF;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.cgl.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        abVar = this.cgl.cgj;
        if (abVar != null) {
            abVar4 = this.cgl.cgj;
            abVar4.cancel();
        }
        VcodeActivity vcodeActivity3 = this.cgl;
        VcodeActivity vcodeActivity4 = this.cgl;
        writeData = this.cgl.cfV;
        vcodeActivity3.cgj = new ab(vcodeActivity4, writeData);
        abVar2 = this.cgl.cgj;
        abVar2.setPriority(3);
        abVar3 = this.cgl.cgj;
        abVar3.execute(0);
    }
}
