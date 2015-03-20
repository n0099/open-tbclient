package com.baidu.tieba.write.write;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ VcodeActivity cxw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(VcodeActivity vcodeActivity) {
        this.cxw = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        DialogInterface.OnCancelListener onCancelListener;
        ProgressDialog progressDialog;
        ag agVar;
        WriteData writeData;
        ag agVar2;
        ag agVar3;
        ag agVar4;
        VcodeActivity vcodeActivity = this.cxw;
        inputMethodManager = this.cxw.mInputManager;
        editText = this.cxw.mEdit;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.cxw;
        Activity pageActivity = this.cxw.getPageContext().getPageActivity();
        String string = this.cxw.getPageContext().getString(com.baidu.tieba.y.sending);
        onCancelListener = this.cxw.ccA;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.cxw.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        agVar = this.cxw.cxu;
        if (agVar != null) {
            agVar4 = this.cxw.cxu;
            agVar4.cancel();
        }
        VcodeActivity vcodeActivity3 = this.cxw;
        VcodeActivity vcodeActivity4 = this.cxw;
        writeData = this.cxw.cxg;
        vcodeActivity3.cxu = new ag(vcodeActivity4, writeData);
        agVar2 = this.cxw.cxu;
        agVar2.setPriority(3);
        agVar3 = this.cxw.cxu;
        agVar3.execute(0);
    }
}
