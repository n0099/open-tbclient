package com.baidu.tieba.write;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ VcodeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(VcodeActivity vcodeActivity) {
        this.a = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        DialogInterface.OnCancelListener onCancelListener;
        ProgressDialog progressDialog;
        ao aoVar;
        WriteData writeData;
        ao aoVar2;
        ao aoVar3;
        ao aoVar4;
        VcodeActivity vcodeActivity = this.a;
        inputMethodManager = this.a.i;
        editText = this.a.e;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.a;
        VcodeActivity vcodeActivity3 = this.a;
        String string = this.a.getString(R.string.sending);
        onCancelListener = this.a.j;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(vcodeActivity3, "", string, true, false, onCancelListener);
        progressDialog = this.a.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        aoVar = this.a.g;
        if (aoVar != null) {
            aoVar4 = this.a.g;
            aoVar4.cancel();
        }
        VcodeActivity vcodeActivity4 = this.a;
        VcodeActivity vcodeActivity5 = this.a;
        writeData = this.a.b;
        vcodeActivity4.g = new ao(vcodeActivity5, writeData);
        aoVar2 = this.a.g;
        aoVar2.setPriority(3);
        aoVar3 = this.a.g;
        aoVar3.execute(0);
    }
}
