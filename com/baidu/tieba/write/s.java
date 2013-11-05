package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VcodeActivity f2670a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(VcodeActivity vcodeActivity) {
        this.f2670a = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        DialogInterface.OnCancelListener onCancelListener;
        v vVar;
        WriteData writeData;
        v vVar2;
        v vVar3;
        v vVar4;
        VcodeActivity vcodeActivity = this.f2670a;
        inputMethodManager = this.f2670a.k;
        editText = this.f2670a.e;
        vcodeActivity.a(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.f2670a;
        String string = this.f2670a.getString(R.string.sending);
        onCancelListener = this.f2670a.l;
        vcodeActivity2.a(string, onCancelListener);
        vVar = this.f2670a.g;
        if (vVar != null) {
            vVar4 = this.f2670a.g;
            vVar4.cancel();
        }
        VcodeActivity vcodeActivity3 = this.f2670a;
        VcodeActivity vcodeActivity4 = this.f2670a;
        writeData = this.f2670a.f2618a;
        vcodeActivity3.g = new v(vcodeActivity4, writeData);
        vVar2 = this.f2670a.g;
        vVar2.setPriority(3);
        vVar3 = this.f2670a.g;
        vVar3.execute(0);
    }
}
