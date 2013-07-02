package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.model.WriteModel;
import com.slidingmenu.lib.R;
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
        WriteModel writeModel;
        s sVar2;
        s sVar3;
        s sVar4;
        VcodeActivity vcodeActivity = this.a;
        inputMethodManager = this.a.k;
        editText = this.a.e;
        vcodeActivity.a(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.a;
        String string = this.a.getString(R.string.sending);
        onCancelListener = this.a.l;
        vcodeActivity2.a(string, onCancelListener);
        sVar = this.a.g;
        if (sVar != null) {
            sVar4 = this.a.g;
            sVar4.cancel();
        }
        VcodeActivity vcodeActivity3 = this.a;
        VcodeActivity vcodeActivity4 = this.a;
        writeModel = this.a.a;
        vcodeActivity3.g = new s(vcodeActivity4, writeModel);
        sVar2 = this.a.g;
        sVar2.setPriority(3);
        sVar3 = this.a.g;
        sVar3.execute(0);
    }
}
