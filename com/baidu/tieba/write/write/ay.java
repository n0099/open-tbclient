package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements TextWatcher {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        str = this.glP.glE;
        if (!str.equals(charSequence.toString())) {
            this.glP.glF = i + i3;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        SpannableString gs;
        EditText editText;
        int i;
        EditText editText2;
        EditText editText3;
        int i2;
        str = this.glP.glE;
        if (!str.equals(editable.toString()) && (gs = com.baidu.tbadk.plugins.a.gs(editable.toString())) != null) {
            this.glP.glE = gs.toString();
            editText = this.glP.fCz;
            editText.setText(gs);
            i = this.glP.glF;
            editText2 = this.glP.fCz;
            if (i <= editText2.getText().length()) {
                editText3 = this.glP.fCz;
                i2 = this.glP.glF;
                editText3.setSelection(i2);
            }
        }
    }
}
