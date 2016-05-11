package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements TextWatcher {
    private int dMC;
    final /* synthetic */ WriteActivity feb;
    private EditText crz = null;
    private TextView Sm = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity) {
        this.feb = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.feb.bcj();
        z = this.feb.fdK;
        if (z) {
            this.dMC = this.crz.getSelectionStart();
            this.crz.setSelection(this.dMC);
            this.feb.b(this.Sm, this.crz);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        boolean z2;
        EditText editText;
        EditText editText2;
        TextView textView;
        TextView textView2;
        boolean z3;
        EditText editText3;
        EditText editText4;
        TextView textView3;
        TextView textView4;
        z = this.feb.fdK;
        if (z) {
            z3 = this.feb.fdL;
            if (z3) {
                EditText editText5 = this.crz;
                editText3 = this.feb.fdF;
                if (editText5 == editText3) {
                    TextView textView5 = this.Sm;
                    textView4 = this.feb.fdG;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.feb.fdF;
                this.crz = editText4;
                textView3 = this.feb.fdG;
                this.Sm = textView3;
                return;
            }
        }
        z2 = this.feb.fdK;
        if (z2) {
            EditText editText6 = this.crz;
            editText = this.feb.fdB;
            if (editText6 == editText) {
                TextView textView6 = this.Sm;
                textView2 = this.feb.fdH;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.feb.fdB;
            this.crz = editText2;
            textView = this.feb.fdH;
            this.Sm = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
