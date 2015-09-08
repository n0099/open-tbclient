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
    final /* synthetic */ VcodeActivity dcU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VcodeActivity vcodeActivity) {
        this.dcU = vcodeActivity;
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
        VcodeActivity vcodeActivity = this.dcU;
        inputMethodManager = this.dcU.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.dcU.mEdit);
        VcodeActivity vcodeActivity2 = this.dcU;
        Activity pageActivity = this.dcU.getPageContext().getPageActivity();
        String string = this.dcU.getPageContext().getString(i.h.sending);
        onCancelListener = this.dcU.ckj;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.dcU.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        bVar = this.dcU.dcS;
        if (bVar != null) {
            bVar4 = this.dcU.dcS;
            bVar4.cancel();
        }
        this.dcU.dcS = new VcodeActivity.b(this.dcU.dcE);
        bVar2 = this.dcU.dcS;
        bVar2.setPriority(3);
        bVar3 = this.dcU.dcS;
        bVar3.execute(0);
    }
}
