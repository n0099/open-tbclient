package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements TextWatcher {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        str = this.fSq.fSg;
        if (!str.equals(charSequence.toString())) {
            this.fSq.fSh = i + i3;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        SpannableString gb;
        EditText editText;
        int i;
        EditText editText2;
        EditText editText3;
        int i2;
        str = this.fSq.fSg;
        if (!str.equals(editable.toString()) && (gb = com.baidu.tbadk.plugins.a.gb(editable.toString())) != null) {
            this.fSq.fSg = gb.toString();
            editText = this.fSq.fme;
            editText.setText(gb);
            i = this.fSq.fSh;
            editText2 = this.fSq.fme;
            if (i <= editText2.getText().length()) {
                editText3 = this.fSq.fme;
                i2 = this.fSq.fSh;
                editText3.setSelection(i2);
            }
        }
    }
}
