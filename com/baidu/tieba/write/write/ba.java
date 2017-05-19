package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements TextWatcher {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        str = this.fSV.fSK;
        if (!str.equals(charSequence.toString())) {
            this.fSV.fSL = i + i3;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        SpannableString fY;
        EditText editText;
        int i;
        EditText editText2;
        EditText editText3;
        int i2;
        str = this.fSV.fSK;
        if (!str.equals(editable.toString()) && (fY = com.baidu.tbadk.plugins.a.fY(editable.toString())) != null) {
            this.fSV.fSK = fY.toString();
            editText = this.fSV.fkx;
            editText.setText(fY);
            i = this.fSV.fSL;
            editText2 = this.fSV.fkx;
            if (i <= editText2.getText().length()) {
                editText3 = this.fSV.fkx;
                i2 = this.fSV.fSL;
                editText3.setSelection(i2);
            }
        }
    }
}
