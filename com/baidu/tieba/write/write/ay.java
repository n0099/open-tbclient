package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements TextWatcher {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        str = this.gpp.gpf;
        if (!str.equals(charSequence.toString())) {
            this.gpp.gpg = i + i3;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        SpannableString go;
        EditText editText;
        int i;
        EditText editText2;
        EditText editText3;
        int i2;
        str = this.gpp.gpf;
        if (!str.equals(editable.toString()) && (go = com.baidu.tbadk.plugins.a.go(editable.toString())) != null) {
            this.gpp.gpf = go.toString();
            editText = this.gpp.fsM;
            editText.setText(go);
            i = this.gpp.gpg;
            editText2 = this.gpp.fsM;
            if (i <= editText2.getText().length()) {
                editText3 = this.gpp.fsM;
                i2 = this.gpp.gpg;
                editText3.setSelection(i2);
            }
        }
    }
}
