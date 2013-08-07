package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VcodeActivity f1909a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(VcodeActivity vcodeActivity) {
        this.f1909a = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        DialogInterface.OnCancelListener onCancelListener;
        s sVar;
        WriteData writeData;
        s sVar2;
        s sVar3;
        s sVar4;
        VcodeActivity vcodeActivity = this.f1909a;
        inputMethodManager = this.f1909a.k;
        editText = this.f1909a.e;
        vcodeActivity.a(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.f1909a;
        String string = this.f1909a.getString(R.string.sending);
        onCancelListener = this.f1909a.l;
        vcodeActivity2.a(string, onCancelListener);
        sVar = this.f1909a.g;
        if (sVar != null) {
            sVar4 = this.f1909a.g;
            sVar4.cancel();
        }
        VcodeActivity vcodeActivity3 = this.f1909a;
        VcodeActivity vcodeActivity4 = this.f1909a;
        writeData = this.f1909a.f1865a;
        vcodeActivity3.g = new s(vcodeActivity4, writeData);
        sVar2 = this.f1909a.g;
        sVar2.setPriority(3);
        sVar3 = this.f1909a.g;
        sVar3.execute(0);
    }
}
