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
    final /* synthetic */ VcodeActivity dpn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VcodeActivity vcodeActivity) {
        this.dpn = vcodeActivity;
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
        VcodeActivity vcodeActivity = this.dpn;
        inputMethodManager = this.dpn.mInputManager;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, this.dpn.mEdit);
        VcodeActivity vcodeActivity2 = this.dpn;
        Activity pageActivity = this.dpn.getPageContext().getPageActivity();
        String string = this.dpn.getPageContext().getString(i.h.sending);
        onCancelListener = this.dpn.cpX;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(pageActivity, "", string, true, false, onCancelListener);
        progressDialog = this.dpn.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        bVar = this.dpn.dpl;
        if (bVar != null) {
            bVar4 = this.dpn.dpl;
            bVar4.cancel();
        }
        this.dpn.dpl = new VcodeActivity.b(this.dpn.doW);
        bVar2 = this.dpn.dpl;
        bVar2.setPriority(3);
        bVar3 = this.dpn.dpl;
        bVar3.execute(0);
    }
}
