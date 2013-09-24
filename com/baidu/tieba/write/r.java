package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VcodeActivity f2125a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(VcodeActivity vcodeActivity) {
        this.f2125a = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        DialogInterface.OnCancelListener onCancelListener;
        u uVar;
        WriteData writeData;
        u uVar2;
        u uVar3;
        u uVar4;
        VcodeActivity vcodeActivity = this.f2125a;
        inputMethodManager = this.f2125a.k;
        editText = this.f2125a.e;
        vcodeActivity.a(inputMethodManager, editText);
        VcodeActivity vcodeActivity2 = this.f2125a;
        String string = this.f2125a.getString(R.string.sending);
        onCancelListener = this.f2125a.l;
        vcodeActivity2.a(string, onCancelListener);
        uVar = this.f2125a.g;
        if (uVar != null) {
            uVar4 = this.f2125a.g;
            uVar4.cancel();
        }
        VcodeActivity vcodeActivity3 = this.f2125a;
        VcodeActivity vcodeActivity4 = this.f2125a;
        writeData = this.f2125a.f2074a;
        vcodeActivity3.g = new u(vcodeActivity4, writeData);
        uVar2 = this.f2125a.g;
        uVar2.setPriority(3);
        uVar3 = this.f2125a.g;
        uVar3.execute(0);
    }
}
