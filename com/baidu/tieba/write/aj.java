package com.baidu.tieba.write;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class aj implements View.OnClickListener {
    final /* synthetic */ VcodeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(VcodeActivity vcodeActivity) {
        this.a = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        DialogInterface.OnCancelListener onCancelListener;
        ProgressDialog progressDialog;
        an anVar;
        WriteData writeData;
        an anVar2;
        an anVar3;
        an anVar4;
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
        anVar = this.a.g;
        if (anVar != null) {
            anVar4 = this.a.g;
            anVar4.cancel();
        }
        VcodeActivity vcodeActivity4 = this.a;
        VcodeActivity vcodeActivity5 = this.a;
        writeData = this.a.b;
        vcodeActivity4.g = new an(vcodeActivity5, writeData);
        anVar2 = this.a.g;
        anVar2.setPriority(3);
        anVar3 = this.a.g;
        anVar3.execute(0);
    }
}
