package com.baidu.tieba.write.write;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tieba.i;
import com.baidu.tieba.write.write.VcodeActivity;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ VcodeActivity doM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VcodeActivity vcodeActivity) {
        this.doM = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        DialogInterface.OnCancelListener onCancelListener;
        ProgressDialog progressDialog;
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        VcodeActivity.b bVar3;
        VcodeActivity.b bVar4;
        VcodeActivity vcodeActivity = this.doM;
        inputMethodManager = this.doM.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.doM.mEdit);
        VcodeActivity vcodeActivity2 = this.doM;
        Activity pageActivity = this.doM.getPageContext().getPageActivity();
        String string = this.doM.getPageContext().getString(i.h.sending);
        onCancelListener = this.doM.cpM;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.doM.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        bVar = this.doM.doK;
        if (bVar != null) {
            bVar4 = this.doM.doK;
            bVar4.cancel();
        }
        this.doM.doK = new VcodeActivity.b(this.doM.dow);
        bVar2 = this.doM.doK;
        bVar2.setPriority(3);
        bVar3 = this.doM.doK;
        bVar3.execute(0);
    }
}
