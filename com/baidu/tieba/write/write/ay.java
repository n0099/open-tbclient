package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements TextWatcher {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        str = this.fDQ.fDG;
        if (!str.equals(charSequence.toString())) {
            this.fDQ.fDH = i + i3;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        SpannableString gj;
        EditText editText;
        int i;
        EditText editText2;
        EditText editText3;
        int i2;
        str = this.fDQ.fDG;
        if (!str.equals(editable.toString()) && (gj = com.baidu.tbadk.plugins.a.gj(editable.toString())) != null) {
            this.fDQ.fDG = gj.toString();
            editText = this.fDQ.eWF;
            editText.setText(gj);
            i = this.fDQ.fDH;
            editText2 = this.fDQ.eWF;
            if (i <= editText2.getText().length()) {
                editText3 = this.fDQ.eWF;
                i2 = this.fDQ.fDH;
                editText3.setSelection(i2);
            }
        }
    }
}
