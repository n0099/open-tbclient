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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VcodeActivity f2715a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(VcodeActivity vcodeActivity) {
        this.f2715a = vcodeActivity;
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
        VcodeActivity vcodeActivity = this.f2715a;
        inputMethodManager = this.f2715a.j;
        editText = this.f2715a.f;
        vcodeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.f2715a;
        VcodeActivity vcodeActivity3 = this.f2715a;
        String string = this.f2715a.getString(R.string.sending);
        onCancelListener = this.f2715a.k;
        vcodeActivity2.mWaitingDialog = ProgressDialog.show(vcodeActivity3, "", string, true, false, onCancelListener);
        progressDialog = this.f2715a.mWaitingDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        sVar = this.f2715a.h;
        if (sVar != null) {
            sVar4 = this.f2715a.h;
            sVar4.cancel();
        }
        VcodeActivity vcodeActivity4 = this.f2715a;
        VcodeActivity vcodeActivity5 = this.f2715a;
        writeData = this.f2715a.b;
        vcodeActivity4.h = new s(vcodeActivity5, writeData);
        sVar2 = this.f2715a.h;
        sVar2.setPriority(3);
        sVar3 = this.f2715a.h;
        sVar3.execute(0);
    }
}
