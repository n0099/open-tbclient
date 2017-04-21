package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements TextWatcher {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        str = this.fUM.fUC;
        if (!str.equals(charSequence.toString())) {
            this.fUM.fUD = i + i3;
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
        str = this.fUM.fUC;
        if (!str.equals(editable.toString()) && (gb = com.baidu.tbadk.plugins.a.gb(editable.toString())) != null) {
            this.fUM.fUC = gb.toString();
            editText = this.fUM.fow;
            editText.setText(gb);
            i = this.fUM.fUD;
            editText2 = this.fUM.fow;
            if (i <= editText2.getText().length()) {
                editText3 = this.fUM.fow;
                i2 = this.fUM.fUD;
                editText3.setSelection(i2);
            }
        }
    }
}
