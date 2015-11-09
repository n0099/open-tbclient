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
    final /* synthetic */ VcodeActivity drb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VcodeActivity vcodeActivity) {
        this.drb = vcodeActivity;
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
        VcodeActivity vcodeActivity = this.drb;
        inputMethodManager = this.drb.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.drb.mEdit);
        VcodeActivity vcodeActivity2 = this.drb;
        Activity pageActivity = this.drb.getPageContext().getPageActivity();
        String string = this.drb.getPageContext().getString(i.h.sending);
        onCancelListener = this.drb.crt;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.drb.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        bVar = this.drb.dqZ;
        if (bVar != null) {
            bVar4 = this.drb.dqZ;
            bVar4.cancel();
        }
        this.drb.dqZ = new VcodeActivity.b(this.drb.dqL);
        bVar2 = this.drb.dqZ;
        bVar2.setPriority(3);
        bVar3 = this.drb.dqZ;
        bVar3.execute(0);
    }
}
