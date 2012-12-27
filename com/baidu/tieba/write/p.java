package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
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
        s sVar;
        com.baidu.tieba.b.u uVar;
        s sVar2;
        s sVar3;
        VcodeActivity vcodeActivity = this.a;
        inputMethodManager = this.a.j;
        editText = this.a.f;
        vcodeActivity.a(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.a;
        String string = this.a.getString(R.string.sending);
        onCancelListener = this.a.k;
        vcodeActivity2.a(string, onCancelListener);
        sVar = this.a.h;
        if (sVar != null) {
            sVar3 = this.a.h;
            sVar3.a();
        }
        VcodeActivity vcodeActivity3 = this.a;
        VcodeActivity vcodeActivity4 = this.a;
        uVar = this.a.b;
        vcodeActivity3.h = new s(vcodeActivity4, uVar);
        sVar2 = this.a.h;
        sVar2.execute(0);
    }
}
