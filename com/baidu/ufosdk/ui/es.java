package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
/* loaded from: classes22.dex */
final class es implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ er f3868a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public es(er erVar) {
        this.f3868a = erVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        editText = this.f3868a.j;
        String obj = editText.getText().toString();
        if (obj.length() > 200) {
            String substring = obj.substring(0, 200);
            editText2 = this.f3868a.j;
            editText2.setText(substring.substring(0, 200));
            editText3 = this.f3868a.j;
            editText3.setSelection(substring.length());
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
