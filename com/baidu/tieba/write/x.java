package com.baidu.tieba.write;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ VcodeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(VcodeActivity vcodeActivity) {
        this.a = vcodeActivity;
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
        VcodeActivity vcodeActivity = this.a;
        inputMethodManager = this.a.i;
        editText = this.a.e;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.a;
        VcodeActivity vcodeActivity3 = this.a;
        String string = this.a.getString(com.baidu.tieba.x.sending);
        onCancelListener = this.a.j;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(vcodeActivity3, "", string, true, false, onCancelListener);
        progressDialog = this.a.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        abVar = this.a.g;
        if (abVar != null) {
            abVar4 = this.a.g;
            abVar4.cancel();
        }
        VcodeActivity vcodeActivity4 = this.a;
        VcodeActivity vcodeActivity5 = this.a;
        writeData = this.a.b;
        vcodeActivity4.g = new ab(vcodeActivity5, writeData);
        abVar2 = this.a.g;
        abVar2.setPriority(3);
        abVar3 = this.a.g;
        abVar3.execute(0);
    }
}
