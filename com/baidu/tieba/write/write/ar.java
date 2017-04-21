package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements TextWatcher {
    private int eOk;
    final /* synthetic */ WriteActivity fUM;
    private EditText dhM = null;
    private TextView mTextView = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.fUM.bfg();
        z = this.fUM.fUl;
        if (z) {
            this.eOk = this.dhM.getSelectionStart();
            this.dhM.setSelection(this.eOk);
            this.fUM.b(this.mTextView, this.dhM);
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
        z = this.fUM.fUl;
        if (z) {
            z3 = this.fUM.fUm;
            if (z3) {
                EditText editText5 = this.dhM;
                editText3 = this.fUM.fUg;
                if (editText5 == editText3) {
                    TextView textView5 = this.mTextView;
                    textView4 = this.fUM.fUh;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.fUM.fUg;
                this.dhM = editText4;
                textView3 = this.fUM.fUh;
                this.mTextView = textView3;
                return;
            }
        }
        z2 = this.fUM.fUl;
        if (z2) {
            EditText editText6 = this.dhM;
            editText = this.fUM.fUc;
            if (editText6 == editText) {
                TextView textView6 = this.mTextView;
                textView2 = this.fUM.fUi;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.fUM.fUc;
            this.dhM = editText2;
            textView = this.fUM.fUi;
            this.mTextView = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
