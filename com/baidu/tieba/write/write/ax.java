package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements TextWatcher {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity) {
        this.fMl = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        str = this.fMl.fMb;
        if (!str.equals(charSequence.toString())) {
            this.fMl.fMc = i + i3;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        SpannableString gg;
        EditText editText;
        int i;
        EditText editText2;
        EditText editText3;
        int i2;
        str = this.fMl.fMb;
        if (!str.equals(editable.toString()) && (gg = com.baidu.tbadk.plugins.a.gg(editable.toString())) != null) {
            this.fMl.fMb = gg.toString();
            editText = this.fMl.ffZ;
            editText.setText(gg);
            i = this.fMl.fMc;
            editText2 = this.fMl.ffZ;
            if (i <= editText2.getText().length()) {
                editText3 = this.fMl.ffZ;
                i2 = this.fMl.fMc;
                editText3.setSelection(i2);
            }
        }
    }
}
