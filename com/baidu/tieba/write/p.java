package com.baidu.tieba.write;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ VcodeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(VcodeActivity vcodeActivity) {
        this.a = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        DialogInterface.OnCancelListener onCancelListener;
        ProgressDialog progressDialog;
        s sVar;
        WriteData writeData;
        s sVar2;
        s sVar3;
        s sVar4;
        VcodeActivity vcodeActivity = this.a;
        inputMethodManager = this.a.j;
        editText = this.a.f;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.a;
        VcodeActivity vcodeActivity3 = this.a;
        String string = this.a.getString(R.string.sending);
        onCancelListener = this.a.k;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(vcodeActivity3, "", string, true, false, onCancelListener);
        progressDialog = this.a.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        sVar = this.a.h;
        if (sVar != null) {
            sVar4 = this.a.h;
            sVar4.cancel();
        }
        VcodeActivity vcodeActivity4 = this.a;
        VcodeActivity vcodeActivity5 = this.a;
        writeData = this.a.b;
        vcodeActivity4.h = new s(vcodeActivity5, writeData);
        sVar2 = this.a.h;
        sVar2.setPriority(3);
        sVar3 = this.a.h;
        sVar3.execute(0);
    }
}
