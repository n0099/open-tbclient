package com.baidu.tieba.write;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ VcodeActivity bTr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(VcodeActivity vcodeActivity) {
        this.bTr = vcodeActivity;
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
        VcodeActivity vcodeActivity = this.bTr;
        inputMethodManager = this.bTr.mInputManager;
        editText = this.bTr.bBX;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.bTr;
        VcodeActivity vcodeActivity3 = this.bTr;
        String string = this.bTr.getString(com.baidu.tieba.y.sending);
        onCancelListener = this.bTr.bCh;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(vcodeActivity3, "", string, true, false, onCancelListener);
        progressDialog = this.bTr.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        abVar = this.bTr.bTp;
        if (abVar != null) {
            abVar4 = this.bTr.bTp;
            abVar4.cancel();
        }
        VcodeActivity vcodeActivity4 = this.bTr;
        VcodeActivity vcodeActivity5 = this.bTr;
        writeData = this.bTr.bTb;
        vcodeActivity4.bTp = new ab(vcodeActivity5, writeData);
        abVar2 = this.bTr.bTp;
        abVar2.setPriority(3);
        abVar3 = this.bTr.bTp;
        abVar3.execute(0);
    }
}
