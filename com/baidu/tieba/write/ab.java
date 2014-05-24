package com.baidu.tieba.write;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ VcodeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(VcodeActivity vcodeActivity) {
        this.a = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        DialogInterface.OnCancelListener onCancelListener;
        ProgressDialog progressDialog;
        af afVar;
        WriteData writeData;
        af afVar2;
        af afVar3;
        af afVar4;
        VcodeActivity vcodeActivity = this.a;
        inputMethodManager = this.a.i;
        editText = this.a.e;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.a;
        VcodeActivity vcodeActivity3 = this.a;
        String string = this.a.getString(com.baidu.tieba.y.sending);
        onCancelListener = this.a.j;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(vcodeActivity3, "", string, true, false, onCancelListener);
        progressDialog = this.a.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        afVar = this.a.g;
        if (afVar != null) {
            afVar4 = this.a.g;
            afVar4.cancel();
        }
        VcodeActivity vcodeActivity4 = this.a;
        VcodeActivity vcodeActivity5 = this.a;
        writeData = this.a.b;
        vcodeActivity4.g = new af(vcodeActivity5, writeData);
        afVar2 = this.a.g;
        afVar2.setPriority(3);
        afVar3 = this.a.g;
        afVar3.execute(0);
    }
}
