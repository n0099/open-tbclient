package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements TextWatcher {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        str = this.fQG.fQw;
        if (!str.equals(charSequence.toString())) {
            this.fQG.fQx = i + i3;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        SpannableString fV;
        EditText editText;
        int i;
        EditText editText2;
        EditText editText3;
        int i2;
        str = this.fQG.fQw;
        if (!str.equals(editable.toString()) && (fV = com.baidu.tbadk.plugins.a.fV(editable.toString())) != null) {
            this.fQG.fQw = fV.toString();
            editText = this.fQG.fkw;
            editText.setText(fV);
            i = this.fQG.fQx;
            editText2 = this.fQG.fkw;
            if (i <= editText2.getText().length()) {
                editText3 = this.fQG.fkw;
                i2 = this.fQG.fQx;
                editText3.setSelection(i2);
            }
        }
    }
}
