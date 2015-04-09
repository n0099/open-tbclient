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
    final /* synthetic */ VcodeActivity cxP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(VcodeActivity vcodeActivity) {
        this.cxP = vcodeActivity;
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
        VcodeActivity vcodeActivity = this.cxP;
        inputMethodManager = this.cxP.mInputManager;
        editText = this.cxP.mEdit;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.cxP;
        Activity pageActivity = this.cxP.getPageContext().getPageActivity();
        String string = this.cxP.getPageContext().getString(com.baidu.tieba.y.sending);
        onCancelListener = this.cxP.ccP;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.cxP.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        agVar = this.cxP.cxN;
        if (agVar != null) {
            agVar4 = this.cxP.cxN;
            agVar4.cancel();
        }
        VcodeActivity vcodeActivity3 = this.cxP;
        VcodeActivity vcodeActivity4 = this.cxP;
        writeData = this.cxP.cxz;
        vcodeActivity3.cxN = new ag(vcodeActivity4, writeData);
        agVar2 = this.cxP.cxN;
        agVar2.setPriority(3);
        agVar3 = this.cxP.cxN;
        agVar3.execute(0);
    }
}
