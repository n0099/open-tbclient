package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements TextWatcher {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        str = this.gaR.gaG;
        if (!str.equals(charSequence.toString())) {
            this.gaR.gaH = i + i3;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        SpannableString fX;
        EditText editText;
        int i;
        EditText editText2;
        EditText editText3;
        int i2;
        str = this.gaR.gaG;
        if (!str.equals(editable.toString()) && (fX = com.baidu.tbadk.plugins.a.fX(editable.toString())) != null) {
            this.gaR.gaG = fX.toString();
            editText = this.gaR.fsp;
            editText.setText(fX);
            i = this.gaR.gaH;
            editText2 = this.gaR.fsp;
            if (i <= editText2.getText().length()) {
                editText3 = this.gaR.fsp;
                i2 = this.gaR.gaH;
                editText3.setSelection(i2);
            }
        }
    }
}
