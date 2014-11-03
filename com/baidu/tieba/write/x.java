package com.baidu.tieba.write;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ VcodeActivity bTG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(VcodeActivity vcodeActivity) {
        this.bTG = vcodeActivity;
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
        VcodeActivity vcodeActivity = this.bTG;
        inputMethodManager = this.bTG.mInputManager;
        editText = this.bTG.bCl;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.bTG;
        VcodeActivity vcodeActivity3 = this.bTG;
        String string = this.bTG.getString(com.baidu.tieba.y.sending);
        onCancelListener = this.bTG.bCv;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(vcodeActivity3, "", string, true, false, onCancelListener);
        progressDialog = this.bTG.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        abVar = this.bTG.bTE;
        if (abVar != null) {
            abVar4 = this.bTG.bTE;
            abVar4.cancel();
        }
        VcodeActivity vcodeActivity4 = this.bTG;
        VcodeActivity vcodeActivity5 = this.bTG;
        writeData = this.bTG.bTq;
        vcodeActivity4.bTE = new ab(vcodeActivity5, writeData);
        abVar2 = this.bTG.bTE;
        abVar2.setPriority(3);
        abVar3 = this.bTG.bTE;
        abVar3.execute(0);
    }
}
